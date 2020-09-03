package com.github.xpenatan.imgui.enums;

/**
 * Flags for ImGui::PushItemFlag(...)
 */
public class ImGuiItemFlags {
	private static ImGuiItemFlags Custom = new ImGuiItemFlags(0);
	public static ImGuiItemFlags None = new ImGuiItemFlags(0);
	public static ImGuiItemFlags Disabled = new ImGuiItemFlags(1 << 2);

	int value;

	private ImGuiItemFlags(int code) {
		value = code;
	}

	public ImGuiItemFlags or(ImGuiItemFlags otherEnum) {
		ImGuiItemFlags.Custom.value = value | otherEnum.value;
		return ImGuiItemFlags.Custom;
	}

	public int getValue() {
		return value;
	}
}
