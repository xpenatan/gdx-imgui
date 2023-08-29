package imgui;

import idl.helper.FloatArray;

public class ImGuiFloat extends FloatArray {

    public static ImGuiFloat TMP = new ImGuiFloat();

    public ImGuiFloat() {
        this(0f);
    }

    public ImGuiFloat(float value) {
        super(1);
        setValue(value);
    }

    public void setValue(float value) {
        setValue(0, value);
    }

    public float getValue() {
        return getValue(0);
    }

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}
