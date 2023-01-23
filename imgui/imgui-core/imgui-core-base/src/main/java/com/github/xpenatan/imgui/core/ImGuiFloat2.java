package com.github.xpenatan.imgui.core;

public class ImGuiFloat2 {
    public static ImGuiFloat2 TMP = new ImGuiFloat2();

    float[] data = new float[]{0.0f, 0.0f};

    public ImGuiFloat2() {
    }

    public ImGuiFloat2(float x, float y) {
        setValue(x, y);
    }

    public void setValue(float x, float y) {
        this.data[0] = x;
        this.data[1] = y;
    }

    public void setX(float value) {
        this.data[0] = value;
    }

    public float getX() {
        return this.data[0];
    }

    public void setY(float value) {
        this.data[1] = value;
    }

    public float getY() {
        return this.data[1];
    }


    @Override
    public String toString() {
        return "x: " + getX() + " y:" + getY();
    }
}
