package imgui.example.basic;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import imgui.example.renderer.ImGuiShared;
import imgui.example.renderer.ImGuiSharedWGPU;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode(1444, 800);
        config.setTitle("ImGui Basic Example");
        config.useVsync(true);
        config.setOpenGLEmulation(Lwjgl3ApplicationConfiguration.GLEmulation.GL30, 3, 2);

        ImGuiShared.instance = new ImGuiSharedWGPU();
        new Lwjgl3Application(new ImGuiGame(), config);
    }
}