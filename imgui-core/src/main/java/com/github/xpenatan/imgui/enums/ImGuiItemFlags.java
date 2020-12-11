package com.github.xpenatan.imgui.enums;

/**
 * Flags for ImGui::PushItemFlag(...)
 */
public class ImGuiItemFlags {
	private static ImGuiItemFlags Custom = new ImGuiItemFlags(0);
	public static ImGuiItemFlags None = new ImGuiItemFlags(0);
	public static ImGuiItemFlags NoTabStop = new ImGuiItemFlags(1 << 0);
	public static ImGuiItemFlags ButtonRepeat = new ImGuiItemFlags(1 << 1);
	public static ImGuiItemFlags Disabled = new ImGuiItemFlags(1 << 2);
	public static ImGuiItemFlags NoNav = new ImGuiItemFlags(1 << 3);
	public static ImGuiItemFlags NoNavDefaultFocus = new ImGuiItemFlags(1 << 4);
	public static ImGuiItemFlags SelectableDontClosePopup = new ImGuiItemFlags(1 << 5);
	public static ImGuiItemFlags MixedValue = new ImGuiItemFlags(1 << 6);
	public static ImGuiItemFlags ReadOnly = new ImGuiItemFlags(1 << 7);

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
