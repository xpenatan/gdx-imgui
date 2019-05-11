package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::BeginTabBar()
 */
public enum ImGuiTabBarFlags {
	None(0),
	Reorderable(1 << 0),
	AutoSelectNewTabs(1 << 1),
	TabListPopupButton(1 << 2),
	NoCloseWithMiddleMouseButton(1 << 3),
	NoTabListScrollingButtons(1 << 4),
	NoTooltip(1 << 5),
	FittingPolicyResizeDown(1 << 6),
	FittingPolicyScroll(1 << 7),
	FittingPolicyMask(FittingPolicyResizeDown.getValue() | FittingPolicyScroll.getValue()),
	FittingPolicyDefault(FittingPolicyResizeDown.getValue());

	int value;

	private ImGuiTabBarFlags(int code) {
		value = code;
	}

	public ImGuiTabBarFlags and(ImGuiTabBarFlags otherEnum) {
		value = value | otherEnum.value;
		return this;
	}

	public int getValue() {
		return value;
	}
}
