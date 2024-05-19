package imgui.example.basic.renderer;

import imgui.ImGui;

public class ModalRenderer implements UIRenderer {

    public ModalRenderer() {
    }

    @Override
    public void render() {
        if(ImGui.Button("Show Modal")) {
            ImGui.OpenPopup("Modal");
        }

        if(ImGui.BeginPopupModal("Modal")) {
            ImGui.Text("Hello text");

            if(ImGui.Button("Close")) {
                ImGui.CloseCurrentPopup();
            }
            ImGui.EndPopup();
        }
    }

    @Override
    public String getName() {
        return "Modal";
    }
}