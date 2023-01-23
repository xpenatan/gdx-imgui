package com.github.xpenatan.imgui.core;

public class ImGuiFloat3 {
    public static ImGuiFloat3 TMP = new ImGuiFloat3();

    float[] data = new float[]{0.0f, 0.0f, 0.0f};

    public ImGuiFloat3() {
    }

    public ImGuiFloat3(float x, float y, float z) {
        setValue(x, y, z);
    }

    public void setValue(float x, float y, float z) {
        this.data[0] = x;
        this.data[1] = y;
        this.data[2] = z;
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

    public void setZ(float value) {
        this.data[2] = value;
    }

    public float getZ() {
        return this.data[2];
    }


    @Override
    public String toString() {
        return "x: " + getX() + " y:" + getY() + " z:" + getY();
    }
}
