package com.xpenatan.imgui.enums;

/**
 * Gamepad/Keyboard directional navigation
 * Keyboard: Set io.ConfigFlags |= ImGuiConfigFlags_NavEnableKeyboard to enable. NewFrame() will automatically fill io.NavInputs[] based on your io.KeysDown[] + io.KeyMap[] arrays.
 * Gamepad:  Set io.ConfigFlags |= ImGuiConfigFlags_NavEnableGamepad to enable. Back-end: set ImGuiBackendFlags_HasGamepad and fill the io.NavInputs[] fields before calling NewFrame(). Note that io.NavInputs[] is cleared by EndFrame().
 * Read instructions in imgui.cpp for more details. Download PNG/PSD at http://goo.gl/9LgVZW.
 **/
public enum ImGuiNavInput_ {
	ImGuiNavInput_Activate(0),
	ImGuiNavInput_Cancel(1),
	ImGuiNavInput_Input(2),
	ImGuiNavInput_Menu(3),
	ImGuiNavInput_DpadLeft(4),
	ImGuiNavInput_DpadRight(5),
	ImGuiNavInput_DpadUp(6),
	ImGuiNavInput_DpadDown(7),
	ImGuiNavInput_LStickLeft(8),
	ImGuiNavInput_LStickRight(9),
	ImGuiNavInput_LStickUp(10),
	ImGuiNavInput_LStickDown(11),
	ImGuiNavInput_FocusPrev(12),
	ImGuiNavInput_FocusNext(13),
	ImGuiNavInput_TweakSlow(14),
	ImGuiNavInput_TweakFast(15);

	private final int code;

	private ImGuiNavInput_(int code) {
		this.code = code;
	}

	public int toInt() {
		return code;
	}
}
