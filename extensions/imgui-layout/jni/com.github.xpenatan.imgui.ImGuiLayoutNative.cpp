#include <com.github.xpenatan.imgui.ImGuiLayoutNative.h>

//@line:10

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
	JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_init(JNIEnv* env, jclass clazz) {


//@line:37

		jclass jLayoutOptionsClass = env->FindClass("com/github/xpenatan/imgui/ImGuiLayoutNative$ImGuiCollapseLayoutOptions");
		jclass jLayoutClass = env->FindClass("com/github/xpenatan/imgui/ImGuiLayoutNative$ImGuiLayout");
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
	

}

JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_ShowLayoutDebug(JNIEnv* env, jclass clazz) {


//@line:64

		ImGuiEx::ShowLayoutDebug();
	

}

JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_BeginLayout__Ljava_lang_String_2FF(JNIEnv* env, jclass clazz, jstring obj_id, jfloat sizeX, jfloat sizeY) {
	char* id = (char*)env->GetStringUTFChars(obj_id, 0);


//@line:68

		ImGuiEx::BeginLayout(id, sizeX, sizeY);
	
	env->ReleaseStringUTFChars(obj_id, id);

}

JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_BeginLayout__Ljava_lang_String_2FFFFFF(JNIEnv* env, jclass clazz, jstring obj_id, jfloat sizeX, jfloat sizeY, jfloat paddingLeft, jfloat paddingRight, jfloat paddingTop, jfloat paddingBottom) {
	char* id = (char*)env->GetStringUTFChars(obj_id, 0);


//@line:72

		ImGuiLayoutOptions options;
		options.paddingLeft = paddingLeft;
		options.paddingRight = paddingRight;
		options.paddingTop = paddingTop;
		options.paddingBottom = paddingBottom;
		ImGuiEx::BeginLayout(id, sizeX, sizeY);
	
	env->ReleaseStringUTFChars(obj_id, id);

}

JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_EndLayout(JNIEnv* env, jclass clazz) {


//@line:81

		ImGuiEx::EndLayout();
	

}

static inline jboolean wrapped_Java_com_github_xpenatan_imgui_ImGuiLayoutNative_BeginCollapseLayoutEx2
(JNIEnv* env, jclass clazz, jstring obj_title, jfloat sizeX, jfloat sizeY, jobject jOptions, char* title) {

//@line:85

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
	
}

JNIEXPORT jboolean JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_BeginCollapseLayoutEx2(JNIEnv* env, jclass clazz, jstring obj_title, jfloat sizeX, jfloat sizeY, jobject jOptions) {
	char* title = (char*)env->GetStringUTFChars(obj_title, 0);

	jboolean JNI_returnValue = wrapped_Java_com_github_xpenatan_imgui_ImGuiLayoutNative_BeginCollapseLayoutEx2(env, clazz, obj_title, sizeX, sizeY, jOptions, title);

	env->ReleaseStringUTFChars(obj_title, title);

	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_BeginCollapseLayoutEx(JNIEnv* env, jclass clazz, jbooleanArray obj_isOpen, jstring obj_title, jfloat sizeX, jfloat sizeY, jobject jOptions) {
	char* title = (char*)env->GetStringUTFChars(obj_title, 0);
	bool* isOpen = (bool*)env->GetPrimitiveArrayCritical(obj_isOpen, 0);


//@line:101

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
	
	env->ReleasePrimitiveArrayCritical(obj_isOpen, isOpen, 0);
	env->ReleaseStringUTFChars(obj_title, title);

}

static inline jboolean wrapped_Java_com_github_xpenatan_imgui_ImGuiLayoutNative_BeginCollapseLayout2
(JNIEnv* env, jclass clazz, jstring obj_title, jfloat sizeX, jfloat sizeY, jobject jOptions, char* title) {

//@line:117

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
	
}

JNIEXPORT jboolean JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_BeginCollapseLayout2(JNIEnv* env, jclass clazz, jstring obj_title, jfloat sizeX, jfloat sizeY, jobject jOptions) {
	char* title = (char*)env->GetStringUTFChars(obj_title, 0);

	jboolean JNI_returnValue = wrapped_Java_com_github_xpenatan_imgui_ImGuiLayoutNative_BeginCollapseLayout2(env, clazz, obj_title, sizeX, sizeY, jOptions, title);

	env->ReleaseStringUTFChars(obj_title, title);

	return JNI_returnValue;
}

JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_BeginCollapseLayout(JNIEnv* env, jclass clazz, jbooleanArray obj_isOpen, jstring obj_title, jfloat sizeX, jfloat sizeY, jobject jOptions) {
	char* title = (char*)env->GetStringUTFChars(obj_title, 0);
	bool* isOpen = (bool*)env->GetPrimitiveArrayCritical(obj_isOpen, 0);


//@line:133

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
	
	env->ReleasePrimitiveArrayCritical(obj_isOpen, isOpen, 0);
	env->ReleaseStringUTFChars(obj_title, title);

}

JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_EndCollapseFrameLayout(JNIEnv* env, jclass clazz) {


//@line:149

		ImGuiEx::EndCollapseFrameLayout();
	

}

JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_EndCollapseLayout(JNIEnv* env, jclass clazz) {


//@line:153

		ImGuiEx::EndCollapseLayout();
	

}

JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_BeginAlign__Ljava_lang_String_2FFFF(JNIEnv* env, jclass clazz, jstring obj_id, jfloat sizeX, jfloat sizeY, jfloat alignX, jfloat alignY) {
	char* id = (char*)env->GetStringUTFChars(obj_id, 0);


//@line:157

		ImGuiEx::BeginAlign(id, sizeX, sizeY, alignX, alignY);
	
	env->ReleaseStringUTFChars(obj_id, id);

}

JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_BeginAlign__Ljava_lang_String_2FFFFFF(JNIEnv* env, jclass clazz, jstring obj_id, jfloat sizeX, jfloat sizeY, jfloat alignX, jfloat alignY, jfloat offsetX, jfloat offsetY) {
	char* id = (char*)env->GetStringUTFChars(obj_id, 0);


//@line:161

		ImGuiEx::BeginAlign(id, sizeX, sizeY, alignX, alignY, offsetX, offsetY);
	
	env->ReleaseStringUTFChars(obj_id, id);

}

JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_EndAlign(JNIEnv* env, jclass clazz) {


//@line:165

		ImGuiEx::EndAlign();
	

}

JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_AlignLayout__FF(JNIEnv* env, jclass clazz, jfloat alignX, jfloat alignY) {


//@line:169

		ImGuiEx::AlignLayout(alignX, alignY);
	

}

JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_AlignLayout__FFFF(JNIEnv* env, jclass clazz, jfloat alignX, jfloat alignY, jfloat offsetX, jfloat offsetY) {


//@line:173

		ImGuiEx::AlignLayout(alignX, alignY, offsetX, offsetY);
	

}

JNIEXPORT void JNICALL Java_com_github_xpenatan_imgui_ImGuiLayoutNative_GetCurrentLayout(JNIEnv* env, jclass clazz, jobject jLayout) {


//@line:177

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
	

}

