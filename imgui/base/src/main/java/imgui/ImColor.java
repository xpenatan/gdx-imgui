package imgui;

public class ImColor extends ImGuiFloat4 {

    public ImColor() {
        this(1f, 1f, 1f, 1f);
    }

    public ImColor(float x, float y, float z, float w) {
        super(x, y, z, w);
    }
}
