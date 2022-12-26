package com.github.xpenatan.imgui.generate;

import com.github.xpenatan.jparser.cpp.CPPBuildHelper;
import com.github.xpenatan.jparser.cpp.FileCopyHelper;
import java.io.File;

public class BuildCPP {

    public static void main(String[] args) throws Exception {
        String libName = "imgui-cpp";

        String cppPath = new File(".").getCanonicalPath();
        String jniPath = cppPath + "/jni";

        File from = new File(cppPath + "/cpp-source/");
        File dest = new File(jniPath + "/src");
        FileCopyHelper.copyDir(from.toPath(), dest.toPath());

        CPPBuildHelper.build(libName, jniPath);
    }

}
