package com.xpenatan.imgui.enums;

/**
 * A primary data type
 */
public enum ImGuiDataType_ {
	ImGuiDataType_S8(0),
	ImGuiDataType_U8(1),
	ImGuiDataType_S16(2),
	ImGuiDataType_U16(3),
	ImGuiDataType_S32(4),
	ImGuiDataType_U32(5),
	ImGuiDataType_S64(6),
	ImGuiDataType_U64(7),
	ImGuiDataType_Float(8),
	ImGuiDataType_Double(9),
	ImGuiDataType_COUNT(10);

	int value;

	private ImGuiDataType_(int code) {
		value = code;
	}

	public int getValue() {
		return value;
	}
}
