package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::BeginCombo()
 */
public enum ImGuiComboFlags {
	None(0),
	PopupAlignLeft(1 << 0),
	HeightSmall(1 << 1),
	HeightRegular(1 << 2),
	HeightLarge(1 << 3),
	HeightLargest(1 << 4),
	NoArrowButton(1 << 5),
	NoPreview(1 << 6),
	HeightMask(HeightSmall.getValue() | HeightRegular.getValue() | HeightLarge.getValue() | HeightLargest.getValue());

	int value;

	private ImGuiComboFlags(int code) {
		value = code;
	}

	public ImGuiComboFlags and(ImGuiComboFlags otherEnum) {
		value = value | otherEnum.value;
		return this;
	}

	public int getValue() {
		return value;
	}
}
