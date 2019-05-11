package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::Begin()
 */
public enum ImGuiWindowFlags {
	None(0),
	NoTitleBar(1 << 0),
	NoResize(1 << 1),
	NoMove(1 << 2),
	NoScrollbar(1 << 3),
	NoScrollWithMouse(1 << 4),
	NoCollapse(1 << 5),
	AlwaysAutoResize(1 << 6),
	NoBackground(1 << 7),
	NoSavedSettings(1 << 8),
	NoMouseInputs(1 << 9),
	MenuBar(1 << 10),
	HorizontalScrollbar(1 << 11),
	NoFocusOnAppearing(1 << 12),
	NoBringToFrontOnFocus(1 << 13),
	AlwaysVerticalScrollbar(1 << 14),
	AlwaysHorizontalScrollbar(1 << 15),
	AlwaysUseWindowPadding(1 << 16),
	NoNavInputs(1 << 17),
	NoNavFocus(1 << 18),
	UnsavedDocument(1 << 19),
	NoNav(NoNavInputs.getValue() | NoNavFocus.getValue()),
	NoDecoration(NoTitleBar.getValue() | NoResize.getValue() | NoScrollbar.getValue() | NoCollapse.getValue()),
	NoInputs(NoMouseInputs.getValue() | NoNavInputs.getValue() | NoNavFocus.getValue());

	int value;

	private ImGuiWindowFlags(int code) {
		value = code;
	}

	public ImGuiWindowFlags and(ImGuiWindowFlags otherEnum) {
		value = value | otherEnum.value;
		return this;
	}

	public int getValue() {
		return value;
	}
}
