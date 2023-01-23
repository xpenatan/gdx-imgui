package com.github.xpenatan.imgui.core;

public class ImGuiFloat4 {
    public static ImGuiFloat4 TMP = new ImGuiFloat4();

    float[] data = new float[]{0.0f, 0.0f, 0.0f, 0.0f};

    public ImGuiFloat4() {
    }

    public ImGuiFloat4(float x, float y, float z, float w) {
        setValue(x, y, z, w);
    }

    public void setValue(float x, float y, float z, float w) {
        this.data[0] = x;
        this.data[1] = y;
        this.data[2] = z;
        this.data[3] = w;
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

    public void setW(float value) {
        this.data[3] = value;
    }

    public float getW() {
        return this.data[3];
    }


    @Override
    public String toString() {
        return "x: " + getX() + " y:" + getY() + " z:" + getZ() + " w:" + getW();
    }
}
