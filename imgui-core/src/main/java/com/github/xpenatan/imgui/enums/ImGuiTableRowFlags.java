package com.github.xpenatan.imgui.enums;

public class ImGuiTableRowFlags {
	private static ImGuiTableRowFlags Custom = new ImGuiTableRowFlags(0);

	public static ImGuiTableRowFlags None = new ImGuiTableRowFlags(0);
	public static ImGuiTableRowFlags Headers = new ImGuiTableRowFlags(1 << 0);


	int value;

	private ImGuiTableRowFlags(int code) {
		value = code;
	}

	public ImGuiTableRowFlags or(ImGuiTableRowFlags otherEnum) {
		ImGuiTableRowFlags.Custom.value = value | otherEnum.value;
		return ImGuiTableRowFlags.Custom;
	}

	public int getValue() {
		return value;
	}
}
