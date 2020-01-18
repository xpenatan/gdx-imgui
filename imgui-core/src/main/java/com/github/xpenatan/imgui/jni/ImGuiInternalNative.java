package com.github.xpenatan.imgui.jni;

public class ImGuiInternalNative {


	/*JNI
		#include <imgui.h>
		#include <imgui_internal.h>
	*/

	public static native void PushMultiItemsWidths(int components, float w_full) /*-{ }-*/; /*
		ImGui::PushMultiItemsWidths(components, w_full);
	*/

	public static native boolean ItemAdd(float x1, float y1, float x2, float y2, String id) /*-{ }-*/; /*
		ImGuiID imGuiID = ImGui::GetID(id);
		return ImGui::ItemAdd(ImRect(x1, y1, x2, y2), imGuiID);
	*/

	public static native void ItemSize(float x1, float y1, float x2, float y2, float text_offset_y) /*-{ }-*/; /*
		ImGui::ItemSize(ImRect(x1, y1, x2, y2), text_offset_y);
	*/
}
