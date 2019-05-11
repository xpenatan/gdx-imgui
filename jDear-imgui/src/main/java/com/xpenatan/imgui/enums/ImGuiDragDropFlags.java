package com.xpenatan.imgui.enums;

/**
 * Flags for ImGui::IsItemHovered(), ImGui::IsWindowHovered()
 * Note: if you are trying to check whether your mouse should be dispatched to imgui or to your app, you should use the 'io.WantCaptureMouse' boolean for that. Please read the FAQ!
 * Note: windows with the ImGuiWindowFlags_NoInputs flag are ignored by IsWindowHovered() calls.
 */
public enum ImGuiDragDropFlags {
	ImGuiDragDropFlags_None(0),
	// BeginDragDropSource() flags
	ImGuiDragDropFlags_SourceNoPreviewTooltip(1 << 0),
	ImGuiDragDropFlags_SourceNoDisableHover(1 << 1),
	ImGuiDragDropFlags_SourceNoHoldToOpenOthers(1 << 2),
	ImGuiDragDropFlags_SourceAllowNullID(1 << 3),
	ImGuiDragDropFlags_SourceExtern(1 << 4),
	ImGuiDragDropFlags_SourceAutoExpirePayload(1 << 5),
	// AcceptDragDropPayload() flags
	ImGuiDragDropFlags_AcceptBeforeDelivery(1 << 10),
	ImGuiDragDropFlags_AcceptNoDrawDefaultRect(1 << 11),
	ImGuiDragDropFlags_AcceptNoPreviewTooltip(1 << 12),
	ImGuiDragDropFlags_AcceptPeekOnly(ImGuiDragDropFlags_AcceptBeforeDelivery.getValue() | ImGuiDragDropFlags_AcceptNoDrawDefaultRect.getValue());

	int value;

	private ImGuiDragDropFlags(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
