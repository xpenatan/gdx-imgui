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
        String genDir = "../imgui-imlayout/";
        String genLibsDir = new File(genDir + "/libs").getCanonicalPath();

        String genJavaDir = genDir + "/src/main/java/";
        String jniDir = cppPath + "/jni";
        String sourceDir = "../imgui-imlayout-base/src/main/java/";
        String sharedlibCppPath = new File("../../../imgui-cpp/imgui-cpp/jni").getCanonicalPath();

        FileCopyHelper.copyDir(cppPath + "/cpp-source", jniDir);

        //Generate CPP
        ImGuiCppParser cppParser = new ImGuiCppParser(ImGuiCppParser.getClassPath("imlayout", "core", "gdx-1", "gdx-jnigen-loader", "jParser"), jniDir);
        JParser.generate(cppParser, sourceDir, genJavaDir);
        CPPBuildHelper.build(libName, jniDir, genLibsDir, null, sharedlibCppPath, "/src/", "imgui-cpp64", false);
    }
}