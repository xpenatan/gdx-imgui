package com.github.xpenatan.imgui.example.viewport;

import com.badlogic.gdx.Gdx;
import com.github.xpenatan.gdx.frame.viewport.EmuApplicationWindow;
import com.github.xpenatan.gdx.frame.viewport.EmuInput;
import com.github.xpenatan.imgui.example.basic.ImGuiRenderer;
import com.github.xpenatan.imgui.gdx.ImGuiGdxImpl;
import com.github.xpenatan.imgui.gdx.frame.viewport.ImGuiGdxFrameWindow;
import imgui.ImGui;
import imgui.ImGuiConfigFlags;

public class MainApp extends ImGuiRenderer {

    boolean init = false;

    ImGuiGdxFrameWindow gameWindow1;
    ImGuiGdxFrameWindow gameWindow2;

    ImGuiGdxImpl impl;

    @Override
    public void show() {
        super.show();
        ImGui.GetIO().set_ConfigFlags(ImGuiConfigFlags.ImGuiConfigFlags_DockingEnable);
        // Viewport inputs not working
//        ImGui.GetIO().set_ConfigFlags(ImGuiConfigFlags.ImGuiConfigFlags_DockingEnable | ImGuiConfigFlags.ImGuiConfigFlags_DockingEnable));
        ImGui.GetIO().SetDockingFlags(false, false, false, false);

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
        gameWindow1 = new ImGuiGdxFrameWindow(emuApplication1, 400, 400, 100, 100);
        gameWindow1.setName("Game 1");
        emuApplication1.setApplicationListener(new GameApp());

        EmuApplicationWindow emuApplication2 = new EmuApplicationWindow(input02);
        gameWindow2 = new ImGuiGdxFrameWindow(emuApplication2, 400, 400, 600, 100);
        gameWindow2.setName("Game 2");
        emuApplication2.setApplicationListener(new GameApp());

        input.addProcessor(gameWindow1.getInput());
        input.addProcessor(gameWindow2.getInput());
    }

    @Override
    public void renderImGui() {
        gameWindow1.render();
        gameWindow2.render();
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
}
