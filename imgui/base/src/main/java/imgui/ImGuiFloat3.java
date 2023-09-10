package imgui;

import idl.helper.FloatArray;

public class ImGuiFloat3 extends FloatArray {

    public ImGuiFloat3() {
        this(0f, 0f, 0f);
    }

    public ImGuiFloat3(float x, float y, float z) {
        super(3);
        setValue(x, y, z);
    }

    public void setValue(float x, float y, float z) {
        setValue(0, x);
        setValue(1, y);
        setValue(2, z);
    }

    public void setX(float x) {
        setValue(0, x);
    }

    public void setY(float y) {
        setValue(1, y);
    }

    public void setZ(float z) {
        setValue(2, z);
    }

    public float getX() {
        return getValue(0);
    }

    public float getY() {
        return getValue(1);
    }

    public float getZ() {
        return getValue(2);
    }

    @Override
    public String toString() {
        return String.valueOf(getX() + ", " + getY() + ", " + getZ());
    }
}
