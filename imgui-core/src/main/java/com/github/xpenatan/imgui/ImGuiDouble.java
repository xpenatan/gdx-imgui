package com.github.xpenatan.imgui;

public class ImGuiDouble {
	public static ImGuiDouble TMP = new ImGuiDouble();

	double [] data = new double[] { 0.0d };

	public ImGuiDouble() {}

	public ImGuiDouble(double value) {
		setValue(value);
	}

	public void setValue(double value) {
		this.data[0] = value;
	}

	public double getValue() {
		return this.data[0];
	}

	@Override
	public String toString() {
		return String.valueOf(getValue());
	}
}
