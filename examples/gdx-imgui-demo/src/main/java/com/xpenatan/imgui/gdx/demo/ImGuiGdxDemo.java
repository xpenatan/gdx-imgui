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
import com.xpenatan.imgui.ImGuiFloat;
import com.xpenatan.imgui.ImGuiInt;
import com.xpenatan.imgui.ImGuiString;
import com.xpenatan.imgui.enums.ImGuiDir;
import com.xpenatan.imgui.enums.ImGuiInputTextFlags;
import com.xpenatan.imgui.enums.ImGuiTabBarFlags;
import com.xpenatan.imgui.enums.ImGuiTreeNodeFlags;
import com.xpenatan.imgui.gdx.ImGuiGdxImpl;
import com.xpenatan.imgui.gdx.ImGuiGdxInput;

public class ImGuiGdxDemo implements ApplicationListener
{
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1444;
		config.height = 800;
		config.title = "Gdx-imgui";
		config.vSyncEnabled = true;
		new LwjglApplication(new ImGuiGdxDemo(), config);
	}


	ImGuiGdxImpl impl;
	ImGuiBoolean guiBool = new ImGuiBoolean();
	ImGuiInt guiInt = new ImGuiInt();
	ImGuiInt listSelected = new ImGuiInt();

	String [] myList = new String [] {"111", "222", "333", "444"};

	int treeSelected = -1;

	ImGuiString myText =  new ImGuiString("Hello");
	ImGuiFloat dragFloat =  new ImGuiFloat(0.0f);
	ImGuiFloat dragFloat2 =  new ImGuiFloat(1.0f);
	ImGuiFloat sliderFloat =  new ImGuiFloat(0.5f);

	@Override
	public void create () {
		OrthographicCamera uiCam = new OrthographicCamera();
		uiCam.setToOrtho(true);
		ImGui.init();

		ImGuiGdxInput input = new ImGuiGdxInput();
		impl = new ImGuiGdxImpl(input);
		Gdx.input.setInputProcessor(input);
	}

	@Override
	public void render () {
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
		ImGui.Begin("Hello World");

		renderTabTree();


		// Edittext
		if(ImGui.InputText("", myText, ImGuiInputTextFlags.EnterReturnsTrue)) {
		}

		// Show edittext text
		ImGui.Text(myText.getValue());

		ImGui.DragFloat("DragFloat", dragFloat);

		ImGui.Text("DragFloat2");
		ImGui.SameLine();
		ImGui.SetNextItemWidth(-1);
		ImGui.DragFloat("DragFloat22", dragFloat2, 0.01f, 0, 0, "%.2f");

		ImGui.SliderFloat("SliderFloat", sliderFloat, 0.0f, 1.0f, "%.2f", 1.0f);

		ImGui.Checkbox("CheckBox", guiBool);

		ImGui.Button("Button");

		ImGui.ArrowButton("##Left", ImGuiDir.Left);
		ImGui.SameLine();
		ImGui.ArrowButton("##Right", ImGuiDir.Right);
		ImGui.SameLine();
		ImGui.ArrowButton("##Up", ImGuiDir.Up);
		ImGui.SameLine();
		ImGui.ArrowButton("##Down", ImGuiDir.Down);

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

		ImGui.ListBox("MyList", listSelected, myList, myList.length);
		ImGui.End();

		ImGui.ShowDemoWindow(false);

		ImGui.Render();
		DrawData drawData = ImGui.GetDrawData();
		impl.render(drawData);
	}

	private void renderTabTree() {
		ImGuiTabBarFlags tab_bar_flags = ImGuiTabBarFlags.Reorderable;
		if (ImGui.BeginTabBar("MyTabBar", tab_bar_flags)) {
			if (ImGui.BeginTabItem("TAB 01")) {
				ImGui.Text("MyText");
				ImGui.EndTabItem();
			}
			if (ImGui.BeginTabItem("TAB 02")) {
				if (ImGui.TreeNode("Parent 01")) {
					for (int i = 0; i < 5; i++) {
						ImGuiTreeNodeFlags flags = ImGuiTreeNodeFlags.Leaf;
						if (i == treeSelected) {
							flags = flags.and(ImGuiTreeNodeFlags.Selected);
						}
						if (ImGui.TreeNodeEx(i, flags, "Leaf " + i)) {
							if (ImGui.IsItemClicked()) {
								if (treeSelected == i)
									treeSelected = -1;
								else
									treeSelected = i;
							}
							ImGui.TreePop();
						}
					}
					ImGui.TreePop();
				}
				if (ImGui.TreeNode("Parent 02")) {
					ImGui.TreePop();
				}
				if (ImGui.TreeNode("Parent 03")) {
					ImGui.TreePop();
				}
				ImGui.EndTabItem();
			}
			ImGui.EndTabBar();
		}
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
