package com.xpenatan.imgui.enums;

public enum ImGuiCol {
	Text(0),
	TextDisabled(1),
	/** Background of normal windows */
	WindowBg(2),
	/** Background of child windows */
	ChildBg(3),
	/** Background of popups, menus, tooltips windows */
	PopupBg(4),
	Border(5),
	BorderShadow(6),
	/** Background of checkbox, radio button, plot, slider, text input */
	FrameBg(7),
	FrameBgHovered(8),
	FrameBgActive(9),
	TitleBg(10),
	TitleBgActive(11),
	TitleBgCollapsed(12),
	MenuBarBg(13),
	ScrollbarBg(14),
	ScrollbarGrab(15),
	ScrollbarGrabHovered(16),
	ScrollbarGrabActive(17),
	CheckMark(18),
	SliderGrab(19),
	SliderGrabActive(20),
	Button(21),
	ButtonHovered(22),
	ButtonActive(23),
	Header(24),
	HeaderHovered(25),
	HeaderActive(26),
	Separator(27),
	SeparatorHovered(28),
	SeparatorActive(29),
	ResizeGrip(30),
	ResizeGripHovered(31),
	ResizeGripActive(32),
	Tab(33),
	TabHovered(34),
	TabActive(35),
	TabUnfocused(36),
	TabUnfocusedActive(37),
	PlotLines(38),
	PlotLinesHovered(39),
	PlotHistogram(40),
	PlotHistogramHovered(41),
	TextSelectedBg(42),
	DragDropTarget(43),
	/** Gamepad/keyboard: current highlighted item */
	NavHighlight(44),
	/** Highlight window when using CTRL+TAB */
	NavWindowingHighlight(45),
	/** Darken/colorize entire screen behind the CTRL+TAB window list, when active */
	NavWindowingDimBg(46),
	/** Darken/colorize entire screen behind a modal window, when one is active */
	ModalWindowDimBg(47),
	COUNT(48);

	int value;

	private ImGuiCol(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
