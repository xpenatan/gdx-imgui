package com.github.xpenatan.imgui;

import com.github.xpenatan.imgui.enums.ImDrawCornerFlags;

public class ImGuiCustomWidgetNative {

	public static ImGuiCollapseLayoutOptions defaultOptions = new ImGuiCollapseLayoutOptions();
	static ImGuiLayout tempLayout = new ImGuiLayout();

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

		jfieldID positionXID;
		jfieldID positionYID;
		jfieldID sizeXID;
		jfieldID sizeYID;
		jfieldID contentSizeXID;
		jfieldID contentSizeYID;
		jfieldID layoutPaddingLeftID;
		jfieldID layoutPaddingRightID;
		jfieldID layoutPaddingTopID;
		jfieldID layoutPaddingBottomID;
	*/

	static native void init() /*-{ }-*/; /*
		jclass jLayoutOptionsClass = env->FindClass("com/github/xpenatan/imgui/ImGuiCustomWidgetNative$ImGuiCollapseLayoutOptions");
		jclass jLayoutClass = env->FindClass("com/github/xpenatan/imgui/ImGuiCustomWidgetNative$ImGuiLayout");
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

		positionXID = env->GetFieldID(jLayoutClass, "positionX", "F");
		positionYID = env->GetFieldID(jLayoutClass, "positionY", "F");
		sizeXID = env->GetFieldID(jLayoutClass, "sizeX", "F");
		sizeYID = env->GetFieldID(jLayoutClass, "sizeY", "F");
		contentSizeXID = env->GetFieldID(jLayoutClass, "contentSizeX", "F");
		contentSizeYID = env->GetFieldID(jLayoutClass, "contentSizeY", "F");
		layoutPaddingLeftID = env->GetFieldID(jLayoutClass, "paddingLeft", "F");
		layoutPaddingRightID = env->GetFieldID(jLayoutClass, "paddingRight", "F");
		layoutPaddingTopID = env->GetFieldID(jLayoutClass, "paddingTop", "F");
		layoutPaddingBottomID = env->GetFieldID(jLayoutClass, "paddingBottom", "F");
	*/

	static {
		init();
	}

	static native void ShowLayoutDebug() /*-{ }-*/; /*
		ImGuiEx::ShowLayoutDebug();
	*/

	static native void BeginLayout(String id, float sizeX, float sizeY); /*-{ }-*/; /*
		ImGuiEx::BeginLayout(id, sizeX, sizeY);
	*/

	static native void BeginLayout(String id, float sizeX, float sizeY, float paddingLeft, float paddingRight, float paddingTop, float paddingBottom); /*-{ }-*/; /*
		ImGuiLayoutOptions options;
		options.paddingLeft = paddingLeft;
		options.paddingRight = paddingRight;
		options.paddingTop = paddingTop;
		options.paddingBottom = paddingBottom;
		ImGuiEx::BeginLayout(id, sizeX, sizeY);
	*/

	static native void EndLayout(); /*-{ }-*/; /*
		ImGuiEx::EndLayout();
	*/

	static native boolean BeginCollapseLayoutEx2(String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions jOptions); /*-{ }-*/; /*
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
		return ImGuiEx::BeginCollapseLayoutEx(title, sizeX, sizeY, options);
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
		ImGuiEx::BeginCollapseLayoutEx(&isOpen[0], title, sizeX, sizeY, options);
	*/

	static native boolean BeginCollapseLayout2(String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions jOptions); /*-{ }-*/; /*
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
		return ImGuiEx::BeginCollapseLayout(title, sizeX, sizeY, options);
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
		ImGuiEx::BeginCollapseLayout(&isOpen[0], title, sizeX, sizeY, options);
	*/

	static native void EndCollapseFrameLayout(); /*-{ }-*/; /*
		ImGuiEx::EndCollapseFrameLayout();
	*/

	static native void EndCollapseLayout(); /*-{ }-*/; /*
		ImGuiEx::EndCollapseLayout();
	*/

	static native void BeginAlign(String id, float sizeX, float sizeY, float alignX, float alignY) /*-{ }-*/; /*
		ImGuiEx::BeginAlign(id, sizeX, sizeY, alignX, alignY);
	*/

	static native void BeginAlign(String id, float sizeX, float sizeY, float alignX, float alignY, float offsetX, float offsetY) /*-{ }-*/; /*
		ImGuiEx::BeginAlign(id, sizeX, sizeY, alignX, alignY, offsetX, offsetY);
	*/

	static native void EndAlign() /*-{ }-*/; /*
		ImGuiEx::EndAlign();
	*/

	static native void AlignLayout(float alignX, float alignY) /*-{ }-*/; /*
		ImGuiEx::AlignLayout(alignX, alignY);
	*/

	static native void AlignLayout(float alignX, float alignY, float offsetX, float offsetY) /*-{ }-*/; /*
		ImGuiEx::AlignLayout(alignX, alignY, offsetX, offsetY);
	*/

	static native void GetCurrentLayout(ImGuiLayout jLayout); /*-{ }-*/; /*
		ImGuiLayout* curLayout = ImGuiEx::GetCurrentLayout();
		env->SetFloatField (jLayout, positionXID, curLayout->position.x);
		env->SetFloatField (jLayout, positionYID, curLayout->position.y);
		env->SetFloatField (jLayout, sizeXID, curLayout->size.x);
		env->SetFloatField (jLayout, sizeYID, curLayout->size.y);
		env->SetFloatField (jLayout, contentSizeXID, curLayout->contentSize.x);
		env->SetFloatField (jLayout, contentSizeYID, curLayout->contentSize.y);
		env->SetFloatField (jLayout, layoutPaddingLeftID, curLayout->paddingLeft);
		env->SetFloatField (jLayout, layoutPaddingRightID, curLayout->paddingRight);
		env->SetFloatField (jLayout, layoutPaddingTopID, curLayout->paddingTop);
		env->SetFloatField (jLayout, layoutPaddingBottomID, curLayout->paddingBottom);
	*/

	public static class ImGuiCollapseLayoutOptions {
		public float paddingLeft = 2;
		public float paddingRight = 2;
		public float paddingTop = 2;
		public float paddingBottom = 2;
		public int arrowColor = ImGuiEx.colorToIntBits(0xFF, 0xFF, 0xFF, 0xFF);
		public int arrowBackgroundHoveredColor = ImGuiEx.colorToIntBits(0x77, 0x77, 0x77, 0xFF);
		public int arrowBackgroundClickedColor = ImGuiEx.colorToIntBits(0x55, 0x55, 0x55, 0xFF);
		public int frameColor = ImGuiEx.colorToIntBits(0x24, 0x24, 0x24, 0xFF);
		public int borderColor = ImGuiEx.colorToIntBits(0x40, 0x40, 0x49, 0xFF);
		public int borderRound = 4;
		public int roundingCorners = ImDrawCornerFlags.TopLeft.or(ImDrawCornerFlags.TopRight).getValue();
	}

	/**
	 * Read only
	 */
	public static class ImGuiLayout {
		public float positionX;
		public float positionY;
		public float sizeX;
		public float sizeY;
		public float contentSizeX;
		public float contentSizeY;
		public float paddingLeft;
		public float paddingRight;
		public float paddingTop;
		public float paddingBottom;
	}
}
