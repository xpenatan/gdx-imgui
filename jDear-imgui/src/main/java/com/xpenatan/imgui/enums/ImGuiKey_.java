package com.xpenatan.imgui.enums;

/**
 * User fill ImGuiIO.KeyMap[] array with indices into the ImGuiIO.KeysDown[512] array
 */
public enum ImGuiKey_ {
	ImGuiKey_Tab(0),
	ImGuiKey_LeftArrow(1),
	ImGuiKey_RightArrow(2),
	ImGuiKey_UpArrow(3),
	ImGuiKey_DownArrow(4),
	ImGuiKey_PageUp(5),
	ImGuiKey_PageDown(6),
	ImGuiKey_Home(7),
	ImGuiKey_End(8),
	ImGuiKey_Insert(9),
	ImGuiKey_Delete(10),
	ImGuiKey_Backspace(11),
	ImGuiKey_Space(12),
	ImGuiKey_Enter(13),
	ImGuiKey_Escape(14),
	ImGuiKey_A(15),
	ImGuiKey_C(16),
	ImGuiKey_V(17),
	ImGuiKey_X(18),
	ImGuiKey_Y(19),
	ImGuiKey_Z(20),
	ImGuiKey_COUNT(21);

	private final int code;

	private ImGuiKey_(int code) {
		this.code = code;
	}

	public int toInt() {
		return code;
	}
}
