package com.github.xpenatan.imgui.core;

public class ImGuiBoolean {
    public static ImGuiBoolean TMP = new ImGuiBoolean();
    // teaVM don't support boolean array.
    public byte[] data = new byte[]{ 0 };

    public ImGuiBoolean() {
    }

    public ImGuiBoolean(boolean value) {
        setValue(value);
    }

    public void setValue(boolean value) {
        if(value) {
            this.data[0] = 1;
        }
        else {
            this.data[0] = 0;
        }
    }

    public boolean getValue() {
        return this.data[0] == 1;
    }

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}
