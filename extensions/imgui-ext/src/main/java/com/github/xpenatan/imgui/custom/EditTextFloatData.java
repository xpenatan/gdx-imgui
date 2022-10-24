package com.github.xpenatan.imgui.custom;

public class EditTextFloatData extends EditTextData {

    public static EditTextFloatData tmp01 = new EditTextFloatData();
    public static EditTextFloatData tmp02 = new EditTextFloatData();
    public static EditTextFloatData tmp03 = new EditTextFloatData();
    public static EditTextFloatData tmp04 = new EditTextFloatData();

    public float value;
    public float v_min;
    public float v_max;

    public EditTextFloatData() {
        this(null);
    }

    public EditTextFloatData(String leftLabel) {
        this(leftLabel, null);
    }

    public EditTextFloatData(String leftLabel, String tooltip) {
        this(leftLabel, tooltip, 0);
    }

    public EditTextFloatData(String leftLabel, String tooltip, int leftLabelColor) {
        this(leftLabel, tooltip, leftLabelColor, -1);
    }

    public EditTextFloatData(String leftLabel, String tooltip, int leftLabelColor, float tooltipDelay) {
        super(EditTextData.DEFAULT_FORMAT_FLOAT, leftLabel, tooltip, leftLabelColor, tooltipDelay);
    }
}
