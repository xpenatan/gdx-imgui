package com.github.xpenatan.imgui.core;

public class ImGuiInt2 {
    public static ImGuiInt2 TMP = new ImGuiInt2();

    int[] data = new int[]{0, 0};

    public ImGuiInt2() {
    }

    public ImGuiInt2(int x, int y) {
        setValue(x, y);
    }

    public void setValue(int x, int y) {
        this.data[0] = x;
        this.data[1] = y;
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

    @Override
    public String toString() {
        return "x: " + getX() + " y:" + getY();
    }
}
