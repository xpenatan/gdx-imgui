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


	// Cursor / Layout
	// - By "cursor" we mean the current output position.
	// - The typical widget behavior is to output themselves at the current cursor position, then move the cursor one line down.

	public void separator() {
		ImGuiNative.separator();
	}

	public void sameLine() {
		ImGuiNative.sameLine();
	}

	public void sameLine(float offsetFromStartX, float spacing) {
		ImGuiNative.sameLine(offsetFromStartX, spacing);
	}

	public void newLine() {
		ImGuiNative.newLine();
	}

	public void spacing() {
		ImGuiNative.spacing();
	}

	public void dummy(float width, float height) {
		ImGuiNative.dummy(width, height);
	}

	public void indent() {
		ImGuiNative.indent();
	}

	public void indent(float indentW) {
		ImGuiNative.indent(indentW);
	}

	public void unindent() {
		ImGuiNative.unindent();
	}

	public void unindent(float indentW) {
		ImGuiNative.unindent(indentW);
	}

	public void beginGroup() {
		ImGuiNative.beginGroup();
	}

	public void endGroup() {
		ImGuiNative.endGroup();
	}

	public float getCursorPosX() {
		return ImGuiNative.getCursorPosX();
	}

	public float getCursorPosY() {
		return ImGuiNative.getCursorPosY();
	}

	// Widgets: Main
	// - Most widgets return true when the value has been changed or when pressed/selected

	/**
	 * button
	 */
	public boolean button(String label) {
		return ImGuiNative.button(label);
	}

	/**
	 * button
	 */
	public boolean button(String label, float width, float height) {
		return ImGuiNative.button(label, width, height);
	}

	/**
	 * button with FramePadding=(0,0) to easily embed within text
	 */
	public boolean smallButton(String label) {
		return ImGuiNative.smallButton(label);
	}

	/**
	 * button behavior without the visuals, frequently useful to build custom behaviors using the public api (along with IsItemActive, IsItemHovered, etc.)
	 */
	public boolean invisibleButton(String strId, float width, float height) {
		return ImGuiNative.invisibleButton(strId, width, height);
	}

	/**
	 * square button with an arrow shape
	 */
	public boolean arrowButton(String strId, ImGuiDir dir) {
		return ImGuiNative.arrowButton(strId, dir.toInt());
	}

	//TODO Image and ImageButton

	public boolean checkbox(String label, ImGuiBoolean value) {
		return ImGuiNative.checkbox(label, value.data);
	}

	public boolean checkboxFlags(String label, ImGuiInputTextFlags flags, int flagsValue) {
		return ImGuiNative.checkboxFlags(label, flags.data, flagsValue);
	}

	public boolean radioButton(String label, boolean active) {
		return ImGuiNative.radioButton(label, active);
	}

	public boolean radioButton(String label, ImGuiInt value, int v_button) {
		return ImGuiNative.radioButton(label, value.data, v_button);
	}

	public void bullet() {
		ImGuiNative.bullet();
	}

}
