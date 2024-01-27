package imgui.example.nodeeditor.blueprint;

import imgui.ImDrawList;
import imgui.ImRect;
import imgui.ImVec2;

public class Drawing {

    public static void DrawIcon(ImDrawList drawList, ImVec2 a, ImVec2 b, IconType type, boolean filled, int color, int innerColor) {
//        ImRect rect           = ImRect.TMP_1.set(a, b);
//        float rect_x         = rect.Min().x();
//        float rect_y         = rect.Min().y();
//        float rect_w         = rect.Max().x() - rect.Min().x();
//        float rect_h         = rect.Max().y() - rect.Min().y();
//        float rect_center_x  = (rect.Min().x() + rect.Max().x()) * 0.5f;
//        float rect_center_y  = (rect.Min().y() + rect.Max().y()) * 0.5f;
//        ImVec2 rect_center    = ImVec2.TMP_4.set(rect_center_x, rect_center_y);
//        float outline_scale  = rect_w / 24.0f;
//        float extra_segments = static_cast<int>(2 * outline_scale); // for full circle
    }

    public enum IconType {
        Flow,
        Circle,
        Square,
        Grid,
        RoundSquare,
        Diamond
    }
}