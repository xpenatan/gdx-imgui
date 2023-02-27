package com.github.xpenatan.imgui.generate;

import com.github.xpenatan.jparser.cpp.CPPBuildHelper;
import com.github.xpenatan.jparser.cpp.FileCopyHelper;
import java.io.File;

public class BuildCPP {

    public static void main(String[] args) throws Exception {
        String libName = "imgui-cpp";

        String cppPath = new File(".").getCanonicalPath();
        String jniPath = cppPath + "/build/c++/";

        File imguiFrom = new File(cppPath + "/build/imgui/");
        File dest = new File(jniPath + "/src");

        //Copy JNI helper
        FileCopyHelper.copyDir(new File(cppPath + "/cpp-source/jni/").toPath(), dest.toPath());

        //Copy Custom code to source
        FileCopyHelper.copyDir(new File(cppPath + "/cpp-source/custom/").toPath(), imguiFrom.toPath());
        FileCopyHelper.copyDir(imguiFrom.toPath(), dest.toPath());

        CPPBuildHelper.build(libName, jniPath);
    }

}
