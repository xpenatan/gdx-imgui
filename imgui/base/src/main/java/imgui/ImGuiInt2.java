package imgui;

import idl.helper.IntArray;

public class ImGuiInt2 extends IntArray {

    public ImGuiInt2() {
        this(0, 0);
    }

    public ImGuiInt2(int x, int y) {
        super(2);
        setValue(x, y);
    }

    public void setValue(int x, int y) {
        setValue(0, x);
        setValue(1, y);
    }

    public void setX(int x) {
        setValue(0, x);
    }

    public void setY(int y) {
        setValue(1, y);
    }

    public int getX() {
        return getValue(0);
    }
    public int getY() {
        return getValue(1);
    }

    @Override
    public String toString() {
        return String.valueOf(getX() + ", " + getY());
    }
}
