package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::Selectable()
 */
public enum ImGuiSelectableFlags {
	ImGuiSelectableFlags_None(0),
	ImGuiSelectableFlags_DontClosePopups(1 << 0),
	ImGuiSelectableFlags_SpanAllColumns(1 << 1),
	ImGuiSelectableFlags_AllowDoubleClick(1 << 2),
	ImGuiSelectableFlags_Disabled(1 << 3);

	int value;

	private ImGuiSelectableFlags(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
