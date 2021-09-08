package com.github.xpenatan.imgui.enums;

public enum ImGuiStyleVar {
	Alpha(0),                // float     Alpha
	WindowPadding(1),        // ImVec2    WindowPadding
	WindowRounding(2),       // float     WindowRounding
	WindowBorderSize(3),     // float     WindowBorderSize
	WindowMinSize(4),        // ImVec2    WindowMinSize
	WindowTitleAlign(5),     // ImVec2    WindowTitleAlign
	ChildRounding(6),        // float     ChildRounding
	ChildBorderSize(7),      // float     ChildBorderSize
	PopupRounding(8),        // float     PopupRounding
	PopupBorderSize(9),      // float     PopupBorderSize
	FramePadding(10),        // ImVec2    FramePadding
	FrameRounding(11),       // float     FrameRounding
	FrameBorderSize(12),     // float     FrameBorderSize
	ItemSpacing(13),         // ImVec2    ItemSpacing
	ItemInnerSpacing(14),    // ImVec2    ItemInnerSpacing
	IndentSpacing(15),       // float     IndentSpacing
	CellPadding(16),         // ImVec2    CellPadding
	ScrollbarSize(17),       // float     ScrollbarSize
	ScrollbarRounding(18),   // float     ScrollbarRounding
	GrabMinSize(19),         // float     GrabMinSize
	GrabRounding(20),        // float     GrabRounding
	TabRounding(21),         // float     TabRounding
	ButtonTextAlign(22),     // ImVec2    ButtonTextAlign
	SelectableTextAlign(23), // ImVec2    SelectableTextAlign
	COUNT(24);

	int value;

	private ImGuiStyleVar(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
