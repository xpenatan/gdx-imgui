package com.github.xpenatan.imgui;

import com.badlogic.gdx.jnigen.JniGenSharedLibraryLoader;
import com.github.xpenatan.imgui.custom.EditTextFloatData;
import com.github.xpenatan.imgui.custom.EditTextIntData;
import com.github.xpenatan.imgui.custom.ImGuiCollapseLayoutOptions;
import com.github.xpenatan.imgui.custom.ImGuiLayout;
import com.github.xpenatan.imgui.jnicode.ImGuiExtNative;
import com.github.xpenatan.imgui.jnicode.ImGuiLayoutNative;

public class ImGuiExt {

	private static boolean IMGUIINIT = false;

	public static void init () {
		init(true);
	}

	public static void init (boolean logging) {
		if(ImGuiExt.IMGUIINIT)
			return;
		JniGenSharedLibraryLoader loader = new JniGenSharedLibraryLoader();
		loader.load("imgui-ext");
		ImGuiExt.IMGUIINIT = true;

		ImGuiLayoutNative.init();
		ImGuiExtNative.init();
	}

	protected ImGuiExt() {
	}

	// Layout

	public static void DrawBoundingBox(float x1, float y1, float x2, float y2, int r, int g, int b, int a) {
		ImGuiLayoutNative.DrawBoundingBox(x1, y1, x2, y2, r, g, b, a);
	}

	public static void ShowLayoutDebug() {
		ImGuiLayoutNative.ShowLayoutDebug();
	}

	public static void ShowLayoutDebugClipping() {
		ImGuiLayoutNative.ShowLayoutDebugClipping();
	}

	public static void BeginLayout(String id, float sizeX, float sizeY) {
		ImGuiLayoutNative.BeginLayout(id, sizeX, sizeY);
	}

	public static void BeginLayout(String id, float sizeX, float sizeY, float paddingLeft, float paddingRight, float paddingTop, float paddingBottom) {
		ImGuiLayoutNative.BeginLayout(id, sizeX, sizeY, paddingLeft, paddingRight, paddingTop, paddingBottom);
	}

	public static void EndLayout() {
		ImGuiLayoutNative.EndLayout();
	}

	public static ImGuiLayout GetCurrentLayout() {
		ImGuiLayoutNative.GetCurrentLayout(ImGuiLayout.tempLayout);
		return ImGuiLayout.tempLayout;
	}

	// Align view

	public static void BeginAlign(String id, float sizeX, float sizeY, float alignX, float alignY) {
		ImGuiLayoutNative.BeginAlign(id, sizeX, sizeY, alignX, alignY);
	}

	public static void BeginAlign(String id, float sizeX, float sizeY, float alignX, float alignY, float offsetX, float offsetY) {
		ImGuiLayoutNative.BeginAlign(id, sizeX, sizeY, alignX, alignY, offsetX, offsetY);
	}

	public static void EndAlign() {
		ImGuiLayoutNative.EndAlign();
	}

	public static void AlignLayout(float alignX, float alignY) {
		ImGuiLayoutNative.AlignLayout(alignX, alignY);
	}

	public static void AlignLayout(float alignX, float alignY, float offsetX, float offsetY) {
		ImGuiLayoutNative.AlignLayout(alignX, alignY, offsetX, offsetY);
	}

	public static void BeginBoundingBox() {
		ImGuiLayoutNative.BeginBoundingBox();
	}

	public static ImRect EndBoundingBox() {
		ImRect.tmp.reset();
		ImGuiLayoutNative.EndBoundingBox(ImRect.tmp);
		return ImRect.tmp;
	}

	// Custom Collapse Layout

	public static boolean BeginCollapseLayoutEx(String id, String title, float sizeX, float sizeY) {
		return ImGuiLayoutNative.BeginCollapseLayoutEx(id, title, sizeX, sizeY, ImGuiLayoutNative.defaultOptions);
	}

	public static boolean BeginCollapseLayoutEx(String id, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options) {
		return ImGuiLayoutNative.BeginCollapseLayoutEx(id, title, sizeX, sizeY, options);
	}

	public static void BeginCollapseLayoutEx(String id, ImGuiBoolean isOpen, String title, float sizeX, float sizeY) {
		ImGuiLayoutNative.BeginCollapseLayoutEx(id, isOpen.data, title, sizeX, sizeY, ImGuiLayoutNative.defaultOptions);
	}

	public static void BeginCollapseLayoutEx(String id, ImGuiBoolean isOpen, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options) {
		ImGuiLayoutNative.BeginCollapseLayoutEx(id, isOpen.data, title, sizeX, sizeY, options);
	}

	public static boolean BeginCollapseLayout(String id, String title, float sizeX, float sizeY) {
		return ImGuiLayoutNative.BeginCollapseLayout(id, title, sizeX, sizeY, ImGuiLayoutNative.defaultOptions);
	}

	public static boolean BeginCollapseLayout(String id, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options) {
		return ImGuiLayoutNative.BeginCollapseLayout(id, title, sizeX, sizeY, options);
	}

	public static void BeginCollapseLayout(String id, ImGuiBoolean isOpen, String title, float sizeX, float sizeY) {
		ImGuiLayoutNative.BeginCollapseLayout(id, isOpen.data, title, sizeX, sizeY, ImGuiLayoutNative.defaultOptions);
	}

	public static void BeginCollapseLayout(String id, ImGuiBoolean isOpen, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options) {
		ImGuiLayoutNative.BeginCollapseLayout(id, isOpen.data, title, sizeX, sizeY, options);
	}

	public static void EndCollapseFrameLayout() {
		ImGuiLayoutNative.EndCollapseFrameLayout();
	}

	public static void EndCollapseLayout() {
		ImGuiLayoutNative.EndCollapseLayout();
	}

	// Table Ext

	public static float GetTableContentHeight() {
		return ImGuiExtNative.GetTableContentHeight();
	}

	public static void CalculateTableRowHeight() {
		ImGuiExtNative.CalculateTableRowHeight();
	}

	public static float GetTableRowHeight() {
		return ImGuiExtNative.GetTableRowHeight();
	}

	//Custom Widget

	public static int EditTextF(String id, EditTextFloatData d1) {
		return ImGuiExtNative.EditTextF(id, d1, null, null, null);
	}

	public static int EditTextF(String id, EditTextFloatData d1, EditTextFloatData d2) {
		return ImGuiExtNative.EditTextF(id, d1, d2, null, null);
	}

	public static int EditTextF(String id, EditTextFloatData d1, EditTextFloatData d2, EditTextFloatData d3) {
		return ImGuiExtNative.EditTextF(id, d1, d2, d3, null);
	}

	public static int EditTextF(String id, EditTextFloatData d1, EditTextFloatData d2, EditTextFloatData d3, EditTextFloatData d4) {
		return ImGuiExtNative.EditTextF(id, d1, d2, d3, d4);
	}

	public static int EditTextI(String id, EditTextIntData d1) {
		return ImGuiExtNative.EditTextI(id, d1, null, null, null);
	}

	public static int EditTextI(String id, EditTextIntData d1, EditTextIntData d2) {
		return ImGuiExtNative.EditTextI(id, d1, d2, null, null);
	}

	public static int EditTextI(String id, EditTextIntData d1, EditTextIntData d2, EditTextIntData d3) {
		return ImGuiExtNative.EditTextI(id, d1, d2, d3, null);
	}

	public static int EditTextI(String id, EditTextIntData d1, EditTextIntData d2, EditTextIntData d3, EditTextIntData d4) {
		return ImGuiExtNative.EditTextI(id, d1, d2, d3, d4);
	}

	// Helper methods

	/** Packs the color components into a 32-bit integer with the format ABGR. Note that no range checking is performed for higher
	 * performance.
	 * @param r the red component, 0 - 255
	 * @param g the green component, 0 - 255
	 * @param b the blue component, 0 - 255
	 * @param a the alpha component, 0 - 255
	 * @return the packed color as a 32-bit int */
	public static int colorToIntBits (int r, int g, int b, int a) {
		return (a << 24) | (b << 16) | (g << 8) | r;
	}
}
