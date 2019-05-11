package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::IsItemHovered(), ImGui::IsWindowHovered()
 * Note: if you are trying to check whether your mouse should be dispatched to imgui or to your app, you should use the 'io.WantCaptureMouse' boolean for that. Please read the FAQ!
 * Note: windows with the ImGuiWindowFlags_NoInputs flag are ignored by IsWindowHovered() calls.
 */
public enum ImGuiDragDropFlags {
	None(0),
	// BeginDragDropSource() flags
	SourceNoPreviewTooltip(1 << 0),
	SourceNoDisableHover(1 << 1),
	SourceNoHoldToOpenOthers(1 << 2),
	SourceAllowNullID(1 << 3),
	SourceExtern(1 << 4),
	SourceAutoExpirePayload(1 << 5),
	// AcceptDragDropPayload() flags
	AcceptBeforeDelivery(1 << 10),
	AcceptNoDrawDefaultRect(1 << 11),
	AcceptNoPreviewTooltip(1 << 12),
	AcceptPeekOnly(AcceptBeforeDelivery.getValue() | AcceptNoDrawDefaultRect.getValue());

	int value;

	private ImGuiDragDropFlags(int code) {
		value = code;
	}

	public ImGuiDragDropFlags and(ImGuiDragDropFlags otherEnum) {
		value = value | otherEnum.value;
		return this;
	}

	public int getValue() {
		return value;
	}
}
