package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::IsWindowFocused()
 */
public enum ImGuiFocusedFlags {
	None(0),
	ChildWindows(1 << 0),
	RootWindow(1 << 1),
	AnyWindow(1 << 2),
	RootAndChildWindows(RootWindow.getValue() | ChildWindows.getValue());

	int value;

	private ImGuiFocusedFlags(int code) {
		value = code;
	}

	public ImGuiFocusedFlags and(ImGuiFocusedFlags otherEnum) {
		value = value | otherEnum.value;
		return this;
	}

	public int getValue() {
		return value;
	}
}
