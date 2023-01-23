package com.github.xpenatan.imgui.core;

public class ImGuiInt3 {
    public static ImGuiInt3 TMP = new ImGuiInt3();

    int[] data = new int[]{0, 0, 0};

    public ImGuiInt3() {
    }

    public ImGuiInt3(int x, int y, int z) {
        setValue(x, y, z);
    }

    public void setValue(int x, int y, int z) {
        this.data[0] = x;
        this.data[1] = y;
        this.data[2] = z;
    }

    public void setX(int value) {
        this.data[0] = value;
    }

    public int getX() {
        return this.data[0];
    }

    public void setY(int value) {
        this.data[1] = value;
    }

    public int getY() {
        return this.data[1];
    }

    public void setZ(int value) {
        this.data[2] = value;
    }

    public int getZ() {
        return this.data[2];
    }

    @Override
    public String toString() {
        return "x: " + getX() + " y:" + getY() + " z:" + getZ();
    }
}
