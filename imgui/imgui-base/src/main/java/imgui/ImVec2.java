package imgui;

import idl.IDLBase;

public class ImVec2 extends IDLBase {

    public static ImVec2 TMP_1 = new ImVec2();
    public static ImVec2 TMP_2 = new ImVec2();
    public static ImVec2 TMP_3 = new ImVec2();
    public static ImVec2 TMP_4 = new ImVec2();

    public ImVec2() {}

    public ImVec2(byte t) {}

    public native float get_x();
    public native float get_y();
    public native void set_x(float x);
    public native void set_y(float y);

    public ImVec2 set(float x, float y) {
        set_x(x);
        set_y(y);
        return this;
    }

    public ImVec2 set(ImVec2 vec) {
        float x = vec.get_x();
        float y = vec.get_y();
        set_x(x);
        set_y(y);
        return this;
    }
}
