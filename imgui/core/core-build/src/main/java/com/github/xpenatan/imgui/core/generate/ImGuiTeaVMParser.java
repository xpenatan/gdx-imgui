package com.github.xpenatan.imgui.core.generate;

import com.github.xpenatan.jparser.idl.IDLReader;
import com.github.xpenatan.jparser.teavm.TeaVMCodeParser;

public class ImGuiTeaVMParser extends TeaVMCodeParser {
    public ImGuiTeaVMParser(IDLReader idlFile) {
        super("ImGui", null);
    }
}
