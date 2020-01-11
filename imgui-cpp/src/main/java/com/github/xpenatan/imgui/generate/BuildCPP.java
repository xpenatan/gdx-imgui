package com.github.xpenatan.imgui.generate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import com.badlogic.gdx.jnigen.AntScriptGenerator;
import com.badlogic.gdx.jnigen.BuildConfig;
import com.badlogic.gdx.jnigen.BuildExecutor;
import com.badlogic.gdx.jnigen.BuildTarget;
import com.badlogic.gdx.jnigen.BuildTarget.TargetOs;

public class BuildCPP {
	public static void main(String[] args) throws Exception {
		String libName = "imgui-cpp";

		String projectPath = new File(BuildCPP.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getAbsolutePath();
		String toReplace = "build" +  File.separator + "classes"+  File.separator + "java" + File.separator + "main";
		projectPath = projectPath.replace(File.separator + "bin", "").replace(toReplace, "");

		String[] headerDir = {"src"};
		String[] includes = {"**/*.cpp"} ;

		BuildConfig buildConfig = new BuildConfig(libName, "target", "libs", "jni");

		String classpathStr = System.getProperty("java.class.path");
		System.out.println("classpath: " + classpathStr);

		new AntScriptGenerator().generate(buildConfig,
				genWindows(projectPath, headerDir, includes),
				genLinux(projectPath, headerDir, includes),
				genMac(projectPath, headerDir, includes));

//		BuildExecutor.executeAnt("jni/build-windows64.xml", "-v", "-Dhas-compiler=true", "clean", "postcompile");
//		BuildExecutor.executeAnt("jni/build-linux64.xml", "-v", "-Dhas-compiler=true", "clean", "postcompile");
//		BuildExecutor.executeAnt("jni/build-macosx64.xml", "-v", "-Dhas-compiler=true");
	}

	private static BuildTarget genWindows(String projectPath, String[] headerDir, String[] includes) {
		BuildTarget win64 = BuildTarget.newDefaultTarget(TargetOs.Windows, true);
		win64.cppIncludes = includes;
		win64.headerDirs = headerDir;
		return win64;
	}

	private static BuildTarget genLinux(String projectPath, String[] headerDir, String[] includes) {
		BuildTarget lin64 = BuildTarget.newDefaultTarget(TargetOs.Linux, true);
		lin64.cppIncludes = includes;
		lin64.headerDirs = headerDir;
		return lin64;
	}

	private static BuildTarget genMac(String projectPath, String[] headerDir, String[] includes) {
		BuildTarget mac64 = BuildTarget.newDefaultTarget(TargetOs.MacOsX, true);
		mac64.cppIncludes = includes;
		mac64.headerDirs = headerDir;
		// for some weird reason adding -v stop getting errors with github actions
		mac64.linkerFlags = "-v -shared -arch x86_64 -mmacosx-version-min=10.7 -stdlib=libc++";
		return mac64;
	}

	public static void copyDir(Path src, Path dest, String... excludes) throws IOException {
		File directory = dest.toFile();
		if (!directory.exists())
			directory.mkdirs();
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
				e.printStackTrace();
			}
		});

	}
}
