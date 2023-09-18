package com.github.xpenatan.imgui.example.viewport;

import com.badlogic.gdx.ScreenAdapter;
import imgui.ImGuiLoader;

public class ImGuiInitScreen extends ScreenAdapter {

    private ImGuiGame game;

    private boolean bulletInit = false;

    public ImGuiInitScreen(ImGuiGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        ImGuiLoader.init(() -> bulletInit = true);
    }

    @Override
    public void render(float delta) {
        if(bulletInit) {
            bulletInit = false;
            game.setScreen(new MainApp());
        }
    }
}
