package com.xpenatan.imgui;

import java.nio.ByteBuffer;

import com.badlogic.gdx.jnigen.JniGenSharedLibraryLoader;
import com.xpenatan.imgui.enums.ImGuiDir;
import com.xpenatan.imgui.enums.ImGuiInputTextFlags_;


public class ImGui {

	public static boolean enableLogging = true;
	private static boolean IMGUIINIT = false;
	public static String TAG = "ImGui";

	public static void init () {
		init(true);
	}

	public static void init (boolean logging) {
		if(ImGui.IMGUIINIT)
			return;
		new JniGenSharedLibraryLoader().load("gdx-imgui");
		ImGui.IMGUIINIT = true;
		ImGui.enableLogging = logging;

		ImGuiNative.CreateContext();
	}

	private static DrawData drawData = new DrawData(100000, 100000, 1000);

	private  ImGui() {
	}


	public static void Begin(String title) {
		ImGuiNative.Begin(title);
	}

	public static void End()  {
		ImGuiNative.End();
	}

	public static void ShowDemoWindow(boolean open)  {
		ImGuiNative.ShowDemoWindow(open);
	}

	public static void UpdateDisplayAndInputAndFrame(float deltaTime, float w, float h, float backBufferWidth, float backBufferHeight,
			int mouseX, int mouseY, boolean mouseDown0, boolean mouseDown1, boolean mouseDown2)  {
		ImGuiNative.UpdateDisplayAndInputAndFrame(deltaTime, w, h, backBufferWidth, backBufferHeight,
				mouseX, mouseY, mouseDown0, mouseDown1, mouseDown2, false, false, false);
	}

	public static void Text(String text) {
		ImGuiNative.Text(text);
	}

	public static void Render() {
		ImGuiNative.Render();
	}

	public static DrawData GetDrawData() {
		ByteBuffer cmdByteBuffer = drawData.cmdByteBuffer;
		ByteBuffer vByteBuffer = drawData.vByteBuffer;
		ByteBuffer iByteBuffer = drawData.iByteBuffer;
		vByteBuffer.position(0);
		iByteBuffer.position(0);
		cmdByteBuffer.position(0);
		ImGuiNative.GetDrawData(drawData, iByteBuffer, vByteBuffer, cmdByteBuffer);
		return drawData;
	}

	public static void SetNextWindowSize(int width, int height) {
		ImGuiNative.SetNextWindowSize(width, height);
	}

	public static void SetNextWindowPos(int x, int y) {
		ImGuiNative.SetNextWindowPos(x, y);
	}

	// Parameters stacks (current window)

	public static void PushItemWidth(float item_width) {
		ImGuiNative.PushItemWidth(item_width);
	}

	public static void PopItemWidth() {
		ImGuiNative.PopItemWidth();
	}

	public static void SetNextItemWidth(float item_width) {
		ImGuiNative.SetNextItemWidth(item_width);
	}

	public static float CalcItemWidth() {
		return ImGuiNative.CalcItemWidth();
	}

	public static void PushTextWrapPos() {
		ImGuiNative.PushTextWrapPos();
	}

	public static void PushTextWrapPos(float wrap_local_pos_x) {
		ImGuiNative.PushTextWrapPos(wrap_local_pos_x);
	}

	public static void PopTextWrapPos() {
		ImGuiNative.PopTextWrapPos();
	}

	public static void PushAllowKeyboardFocus(boolean allow_keyboard_focus) {
		ImGuiNative.PushAllowKeyboardFocus(allow_keyboard_focus);
	}

	public static void PushButtonRepeat() {
		ImGuiNative.PopAllowKeyboardFocus();
	}

	public static void PushButtonRepeat(boolean repeat) {
		ImGuiNative.PushButtonRepeat(repeat);
	}

	public static void PopButtonRepeat() {
		ImGuiNative.PopButtonRepeat();
	}

	// Cursor / Layout
	// - By "cursor" we mean the current output position.
	// - The typical widget behavior is to output themselves at the current cursor position, then move the cursor one line down.

	public static void Separator() {
		ImGuiNative.Separator();
	}

	public static void SameLine() {
		ImGuiNative.SameLine();
	}

	public static void SameLine(float offsetFromStartX, float spacing) {
		ImGuiNative.SameLine(offsetFromStartX, spacing);
	}

	public static void NewLine() {
		ImGuiNative.NewLine();
	}

	public static void Spacing() {
		ImGuiNative.Spacing();
	}

	public static void Dummy(float width, float height) {
		ImGuiNative.Dummy(width, height);
	}

	public static void Indent() {
		ImGuiNative.Indent();
	}

	public static void Indent(float indentW) {
		ImGuiNative.Indent(indentW);
	}

	public static void Unindent() {
		ImGuiNative.Unindent();
	}

	public static void Unindent(float indentW) {
		ImGuiNative.Unindent(indentW);
	}

	public static void BeginGroup() {
		ImGuiNative.BeginGroup();
	}

	public static void EndGroup() {
		ImGuiNative.EndGroup();
	}

	public static void GetCursorPos() {
		//TODO impl
	}

	public static float GetCursorPosX() {
		return ImGuiNative.GetCursorPosX();
	}

	public static float GetCursorPosY() {
		return ImGuiNative.GetCursorPosY();
	}

	public static void SetCursorPos(float x, float y) {
		ImGuiNative.SetCursorPos(x, y);
	}

	public static void SetCursorPosX(float x) {
		ImGuiNative.SetCursorPosX(x);
	}

	public static void SetCursorPosY(float y) {
		ImGuiNative.SetCursorPosY(y);
	}

	public static void GetCursorStartPos() {
		//TODO impl
	}

	public static void GetCursorScreenPos() {
		//TODO impl
	}

	public static void SetCursorScreenPos(float x, float y) {
		ImGuiNative.SetCursorScreenPos(x, y);
	}

	public static void AlignTextToFramePadding() {
		ImGuiNative.AlignTextToFramePadding();
	}

	public static float GetTextLineHeight() {
		return ImGuiNative.GetTextLineHeight();
	}

	public static float GetTextLineHeightWithSpacing() {
		return ImGuiNative.GetTextLineHeightWithSpacing();
	}

	public static float GetFrameHeight() {
		return ImGuiNative.GetFrameHeight();
	}

	public static float GetFraGetFrameHeightWithSpacingmeHeight() {
		return ImGuiNative.GetFrameHeightWithSpacing();
	}

	// Widgets: Main
	// - Most widgets return true when the value has been changed or when pressed/selected

	/**
	 * button
	 */
	public static boolean Button(String label) {
		return ImGuiNative.Button(label);
	}

	/**
	 * button
	 */
	public static boolean Button(String label, float width, float height) {
		return ImGuiNative.Button(label, width, height);
	}

	/**
	 * button with FramePadding=(0,0) to easily embed within text
	 */
	public static boolean SmallButton(String label) {
		return ImGuiNative.SmallButton(label);
	}

	/**
	 * button behavior without the visuals, frequently useful to build custom behaviors using the public api (along with IsItemActive, IsItemHovered, etc.)
	 */
	public static boolean InvisibleButton(String strId, float width, float height) {
		return ImGuiNative.InvisibleButton(strId, width, height);
	}

	/**
	 * square button with an arrow shape
	 */
	public static boolean ArrowButton(String strId, ImGuiDir dir) {
		return ImGuiNative.ArrowButton(strId, dir.toInt());
	}

	//TODO Image and ImageButton

	public static boolean Checkbox(String label, ImGuiBoolean value) {
		return ImGuiNative.Checkbox(label, value.data);
	}

	public static boolean CheckboxFlags(String label, ImGuiInputTextFlags_ flags, int flagsValue) {
		return ImGuiNative.CheckboxFlags(label, flags.data, flagsValue);
	}

	public static boolean RadioButton(String label, boolean active) {
		return ImGuiNative.RadioButton(label, active);
	}

	public static boolean RadioButton(String label, ImGuiInt value, int v_button) {
		return ImGuiNative.RadioButton(label, value.data, v_button);
	}

	public static void Bullet() {
		ImGuiNative.Bullet();
	}

}
