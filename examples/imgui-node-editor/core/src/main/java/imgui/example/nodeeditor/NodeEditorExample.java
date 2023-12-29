package imgui.example.nodeeditor;

import imgui.example.renderer.ImGuiRenderer;
import imgui.extension.nodeeditor.CustomNodeEditor;

public class NodeEditorExample extends ImGuiRenderer {


    @Override
    public void show() {
        super.show();

        CustomNodeEditor.print();

    }

    @Override
    public void renderImGui() {

    }
}