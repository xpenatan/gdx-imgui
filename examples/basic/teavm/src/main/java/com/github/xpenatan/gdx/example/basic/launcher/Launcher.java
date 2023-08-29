package com.github.xpenatan.gdx.example.basic.launcher;

import com.github.xpenatan.gdx.backends.teavm.TeaApplication;
import com.github.xpenatan.gdx.backends.teavm.TeaApplicationConfiguration;
import com.github.xpenatan.imgui.example.basic.BasicExample;
import com.github.xpenatan.imgui.example.basic.ImGuiGame;

public class Launcher {

    public static void main(String[] args) {
        TeaApplicationConfiguration config = new TeaApplicationConfiguration("canvas");
        config.useDebugGL = false;
        config.width = 0;
        config.height = 0;
        new TeaApplication(new ImGuiGame(), config);
    }
}
