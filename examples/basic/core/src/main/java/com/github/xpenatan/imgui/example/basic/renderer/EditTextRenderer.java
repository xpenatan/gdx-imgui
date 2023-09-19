package com.github.xpenatan.imgui.example.basic.renderer;

import imgui.ImGui;
import imgui.ImGuiFloat;
import imgui.ImGuiFloat2;
import imgui.ImGuiFloat3;
import imgui.ImGuiFloat4;
import imgui.ImGuiString;

public class EditTextRenderer implements UIRenderer {

    private final ImGuiFloat imguiFloat1 = new ImGuiFloat();
    private final ImGuiFloat2 imguiFloat2 = new ImGuiFloat2();
    private final ImGuiFloat3 imguiFloat3 = new ImGuiFloat3();
    private final ImGuiFloat4 imguiFloat4 = new ImGuiFloat4();

    private final ImGuiString imguiString1 = new ImGuiString();

    public EditTextRenderer() {
    }

    public void render() {
        ImGui.DragFloat("TestFloat", imguiFloat1);
        ImGui.DragFloat2("TestFloat2", imguiFloat2);
        ImGui.DragFloat3("TestFloat3", imguiFloat3);
        ImGui.DragFloat4("TestFloat4", imguiFloat4, 0.01f, -2, 2);

        if(ImGui.InputText("TestString2", imguiString1, imguiString1.getSize())) {
            String value = imguiString1.getValue();
            System.out.println("value: " + value);
        }
    }

    @Override
    public String getName() {
        return "EditText";
    }
}
