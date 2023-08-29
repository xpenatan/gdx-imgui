package imgui;

import idl.helper.BoolArray;

public class ImGuiBoolean extends BoolArray {
    public static ImGuiBoolean TMP = new ImGuiBoolean();

    public ImGuiBoolean() {
        this(false);
    }

    public ImGuiBoolean(boolean value) {
        super(1);
        setValue(value);
    }

    public void setValue(boolean value) {
        setValue(0, value);
    }

    public boolean getValue() {
        return getValue(0);
    }

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}
