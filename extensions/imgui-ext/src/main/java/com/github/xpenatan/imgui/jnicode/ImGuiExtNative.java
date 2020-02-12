package com.github.xpenatan.imgui.jnicode;

import com.github.xpenatan.imgui.custom.EditTextFloatData;

public class ImGuiExtNative {

	/*JNI
		#include <src/imgui_ext.h>

		jfieldID leftLabelID;
		jfieldID leftLabelColorID;
		jfieldID leftLabelDragColorID;
		jfieldID tooltipID;
		jfieldID tooltipDelayID;
		jfieldID v_speedID;
		jfieldID powerID;
		jfieldID formatID;

		jfieldID v_minID;
		jfieldID v_maxID;
	*/

	public static native void init() /*-{ }-*/; /*
		jclass jEditTextDataClass = env->FindClass("com/github/xpenatan/imgui/custom/EditTextData");
		jclass jEditTextFloatDataClass = env->FindClass("com/github/xpenatan/imgui/custom/EditTextFloatData");

		leftLabelID = env->GetFieldID(jEditTextDataClass, "leftLabel", "Ljava/lang/String;");
		leftLabelColorID = env->GetFieldID(jEditTextDataClass, "leftLabelColor", "I");
		leftLabelDragColorID = env->GetFieldID(jEditTextDataClass, "leftLabelDragColor", "I");
		tooltipID = env->GetFieldID(jEditTextDataClass, "tooltip", "Ljava/lang/String;");
		tooltipDelayID = env->GetFieldID(jEditTextDataClass, "tooltipDelay", "F");
		v_speedID = env->GetFieldID(jEditTextDataClass, "v_speed", "F");
		powerID = env->GetFieldID(jEditTextDataClass, "power", "F");
		formatID = env->GetFieldID(jEditTextDataClass, "format", "Ljava/lang/String;");

		v_minID = env->GetFieldID(jEditTextFloatDataClass, "v_min", "F");
		v_maxID = env->GetFieldID(jEditTextFloatDataClass, "v_max", "F");
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
		void editTextF(JNIEnv* env, EditTextFloatData & data, jobject jData) {
			jstring jleftLabel = (jstring)env->GetObjectField(jData, leftLabelID);
			if(jleftLabel != NULL) {
				const char* leftLabel = env->GetStringUTFChars(jleftLabel, NULL);
				data.leftLabel = (char*)leftLabel;
			}

			jstring jtooltip = (jstring)env->GetObjectField(jData, tooltipID);
			if(jtooltip != NULL) {
				const char* tooltip = env->GetStringUTFChars(jtooltip, NULL);
				data.tooltip = (char*)tooltip;
			}

			int leftLabelColor = env->GetIntField(jData, leftLabelColorID);
			if(leftLabelColor != 0) {
				data.leftLabelColor = leftLabelColor;
			}

			int leftLabelDragColor = env->GetIntField(jData, leftLabelDragColorID);
			if(leftLabelDragColor != 0) {
				data.leftLabelDragColor = leftLabelDragColor;
			}

			float tooltipDelay = env->GetFloatField(jData, tooltipDelayID);
			if(tooltipDelay >=0) {
				data.tooltipDelay = tooltipDelay;
			}

			float v_speed = env->GetFloatField(jData, v_speedID);
			if(v_speed != -1) {
				data.v_speed = v_speed;
			}

			jstring jformat = (jstring)env->GetObjectField(jData, formatID);
			if(jformat != NULL) {
				const char* format = env->GetStringUTFChars(jformat, NULL);
				data.format = (char*)format;
			}

			float v_min = env->GetFloatField(jData, v_minID);
			if(v_min != 0) {
				data.v_min = v_min;
			}

			float v_max = env->GetFloatField(jData, v_maxID);
			if(v_max != 0) {
				data.v_max = v_max;
			}
		}
	*/

	public static native void EditTextF3(String id, float [] value01, float [] value02, float [] value03, EditTextFloatData jData01, EditTextFloatData jData02, EditTextFloatData jData03) /*-{ }-*/; /*
		EditTextFloatData data01;
		EditTextFloatData data02;
		EditTextFloatData data03;
		editTextF(env, data01, jData01);
		editTextF(env, data02, jData02);
		editTextF(env, data03, jData03);
		ImGuiExt::EditTextF3(id, &value01[0], &value02[0], &value03[0], data01, data02, data03);
	*/
}