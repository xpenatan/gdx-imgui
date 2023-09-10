package imgui;

import idl.helper.IntArray;

public class ImGuiInt3 extends IntArray {

    public ImGuiInt3() {
        this(0, 0, 0);
    }

    public ImGuiInt3(int x, int y, int z) {
        super(3);
        setValue(x, y, z);
    }

    public void setValue(int x, int y, int z) {
        setValue(0, x);
        setValue(1, y);
        setValue(2, z);
    }

    public void setX(int x) {
        setValue(0, x);
    }

    public void setY(int y) {
        setValue(1, y);
    }

    public void setZ(int z) {
        setValue(2, z);
    }

    public int getX() {
        return getValue(0);
    }

    public int getY() {
        return getValue(1);
    }

    public int getZ() {
        return getValue(2);
    }

    @Override
    public String toString() {
        return String.valueOf(getX() + ", " + getY() + ", " + getZ());
    }
}
