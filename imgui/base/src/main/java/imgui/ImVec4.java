package imgui;

public class ImVec4 {

    public static ImVec4 TMP = new ImVec4();
    public static ImVec4 TMP_2 = new ImVec4();
    public static ImVec4 TMP_3 = new ImVec4();
    public static ImVec4 TMP_4 = new ImVec4();

    public native float get_x();
    public native float get_y();
    public native float get_z();
    public native float get_w();
    public native void set_x(float x);
    public native void set_y(float y);
    public native void set_z(float z);
    public native void set_w(float w);

    public ImVec4 set(float x, float y, float z, float w) {
        set_x(x);
        set_y(y);
        set_z(z);
        set_w(w);
        return this;
    }
}
