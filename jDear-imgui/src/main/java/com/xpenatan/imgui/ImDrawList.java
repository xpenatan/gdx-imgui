package com.xpenatan.imgui;

import com.xpenatan.imgui.enums.ImDrawCornerFlags;

public class ImDrawList {

	public void AddLine(float a_x, float a_y, float b_x, float b_y, int col) {
		ImGuiNative.AddLine(a_x, a_y, b_x, b_y, col);
	}

	public void AddLine(float a_x, float a_y, float b_x, float b_y, int col, float thinkness) {
		ImGuiNative.AddLine(a_x, a_y, b_x, b_y, col, thinkness);
	}

	public void AddRect(float a_x, float a_y, float b_x, float b_y, int col) {
		ImGuiNative.AddRect(a_x, a_y, b_x, b_y, col);
	}

	public void AddRect(float a_x, float a_y, float b_x, float b_y, int col, float rounding) {
		ImGuiNative.AddRect(a_x, a_y, b_x, b_y, col, rounding);
	}

	public void AddRect(float a_x, float a_y, float b_x, float b_y, int col, float rounding, ImDrawCornerFlags rounding_corners_flags) {
		ImGuiNative.AddRect(a_x, a_y, b_x, b_y, col, rounding, rounding_corners_flags.getValue());
	}

	public void AddRect(float a_x, float a_y, float b_x, float b_y, int col, float rounding, ImDrawCornerFlags rounding_corners_flags, float thickness) {
		ImGuiNative.AddRect(a_x, a_y, b_x, b_y, col, rounding, rounding_corners_flags.getValue(), thickness);
	}

	public void AddRectFilled(float a_x, float a_y, float b_x, float b_y, int col) {
		ImGuiNative.AddRectFilled(a_x, a_y, b_x, b_y, col);
	}

	public void AddRectFilled(float a_x, float a_y, float b_x, float b_y, int col, float rounding) {
		ImGuiNative.AddRectFilled(a_x, a_y, b_x, b_y, col, rounding);
	}

	public void AddRectFilled(float a_x, float a_y, float b_x, float b_y, int col, float rounding, ImDrawCornerFlags rounding_corners_flags) {
		ImGuiNative.AddRectFilled(a_x, a_y, b_x, b_y, col, rounding, rounding_corners_flags.getValue());
	}

	public void AddRectFilledMultiColor(float a_x, float a_y, float b_x, float b_y, int col_upr_left, float col_upr_right, int col_bot_right, int col_bot_left) {
		ImGuiNative.AddRectFilledMultiColor(a_x, a_y, b_x, b_y, col_upr_left, col_upr_right, col_bot_right, col_bot_left);
	}

	public void AddQuad(float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, float d_x, float d_y, int col) {
		ImGuiNative.AddQuad(a_x, a_y, b_x, b_y, c_x, c_y, d_x, d_y, col);
	}

	public void AddQuad(float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, float d_x, float d_y, int col, float thickness) {
		ImGuiNative.AddQuad(a_x, a_y, b_x, b_y, c_x, c_y, d_x, d_y, col, thickness);
	}

	public void AddQuadFilled(float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, float d_x, float d_y, int col) {
		ImGuiNative.AddQuadFilled(a_x, a_y, b_x, b_y, c_x, c_y, d_x, d_y, col);
	}

	public void AddTriangle(float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, int col) {
		ImGuiNative.AddTriangle(a_x, a_y, b_x, b_y, c_x, c_y, col);
	}

	public void AddTriangle(float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, int col, float thickness) {
		ImGuiNative.AddTriangle(a_x, a_y, b_x, b_y, c_x, c_y, col, thickness);
	}

	public void AddTriangleFilled(float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, int col) {
		ImGuiNative.AddTriangleFilled(a_x, a_y, b_x, b_y, c_x, c_y, col);
	}

	public void AddCircle(float centre_x, float centre_y, float radius, float col, int num_segments, float thickness) {
		ImGuiNative.AddCircle(centre_x, centre_y, radius, col, num_segments, thickness);
	}

	public void AddText(float pos_x, float pos_y, int col, String text_begin) {
		ImGuiNative.AddText(pos_x, pos_y, col, text_begin);
	}

	public void AddText(float pos_x, float pos_y, int col, String text_begin, String text_end) {
		ImGuiNative.AddText(pos_x, pos_y, col, text_begin, text_end);
	}

	// TODO AddText

	public void AddImage(int textureID, float a_x, float a_y, float b_x, float b_y) {
		ImGuiNative.AddImage(textureID, a_x, a_y, b_x, b_y);
	}

	public void AddImage(int textureID, float a_x, float a_y, float b_x, float b_y, float uv_a_x, float uv_a_y, float uv_b_x, float uv_b_y) {
		ImGuiNative.AddImage(textureID, a_x, a_y, b_x, b_y, uv_a_x, uv_a_y, uv_b_x, uv_b_y);
	}

	//TODO AddImageQuad, AddImageRounded, AddPolyline, AddConvexPolyFilled

	public void AddBezierCurve(float pos0_x, float pos0_y, float cp0_x, float cp0_y, float cp1_x, float cp1_y, float pos1_x, float pos1_y, float col, float thickness) {
		ImGuiNative.AddBezierCurve(pos0_x, pos0_y, cp0_x, cp0_y, cp1_x, cp1_y, pos1_x, pos1_y, col, thickness);
	}
}
