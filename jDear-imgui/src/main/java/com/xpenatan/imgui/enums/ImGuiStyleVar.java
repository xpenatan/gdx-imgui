package com.xpenatan.imgui.enums;

public enum ImGuiStyleVar {
	ImGuiStyleVar_Alpha(0),
	ImGuiStyleVar_WindowPadding(1),
	ImGuiStyleVar_WindowRounding(2),
	ImGuiStyleVar_WindowBorderSize(3),
	ImGuiStyleVar_WindowMinSize(4),
	ImGuiStyleVar_WindowTitleAlign(5),
	ImGuiStyleVar_ChildRounding(6),
	ImGuiStyleVar_ChildBorderSize(7),
	ImGuiStyleVar_PopupRounding(8),
	ImGuiStyleVar_PopupBorderSize(9),
	ImGuiStyleVar_FramePadding(10),
	ImGuiStyleVar_FrameRounding(11),
	ImGuiStyleVar_FrameBorderSize(12),
	ImGuiStyleVar_ItemSpacing(13),
	ImGuiStyleVar_ItemInnerSpacing(14),
	ImGuiStyleVar_IndentSpacing(15),
	ImGuiStyleVar_ScrollbarSize(16),
	ImGuiStyleVar_ScrollbarRounding(17),
	ImGuiStyleVar_GrabMinSize(18),
	ImGuiStyleVar_GrabRounding(19),
	ImGuiStyleVar_TabRounding(20),
	ImGuiStyleVar_ButtonTextAlign(21),
	ImGuiStyleVar_SelectableTextAlign(22),
	ImGuiStyleVar_COUNT(23);

	int value;

	private ImGuiStyleVar(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
