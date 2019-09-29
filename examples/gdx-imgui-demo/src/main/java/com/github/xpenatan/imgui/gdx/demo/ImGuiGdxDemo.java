package com.github.xpenatan.imgui.gdx.demo;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.github.xpenatan.imgui.DrawData;
import com.github.xpenatan.imgui.ImGui;
import com.github.xpenatan.imgui.ImGuiBoolean;
import com.github.xpenatan.imgui.ImGuiFloat;
import com.github.xpenatan.imgui.ImGuiInt;
import com.github.xpenatan.imgui.ImGuiString;
import com.github.xpenatan.imgui.enums.ImGuiConfigFlags;
import com.github.xpenatan.imgui.enums.ImGuiDir;
import com.github.xpenatan.imgui.enums.ImGuiInputTextFlags;
import com.github.xpenatan.imgui.enums.ImGuiStyleVar;
import com.github.xpenatan.imgui.enums.ImGuiTabBarFlags;
import com.github.xpenatan.imgui.enums.ImGuiTreeNodeFlags;
import com.github.xpenatan.imgui.enums.ImGuiWindowFlags;
import com.github.xpenatan.imgui.enums.ImLayout;
import com.github.xpenatan.imgui.gdx.ImGuiGdxImpl;
import com.github.xpenatan.imgui.gdx.ImGuiGdxInput;

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
	ImGuiBoolean dockBool = new ImGuiBoolean();
	ImGuiInt guiInt = new ImGuiInt();
	ImGuiInt listSelected = new ImGuiInt();

	String [] myList = new String [] {"111", "222", "333", "444"};

	int treeSelected = -1;

	ImGuiString myText =  new ImGuiString("Hello");
	ImGuiFloat dragFloat =  new ImGuiFloat(0.0f);
	ImGuiFloat dragFloat2 =  new ImGuiFloat(1.0f);
	ImGuiFloat sliderFloat =  new ImGuiFloat(0.5f);

	ImGuiBoolean isCollapseOpen = new ImGuiBoolean();

	Texture buttonTexture;

	static ImGuiFloat alignX = new ImGuiFloat(0.5f);
	static ImGuiFloat contentAlignX = new ImGuiFloat(0.5f);
	static ImGuiFloat paddingX = new ImGuiFloat(0.0f);
	static ImGuiFloat alignY = new ImGuiFloat(0.5f);
	static ImGuiFloat contentAlignY = new ImGuiFloat(0.5f);
	static ImGuiFloat paddingY = new ImGuiFloat(0.0f);

	@Override
	public void create () {
		OrthographicCamera uiCam = new OrthographicCamera();
		uiCam.setToOrtho(true);
		ImGui.init();
		ImGui.GetIO().SetConfigFlags(ImGuiConfigFlags.DockingEnable);
		ImGui.GetIO().SetDockingFlags(false, false, false, false);

		buttonTexture = new Texture(Gdx.files.internal("data/badlogicsmall.jpg"));

		ImGuiGdxInput input = new ImGuiGdxInput();
		impl = new ImGuiGdxImpl(input);
		Gdx.input.setInputProcessor(input);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
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

		renderCollapseUI();

		ImGui.ListBox("MyList", listSelected, myList, myList.length);
		ImGui.End();

		ImGui.ShowDemoWindow(false);

		ImGui.Render();
		DrawData drawData = ImGui.GetDrawData();
		impl.render(drawData);
	}

	private void renderCollapseUI() {
		ImGui.BeginCollapseLayoutEx(isCollapseOpen, "Stuff", ImLayout.MATCH_PARENT, ImLayout.WRAP_PARENT);

		ImGui.BeginAlign("#ID", ImLayout.MATCH_PARENT, ImLayout.MATCH_PARENT, 1.0f, 0.5f, 1.0f, 0.5f, -5, 0);
		ImGui.Button("Ok");
		ImGui.SameLine();
		ImGui.Text("Custom Align");
		ImGui.EndAlign();

		ImGui.EndCollapseFrameLayout();
		if(isCollapseOpen.getValue())
		{
			ImGui.SliderFloat("AlignX", alignX, 0.0f, 1.0f, "%.2f");
			ImGui.SliderFloat("ContentAlignX", contentAlignX, 0.0f, 1.0f, "%.2f");
			ImGui.SliderFloat("PaddingX", paddingX, -10.0f, 10.0f, "%.2f");
			ImGui.SliderFloat("AlignY", alignY, 0.0f, 1.0f, "%.2f");
			ImGui.SliderFloat("ContentAlignY", contentAlignY, 0.0f, 1.0f, "%.2f");
			ImGui.SliderFloat("paddingY", paddingY, -10.0f, 10.0f, "%.2f");
			ImGui.ShowAlignDebug();

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

			ImGui.BeginAlign("##ID", ImLayout.MATCH_PARENT, 200, alignX.getValue(), alignY.getValue(), contentAlignX.getValue(), contentAlignY.getValue(), paddingX.getValue(), paddingY.getValue());
			ImGui.ShowAlignDebug();
			ImGui.Image(buttonTexture.getTextureObjectHandle(), 32, 32);
			ImGui.ImageButton(buttonTexture.getTextureObjectHandle(), 42, 42);

			ImGui.EndAlign();
		}
		ImGui.EndCollapseLayout();
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
							flags = flags.or(ImGuiTreeNodeFlags.Selected);
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
