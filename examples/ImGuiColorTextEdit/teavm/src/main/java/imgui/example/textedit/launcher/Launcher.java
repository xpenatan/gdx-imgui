package imgui.example.textedit.launcher;

import com.github.xpenatan.gdx.backends.teavm.TeaApplication;
import com.github.xpenatan.gdx.backends.teavm.TeaApplicationConfiguration;
import imgui.example.renderer.ImGuiShared;
import imgui.example.renderer.ImGuiSharedGdx;
import imgui.example.textedit.ImGuiGame;

public class Launcher {

    public static void main(String[] args) {
        TeaApplicationConfiguration config = new TeaApplicationConfiguration("canvas");
        config.useDebugGL = false;
        config.width = 0;
        config.height = 0;
//        config.useGL30 = false;
//        config.useGLArrayBuffer = true;
        ImGuiShared.instance = new ImGuiSharedGdx();
        new TeaApplication(new ImGuiGame(), config);
    }
}
