package com.github.xpenatan.imgui.core;

import java.nio.charset.StandardCharsets;

public class ImGuiString extends ImGuiBase {
    public static ImGuiString TMP = new ImGuiString();

    boolean isDirty = false;

    ImGuiByteArray data;

    private String text;

    int size;

    public ImGuiString() {
        this(10);
    }

    public ImGuiString(int bufferSize) {
        data = new ImGuiByteArray(bufferSize);
    }

    public ImGuiString(String text) {
        this(text.length());
        setValue(text);
    }

    @Override
    public void dispose() {
        super.dispose();
        data.dispose();
    }

    @Override
    public long getCPointer() {
        return data.getCPointer();
    }

    @Override
    public void setPointer(long cPtr) {
        data.setPointer(cPtr);
    }

    public void resizeBuffer(int newBufferSize) {
        data.resize(newBufferSize);
        isDirty = true;
    }

    public void setValue(String value) {
        size = value.length();
        int sizeEndLine = size+1;
        int dataSize = data.getSize();
        byte[] strBytes = value.getBytes();
        if(sizeEndLine > dataSize) {
            data.resize(sizeEndLine);
        }
        else {
            //setting value 0 to a bigger buffer makes imgui ignore junk characters
            byte val = 0;
            data.setValue(size, val);
        }
        ImGuiByteArray.arraycopy(strBytes, 0, data, 0, size);
        isDirty = true;
    }

    public String getValue() {
        if(isDirty) {
            isDirty = false;
            byte[] charData = new byte[size];
            ImGuiByteArray.arraycopy(data, 0, charData, 0, size);
            text = new String(charData, 0, size);
        }
        return text;
    }

    public long getValuePointer() {
        return data.getValuePointer();
    }

    public int getBufferSize() {
        return data.getSize();
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
