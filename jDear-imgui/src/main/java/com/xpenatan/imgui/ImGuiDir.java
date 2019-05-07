package com.xpenatan.imgui;

public enum ImGuiDir {

	ImGuiDir_None(-1), ImGuiDir_Left(0), ImGuiDir_Right(1), ImGuiDir_Up(2), ImGuiDir_Down(3);

	private final int code;

	private ImGuiDir(int code) {
		this.code = code;
	}

	public int toInt() {
		return code;
	}
}
