package com.github.xpenatan.imgui;

public class ImGuiViewport {
    public int platformUserData;
    public long platformHandle;
    public int flags;
    public float sizeX;
    public float sizeY;
    public float posX;
    public float posY;
    public final ImDrawData drawData = new ImDrawData();
}
