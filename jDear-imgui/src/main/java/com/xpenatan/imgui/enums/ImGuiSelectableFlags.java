package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::Selectable()
 */
public enum ImGuiSelectableFlags {
	None(0),
	DontClosePopups(1 << 0),
	SpanAllColumns(1 << 1),
	AllowDoubleClick(1 << 2),
	Disabled(1 << 3);

	int value;

	private ImGuiSelectableFlags(int code) {
		value = code;
	}

	public ImGuiSelectableFlags and(ImGuiSelectableFlags otherEnum) {
		value = value | otherEnum.value;
		return this;
	}

	public int getValue() {
		return value;
	}
}
