package com.xpenatan.imgui.enums;

/**
 * Enumateration for ImGui::SetWindow***(), SetNextWindow***(), SetNextTreeNode***() functions
 * Represent a condition.
 * Important: Treat as a regular enum! Do NOT combine multiple values using binary operators! All the functions above treat 0 as a shortcut to ImGuiCond_Always.
 */
public enum ImGuiCond {
	Always(1 << 0),
	Once(1 << 1),
	FirstUseEver(1 << 2),
	Appearing(1 << 3);

	int value;

	private ImGuiCond(int code) {
		value = code;
	}

	public ImGuiCond and(ImGuiCond otherEnum) {
		value = value | otherEnum.value;
		return this;
	}

	public int getValue() {
		return value;
	}
}
