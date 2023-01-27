package com.github.xpenatan.imgui.example.tests;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode(1444, 800);
        config.setTitle("ImGui Tests Example");
        config.useVsync(true);
        config.setOpenGLEmulation(Lwjgl3ApplicationConfiguration.GLEmulation.GL20, 3, 2);
        new Lwjgl3Application(new ImGuiGdxTests(), config);
    }
}