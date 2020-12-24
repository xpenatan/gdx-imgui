package com.github.xpenatan.imgui.enums;

/**
 * User fill ImGuiIO.KeyMap[] array with indices into the ImGuiIO.KeysDown[512] array
 */
public enum ImGuiKey {
	Tab(0),
	LeftArrow(1),
	RightArrow(2),
	UpArrow(3),
	DownArrow(4),
	PageUp(5),
	PageDown(6),
	Home(7),
	End(8),
	Insert(9),
	Delete(10),
	Backspace(11),
	Space(12),
	Enter(13),
	Escape(14),
	KeyPadEnter(15),
	A(16),
	C(17),
	V(18),
	X(19),
	Y(20),
	Z(21),
	COUNT(22);

	private final int code;

	private ImGuiKey(int code) {
		this.code = code;
	}

	public int getValue() {
		return code;
	}
}
