package imgui;

import idl.helper.FloatArray;

public class ImGuiFloat2 extends FloatArray {

    public ImGuiFloat2() {
        this(0f, 0f);
    }

    public ImGuiFloat2(float x, float y) {
        super(2);
        setValue(x, y);
    }

    public void setValue(float x, float y) {
        setValue(0, x);
        setValue(1, y);
    }

    public void setX(float x) {
        setValue(0, x);
    }

    public void setY(float y) {
        setValue(1, y);
    }

    public float getX() {
        return getValue(0);
    }
    public float getY() {
        return getValue(1);
    }

    @Override
    public String toString() {
        return String.valueOf(getX() + ", " + getY());
    }
}
