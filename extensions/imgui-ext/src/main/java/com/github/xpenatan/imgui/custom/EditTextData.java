package com.github.xpenatan.imgui.custom;

public class EditTextData {
	public String leftLabel;
	public int leftLabelColor;
	public String tooltip;
	public float tooltipDelay = -1; //use default c++ delay


	public EditTextData(String leftLabel) {
		this(leftLabel, null);
	}

	public EditTextData(String leftLabel, String tooltip) {
		this(leftLabel, tooltip, 0);
	}

	public EditTextData(String leftLabel, String tooltip, int leftLabelColor) {
		this(leftLabel, tooltip, leftLabelColor, -1);
	}

	public EditTextData(String leftLabel, String tooltip, int leftLabelColor, float tooltipDelay) {
		this.leftLabel = leftLabel;
		this.tooltip = tooltip;
		this.leftLabelColor = leftLabelColor;
		this.tooltipDelay = tooltipDelay;
	}
}
