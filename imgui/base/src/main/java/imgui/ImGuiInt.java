package imgui;

import idl.helper.IntArray;

public class ImGuiInt extends IntArray {

    public static ImGuiInt TMP = new ImGuiInt();

    public ImGuiInt() {
        this(0);
    }

    public ImGuiInt(int value) {
        super(1);
        setValue(value);
    }

    public void setValue(int value) {
        setValue(0, value);
    }

    public int getValue() {
        return getValue(0);
    }

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}
