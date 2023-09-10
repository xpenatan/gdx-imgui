package com.github.xpenatan.imgui.example.basic.renderer;


import imgui.ImColor;
import imgui.ImGui;

public class ColorRenderer {
//
    private final ImColor color3 = new ImColor();
    private final ImColor color4 = new ImColor();

    public ColorRenderer() {
    }

    public void render() {

        if(ImGui.ColorEdit3("color 01", color3)) {
            float r = color3.getX();
            float g = color3.getY();
            float b = color3.getZ();
            System.out.println("Red: " + r + " Green: " + g + " Blue: " + b);
        }

        if(ImGui.ColorEdit4("color 02", color4)) {
            float r = color4.getX();
            float g = color4.getY();
            float b = color4.getZ();
            float a = color4.getW();
            System.out.println("Red: " + r + " Green: " + g + " Blue: " + b + " Alpha: " + a);
        }
    }
}
