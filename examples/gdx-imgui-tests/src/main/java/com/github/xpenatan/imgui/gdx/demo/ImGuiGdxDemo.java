package com.github.xpenatan.imgui.gdx.demo;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.github.xpenatan.imgui.DrawData;
import com.github.xpenatan.imgui.ImGui;
import com.github.xpenatan.imgui.ImGuiBoolean;
import com.github.xpenatan.imgui.ImGuiCustomWidgetNative.ImGuiLayout;
import com.github.xpenatan.imgui.ImGuiEx;
import com.github.xpenatan.imgui.ImGuiFloat;
import com.github.xpenatan.imgui.ImGuiInt;
import com.github.xpenatan.imgui.ImGuiString;
import com.github.xpenatan.imgui.enums.ImGuiConfigFlags;
import com.github.xpenatan.imgui.enums.ImGuiDir;
import com.github.xpenatan.imgui.enums.ImGuiInputTextFlags;
import com.github.xpenatan.imgui.enums.ImGuiTabBarFlags;
import com.github.xpenatan.imgui.enums.ImGuiTreeNodeFlags;
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

	ShapeRenderer shapeRenderer;
	ShapeRenderer pointRenderer;
	OrthographicCamera uiCam;

	SpriteBatch batch;

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
	ImGuiBoolean isCollapseOpen2 = new ImGuiBoolean();

	Texture buttonTexture;

	static ImGuiFloat alignX = new ImGuiFloat(0.5f);
	static ImGuiFloat offsetX = new ImGuiFloat(0.0f);
	static ImGuiFloat alignY = new ImGuiFloat(0.5f);
	static ImGuiFloat offsetY = new ImGuiFloat(0.0f);

	boolean init = false;
	@Override
	public void create () {
		uiCam = new OrthographicCamera();
		shapeRenderer = new ShapeRenderer();
		pointRenderer = new ShapeRenderer();
		uiCam.setToOrtho(true);
		batch = new SpriteBatch();
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

		uiCam.update();
		batch.setProjectionMatrix(uiCam.combined);
		shapeRenderer.setProjectionMatrix(uiCam.combined);
		shapeRenderer.begin(ShapeType.Line);
		pointRenderer.setProjectionMatrix(uiCam.combined);
		pointRenderer.begin(ShapeType.Point);

		if(init == false) {
			init = true;
			ImGui.SetNextWindowSize(400, 400);
		}

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

		shapeRenderer.end();
		pointRenderer.end();
	}

	private void renderCollapseUI() {
		ImGuiEx.BeginCollapseLayoutEx(isCollapseOpen, "Stuff", ImLayout.MATCH_PARENT, ImLayout.WRAP_PARENT);

		ImGuiEx.ShowLayoutDebug();

		ImGuiEx.BeginAlign("#ID", ImLayout.MATCH_PARENT, ImLayout.MATCH_PARENT, 1.0f, 0.5f, -5, 0);
		ImGui.Button("Ok");
		ImGui.SameLine();
		ImGui.Text("Custom Align");
		ImGuiEx.EndAlign();

		ImGuiEx.EndCollapseFrameLayout();
		if(isCollapseOpen.getValue())
		{
			ImGuiEx.BeginCollapseLayout(isCollapseOpen2, "Alignment options", ImLayout.MATCH_PARENT, ImLayout.WRAP_PARENT);
			if(isCollapseOpen2.getValue())
			{
				ImGui.SliderFloat("AlignX", alignX, 0.0f, 1.0f, "%.2f");
				ImGui.SliderFloat("OffsetX", offsetX, -10.0f, 10.0f, "%.2f");
				ImGui.SliderFloat("AlignY", alignY, 0.0f, 1.0f, "%.2f");
				ImGui.SliderFloat("OffsetY", offsetY, -10.0f, 10.0f, "%.2f");
			}
			ImGuiEx.EndCollapseLayout();

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

			ImGuiEx.BeginAlign("##ID", ImLayout.MATCH_PARENT, 200, alignX.getValue(), alignY.getValue(), offsetX.getValue(), offsetY.getValue());
			ImGuiEx.ShowLayoutDebug();
			ImGui.Image(buttonTexture.getTextureObjectHandle(), 32, 32);
			ImGui.ImageButton(buttonTexture.getTextureObjectHandle(), 42, 42);

			ImGuiEx.EndAlign();
		}
		ImGuiEx.EndCollapseLayout();
	}

	private void renderLayout() {
		float mouseX = Gdx.input.getX();
		float mouseY = Gdx.input.getY();



		batch.begin();
		batch.draw(buttonTexture, 1, 4);
		batch.end();

//		pointRenderer.point(1, 1, 0);
//		shapeRenderer.line(1, 1, 1 + 5, 1 + 0);
//		shapeRenderer.line(1 + 1, 1, 1 + 1 + 0, 1 + 5);

		System.out.println("buttonTexture.getHeight(): " + buttonTexture.getHeight());
//		shapeRenderer.rect(1 + 1, 1 + 1, buttonTexture.getWidth()-1, buttonTexture.getHeight());

//		pointRenderer.point(mouseX, mouseY, 0);
//		pointRenderer.point(mouseX+1, mouseY, 0);
//		shapeRenderer.line(mouseX, mouseY, mouseX + 5, mouseY + 0);
//		shapeRenderer.line(mouseX, mouseY, mouseX + 0, mouseY + 5);

		ImGuiEx.BeginLayout("Stuff", 4, 32);
		ImGuiLayout curLayout = ImGuiEx.GetCurrentLayout();
		float posX = curLayout.positionX;
		float posY = curLayout.positionY;
		float sizeX = curLayout.sizeX;
		float sizeY = curLayout.sizeY;

		float posSizeX = posX + sizeX;
		float posSizeY = posY + sizeY;

//		shapeRenderer.rect(posX, posY, sizeX, sizeY);
//		shapeRenderer.line(posX, posY, posSizeX, posY);
//		shapeRenderer.line(posSizeX, posY, posSizeX, posSizeY);
//		shapeRenderer.line(posSizeX, posSizeY, posX, posSizeY);
//		shapeRenderer.line(posX, posSizeY, posX, posY);
//		shapeRenderer.line(posX, posY, posX, posSizeY);

		ImGuiEx.ShowLayoutDebug();


		ImGuiEx.EndLayout();

		ImGui.Text("MouseX: " + mouseX);
		ImGui.SameLine();
		ImGui.Text("MouseY: " + mouseY);
		ImGui.Text("posX: " + posX);
		ImGui.Text("posY: " + posY);
		ImGui.Text("posSizeX: " + posSizeX);
		ImGui.Text("posSizeY: " + posSizeY);

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
			if (ImGui.BeginTabItem("Layout Test")) {
				renderLayout();
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
