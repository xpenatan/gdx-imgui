package imgui.example.renderer;

import com.badlogic.gdx.InputMultiplexer;
import imgui.ImGuiImpl;

public final class ImGuiShared {

    public static ImGuiSharedInstance instance;

    public interface ImGuiSharedInstance {
        void clearScreen(float red, float green, float blue, float alpha);
        ImGuiImpl createImpl();
        InputMultiplexer createInput();
    }
}