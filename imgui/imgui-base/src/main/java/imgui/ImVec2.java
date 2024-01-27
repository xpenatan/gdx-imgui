package imgui;

import idl.IDLBase;

public class ImVec2 extends IDLBase {

    public static ImVec2 TMP_1 = new ImVec2();
    public static ImVec2 TMP_2 = new ImVec2();
    public static ImVec2 TMP_3 = new ImVec2();
    public static ImVec2 TMP_4 = new ImVec2();

    public ImVec2() {}

    public ImVec2(byte t) {}

    public native float x();
    public native float y();
    public native void x(float x);
    public native void y(float y);

    public ImVec2 set(float x, float y) {
        x(x);
        y(y);
        return this;
    }

    public ImVec2 set(ImVec2 vec) {
        float x = vec.x();
        float y = vec.y();
        x(x);
        y(y);
        return this;
    }
}
