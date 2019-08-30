package com.github.xpenatan.imgui.generate;

import java.io.File;
import java.net.URLDecoder;

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

		String path = Build.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		path = URLDecoder.decode(path, "UTF-8" ).replace("bin/", "");

//		BuildTarget win32 = BuildTarget.newDefaultTarget(TargetOs.Windows, false);
		BuildTarget win64 = BuildTarget.newDefaultTarget(TargetOs.Windows, true);

		String[] header = {"src"};
		String[] includes = {"**/*.cpp"};

		win64.cppIncludes = includes;
		win64.headerDirs = header;
		win64.cppFlags =  "-c -Wall -O0 -mfpmath=sse -msse2 -fmessage-length=0 -m64";
		if(debug)
			win64.cppFlags +=  " -g";

//		BuildTarget lin32 = BuildTarget.newDefaultTarget(TargetOs.Linux, false);
//		BuildTarget lin64 = BuildTarget.newDefaultTarget(TargetOs.Linux, false);
//		BuildTarget android = BuildTarget.newDefaultTarget(TargetOs.Android, false);
//		BuildTarget mac64 = BuildTarget.newDefaultTarget(TargetOs.MacOsX, false);
//		BuildTarget ios = BuildTarget.newDefaultTarget(TargetOs.IOS, false);
		new NativeCodeGenerator().generate("src/main/java", "bin" + File.pathSeparator, "jni");
//		new AntScriptGenerator().generate(new BuildConfig("gdx-imgui"), win32, win64, lin32, lin64, mac64, android, ios);
		new AntScriptGenerator().generate(new BuildConfig("gdx-imgui", "target", "libs", "jni"), win64);

		BuildExecutor.executeAnt("jni/build-windows64.xml", "-v -Dhas-compiler=true clean postcompile");

		BuildExecutor.executeAnt("jni/build.xml", "-v pack-natives");
	}
}
