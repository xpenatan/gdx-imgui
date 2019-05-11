package com.xpenatan.imgui.enums;

public enum ImDrawCornerFlags {
	ImDrawCornerFlags_TopLeft(1 << 0),
	ImDrawCornerFlags_TopRight(1 << 1),
	ImDrawCornerFlags_BotLeft(1 << 2),
	ImDrawCornerFlags_BotRight(1 << 3),
	ImDrawCornerFlags_Top(ImDrawCornerFlags_TopLeft.getValue() | ImDrawCornerFlags_TopRight.getValue()),
	ImDrawCornerFlags_Bot(ImDrawCornerFlags_BotLeft.getValue() | ImDrawCornerFlags_BotRight.getValue()),
	ImDrawCornerFlags_Left(ImDrawCornerFlags_TopLeft.getValue() | ImDrawCornerFlags_BotLeft.getValue()),
	ImDrawCornerFlags_Right(ImDrawCornerFlags_TopRight.getValue() | ImDrawCornerFlags_BotRight.getValue()),
	ImDrawCornerFlags_All(0xF);

	int value;

	private ImDrawCornerFlags(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
