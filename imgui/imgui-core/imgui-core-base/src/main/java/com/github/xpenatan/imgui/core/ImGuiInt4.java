package com.github.xpenatan.imgui.core;

public class ImGuiInt4 {
    public static ImGuiInt4 TMP = new ImGuiInt4();

    int[] data = new int[]{0, 0, 0, 0};

    public ImGuiInt4() {
    }

    public ImGuiInt4(int x, int y, int z, int w) {
        setValue(x, y, z, w);
    }

    public void setValue(int x, int y, int z, int w) {
        this.data[0] = x;
        this.data[1] = y;
        this.data[2] = z;
        this.data[3] = w;
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

    public void setW(int value) {
        this.data[3] = value;
    }

    public int getW() {
        return this.data[3];
    }

    @Override
    public String toString() {
        return "x: " + getX() + " y:" + getY() + " z:" + getZ() + " w:" + getW();
    }
}
