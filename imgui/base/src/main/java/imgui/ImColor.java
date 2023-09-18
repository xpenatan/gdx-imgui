package imgui;

public class ImColor extends ImGuiFloat4 {

    public ImColor() {
        this(1f, 1f, 1f, 1f);
    }

    public ImColor(float r, float g, float b, float a) {
        super(r, g, b, a);
    }

    public void setColor(float r, float g, float b, float a) {
        setValue(r, g, b, a);
    }

    public float getR() {
        return getX();
    }

    public float getG() {
        return getY();
    }

    public float getB() {
        return getZ();
    }

    public float getA() {
        return getW();
    }
}
