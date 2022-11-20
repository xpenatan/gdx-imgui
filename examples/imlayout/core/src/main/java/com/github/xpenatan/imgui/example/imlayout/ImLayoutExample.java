package com.github.xpenatan.imgui.example.imlayout;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.xpenatan.imgui.core.ImDrawData;
import com.github.xpenatan.imgui.core.ImGui;
import com.github.xpenatan.imgui.gdx.ImGuiGdxImpl;
import com.github.xpenatan.imgui.gdx.ImGuiGdxInputMultiplexer;

public class ImLayoutExample implements ApplicationListener {

    private OrthographicCamera uiCam;
    private SpriteBatch batch;
    private ImGuiGdxImpl impl;

    private boolean init = false;

    private ImLayoutView view;

    @Override
    public void create() {
        uiCam = new OrthographicCamera();
        uiCam.setToOrtho(true);
        batch = new SpriteBatch();

        ImGui.init();
        ImGuiGdxInputMultiplexer input = new ImGuiGdxInputMultiplexer();
        impl = new ImGuiGdxImpl();
        Gdx.input.setInputProcessor(input);

        view = new ImLayoutView();
        view.init();
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
        view.renderTabImGuiExtViews();
        ImGui.End();

        ImGui.ShowDemoWindow(false);

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
        view.dispose();
        ImGui.dispose();
    }
}
