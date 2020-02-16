package com.github.xpenatan.imgui.custom;

public class EditTextIntData extends EditTextData {

	public static EditTextIntData tmp01 = new EditTextIntData();
	public static EditTextIntData tmp02 = new EditTextIntData();
	public static EditTextIntData tmp03 = new EditTextIntData();
	public static EditTextIntData tmp04 = new EditTextIntData();

	public int value;
	public int v_min;
	public int v_max;

	public EditTextIntData() {
		this(null);
	}

	public EditTextIntData(String leftLabel) {
		this(leftLabel, null);
	}

	public EditTextIntData(String leftLabel, String tooltip) {
		this(leftLabel, tooltip, 0);
	}

	public EditTextIntData(String leftLabel, String tooltip, int leftLabelColor) {
		this(leftLabel, tooltip, leftLabelColor, -1);
	}

	public EditTextIntData(String leftLabel, String tooltip, int leftLabelColor, float tooltipDelay) {
		super(EditTextData.DEFAULT_FORMAT_INT, leftLabel, tooltip, leftLabelColor, tooltipDelay);
	}
}
