package com.xpenatan.imgui.enums;

/**
 * Enumeration for GetMouseCursor()
 * User code may request binding to display given cursor by calling SetMouseCursor(), which is why we have some cursors that are marked unused here
 */
public enum ImGuiMouseCursor_ {
	ImGuiMouseCursor_None(-1),
	ImGuiMouseCursor_Arrow(0),
	ImGuiMouseCursor_TextInput(1),
	ImGuiMouseCursor_ResizeAll(2),
	ImGuiMouseCursor_ResizeNS(3),
	ImGuiMouseCursor_ResizeEW(4),
	ImGuiMouseCursor_ResizeNESW(5),
	ImGuiMouseCursor_ResizeNWSE(6),
	ImGuiMouseCursor_Hand(7),
	ImGuiMouseCursor_COUNT(8);

	int value;

	private ImGuiMouseCursor_(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
