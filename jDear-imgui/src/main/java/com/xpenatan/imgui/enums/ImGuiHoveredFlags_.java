package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::IsItemHovered(), ImGui::IsWindowHovered()
 * Note: if you are trying to check whether your mouse should be dispatched to imgui or to your app, you should use the 'io.WantCaptureMouse' boolean for that. Please read the FAQ!
 * Note: windows with the ImGuiWindowFlags_NoInputs flag are ignored by IsWindowHovered() calls.
 */
public enum ImGuiHoveredFlags_ {
	ImGuiHoveredFlags_None(0),
	ImGuiHoveredFlags_ChildWindows(1 << 0),
	ImGuiHoveredFlags_RootWindow(1 << 1),
	ImGuiHoveredFlags_AnyWindow(1 << 2),
	ImGuiHoveredFlags_AllowWhenBlockedByPopup(1 << 3),
//	ImGuiHoveredFlags_AllowWhenBlockedByModal(1 << 4),
	ImGuiHoveredFlags_AllowWhenBlockedByActiveItem(1 << 5),
	ImGuiHoveredFlags_AllowWhenOverlapped(1 << 6),
	ImGuiHoveredFlags_AllowWhenDisabled(1 << 7),
	ImGuiHoveredFlags_RectOnly(ImGuiHoveredFlags_AllowWhenBlockedByPopup.getValue() | ImGuiHoveredFlags_AllowWhenBlockedByActiveItem.getValue() | ImGuiHoveredFlags_AllowWhenOverlapped.getValue()),
	ImGuiHoveredFlags_RootAndChildWindows(ImGuiHoveredFlags_RootWindow.getValue() | ImGuiHoveredFlags_ChildWindows.getValue());

	int value;

	private ImGuiHoveredFlags_(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
