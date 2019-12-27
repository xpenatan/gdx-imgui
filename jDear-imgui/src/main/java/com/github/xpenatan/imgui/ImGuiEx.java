package com.github.xpenatan.imgui;

import com.github.xpenatan.imgui.ImGuiCustomWidgetNative.ImGuiCollapseLayoutOptions;
import com.github.xpenatan.imgui.ImGuiCustomWidgetNative.ImGuiLayout;

public class ImGuiEx {

	protected ImGuiEx() {
	}

	public static void ShowLayoutDebug() {
		ImGuiCustomWidgetNative.ShowLayoutDebug();
	}

	public static void BeginLayout(String id, float sizeX, float sizeY) {
		ImGuiCustomWidgetNative.BeginLayout(id, sizeX, sizeY);
	}

	public static void BeginLayout(String id, float sizeX, float sizeY, float paddingLeft, float paddingRight, float paddingTop, float paddingBottom) {
		ImGuiCustomWidgetNative.BeginLayout(id, sizeX, sizeY, paddingLeft, paddingRight, paddingTop, paddingBottom);
	}

	public static void EndLayout() {
		ImGuiCustomWidgetNative.EndLayout();
	}

	public static boolean BeginCollapseLayoutEx(String title, float sizeX, float sizeY) {
		return ImGuiCustomWidgetNative.BeginCollapseLayoutEx2(title, sizeX, sizeY, ImGuiCustomWidgetNative.defaultOptions);
	}

	public static boolean BeginCollapseLayoutEx(String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options) {
		return ImGuiCustomWidgetNative.BeginCollapseLayoutEx2(title, sizeX, sizeY, options);
	}

	public static void BeginCollapseLayoutEx(ImGuiBoolean isOpen, String title, float sizeX, float sizeY) {
		ImGuiCustomWidgetNative.BeginCollapseLayoutEx(isOpen.data, title, sizeX, sizeY, ImGuiCustomWidgetNative.defaultOptions);
	}

	public static void BeginCollapseLayoutEx(ImGuiBoolean isOpen, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options) {
		ImGuiCustomWidgetNative.BeginCollapseLayoutEx(isOpen.data, title, sizeX, sizeY, options);
	}

	public static boolean BeginCollapseLayout(String title, float sizeX, float sizeY) {
		return ImGuiCustomWidgetNative.BeginCollapseLayout2(title, sizeX, sizeY, ImGuiCustomWidgetNative.defaultOptions);
	}

	public static boolean BeginCollapseLayout(String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options) {
		return ImGuiCustomWidgetNative.BeginCollapseLayout2(title, sizeX, sizeY, options);
	}

	public static void BeginCollapseLayout(ImGuiBoolean isOpen, String title, float sizeX, float sizeY) {
		ImGuiCustomWidgetNative.BeginCollapseLayout(isOpen.data, title, sizeX, sizeY, ImGuiCustomWidgetNative.defaultOptions);
	}

	public static void BeginCollapseLayout(ImGuiBoolean isOpen, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options) {
		ImGuiCustomWidgetNative.BeginCollapseLayout(isOpen.data, title, sizeX, sizeY, options);
	}

	public static void EndCollapseFrameLayout() {
		ImGuiCustomWidgetNative.EndCollapseFrameLayout();
	}

	public static void EndCollapseLayout() {
		ImGuiCustomWidgetNative.EndCollapseLayout();
	}

	public static void BeginAlign(String id, float sizeX, float sizeY, float alignX, float alignY) {
		ImGuiCustomWidgetNative.BeginAlign(id, sizeX, sizeY, alignX, alignY);
	}

	public static void BeginAlign(String id, float sizeX, float sizeY, float alignX, float alignY, float offsetX, float offsetY) {
		ImGuiCustomWidgetNative.BeginAlign(id, sizeX, sizeY, alignX, alignY, offsetX, offsetY);
	}

	public static void EndAlign() {
		ImGuiCustomWidgetNative.EndAlign();
	}

	public static void AlignLayout(float alignX, float alignY) {
		ImGuiCustomWidgetNative.AlignLayout(alignX, alignY);
	}

	public static void AlignLayout(float alignX, float alignY, float offsetX, float offsetY) {
		ImGuiCustomWidgetNative.AlignLayout(alignX, alignY, offsetX, offsetY);
	}

	public static ImGuiLayout GetCurrentLayout() {
		ImGuiCustomWidgetNative.GetCurrentLayout(ImGuiCustomWidgetNative.tempLayout);
		return ImGuiCustomWidgetNative.tempLayout;
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
