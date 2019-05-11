package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::BeginTabBar()
 */
public enum ImGuiTabBarFlags {
	ImGuiTabBarFlags_None(0),
	ImGuiTabBarFlags_Reorderable(1 << 0),
	ImGuiTabBarFlags_AutoSelectNewTabs(1 << 1),
	ImGuiTabBarFlags_TabListPopupButton(1 << 2),
	ImGuiTabBarFlags_NoCloseWithMiddleMouseButton(1 << 3),
	ImGuiTabBarFlags_NoTabListScrollingButtons(1 << 4),
	ImGuiTabBarFlags_NoTooltip(1 << 5),
	ImGuiTabBarFlags_FittingPolicyResizeDown(1 << 6),
	ImGuiTabBarFlags_FittingPolicyScroll(1 << 7),
	ImGuiTabBarFlags_FittingPolicyMask_(ImGuiTabBarFlags_FittingPolicyResizeDown.getValue() | ImGuiTabBarFlags_FittingPolicyScroll.getValue()),
	ImGuiTabBarFlags_FittingPolicyDefault_(ImGuiTabBarFlags_FittingPolicyResizeDown.getValue());

	int value;

	private ImGuiTabBarFlags(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
