package imgui.example.basic.renderer;

import imgui.ImGui;
import imgui.ImGuiPayload;
import imgui.ImGuiString;

public class DragAndDropRenderer implements UIRenderer {

    private ImGuiString imString = new ImGuiString();

    public DragAndDropRenderer() {
    }

    @Override
    public void render() {
        ImGui.inputText("##test", imString, imString.getSize());

        if(ImGui.beginDragDropSource()) {
            ImGui.setDragDropPayload("DRAG_ENTITY_ID", 3);
            ImGui.text("Dragging: " + "entityName");
            ImGui.endDragDropSource();
        }

        ImGui.text("Drag here");
        if(ImGui.beginDragDropTarget()) {
            ImGuiPayload dragDropPayload = ImGui.acceptDragDropPayload("DRAG_ENTITY_ID");
            if(dragDropPayload != null) {
                System.out.println("dragDropPayload");
                int data1 = dragDropPayload.get_Data();
                System.out.println("Value: " + data1);
            }
            ImGui.endDragDropTarget();
        }
    }

    @Override
    public String getName() {
        return "Drag&Drop";
    }
}