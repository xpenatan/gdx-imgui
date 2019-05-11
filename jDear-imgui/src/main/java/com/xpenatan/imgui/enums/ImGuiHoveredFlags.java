package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::IsItemHovered(), ImGui::IsWindowHovered()
 * Note: if you are trying to check whether your mouse should be dispatched to imgui or to your app, you should use the 'io.WantCaptureMouse' boolean for that. Please read the FAQ!
 * Note: windows with the ImGuiWindowFlags_NoInputs flag are ignored by IsWindowHovered() calls.
 */
public enum ImGuiHoveredFlags {
	None(0),
	ChildWindows(1 << 0),
	RootWindow(1 << 1),
	AnyWindow(1 << 2),
	AllowWhenBlockedByPopup(1 << 3),
//	AllowWhenBlockedByModal(1 << 4),
	AllowWhenBlockedByActiveItem(1 << 5),
	AllowWhenOverlapped(1 << 6),
	AllowWhenDisabled(1 << 7),
	RectOnly(AllowWhenBlockedByPopup.getValue() | AllowWhenBlockedByActiveItem.getValue() | AllowWhenOverlapped.getValue()),
	RootAndChildWindows(RootWindow.getValue() | ChildWindows.getValue());

	int value;

	private ImGuiHoveredFlags(int code) {
		value = code;
	}

	public ImGuiHoveredFlags and(ImGuiHoveredFlags otherEnum) {
		value = value | otherEnum.value;
		return this;
	}

	public int getValue() {
		return value;
	}
}
