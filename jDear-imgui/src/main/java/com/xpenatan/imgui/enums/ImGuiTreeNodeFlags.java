package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::TreeNodeEx(), ImGui::CollapsingHeader*()
 */
public enum ImGuiTreeNodeFlags {
	ImGuiTreeNodeFlags_None(0),
	ImGuiTreeNodeFlags_Selected(1 << 0),
	ImGuiTreeNodeFlags_Framed(1 << 1),
	ImGuiTreeNodeFlags_AllowItemOverlap(1 << 2),
	ImGuiTreeNodeFlags_NoTreePushOnOpen(1 << 3),
	ImGuiTreeNodeFlags_NoAutoOpenOnLog(1 << 4),
	ImGuiTreeNodeFlags_DefaultOpen(1 << 5),
	ImGuiTreeNodeFlags_OpenOnDoubleClick(1 << 6),
	ImGuiTreeNodeFlags_OpenOnArrow(1 << 7),
	ImGuiTreeNodeFlags_Leaf(1 << 8),
	ImGuiTreeNodeFlags_Bullet(1 << 9),
	ImGuiTreeNodeFlags_FramePadding(1 << 10),
//	ImGuITreeNodeFlags_SpanAllAvailWidth(1 << 11),
//	ImGuiTreeNodeFlags_NoScrollOnOpen(1 << 12),
	ImGuiTreeNodeFlags_NavLeftJumpsBackHere(1 << 13),
	ImGuiTreeNodeFlags_CollapsingHeader(ImGuiTreeNodeFlags_Framed.getValue() | ImGuiTreeNodeFlags_NoTreePushOnOpen.getValue() | ImGuiTreeNodeFlags_NoAutoOpenOnLog.getValue());

	int value;

	private ImGuiTreeNodeFlags(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
