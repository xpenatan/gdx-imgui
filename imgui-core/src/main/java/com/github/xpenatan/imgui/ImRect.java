package com.github.xpenatan.imgui;

public class ImRect {
    public static ImRect tmp = new ImRect();

    public float minX;
    public float minY;

    public float maxX;
    public float maxY;

    public void reset() {
        minX = 0;
        minY = 0;
        maxX = 0;
        maxY = 0;
    }
}
