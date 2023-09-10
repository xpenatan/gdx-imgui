package imgui;

import idl.helper.FloatArray;

public class ImGuiFloat4 extends FloatArray {

    public ImGuiFloat4() {
        this(0f, 0f, 0f, 0f);
    }

    public ImGuiFloat4(float x, float y, float z, float w) {
        super(4);
        setValue(x, y, z, w);
    }

    public void setValue(float x, float y, float z, float w) {
        setValue(0, x);
        setValue(1, y);
        setValue(2, z);
        setValue(3, w);
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

    public void setW(float w) {
        setValue(3, w);
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

    public float getW() {
        return getValue(3);
    }

    @Override
    public String toString() {
        return String.valueOf(getX() + ", " + getY() + ", " + getZ() + ", " + getW());
    }
}
