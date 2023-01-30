package com.github.xpenatan.imgui.core;

import java.nio.charset.StandardCharsets;

public class ImGuiString {
    public static ImGuiString TMP = new ImGuiString();

    boolean isDirty = false;

    byte[] data;

    private String text;

    int size;

    public ImGuiString() {
        this(10);
    }

    public ImGuiString(int bufferSize) {
        data = new byte[bufferSize];
    }

    public ImGuiString(String text) {
        this(text.length());
        setValue(text);
    }

    public void resizeBuffer(int newBufferSize) {
        byte[] newItems = new byte[newBufferSize];
        int newSize = Math.min(size, newItems.length);
        System.arraycopy(data, 0, newItems, 0, newSize);
        this.data = newItems;
        this.size = newSize;
        isDirty = true;
    }

    public void setValue(String value) {
        size = value.length();
        byte[] strBytes = value.getBytes();
        if(size >= data.length) {
            data = new byte[size + 10];
        }
        System.arraycopy(strBytes, 0, data, 0, size);
        isDirty = true;
    }

    public String getValue() {
        if(isDirty) {
            isDirty = false;
            text = new String(data, 0, size, StandardCharsets.UTF_8);
        }
        return text;
    }

    public byte[] getData() {
        return data;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
