package com.github.xpenatan.imgui.jnicode;

public class ImGuiExtNative {

	/*JNI
		#include <src/imgui_ext.h>
	*/

	public static native float GetTableContentHeight() /*-{ }-*/; /*
		return ImGuiExt::GetTableContentHeight();
	*/

	public static native void CalculateTableRowHeight() /*-{ }-*/; /*
		ImGuiExt::CalculateTableRowHeight();
	*/

	public static native float GetTableRowHeight() /*-{ }-*/; /*
		return ImGuiExt::GetTableRowHeight();
	*/
}