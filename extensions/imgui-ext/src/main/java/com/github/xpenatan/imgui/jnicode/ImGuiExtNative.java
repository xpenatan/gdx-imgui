package com.github.xpenatan.imgui.jnicode;

import com.github.xpenatan.imgui.custom.EditTextData;

public class ImGuiExtNative {

	/*JNI
		#include <src/imgui_ext.h>

		jfieldID leftLabelID;
		jfieldID leftLabelColorID;
		jfieldID tooltipID;
		jfieldID tooltipDelayID;
	*/

	public static native void init() /*-{ }-*/; /*
		jclass jEditTextDataClass = env->FindClass("com/github/xpenatan/imgui/custom/EditTextData");
		leftLabelID = env->GetFieldID(jEditTextDataClass, "leftLabel", "Ljava/lang/String;");
		leftLabelColorID = env->GetFieldID(jEditTextDataClass, "leftLabelColor", "I");
		tooltipID = env->GetFieldID(jEditTextDataClass, "tooltip", "Ljava/lang/String;");
		tooltipDelayID = env->GetFieldID(jEditTextDataClass, "tooltipDelay", "F");
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

	/*JNI
		void edittext(JNIEnv* env, EditTextData & data, jobject jData) {
			jstring jleftLabel = (jstring)env->GetObjectField(jData, leftLabelID);
			if(jleftLabel != NULL) {
				const char* leftLabel = env->GetStringUTFChars(jleftLabel, NULL);
				data.leftLabel = leftLabel;
			}

			jstring jtooltip = (jstring)env->GetObjectField(jData, tooltipID);
			if(jtooltip != NULL) {
				const char* tooltip = env->GetStringUTFChars(jtooltip, NULL);
				data.tooltip = tooltip;
			}

			int leftLabelColor = env->GetIntField(jData, leftLabelColorID);
			if(leftLabelColor != 0) {
				data.leftLabelColor = leftLabelColor;
			}

			float tooltipDelay = env->GetFloatField(jData, tooltipDelayID);
			if(tooltipDelay >=0) {
				data.tooltipDelay = tooltipDelay;
			}
		}
	*/

	public static native void EditTextF3(String id, float [] value01, float [] value02, float [] value03, EditTextData jData01, EditTextData jData02, EditTextData jData03) /*-{ }-*/; /*
		EditTextData data01;
		EditTextData data02;
		EditTextData data03;
		edittext(env, data01, jData01);
		edittext(env, data02, jData02);
		edittext(env, data03, jData03);
		ImGuiExt::EditTextF3(id, &value01[0], &value02[0], &value03[0], data01, data02, data03);
	*/
}