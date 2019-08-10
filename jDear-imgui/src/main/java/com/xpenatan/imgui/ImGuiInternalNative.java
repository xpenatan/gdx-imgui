package com.xpenatan.imgui;

public class ImGuiInternalNative {


	/*JNI
		#include <src/imgui.h>
		#include <src/imgui_internal.h>
	*/

	static native void PushMultiItemsWidths(int components, float w_full) /*-{ }-*/; /*
		ImGui::PushMultiItemsWidths(components, w_full);
	*/

}
