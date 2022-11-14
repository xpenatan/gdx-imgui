package com.github.xpenatan.imgui.example;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.github.xpenatan.imgui.example.basic.BasicExample;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode(1444, 800);
        config.setTitle("ImGui Basic Example");
        config.useVsync(true);
        new Lwjgl3Application(new BasicExample(), config);
    }
}