package com.github.xpenatan.imgui.gdx.frame.viewport;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.backends.lwjgl3.ImGuiLWJGL3Impl;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;
import com.badlogic.gdx.graphics.Color;
import com.github.xpenatan.gdx.frame.viewport.EmuApplicationWindow;
import com.github.xpenatan.gdx.frame.viewport.EmuInput;
import com.github.xpenatan.gdx.frame.viewport.EmuWindow;
import com.github.xpenatan.imgui.ImGui;
import com.github.xpenatan.imgui.ImGuiViewport;
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

	private StringBuilder stringBuilder = new StringBuilder();

	private long curWindowHandle = 0;
	private InputMultiplexer curInputMultiplexer;

	private ImGuiLWJGL3Impl imp;

	public ImGuiGdxFrameWindow(ImGuiLWJGL3Impl imp, EmuWindow emuWindow, int width, int height, float x, float y) {
		this.imp = imp;
		this.startWidth = width;
		this.startHeight = height;
		this.startX = x;
		this.startY = y;
		this.emuWindow = emuWindow;
	}

	public void setName(String name) {
		this.name = name;
	}

	private void updateInput(long windowHandle) {
		EmuInput emuInput = emuWindow.getInput();
		if(curInputMultiplexer != null) {
			curInputMultiplexer.removeProcessor(emuInput);
			curInputMultiplexer = null;
		}

		Lwjgl3Window window = imp.findWindow(windowHandle);
		Input windowInput = imp.getWindowInput(window);

		if(windowInput != null) {
			InputProcessor inputProcessor = windowInput.getInputProcessor();
			if(inputProcessor instanceof InputMultiplexer) {
				curInputMultiplexer = (InputMultiplexer)inputProcessor;
				curInputMultiplexer.addProcessor(emuInput);
				curWindowHandle = windowHandle;
			}
		}
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

		ImGuiViewport viewport = ImGui.GetWindowViewport();
		updateInput(viewport.getPlatformHandle());

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

		stringBuilder.setLength(0);

		stringBuilder.append(widthLabel);
		stringBuilder.append(windowWidth);

		stringBuilder.append(heightLabel);
		stringBuilder.append(windowHeight);

		stringBuilder.append(mouseXLabel);
		stringBuilder.append(mouseX);

		stringBuilder.append(mouseYLabel);
		stringBuilder.append(mouseY);

		ImGui.Text(stringBuilder);
		ImGui.End();
	}

	public InputProcessor getInput() {
		return emuWindow.getInput();
	}

}
