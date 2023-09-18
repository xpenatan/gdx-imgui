package com.github.xpenatan.imgui.example.imlayout.views;

import com.badlogic.gdx.Gdx;
import imgui.ImGui;
import imgui.ImVec2;
import imgui.imlayout.ImGuiLayout;
import imgui.imlayout.ImLayout;

public class LayoutTestView {

    public void render() {
        float mouseX = Gdx.input.getX();
        float mouseY = Gdx.input.getY();

        ImLayout.BeginLayout("Stuff", ImLayout.WRAP_PARENT, ImLayout.WRAP_PARENT);
        ImLayout.ShowLayoutDebug();
        ImGuiLayout curLayout = ImLayout.GetCurrentLayout();
        ImVec2 position = curLayout.get_position();
        ImVec2 size = curLayout.get_size();
        float posX = position.get_x();
        float posY = position.get_y();
        float sizeX = size.get_x();
        float sizeY = size.get_y();
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
    }
}
