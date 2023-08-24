package com.github.xpenatan.imgui.core.generate;

import com.github.xpenatan.jparser.cpp.CppCodeParser;
import com.github.xpenatan.jparser.idl.IDLReader;

public class ImGuiCppParser extends CppCodeParser {

    public ImGuiCppParser(String classpath, String jniDir) {
        this(null, classpath, jniDir);
    }

    public ImGuiCppParser(IDLReader idlReader, String classpath, String jniDir) {
        super(null, classpath, jniDir);
    }
}
