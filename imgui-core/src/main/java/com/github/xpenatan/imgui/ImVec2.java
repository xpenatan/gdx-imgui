package com.github.xpenatan.imgui;

public class ImVec2 {
    public static ImVec2 TMP = new ImVec2();

    public ImVec2() {
    }

    public ImVec2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float x;
    public float y;
}
