package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::TreeNodeEx(), ImGui::CollapsingHeader*()
 */
public enum ImGuiTreeNodeFlags {
	None(0),
	Selected(1 << 0),
	Framed(1 << 1),
	AllowItemOverlap(1 << 2),
	NoTreePushOnOpen(1 << 3),
	NoAutoOpenOnLog(1 << 4),
	DefaultOpen(1 << 5),
	OpenOnDoubleClick(1 << 6),
	OpenOnArrow(1 << 7),
	Leaf(1 << 8),
	Bullet(1 << 9),
	FramePadding(1 << 10),
//	SpanAllAvailWidth(1 << 11),
//	NoScrollOnOpen(1 << 12),
	NavLeftJumpsBackHere(1 << 13),
	CollapsingHeader(Framed.getValue() | NoTreePushOnOpen.getValue() | NoAutoOpenOnLog.getValue());

	int value;

	private ImGuiTreeNodeFlags(int code) {
		value = code;
	}

	public ImGuiTreeNodeFlags and(ImGuiTreeNodeFlags otherEnum) {
		value = value | otherEnum.value;
		return this;
	}

	public int getValue() {
		return value;
	}
}
