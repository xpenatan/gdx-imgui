package com.github.xpenatan.imgui.jnicode;

public class ImGuiExNative {

	/*JNI
		#include <src/imgui_ex.h>
	*/

	public static native float GetTableContentHeight() /*-{ }-*/; /*
		return ImGuiEx::GetTableContentHeight();
	*/

	public static native void CalculateTableRowHeight() /*-{ }-*/; /*
		ImGuiEx::CalculateTableRowHeight();
	*/

	public static native float GetTableRowHeight() /*-{ }-*/; /*
		return ImGuiEx::GetTableRowHeight();
	*/
}