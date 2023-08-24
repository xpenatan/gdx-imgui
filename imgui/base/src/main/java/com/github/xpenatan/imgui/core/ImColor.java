package com.github.xpenatan.imgui.core;

public class ImColor {

    ImGuiFloat4 data;

    public ImColor() {
        data = new ImGuiFloat4();
        setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public ImColor(float r, float g, float b, float a) {
        data = new ImGuiFloat4();
        setColor(r, g, b, a);
    }

    public ImColor(float r, float g, float b) {
        data = new ImGuiFloat4();
        setColor(r, g, b);
    }

    public ImColor(int r, int g, int b, int a) {
        data = new ImGuiFloat4();
        setColor(r, g, b, a);
    }

    public ImColor(int r, int g, int b) {
        data = new ImGuiFloat4();
        setColor(r, g, b);
    }

    /**
     * Color from 0.0-1.0
     */
    public void setColor(float r, float g, float b, float a) {
        data.setValue(r, g, b, a);
    }

    /**
     * Color from 0.0-1.0
     */
    public void setColor(float r, float g, float b) {
        data.setValue(r, g, b, 0);
    }

    /**
     * Color from 0-255
     */
    public void setColor(int r, int g, int b, int a) {
        float rr = r / 255f;
        float gg = g / 255f;
        float bb = b / 255f;
        float aa = a / 255f;
        setColor(rr, gg, bb, aa);
    }

    /**
     * Color from 0-255
     */
    public void setColor(int r, int g, int b) {
        float rr = r / 255f;
        float gg = g / 255f;
        float bb = b / 255f;
        setColor(rr, gg, bb);
    }

    public float getR() {
        return data.getX();
    }

    public float getG() {
        return data.getY();
    }

    public float getB() {
        return data.getZ();
    }

    public float getA() {
        return data.getW();
    }

    public long getValuePointer() {
        return data.getValuePointer();
    }
}