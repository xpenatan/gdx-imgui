package com.github.xpenatan.imgui;

public class ImGuiString {
	public static ImGuiString TMP = new ImGuiString();

	byte [] data;

	private String text;

	final ImGuiInputTextData inputData = new ImGuiInputTextData();

	public ImGuiString() {
		this(100);
	}

	public ImGuiString(int size) {
		data = new byte[size];
	}

	public ImGuiString(String text) {
		this(100);
		setValue(text);
	}

	public void setValue(String value) {
		inputData.size = value.length();
		text = value;
		for(int i = 0; i < inputData.size; i++) {
			data[i] = (byte) value.charAt(i);
		}
	}

	public String getValue() {
		if(inputData.isDirty) {
			inputData.isDirty = false;
			text = new String(data,0, inputData.size);
		}
		return text;
	}

	@Override
	public String toString() {
		return getValue();
	}
}
