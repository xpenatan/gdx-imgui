package com.github.xpenatan.imgui.extension.nodeeditor.generate;

import com.github.xpenatan.imgui.core.generate.ImGuiCppParser;
import com.github.xpenatan.jparser.core.JParser;
import com.github.xpenatan.jparser.cpp.CPPBuildHelper;
import com.github.xpenatan.jparser.cpp.FileCopyHelper;
import java.io.File;

public class Build {

    public static void main(String[] args) throws Exception {
        String libName = "imgui-node-editor";

        String cppPath = new File("../editor-base/").getCanonicalPath();
        String buildPath = new File("../editor-build/").getCanonicalPath();
        String genDir = new File("../editor-core/").getCanonicalPath();

        String genJavaDir = genDir + "/src/main/java/";
        String jniDir = buildPath + "/build/c++/";
        String sourceDir = "../editor-base/src/main/java/";
        String sharedlibCppPath = new File("../../../cpp/build/c++/").getCanonicalPath();

        FileCopyHelper.copyDir(cppPath + "/cpp-source", jniDir);

        //Generate CPP
        ImGuiCppParser cppParser = new ImGuiCppParser(ImGuiCppParser.getClassPath("imgui-node-editor", "core", "gdx-1", "gdx-jnigen-loader", "jParser"), jniDir);
        JParser.generate(cppParser, sourceDir, genJavaDir);
        CPPBuildHelper.build(libName, jniDir, "libs", null, sharedlibCppPath, "/src/", "imgui-cpp64", false);
    }
}