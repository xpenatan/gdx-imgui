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
//		System.out.println(System.getenv("HOME"));
//		if(true)
//			return;

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

		BuildConfig buildConfig = new BuildConfig("gdx-imgui", "target", "libs", "jni");

		BuildTarget lin64 = BuildTarget.newDefaultTarget(TargetOs.Linux, true);
		lin64.linkerFlags = "-shared -m64 -Wl";

		BuildTarget mac64 = BuildTarget.newDefaultTarget(TargetOs.MacOsX, true);
		mac64.linkerFlags = "-shared -arch x86_64 -mmacosx-version-min=10.7 -stdlib=libstdc++";

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
		new AntScriptGenerator().generate(buildConfig, lin64, win64, mac64);

//		BuildExecutor.executeAnt("jni/build-windows64.xml", "-v", "-Dhas-compiler=true", "clean", "postcompile");
//		BuildExecutor.executeAnt("jni/build-linux64.xml", "-v", "-Dhas-compiler=true", "clean", "postcompile");
//		BuildExecutor.executeAnt("jni/build-macosx64.xml", "-v", "-Dhas-compiler=true", "clean", "postcompile");

//		BuildExecutor.executeAnt("jni/build.xml", "-v", "pack-natives");

//		BuildExecutor.executeAnt("jni/build.xml", "-v", "-Dhas-compiler=true");
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
