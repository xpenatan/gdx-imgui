package com.github.xpenatan.imgui.generate;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import com.badlogic.gdx.jnigen.AntScriptGenerator;
import com.badlogic.gdx.jnigen.BuildConfig;
import com.badlogic.gdx.jnigen.BuildExecutor;
import com.badlogic.gdx.jnigen.BuildTarget;
import com.badlogic.gdx.jnigen.FileDescriptor;
import com.badlogic.gdx.jnigen.NativeCodeGenerator;
import com.badlogic.gdx.jnigen.BuildTarget.TargetOs;

public class Build {


	public static void main(String[] args) throws Exception {
		boolean debug = false;

		String path = new File(Build.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getAbsolutePath();

		String toReplace = "build" +  File.separator + "classes"+  File.separator + "java" + File.separator + "main";
		System.out.println("path: " + path);
		System.out.println("path toReplace: " + toReplace);
		path = path.replace(File.separator + "bin", "").replace(toReplace, "");

		BuildTarget win64 = BuildTarget.newDefaultTarget(TargetOs.Windows, true);

		String[] header = {"src"};
		String[] includes = {"**/*.cpp"} ;
		win64.cppIncludes = includes;
		win64.headerDirs = header;
//		win64.cppFlags =  "-c -Wno-unused -O0 -mfpmath=sse -msse2 -fmessage-length=0 -m64";
		if(debug)
			win64.cppFlags +=  " -g";

		String libName = "imgui";

		BuildConfig buildConfig = new BuildConfig(libName, "target", "libs", "jni");

		BuildTarget lin64 = BuildTarget.newDefaultTarget(TargetOs.Linux, true);
		lin64.linkerFlags = "-v -shared -m64 -Wl,-wrap,memcpy";

		BuildTarget mac64 = BuildTarget.newDefaultTarget(TargetOs.MacOsX, true);
		// for some weird reason adding -v stop getting errors with github actions
		mac64.linkerFlags = "-v -shared -arch x86_64 -mmacosx-version-min=10.7 -stdlib=libc++";

		File from = new File(path + "/../extensions/imgui-layout-widget/");
		File dest = new File(path + "/jni/src");

		System.out.println("imgui - path: " + path);
		System.out.println("imgui - from: " + from);
		System.out.println("imgui - dest: " + dest);

		String exclude = "imgui_layout_widget_tests";
		copyDir(from.toPath(), dest.toPath(), exclude);

		String classpathStr = System.getProperty("java.class.path");
		System.out.println("classpath: " + classpathStr);

		new NativeCodeGenerator().generate("src/main/java",classpathStr + File.pathSeparator, path + "/jni");

		new AntScriptGenerator().generate(buildConfig, win64, lin64, mac64);

//		BuildExecutor.executeAnt("jni/build-windows64.xml", "-v", "-Dhas-compiler=true", "clean", "postcompile");
//		BuildExecutor.executeAnt("jni/build-linux64.xml", "-v", "-Dhas-compiler=true", "clean", "postcompile");
//		BuildExecutor.executeAnt("jni/build-macosx64.xml", "-v", "-Dhas-compiler=true");
//		BuildExecutor.executeAnt("jni/build.xml", "-v", "pack-natives");
	}

	public static void copyDir(Path src, Path dest, String... excludes) throws IOException {
		Files.walk(src).forEach(source -> {
			try {
				boolean skip = false;
				if(excludes != null) {
					String fileStr = source.getFileName().toString();
					for(int i = 0; i < excludes.length; i++) {
						String excludeFile = excludes[i];
						if(fileStr.contains(excludeFile)) {
							skip = true;
							break;
						}
					}
				}
				if(!skip)
					Files.copy(source, dest.resolve(src.relativize(source)), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
			}
		});

	}
}
