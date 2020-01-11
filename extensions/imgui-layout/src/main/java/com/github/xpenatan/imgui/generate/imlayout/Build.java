package com.github.xpenatan.imgui.generate.imlayout;

import com.badlogic.gdx.jnigen.*;
import com.badlogic.gdx.jnigen.BuildTarget.TargetOs;
import com.github.xpenatan.imgui.generate.BuildCPP;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Build {
	public static void main(String[] args) throws Exception {
		String libName = "imgui-layout";

		String projectPath = new File(Build.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getAbsolutePath();
		String toReplace = "build" +  File.separator + "classes"+  File.separator + "java" + File.separator + "main";
		projectPath = projectPath.replace(File.separator + "bin", "").replace(toReplace, "");


		String imguiCPPProject = projectPath + "../../imgui-cpp";

		String[] headerDir = {"src", imguiCPPProject + "/jni/src"};
		String[] includes = {"**/*.cpp"} ;

		BuildConfig buildConfig = new BuildConfig(libName, "target", "libs", "jni");

		File from = new File(projectPath + "/cpp-source/");
		File dest = new File(projectPath + "/jni/src");

		System.out.println("imguiCPP - path: " + imguiCPPProject);
		System.out.println("imgui - path: " + projectPath);
		System.out.println("imgui - from: " + from);
		System.out.println("imgui - dest: " + dest);

		String exclude = "imgui_layout_widget_tests";
		BuildCPP.copyDir(from.toPath(), dest.toPath(), exclude);

		String classpathStr = System.getProperty("java.class.path");
		System.out.println("classpath: " + classpathStr);

		new NativeCodeGenerator().generate("src/main/java",classpathStr + File.pathSeparator, projectPath + "jni");
		new AntScriptGenerator().generate(buildConfig,
				genWindows(projectPath, headerDir, includes),
				genLinux(projectPath, headerDir, includes),
				genMac(projectPath, headerDir, includes));

//		BuildExecutor.executeAnt("jni/build-windows64.xml", "-v", "-Dhas-compiler=true", "postcompile");
//		BuildExecutor.executeAnt("jni/build-linux64.xml", "-v", "-Dhas-compiler=true", "postcompile");
//		BuildExecutor.executeAnt("jni/build-macosx64.xml", "-v", "-Dhas-compiler=true");
//		BuildExecutor.executeAnt("jni/build.xml", "-v", "pack-natives");
	}


	private static BuildTarget genWindows(String projectPath, String[] headerDir, String[] includes) {
		String libFolder = projectPath + "libs/windows64";

		BuildTarget win64 = BuildTarget.newDefaultTarget(TargetOs.Windows, true);

		win64.cppIncludes = includes;
		win64.headerDirs = headerDir;
		win64.linkerFlags =  "-Wl,--kill-at -shared -static-libgcc -static-libstdc++ -m64";
		win64.libraries = "-L" + libFolder + " -limgui-cpp64";
		return win64;
	}

	private static BuildTarget genLinux(String projectPath, String[] headerDir, String[] includes) {
		String libFolder = projectPath + "libs/linux64";

		BuildTarget lin64 = BuildTarget.newDefaultTarget(TargetOs.Linux, true);
		lin64.cppIncludes = includes;
		lin64.headerDirs = headerDir;
		lin64.libraries = "-L" + libFolder + " -limgui-cpp64";
		return lin64;
	}

	private static BuildTarget genMac(String projectPath, String[] headerDir, String[] includes) {
		String libFolder = projectPath + "libs/macosx64";

		BuildTarget mac64 = BuildTarget.newDefaultTarget(TargetOs.MacOsX, true);
		mac64.cppIncludes = includes;
		mac64.headerDirs = headerDir;
		// for some weird reason adding -v stop getting errors with github actions
		mac64.linkerFlags = "-v -shared -arch x86_64 -mmacosx-version-min=10.7 -stdlib=libc++";
		mac64.libraries = "-L" + libFolder + " -limgui-cpp64";
		return mac64;
	}
}
