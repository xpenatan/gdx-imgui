package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::IsWindowFocused()
 */
public enum ImGuiFocusedFlags_ {
	ImGuiFocusedFlags_None(0),
	ImGuiFocusedFlags_ChildWindows(1 << 0),
	ImGuiFocusedFlags_RootWindow(1 << 1),
	ImGuiFocusedFlags_AnyWindow(1 << 2),
	ImGuiFocusedFlags_RootAndChildWindows(ImGuiFocusedFlags_RootWindow.getValue() | ImGuiFocusedFlags_ChildWindows.getValue());

	int value;

	private ImGuiFocusedFlags_(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
