package imgui;

public class ImRect {

    public static ImRect TMP_1 = new ImRect();
    public static ImRect TMP_2 = new ImRect();
    public static ImRect TMP_3 = new ImRect();
    public static ImRect TMP_4 = new ImRect();

    public native void Min(ImVec2 min);
    public native void Max(ImVec2 max);

    public ImRect set(float x1, float y1, float x2, float y2) {
        Min(ImVec2.TMP_2.set(x1, y1));
        Max(ImVec2.TMP_2.set(x2, y2));
        return this;
    }

    public ImRect set(ImVec2 min, ImVec2 max) {
        Min(min);
        Max(max);
        return this;
    }
}
