package com.github.xpenatan.imgui.core.generate;

import com.github.xpenatan.jparser.core.idl.IDLFile;
import com.github.xpenatan.jparser.cpp.CppCodeParser;

public class ImGuiCppParser extends CppCodeParser {

    public ImGuiCppParser(String classpath, String jniDir) {
        this(null, classpath, jniDir);
    }

    public ImGuiCppParser(IDLFile idlFile, String classpath, String jniDir) {
        super(null, classpath, jniDir);
    }
}
