package com.xpenatan.imgui.enums;

/**
 * Enumateration for ImGui::SetWindow***(), SetNextWindow***(), SetNextTreeNode***() functions
 * Represent a condition.
 * Important: Treat as a regular enum! Do NOT combine multiple values using binary operators! All the functions above treat 0 as a shortcut to ImGuiCond_Always.
 */
public enum ImGuiCond_ {
	ImGuiCond_Always(1 << 0),
	ImGuiCond_Once(1 << 1),
	ImGuiCond_FirstUseEver(1 << 2),
	ImGuiCond_Appearing(1 << 3);

	int value;

	private ImGuiCond_(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
