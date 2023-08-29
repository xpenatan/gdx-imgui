package imgui;

import idl.helper.DoubleArray;

public class ImGuiDouble extends DoubleArray {
    public static ImGuiDouble TMP = new ImGuiDouble();

    public ImGuiDouble() {
        this(0f);
    }

    public ImGuiDouble(double value) {
        super(1);
        setValue(value);
    }

    public void setValue(double value) {
        setValue(0, value);
    }

    public double getValue() {
        return getValue(0);
    }

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}
