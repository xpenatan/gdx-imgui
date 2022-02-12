package com.github.xpenatan.imgui.generate;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import com.badlogic.gdx.jnigen.AntScriptGenerator;
import com.badlogic.gdx.jnigen.BuildConfig;
import com.badlogic.gdx.jnigen.BuildExecutor;
import com.badlogic.gdx.jnigen.BuildTarget;
import com.badlogic.gdx.jnigen.BuildTarget.TargetOs;

public class BuildCPP {

	public static boolean DEBUG_BUILD = false;

	public static void main(String[] args) throws Exception {
		String libName = "imgui-cpp";

		String projectPath = new File(BuildCPP.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getAbsolutePath();
		String toReplace = "build" +  File.separator + "classes"+  File.separator + "java" + File.separator + "main";
		projectPath = projectPath.replace(File.separator + "bin", "").replace(toReplace, "");

		String[] headerDir = {"src"};
		String[] includes = {"**/*.cpp"} ;

		BuildConfig buildConfig = new BuildConfig(libName, "target", "libs", "jni");

		File from = new File(projectPath + "/cpp-source/");
		File dest = new File(projectPath + "/jni/src");

		System.out.println("imguiCPP - path: " + projectPath);
		System.out.println("imgui - path: " + projectPath);
		System.out.println("imgui - from: " + from);
		System.out.println("imgui - dest: " + dest);

		BuildCPP.copyDir(from.toPath(), dest.toPath());

		String classpathStr = System.getProperty("java.class.path");
		System.out.println("classpath: " + classpathStr);

		new AntScriptGenerator().generate(buildConfig,
				genWindows(projectPath, headerDir, includes),
				genLinux(projectPath, headerDir, includes),
				genMac(projectPath, headerDir, includes));

		if(isWindows() || isUnix()) {
			if(!BuildExecutor.executeAnt("jni/build-windows64.xml", "-v", "-Dhas-compiler=true", "clean", "postcompile"))
				throw new RuntimeException();
		}
		if(isUnix()) {
			if(!BuildExecutor.executeAnt("jni/build-linux64.xml", "-v", "-Dhas-compiler=true", "clean", "postcompile"))
				throw new RuntimeException();
		}
		if(isMac()) {
			if(!BuildExecutor.executeAnt("jni/build-macosx64.xml", "-v", "-Dhas-compiler=true"))
				throw new RuntimeException();
		}
		if(!BuildExecutor.executeAnt("jni/build.xml", "pack-natives"))
			throw new RuntimeException();
	}

	private static BuildTarget genWindows(String projectPath, String[] headerDir, String[] includes) {
		BuildTarget win64 = BuildTarget.newDefaultTarget(TargetOs.Windows, true);
		win64.cppIncludes = includes;
		win64.headerDirs = headerDir;
		win64.cppFlags += " -std=c++11";
		if(BuildCPP.DEBUG_BUILD)
			win64.cppFlags = "-c -Wall -O0 -mfpmath=sse -msse2 -fmessage-length=0 -m64 -g";
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

		if(Files.exists(src)) {
			Files.walkFileTree(src, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile (Path path, BasicFileAttributes basicFileAttributes) throws IOException {
					boolean skip = false;
					if(excludes != null) {
						String fileStr = path.getFileName().toString();
						for(int i = 0; i < excludes.length; i++) {
							String excludeFile = excludes[i];
							if(fileStr.contains(excludeFile)) {
								skip = true;
								break;
							}
						}
					}
					if(!skip) {
						File file = path.toFile();
						String name = file.getName();
						Path newDest = dest.resolve(name);
						Files.copy(path, newDest, StandardCopyOption.REPLACE_EXISTING);
					}
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult postVisitDirectory (Path directory, IOException ioException) throws IOException {
					return FileVisitResult.CONTINUE;
				}
			});
		}
	}

	public static void copy (Path src, Path dest) throws IOException {


	}

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static boolean isWindows() {
		return OS.contains("win");
	}

	public static boolean isMac() {
		return OS.contains("mac");
	}

	public static boolean isUnix() {
		return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
	}
}
