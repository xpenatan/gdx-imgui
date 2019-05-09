package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::Begin()
 */
public enum ImGuiWindowFlags_ {
	ImGuiWindowFlags_None(0),
	ImGuiWindowFlags_NoTitleBar(1 << 0),
	ImGuiWindowFlags_NoResize(1 << 1),
	ImGuiWindowFlags_NoMove(1 << 2),
	ImGuiWindowFlags_NoScrollbar(1 << 3),
	ImGuiWindowFlags_NoScrollWithMouse(1 << 4),
	ImGuiWindowFlags_NoCollapse(1 << 5),
	ImGuiWindowFlags_AlwaysAutoResize(1 << 6),
	ImGuiWindowFlags_NoBackground(1 << 7),
	ImGuiWindowFlags_NoSavedSettings(1 << 8),
	ImGuiWindowFlags_NoMouseInputs(1 << 9),
	ImGuiWindowFlags_MenuBar(1 << 10),
	ImGuiWindowFlags_HorizontalScrollbar(1 << 11),
	ImGuiWindowFlags_NoFocusOnAppearing(1 << 12),
	ImGuiWindowFlags_NoBringToFrontOnFocus(1 << 13),
	ImGuiWindowFlags_AlwaysVerticalScrollbar(1 << 14),
	ImGuiWindowFlags_AlwaysHorizontalScrollbar(1 << 15),
	ImGuiWindowFlags_AlwaysUseWindowPadding(1 << 16),
	ImGuiWindowFlags_NoNavInputs(1 << 17),
	ImGuiWindowFlags_NoNavFocus(1 << 18),
	ImGuiWindowFlags_UnsavedDocument(1 << 19),
	ImGuiWindowFlags_NoNav(ImGuiWindowFlags_NoNavInputs.getValue() | ImGuiWindowFlags_NoNavFocus.getValue()),
	ImGuiWindowFlags_NoDecoration(ImGuiWindowFlags_NoTitleBar.getValue() | ImGuiWindowFlags_NoResize.getValue() | ImGuiWindowFlags_NoScrollbar.getValue() | ImGuiWindowFlags_NoCollapse.getValue()),
	ImGuiWindowFlags_NoInputs(ImGuiWindowFlags_NoMouseInputs.getValue() | ImGuiWindowFlags_NoNavInputs.getValue() | ImGuiWindowFlags_NoNavFocus.getValue());

	int value;

	private ImGuiWindowFlags_(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
