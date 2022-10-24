package com.github.xpenatan.imgui.custom;

import com.github.xpenatan.imgui.ImGuiInputTextData;

public class EditTextStringData extends EditTextData {

    public final static int DEFAULT_SIZE = 30;

    byte[] data;
    private String text;

    public final ImGuiInputTextData inputData = new ImGuiInputTextData();

    public EditTextStringData() {
        this(null);
    }

    public EditTextStringData(String leftLabel) {
        this(leftLabel, null);
    }

    public EditTextStringData(String leftLabel, String tooltip) {
        this(leftLabel, tooltip, 0);
    }

    public EditTextStringData(String leftLabel, String tooltip, int leftLabelColor) {
        this(DEFAULT_SIZE, leftLabel, tooltip, leftLabelColor, -1);
    }

    public EditTextStringData(int size, String leftLabel, String tooltip, int leftLabelColor, float tooltipDelay) {
        super(DEFAULT_FORMAT_STRING, leftLabel, tooltip, leftLabelColor, tooltipDelay);
        data = new byte[size];
        inputData.maxChar = size;
    }

    public void setValue(String value) {
        inputData.size = value.length();
        text = value;
        for(int i = 0; i < inputData.maxChar; i++) {
            if(i < inputData.size)
                data[i] = (byte)value.charAt(i);
            else {
                data[i] = 0;
            }
        }
    }

    public String getValue() {
        if(inputData.isDirty) {
            inputData.isDirty = false;
            text = new String(data, 0, inputData.size);
        }
        return text;
    }

    @Override
    public String toString() {
        return getValue();
    }

    public byte[] getData() {
        return data;
    }
}
