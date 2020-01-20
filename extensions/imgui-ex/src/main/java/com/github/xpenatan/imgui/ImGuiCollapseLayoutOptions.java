package com.github.xpenatan.imgui;

import com.github.xpenatan.imgui.enums.ImDrawCornerFlags;

public class ImGuiCollapseLayoutOptions {
	public float paddingLeft = 2;
	public float paddingRight = 2;
	public float paddingTop = 2;
	public float paddingBottom = 2;
	public int arrowColor = ImGuiEx.colorToIntBits(0xFF, 0xFF, 0xFF, 0xFF);
	public int arrowBackgroundHoveredColor = ImGuiEx.colorToIntBits(0x77, 0x77, 0x77, 0xFF);
	public int arrowBackgroundClickedColor = ImGuiEx.colorToIntBits(0x55, 0x55, 0x55, 0xFF);
	public int frameColor = ImGuiEx.colorToIntBits(0x24, 0x24, 0x24, 0xFF);
	public int borderColor = ImGuiEx.colorToIntBits(0x40, 0x40, 0x49, 0xFF);
	public int borderRound = 4;
	public int roundingCorners = ImDrawCornerFlags.TopLeft.or(ImDrawCornerFlags.TopRight).getValue();
}
