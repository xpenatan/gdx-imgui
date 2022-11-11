package com.github.xpenatan.imgui.core.generate;

import com.github.xpenatan.jparser.core.JParser;
import com.github.xpenatan.jparser.core.idl.IDLFile;
import com.github.xpenatan.jparser.core.idl.IDLParser;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        String path = "..\\imgui-core-build\\src\\main\\resources\\imgui.idl";
        IDLFile idlFile = IDLParser.parseFile(path);

        String basePath = new File(".").getAbsolutePath();
        JParser.generate(new ImGuiCppParser(idlFile), basePath + "./imgui-core-base/src", "../imgui-core-cpp/src", null);
    }
}