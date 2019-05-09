package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::BeginCombo()
 */
public enum ImGuiComboFlags_ {
	ImGuiComboFlags_None(0),
	ImGuiComboFlags_PopupAlignLeft(1 << 0),
	ImGuiComboFlags_HeightSmall(1 << 1),
	ImGuiComboFlags_HeightRegular(1 << 2),
	ImGuiComboFlags_HeightLarge(1 << 3),
	ImGuiComboFlags_HeightLargest(1 << 4),
	ImGuiComboFlags_NoArrowButton(1 << 5),
	ImGuiComboFlags_NoPreview(1 << 6),
	ImGuiComboFlags_HeightMask_(ImGuiComboFlags_HeightSmall.getValue() | ImGuiComboFlags_HeightRegular.getValue() | ImGuiComboFlags_HeightLarge.getValue() | ImGuiComboFlags_HeightLargest.getValue());

	int value;

	private ImGuiComboFlags_(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
