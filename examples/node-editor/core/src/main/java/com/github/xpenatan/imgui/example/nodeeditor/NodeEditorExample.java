package com.github.xpenatan.imgui.example.nodeeditor;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.xpenatan.imgui.core.ImDrawData;
import com.github.xpenatan.imgui.core.ImGui;
import com.github.xpenatan.imgui.core.ImGuiBoolean;
import com.github.xpenatan.imgui.core.ImGuiIO;
import com.github.xpenatan.imgui.core.enums.ImGuiConfigFlags;
import com.github.xpenatan.imgui.example.nodeeditor.renderer.NodeEditorRenderer;
import com.github.xpenatan.imgui.gdx.ImGuiGdxImpl;
import com.github.xpenatan.imgui.gdx.ImGuiGdxInputMultiplexer;

public class NodeEditorExample implements ApplicationListener {

    private OrthographicCamera uiCam;
    private SpriteBatch batch;
    private ImGuiGdxImpl impl;

    private boolean init = false;

    private ImGuiBoolean checkbox;

    private NodeEditorRenderer editorRenderer;

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void create() {
        ImGui.init();

        checkbox = new ImGuiBoolean();
        editorRenderer = new NodeEditorRenderer();

        uiCam = new OrthographicCamera();
        uiCam.setToOrtho(true);
        batch = new SpriteBatch();
        ImGuiIO io = ImGui.GetIO();
        if(Gdx.app.getType() == Application.ApplicationType.WebGL) {
            // Not possible to have ini filename with webgl
            ImGui.GetIO().setIniFilename(null);
        }

        io.SetConfigFlags(ImGuiConfigFlags.DockingEnable);

        ImGuiGdxInputMultiplexer input = new ImGuiGdxInputMultiplexer();
        impl = new ImGuiGdxImpl();
        Gdx.input.setInputProcessor(input);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        uiCam.update();
        batch.setProjectionMatrix(uiCam.combined);

        impl.update();

        if(init == false) {
            init = true;
            ImGui.SetNextWindowSize(400, 400);
        }

        ImGui.Begin("Hello World");

        ImGui.Text("HelloText");

        stringBuilder.setLength(0);
        stringBuilder.append("HelloText 2");
        ImGui.Text(stringBuilder);

        ImGui.Checkbox("Check", checkbox);

        editorRenderer.render();

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
        ImGui.dispose();
    }
}