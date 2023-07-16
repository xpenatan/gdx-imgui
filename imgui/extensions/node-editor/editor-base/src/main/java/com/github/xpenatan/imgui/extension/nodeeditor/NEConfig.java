package com.github.xpenatan.imgui.extension.nodeeditor;

import com.github.xpenatan.imgui.core.ImGuiBase;

public class NEConfig extends ImGuiBase {

    /*[-C++;-NATIVE]
        #include <imgui_node_editor.h>
        namespace ed = ax::NodeEditor;
    */

    public NEConfig() {
        initObject(createNative(), true);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = new ED.Config();
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        return (jlong)new ed::Config();
    */
    private static native long createNative();
}