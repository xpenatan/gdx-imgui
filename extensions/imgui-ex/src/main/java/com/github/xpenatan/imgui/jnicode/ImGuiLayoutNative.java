package com.github.xpenatan.imgui.jnicode;

import com.github.xpenatan.imgui.ImGuiCollapseLayoutOptions;
import com.github.xpenatan.imgui.ImGuiLayout;

public class ImGuiLayoutNative {

	public static ImGuiCollapseLayoutOptions defaultOptions = new ImGuiCollapseLayoutOptions();

	/*JNI
		#include <src/imgui_layout.h>

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

	public static native void init() /*-{ }-*/; /*
		jclass jLayoutOptionsClass = env->FindClass("com/github/xpenatan/imgui/ImGuiCollapseLayoutOptions");
		jclass jLayoutClass = env->FindClass("com/github/xpenatan/imgui/ImGuiLayout");
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

	public static native void ShowLayoutDebug() /*-{ }-*/; /*
		ImGuiEx::ShowLayoutDebug();
	*/

	public static native void BeginLayout(String id, float sizeX, float sizeY); /*-{ }-*/; /*
		ImGuiEx::BeginLayout(id, sizeX, sizeY);
	*/

	public static native void BeginLayout(String id, float sizeX, float sizeY, float paddingLeft, float paddingRight, float paddingTop, float paddingBottom); /*-{ }-*/; /*
		ImGuiLayoutOptions options;
		options.paddingLeft = paddingLeft;
		options.paddingRight = paddingRight;
		options.paddingTop = paddingTop;
		options.paddingBottom = paddingBottom;
		ImGuiEx::BeginLayout(id, sizeX, sizeY);
	*/

	public static native void EndLayout(); /*-{ }-*/; /*
		ImGuiEx::EndLayout();
	*/

	public static native boolean BeginCollapseLayoutEx2(String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions jOptions); /*-{ }-*/; /*
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
		return ImGuiEx::BeginCollapseLayoutEx(title, sizeX, sizeY);
	*/

	public static native void BeginCollapseLayoutEx(boolean [] isOpen, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions jOptions); /*-{ }-*/; /*
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

	public static native boolean BeginCollapseLayout2(String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions jOptions); /*-{ }-*/; /*
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

	public static native void BeginCollapseLayout(boolean [] isOpen, String title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions jOptions); /*-{ }-*/; /*
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

	public static native void EndCollapseFrameLayout(); /*-{ }-*/; /*
		ImGuiEx::EndCollapseFrameLayout();
	*/

	public static native void EndCollapseLayout(); /*-{ }-*/; /*
		ImGuiEx::EndCollapseLayout();
	*/

	public static native void BeginAlign(String id, float sizeX, float sizeY, float alignX, float alignY) /*-{ }-*/; /*
		ImGuiEx::BeginAlign(id, sizeX, sizeY, alignX, alignY);
	*/

	public static native void BeginAlign(String id, float sizeX, float sizeY, float alignX, float alignY, float offsetX, float offsetY) /*-{ }-*/; /*
		ImGuiEx::BeginAlign(id, sizeX, sizeY, alignX, alignY, offsetX, offsetY);
	*/

	public static native void EndAlign() /*-{ }-*/; /*
		ImGuiEx::EndAlign();
	*/

	public static native void AlignLayout(float alignX, float alignY) /*-{ }-*/; /*
		ImGuiEx::AlignLayout(alignX, alignY);
	*/

	public static native void AlignLayout(float alignX, float alignY, float offsetX, float offsetY) /*-{ }-*/; /*
		ImGuiEx::AlignLayout(alignX, alignY, offsetX, offsetY);
	*/

	public static native void GetCurrentLayout(ImGuiLayout jLayout); /*-{ }-*/; /*
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
}
