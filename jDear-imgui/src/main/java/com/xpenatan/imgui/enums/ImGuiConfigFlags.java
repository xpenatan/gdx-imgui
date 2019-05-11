package com.xpenatan.imgui.enums;

/**
 * Configuration flags stored in io.ConfigFlags. Set by user/application.
 */
public enum ImGuiConfigFlags {
	ImGuiConfigFlags_None(0),
	ImGuiConfigFlags_NavEnableKeyboard(1 << 0),
	ImGuiConfigFlags_NavEnableGamepad(1 << 1),
	ImGuiConfigFlags_NavEnableSetMousePos(1 << 2),
	ImGuiConfigFlags_NavNoCaptureKeyboard(1 << 3),
	ImGuiConfigFlags_NoMouse(1 << 4),
	ImGuiConfigFlags_NoMouseCursorChange(1 << 5),
	ImGuiConfigFlags_IsSRGB(1 << 20),
	ImGuiConfigFlags_IsTouchScreen(1 << 21);

	int value;

	private ImGuiConfigFlags(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
