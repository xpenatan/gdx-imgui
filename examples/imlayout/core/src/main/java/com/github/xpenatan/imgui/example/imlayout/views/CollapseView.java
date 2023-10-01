package com.github.xpenatan.imgui.example.imlayout.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import imgui.ImGui;
import imgui.ImGuiBoolean;
import imgui.ImGuiDir;
import imgui.ImGuiFloat;
import imgui.ImGuiInt;
import imgui.ImVec2;
import imgui.imlayout.ImLayout;

public class CollapseView {

    private Texture buttonTexture;

    private ImGuiBoolean isDebug = new ImGuiBoolean();

    private ImGuiBoolean dummyCheckbox = new ImGuiBoolean();

    private ImGuiBoolean isCollapseOpen = new ImGuiBoolean();
    private ImGuiBoolean isCollapseOpen2 = new ImGuiBoolean();

    private ImGuiFloat alignX = new ImGuiFloat(0.5f);
    private ImGuiFloat offsetX = new ImGuiFloat(0.0f);
    private ImGuiFloat alignY = new ImGuiFloat(0.5f);
    private ImGuiFloat offsetY = new ImGuiFloat(0.0f);

    private ImGuiInt guiInt = new ImGuiInt();

    public void init() {
        buttonTexture = new Texture(Gdx.files.internal("data/badlogicsmall.jpg"));
    }

    public void dispose() {
        buttonTexture.dispose();
    }

    public void render() {
        ImLayout.DrawBoundingBox(100f, 100f,40f, 40f, 255, 0, 0);

        if(ImLayout.BeginCollapseLayout("##idd", "Hello", ImLayout.get_MATCH_PARENT(), ImLayout.get_WRAP_PARENT())) {
            ImGui.Button("HI");

        }
        ImLayout.EndCollapseLayout();

        ImLayout.BeginCollapseLayoutEx("##ID1", isCollapseOpen, "Stuff", ImLayout.MATCH_PARENT, ImLayout.WRAP_PARENT);

        if(isDebug.getValue()) {
            ImLayout.ShowLayoutDebug();
        }

        ImGui.Checkbox("DummyCheckBox", dummyCheckbox);

        ImGui.SameLine();

        ImLayout.BeginAlign("##ID2", ImLayout.MATCH_PARENT, ImLayout.MATCH_PARENT, 1.0f, 0.5f, -5, 0);
        ImGui.Button("Ok");
        ImGui.SameLine();
        ImGui.Text("Custom Align");
        ImLayout.EndAlign();

        ImLayout.EndCollapseFrameLayout();

        if(isCollapseOpen.getValue()) {

            ImGui.Checkbox("LayoutDebug", isDebug);

            ImLayout.BeginCollapseLayout("##ID3", isCollapseOpen2, "Alignment options", ImLayout.MATCH_PARENT, ImLayout.WRAP_PARENT);
            if(isCollapseOpen2.getValue()) {
                ImGui.SliderFloat("AlignX", alignX, 0.0f, 1.0f, "%.2f");
                ImGui.SliderFloat("OffsetX", offsetX, -10.0f, 10.0f, "%.2f");
                ImGui.SliderFloat("AlignY", alignY, 0.0f, 1.0f, "%.2f");
                ImGui.SliderFloat("OffsetY", offsetY, -10.0f, 10.0f, "%.2f");
            }
            ImLayout.EndCollapseLayout();

            ImGui.ArrowButton("##Left", ImGuiDir.ImGuiDir_Left);
            ImGui.SameLine();
            ImGui.ArrowButton("##Right", ImGuiDir.ImGuiDir_Right);
            ImGui.SameLine();
            ImGui.ArrowButton("##Up", ImGuiDir.ImGuiDir_Up);
            ImGui.SameLine();
            ImGui.ArrowButton("##Down", ImGuiDir.ImGuiDir_Down);

            ImGui.RadioButton_2("radio a", guiInt, 0);
            ImGui.SameLine();
            ImGui.RadioButton_2("radio b", guiInt, 1);
            ImGui.SameLine();
            ImGui.RadioButton_2("radio c", guiInt, 2);
            ImGui.SameLine();
            ImGui.RadioButton("radio true", true);

            ImGui.Bullet();
            ImGui.SameLine();
            ImGui.Text("Bullet text");

            ImLayout.BeginAlign("##ID4", ImLayout.MATCH_PARENT, 200, alignX.getValue(), alignY.getValue(), offsetX.getValue(), offsetY.getValue());

            if(isDebug.getValue()) {
                ImLayout.ShowLayoutDebug();
            }

            ImGui.Image(buttonTexture.getTextureObjectHandle(), ImVec2.TMP_1.set(32, 32));
            ImGui.ImageButton("##textId", buttonTexture.getTextureObjectHandle(), ImVec2.TMP_1.set(42, 42));

            ImLayout.EndAlign();
        }
        ImLayout.EndCollapseLayout();
    }
}
