package com.xpenatan.imgui;

import java.nio.ByteBuffer;

public class ImGui<T extends DrawData> {

	public static boolean enableLogging = true;
	private static boolean IMGUIINIT = false;
	public static String TAG = "ImGui";

	public static void init () {
		init(true);
	}

	public static void init (boolean logging) {
		if(ImGui.IMGUIINIT)
			return;
		ImGui.IMGUIINIT = true;
		ImGui.enableLogging = logging;
	}

	protected T drawData;

	public ImGui() {
		this((T) new DrawData(10000,10000,10000));
	}

	public ImGui(T drawData) {
		this.drawData = drawData;
		ImGuiNative.createContext();
		drawData.prepareFont();
	}

	public void begin(String title) {
		ImGuiNative.begin(title);
	}

	public void end()  {
		ImGuiNative.end();
	}

	public void showDemoWindow(boolean open)  {
		ImGuiNative.showDemoWindow(open);
	}

	public void updateDisplayAndInputAndFrame(float deltaTime, float w, float h, float backBufferWidth, float backBufferHeight,
			int mouseX, int mouseY, boolean mouseDown0, boolean mouseDown1, boolean mouseDown2)  {
		ImGuiNative.updateDisplayAndInputAndFrame(deltaTime, w, h, backBufferWidth, backBufferHeight,
				mouseX, mouseY, mouseDown0, mouseDown1, mouseDown2, false, false, false);
	}

	public void text(String text) {
		ImGuiNative.text(text);
	}

	public void render() {
		ImGuiNative.render();
	}

	public T getDrawData() {
		ByteBuffer cmdByteBuffer = drawData.cmdByteBuffer;
		ByteBuffer vByteBuffer = drawData.vByteBuffer;
		ByteBuffer iByteBuffer = drawData.iByteBuffer;
		vByteBuffer.position(0);
		iByteBuffer.position(0);
		cmdByteBuffer.position(0);
		ImGuiNative.getDrawData(drawData, iByteBuffer, vByteBuffer, cmdByteBuffer);
		return drawData;
	}

	public void setNextWindowSize(int width, int height) {
		ImGuiNative.setNextWindowSize(width, height);
	}

	public void setNextWindowPos(int x, int y) {
		ImGuiNative.setNextWindowPos(x, y);
	}

}
