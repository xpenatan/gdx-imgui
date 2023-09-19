package imgui;

public class ImRect {

    public static ImRect TMP = new ImRect();
    public static ImRect TMP_2 = new ImRect();
    public static ImRect TMP_3 = new ImRect();
    public static ImRect TMP_4 = new ImRect();

    public native void set_Min(ImVec2 min);
    public native void set_Max(ImVec2 max);

    public ImRect set(float x1, float y1, float x2, float y2) {
        set_Min(ImVec2.TMP.set(x1, y1));
        set_Max(ImVec2.TMP_2.set(x2, y2));
        return this;
    }
}
