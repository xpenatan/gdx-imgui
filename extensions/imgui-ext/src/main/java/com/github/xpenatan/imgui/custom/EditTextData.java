package com.github.xpenatan.imgui.custom;

public class EditTextData {

	public String leftLabel;
	public int leftLabelColor;
	public int leftLabelDragColor;
	public String tooltip;
	public float tooltipDelay = -1; //use default c++ delay
	public float v_speed = -1;
	public float power = -1;
	public String format = null;

	EditTextData() {
		this(null);
	}

	EditTextData(String leftLabel) {
		this(leftLabel, null);
	}

	EditTextData(String leftLabel, String tooltip) {
		this(leftLabel, tooltip, 0);
	}

	EditTextData(String leftLabel, String tooltip, int leftLabelColor) {
		this(leftLabel, tooltip, leftLabelColor, -1);
	}

	EditTextData(String leftLabel, String tooltip, int leftLabelColor, float tooltipDelay) {
		this.leftLabel = leftLabel;
		this.tooltip = tooltip;
		this.leftLabelColor = leftLabelColor;
		this.tooltipDelay = tooltipDelay;
	}

	public void reset() {
		leftLabel = null;
		leftLabelColor = 0;
		tooltip = null;
		tooltipDelay = -1;
	}
}
