package com.xpenatan.imgui.enums;

/**
 * Back-end capabilities flags stored in io.BackendFlags. Set by imgui_impl_xxx or custom back-end.
 */
public enum ImGuiBackendFlags_ {
	ImGuiBackendFlags_None(0),
	ImGuiBackendFlags_HasGamepad(1 << 0),
	ImGuiBackendFlags_HasMouseCursors(1 << 1),
	ImGuiBackendFlags_HasSetMousePos(1 << 2);

	int value;

	private ImGuiBackendFlags_(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
