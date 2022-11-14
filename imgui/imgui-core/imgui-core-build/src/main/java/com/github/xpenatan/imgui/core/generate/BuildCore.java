package com.github.xpenatan.imgui.core.generate;

import com.github.xpenatan.jparser.core.JParser;
import com.github.xpenatan.jparser.core.idl.IDLFile;
import com.github.xpenatan.jparser.core.idl.IDLParser;
import com.github.xpenatan.jparser.cpp.CPPBuildHelper;
import java.io.File;

public class BuildCore {

    public static void main(String[] args) throws Exception {
        String path = "..\\imgui-core-build\\src\\main\\resources\\imgui.idl";
        IDLFile idlFile = IDLParser.parseFile(path);

        String classpathStr = System.getProperty("java.class.path") + File.pathSeparator;
        String jniDir = "../imgui-core-cpp/jni";
        String sourceDir = "../imgui-core-base/src/main/java/";
        String genDir = "../imgui-core-cpp/src/main/java/";

        ImGuiCppParser parser = new ImGuiCppParser(idlFile, classpathStr, jniDir);

        JParser.generate(parser, sourceDir, genDir, null);

        String imguiCppBase = new File("../../../imgui-cpp").getCanonicalPath();
        String projectPath = new File("../imgui-core-cpp/").getCanonicalPath();

        CPPBuildHelper.build("imgui", projectPath, imguiCppBase, "imgui-cpp64");
    }
}