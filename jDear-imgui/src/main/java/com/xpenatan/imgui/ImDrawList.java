package com.xpenatan.imgui;

public class ImDrawList {
	public void AddImage(int textureID, float a_x, float a_y, float b_x, float b_y) {
		ImGuiNative.AddImage(textureID, a_x, a_y, b_x, b_y);
	}

	public void AddImage(int textureID, float a_x, float a_y, float b_x, float b_y, float uv_a_x, float uv_a_y, float uv_b_x, float uv_b_y) {
		ImGuiNative.AddImage(textureID, a_x, a_y, b_x, b_y, uv_a_x, uv_a_y, uv_b_x, uv_b_y);
	}
}
