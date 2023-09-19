package com.github.xpenatan.imgui.example.basic.renderer;

import imgui.ImGui;
import imgui.ImGuiPayload;
import imgui.ImGuiString;

public class DragAndDropRenderer implements UIRenderer {

    private ImGuiString imString = new ImGuiString();

    public DragAndDropRenderer() {
    }

    @Override
    public void render() {
        ImGui.InputText("##test", imString, imString.getSize());

        if(ImGui.BeginDragDropSource()) {
            ImGui.SetDragDropPayload("DRAG_ENTITY_ID", 3);
            ImGui.Text("Dragging: " + "entityName");
            ImGui.EndDragDropSource();
        }

        ImGui.Text("dadsada");
        if(ImGui.BeginDragDropTarget()) {
            ImGuiPayload dragDropPayload = ImGui.AcceptDragDropPayload("DRAG_ENTITY_ID");
            if(dragDropPayload != null) {
                System.out.println("dragDropPayload");
                int data1 = dragDropPayload.get_Data();
                System.out.println("Value: " + data1);
            }
            ImGui.EndDragDropTarget();
        }
    }

    @Override
    public String getName() {
        return "Drag&Drop";
    }
}