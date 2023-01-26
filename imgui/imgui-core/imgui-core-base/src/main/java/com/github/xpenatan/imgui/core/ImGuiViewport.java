package com.github.xpenatan.imgui.core;

public class ImGuiViewport extends ImGuiBase {

    /*[-C++;-NATIVE]
        #include "imgui.h"
    */

    private int platformUserData;
    private long platformHandle;
    private int flags;
    private float sizeX;
    private float sizeY;
    private float posX;
    private float posY;
    private final ImDrawData drawData = new ImDrawData(false);

    public void setPlatformUserData(int platformUserData) {
        this.platformUserData = platformUserData;
    }

    public int getPlatformUserData() {
        return platformUserData;
    }

    public void setPlatformHandle(long platformHandle) {
        this.platformHandle = platformHandle;
    }

    public long getPlatformHandle() {
        return platformHandle;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public int getFlags() {
        return flags;
    }

    public void setSizeX(float sizeX) {
        this.sizeX = sizeX;
    }

    public float getSizeX() {
        return sizeX;
    }

    public void setSizeY(float sizeY) {
        this.sizeY = sizeY;
    }

    public float getSizeY() {
        return sizeY;
    }

    public void setPosX(float x) {
        this.posX = x;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosY(float y) {
        this.posY = y;
    }

    public float getPosY() {
        return posY;
    }

    public ImDrawData getDrawData() {
        return drawData;
    }
}
