package com.github.xpenatan.imgui.example.gdx;

import java.util.List;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.tests.InputTest;
import com.badlogic.gdx.tests.utils.GdxTest;
import com.badlogic.gdx.tests.utils.GdxTests;
import com.github.xpenatan.gdx.frame.viewport.EmuApplicationWindow;
import com.github.xpenatan.gdx.frame.viewport.EmuFrameBuffer;
import com.github.xpenatan.imgui.DrawData;
import com.github.xpenatan.imgui.ImGui;
import com.github.xpenatan.imgui.ImGuiBoolean;
import com.github.xpenatan.imgui.ImGuiInt;
import com.github.xpenatan.imgui.enums.ImGuiConfigFlags;
import com.github.xpenatan.imgui.enums.ImGuiStyleVar;
import com.github.xpenatan.imgui.enums.ImGuiWindowFlags;
import com.github.xpenatan.imgui.gdx.ImGuiGdxImpl;
import com.github.xpenatan.imgui.gdx.frame.viewport.ImGuiGdxFrameWindow;

/**
 *
 * Requires Gdx-test
 *
 */
public class TestsExample implements ApplicationListener {


	public static void main(String[] args) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1600;
		config.height = 900;
		config.title = "ImGui-Gdx-tests";
		config.vSyncEnabled = true;
		new LwjglApplication(new TestsExample(), config);
	}

	ImGuiGdxImpl impl;

	EmuApplicationWindow emuApplication;
	ImGuiGdxFrameWindow gameWindow;

	int i = 0;

	boolean gdxTestInit = false;

	List<String> names;
	ImGuiInt listSelected = new ImGuiInt();
	ImGuiBoolean booleanFlag = new ImGuiBoolean();
	int selected = -1;
	@Override
	public void create() {
		ImGui.init();

		ImGui.GetIO().SetConfigFlags(ImGuiConfigFlags.DockingEnable);
		ImGui.GetIO().SetDockingFlags(false, false, false, false);

		impl = new ImGuiGdxImpl();

		EmuFrameBuffer.setDefaultFramebufferHandleInitialized(false);

		emuApplication = new EmuApplicationWindow();
		gameWindow = new ImGuiGdxFrameWindow(emuApplication, 400, 400, 300, 100);

		gameWindow.setName("Game");

		Gdx.input.setInputProcessor(gameWindow.getInput());

		names = GdxTests.getNames();

		emuApplication.setApplicationListener(new InputTest());
	}


	private void drawTestListWindow() {
		if(!gdxTestInit) {
			gdxTestInit = true;
			ImGui.SetNextWindowSize(200, 500);
		}
		ImGui.Begin("GdxTests");
		ImGui.BeginChildFrame(313, 0f, 0f);
		for(int i = 0; i < names.size(); i++) {
			String testName = names.get(i);
			boolean isSelected = selected == i;
			if(ImGui.Selectable(testName, isSelected)) {
				if(selected != i) {
					selected = i;
					GdxTest newTest = GdxTests.newTest(testName);
					emuApplication.setApplicationListener(newTest);
				}
			}
		}
		ImGui.EndChildFrame();
		ImGui.End();
	}


	@Override
	public void render() {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		int backBufferWidth = Gdx.graphics.getBackBufferWidth();
		int backBufferHeight = Gdx.graphics.getBackBufferHeight();

		boolean mouseDown0 = Gdx.input.isButtonPressed(Buttons.LEFT);
		boolean mouseDown1 = Gdx.input.isButtonPressed(Buttons.RIGHT);
		boolean mouseDown2 = Gdx.input.isButtonPressed(Buttons.MIDDLE);

		ImGui.UpdateDisplayAndInputAndFrame(Gdx.graphics.getDeltaTime(), width, height, backBufferWidth, backBufferHeight,
				Gdx.input.getX(), Gdx.input.getY(), mouseDown0, mouseDown1, mouseDown2);


		ImGui.SetNextWindowSize(width, height);
		ImGui.SetNextWindowPos(0, 0);

		ImGuiWindowFlags flags = ImGuiWindowFlags.NoDecoration;
		flags = flags.or(ImGuiWindowFlags.NoDocking).or(ImGuiWindowFlags.NoBringToFrontOnFocus);

		ImGui.PushStyleVar(ImGuiStyleVar.WindowRounding, 0.0f);
		ImGui.PushStyleVar(ImGuiStyleVar.WindowBorderSize, 0.0f);

		ImGui.PushStyleVar(ImGuiStyleVar.WindowPadding, 0.0f, 0.0f);
		ImGui.Begin("DockSpace Demo", booleanFlag, flags);
		ImGui.PopStyleVar();
		ImGui.PopStyleVar(2);


		ImGui.DockSpace(201, width, height);

		drawTestListWindow();
		gameWindow.render();

		ImGui.End();

		ImGui.Render();
		DrawData drawData = ImGui.GetDrawData();
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
