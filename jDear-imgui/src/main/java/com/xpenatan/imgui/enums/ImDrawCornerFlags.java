package com.xpenatan.imgui.enums;

public enum ImDrawCornerFlags {
	TopLeft(1 << 0),
	TopRight(1 << 1),
	BotLeft(1 << 2),
	BotRight(1 << 3),
	Top(TopLeft.getValue() | TopRight.getValue()),
	Bot(BotLeft.getValue() | BotRight.getValue()),
	Left(TopLeft.getValue() | BotLeft.getValue()),
	Right(TopRight.getValue() | BotRight.getValue()),
	All(0xF);

	int value;

	private ImDrawCornerFlags(int code) {
		value = code;
	}

	public ImDrawCornerFlags and(ImDrawCornerFlags otherEnum) {
		value = value | otherEnum.value;
		return this;
	}

	public int getValue() {
		return value;
	}
}
