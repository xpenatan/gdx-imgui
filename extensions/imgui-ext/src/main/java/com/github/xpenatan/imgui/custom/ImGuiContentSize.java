package com.github.xpenatan.imgui.custom;

public class ImGuiContentSize {
	public static ImGuiContentSize tmp = new ImGuiContentSize();

	public float beginPositionX;
	public float beginPositionY;

	public float endPositionX;
	public float endPositionY;

	public void reset() {
		beginPositionX = 0;
		beginPositionY = 0;
		endPositionX = 0;
		endPositionY = 0;
	}
}
