package com.github.xpenatan.imgui.enums;

public class ImGuiTableFlags {
	private static ImGuiTableFlags Custom = new ImGuiTableFlags(0);

	// Features
	public static ImGuiTableFlags None = new ImGuiTableFlags(0);
	public static ImGuiTableFlags Resizable = new ImGuiTableFlags(1 << 0);
	public static ImGuiTableFlags Reorderable = new ImGuiTableFlags(1 << 1);
	public static ImGuiTableFlags Hideable  = new ImGuiTableFlags(1 << 2);
	public static ImGuiTableFlags Sortable = new ImGuiTableFlags(1 << 3);
	public static ImGuiTableFlags MultiSortable = new ImGuiTableFlags(1 << 4);
	public static ImGuiTableFlags NoSavedSettings = new ImGuiTableFlags(1 << 5);

	// Decoration
	public static ImGuiTableFlags RowBg = new ImGuiTableFlags(1 << 6);
	public static ImGuiTableFlags BordersHInner = new ImGuiTableFlags(1 << 7);
	public static ImGuiTableFlags BordersHOuter = new ImGuiTableFlags(1 << 8);
	public static ImGuiTableFlags BordersVInner = new ImGuiTableFlags(1 << 9);
	public static ImGuiTableFlags BordersVOuter = new ImGuiTableFlags(1 << 10);
	public static ImGuiTableFlags BordersH = new ImGuiTableFlags(BordersHInner.getValue() | BordersHOuter.getValue());
	public static ImGuiTableFlags BordersV = new ImGuiTableFlags(BordersVInner.getValue() | BordersVOuter.getValue());
	public static ImGuiTableFlags BordersInner = new ImGuiTableFlags(BordersVInner.getValue() | BordersHInner.getValue());
	public static ImGuiTableFlags BordersOuter = new ImGuiTableFlags(BordersVOuter.getValue() | BordersHOuter.getValue());
	public static ImGuiTableFlags Borders = new ImGuiTableFlags(BordersInner.getValue() | BordersOuter.getValue());
	public static ImGuiTableFlags BordersVFullHeight = new ImGuiTableFlags(1 << 11);

	// Padding, Sizing
	public static ImGuiTableFlags NoClipX = new ImGuiTableFlags(1 << 12);
	public static ImGuiTableFlags SizingPolicyFixedX = new ImGuiTableFlags(1 << 13);
	public static ImGuiTableFlags SizingPolicyStretchX = new ImGuiTableFlags(1 << 14);
	public static ImGuiTableFlags NoHeadersWidth = new ImGuiTableFlags(1 << 15);
	public static ImGuiTableFlags NoHostExtendY = new ImGuiTableFlags(1 << 16);

	// Scrolling
	public static ImGuiTableFlags ScrollX = new ImGuiTableFlags(1 << 17);
	public static ImGuiTableFlags ScrollY = new ImGuiTableFlags(1 << 18);
	public static ImGuiTableFlags Scroll = new ImGuiTableFlags(ScrollX.getValue() | ScrollY.getValue());
	public static ImGuiTableFlags ScrollFreezeTopRow = new ImGuiTableFlags(1 << 19);
	public static ImGuiTableFlags ScrollFreeze2Rows = new ImGuiTableFlags(2 << 19);
	public static ImGuiTableFlags ScrollFreeze3Rows = new ImGuiTableFlags(3 << 19);
	public static ImGuiTableFlags ScrollFreezeLeftColumn = new ImGuiTableFlags(1 << 21);
	public static ImGuiTableFlags ScrollFreeze2Columns = new ImGuiTableFlags(2 << 21);
	public static ImGuiTableFlags ScrollFreeze3Columns = new ImGuiTableFlags(3 << 21);



	int value;

	private ImGuiTableFlags(int code) {
		value = code;
	}

	public ImGuiTableFlags or(ImGuiTableFlags otherEnum) {
		ImGuiTableFlags.Custom.value = value | otherEnum.value;
		return ImGuiTableFlags.Custom;
	}

	public int getValue() {
		return value;
	}
}
