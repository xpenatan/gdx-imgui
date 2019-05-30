package com.xpenatan.imgui.gdx.widgets;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.xpenatan.imgui.ImGui;
import com.xpenatan.imgui.ImVec2;
import com.xpenatan.imgui.enums.ImGuiCol;
import com.xpenatan.imgui.enums.ImGuiHoveredFlags;
import com.xpenatan.imgui.enums.ImGuiWindowFlags;
import com.xpenatan.imgui.gdx.utils.EmuApplicationWindow;

/**
 *
 *	Emulate gdx application inside a ImGui window
 *
 * @author xpenatan
 */
public class ImGuiGdxGameWindow {

	private EmuApplicationWindow emuWindow;

	private boolean initWindowSize;

	int startWidth;
	int startHeight;

	private String name = "";
	private String beginID = "BeginID";
	private String btnId = "btnId";

	private String widthLabel = "Width: ";
	private String heightLabel = " Height: ";
	private String mouseXLabel = " X: ";
	private String mouseYLabel = " Y: ";

	public int activeColor = Color.GREEN.toIntBits();

	private boolean curFrameFocus;
	private boolean isWindowHovered;

	public ImGuiGdxGameWindow(int width, int height) {
		this.startWidth = width;
		this.startHeight = height;
		emuWindow = new EmuApplicationWindow();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void render() {

		if(!initWindowSize) {
			initWindowSize = true;
			ImGui.SetNextWindowSize(500, 400);
		}

		int mouseX = 0;
		int mouseY = 0;
		int windowWidth = 0;
		int windowHeight = 0;
		int windowX = 0;
		int windowY = 0;


		if(curFrameFocus)
			ImGui.PushStyleColor(ImGuiCol.Text, activeColor);
		ImGui.Begin(name);
		if(curFrameFocus)
			ImGui.PopStyleColor();
		boolean beginChild = ImGui.BeginChild(beginID, 0, -ImGui.GetFrameHeightWithSpacing(), false, ImGuiWindowFlags.NoMove);
		if(beginChild) {
			windowWidth = (int)ImGui.GetWindowContentRegionWidth();
			windowHeight = (int)ImGui.GetWindowHeight();

			ImVec2 winPos = ImGui.GetWindowPos();
			windowX = (int)winPos.x;
			windowY = (int)winPos.y;

			curFrameFocus = ImGui.IsWindowFocused();
			isWindowHovered = ImGui.IsWindowHovered(ImGuiHoveredFlags.AllowWhenBlockedByActiveItem);

			if(ImGui.InvisibleButton(btnId, windowWidth, windowHeight))
				curFrameFocus = true;

			emuWindow.begin(curFrameFocus, isWindowHovered, windowX, windowY, windowWidth, windowHeight);
			mouseX = Gdx.input.getX();
			mouseY = Gdx.input.getY();

			emuWindow.loop();

			emuWindow.end();

			ImGui.GetWindowDrawList().AddImage(emuWindow.getTextureID(), windowX, windowY, windowX +  windowWidth, windowY + windowHeight, emuWindow.u, emuWindow.v, emuWindow.u2, emuWindow.v2);
		}

		ImGui.EndChild();
		ImGui.Separator();
		ImGui.Text(widthLabel + windowWidth + heightLabel + windowHeight + mouseXLabel + mouseX + mouseYLabel + mouseY);
	}

	public void setApplicationListener(ApplicationListener applicationListener) {
		emuWindow.setApplicationListener(applicationListener);
	}

	public InputProcessor getInput() {
		return emuWindow.getInput();
	}

}
