package com.github.xpenatan.imgui.enums;

public class ImDrawFlags {
	private static ImDrawFlags Custom = new ImDrawFlags(0);
	public static ImDrawFlags Closed = new ImDrawFlags(1 << 0);
	public static ImDrawFlags RoundCornersTopLeft = new ImDrawFlags(1 << 4);
	public static ImDrawFlags RoundCornersTopRight = new ImDrawFlags(1 << 5);
	public static ImDrawFlags RoundCornersBottomLeft = new ImDrawFlags(1 << 6);
	public static ImDrawFlags RoundCornersBottomRight = new ImDrawFlags(1 << 7);
	public static ImDrawFlags RoundCornersNone = new ImDrawFlags(1 << 8);
	public static ImDrawFlags RoundCornersTop = new ImDrawFlags(RoundCornersTopLeft.getValue() | RoundCornersTopRight.getValue());
	public static ImDrawFlags RoundCornersBottom = new ImDrawFlags(RoundCornersBottomLeft.getValue() | RoundCornersBottomRight.getValue());
	public static ImDrawFlags RoundCornersLeft = new ImDrawFlags(RoundCornersBottomLeft.getValue() | RoundCornersTopLeft.getValue());
	public static ImDrawFlags RoundCornersRight = new ImDrawFlags(RoundCornersBottomRight.getValue() | RoundCornersTopRight.getValue());
	public static ImDrawFlags RoundCornersAll = new ImDrawFlags(RoundCornersTopLeft.getValue() | RoundCornersTopRight.getValue() | RoundCornersBottomLeft.getValue() | RoundCornersBottomRight.getValue());
	public static ImDrawFlags RoundCornersDefault_ = new ImDrawFlags(RoundCornersAll.getValue());
	public static ImDrawFlags RoundCornersMask_ = new ImDrawFlags(RoundCornersAll.getValue() | RoundCornersNone.getValue());

	int value;

	private ImDrawFlags(int code) {
		value = code;
	}

	public ImDrawFlags or(ImDrawFlags otherEnum) {
		ImDrawFlags.Custom.value = value | otherEnum.value;
		return ImDrawFlags.Custom;
	}

	public int getValue() {
		return value;
	}
}
