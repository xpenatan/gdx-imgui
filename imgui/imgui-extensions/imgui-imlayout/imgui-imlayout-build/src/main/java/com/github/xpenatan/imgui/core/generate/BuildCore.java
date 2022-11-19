package com.github.xpenatan.imgui.core.generate;

import com.github.xpenatan.jparser.core.JParser;
import com.github.xpenatan.jparser.cpp.CPPBuildHelper;
import java.io.File;

public class BuildCore {

    public static void main(String[] args) throws Exception {
        String libName = "imlayout";

        String classpathStr = System.getProperty("java.class.path") + File.pathSeparator;

        String cppPath = new File("../imgui-imlayout/").getCanonicalPath();

        String jniDir = cppPath + "/jni";
        String sourceDir = "../imgui-imlayout-base/src/main/java/";
        String cppGenDir = cppPath + "/src/main/java/";
        String imguiCppBase = new File("../../imgui-cpp/imgui-cpp").getCanonicalPath();

        //Generate CPP
        ImGuiCppParser cppParser = new ImGuiCppParser(classpathStr, jniDir);
        JParser.generate(cppParser, sourceDir, cppGenDir);
//        CPPBuildHelper.DEBUG_BUILD = true;
        CPPBuildHelper.build(libName, cppPath, imguiCppBase, "imgui-cpp64");
    }
}