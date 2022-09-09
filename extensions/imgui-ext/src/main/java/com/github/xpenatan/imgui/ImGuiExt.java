package com.github.xpenatan.imgui;

import com.badlogic.gdx.utils.SharedLibraryLoader;
import com.github.xpenatan.imgui.custom.*;
import com.github.xpenatan.imgui.enums.ImGuiInputTextFlags;
import com.github.xpenatan.imgui.jnicode.ImGuiExtNative;
import com.github.xpenatan.imgui.jnicode.ImGuiLayoutNative;
import com.github.xpenatan.imgui.jnicode.ImGuiNative;
import com.github.xpenatan.imgui.util.CharSequenceHelper;

public class ImGuiExt {

	private static boolean IMGUIINIT = false;

	public static void init () {
		init(true);
	}

	public static void init (boolean logging) {
		if(ImGuiExt.IMGUIINIT)
			return;

		SharedLibraryLoader loader = new SharedLibraryLoader();
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

	public static void BeginAlign(CharSequence id, float sizeX, float sizeY, float alignX, float alignY) {
		byte[] tempChar = CharSequenceHelper.getTempChar(id, 0);
		ImGuiLayoutNative.BeginAlign(tempChar, sizeX, sizeY, alignX, alignY);
	}

	public static void BeginAlign(CharSequence id, float sizeX, float sizeY, float alignX, float alignY, float offsetX, float offsetY) {
		byte[] tempChar = CharSequenceHelper.getTempChar(id, 0);
		ImGuiLayoutNative.BeginAlign(tempChar, sizeX, sizeY, alignX, alignY, offsetX, offsetY);
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

	public static boolean BeginCollapseLayoutEx(int id, String title, float sizeX, float sizeY) {
		return ImGuiLayoutNative.BeginCollapseLayoutEx(id, title, sizeX, sizeY, ImGuiLayoutNative.defaultOptions);
	}

	public static boolean BeginCollapseLayoutEx(int id, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options) {
		return ImGuiLayoutNative.BeginCollapseLayoutEx(id, title, sizeX, sizeY, options);
	}

	public static boolean BeginCollapseLayoutEx(int id, CharSequence title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options) {
		byte[] tempChar = CharSequenceHelper.getTempChar(title, 0);
		return ImGuiLayoutNative.BeginCollapseLayoutEx(id, tempChar, sizeX, sizeY, options);
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
		return ImGuiExtNative.EditTextF(id, d1, null, null, null, 0);
	}

	public static int EditTextF(String id, EditTextFloatData d1, EditTextFloatData d2) {
		return ImGuiExtNative.EditTextF(id, d1, d2, null, null, 0);
	}

	public static int EditTextF(String id, EditTextFloatData d1, EditTextFloatData d2, EditTextFloatData d3) {
		return ImGuiExtNative.EditTextF(id, d1, d2, d3, null, 0);
	}

	public static int EditTextF(String id, EditTextFloatData d1, EditTextFloatData d2, EditTextFloatData d3, EditTextFloatData d4) {
		return ImGuiExtNative.EditTextF(id, d1, d2, d3, d4, 0);
	}

	public static int EditTextI(String id, EditTextIntData d1) {
		return ImGuiExtNative.EditTextI(id, d1, null, null, null, 0);
	}

	public static int EditTextI(String id, EditTextIntData d1, EditTextIntData d2) {
		return ImGuiExtNative.EditTextI(id, d1, d2, null, null, 0);
	}

	public static int EditTextI(String id, EditTextIntData d1, EditTextIntData d2, EditTextIntData d3) {
		return ImGuiExtNative.EditTextI(id, d1, d2, d3, null, 0);
	}

	public static int EditTextI(String id, EditTextIntData d1, EditTextIntData d2, EditTextIntData d3, EditTextIntData d4) {
		return ImGuiExtNative.EditTextI(id, d1, d2, d3, d4, 0);
	}

	public static int EditTextF(String id, EditTextFloatData d1, int flags) {
		return ImGuiExtNative.EditTextF(id, d1, null, null, null, flags);
	}

	public static int EditTextF(String id, EditTextFloatData d1, EditTextFloatData d2, int flags) {
		return ImGuiExtNative.EditTextF(id, d1, d2, null, null, flags);
	}

	public static int EditTextF(String id, EditTextFloatData d1, EditTextFloatData d2, EditTextFloatData d3, int flags) {
		return ImGuiExtNative.EditTextF(id, d1, d2, d3, null, flags);
	}

	public static int EditTextF(String id, EditTextFloatData d1, EditTextFloatData d2, EditTextFloatData d3, EditTextFloatData d4, int flags) {
		return ImGuiExtNative.EditTextF(id, d1, d2, d3, d4, flags);
	}

	public static int EditTextI(String id, EditTextIntData d1, int flags) {
		return ImGuiExtNative.EditTextI(id, d1, null, null, null, flags);
	}

	public static int EditTextI(String id, EditTextIntData d1, EditTextIntData d2, int flags) {
		return ImGuiExtNative.EditTextI(id, d1, d2, null, null, flags);
	}

	public static int EditTextI(String id, EditTextIntData d1, EditTextIntData d2, EditTextIntData d3, int flags) {
		return ImGuiExtNative.EditTextI(id, d1, d2, d3, null, flags);
	}

	public static int EditTextI(String id, EditTextIntData d1, EditTextIntData d2, EditTextIntData d3, EditTextIntData d4, int flags) {
		return ImGuiExtNative.EditTextI(id, d1, d2, d3, d4, flags);
	}

	public static boolean EditTextS(String id, EditTextStringData d1) {
		return ImGuiExtNative.EditTextS(id, d1, d1.getData(), d1.getData().length, 0, d1.inputData, d1.inputData.maxChar, d1.inputData.allowedChar, d1.inputData.allowedChar.length());
	}

	public static boolean EditTextS(String id, EditTextStringData d1, ImGuiInputTextFlags flags) {
		return ImGuiExtNative.EditTextS(id, d1, d1.getData(), d1.getData().length, flags.getValue(), d1.inputData, d1.inputData.maxChar, d1.inputData.allowedChar, d1.inputData.allowedChar.length());
	}
}
