package imgui;

import idl.IDLBase;

public class ImVec4 extends IDLBase {

    public static ImVec4 TMP_1 = new ImVec4();
    public static ImVec4 TMP_2 = new ImVec4();
    public static ImVec4 TMP_3 = new ImVec4();
    public static ImVec4 TMP_4 = new ImVec4();

    public static ImVec4 TMP_INTERNAL_1 = new ImVec4();
    public static ImVec4 TMP_INTERNAL_2 = new ImVec4();

    public ImVec4() {
    }

    public ImVec4(boolean cMemoryOwn) {
    }

    public native float x();
    public native float y();
    public native float z();
    public native float w();
    public native void x(float x);
    public native void y(float y);
    public native void z(float z);
    public native void w(float w);

    public ImVec4 set(float x, float y, float z, float w) {
        x(x);
        y(y);
        z(z);
        w(w);
        return this;
    }

    public ImVec4 set(ImVec4 vec) {
        float x = vec.x();
        float y = vec.y();
        float z = vec.z();
        float w = vec.w();
        x(x);
        y(y);
        z(z);
        w(w);
        return this;
    }
}
