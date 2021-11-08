package com.github.xpenatan.imgui.example.gdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.ImGuiLWJGL3Impl;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.github.xpenatan.gdx.frame.viewport.EmuApplicationWindow;
import com.github.xpenatan.imgui.ImDrawData;
import com.github.xpenatan.imgui.ImGui;
import com.github.xpenatan.imgui.enums.ImGuiConfigFlags;
import com.github.xpenatan.imgui.gdx.ImGuiGdxImpl;
import com.github.xpenatan.imgui.gdx.ImGuiGdxInput;
import com.github.xpenatan.imgui.gdx.ImGuiGdxInputMultiplexer;
import com.github.xpenatan.imgui.gdx.frame.viewport.ImGuiGdxFrameWindow;

public class GameViewportExample implements ApplicationListener
{
	public static void main (String[] args) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(1080, 800);
		config.setTitle("Gdx-imgui");
		config.useVsync(true);
		new Lwjgl3Application(new GameViewportExample(), config);
	}

	boolean init = false;

	ImGuiGdxInput input = new ImGuiGdxInput();
	ImGuiGdxFrameWindow gameWindow1;
	ImGuiGdxFrameWindow gameWindow2;

	ImGuiGdxImpl impl;

	@Override
	public void create () {
		ImGui.init();
		ImGui.GetIO().SetConfigFlags(ImGuiConfigFlags.DockingEnable.or(ImGuiConfigFlags.ViewportsEnable));
		ImGui.GetIO().SetDockingFlags(false, false, false, false);


		impl = new ImGuiLWJGL3Impl();
		Gdx.input.setInputProcessor(input);
		configFrameViewport();
	}

	private void configFrameViewport() {
		EmuApplicationWindow emuApplication1 = new EmuApplicationWindow();
		gameWindow1 = new ImGuiGdxFrameWindow(emuApplication1, 400, 400, 100, 100);
		gameWindow1.setName("Game 1");
		emuApplication1.setApplicationListener(new GameApp());

		EmuApplicationWindow emuApplication2 = new EmuApplicationWindow();
		gameWindow2 = new ImGuiGdxFrameWindow(emuApplication2, 400, 400, 600, 100);
		gameWindow2.setName("Game 2");
		emuApplication2.setApplicationListener(new GameApp());

		ImGuiGdxInputMultiplexer multiplexer = new ImGuiGdxInputMultiplexer(input);
		multiplexer.addProcessor(gameWindow1.getInput());
		multiplexer.addProcessor(gameWindow2.getInput());
		Gdx.input.setInputProcessor(multiplexer);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		impl.update();

		gameWindow1.render();
		gameWindow2.render();

		ImGui.Render();
		ImDrawData drawData = ImGui.GetDrawData();
		impl.render(drawData);
	}

	@Override
	public void resize (int width, int height) {
	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void dispose () {
		ImGui.dispose();
	}
}
