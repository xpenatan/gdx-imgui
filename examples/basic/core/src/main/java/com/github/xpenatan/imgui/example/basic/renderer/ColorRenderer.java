package com.github.xpenatan.imgui.example.basic.renderer;

import com.github.xpenatan.imgui.core.ImColor;
import com.github.xpenatan.imgui.core.ImGui;

public class ColorRenderer {

    private final ImColor color3 = new ImColor();
    private final ImColor color4 = new ImColor();

    public ColorRenderer() {
    }

    public void render() {

        if(ImGui.ColorEdit3("color 01", color3)) {
            float r = color3.getR();
            float g = color3.getG();
            float b = color3.getB();
            System.out.println("Red: " + r + " Green: " + g + " Blue: " + b);
        }

        if(ImGui.ColorEdit4("color 02", color4)) {
            float r = color4.getR();
            float g = color4.getG();
            float b = color4.getB();
            float a = color4.getA();
            System.out.println("Red: " + r + " Green: " + g + " Blue: " + b + " Alpha: " + a);
        }
    }
}
