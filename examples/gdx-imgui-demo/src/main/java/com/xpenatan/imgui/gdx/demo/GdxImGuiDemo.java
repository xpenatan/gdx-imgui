package com.xpenatan.imgui.gdx.demo;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.xpenatan.imgui.DrawData;
import com.xpenatan.imgui.ImGui;
import com.xpenatan.imgui.ImGuiBoolean;
import com.xpenatan.imgui.ImGuiDir;
import com.xpenatan.imgui.ImGuiInt;
import com.xpenatan.imgui.gdx.GdxImGuiRenderer;

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


	GdxImGuiRenderer impl;
	ImGuiBoolean guiBool = new ImGuiBoolean();
	ImGuiInt guiInt = new ImGuiInt();

	@Override
	public void create ()
	{
		OrthographicCamera uiCam = new OrthographicCamera();
		uiCam.setToOrtho(true);
		ImGui.init();
		impl = new GdxImGuiRenderer();
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
		ImGui.UpdateDisplayAndInputAndFrame(Gdx.graphics.getDeltaTime(), width, height, backBufferWidth, backBufferHeight,
				Gdx.input.getX(), Gdx.input.getY(), mouseDown0, mouseDown1, mouseDown2);

//		ImGui.setNextWindowPos(0,0);
		ImGui.SetNextWindowSize(400, 400);
		ImGui.Begin("Hello World");

		ImGui.Checkbox("CheckBox", guiBool);
		ImGui.Button("CheckBox");

		ImGui.ArrowButton("##Left", ImGuiDir.ImGuiDir_Left);
		ImGui.SameLine();
		ImGui.ArrowButton("##Right", ImGuiDir.ImGuiDir_Right);
		ImGui.SameLine();
		ImGui.ArrowButton("##Up", ImGuiDir.ImGuiDir_Up);
		ImGui.SameLine();
		ImGui.ArrowButton("##Down", ImGuiDir.ImGuiDir_Down);

		ImGui.RadioButton("radio a", guiInt, 0);
		ImGui.SameLine();
		ImGui.RadioButton("radio b", guiInt, 1);
		ImGui.SameLine();
		ImGui.RadioButton("radio c", guiInt, 2);
		ImGui.SameLine();
		ImGui.RadioButton("radio true", true);

		ImGui.Bullet();
		ImGui.SameLine();
		ImGui.Text("Bullet text");
		ImGui.End();

		ImGui.ShowDemoWindow(false);

		ImGui.Render();
		DrawData drawData = ImGui.GetDrawData();
		impl.render(drawData);
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
