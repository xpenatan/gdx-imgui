package com.github.xpenatan.imgui.enums;

/**
 * Flags for ImGui::Selectable()
 */
public class ImGuiSelectableFlags {
	private static ImGuiSelectableFlags Custom = new ImGuiSelectableFlags(0);
	public static ImGuiSelectableFlags None = new ImGuiSelectableFlags(0);
	public static ImGuiSelectableFlags DontClosePopups = new ImGuiSelectableFlags(1 << 0);
	public static ImGuiSelectableFlags SpanAllColumns = new ImGuiSelectableFlags(1 << 1);
	public static ImGuiSelectableFlags AllowDoubleClick = new ImGuiSelectableFlags(1 << 2);
	public static ImGuiSelectableFlags Disabled = new ImGuiSelectableFlags(1 << 3);

	int value;

	private ImGuiSelectableFlags(int code) {
		value = code;
	}

	public ImGuiSelectableFlags or(ImGuiSelectableFlags otherEnum) {
		ImGuiSelectableFlags.Custom.value = value | otherEnum.value;
		return ImGuiSelectableFlags.Custom;
	}

	public int getValue() {
		return value;
	}
}
