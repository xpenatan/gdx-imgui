package com.github.xpenatan.imgui.example.viewport;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.ImGuiLWJGL3Impl;
import com.badlogic.gdx.graphics.GL20;
import com.github.xpenatan.gdx.frame.viewport.EmuApplicationWindow;
import com.github.xpenatan.gdx.frame.viewport.EmuInput;
import com.github.xpenatan.imgui.core.ImDrawData;
import com.github.xpenatan.imgui.core.ImGui;
import com.github.xpenatan.imgui.core.enums.ImGuiConfigFlags;
import com.github.xpenatan.imgui.gdx.ImGuiGdxInputMultiplexer;
import com.github.xpenatan.imgui.gdx.frame.viewport.ImGuiGdxFrameWindow;

public class MainApp implements ApplicationListener {

    boolean init = false;

    ImGuiGdxFrameWindow gameWindow1;
    ImGuiGdxFrameWindow gameWindow2;

    ImGuiLWJGL3Impl impl;

    @Override
    public void create() {
        ImGui.init();
        ImGui.GetIO().SetConfigFlags(ImGuiConfigFlags.DockingEnable);
        // Viewport inputs not working
//        ImGui.GetIO().SetConfigFlags(ImGuiConfigFlags.DockingEnable.or(ImGuiConfigFlags.ViewportsEnable));
        ImGui.GetIO().SetDockingFlags(false, false, false, false);

        impl = new ImGuiLWJGL3Impl();
        configFrameViewport();
    }

    private void configFrameViewport() {
        EmuInput input01 = new EmuInput(Gdx.input) {
            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                boolean b = super.touchUp(screenX, screenY, pointer, button);
                return b;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                boolean b = super.touchDown(screenX, screenY, pointer, button);
                return b;
            }
        };
        EmuInput input02 = new EmuInput(Gdx.input) {
            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                boolean b = super.touchUp(screenX, screenY, pointer, button);
                return b;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                boolean b = super.touchDown(screenX, screenY, pointer, button);
                return b;
            }
        };

        EmuApplicationWindow emuApplication1 = new EmuApplicationWindow(input01);
        gameWindow1 = new ImGuiGdxFrameWindow(impl, emuApplication1, 400, 400, 100, 100);
        gameWindow1.setName("Game 1");
        emuApplication1.setApplicationListener(new GameApp());

        EmuApplicationWindow emuApplication2 = new EmuApplicationWindow(input02);
        gameWindow2 = new ImGuiGdxFrameWindow(impl, emuApplication2, 400, 400, 600, 100);
        gameWindow2.setName("Game 2");
        emuApplication2.setApplicationListener(new GameApp());

        ImGuiGdxInputMultiplexer multiplexer = new ImGuiGdxInputMultiplexer();
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        impl.update();

        gameWindow1.render();
        gameWindow2.render();

        ImGui.Render();
        ImDrawData drawData = ImGui.GetDrawData();
        impl.render(drawData);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        ImGui.dispose();
    }
}
