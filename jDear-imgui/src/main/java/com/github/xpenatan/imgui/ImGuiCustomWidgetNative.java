package com.github.xpenatan.imgui;

import com.github.xpenatan.imgui.enums.ImDrawCornerFlags;

public class ImGuiCustomWidgetNative {

	/*JNI
		#include <src/imgui_layout_widget.h>

		jfieldID paddingLeftID;
		jfieldID paddingRightID;
		jfieldID paddingTopID;
		jfieldID paddingBottomID;
		jfieldID arrowColorID;
		jfieldID arrowBackgroundHoveredColorID;
		jfieldID arrowBackgroundClickedColorID;
		jfieldID frameColorID;
		jfieldID borderColorID;
		jfieldID borderRoundID;
		jfieldID roundingCornersID;
	*/

	static native void init() /*-{ }-*/; /*
		jclass jLayoutOptionsClass = env->FindClass("com/github/xpenatan/imgui/ImGuiCustomWidgetNative$ImGuiCollapseLayoutOptions");
		paddingLeftID = env->GetFieldID(jLayoutOptionsClass, "paddingLeft", "F");
		paddingRightID = env->GetFieldID(jLayoutOptionsClass, "paddingRight", "F");
		paddingTopID = env->GetFieldID(jLayoutOptionsClass, "paddingTop", "F");
		paddingBottomID = env->GetFieldID(jLayoutOptionsClass, "paddingBottom", "F");
		arrowColorID = env->GetFieldID(jLayoutOptionsClass, "arrowColor", "I");
		arrowBackgroundHoveredColorID = env->GetFieldID(jLayoutOptionsClass, "arrowBackgroundHoveredColor", "I");
		arrowBackgroundClickedColorID = env->GetFieldID(jLayoutOptionsClass, "arrowBackgroundClickedColor", "I");
		frameColorID = env->GetFieldID(jLayoutOptionsClass, "frameColor", "I");
		borderColorID = env->GetFieldID(jLayoutOptionsClass, "borderColor", "I");
		borderRoundID = env->GetFieldID(jLayoutOptionsClass, "borderRound", "I");
		roundingCornersID = env->GetFieldID(jLayoutOptionsClass, "roundingCorners", "I");
	*/

	static {
		init();
	}

	static native void ShowLayoutDebug() /*-{ }-*/; /*
		ImGui::ShowLayoutDebug();
	*/

	static native void BeginLayout(String id, float sizeX, float sizeY); /*-{ }-*/; /*
		ImGui::BeginLayout(id, sizeX, sizeY);
	*/

	static native void BeginLayout(String id, float sizeX, float sizeY, float paddingLeft, float paddingRight, float paddingTop, float paddingBottom); /*-{ }-*/; /*
		ImGui::BeginLayout(id, sizeX, sizeY, paddingLeft, paddingRight, paddingTop, paddingBottom);
	*/

	static native void EndLayout(); /*-{ }-*/; /*
		ImGui::EndLayout();
	*/

	static native void BeginCollapseLayoutEx(boolean [] isOpen, String title, float sizeX, float sizeY); /*-{ }-*/; /*
		ImGui::BeginCollapseLayoutEx(&isOpen[0], title, sizeX, sizeY);
	*/

	static native void BeginCollapseLayoutEx(boolean [] isOpen, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions jOptions); /*-{ }-*/; /*
		ImGuiCollapseLayoutOptions options;
		options.paddingLeft = env->GetFloatField (jOptions, paddingLeftID);
		options.paddingRight = env->GetFloatField (jOptions, paddingRightID);
		options.paddingTop = env->GetFloatField (jOptions, paddingTopID);
		options.paddingBottom = env->GetFloatField (jOptions, paddingBottomID);
		options.arrowColor = env->GetIntField (jOptions, arrowColorID);
		options.arrowBackgroundHoveredColor = env->GetIntField (jOptions, arrowBackgroundHoveredColorID);
		options.arrowBackgroundClickedColor = env->GetIntField (jOptions, arrowBackgroundClickedColorID);
		options.frameColor = env->GetIntField (jOptions, frameColorID);
		options.borderColor = env->GetIntField (jOptions, borderColorID);
		options.borderRound = env->GetIntField (jOptions, borderRoundID);
		options.roundingCorners = env->GetIntField (jOptions, roundingCornersID);
		ImGui::BeginCollapseLayoutEx(&isOpen[0], title, sizeX, sizeY, options);
	*/

	static native void BeginCollapseLayout(boolean [] isOpen, String title, float sizeX, float sizeY); /*-{ }-*/; /*
		ImGui::BeginCollapseLayout(&isOpen[0], title, sizeX, sizeY);
	*/

	static native void BeginCollapseLayout(boolean [] isOpen, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions jOptions); /*-{ }-*/; /*
		ImGuiCollapseLayoutOptions options;
		options.paddingLeft = env->GetFloatField (jOptions, paddingLeftID);
		options.paddingRight = env->GetFloatField (jOptions, paddingRightID);
		options.paddingTop = env->GetFloatField (jOptions, paddingTopID);
		options.paddingBottom = env->GetFloatField (jOptions, paddingBottomID);
		options.arrowColor = env->GetIntField (jOptions, arrowColorID);
		options.arrowBackgroundHoveredColor = env->GetIntField (jOptions, arrowBackgroundHoveredColorID);
		options.arrowBackgroundClickedColor = env->GetIntField (jOptions, arrowBackgroundClickedColorID);
		options.frameColor = env->GetIntField (jOptions, frameColorID);
		options.borderColor = env->GetIntField (jOptions, borderColorID);
		options.borderRound = env->GetIntField (jOptions, borderRoundID);
		options.roundingCorners = env->GetIntField (jOptions, roundingCornersID);
		ImGui::BeginCollapseLayout(&isOpen[0], title, sizeX, sizeY, options);
	 */

	static native void EndCollapseFrameLayout(); /*-{ }-*/; /*
		ImGui::EndCollapseFrameLayout();
	*/

	static native void EndCollapseLayout(); /*-{ }-*/; /*
		ImGui::EndCollapseLayout();
	*/

	static native void ShowAlignDebug() /*-{ }-*/; /*
		ImGui::ShowAlignDebug();
	*/

	static native void BeginAlign(String id, float sizeX, float sizeY) /*-{ }-*/; /*
		ImGui::BeginAlign(id, sizeX, sizeY);
	*/

	static native void BeginAlign(String id, float sizeX, float sizeY, float alignX, float alignY) /*-{ }-*/; /*
		ImGui::BeginAlign(id, sizeX, sizeY, alignX, alignY);
	*/

	static native void BeginAlign(String id, float sizeX, float sizeY, float alignX, float alignY, float contentAlignX, float contentAlignY) /*-{ }-*/; /*
		ImGui::BeginAlign(id, sizeX, sizeY, alignX, alignY, contentAlignX, contentAlignY);
	*/

	static native void BeginAlign(String id, float sizeX, float sizeY, float alignX, float alignY, float contentAlignX, float contentAlignY, float paddingX, float paddingY) /*-{ }-*/; /*
		ImGui::BeginAlign(id, sizeX, sizeY, alignX, alignY, contentAlignX, contentAlignY, paddingX, paddingY);
	*/

	static native void EndAlign() /*-{ }-*/; /*
		ImGui::EndAlign();
	*/

	public static class ImGuiCollapseLayoutOptions {
		public float paddingLeft = 2;
		public float paddingRight = 2;
		public float paddingTop = 2;
		public float paddingBottom = 2;
		public int arrowColor = ImGui.colorToIntBits(0xFF, 0xFF, 0xFF, 0xFF);
		public int arrowBackgroundHoveredColor = ImGui.colorToIntBits(0x77, 0x77, 0x77, 0xFF);
		public int arrowBackgroundClickedColor = ImGui.colorToIntBits(0x55, 0x55, 0x55, 0xFF);
		public int frameColor = ImGui.colorToIntBits(0x24, 0x24, 0x24, 0xFF);
		public int borderColor = ImGui.colorToIntBits(0x40, 0x40, 0x49, 0xFF);
		public int borderRound = 4;
		public int roundingCorners = ImDrawCornerFlags.TopLeft.or(ImDrawCornerFlags.TopRight).getValue();
	}
}
