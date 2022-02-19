package com.github.xpenatan.imgui;

import java.lang.ref.WeakReference;
import java.nio.Buffer;
import com.badlogic.gdx.utils.SharedLibraryLoader;
import com.github.xpenatan.imgui.enums.*;
import com.github.xpenatan.imgui.jnicode.ImGuiInternalNative;
import com.github.xpenatan.imgui.jnicode.ImGuiNative;
import com.github.xpenatan.imgui.util.CharSequenceHelper;

public class ImGui {

	public static boolean enableLogging = true;
	private static boolean IMGUIINIT = false;
	public static String TAG = "ImGui";

	public static final int VERSION_CODE = 39;

	public static void init () {
		init(true, true);
	}

	public static void init (boolean saveIni, boolean logging) {
		if(ImGui.IMGUIINIT)
			return;
		SharedLibraryLoader loader = new SharedLibraryLoader();
		loader.load("imgui-cpp");
		loader.load("imgui");
		ImGui.IMGUIINIT = true;
		ImGui.enableLogging = logging;

		ImGuiNative.init();
		ImGuiNative.CreateContext(saveIni);
	}

	public static void dispose() {
		ImGuiNative.DestroyContext();
	}

	private static ImDrawData drawData = new ImDrawData();
	private static ImGuiIO imguiIO = new ImGuiIO();
	private static ImGuiStyle imguiStyle = new ImGuiStyle();
	private static ImVec2 imVec2 = new ImVec2();
	private static ImVec4 imVec4 = new ImVec4();
	private static ImDrawList imDrawList = new ImDrawList(ImDrawList.TYPE_DEFAULT);
	private static ImDrawList imDrawListBackground = new ImDrawList(ImDrawList.TYPE_BACKGROUND);
	private static ImDrawList imDrawListForeground = new ImDrawList(ImDrawList.TYPE_FOREGROUND);

	protected ImGui() {
	}

	public static ImGuiIO GetIO() {
		return imguiIO;
	}

	public static ImGuiStyle GetStyle() {
		return imguiStyle;
	}

	public static void ShowStyleEditor()  {
		ImGuiNative.ShowStyleEditor();
	}

	public static void ShowDemoWindow()  {
		ImGuiNative.ShowDemoWindow();
	}

	public static void ShowDemoWindow(boolean open)  {
		ImGuiNative.ShowDemoWindow(open);
	}

	public static void ShowMetricsWindow()  {
		ImGuiNative.ShowMetricsWindow();
	}

	public static void ShowMetricsWindow(boolean open)  {
		ImGuiNative.ShowMetricsWindow(open);
	}

	public static void UpdateDisplayAndInputAndFrame(float deltaTime, int width, int height, int backBufferWidth, int backBufferHeight)  {
		ImGuiNative.UpdateDisplayAndInputAndFrame(imguiIO, imguiStyle, deltaTime, width, height, backBufferWidth, backBufferHeight);
	}

	public static void AddKeyEvent(int imGuiKey, boolean down) {
		ImGuiNative.AddKeyEvent(imGuiKey, down);
	}

	public static void AddMousePosEvent(float x, float y) {
		ImGuiNative.AddMousePosEvent(x, y);
	}

	public static void AddMouseButtonEvent(int button, boolean down) {
		ImGuiNative.AddMouseButtonEvent(button, down);
	}

	public static void AddMouseWheelEvent(float xOffset, float yOffset) {
		ImGuiNative.AddMouseWheelEvent(xOffset, yOffset);
	}

	public static void UpdateKeyTyped(int c)  {
		ImGuiNative.updateKeyTyped(c);
	}

	public static void Render() {
		ImGuiNative.Render();
	}

	public static ImDrawData GetDrawData() {
		ImGuiNative.GetDrawData(drawData);
		return drawData;
	}

	public static void GetTexDataAsRGBA32(TexDataRGBA32 jTexData, Buffer pixelBuffer) {
		ImGuiNative.GetTexDataAsRGBA32(jTexData, pixelBuffer);
	}

	public static void SetFontTexID(int id) {
		ImGuiNative.SetFontTexID(id);
	}

	public static void StyleColorsDark() {
		ImGuiNative.StyleColorsDark();
	}

	public static void StyleColorsClassic() {
		ImGuiNative.StyleColorsClassic();
	}

	public static void StyleColorsLight() {
		ImGuiNative.StyleColorsLight();
	}

	public static boolean Begin(String title) {
		return ImGuiNative.Begin(title);
	}

	public static boolean Begin(String title, ImGuiWindowFlags flags) {
		return ImGuiNative.Begin(title, flags.getValue());
	}

	public static boolean Begin(String title, ImGuiBoolean p_open, ImGuiWindowFlags flags) {
		return ImGuiNative.Begin(title, p_open.data, flags.getValue());
	}

	public static void End()  {
		ImGuiNative.End();
	}

	// Child Windows
	// - Use child windows to begin into a self-contained independent scrolling/clipping regions within a host window. Child windows can embed their own child.
	// - For each independent axis of 'size': ==0.0f: use remaining host window size / >0.0f: fixed size / <0.0f: use remaining window size minus abs(size) / Each axis can use a different mode, e.g. ImVec2(0,400).
	// - BeginChild() returns false to indicate the window is collapsed or fully clipped, so you may early out and omit submitting anything to the window.
	//   Always call a matching EndChild() for each BeginChild() call, regardless of its return value [this is due to legacy reason and is inconsistent with most other functions such as BeginMenu/EndMenu, BeginPopup/EndPopup, etc. where the EndXXX call should only be called if the corresponding BeginXXX function returned true.]


	public static boolean BeginChild(String str_id) {
		return ImGuiNative.BeginChild(str_id);
	}

	public static boolean BeginChild(String str_id, float width, float height) {
		return ImGuiNative.BeginChild(str_id, width, height);
	}

	public static boolean BeginChild(String str_id, float width, float height, boolean border) {
		return ImGuiNative.BeginChild(str_id, width, height, border);
	}

	public static boolean BeginChild(String str_id, float width, float height, boolean border, ImGuiWindowFlags flags) {
		return ImGuiNative.BeginChild(str_id, width, height, border, flags.getValue());
	}

	public static boolean BeginChild(int imGuiID) {
		return ImGuiNative.BeginChild(imGuiID);
	}

	public static boolean BeginChild(int imGuiID, float width, float height, boolean border) {
		return ImGuiNative.BeginChild(imGuiID, width, height, border);
	}

	public static boolean BeginChild(int imGuiID, float width, float height, boolean border, ImGuiWindowFlags flags) {
		return ImGuiNative.BeginChild(imGuiID, width, height, border, flags.getValue());
	}

	public static void EndChild() {
		ImGuiNative.EndChild();
	}

	// Windows Utilities
	// - "current window" = the window we are appending into while inside a Begin()/End() block. "next window" = next window we will Begin() into.

	public static boolean IsWindowAppearing() {
		return ImGuiNative.IsWindowAppearing();
	}

	public static boolean IsWindowCollapsed() {
		return ImGuiNative.IsWindowCollapsed();
	}

	public static boolean IsWindowFocused() {
		return ImGuiNative.IsWindowFocused();
	}

	public static boolean IsWindowFocused(ImGuiFocusedFlags flags) {
		return ImGuiNative.IsWindowFocused(flags.getValue());
	}

	public static boolean IsWindowHovered() {
		return ImGuiNative.IsWindowHovered();
	}

	public static boolean IsWindowHovered(ImGuiHoveredFlags flags) {
		return ImGuiNative.IsWindowHovered(flags.getValue());
	}

	public static ImDrawList GetWindowDrawList() {
		return imDrawList;
	}

	public static ImDrawList GetBackgroundDrawList() {
		return imDrawListBackground;
	}

	public static ImDrawList GetForegroundDrawList() {
		return imDrawListForeground;
	}

	public static ImVec2 GetWindowPos() {
		ImGuiNative.GetWindowPos(imVec2);
		return imVec2;
	}

	public static float GetWindowPosX() {
		return ImGuiNative.GetWindowPosX();
	}

	public static float GetWindowPosY() {
		return ImGuiNative.GetWindowPosY();
	}

	public static ImVec2 GetWindowSize() {
		ImGuiNative.GetWindowSize(imVec2);
		return imVec2;
	}

	public static float GetWindowWidth() {
		return ImGuiNative.GetWindowWidth();
	}

	public static float GetWindowHeight() {
		return ImGuiNative.GetWindowHeight();
	}

	public static ImGuiViewport GetWindowViewport() {
		return ImGuiNative.GetWindowViewport();
	}

	// Window manipulation

	public static void SetNextWindowPos(float x, float y) {
		ImGuiNative.SetNextWindowPos(x, y);
	}

	public static void SetNextWindowPos(float x, float y, ImGuiCond cond) {
		ImGuiNative.SetNextWindowPos(x, y, cond.getValue());
	}

	public static void SetNextWindowPos(float x, float y, ImGuiCond cond, float pivotX, float pivotY) {
		ImGuiNative.SetNextWindowPos(x, y, cond.getValue(), pivotX, pivotY);
	}

	public static void SetNextWindowSize(int width, int height) {
		ImGuiNative.SetNextWindowSize(width, height);
	}

	public static void SetNextWindowSize(int width, int height, ImGuiCond cond) {
		ImGuiNative.SetNextWindowSize(width, height, cond.getValue());
	}

	public static void SetNextWindowSizeConstraints(float minWidth, float minHeight, float maxWidth, float maxHeight) {
		ImGuiNative.SetNextWindowSizeConstraints(minWidth, minHeight, maxWidth, maxHeight);
	}

	public static void SetNextWindowContentSize(float sizeX, float sizeY) {
		ImGuiNative.SetNextWindowContentSize(sizeX, sizeY);
	}

	public static void SetNextWindowCollapsed(boolean flag) {
		ImGuiNative.SetNextWindowCollapsed(flag);
	}

	public static void SetNextWindowFocus() {
		ImGuiNative.SetNextWindowFocus();
	}

	public static void SetNextWindowBgAlpha(float alpha) {
		ImGuiNative.SetNextWindowBgAlpha(alpha);
	}

	//TODO add more methods

	public static void SetWindowFocus() {
		ImGuiNative.SetWindowFocus();
	}

	public static void SetWindowFocus(String name) {
		if(name == null)
			ImGuiNative.RemoveWindowFocus();
		else
			ImGuiNative.SetWindowFocus(name);
	}

	// Content region
	// - Those functions are bound to be redesigned soon (they are confusing, incomplete and return values in local window coordinates which increases confusion)

	public static ImVec2 GetContentRegionMax() {
		ImGuiNative.GetContentRegionMax(imVec2);
		return imVec2;
	}

	public static ImVec2 GetContentRegionAvail() {
		ImGuiNative.GetContentRegionAvail(imVec2);
		return imVec2;
	}

	public static ImVec2 GetWindowContentRegionMin() {
		ImGuiNative.GetWindowContentRegionMin(imVec2);
		return imVec2;
	}

	public static ImVec2 GetWindowContentRegionMax() {
		ImGuiNative.GetWindowContentRegionMax(imVec2);
		return imVec2;
	}

	public static float GetWindowContentRegionWidth() {
		return ImGuiNative.GetWindowContentRegionWidth();
	}

	// Windows Scrolling

	public static float GetScrollX() {
		return ImGuiNative.GetScrollX();
	}

	public static float GetScrollY() {
		return ImGuiNative.GetScrollY();
	}

	public static float GetScrollMaxX() {
		return ImGuiNative.GetScrollMaxX();
	}

	public static float GetScrollMaxY() {
		return ImGuiNative.GetScrollMaxY();
	}

	public static void SetScrollX(float scroll_x) {
		ImGuiNative.SetScrollX(scroll_x);
	}

	public static void SetScrollY(float scroll_y) {
		ImGuiNative.SetScrollY(scroll_y);
	}

	public static void SetScrollFromPosY(float local_y) {
		ImGuiNative.SetScrollFromPosY(local_y);
	}

	public static void SetScrollFromPosY(float local_y, float center_y_ratio) {
		ImGuiNative.SetScrollFromPosY(local_y, center_y_ratio);
	}

	// Parameters stacks (shared)

	public static void PushStyleColor(ImGuiCol idx, int col) {
		ImGuiNative.PushStyleColor(idx.getValue(), col);
	}

	public static void PushStyleColor(ImGuiCol idx, float r, float g, float b, float a) {
		ImGuiNative.PushStyleColor(idx.getValue(), r, g, b, a);
	}

	public static void PopStyleColor() {
		ImGuiNative.PopStyleColor();
	}

	public static void PopStyleColor(int count) {
		ImGuiNative.PopStyleColor(count);
	}

	public static void PushStyleVar(ImGuiStyleVar idx, float val) {
		ImGuiNative.PushStyleVar(idx.	getValue(), val);
	}

	public static void PushStyleVar(ImGuiStyleVar idx, float valX, float valY) {
		ImGuiNative.PushStyleVar(idx.getValue(), valX, valY);
	}

	public static void PopStyleVar() {
		ImGuiNative.PopStyleVar();
	}

	public static void PopStyleVar(int count) {
		ImGuiNative.PopStyleVar(count);
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

	public static void SameLine(float offsetFromStartX) {
		ImGuiNative.SameLine(offsetFromStartX);
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

	public static ImVec2 GetCursorStartPos() {
		ImGuiNative.GetCursorStartPos(imVec2);
		return imVec2;
	}

	public static ImVec2 GetCursorScreenPos() {
		ImGuiNative.GetCursorScreenPos(imVec2);
		return imVec2;
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

	public static float GetFrameHeightWithSpacing() {
		return ImGuiNative.GetFrameHeightWithSpacing();
	}

	// ID stack/scopes
	// - Read the FAQ for more details about how ID are handled in dear imgui. If you are creating widgets in a loop you most
	//   likely want to push a unique identifier (e.g. object pointer, loop index) to uniquely differentiate them.
	// - The resulting ID are hashes of the entire stack.
	// - You can also use the "Label##foobar" syntax within widget label to distinguish them from each others.
	// - In this header file we use the "label"/"name" terminology to denote a string that will be displayed and used as an ID,
	//   whereas "str_id" denote a string that is only used as an ID and not normally displayed.

	public static void PushID(String str_id) {
		ImGuiNative.PushID(str_id);
	}

	public static void PushID(String str_id_begin, String str_id_end) {
		ImGuiNative.PushID(str_id_begin, str_id_end);
	}

	public static void PushID(int int_id) {
		ImGuiNative.PushID(int_id);
	}

	public static void PopID() {
		ImGuiNative.PopID();
	}

	public static int GetID(String str_id) {
		return ImGuiNative.GetID(str_id);
	}

	public static int GetID(String str_id_begin, String str_id_end) {
		return ImGuiNative.GetID(str_id_begin, str_id_end);
	}

	// TODO GetID ptr_id

	// Widgets: Text

	public static void TextUnformatted(String text) {
		ImGuiNative.TextUnformatted(text);
	}

	public static void TextUnformatted(String text, String text_end) {
		ImGuiNative.TextUnformatted(text, text_end);
	}

	public static void Text(String text) {
		ImGuiNative.Text(text);
	}

	public static void Text(CharSequence text) {
		byte[] tempChar = CharSequenceHelper.getTempChar(text, 0);
		ImGuiNative.Text(tempChar);
	}

	public static void TextColored(float r, float g, float b, float a, String text) {
		ImGuiNative.TextColored(r, g, b, a, text);
	}

	public static void TextDisabled(String text) {
		ImGuiNative.TextDisabled(text);
	}

	public static void TextWrapped(String text) {
		ImGuiNative.TextWrapped(text);
	}

	public static void LabelText(String label, String text) {
		ImGuiNative.LabelText(label, text);
	}

	public static void BulletText(String text) {
		ImGuiNative.BulletText(text);
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

	public static void Image(int textureID, float sizeX, float sizeY) {
		ImGuiNative.Image(textureID, sizeX, sizeY);
	}

	public static void Image(int textureID, float sizeX, float sizeY, float uv0_x, float uv0_y, float uv1_x, float uv1_y) {
		ImGuiNative.Image(textureID, sizeX, sizeY, uv0_x, uv0_y, uv1_x, uv1_y);
	}

	public static boolean ImageButton(int textureID, float sizeX, float sizeY) {
		return ImGuiNative.ImageButton(textureID, sizeX, sizeY);
	}

	public static boolean ImageButton(int textureID, float sizeX, float sizeY, float uv0_x, float uv0_y, float uv1_x, float uv1_y, int frame_padding) {
		return ImGuiNative.ImageButton(textureID, sizeX, sizeY, uv0_x, uv0_y, uv1_x, uv1_y, frame_padding);
	}

	public static boolean ImageButton(int textureID, float sizeX, float sizeY, float uv0_x, float uv0_y, float uv1_x, float uv1_y, int frame_padding, ImColor bg_col) {
		return ImGuiNative.ImageButton(textureID, sizeX, sizeY, uv0_x, uv0_y, uv1_x, uv1_y, frame_padding, bg_col.getR(), bg_col.getG(), bg_col.getB(), bg_col.getA(), 1f, 1f, 1f, 1f);
	}

	public static boolean ImageButton(int textureID, float sizeX, float sizeY, float uv0_x, float uv0_y, float uv1_x, float uv1_y, int frame_padding, ImColor bg_col, ImColor tint_col) {
		return ImGuiNative.ImageButton(textureID, sizeX, sizeY, uv0_x, uv0_y, uv1_x, uv1_y, frame_padding, bg_col.getR(), bg_col.getG(), bg_col.getB(), bg_col.getA(), tint_col.getR(), tint_col.getG(), tint_col.getB(), tint_col.getA());
	}

	public static boolean Checkbox(String label, ImGuiBoolean value) {
		return ImGuiNative.Checkbox(label, value.data);
	}

	public static boolean CheckboxFlags(String label, ImGuiInt flags, ImGuiTabBarFlags flagsValues) {
		return ImGuiNative.CheckboxFlags(label, flags.data, flagsValues.getValue());
	}

	public static boolean RadioButton(String label, boolean active) {
		return ImGuiNative.RadioButton(label, active);
	}

	public static boolean RadioButton(String label, ImGuiInt value, int v_button) {
		return ImGuiNative.RadioButton(label, value.data, v_button);
	}

	public static void ProgressBar(float fraction) {
		ImGuiNative.ProgressBar(fraction);
	}

	public static void ProgressBar(float fraction, float size_arg_x, float size_arg_y) {
		ImGuiNative.ProgressBar(fraction, size_arg_x, size_arg_y);
	}

	public static void Bullet() {
		ImGuiNative.Bullet();
	}

	// Widgets: Combo Box
	// - The new BeginCombo()/EndCombo() api allows you to manage your contents and selection state however you want it, by creating e.g. Selectable() items.
	// - The old Combo() api are helpers over BeginCombo()/EndCombo() which are kept available for convenience purpose.

	public static boolean BeginCombo(String label, String preview_value) {
		return ImGuiNative.BeginCombo(label, preview_value);
	}

	public static boolean BeginCombo(String label, String preview_value, ImGuiComboFlags flags) {
		return ImGuiNative.BeginCombo(label, preview_value, flags.getValue());
	}

	public static void EndCombo() {
		ImGuiNative.EndCombo();
	}

	public static boolean Combo(String label, ImGuiInt current_item, String [] items, int items_count) {
		return ImGuiNative.Combo(label, current_item.data, items, items_count);
	}

	public static boolean Combo(String label, ImGuiInt current_item, String [] items, int items_count, int popup_max_height_in_items) {
		return ImGuiNative.Combo(label, current_item.data, items, items_count, popup_max_height_in_items);
	}

	public static boolean Combo(String label, ImGuiInt current_item, String items_separated_by_zeros) {
		return ImGuiNative.Combo(label, current_item.data, items_separated_by_zeros);
	}

	public static boolean Combo(String label, ImGuiInt current_item, String items_separated_by_zeros, int popup_max_height_in_items) {
		return ImGuiNative.Combo(label, current_item.data, items_separated_by_zeros, popup_max_height_in_items);
	}

	// Widgets: Drags
	// - CTRL+Click on any drag box to turn them into an input box. Manually input values aren't clamped and can go off-bounds.
	// - For all the Float2/Float3/Float4/Int2/Int3/Int4 versions of every functions, note that a 'float v[X]' function argument is the same as 'float* v', the array syntax is just a way to document the number of elements that are expected to be accessible. You can pass address of your first element out of a contiguous set, e.g. &myvector.x
	// - Adjust format string to decorate the value with a prefix, a suffix, or adapt the editing and display precision e.g. "%.3f" -> 1.234; "%5.2f secs" -> 01.23 secs; "Biscuit: %.0f" -> Biscuit: 1; etc.
	// - Speed are per-pixel of mouse movement (v_speed=0.2f: mouse needs to move by 5 pixels to increase value by 1). For gamepad/keyboard navigation, minimum speed is Max(v_speed, minimum_step_at_given_precision).

	public static boolean DragFloat(String label, ImGuiFloat v) {
		return ImGuiNative.DragFloat(label, v.data);
	}

	public static boolean DragFloat(String label, ImGuiFloat v, float v_speed) {
		return ImGuiNative.DragFloat(label, v.data, v_speed);
	}

	public static boolean DragFloat(String label, ImGuiFloat v, float v_speed, float v_min, float v_max, String format) {
		return ImGuiNative.DragFloat(label, v.data, v_speed, v_min, v_max, format);
	}

	public static boolean DragFloat(String label, ImGuiFloat v, float v_speed, float v_min, float v_max, String format, float power) {
		return ImGuiNative.DragFloat(label, v.data, v_speed, v_min, v_max, format, power);
	}

	public static boolean DragFloat2(String label, float [] v) {
		return ImGuiNative.DragFloat2(label, v);
	}

	public static boolean DragFloat2(String label, float [] v, float v_speed, float v_min, float v_max, String format, float power) {
		return ImGuiNative.DragFloat2(label, v, v_speed, v_min, v_max, format, power);
	}

	public static boolean DragFloat3(String label, float [] v) {
		return ImGuiNative.DragFloat3(label, v);
	}

	public static boolean DragFloat3(String label, float [] v, float v_speed, float v_min, float v_max, String format, float power) {
		return ImGuiNative.DragFloat3(label, v, v_speed, v_min, v_max, format, power);
	}

	public static boolean DragFloat4(String label, float [] v) {
		return ImGuiNative.DragFloat4(label, v);
	}

	public static boolean DragFloat4(String label, float [] v, float v_speed, float v_min, float v_max, String format, float power) {
		return ImGuiNative.DragFloat4(label, v, v_speed, v_min, v_max, format, power);
	}

	public static boolean DragFloatRange2(String label, ImGuiFloat v_current_min, ImGuiFloat v_current_max) {
		return ImGuiNative.DragFloatRange2(label, v_current_min.data, v_current_max.data);
	}

	public static boolean DragFloatRange2(String label, ImGuiFloat v_current_min, ImGuiFloat v_current_max, float v_speed, float v_min, float v_max, String format, String format_max, float power) {
		return ImGuiNative.DragFloatRange2(label, v_current_min.data, v_current_max.data, v_speed, v_min, v_max, format, format_max, power);
	}

	public static boolean DragInt(String label, ImGuiInt v) {
		return ImGuiNative.DragInt(label, v.data);
	}

	public static boolean DragInt(String label, ImGuiInt v, float v_speed) {
		return ImGuiNative.DragInt(label, v.data, v_speed);
	}

	public static boolean DragInt(String label, ImGuiInt v, float v_speed, float v_min, float v_max, String format) {
		return ImGuiNative.DragInt(label, v.data, v_speed, v_min, v_max, format);
	}

	public static boolean DragInt2(String label, int [] v) {
		return ImGuiNative.DragInt2(label, v);
	}

	public static boolean DragInt2(String label, int [] v, float v_speed, float v_min, float v_max, String format) {
		return ImGuiNative.DragInt2(label, v, v_speed, v_min, v_max, format);
	}

	public static boolean DragInt3(String label, int [] v) {
		return ImGuiNative.DragInt3(label, v);
	}

	public static boolean DragInt3(String label, int [] v, float v_speed, float v_min, float v_max, String format) {
		return ImGuiNative.DragInt3(label, v, v_speed, v_min, v_max, format);
	}

	public static boolean DragInt4(String label, int [] v) {
		return ImGuiNative.DragInt4(label, v);
	}

	public static boolean DragInt4(String label, int [] v, float v_speed, float v_min, float v_max, String format) {
		return ImGuiNative.DragInt4(label, v, v_speed, v_min, v_max, format);
	}

	public static boolean DragIntRange2(String label, ImGuiInt v_current_min, ImGuiInt v_current_max) {
		return ImGuiNative.DragIntRange2(label, v_current_min.data, v_current_max.data);
	}

	public static boolean DragIntRange2(String label, ImGuiInt v_current_min, ImGuiInt v_current_max, float v_speed, float v_min, float v_max, String format, String format_max) {
		return ImGuiNative.DragIntRange2(label, v_current_min.data, v_current_max.data, v_speed, v_min, v_max, format, format_max);
	}

	//TODO impl
//	public static boolean DragScalar(String label, ImGuiDataType_ data_type, ImGuiInt v, ImGuiInt v_current_max, float v_speed, float v_min, float v_max, String format, String format_max) {
//		return ImGuiNative.DragScalar(label, data_type.getValue(), v.data, v_current_max.data, v_speed, v_min, v_max, format, format_max);
//	}


	// Widgets: Sliders
	// - CTRL+Click on any slider to turn them into an input box. Manually input values aren't clamped and can go off-bounds.
	// - Adjust format string to decorate the value with a prefix, a suffix, or adapt the editing and display precision e.g. "%.3f" -> 1.234; "%5.2f secs" -> 01.23 secs; "Biscuit: %.0f" -> Biscuit: 1; etc.

	public static boolean SliderFloat(String label, ImGuiFloat v, float v_min, float v_max) {
		return ImGuiNative.SliderFloat(label, v.data, v_min, v_max);
	}

	public static boolean SliderFloat(String label, ImGuiFloat v, float v_min, float v_max, String format) {
		return ImGuiNative.SliderFloat(label, v.data, v_min, v_max, format);
	}

	public static boolean SliderFloat(String label, ImGuiFloat v, float v_min, float v_max, String format, float power) {
		return ImGuiNative.SliderFloat(label, v.data, v_min, v_max, format, power);
	}

	public static boolean SliderFloat2(String label, float [] v, float v_min, float v_max) {
		return ImGuiNative.SliderFloat2(label, v, v_min, v_max);
	}

	public static boolean SliderFloat2(String label, float [] v, float v_min, float v_max, String format, float power) {
		return ImGuiNative.SliderFloat2(label, v, v_min, v_max, format, power);
	}

	public static boolean SliderFloat3(String label, float [] v, float v_min, float v_max) {
		return ImGuiNative.SliderFloat3(label, v, v_min, v_max);
	}

	public static boolean SliderFloat3(String label, float [] v, float v_min, float v_max, String format, float power) {
		return ImGuiNative.SliderFloat3(label, v, v_min, v_max, format, power);
	}

	public static boolean SliderFloat4(String label, float [] v, float v_min, float v_max) {
		return ImGuiNative.SliderFloat4(label, v, v_min, v_max);
	}

	public static boolean SliderFloat4(String label, float [] v, float v_min, float v_max, String format, float power) {
		return ImGuiNative.SliderFloat4(label, v, v_min, v_max, format, power);
	}

	public static boolean SliderAngle(String label, ImGuiFloat v) {
		return ImGuiNative.SliderAngle(label, v.data);
	}

	public static boolean SliderAngle(String label, ImGuiFloat v, float v_degrees_min, float v_degrees_max, String format) {
		return ImGuiNative.SliderAngle(label, v.data, v_degrees_min, v_degrees_max, format);
	}

	public static boolean SliderInt(String label, ImGuiInt v, int v_min, int v_max) {
		return ImGuiNative.SliderInt(label, v.data, v_min, v_max);
	}

	public static boolean SliderInt(String label, ImGuiInt v, int v_min, int v_max, String format) {
		return ImGuiNative.SliderInt(label, v.data, v_min, v_max, format);
	}

	public static boolean SliderInt2(String label, int [] v, int v_min, int v_max) {
		return ImGuiNative.SliderInt2(label, v, v_min, v_max);
	}

	public static boolean SliderInt2(String label, int [] v, int v_min, int v_max, String format) {
		return ImGuiNative.SliderInt2(label, v, v_min, v_max, format);
	}

	public static boolean SliderInt3(String label, int [] v, int v_min, int v_max) {
		return ImGuiNative.SliderInt3(label, v, v_min, v_max);
	}

	public static boolean SliderInt3(String label, int [] v, int v_min, int v_max, String format) {
		return ImGuiNative.SliderInt3(label, v, v_min, v_max, format);
	}

	public static boolean SliderInt4(String label, int [] v, int v_min, int v_max) {
		return ImGuiNative.SliderInt4(label, v, v_min, v_max);
	}

	public static boolean SliderInt4(String label, int [] v, int v_min, int v_max, String format) {
		return ImGuiNative.SliderInt4(label, v, v_min, v_max, format);
	}

	public static boolean SliderScalar(String label, ImGuiDataType data_type, ImGuiInt v, int v_min, int v_max) {
		return ImGuiNative.SliderScalar(label, data_type.getValue(), v.data, v_min, v_max);
	}

	public static boolean SliderScalar(String label, ImGuiDataType data_type, ImGuiInt v, int v_min, int v_max, String format, float power) {
		return ImGuiNative.SliderScalar(label, data_type.getValue(), v.data, v_min, v_max, format, power);
	}

	public static boolean SliderScalar(String label, ImGuiDataType data_type, ImGuiFloat v, float v_min, float v_max) {
		return ImGuiNative.SliderScalar(label, data_type.getValue(), v.data, v_min, v_max);
	}

	public static boolean SliderScalar(String label, ImGuiDataType data_type, ImGuiFloat v, float v_min, float v_max, String format, float power) {
		return ImGuiNative.SliderScalar(label, data_type.getValue(), v.data, v_min, v_max, format, power);
	}

	public static boolean VSliderFloat(String label, float sizeX, float sizeY, ImGuiFloat v, float v_min, float v_max) {
		return ImGuiNative.VSliderFloat(label, sizeX, sizeY, v.data, v_min, v_max);
	}

	public static boolean VSliderFloat(String label, float sizeX, float sizeY, ImGuiFloat v, float v_min, float v_max, String format, float power) {
		return ImGuiNative.VSliderFloat(label, sizeX, sizeY, v.data, v_min, v_max, format, power);
	}

	public static boolean VSliderInt(String label, float sizeX, float sizeY, ImGuiInt v, int v_min, int v_max) {
		return ImGuiNative.VSliderInt(label, sizeX, sizeY, v.data, v_min, v_max);
	}

	public static boolean VSliderInt(String label, float sizeX, float sizeY, ImGuiInt v, int v_min, int v_max, String format) {
		return ImGuiNative.VSliderInt(label, sizeX, sizeY, v.data, v_min, v_max, format);
	}

	public static boolean VSliderScalar(String label, float sizeX, float sizeY, ImGuiDataType data_type, ImGuiFloat v, float v_min, float v_max) {
		return ImGuiNative.VSliderScalar(label, sizeX, sizeY, data_type.getValue(), v.data, v_min, v_max);
	}

	public static boolean VSliderScalar(String label, float sizeX, float sizeY, ImGuiDataType data_type, ImGuiFloat v, float v_min, float v_max, String format, float power) {
		return ImGuiNative.VSliderScalar(label, sizeX, sizeY, data_type.getValue(), v.data, v_min, v_max, format, power);
	}

	public static boolean VSliderScalar(String label, float sizeX, float sizeY, ImGuiDataType data_type, ImGuiInt v, int v_min, int v_max) {
		return ImGuiNative.VSliderScalar(label, sizeX, sizeY, data_type.getValue(), v.data, v_min, v_max);
	}

	public static boolean VSliderScalar(String label, float sizeX, float sizeY, ImGuiDataType data_type, ImGuiInt v, int v_min, int v_max, String format, float power) {
		return ImGuiNative.VSliderScalar(label, sizeX, sizeY, data_type.getValue(), v.data, v_min, v_max, format, power);
	}

	// Widgets: Input with Keyboard
	// - If you want to use InputText() with a dynamic string type such as std::string or your own, see misc/cpp/imgui_stdlib.h
	// - Most of the ImGuiInputTextFlags flags are only useful for InputText() and not for InputFloatX, InputIntX, InputDouble etc.

	public static boolean InputText(String label, ImGuiString text) {
		return ImGuiNative.InputText(label, text.data, text.data.length, 0, text.inputData, text.inputData.maxChar, text.inputData.allowedChar, text.inputData.allowedChar.length());
	}

	public static boolean InputText(String label, ImGuiString text, ImGuiInputTextFlags flags) {
		return ImGuiNative.InputText(label, text.data, text.data.length, flags.getValue(), text.inputData, text.inputData.maxChar, text.inputData.allowedChar, text.inputData.allowedChar.length());
	}

	public static boolean InputFloat(String label, ImGuiFloat v) {
		return ImGuiNative.InputFloat(label, v.data);
	}

	public static boolean InputFloat(String label, ImGuiFloat v, float step, float step_fast, String format) {
		return ImGuiNative.InputFloat(label, v.data, step, step_fast, format);
	}

	public static boolean InputFloat(String label, ImGuiFloat v, float step, float step_fast, String format, ImGuiInputTextFlags flags) {
		return ImGuiNative.InputFloat(label, v.data, step, step_fast, format, flags.getValue());
	}

	public static boolean InputInt(String label, ImGuiInt v) {
		return ImGuiNative.InputInt(label, v.data);
	}

	public static boolean InputInt(String label, ImGuiInt v, float step, float step_fast) {
		return ImGuiNative.InputInt(label, v.data, step, step_fast);
	}

	public static boolean InputInt(String label, ImGuiInt v, float step, float step_fast, ImGuiInputTextFlags flags) {
		return ImGuiNative.InputInt(label, v.data, step, step_fast, flags.getValue());
	}

	public static boolean InputDouble(String label, ImGuiDouble v) {
		return ImGuiNative.InputDouble(label, v.data);
	}

	public static boolean InputDouble(String label, ImGuiDouble v, float step, float step_fast, String format) {
		return ImGuiNative.InputDouble(label, v.data, step, step_fast, format);
	}

	public static boolean InputDouble(String label, ImGuiDouble v, float step, float step_fast, String format, ImGuiInputTextFlags flags) {
		return ImGuiNative.InputDouble(label, v.data, step, step_fast, format, flags.getValue());
	}

	// Widgets: Color Editor/Picker (tip: the ColorEdit* functions have a little color square that can be left-clicked to open a picker, and right-clicked to open an option menu.)
	// - Note that in C++ a 'float v[X]' function argument is the _same_ as 'float* v', the array syntax is just a way to document the number of elements that are expected to be accessible.
	// - You can pass the address of a first float element out of a contiguous structure, e.g. &myvector.x

	public static boolean ColorEdit3(String label, ImColor color) {
		return ColorEdit3(label, color, ImGuiColorEditFlags.None);
	}

	public static boolean ColorEdit3(String label, ImColor color, ImGuiColorEditFlags flags) {
		return ImGuiNative.ColorEdit3(label, color.data, flags.getValue());
	}

	public static boolean ColorEdit4(String label, ImColor color) {
		return ColorEdit4(label, color, ImGuiColorEditFlags.None);
	}

	public static boolean ColorEdit4(String label, ImColor color, ImGuiColorEditFlags flags) {
		return ImGuiNative.ColorEdit4(label, color.data, flags.getValue());
	}

	public static boolean ColorPicker3(String label, ImColor color) {
		return ColorPicker3(label, color, ImGuiColorEditFlags.None);
	}

	public static boolean ColorPicker3(String label, ImColor color, ImGuiColorEditFlags flags) {
		return ImGuiNative.ColorPicker3(label, color.data, flags.getValue());
	}

	public static boolean ColorPicker4(String label, ImColor color) {
		return ColorPicker4(label, color, ImGuiColorEditFlags.None);
	}

	public static boolean ColorPicker4(String label, ImColor color, ImGuiColorEditFlags flags) {
		return ImGuiNative.ColorPicker4(label, color.data, flags.getValue());
	}

	// Widgets: Trees
	// - TreeNode functions return true when the node is open, in which case you need to also call TreePop() when you are finished displaying the tree node contents.

	public static boolean TreeNode(String label) {
		return ImGuiNative.TreeNode(label);
	}

	public static boolean TreeNode(String str_id, String label) {
		return ImGuiNative.TreeNode(str_id, label);
	}

	public static boolean TreeNode(int ptr_id, String label) {
		return ImGuiNative.TreeNode(ptr_id, label);
	}

	public static boolean TreeNodeEx(String label) {
		return ImGuiNative.TreeNodeEx(label);
	}

	public static boolean TreeNodeEx(String label, ImGuiTreeNodeFlags flags) {
		return ImGuiNative.TreeNodeEx(label, flags.getValue());
	}

	public static boolean TreeNodeEx(String str_id, ImGuiTreeNodeFlags flags, String label) {
		return ImGuiNative.TreeNodeEx(str_id, flags.getValue(), label);
	}

	public static boolean TreeNodeEx(int ptr_id, ImGuiTreeNodeFlags flags, String label) {
		return ImGuiNative.TreeNodeEx(ptr_id, flags.getValue(), label);
	}

	public static void TreePush() {
		ImGuiNative.TreePush();
	}

	public static void TreePush(String str_id) {
		ImGuiNative.TreePush(str_id);
	}

	public static void TreePush(int  ptr_id) {
		ImGuiNative.TreePush(ptr_id);
	}

	public static void TreePop() {
		ImGuiNative.TreePop();
	}

	public static float GetTreeNodeToLabelSpacing() {
		return ImGuiNative.GetTreeNodeToLabelSpacing();
	}

	public static boolean CollapsingHeader(String label) {
		return ImGuiNative.CollapsingHeader(label);
	}

	public static boolean CollapsingHeader(String label, ImGuiTreeNodeFlags flags) {
		return ImGuiNative.CollapsingHeader(label, flags.getValue());
	}

	public static boolean CollapsingHeader(String label, ImGuiBoolean p_open) {
		return ImGuiNative.CollapsingHeader(label, p_open.data);
	}

	public static boolean CollapsingHeader(String label, ImGuiBoolean p_open, ImGuiTreeNodeFlags flags) {
		return ImGuiNative.CollapsingHeader(label, p_open.data, flags.getValue());
	}


	// Widgets: Selectables
	// - A selectable highlights when hovered, and can display another color when selected.
	// - Neighbors selectable extend their highlight bounds in order to leave no gap between them.

	public static boolean Selectable(String label) {
		return ImGuiNative.Selectable(label);
	}

	public static boolean Selectable(String label, boolean selected) {
		return ImGuiNative.Selectable(label, selected);
	}

	public static boolean Selectable(String label, boolean selected, int flags, float sizeX, float sizeY) {
		return ImGuiNative.Selectable(label, selected, flags, sizeX, sizeY);
	}

	public static boolean Selectable(String label, ImGuiBoolean selected) {
		return ImGuiNative.Selectable(label, selected.data);
	}

	public static boolean Selectable(String label, ImGuiBoolean selected, int flags, float sizeX, float sizeY) {
		return ImGuiNative.Selectable(label, selected.data, flags, sizeX, sizeY);
	}

	// Widgets: List Boxes
	// - FIXME: To be consistent with all the newer API, ListBoxHeader/ListBoxFooter should in reality be called BeginListBox/EndListBox. Will rename them.

	public static void ListBox(String label, ImGuiInt current_item, String [] items, int items_count) {
		ImGuiNative.ListBox(label, current_item.data, items, items_count);
	}

	public static void ListBoxHeader(String label) {
		ImGuiNative.ListBoxHeader(label);
	}

	public static void ListBoxHeader(String label, float sizeX, float sizeY) {
		ImGuiNative.ListBoxHeader(label, sizeX, sizeY);
	}

	public static void ListBoxHeader(String label, int items_count) {
		ImGuiNative.ListBoxHeader(label, items_count);
	}

	public static void ListBoxHeader(String label, int items_count, int height_in_items) {
		ImGuiNative.ListBoxHeader(label, items_count, height_in_items);
	}

	// Widgets: Menus

	public static boolean BeginMainMenuBar() {
		return ImGuiNative.BeginMainMenuBar();
	}

	public static void EndMainMenuBar() {
		ImGuiNative.EndMainMenuBar();
	}

	public static boolean BeginMenuBar() {
		return ImGuiNative.BeginMenuBar();
	}

	public static void EndMenuBar() {
		ImGuiNative.EndMenuBar();
	}

	public static boolean BeginMenu(String label) {
		return ImGuiNative.BeginMenu(label);
	}

	public static boolean BeginMenu(String label, boolean enabled) {
		return ImGuiNative.BeginMenu(label, enabled);
	}

	public static void EndMenu() {
		ImGuiNative.EndMenu();
	}

	public static boolean MenuItem(String label) {
		return ImGuiNative.MenuItem(label);
	}

	public static boolean MenuItem(String label, boolean selected) {
		return ImGuiNative.MenuItem(label, selected);
	}

	public static boolean MenuItem(String label, boolean selected, boolean enabled) {
		return ImGuiNative.MenuItem(label, selected, enabled);
	}

	public static boolean MenuItem(String label, String shortcut, boolean selected) {
		return ImGuiNative.MenuItem(label, shortcut, selected);
	}

	public static boolean MenuItem(String label, String shortcut, boolean selected, boolean enabled) {
		return ImGuiNative.MenuItem(label, shortcut, selected, enabled);
	}

	public static boolean MenuItem(String label, String shortcut, ImGuiBoolean p_selected) {
		return ImGuiNative.MenuItem(label, shortcut, p_selected.data);
	}

	public static boolean MenuItem(String label, String shortcut, ImGuiBoolean p_selected, boolean enabled) {
		return ImGuiNative.MenuItem(label, shortcut, p_selected.data, enabled);
	}

	// Tooltips

	public static void BeginTooltip() {
		ImGuiNative.BeginTooltip();
	}

	public static void EndTooltip() {
		ImGuiNative.EndTooltip();
	}

	public static void SetTooltip(String text) {
		ImGuiNative.SetTooltip(text);
	}

	// Popups, Modals
	// The properties of popups windows are:
	// - They block normal mouse hovering detection outside them. (*)
	// - Unless modal, they can be closed by clicking anywhere outside them, or by pressing ESCAPE.
	// - Their visibility state (~bool) is held internally by imgui instead of being held by the programmer as we are used to with regular Begin() calls.
	//   User can manipulate the visibility state by calling OpenPopup().
	// (*) One can use IsItemHovered(ImGuiHoveredFlags_AllowWhenBlockedByPopup) to bypass it and detect hovering even when normally blocked by a popup.
	// Those three properties are connected. The library needs to hold their visibility state because it can close popups at any time.

	public static void OpenPopup(String str_id) {
		ImGuiNative.OpenPopup(str_id);
	}

	public static boolean BeginPopup(String str_id) {
		return ImGuiNative.BeginPopup(str_id);
	}

	public static boolean BeginPopup(String str_id, ImGuiWindowFlags flags) {
		return ImGuiNative.BeginPopup(str_id, flags.getValue());
	}

	public static boolean BeginPopupContextItem() {
		return ImGuiNative.BeginPopupContextItem();
	}

	public static boolean BeginPopupContextItem(String str_id, int mouse_button) {
		return ImGuiNative.BeginPopupContextItem(str_id, mouse_button);
	}

	public static boolean BeginPopupContextWindow() {
		return ImGuiNative.BeginPopupContextWindow();
	}

	public static boolean BeginPopupContextWindow(String str_id, int mouse_button, boolean also_over_items) {
		return ImGuiNative.BeginPopupContextWindow(str_id, mouse_button, also_over_items);
	}

	public static boolean BeginPopupContextVoid() {
		return ImGuiNative.BeginPopupContextVoid();
	}

	public static boolean BeginPopupContextVoid(String str_id, int mouse_button) {
		return ImGuiNative.BeginPopupContextVoid(str_id, mouse_button);
	}

	public static boolean BeginPopupModal(String name) {
		return ImGuiNative.BeginPopupModal(name);
	}

	public static boolean BeginPopupModal(String name, ImGuiWindowFlags flags) {
		return ImGuiNative.BeginPopupModal(name, flags.getValue());
	}

	public static boolean BeginPopupModal(String name, ImGuiBoolean p_open, ImGuiWindowFlags flags) {
		return ImGuiNative.BeginPopupModal(name, p_open.data, flags.getValue());
	}

	public static void EndPopup() {
		ImGuiNative.EndPopup();
	}

	public static void OpenPopupOnItemClick() {
		ImGuiNative.OpenPopupOnItemClick();
	}

	public static void OpenPopupOnItemClick(String str_id, int mouse_button) {
		ImGuiNative.OpenPopupOnItemClick(str_id, mouse_button);
	}

	public static boolean IsPopupOpen(String str_id) {
		return ImGuiNative.IsPopupOpen(str_id);
	}

	public static void CloseCurrentPopup() {
		ImGuiNative.CloseCurrentPopup();
	}

	// Columns
	// - You can also use SameLine(pos_x) to mimic simplified columns.
	// - The columns API is work-in-progress and rather lacking (columns are arguably the worst part of dear imgui at the moment!)

	@Deprecated
	public static void Columns() {
		ImGuiNative.Columns();
	}

	@Deprecated
	public static void Columns(int count) {
		ImGuiNative.Columns(count);
	}

	@Deprecated
	public static void Columns(int count, String id) {
		ImGuiNative.Columns(count, id);
	}

	@Deprecated
	public static void Columns(int count, String id, boolean border) {
		ImGuiNative.Columns(count, id, border);
	}

	@Deprecated
	public static void NextColumn() {
		ImGuiNative.NextColumn();
	}

	@Deprecated
	public static int GetColumnIndex() {
		return ImGuiNative.GetColumnIndex();
	}

	@Deprecated
	public static float GetColumnWidth() {
		return ImGuiNative.GetColumnWidth();
	}

	@Deprecated
	public static float GetColumnWidth(int column_index) {
		return ImGuiNative.GetColumnWidth(column_index);
	}

	@Deprecated
	public static void SetColumnWidth(int column_index, float width) {
		ImGuiNative.SetColumnWidth(column_index, width);
	}

	@Deprecated
	public static float GetColumnOffset() {
		return ImGuiNative.GetColumnOffset();
	}

	@Deprecated
	public static float GetColumnOffset(int column_index) {
		return ImGuiNative.GetColumnOffset(column_index);
	}

	@Deprecated
	public static void SetColumnOffset(int column_index, float offset_x) {
		ImGuiNative.SetColumnOffset(column_index, offset_x);
	}

	@Deprecated
	public static int GetColumnsCount() {
		return ImGuiNative.GetColumnsCount();
	}

	// Tables

	public static boolean BeginTable(String id, int columns_count) {
		return ImGuiNative.BeginTable(id, columns_count);
	}

	public static boolean BeginTable(String id, int columns_count, ImGuiTableFlags flags) {
		return ImGuiNative.BeginTable(id, columns_count, flags.getValue());
	}

	public static boolean BeginTable(String id, int columns_count, ImGuiTableFlags flags, float outer_sizeX, float outer_sizeY) {
		return ImGuiNative.BeginTable(id, columns_count, flags.getValue(), outer_sizeX, outer_sizeY);
	}

	public static boolean BeginTable(String id, int columns_count, ImGuiTableFlags flags, float outer_sizeX, float outer_sizeY, float inner_width) {
		return ImGuiNative.BeginTable(id, columns_count, flags.getValue(), outer_sizeX, outer_sizeY, inner_width);
	}

	public static boolean BeginTable(CharSequence id, int columns_count) {
		byte[] tempChar = CharSequenceHelper.getTempChar(id, 0);
		return ImGuiNative.BeginTable(tempChar, columns_count);
	}

	public static boolean BeginTable(CharSequence id, int columns_count, ImGuiTableFlags flags) {
		byte[] tempChar = CharSequenceHelper.getTempChar(id, 0);
		return ImGuiNative.BeginTable(tempChar, columns_count, flags.getValue());
	}

	public static boolean BeginTable(CharSequence id, int columns_count, ImGuiTableFlags flags, float outer_sizeX, float outer_sizeY) {
		byte[] tempChar = CharSequenceHelper.getTempChar(id, 0);
		return ImGuiNative.BeginTable(tempChar, columns_count, flags.getValue(), outer_sizeX, outer_sizeY);
	}

	public static boolean BeginTable(CharSequence id, int columns_count, ImGuiTableFlags flags, float outer_sizeX, float outer_sizeY, float inner_width) {
		byte[] tempChar = CharSequenceHelper.getTempChar(id, 0);
		return ImGuiNative.BeginTable(tempChar, columns_count, flags.getValue(), outer_sizeX, outer_sizeY, inner_width);
	}

	public static void EndTable() {
		ImGuiNative.EndTable();
	}

	public static void TableNextRow() {
		ImGuiNative.TableNextRow();
	}

	public static void TableNextRow(int row_flags) {
		ImGuiNative.TableNextRow(row_flags);
	}

	public static void TableNextRow(int row_flags, float min_row_height) {
		ImGuiNative.TableNextRow(row_flags, min_row_height);
	}

	public static boolean TableNextColumn() {
		return ImGuiNative.TableNextColumn();
	}

	public static boolean TableSetColumnIndex(int column_n) {
		return ImGuiNative.TableSetColumnIndex(column_n);
	}

	public static int TableGetColumnIndex() {
		return ImGuiNative.TableGetColumnIndex();
	}

	public static int TableGetRowIndex() {
		return ImGuiNative.TableGetRowIndex();
	}

	// Tables: Headers & Columns declaration

	public static void TableSetupColumn(String label) {
		ImGuiNative.TableSetupColumn(label);
	}

	public static void TableSetupColumn(String label, ImGuiTableColumnFlags flags) {
		ImGuiNative.TableSetupColumn(label, flags.getValue());
	}

	public static void TableSetupColumn(CharSequence label, ImGuiTableColumnFlags flags) {
		byte[] tempChar = CharSequenceHelper.getTempChar(label, 0);
		ImGuiNative.TableSetupColumn(tempChar, flags.getValue());
	}

	public static void TableSetupColumn(String label, ImGuiTableColumnFlags flags, float init_width_or_weight) {
		ImGuiNative.TableSetupColumn(label, flags.getValue(), init_width_or_weight);
	}

	public static void TableSetupColumn(String label, ImGuiTableColumnFlags flags, float init_width_or_weight, int user_id) {
		ImGuiNative.TableSetupColumn(label, flags.getValue(), init_width_or_weight, user_id);
	}

	public static void TableHeadersRow() {
		ImGuiNative.TableHeadersRow();
	}

	public static void TableHeader(String label) {
		ImGuiNative.TableHeader(label);
	}

	// Tables: Miscellaneous functions

	//TODO Fix return string
	public static String TableGetColumnName() {
		return null;
	}

	public static int TableGetColumnCount() {
		return ImGuiNative.TableGetColumnCount();
	}

	public static void TableGetSortSpecs() {
		// TODO
	}

	public static void TableSetBgColor() {
		// TODO
	}

	// Tab Bars, Tabs
	// [BETA API] API may evolve!

	public static boolean BeginTabBar(String str_id) {
		return ImGuiNative.BeginTabBar(str_id);
	}

	public static boolean BeginTabBar(String str_id, ImGuiTabBarFlags flags) {
		return ImGuiNative.BeginTabBar(str_id, flags.getValue());
	}

	public static void EndTabBar() {
		ImGuiNative.EndTabBar();
	}

	public static boolean BeginTabItem(String label) {
		return ImGuiNative.BeginTabItem(label);
	}

	public static boolean BeginTabItem(String label, ImGuiBoolean p_open, ImGuiTabItemFlags flags) {
		return ImGuiNative.BeginTabItem(label, p_open.data, flags.getValue());
	}

	public static void EndTabItem() {
		ImGuiNative.EndTabItem();
	}

	public static void SetTabItemClosed(String tab_or_docked_window_label) {
		ImGuiNative.SetTabItemClosed(tab_or_docked_window_label);
	}

	// Docking
	// [BETA API] Enable with io.ConfigFlags |= ImGuiConfigFlags_DockingEnable.
	// Note: you DO NOT need to call DockSpace() to use most Docking facilities!
	// To dock windows: if io.ConfigDockingWithShift == false: drag window from their title bar.
	// To dock windows: if io.ConfigDockingWithShift == true: hold SHIFT anywhere while moving windows.
	// Use DockSpace() to create an explicit dock node _within_ an existing window. See Docking demo for details.

	//TODO Create ImGuiWindowClass. May need to have a C++ pointer reference.

	public static int DockSpace(int id) {
		return ImGuiNative.DockSpace(id);
	}

	public static int DockSpace(int id, float sizeX, float sizeY) {
		return ImGuiNative.DockSpace(id, sizeX, sizeY);
	}

	public static int DockSpace(int id, float sizeX, float sizeY, ImGuiDockNodeFlags flags) {
		return ImGuiNative.DockSpace(id, sizeX, sizeY, flags.getValue());
	}

	public static int DockSpaceOverViewport() {
		return ImGuiNative.DockSpaceOverViewport();
	}

	public static int DockSpaceOverViewport(ImGuiViewport viewport) {
		return ImGuiNative.DockSpaceOverViewport(viewport, ImGuiDockNodeFlags.None.getValue());
	}

	public static int DockSpaceOverViewport(ImGuiViewport viewport, ImGuiDockNodeFlags flags) {
		return ImGuiNative.DockSpaceOverViewport(viewport, flags.getValue());
	}

	public static void SetNextWindowDockID(int dock_id) {
		SetNextWindowDockID(dock_id, ImGuiCond.None);
	}

	public static void SetNextWindowDockID(int dock_id, ImGuiCond cond) {
		ImGuiNative.SetNextWindowDockID(dock_id, cond.getValue());
	}

	public static int GetWindowDockID() {
		return ImGuiNative.GetWindowDockID();
	}

	public static boolean IsWindowDocked() {
		return ImGuiNative.IsWindowDocked();
	}

	// Drag and Drop

	private static WeakReference<Object> dragDropData = null;

	public static boolean BeginDragDropSource() {
		return ImGuiNative.BeginDragDropSource(0);
	}

	public static boolean BeginDragDropSource(ImGuiDragDropFlags flags) {
		return ImGuiNative.BeginDragDropSource(flags.getValue());
	}

	public static boolean SetDragDropPayload(String type, Object data) {
		if (dragDropData == null || dragDropData.get() != data) {
			dragDropData = new WeakReference<>(data);
		}
		return ImGuiNative.SetDragDropPayload(type);
	}

	public static void EndDragDropSource() {
		ImGuiNative.EndDragDropSource();
	}

	public static boolean BeginDragDropTarget() {
		return ImGuiNative.BeginDragDropTarget();
	}

	public static <T> T AcceptDragDropPayload(String type, Class<T> classType) {
		return AcceptDragDropPayload(type, classType, ImGuiDragDropFlags.None);
	}

	public static <T> T AcceptDragDropPayload(String type, Class<T> classType, ImGuiDragDropFlags flags) {
		if(ImGuiNative.AcceptDragDropPayload(type, flags.getValue())) {
			if(dragDropData != null) {
				Object data = dragDropData.get();
				if(data != null && data.getClass() == classType) {
					return (T)data;
				}
			}
		}
		return null;
	}

	public static void EndDragDropTarget() {
		ImGuiNative.EndDragDropTarget();
	}

	/**
	 * Peek directly into the current payload from anywhere. may return NULL
	 */
	public static <T> T GetDragDropPayload( Class<T> classType) {
		if(dragDropData != null && ImGuiNative.HasDragDropPayloadData()) {
			Object data = dragDropData.get();
			if(data != null && data.getClass() == classType) {
				return (T)data;
			}
		}
		return null;
	}

	// Disabling [BETA API]
	// - Disable all user interactions and dim items visuals (applying style.DisabledAlpha over current colors)
	// - Those can be nested but it cannot be used to enable an already disabled section (a single BeginDisabled(true) in the stack is enough to keep everything disabled)
	// - BeginDisabled(false) essentially does nothing useful but is provided to facilitate use of boolean expressions. If you can avoid calling BeginDisabled(False)/EndDisabled() best to avoid it.

	public static void BeginDisabled() {
		BeginDisabled(true);
	};

	public static void BeginDisabled(boolean disabled) {
		ImGuiNative.BeginDisabled(disabled);
	}

	public static void EndDisabled() {
		ImGuiNative.EndDisabled();
	}

	// Focus, Activation
	// - Prefer using "SetItemDefaultFocus()" over "if (IsWindowAppearing()) SetScrollHereY()" when applicable to signify "this is the default item"

	public static void SetItemDefaultFocus() {
		ImGuiNative.SetItemDefaultFocus();
	}

	public static void SetKeyboardFocusHere() {
		ImGuiNative.SetKeyboardFocusHere();
	}

	public static void SetKeyboardFocusHere(int offset) {
		ImGuiNative.SetKeyboardFocusHere(offset);
	}

	// Item/Widgets Utilities
	// - Most of the functions are referring to the last/previous item we submitted.
	// - See Demo Window under "Widgets->Querying Status" for an interactive visualization of most of those functions.

	public static boolean IsItemHovered() {
		return ImGuiNative.IsItemHovered();
	}

	public static boolean IsItemHovered(ImGuiHoveredFlags flags) {
		return ImGuiNative.IsItemHovered(flags.getValue());
	}

	public static boolean IsItemActive() {
		return ImGuiNative.IsItemActive();
	}

	public static boolean IsItemFocused() {
		return ImGuiNative.IsItemFocused();
	}

	public static boolean IsItemClicked() {
		return ImGuiNative.IsItemClicked();
	}

	public static boolean IsItemClicked(int mouse_button) {
		return ImGuiNative.IsItemClicked(mouse_button);
	}

	public static boolean IsItemVisible() {
		return ImGuiNative.IsItemVisible();
	}

	public static boolean IsItemEdited() {
		return ImGuiNative.IsItemEdited();
	}

	public static boolean IsItemActivated() {
		return ImGuiNative.IsItemActivated();
	}

	public static boolean IsItemDeactivated() {
		return ImGuiNative.IsItemDeactivated();
	}

	public static boolean IsItemDeactivatedAfterEdit() {
		return ImGuiNative.IsItemDeactivatedAfterEdit();
	}

	public static boolean IsAnyItemHovered() {
		return ImGuiNative.IsAnyItemHovered();
	}

	public static boolean IsAnyItemActive() {
		return ImGuiNative.IsAnyItemActive();
	}

	public static boolean IsAnyItemFocused() {
		return ImGuiNative.IsAnyItemFocused();
	}

	public static ImVec2 GetItemRectMin() {
		ImGuiNative.GetItemRectMin(imVec2);
		return imVec2;
	}

	public static ImVec2 GetItemRectMax() {
		ImGuiNative.GetItemRectMax(imVec2);
		return imVec2;
	}

	public static ImVec2 GetItemRectSize() {
		ImGuiNative.GetItemRectSize(imVec2);
		return imVec2;
	}

	public static void SetItemAllowOverlap() {
		ImGuiNative.SetItemAllowOverlap();
	}

	// Viewports
	// - Currently represents the Platform Window created by the application which is hosting our Dear ImGui windows.
	// - In 'docking' branch with multi-viewport enabled, we extend this concept to have multiple active viewports.
	// - In the future we will extend this concept further to also represent Platform Monitor and support a "no main platform window" operation mode.

	public static ImGuiViewport GetMainViewport() {
		return GetMainViewport(false);
	}

	public static ImGuiViewport GetMainViewport(boolean updateDrawData) {
		return ImGuiNative.GetMainViewport(updateDrawData);
	}

	// Miscellaneous Utilities

	public static int GetFrameCount() {
		return ImGuiNative.GetFrameCount();
	}

	public static boolean BeginChildFrame(int id, float width, float height) {
		return ImGuiNative.BeginChildFrame(id, width, height);
	}

	public static boolean BeginChildFrame(int id, float width, float height, ImGuiWindowFlags flags) {
		return ImGuiNative.BeginChildFrame(id, width, height, flags.getValue());
	}

	public static void EndChildFrame() {
		ImGuiNative.EndChildFrame();
	}

	// Inputs Utilities

	public static boolean IsMouseDown(int button) {
		return ImGuiNative.IsMouseDown(button);
	}

	public static boolean IsMouseClicked(int button) {
		return ImGuiNative.IsMouseClicked(button);
	}

	public static boolean IsMouseClicked(int button, boolean repeat) {
		return ImGuiNative.IsMouseClicked(button, repeat);
	}

	public static boolean IsMouseReleased(int button) {
		return ImGuiNative.IsMouseReleased(button);
	}

	public static boolean IsMouseDragging(int button) {
		return ImGuiNative.IsMouseDragging(button);
	}

	public static boolean IsMouseDragging(int button, float lock_threshold) {
		return ImGuiNative.IsMouseDragging(button, lock_threshold);
	}

	public static boolean IsMouseHoveringRect(float minX, float minY, float maxX, float maxY) {
		return ImGuiNative.IsMouseHoveringRect(minX, minY, maxX, maxY);
	}

	public static boolean IsMouseHoveringRect(float minX, float minY, float maxX, float maxY, boolean clip) {
		return ImGuiNative.IsMouseHoveringRect(minX, minY, maxX, maxY, clip);
	}

	// (Optional) Platform/OS interface for multi-viewport support

	public static void UpdatePlatformWindows() {
		ImGuiNative.UpdatePlatformWindows();
	}

	public static void RenderPlatformWindowsDefault() {
		ImGuiNative.RenderPlatformWindowsDefault();
	}

	public static void DestroyPlatformWindows() {
		ImGuiNative.DestroyPlatformWindows();
	}

	public static ImGuiViewport FindViewportByPlatformHandle(long platformHandle, boolean updateDrawData) {
		return ImGuiNative.FindViewportByPlatformHandle(platformHandle, updateDrawData);
	}


	// Internal methods

	public static void PushMultiItemsWidths(int components, float w_full) {
		ImGuiInternalNative.PushMultiItemsWidths(components, w_full);
	}

	public static void ItemSize(float x1, float y1, float text_offset_y) {
		ImGuiInternalNative.ItemSize(x1, y1, text_offset_y);
	}

	public static void ItemSize(float x1, float y1, float x2, float y2, float text_offset_y) {
		ImGuiInternalNative.ItemSize(x1, y1, x2, y2, text_offset_y);
	}

	public static boolean ItemAdd(float x1, float y1, float x2, float y2, String id) {
		return ImGuiInternalNative.ItemAdd(x1, y1, x2, y2, id);
	}

	public static void PushItemFlag(ImGuiItemFlags option, boolean enabled) {
		ImGuiInternalNative.PushItemFlag(option.getValue(), enabled);
	}

	public static void PopItemFlag() {
		ImGuiInternalNative.PopItemFlag();
	}



	/**
	 *  ##### Start ImGuiWindow
	 */

	public static boolean GetWindowSkipItem() {
		return ImGuiInternalNative.GetWindowSkipItem();
	}

	public static float GetWindowDCCursorPosX() {
		return ImGuiInternalNative.GetWindowDCCursorPosX();
	}

	public static float GetWindowDCCursorPosY() {
		return ImGuiInternalNative.GetWindowDCCursorPosY();
	}

	/**
	 *  ##### End ImGuiWindow
	 */

	/**
	 *  ##### Start ImGuiContext
	 */

	public static double GetContextTime() {
		return ImGuiInternalNative.GetContextTime();
	}

	/**
	 * ##### End ImGuiContext
	 */



	// Helper methods

	/** Packs the color components into a 32-bit integer with the format ABGR. Note that no range checking is performed for higher
	 * performance.
	 * @param r the red component, 0 - 255
	 * @param g the green component, 0 - 255
	 * @param b the blue component, 0 - 255
	 * @param a the alpha component, 0 - 255
	 * @return the packed color as a 32-bit int */
	public static int ColorToIntBits (int r, int g, int b, int a) {
		return (a << 24) | (b << 16) | (g << 8) | r;
	}
}
