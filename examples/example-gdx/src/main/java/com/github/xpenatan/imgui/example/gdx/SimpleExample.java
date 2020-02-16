package com.github.xpenatan.imgui.example.gdx;

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
import com.github.xpenatan.imgui.*;
import com.github.xpenatan.imgui.custom.EditTextFloatData;
import com.github.xpenatan.imgui.custom.EditTextIntData;
import com.github.xpenatan.imgui.custom.ImGuiLayout;
import com.github.xpenatan.imgui.enums.ImGuiConfigFlags;
import com.github.xpenatan.imgui.enums.ImGuiDir;
import com.github.xpenatan.imgui.enums.ImGuiInputTextFlags;
import com.github.xpenatan.imgui.enums.ImGuiTabBarFlags;
import com.github.xpenatan.imgui.enums.ImGuiTreeNodeFlags;
import com.github.xpenatan.imgui.enums.ImLayout;
import com.github.xpenatan.imgui.gdx.ImGuiGdxImpl;
import com.github.xpenatan.imgui.gdx.ImGuiGdxInput;

public class SimpleExample implements ApplicationListener
{
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1444;
		config.height = 800;
		config.title = "Gdx-imgui";
		config.vSyncEnabled = true;
		new LwjglApplication(new SimpleExample(), config);
	}

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

	ImGuiFloat alignX = new ImGuiFloat(0.5f);
	ImGuiFloat offsetX = new ImGuiFloat(0.0f);
	ImGuiFloat alignY = new ImGuiFloat(0.5f);
	ImGuiFloat offsetY = new ImGuiFloat(0.0f);

	EditTextFloatData dF1 = new EditTextFloatData("X:", "Tooltip 01", ImGuiExt.colorToIntBits(255, 0, 0, 255), 0);
	EditTextFloatData dF2 = new EditTextFloatData("Y:", "Tooltip 02");
	EditTextFloatData dF3 = new EditTextFloatData("Z:", "Tooltip 03");

	EditTextIntData dI1 = new EditTextIntData("X:", "Tooltip 01", ImGuiExt.colorToIntBits(255, 0, 0, 255), 0);
	EditTextIntData dI2 = new EditTextIntData("Y:", "Tooltip 02");
	EditTextIntData dI3 = new EditTextIntData("Z:", "Tooltip 03");

	boolean init = false;
	@Override
	public void create () {
		uiCam = new OrthographicCamera();
		uiCam.setToOrtho(true);
		batch = new SpriteBatch();
		ImGui.init();
		ImGuiExt.init();
		ImGui.GetIO().SetConfigFlags(ImGuiConfigFlags.DockingEnable);
		ImGui.GetIO().SetDockingFlags(false, false, false, false);

		buttonTexture = new Texture(Gdx.files.internal("data/badlogicsmall.jpg"));

		ImGuiGdxInput input = new ImGuiGdxInput();
		impl = new ImGuiGdxImpl();
		Gdx.input.setInputProcessor(input);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		boolean mode01 = false;
		if(mode01) {
			// use ImGui method which requires some input from gdx
			int width = Gdx.graphics.getWidth();
			int height = Gdx.graphics.getHeight();
			int backBufferWidth = Gdx.graphics.getBackBufferWidth();
			int backBufferHeight = Gdx.graphics.getBackBufferHeight();
			boolean mouseDown0 = Gdx.input.isButtonPressed(Buttons.LEFT);
			boolean mouseDown1 = Gdx.input.isButtonPressed(Buttons.RIGHT);
			boolean mouseDown2 = Gdx.input.isButtonPressed(Buttons.MIDDLE);
			ImGui.UpdateDisplayAndInputAndFrame(Gdx.graphics.getDeltaTime(), width, height, backBufferWidth, backBufferHeight,
					Gdx.input.getX(), Gdx.input.getY(), mouseDown0, mouseDown1, mouseDown2);
		}
		else {
			// Or use from Impl object which does it for you
			impl.update();
		}

		uiCam.update();
		batch.setProjectionMatrix(uiCam.combined);

		if(init == false) {
			init = true;
			ImGui.SetNextWindowSize(400, 400);
		}

		ImGui.Begin("Hello World");

		renderTabTree();

		ImGui.End();

		ImGui.ShowDemoWindow(false);

		ImGui.Render();
		DrawData drawData = ImGui.GetDrawData();
		impl.render(drawData);

	}

	private void renderTabTree() {
		ImGuiTabBarFlags tab_bar_flags = ImGuiTabBarFlags.Reorderable;
		if (ImGui.BeginTabBar("MyTabBar", tab_bar_flags)) {
			if (ImGui.BeginTabItem("ImGui Views")) {
				renderTabImGuiViews();
				ImGui.EndTabItem();
			}
			if (ImGui.BeginTabItem("ImGuiExt Views")) {
				renderTabImGuiExtViews();
				ImGui.EndTabItem();
			}
			ImGui.EndTabBar();
		}
	}

	private void renderTabImGuiViews() {
		ImGui.Text("MyText");

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

		ImGui.ListBox("MyList", listSelected, myList, myList.length);

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

	}

	private void renderTabImGuiExtViews() {

		testContentSize();

		dF1.leftLabelDragColor = ImGuiExt.colorToIntBits(255, 255, 0, 255);
		dF2.format = "%.2f";
		dF3.v_min = -5f;
		dF3.v_max = 5f;
		dF3.v_speed = 0.01f;
		int index = ImGuiExt.EditTextF("##1", dF1, dF2, dF3);

		if(index != -1)
			System.out.println("index: " + index);

		dI3.v_min = -25;
		dI3.v_max = 25;

		ImGuiExt.EditTextI("##1", dI1, dI2, dI3);

		testContentSize();

		float mouseX = Gdx.input.getX();
		float mouseY = Gdx.input.getY();

		ImGuiExt.BeginLayout("Stuff", ImLayout.WRAP_PARENT, ImLayout.WRAP_PARENT);
		ImGuiExt.ShowLayoutDebug();
		ImGuiLayout curLayout = ImGuiExt.GetCurrentLayout();
		float posX = curLayout.positionX;
		float posY = curLayout.positionY;
		float sizeX = curLayout.sizeX;
		float sizeY = curLayout.sizeY;
		float posSizeX = posX + sizeX;
		float posSizeY = posY + sizeY;


		ImGui.Text("MouseX: " + mouseX);
		ImGui.SameLine();
		ImGui.Text("MouseY: " + mouseY);
		ImGui.Text("posX: " + posX);
		ImGui.Text("posY: " + posY);
		ImGui.Text("posSizeX: " + posSizeX);
		ImGui.Text("posSizeY: " + posSizeY);

		ImGuiExt.EndLayout();

		renderExtCollapseUI();
	}

	private void testContentSize() {
		ImGuiExt.BeginBoundingBox();
		ImGui.Button("Label");
		ImGui.Button("Label Test");
		ImRect boundingBox = ImGuiExt.EndBoundingBox();
		ImGuiExt.DrawBoundingBox(boundingBox.minX, boundingBox.minY, boundingBox.maxX, boundingBox.maxY, 255, 0, 0, 255);
	}

	private void renderExtCollapseUI() {
		ImGuiExt.BeginCollapseLayoutEx("##ID1", isCollapseOpen, "Stuff", ImLayout.MATCH_PARENT, ImLayout.WRAP_PARENT);

		ImGuiExt.ShowLayoutDebug();

		ImGuiExt.BeginAlign("##ID2", ImLayout.MATCH_PARENT, ImLayout.MATCH_PARENT, 1.0f, 0.5f, -5, 0);
		ImGui.Button("Ok");
		ImGui.SameLine();
		ImGui.Text("Custom Align");
		ImGuiExt.EndAlign();

		ImGuiExt.EndCollapseFrameLayout();
		if(isCollapseOpen.getValue())
		{
			ImGuiExt.BeginCollapseLayout("##ID3", isCollapseOpen2, "Alignment options", ImLayout.MATCH_PARENT, ImLayout.WRAP_PARENT);
			if(isCollapseOpen2.getValue())
			{
				ImGui.SliderFloat("AlignX", alignX, 0.0f, 1.0f, "%.2f");
				ImGui.SliderFloat("OffsetX", offsetX, -10.0f, 10.0f, "%.2f");
				ImGui.SliderFloat("AlignY", alignY, 0.0f, 1.0f, "%.2f");
				ImGui.SliderFloat("OffsetY", offsetY, -10.0f, 10.0f, "%.2f");
			}
			ImGuiExt.EndCollapseLayout();

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

			ImGuiExt.BeginAlign("##ID4", ImLayout.MATCH_PARENT, 200, alignX.getValue(), alignY.getValue(), offsetX.getValue(), offsetY.getValue());
			ImGuiExt.ShowLayoutDebug();
			ImGui.Image(buttonTexture.getTextureObjectHandle(), 32, 32);
			ImGui.ImageButton(buttonTexture.getTextureObjectHandle(), 42, 42);

			ImGuiExt.EndAlign();
		}
		ImGuiExt.EndCollapseLayout();
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
