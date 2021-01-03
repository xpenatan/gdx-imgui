package com.github.xpenatan.imgui.enums;

public class ImGuiTableColumnFlags {
	private static ImGuiTableColumnFlags Custom = new ImGuiTableColumnFlags(0);

	public static ImGuiTableColumnFlags None = new ImGuiTableColumnFlags(0);
	public static ImGuiTableColumnFlags DefaultHide = new ImGuiTableColumnFlags(1 << 0);
	public static ImGuiTableColumnFlags DefaultSort = new ImGuiTableColumnFlags(1 << 1);
	public static ImGuiTableColumnFlags WidthStretch = new ImGuiTableColumnFlags(1 << 2);
	public static ImGuiTableColumnFlags WidthFixed  = new ImGuiTableColumnFlags(1 << 3);
	public static ImGuiTableColumnFlags WidthAuto = new ImGuiTableColumnFlags(1 << 4);
	public static ImGuiTableColumnFlags NoResize = new ImGuiTableColumnFlags(1 << 5);
	public static ImGuiTableColumnFlags NoReorder = new ImGuiTableColumnFlags(1 << 6);
	public static ImGuiTableColumnFlags NoHide = new ImGuiTableColumnFlags(1 << 7);
	public static ImGuiTableColumnFlags NoClip = new ImGuiTableColumnFlags(1 << 8);
	public static ImGuiTableColumnFlags NoSort = new ImGuiTableColumnFlags(1 << 9);
	public static ImGuiTableColumnFlags NoSortAscending = new ImGuiTableColumnFlags(1 << 10);
	public static ImGuiTableColumnFlags NoSortDescending = new ImGuiTableColumnFlags(1 << 11);
	public static ImGuiTableColumnFlags NoHeaderWidth = new ImGuiTableColumnFlags(1 << 12);
	public static ImGuiTableColumnFlags PreferSortAscending = new ImGuiTableColumnFlags(1 << 13);
	public static ImGuiTableColumnFlags PreferSortDescending = new ImGuiTableColumnFlags(1 << 14);
	public static ImGuiTableColumnFlags IndentEnable = new ImGuiTableColumnFlags(1 << 15);
	public static ImGuiTableColumnFlags IndentDisable = new ImGuiTableColumnFlags(1 << 16);

	public static ImGuiTableColumnFlags IsEnabled = new ImGuiTableColumnFlags(1 << 20);
	public static ImGuiTableColumnFlags IsVisible = new ImGuiTableColumnFlags(1 << 21);
	public static ImGuiTableColumnFlags IsSorted = new ImGuiTableColumnFlags(1 << 22);
	public static ImGuiTableColumnFlags IsHovered = new ImGuiTableColumnFlags(1 << 23);

	int value;

	private ImGuiTableColumnFlags(int code) {
		value = code;
	}

	public ImGuiTableColumnFlags or(ImGuiTableColumnFlags otherEnum) {
		ImGuiTableColumnFlags.Custom.value = value | otherEnum.value;
		return ImGuiTableColumnFlags.Custom;
	}

	public int getValue() {
		return value;
	}
}
