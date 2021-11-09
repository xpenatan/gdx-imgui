package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.github.xpenatan.imgui.ImDrawData;
import com.github.xpenatan.imgui.ImGui;
import com.github.xpenatan.imgui.ImGuiViewport;
import com.github.xpenatan.imgui.gdx.ImGuiGdxInput;

public class ImGuiApplication implements ApplicationListener {

    private ImGuiLWJGL3Impl impl;
    public Lwjgl3Window lwjgl3Window;
    private ImGuiGdxInput input;

    public ImGuiApplication(ImGuiLWJGL3Impl impl) {
        this.impl = impl;
    }

    @Override
    public void create() {
        input = new ImGuiGdxInput();
        Gdx.input.setInputProcessor(input);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ImGuiViewport imGuiViewport = ImGui.FindViewportByPlatformHandle(lwjgl3Window.getWindowHandle(), true);
        if(imGuiViewport != null) {
            ImDrawData drawData = imGuiViewport.getDrawData();
            impl.renderDrawData(drawData, 1);
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
