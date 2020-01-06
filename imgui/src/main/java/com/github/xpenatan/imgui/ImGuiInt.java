package com.github.xpenatan.imgui;

public class ImGuiInt {
	public static ImGuiInt TMP = new ImGuiInt();

	int [] data = new int[] { 0 };

	public ImGuiInt() {}

	public ImGuiInt(int value) {
		setValue(value);
	}

	public void setValue(int value) {
		this.data[0] = value;
	}

	public int getValue() {
		return this.data[0];
	}

	@Override
	public String toString() {
		return String.valueOf(getValue());
	}
}
