package com.github.xpenatan.imgui.example.imlayout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.github.xpenatan.imgui.core.ImGui;
import com.github.xpenatan.imgui.core.ImGuiBoolean;
import com.github.xpenatan.imgui.core.ImGuiFloat;
import com.github.xpenatan.imgui.core.ImGuiInt;
import com.github.xpenatan.imgui.core.ImRect;
import com.github.xpenatan.imgui.core.enums.ImGuiDir;
import com.github.xpenatan.imgui.imlayout.ImLayout;
import com.github.xpenatan.imgui.imlayout.custom.EditTextFloatData;
import com.github.xpenatan.imgui.imlayout.custom.EditTextIntData;
import com.github.xpenatan.imgui.imlayout.custom.EditTextStringData;
import com.github.xpenatan.imgui.imlayout.custom.ImGuiLayout;

public class ImLayoutView {

    private Texture buttonTexture;

    private ImGuiBoolean isCollapseOpen = new ImGuiBoolean();
    private ImGuiBoolean isCollapseOpen2 = new ImGuiBoolean();

    private EditTextFloatData dF1 = new EditTextFloatData("X:", "Tooltip 01", ImGui.ColorToIntBits(255, 0, 0, 255), 0);
    private EditTextFloatData dF2 = new EditTextFloatData("Y:", "Tooltip 02");
    private EditTextFloatData dF3 = new EditTextFloatData("Z:", "Tooltip 03");

    private EditTextIntData dI1 = new EditTextIntData("X:", "Tooltip 01", ImGui.ColorToIntBits(255, 0, 0, 255), 0);
    private EditTextIntData dI2 = new EditTextIntData("Y:", "Tooltip 02");
    private EditTextIntData dI3 = new EditTextIntData("Z:", "Tooltip 03");
    private EditTextStringData dS1 = new EditTextStringData("S:", "Tooltip String");

    private ImGuiFloat alignX = new ImGuiFloat(0.5f);
    private ImGuiFloat offsetX = new ImGuiFloat(0.0f);
    private ImGuiFloat alignY = new ImGuiFloat(0.5f);
    private ImGuiFloat offsetY = new ImGuiFloat(0.0f);

    private ImGuiInt guiInt = new ImGuiInt();

    public void init() {
        ImLayout.init();
        buttonTexture = new Texture(Gdx.files.internal("data/badlogicsmall.jpg"));
    }

    public void dispose() {
        buttonTexture.dispose();
    }

    public void renderTabImGuiExtViews() {

        testContentSize();

        dF1.leftLabelDragColor = ImGui.ColorToIntBits(255, 255, 0, 255);
        dF2.format = "%.2f";
        dF3.v_min = -5f;
        dF3.v_max = 5f;
        dF3.v_speed = 0.01f;
        int index = ImLayout.EditTextF("##1", dF1, dF2, dF3);

        if(index != -1) {
            System.out.println("index: " + index);
            System.out.println("dF1.isDragging: " + dF1.isDragging);
            System.out.println("dF2.isDragging: " + dF2.isDragging);
            System.out.println("dF3.isDragging: " + dF3.isDragging);
        }

        dI3.v_min = -25;
        dI3.v_max = 25;

        ImLayout.EditTextI("##2", dI1, dI2, dI3);

        if(ImLayout.EditTextS("##S", dS1)) {
            String newValue = dS1.getValue();
            int length = newValue.length();
            System.out.println("newValue: " + newValue);
        }

        testContentSize();

        float mouseX = Gdx.input.getX();
        float mouseY = Gdx.input.getY();

        ImLayout.BeginLayout("Stuff", ImLayout.WRAP_PARENT, ImLayout.WRAP_PARENT);
        ImLayout.ShowLayoutDebug();
        ImGuiLayout curLayout = ImLayout.GetCurrentLayout();
        float posX = curLayout.positionX;
        float posY = curLayout.positionY;
        float sizeX = curLayout.sizeX;
        float sizeY = curLayout.sizeY;
        float posSizeX = posX + sizeX;
        float posSizeY = posY + sizeY;

        ImGui.Text("MouseX: " + mouseX);
        ImGui.SameLine();
        ImGui.Text("MouseY: " + mouseY);
        ImGui.Text("posX: " + posX);
        ImGui.Text("posY: " + posY);
        ImGui.Text("posSizeX: " + posSizeX);
        ImGui.Text("posSizeY: " + posSizeY);

        ImLayout.EndLayout();

        renderExtCollapseUI();
    }

    private void testContentSize() {
        ImLayout.BeginBoundingBox();
        ImGui.Button("Label");
        ImGui.Button("Label Test");
        ImRect boundingBox = ImLayout.EndBoundingBox();
        ImLayout.DrawBoundingBox(boundingBox.minX, boundingBox.minY, boundingBox.maxX, boundingBox.maxY, 255, 0, 0, 255);
    }

    private void renderExtCollapseUI() {
        ImLayout.BeginCollapseLayoutEx("##ID1", isCollapseOpen, "Stuff", ImLayout.MATCH_PARENT, ImLayout.WRAP_PARENT);

        ImLayout.ShowLayoutDebug();

        ImLayout.BeginAlign("##ID2", ImLayout.MATCH_PARENT, ImLayout.MATCH_PARENT, 1.0f, 0.5f, -5, 0);
        ImGui.Button("Ok");
        ImGui.SameLine();
        ImGui.Text("Custom Align");
        ImLayout.EndAlign();

        ImLayout.EndCollapseFrameLayout();
        if(isCollapseOpen.getValue()) {
            ImLayout.BeginCollapseLayout("##ID3", isCollapseOpen2, "Alignment options", ImLayout.MATCH_PARENT, ImLayout.WRAP_PARENT);
            if(isCollapseOpen2.getValue()) {
                ImGui.SliderFloat("AlignX", alignX, 0.0f, 1.0f, "%.2f");
                ImGui.SliderFloat("OffsetX", offsetX, -10.0f, 10.0f, "%.2f");
                ImGui.SliderFloat("AlignY", alignY, 0.0f, 1.0f, "%.2f");
                ImGui.SliderFloat("OffsetY", offsetY, -10.0f, 10.0f, "%.2f");
            }
            ImLayout.EndCollapseLayout();

            ImGui.ArrowButton("##Left", ImGuiDir.Left);
            ImGui.SameLine();
            ImGui.ArrowButton("##Right", ImGuiDir.Right);
            ImGui.SameLine();
            ImGui.ArrowButton("##Up", ImGuiDir.Up);
            ImGui.SameLine();
            ImGui.ArrowButton("##Down", ImGuiDir.Down);

            ImGui.RadioButton("radio a", guiInt, 0);
            ImGui.SameLine();
            ImGui.RadioButton("radio b", guiInt, 1);
            ImGui.SameLine();
            ImGui.RadioButton("radio c", guiInt, 2);
            ImGui.SameLine();
            ImGui.RadioButton("radio true", true);

            ImGui.Bullet();
            ImGui.SameLine();
            ImGui.Text("Bullet text");

            ImLayout.BeginAlign("##ID4", ImLayout.MATCH_PARENT, 200, alignX.getValue(), alignY.getValue(), offsetX.getValue(), offsetY.getValue());
            ImLayout.ShowLayoutDebug();
            ImGui.Image(buttonTexture.getTextureObjectHandle(), 32, 32);
            ImGui.ImageButton(buttonTexture.getTextureObjectHandle(), 42, 42);

            ImLayout.EndAlign();
        }
        ImLayout.EndCollapseLayout();
    }
}
