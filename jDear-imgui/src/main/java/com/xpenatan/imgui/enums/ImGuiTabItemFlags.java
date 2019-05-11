package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::BeginTabItem()
 */
public enum ImGuiTabItemFlags {
	None(0),
	UnsavedDocument(1 << 0),
	SetSelected(1 << 1),
	NoCloseWithMiddleMouseButton(1 << 2),
	NoPushId(1 << 3);

	int value;

	private ImGuiTabItemFlags(int code) {
		value = code;
	}

	public ImGuiTabItemFlags and(ImGuiTabItemFlags otherEnum) {
		value = value | otherEnum.value;
		return this;
	}

	public int getValue() {
		return value;
	}
}
