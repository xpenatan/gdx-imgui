package com.github.xpenatan.imgui.example.gdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.backends.lwjgl3.ImGuiLWJGL3Impl;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.xpenatan.imgui.*;
import com.github.xpenatan.imgui.custom.EditTextFloatData;
import com.github.xpenatan.imgui.custom.EditTextIntData;
import com.github.xpenatan.imgui.custom.EditTextStringData;
import com.github.xpenatan.imgui.custom.ImGuiLayout;
import com.github.xpenatan.imgui.enums.*;
import com.github.xpenatan.imgui.gdx.ImGuiGdxImpl;
import com.github.xpenatan.imgui.gdx.ImGuiGdxInput;
import com.github.xpenatan.imgui.gdx.ImGuiGdxInputMultiplexer;

public class SimpleExample implements ApplicationListener
{
	public static void main (String[] args) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(1444, 800);
		config.setTitle("Gdx-imgui");
		config.useVsync(true);
		new Lwjgl3Application(new SimpleExample(), config);
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

	ImGuiString myText =  new ImGuiString(100, "Hello");
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

	EditTextFloatData dF1 = new EditTextFloatData("X:", "Tooltip 01", ImGui.ColorToIntBits(255, 0, 0, 255), 0);
	EditTextFloatData dF2 = new EditTextFloatData("Y:", "Tooltip 02");
	EditTextFloatData dF3 = new EditTextFloatData("Z:", "Tooltip 03");

	EditTextIntData dI1 = new EditTextIntData("X:", "Tooltip 01", ImGui.ColorToIntBits(255, 0, 0, 255), 0);
	EditTextIntData dI2 = new EditTextIntData("Y:", "Tooltip 02");
	EditTextIntData dI3 = new EditTextIntData("Z:", "Tooltip 03");
	EditTextStringData dS1 = new EditTextStringData("S:", "Tooltip String");

	private String dragDropValue;

	ImColor color = new ImColor(0, 0, 255, 0);
	ImColor color2 = new ImColor(0.0f, 1.0f, 0.0f, 1.0f);

	boolean init = false;
	@Override
	public void create () {
		uiCam = new OrthographicCamera();
		uiCam.setToOrtho(true);
		batch = new SpriteBatch();
		ImGui.init();
		ImGuiExt.init();
//		ImGui.GetIO().SetConfigFlags(ImGuiConfigFlags.DockingEnable.or(ImGuiConfigFlags.ViewportsEnable));
		ImGui.GetIO().SetConfigFlags(ImGuiConfigFlags.DockingEnable);
		ImGui.GetIO().SetDockingFlags(false, false, false, false);

		buttonTexture = new Texture(Gdx.files.internal("data/badlogicsmall.jpg"));

		ImGuiGdxInputMultiplexer input = new ImGuiGdxInputMultiplexer();
		impl = new ImGuiLWJGL3Impl();
		Gdx.input.setInputProcessor(input);

		dS1.setValue("Test");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		impl.update();

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
		ImDrawData drawData = ImGui.GetDrawData();
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

	private void addItem(String text) {
		ImGui.TableNextColumn();
		ImGui.Text(text);
	}

	private void renderTabImGuiViews() {
		renderColorWidget();
		ImGui.Text("jDear-ImGui VersionCode: " + ImGui.VERSION_CODE);

		if (ImGui.BeginTable("split2", 2, ImGuiTableFlags.Sortable)) {
			ImGui.TableSetupColumn("A0", ImGuiTableColumnFlags.PreferSortAscending);
			ImGui.TableSetupColumn("A1", ImGuiTableColumnFlags.PreferSortAscending);

			ImGui.TableHeadersRow();

			ImGui.TableGetSortSpecs();

			addItem("AAAA1");

			addItem("BBBB2");

			addItem("BBBB1");

			addItem("CCCC2");

			addItem("CCCC1");

			addItem("DDDD2");




			ImGui.EndTable();
		}

		testDragAndDrop();

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
		if(ImGui.InputText("InputText", myText, ImGuiInputTextFlags.EnterReturnsTrue)) {
			String value = myText.getValue();
			System.out.println("Value: " + value);
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

		boolean openSave = false;
		if (ImGui.BeginMainMenuBar()) {
			ImVec2 imVec2 = ImGui.GetWindowSize();
			if (ImGui.BeginMenu("File")) {
				if (ImGui.MenuItem("New Project")) {

				}
				if (ImGui.MenuItem("Open Project")) {

				}
				if (ImGui.MenuItem("Save Scene As..")) {
					openSave = true;
				}
				if (ImGui.MenuItem("Open Scene")) {

				}
				ImGui.EndMenu();
			}
			ImGui.EndMainMenuBar();
		}

		if(openSave) {
			openSave = false;
			ImGui.OpenPopup("testt");
		}

		if (ImGui.BeginPopupModal("testt"))
		{
			if (ImGui.Button("Close"))
				ImGui.CloseCurrentPopup();

			ImGui.EndPopup();
		}
	}

	private void testDragAndDrop() {
		ImGui.Button("DragMe Integer");
		if (ImGui.BeginDragDropSource())
		{
			ImGui.SetDragDropPayload("DND_DEMO_CELL", 100);
			ImGui.Text("This is a drag and drop source");
			ImGui.EndDragDropSource();
		}

		ImGui.Button("DragMe String");
		if (ImGui.BeginDragDropSource())
		{
			ImGui.SetDragDropPayload("DND_DEMO_CELL", "MyCoolText");
			ImGui.Text("This is a drag and drop source");
			ImGui.EndDragDropSource();
		}

		ImGui.Button("Drop Here");
		if (ImGui.BeginDragDropTarget())
		{
			Integer intValue = ImGui.AcceptDragDropPayload("DND_DEMO_CELL", Integer.class);
			if(intValue != null) {
				dragDropValue = String.valueOf(intValue);
				ImGui.OpenPopup("ShowModal");
			}
			String stringValue = ImGui.AcceptDragDropPayload("DND_DEMO_CELL", String.class);
			if(stringValue != null) {
				dragDropValue = stringValue;
				ImGui.OpenPopup("ShowModal");
			}

			Integer currentIntValue = ImGui.GetDragDropPayload(Integer.class);
			String currentStringValue = ImGui.GetDragDropPayload(String.class);

			System.out.println("currentIntValue: " + currentIntValue);
			System.out.println("currentStringValue: " + currentStringValue);

			ImGui.EndDragDropTarget();
		}
		if (ImGui.BeginPopupModal("ShowModal", ImGuiWindowFlags.AlwaysAutoResize)) {
			ImGui.Text(dragDropValue);
			if (ImGui.Button("OK", 120, 0)) {
				ImGui.CloseCurrentPopup();
			}
			ImGui.EndPopup();
		}
	}

	private void renderTabImGuiExtViews() {

		testContentSize();

		dF1.leftLabelDragColor = ImGui.ColorToIntBits(255, 255, 0, 255);
		dF2.format = "%.2f";
		dF3.v_min = -5f;
		dF3.v_max = 5f;
		dF3.v_speed = 0.01f;
		int index = ImGuiExt.EditTextF("##1", dF1, dF2, dF3);

		if(index != -1) {
			System.out.println("index: " + index);
			System.out.println("dF1.isDragging: " + dF1.isDragging);
			System.out.println("dF2.isDragging: " + dF2.isDragging);
			System.out.println("dF3.isDragging: " + dF3.isDragging);
		}

		dI3.v_min = -25;
		dI3.v_max = 25;

		ImGuiExt.EditTextI("##1", dI1, dI2, dI3);

		if(ImGuiExt.EditTextS("##S", dS1)) {
			String newValue = dS1.getValue();
			int length = newValue.length();
			System.out.println("newValue: " + newValue);
		}

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

	public void renderColorWidget() {
		ImGui.ColorPicker3("ColorPicker3", color);
		ImGui.ColorEdit3("ColorEdit3", color2);
		ImGuiColorEditFlags flag = ImGuiColorEditFlags.PickerHueWheel;
		ImGui.ColorPicker4("ColorPicker4", color, flag);
		ImGui.ColorEdit4("ColorEdit4", color2);
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
		impl.dispose();
		ImGui.dispose();
	}
}
