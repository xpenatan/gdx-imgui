package com.github.xpenatan.imgui;

public class ImGuiFloat {
	public static ImGuiFloat TMP = new ImGuiFloat();

	float [] data = new float[] { 0.0f };

	public ImGuiFloat() {}

	public ImGuiFloat(float value) {
		setValue(value);
	}

	public void setValue(float value) {
		this.data[0] = value;
	}

	public float getValue() {
		return this.data[0];
	}

	@Override
	public String toString() {
		return String.valueOf(getValue());
	}
}
