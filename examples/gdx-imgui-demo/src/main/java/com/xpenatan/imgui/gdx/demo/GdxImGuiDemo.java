package com.xpenatan.imgui.gdx.demo;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.xpenatan.imgui.ImGuiBoolean;
import com.xpenatan.imgui.ImGuiDir;
import com.xpenatan.imgui.ImGuiInt;
import com.xpenatan.imgui.gdx.GdxDrawData;
import com.xpenatan.imgui.gdx.GdxImGui;

public class GdxImGuiDemo implements ApplicationListener
{
	public static void main (String[] args)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1444;
		config.height = 800;
		config.title = "Gdx-imgui";
		config.vSyncEnabled = true;
		new LwjglApplication(new GdxImGuiDemo(), config);
	}

	private GdxImGui imGui;

	ImGuiBoolean guiBool = new ImGuiBoolean();
	ImGuiInt guiInt = new ImGuiInt();

	@Override
	public void create ()
	{
		OrthographicCamera uiCam = new OrthographicCamera();
		uiCam.setToOrtho(true);
		GdxImGui.init();
		imGui = new GdxImGui();
	}

	@Override
	public void render ()
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();
		int backBufferWidth = Gdx.graphics.getBackBufferWidth();
		int backBufferHeight = Gdx.graphics.getBackBufferHeight();

		boolean mouseDown0 = Gdx.input.isButtonPressed(Buttons.LEFT);
		boolean mouseDown1 = Gdx.input.isButtonPressed(Buttons.RIGHT);
		boolean mouseDown2 = Gdx.input.isButtonPressed(Buttons.MIDDLE);
		imGui.updateDisplayAndInputAndFrame(Gdx.graphics.getDeltaTime(), width, height, backBufferWidth, backBufferHeight,
				Gdx.input.getX(), Gdx.input.getY(), mouseDown0, mouseDown1, mouseDown2);

//		imGui.setNextWindowPos(0,0);
		imGui.setNextWindowSize(400, 400);
		imGui.begin("Hello World");

		imGui.checkbox("CheckBox", guiBool);
		imGui.button("CheckBox");

		imGui.arrowButton("##Left", ImGuiDir.ImGuiDir_Left);
		imGui.sameLine();
		imGui.arrowButton("##Right", ImGuiDir.ImGuiDir_Right);
		imGui.sameLine();
		imGui.arrowButton("##Up", ImGuiDir.ImGuiDir_Up);
		imGui.sameLine();
		imGui.arrowButton("##Down", ImGuiDir.ImGuiDir_Down);

		imGui.radioButton("radio a", guiInt, 0);
		imGui.sameLine();
		imGui.radioButton("radio b", guiInt, 1);
		imGui.sameLine();
		imGui.radioButton("radio c", guiInt, 2);
		imGui.sameLine();
		imGui.radioButton("radio true", true);

		imGui.bullet();
		imGui.sameLine();
		imGui.text("Bullet text");
		imGui.end();


		imGui.showDemoWindow(false);

		imGui.render();

		GdxDrawData drawData = imGui.getDrawData();

		drawData.render();
	}

	@Override
	public void resize (int width, int height)
	{
	}

	@Override
	public void pause ()
	{
	}

	@Override
	public void resume ()
	{
	}

	@Override
	public void dispose ()
	{
	}
}
