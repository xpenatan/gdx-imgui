package com.xpenatan.imgui.enums;

/**
 * Enumeration for GetMouseCursor()
 * User code may request binding to display given cursor by calling SetMouseCursor(), which is why we have some cursors that are marked unused here
 */
public enum ImGuiColorEditFlags {
	None(0),
	NoAlpha(1 << 1),
	NoPicker(1 << 2),
	NoOptions(1 << 3),
	NoSmallPreview(1 << 4),
	NoInputs(1 << 5),
	NoTooltip(1 << 6),
	NoLabel(1 << 7),
	NoSidePreview(1 << 8),
	NoDragDrop(1 << 9),

	AlphaBar(1 << 16),
	AlphaPreview(1 << 17),
	AlphaPreviewHalf(1 << 18),
	HDR(1 << 19),
	DisplayRGB(1 << 20),
	DisplayHSV(1 << 21),
	DisplayHex(1 << 22),
	Uint8(1 << 23),
	Float(1 << 24),
	PickerHueBar(1 << 25),
	PickerHueWheel(1 << 26),
	InputRGB(1 << 27),
	InputHSV(1 << 28),

	OptionsDefault(Uint8.getValue() | DisplayRGB.getValue() | InputRGB.getValue() | PickerHueBar.getValue());

	int value;

	private ImGuiColorEditFlags(int code) {
		value = code;
	}

	public ImGuiColorEditFlags and(ImGuiColorEditFlags otherEnum) {
		value = value | otherEnum.value;
		return this;
	}

	public int getValue() {
		return value;
	}
}
