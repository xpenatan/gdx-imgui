package com.github.xpenatan.imgui.core.generate;

import com.github.xpenatan.jparser.core.idl.IDLFile;
import com.github.xpenatan.jparser.teavm.TeaVMCodeParser;

public class ImGuiTeaVMParser extends TeaVMCodeParser {
    public ImGuiTeaVMParser(IDLFile idlFile) {
        super("ImGui", null);
    }
}
