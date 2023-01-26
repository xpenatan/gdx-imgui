package com.github.xpenatan.imgui.example.tests;

import com.github.xpenatan.imgui.core.ImDrawData;
import com.github.xpenatan.imgui.core.ImGui;
import com.github.xpenatan.imgui.core.ImGuiBoolean;
import com.github.xpenatan.imgui.core.ImGuiInt;
import com.github.xpenatan.imgui.core.enums.ImGuiConfigFlags;
import com.github.xpenatan.imgui.core.enums.ImGuiStyleVar;
import com.github.xpenatan.imgui.core.enums.ImGuiWindowFlags;
import com.github.xpenatan.imgui.gdx.ImGuiGdxInputMultiplexer;
import java.util.List;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.tests.InputTest;
import com.badlogic.gdx.tests.utils.GdxTest;
import com.badlogic.gdx.tests.utils.GdxTests;
import com.github.xpenatan.gdx.frame.viewport.EmuApplicationWindow;
import com.github.xpenatan.gdx.frame.viewport.EmuFrameBuffer;
import com.github.xpenatan.imgui.gdx.ImGuiGdxImpl;
import com.github.xpenatan.imgui.gdx.frame.viewport.ImGuiGdxFrameWindow;

/**
 * Requires Gdx-test
 */
public class ImGuiGdxTests implements ApplicationListener {

    ImGuiGdxImpl impl;

    EmuApplicationWindow emuApplication;
    ImGuiGdxFrameWindow gameWindow;

    int i = 0;

    boolean gdxTestInit = false;

    List<String> names;
    ImGuiInt listSelected = new ImGuiInt();
    ImGuiBoolean booleanFlag = new ImGuiBoolean();
    int selected = -1;

    @Override
    public void create() {
        ImGui.init();

        ImGui.GetIO().SetConfigFlags(ImGuiConfigFlags.DockingEnable);
        ImGui.GetIO().SetDockingFlags(false, false, false, false);

        impl = new ImGuiGdxImpl();

        EmuFrameBuffer.setDefaultFramebufferHandleInitialized(false);

        emuApplication = new EmuApplicationWindow();
        gameWindow = new ImGuiGdxFrameWindow(emuApplication, 400, 400, 300, 100);
        gameWindow.setName("Game");

        names = GdxTests.getNames();

        emuApplication.setApplicationListener(new InputTest());

        ImGuiGdxInputMultiplexer multiplexer = new ImGuiGdxInputMultiplexer();
        Gdx.input.setInputProcessor(multiplexer);
    }

    private void drawTestListWindow() {
        if(!gdxTestInit) {
            gdxTestInit = true;
            ImGui.SetNextWindowSize(200, 500);
        }
        ImGui.Begin("GdxTests");
        ImGui.BeginChildFrame(313, 0f, 0f);
        for(int i = 0; i < names.size(); i++) {
            String testName = names.get(i);
            boolean isSelected = selected == i;
            if(ImGui.Selectable(testName, isSelected)) {
                if(selected != i) {
                    selected = i;
                    GdxTest newTest = GdxTests.newTest(testName);
                    emuApplication.setApplicationListener(newTest);
                }
            }
        }
        ImGui.EndChildFrame();
        ImGui.End();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();
        int backBufferWidth = Gdx.graphics.getBackBufferWidth();
        int backBufferHeight = Gdx.graphics.getBackBufferHeight();


        impl.update();

        ImGui.SetNextWindowSize(width, height);
        ImGui.SetNextWindowPos(0, 0);

        ImGuiWindowFlags flags = ImGuiWindowFlags.NoDecoration;
        flags = flags.or(ImGuiWindowFlags.NoDocking).or(ImGuiWindowFlags.NoBringToFrontOnFocus);

        ImGui.PushStyleVar(ImGuiStyleVar.WindowRounding, 0.0f);
        ImGui.PushStyleVar(ImGuiStyleVar.WindowBorderSize, 0.0f);

        ImGui.PushStyleVar(ImGuiStyleVar.WindowPadding, 0.0f, 0.0f);
        ImGui.Begin("DockSpace Demo", booleanFlag, flags);
        ImGui.PopStyleVar();
        ImGui.PopStyleVar(2);

        ImGui.DockSpace(201, width, height);

        drawTestListWindow();
        gameWindow.render();

        ImGui.End();

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
