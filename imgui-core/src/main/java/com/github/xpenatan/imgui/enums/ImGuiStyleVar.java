package com.github.xpenatan.imgui.enums;

public enum ImGuiStyleVar {
	Alpha(0),               // float     Alpha
	DisabledAlpha(1),       // float     DisabledAlpha
	WindowPadding(2),       // ImVec2    WindowPadding
	WindowRounding(3),      // float     WindowRounding
	WindowBorderSize(4),    // float     WindowBorderSize
	WindowMinSize(5),       // ImVec2    WindowMinSize
	WindowTitleAlign(6),    // ImVec2    WindowTitleAlign
	ChildRounding(7),       // float     ChildRounding
	ChildBorderSize(8),     // float     ChildBorderSize
	PopupRounding(9),       // float     PopupRounding
	PopupBorderSize(10),     // float     PopupBorderSize
	FramePadding(11),        // ImVec2    FramePadding
	FrameRounding(12),       // float     FrameRounding
	FrameBorderSize(13),     // float     FrameBorderSize
	ItemSpacing(14),         // ImVec2    ItemSpacing
	ItemInnerSpacing(15),    // ImVec2    ItemInnerSpacing
	IndentSpacing(16),       // float     IndentSpacing
	CellPadding(17),         // ImVec2    CellPadding
	ScrollbarSize(18),       // float     ScrollbarSize
	ScrollbarRounding(19),   // float     ScrollbarRounding
	GrabMinSize(20),         // float     GrabMinSize
	GrabRounding(21),        // float     GrabRounding
	TabRounding(22),         // float     TabRounding
	ButtonTextAlign(23),     // ImVec2    ButtonTextAlign
	SelectableTextAlign(24), // ImVec2    SelectableTextAlign
	COUNT(25);

	int value;

	private ImGuiStyleVar(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
