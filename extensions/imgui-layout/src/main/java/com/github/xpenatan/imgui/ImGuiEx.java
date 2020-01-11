package com.github.xpenatan.imgui;

import com.badlogic.gdx.jnigen.JniGenSharedLibraryLoader;
import com.github.xpenatan.imgui.ImGuiBoolean;
import com.github.xpenatan.imgui.ImGuiLayoutNative.ImGuiCollapseLayoutOptions;
import com.github.xpenatan.imgui.ImGuiLayoutNative.ImGuiLayout;

public class ImGuiEx {

	private static boolean IMGUIINIT = false;

	public static void init () {
		init(true);
	}

	public static void init (boolean logging) {
		if(ImGuiEx.IMGUIINIT)
			return;
		JniGenSharedLibraryLoader loader = new JniGenSharedLibraryLoader();
		loader.load("imgui-layout");
		ImGuiEx.IMGUIINIT = true;

		ImGuiLayoutNative.init();
	}

	protected ImGuiEx() {
	}

	public static void ShowLayoutDebug() {
		ImGuiLayoutNative.ShowLayoutDebug();
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

	public static boolean BeginCollapseLayoutEx(String title, float sizeX, float sizeY) {
		return ImGuiLayoutNative.BeginCollapseLayoutEx2(title, sizeX, sizeY, ImGuiLayoutNative.defaultOptions);
	}

	public static boolean BeginCollapseLayoutEx(String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options) {
		return ImGuiLayoutNative.BeginCollapseLayoutEx2(title, sizeX, sizeY, options);
	}

	public static void BeginCollapseLayoutEx(ImGuiBoolean isOpen, String title, float sizeX, float sizeY) {
		ImGuiLayoutNative.BeginCollapseLayoutEx(isOpen.data, title, sizeX, sizeY, ImGuiLayoutNative.defaultOptions);
	}

	public static void BeginCollapseLayoutEx(ImGuiBoolean isOpen, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options) {
		ImGuiLayoutNative.BeginCollapseLayoutEx(isOpen.data, title, sizeX, sizeY, options);
	}

	public static boolean BeginCollapseLayout(String title, float sizeX, float sizeY) {
		return ImGuiLayoutNative.BeginCollapseLayout2(title, sizeX, sizeY, ImGuiLayoutNative.defaultOptions);
	}

	public static boolean BeginCollapseLayout(String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options) {
		return ImGuiLayoutNative.BeginCollapseLayout2(title, sizeX, sizeY, options);
	}

	public static void BeginCollapseLayout(ImGuiBoolean isOpen, String title, float sizeX, float sizeY) {
		ImGuiLayoutNative.BeginCollapseLayout(isOpen.data, title, sizeX, sizeY, ImGuiLayoutNative.defaultOptions);
	}

	public static void BeginCollapseLayout(ImGuiBoolean isOpen, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options) {
		ImGuiLayoutNative.BeginCollapseLayout(isOpen.data, title, sizeX, sizeY, options);
	}

	public static void EndCollapseFrameLayout() {
		ImGuiLayoutNative.EndCollapseFrameLayout();
	}

	public static void EndCollapseLayout() {
		ImGuiLayoutNative.EndCollapseLayout();
	}

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

	public static ImGuiLayout GetCurrentLayout() {
		ImGuiLayoutNative.GetCurrentLayout(ImGuiLayoutNative.tempLayout);
		return ImGuiLayoutNative.tempLayout;
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
