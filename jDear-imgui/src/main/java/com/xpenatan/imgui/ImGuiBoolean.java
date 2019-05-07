package com.xpenatan.imgui;

public class ImGuiBoolean {
	boolean [] data = new boolean[] { false };

	public ImGuiBoolean() {}

	public ImGuiBoolean(boolean value) {
		setValue(value);
	}

	public void setValue(boolean value) {
		this.data[0] = value;
	}

	public boolean getValue() {
		return this.data[0];
	}

	@Override
	public String toString() {
		return String.valueOf(getValue());
	}
}
