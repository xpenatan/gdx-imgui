package com.github.xpenatan.imgui.example.gdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.github.xpenatan.imgui.DrawData;
import com.github.xpenatan.imgui.ImGui;
import com.github.xpenatan.imgui.enums.ImGuiConfigFlags;
import com.github.xpenatan.imgui.gdx.ImGuiGdxImpl;
import com.github.xpenatan.imgui.gdx.ImGuiGdxInput;
import com.github.xpenatan.imgui.gdx.ImGuiGdxInputMultiplexer;
import com.github.xpenatan.imgui.gdx.widgets.ImGuiGdxGameWindow;
import com.github.xpenatan.xwindow.EmuApplicationWindow;

public class XWindowExample implements ApplicationListener
{
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1080;
		config.height = 800;
		config.title = "Gdx-imgui";
		config.vSyncEnabled = true;
		new LwjglApplication(new XWindowExample(), config);
	}

	boolean init = false;

	ImGuiGdxInput input = new ImGuiGdxInput();
	ImGuiGdxGameWindow gameWindow1;
	ImGuiGdxGameWindow gameWindow2;

	ImGuiGdxImpl impl;

	@Override
	public void create () {
		ImGui.init();
		ImGui.GetIO().SetConfigFlags(ImGuiConfigFlags.DockingEnable);
		ImGui.GetIO().SetDockingFlags(false, false, false, false);


		impl = new ImGuiGdxImpl();
		Gdx.input.setInputProcessor(input);
		configXWindow();
	}

	private void configXWindow() {
		EmuApplicationWindow emuApplication1 = new EmuApplicationWindow();
		gameWindow1 = new ImGuiGdxGameWindow(emuApplication1, 400, 400, 100, 100);
		gameWindow1.setName("Game 1");
		emuApplication1.setApplicationListener(new GameApp());

		EmuApplicationWindow emuApplication2 = new EmuApplicationWindow();
		gameWindow2 = new ImGuiGdxGameWindow(emuApplication2, 400, 400, 600, 100);
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
		DrawData drawData = ImGui.GetDrawData();
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
	}
}
