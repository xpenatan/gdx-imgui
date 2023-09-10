package imgui;

import idl.helper.IntArray;

public class ImGuiInt4 extends IntArray {

    public ImGuiInt4() {
        this(0, 0, 0, 0);
    }

    public ImGuiInt4(int x, int y, int z, int w) {
        super(4);
        setValue(x, y, z, w);
    }

    public void setValue(int x, int y, int z, int w) {
        setValue(0, x);
        setValue(1, y);
        setValue(2, z);
        setValue(3, w);
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

    public void setW(int w) {
        setValue(3, w);
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

    public int getW() {
        return getValue(3);
    }

    @Override
    public String toString() {
        return String.valueOf(getX() + ", " + getY() + ", " + getZ() + ", " + getW());
    }
}
