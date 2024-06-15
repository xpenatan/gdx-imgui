package imgui.example.basic.launcher;

import com.badlogic.gdx.Gdx;
import com.github.xpenatan.gdx.backends.teavm.TeaApplication;
import com.github.xpenatan.gdx.backends.teavm.TeaApplicationConfiguration;
import com.github.xpenatan.gdx.backends.teavm.TeaFiles;
import imgui.example.basic.ImGuiGame;

public class Launcher {

    public static void main(String[] args) {
        TeaApplicationConfiguration config = new TeaApplicationConfiguration("canvas");
        config.useDebugGL = false;
        config.width = 0;
        config.height = 0;
        config.useGL30 = true;
        new TeaApplication(new ImGuiGame() {
            @Override
            public void create() {
                TeaFiles files = (TeaFiles)Gdx.files;
//                files.localStorage.debug = true;
//                files.localStorage.printAllFiles();
                super.create();
            }
        }, config);
    }
}
