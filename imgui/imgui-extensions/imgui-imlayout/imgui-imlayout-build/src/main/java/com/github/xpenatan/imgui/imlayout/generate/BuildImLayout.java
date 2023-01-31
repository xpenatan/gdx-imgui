package com.github.xpenatan.imgui.imlayout.generate;

import com.github.xpenatan.imgui.core.generate.ImGuiCppParser;
import com.github.xpenatan.jparser.core.JParser;
import com.github.xpenatan.jparser.cpp.CPPBuildHelper;
import com.github.xpenatan.jparser.cpp.FileCopyHelper;
import java.io.File;

public class BuildImLayout {

    public static void main(String[] args) throws Exception {
        String libName = "imlayout";

        String cppPath = new File("../imgui-imlayout-base/").getCanonicalPath();
        String genDir = new File("../imgui-imlayout/").getCanonicalPath();

        String genJavaDir = genDir + "/src/main/java/";
        String jniDir = genDir + "/build/c++/";
        String sourceDir = "../imgui-imlayout-base/src/main/java/";
        String sharedlibCppPath = new File("../../../imgui-cpp/imgui-cpp/build/c++/").getCanonicalPath();

        FileCopyHelper.copyDir(cppPath + "/cpp-source", jniDir);

        //Generate CPP
        ImGuiCppParser cppParser = new ImGuiCppParser(ImGuiCppParser.getClassPath("imlayout", "core", "gdx-1", "gdx-jnigen-loader", "jParser"), jniDir);
        JParser.generate(cppParser, sourceDir, genJavaDir);
        CPPBuildHelper.build(libName, jniDir, "libs", null, sharedlibCppPath, "/src/", "imgui-cpp64", false);
    }
}