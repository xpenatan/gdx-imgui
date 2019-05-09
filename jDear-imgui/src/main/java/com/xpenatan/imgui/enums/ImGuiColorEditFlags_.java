package com.xpenatan.imgui.enums;

/**
 * Enumeration for GetMouseCursor()
 * User code may request binding to display given cursor by calling SetMouseCursor(), which is why we have some cursors that are marked unused here
 */
public enum ImGuiColorEditFlags_ {
	ImGuiColorEditFlags_None(0),
	ImGuiColorEditFlags_NoAlpha(1 << 1),
	ImGuiColorEditFlags_NoPicker(1 << 2),
	ImGuiColorEditFlags_NoOptions(1 << 3),
	ImGuiColorEditFlags_NoSmallPreview(1 << 4),
	ImGuiColorEditFlags_NoInputs(1 << 5),
	ImGuiColorEditFlags_NoTooltip(1 << 6),
	ImGuiColorEditFlags_NoLabel(1 << 7),
	ImGuiColorEditFlags_NoSidePreview(1 << 8),
	ImGuiColorEditFlags_NoDragDrop(1 << 9),

	ImGuiColorEditFlags_AlphaBar(1 << 16),
	ImGuiColorEditFlags_AlphaPreview(1 << 17),
	ImGuiColorEditFlags_AlphaPreviewHalf(1 << 18),
	ImGuiColorEditFlags_HDR(1 << 19),
	ImGuiColorEditFlags_DisplayRGB(1 << 20),
	ImGuiColorEditFlags_DisplayHSV(1 << 21),
	ImGuiColorEditFlags_DisplayHex(1 << 22),
	ImGuiColorEditFlags_Uint8(1 << 23),
	ImGuiColorEditFlags_Float(1 << 24),
	ImGuiColorEditFlags_PickerHueBar(1 << 25),
	ImGuiColorEditFlags_PickerHueWheel(1 << 26),
	ImGuiColorEditFlags_InputRGB(1 << 27),
	ImGuiColorEditFlags_InputHSV(1 << 28),

	ImGuiColorEditFlags__OptionsDefault(ImGuiColorEditFlags_Uint8.getValue() | ImGuiColorEditFlags_DisplayRGB.getValue() | ImGuiColorEditFlags_InputRGB.getValue() | ImGuiColorEditFlags_PickerHueBar.getValue());

	int value;

	private ImGuiColorEditFlags_(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
