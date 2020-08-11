package com.github.xpenatan.imgui.gdx.frame.viewport;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.github.xpenatan.gdx.frame.viewport.EmuApplicationWindow;
import com.github.xpenatan.gdx.frame.viewport.EmuInput;
import com.github.xpenatan.gdx.frame.viewport.EmuWindow;
import com.github.xpenatan.imgui.ImGui;
import com.github.xpenatan.imgui.ImVec2;
import com.github.xpenatan.imgui.enums.ImGuiCol;
import com.github.xpenatan.imgui.enums.ImGuiCond;
import com.github.xpenatan.imgui.enums.ImGuiHoveredFlags;
import com.github.xpenatan.imgui.enums.ImGuiWindowFlags;

/**
 *
 *	Emulate gdx application inside a ImGui window
 *
 * @author xpenatan
 */
public class ImGuiGdxFrameWindow {

	private EmuWindow emuWindow;

	int startWidth;
	int startHeight;

	float startX;
	float startY;

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

	public ImGuiGdxFrameWindow(int width, int height, float x, float y) {
		this(new EmuApplicationWindow(), width, height, x, y);
		this.startWidth = width;
		this.startHeight = height;
	}

	public ImGuiGdxFrameWindow(EmuWindow emuWindow, int width, int height, float x, float y) {
		this.startWidth = width;
		this.startHeight = height;
		this.startX = x;
		this.startY = y;
		this.emuWindow = emuWindow;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void render() {
		if(name == null)
			name = "";
		ImGui.SetNextWindowSize(startWidth, startHeight, ImGuiCond.FirstUseEver);
		ImGui.SetNextWindowPos(startX, startY, ImGuiCond.FirstUseEver);

		int mouseX = 0;
		int mouseY = 0;
		int windowWidth = 0;
		int windowHeight = 0;
		int windowX = 0;
		int windowY = 0;

		if(curFrameFocus)
			ImGui.PushStyleColor(ImGuiCol.Text, activeColor);

		EmuInput input = emuWindow.getInput();

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

			if(input.needsFocus())
				ImGui.SetWindowFocus();

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
		ImGui.End();
	}

	public InputProcessor getInput() {
		return emuWindow.getInput();
	}

}
