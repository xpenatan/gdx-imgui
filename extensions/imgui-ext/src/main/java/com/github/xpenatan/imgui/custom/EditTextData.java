package com.github.xpenatan.imgui.custom;

public class EditTextData {

	public static String DEFAULT_FORMAT_FLOAT = "%0.3f";
	public static String DEFAULT_FORMAT_INT = "%d";
	public static String DEFAULT_FORMAT_STRING = null;

	public String leftLabel;
	public int leftLabelColor;
	public int leftLabelDragColor;
	public String tooltip;
	public float tooltipDelay = -1; //use default c++ delay
	public float v_speed = -1;
	public float power = -1;
	public String format = null;
	public boolean isDragging;

	EditTextData(String format) {
		this(format, null);
	}

	EditTextData(String format, String leftLabel) {
		this(format, leftLabel, null);
	}

	EditTextData(String format, String leftLabel, String tooltip) {
		this(format, leftLabel, tooltip, 0);
	}

	EditTextData(String format, String leftLabel, String tooltip, int leftLabelColor) {
		this(format, leftLabel, tooltip, leftLabelColor, -1);
	}

	EditTextData(String format, String leftLabel, String tooltip, int leftLabelColor, float tooltipDelay) {
		this.format = format;
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
		isDragging = false;
	}
}
