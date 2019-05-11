package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::BeginTabItem()
 */
public enum ImGuiTabItemFlags {
	ImGuiTabItemFlags_None(0),
	ImGuiTabItemFlags_UnsavedDocument(1 << 0),
	ImGuiTabItemFlags_SetSelected(1 << 1),
	ImGuiTabItemFlags_NoCloseWithMiddleMouseButton(1 << 2),
	ImGuiTabItemFlags_NoPushId(1 << 3);

	int value;

	private ImGuiTabItemFlags(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
