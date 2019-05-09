package com.xpenatan.imgui.enums;

public enum ImGuiDir {

	ImGuiDir_None(-1),
	ImGuiDir_Left(0),
	ImGuiDir_Right(1),
	ImGuiDir_Up(2),
	ImGuiDir_Down(3),
	ImGuiDir_COUNT(4);

	private final int code;

	private ImGuiDir(int code) {
		this.code = code;
	}

	public int toInt() {
		return code;
	}
}
