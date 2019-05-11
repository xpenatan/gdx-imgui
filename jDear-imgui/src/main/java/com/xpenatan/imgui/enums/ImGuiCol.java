package com.xpenatan.imgui.enums;

public enum ImGuiCol {
	ImGuiCol_Text(0),
	ImGuiCol_TextDisabled(1),
	/** Background of normal windows */
	ImGuiCol_WindowBg(2),
	/** Background of child windows */
	ImGuiCol_ChildBg(3),
	/** Background of popups, menus, tooltips windows */
	ImGuiCol_PopupBg(4),
	ImGuiCol_Border(5),
	ImGuiCol_BorderShadow(6),
	/** Background of checkbox, radio button, plot, slider, text input */
	ImGuiCol_FrameBg(7),
	ImGuiCol_FrameBgHovered(8),
	ImGuiCol_FrameBgActive(9),
	ImGuiCol_TitleBg(10),
	ImGuiCol_TitleBgActive(11),
	ImGuiCol_TitleBgCollapsed(12),
	ImGuiCol_MenuBarBg(13),
	ImGuiCol_ScrollbarBg(14),
	ImGuiCol_ScrollbarGrab(15),
	ImGuiCol_ScrollbarGrabHovered(16),
	ImGuiCol_ScrollbarGrabActive(17),
	ImGuiCol_CheckMark(18),
	ImGuiCol_SliderGrab(19),
	ImGuiCol_SliderGrabActive(20),
	ImGuiCol_Button(21),
	ImGuiCol_ButtonHovered(22),
	ImGuiCol_ButtonActive(23),
	ImGuiCol_Header(24),
	ImGuiCol_HeaderHovered(25),
	ImGuiCol_HeaderActive(26),
	ImGuiCol_Separator(27),
	ImGuiCol_SeparatorHovered(28),
	ImGuiCol_SeparatorActive(29),
	ImGuiCol_ResizeGrip(30),
	ImGuiCol_ResizeGripHovered(31),
	ImGuiCol_ResizeGripActive(32),
	ImGuiCol_Tab(33),
	ImGuiCol_TabHovered(34),
	ImGuiCol_TabActive(35),
	ImGuiCol_TabUnfocused(36),
	ImGuiCol_TabUnfocusedActive(37),
	ImGuiCol_PlotLines(38),
	ImGuiCol_PlotLinesHovered(39),
	ImGuiCol_PlotHistogram(40),
	ImGuiCol_PlotHistogramHovered(41),
	ImGuiCol_TextSelectedBg(42),
	ImGuiCol_DragDropTarget(43),
	/** Gamepad/keyboard: current highlighted item */
	ImGuiCol_NavHighlight(44),
	/** Highlight window when using CTRL+TAB */
	ImGuiCol_NavWindowingHighlight(45),
	/** Darken/colorize entire screen behind the CTRL+TAB window list, when active */
	ImGuiCol_NavWindowingDimBg(46),
	/** Darken/colorize entire screen behind a modal window, when one is active */
	ImGuiCol_ModalWindowDimBg(47),
	ImGuiCol_COUNT(48);

	int value;

	private ImGuiCol(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
