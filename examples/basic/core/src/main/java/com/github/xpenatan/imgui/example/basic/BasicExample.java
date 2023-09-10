package com.github.xpenatan.imgui.example.basic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.xpenatan.imgui.example.basic.renderer.ColorRenderer;
import com.github.xpenatan.imgui.example.basic.renderer.EditTextRenderer;
import com.github.xpenatan.imgui.example.basic.renderer.SelectListRenderer;
import com.github.xpenatan.imgui.gdx.ImGuiGdxImpl;
import com.github.xpenatan.imgui.gdx.ImGuiGdxInputMultiplexer;
import imgui.ImDrawData;
import imgui.ImGui;
import imgui.ImGuiBoolean;
import imgui.ImVec2;
import imgui.ImVec4;

public class BasicExample extends ScreenAdapter {

    private OrthographicCamera uiCam;
    private SpriteBatch batch;
    private ImGuiGdxImpl impl;

    private boolean init = false;

    private ImGuiBoolean checkbox;

    private EditTextRenderer editTextRenderer;
    private SelectListRenderer selectListRenderer;
    private ColorRenderer colorRenderer;

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void show() {
        ImGui.CreateContext(false);

        checkbox = new ImGuiBoolean();
        editTextRenderer = new EditTextRenderer();
        selectListRenderer = new SelectListRenderer();
        colorRenderer = new ColorRenderer();

        uiCam = new OrthographicCamera();
        uiCam.setToOrtho(true);
        batch = new SpriteBatch();
//        ImGuiIO io = ImGui.GetIO();
//        if(Gdx.app.getType() == Application.ApplicationType.WebGL) {
//            // Not possible to have ini filename with webgl
//            ImGui.GetIO().setIniFilename(null);
//        }

//        io.SetConfigFlags(ImGuiConfigFlags.DockingEnable);

        ImGuiGdxInputMultiplexer input = new ImGuiGdxInputMultiplexer();
        impl = new ImGuiGdxImpl();
        Gdx.input.setInputProcessor(input);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        uiCam.update();
        batch.setProjectionMatrix(uiCam.combined);

        impl.update();

        if(init == false) {
            init = true;
            ImGui.SetNextWindowSize(new ImVec2(400, 400), 1 << 1);
        }

        ImGui.Begin("Hello World");

        ImGui.Text("HelloText");

        ImGui.Checkbox("Check", checkbox);

        editTextRenderer.render();
        selectListRenderer.render();
        colorRenderer.render();

        ImGui.End();

        ImGui.ShowDemoWindow();

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
//        ImGui.dispose();
    }
}
