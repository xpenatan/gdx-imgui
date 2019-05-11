package com.xpenatan.imgui.enums;

/**
 * Back-end capabilities flags stored in io.BackendFlags. Set by imgui_impl_xxx or custom back-end.
 */
public enum ImGuiBackendFlags {
	None(0),
	HasGamepad(1 << 0),
	HasMouseCursors(1 << 1),
	HasSetMousePos(1 << 2);

	int value;

	private ImGuiBackendFlags(int code) {
		value = code;
	}

	public ImGuiBackendFlags and(ImGuiBackendFlags otherEnum) {
		value = value | otherEnum.value;
		return this;
	}

	public int getValue() {
		return value;
	}
}
