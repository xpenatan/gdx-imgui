package com.github.xpenatan.imgui.example.basic;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.github.xpenatan.imgui.core.ImGui;

public class BasicExample implements ApplicationListener {

    @Override
    public void create() {

        ImGui.init();

        int value = ImGui.TestNative(30);
        System.out.println("value: " + value);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
