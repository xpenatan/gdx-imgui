package com.github.xpenatan.imgui.enums;

public enum ImGuiStyleVar {
	Alpha(0),
	WindowPadding(1),
	WindowRounding(2),
	WindowBorderSize(3),
	WindowMinSize(4),
	WindowTitleAlign(5),
	ChildRounding(6),
	ChildBorderSize(7),
	PopupRounding(8),
	PopupBorderSize(9),
	FramePadding(10),
	FrameRounding(11),
	ImGuiStyleVar_FrameBorderSize(12),
	ItemSpacing(13),
	ItemInnerSpacing(14),
	IndentSpacing(15),
	ScrollbarSize(16),
	ScrollbarRounding(17),
	GrabMinSize(18),
	GrabRounding(19),
	TabRounding(20),
	ButtonTextAlign(21),
	SelectableTextAlign(22),
	COUNT(23);

	int value;

	private ImGuiStyleVar(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
