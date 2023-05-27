package com.github.xpenatan.imgui.example.basic.renderer;

import com.github.xpenatan.imgui.core.ImGui;
import com.github.xpenatan.imgui.core.ImGuiFloat;
import com.github.xpenatan.imgui.core.ImGuiFloat2;
import com.github.xpenatan.imgui.core.ImGuiFloat3;
import com.github.xpenatan.imgui.core.ImGuiFloat4;
import com.github.xpenatan.imgui.core.ImGuiString;

public class EditTextRenderer {

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

        if(ImGui.InputText("TestString2", imguiString1)) {
            String value = imguiString1.getValue();
            System.out.println("value: " + value);
        }
    }
}
