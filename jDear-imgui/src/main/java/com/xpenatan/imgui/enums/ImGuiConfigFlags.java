package com.xpenatan.imgui.enums;

/**
 * Configuration flags stored in io.ConfigFlags. Set by user/application.
 */
public enum ImGuiConfigFlags {
	None(0),
	NavEnableKeyboard(1 << 0),
	NavEnableGamepad(1 << 1),
	NavEnableSetMousePos(1 << 2),
	NavNoCaptureKeyboard(1 << 3),
	NoMouse(1 << 4),
	NoMouseCursorChange(1 << 5),
	IsSRGB(1 << 20),
	IsTouchScreen(1 << 21);

	int value;

	private ImGuiConfigFlags(int code) {
		value = code;
	}

	public ImGuiConfigFlags and(ImGuiConfigFlags otherEnum) {
		value = value | otherEnum.value;
		return this;
	}

	public int getValue() {
		return value;
	}
}
