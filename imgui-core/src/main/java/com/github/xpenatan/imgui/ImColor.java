package com.github.xpenatan.imgui;

public class ImColor {
    float[] data = new float[4];

    public ImColor() {
        setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public ImColor(float r, float g, float b, float a) {
        setColor(r, g, b, a);
    }

    public ImColor(float r, float g, float b) {
        setColor(r, g, b);
    }

    public ImColor(int r, int g, int b, int a) {
        setColor(r, g, b, a);
    }

    public ImColor(int r, int g, int b) {
        setColor(r, g, b);
    }

    /**
     * Color from 0.0-1.0
     */
    public void setColor(float r, float g, float b, float a) {
        data[0] = r;
        data[1] = g;
        data[2] = b;
        data[3] = a;
    }

    /**
     * Color from 0.0-1.0
     */
    public void setColor(float r, float g, float b) {
        data[0] = r;
        data[1] = g;
        data[2] = b;
    }

    /**
     * Color from 0-255
     */
    public void setColor(int r, int g, int b, int a) {
        data[0] = r / 255f;
        data[1] = g / 255f;
        data[2] = b / 255f;
        data[3] = a / 255f;
    }

    /**
     * Color from 0-255
     */
    public void setColor(int r, int g, int b) {
        data[0] = r / 255f;
        data[1] = g / 255f;
        data[2] = b / 255f;
    }

    public float getR() {
        return data[0];
    }

    public float getG() {
        return data[1];
    }

    public float getB() {
        return data[2];
    }

    public float getA() {
        return data[3];
    }
}
