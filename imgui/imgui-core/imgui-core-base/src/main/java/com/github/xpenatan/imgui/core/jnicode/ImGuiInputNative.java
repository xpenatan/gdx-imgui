package com.github.xpenatan.imgui.core.jnicode;

import com.github.xpenatan.imgui.core.ImGuiInputTextData;

public class ImGuiInputNative {

    /*[-C++;-NATIVE]
        #include "imgui_helper.h"

        #include <imgui.h>
        #include <cstring>
        #if defined(_MSC_VER) && _MSC_VER <= 1500 // MSVC 2008 or earlier
        #include <stddef.h>     // intptr_t
        #else
        #include <stdint.h>     // intptr_t
        #endif

        // ImGuiStyle
        jfieldID imTextInputDataSizeID;
        jfieldID imTextInputDataIsDirtyID;

    */


    /*[-C++;-NATIVE]
        ImGuiHelper::Init(env);
        jclass jImInputTextDataClass = env->FindClass("com/github/xpenatan/imgui/core/ImGuiInputTextData");
        imTextInputDataSizeID = env->GetFieldID(jImInputTextDataClass, "size", "I");
        imTextInputDataIsDirtyID = env->GetFieldID(jImInputTextDataClass, "isDirty", "Z");
    */
    public static native void init();



    // Widgets: Input with Keyboard
    // - If you want to use InputText() with a dynamic string type such as std::string or your own, see misc/cpp/imgui_stdlib.h
    // - Most of the ImGuiInputTextFlags flags are only useful for InputText() and not for InputFloatX, InputIntX, InputDouble etc.

    /*[-C++;-NATIVE]
        struct InputTextCallback_UserData {
            jobject* textInputData;
            JNIEnv* env;
            int maxChar;
            char * allowedChar;
            int allowedCharLength;
            int maxSize;
            int curSize;
        };

        static int TextEditCallbackStub(ImGuiInputTextCallbackData* data) {
            InputTextCallback_UserData* userData = (InputTextCallback_UserData*)data->UserData;

            if (data->EventFlag == ImGuiInputTextFlags_CallbackCharFilter) {
                if(userData->allowedCharLength > 0) {
                    bool found = false;
                    for(int i = 0; i < userData->allowedCharLength; i++) {
                        if(userData->allowedChar[i] == data->EventChar) {
                            found = true;
                            break;
                        }
                    }
                    return found ? 0 : 1;
                }
            }
            return 0;
        }
    */

    /*[-C++;-NATIVE]
        int size = (int)strlen(buff);
        InputTextCallback_UserData cb_user_data;
        cb_user_data.textInputData = &textInputData;
        cb_user_data.env = env;
        cb_user_data.curSize = size;
        cb_user_data.maxSize = maxSize;
        cb_user_data.maxChar = maxChar;
        cb_user_data.allowedChar = allowedChar;
        cb_user_data.allowedCharLength = allowedCharLength;

        char tempArray [maxSize];
        memset(tempArray, 0, sizeof(tempArray));
        memcpy(tempArray, buff, size);
        if(maxChar >= 0 && maxChar < maxSize)
            maxSize = maxChar;
        bool flag = ImGui::InputText(label, tempArray, maxSize, flags  | ImGuiInputTextFlags_CallbackCharFilter, &TextEditCallbackStub, &cb_user_data);
        if(flag) {
            size = (int)strlen(tempArray);
            env->SetIntField (textInputData, imTextInputDataSizeID, size);
            env->SetBooleanField (textInputData, imTextInputDataIsDirtyID, true);
            memset(buff, 0, maxSize);
            memcpy(buff, tempArray, size);
        }
        return flag;
    */
    public static native boolean InputText(String label, byte[] buff, int maxSize, int flags, ImGuiInputTextData textInputData, int maxChar, String allowedChar, int allowedCharLength);

    /*[-C++;-NATIVE]
        return ImGui::InputFloat(label, &v[0]);
    */
    public static native boolean InputFloat(String label, float[] v);

    /*[-C++;-NATIVE]
        return ImGui::InputFloat(label, &v[0], step, step_fast, format);
    */
    public static native boolean InputFloat(String label, float[] v, float step, float step_fast, String format);

    /*[-C++;-NATIVE]
        return ImGui::InputFloat(label, &v[0], step, step_fast, format, flags);
    */
    public static native boolean InputFloat(String label, float[] v, float step, float step_fast, String format, int flags);

    /*[-C++;-NATIVE]
        return ImGui::InputInt(label, &v[0]);
    */
    public static native boolean InputInt(String label, int[] v);

    /*[-C++;-NATIVE]
        return ImGui::InputInt(label, &v[0], step, step_fast);
    */
    public static native boolean InputInt(String label, int[] v, float step, float step_fast);

    /*[-C++;-NATIVE]
        return ImGui::InputInt(label, &v[0], step, step_fast, flags);
    */
    public static native boolean InputInt(String label, int[] v, float step, float step_fast, int flags);

    /*[-C++;-NATIVE]
        return ImGui::InputDouble(label, &v[0]);
    */
    public static native boolean InputDouble(String label, double[] v);

    /*[-C++;-NATIVE]
        return ImGui::InputDouble(label, &v[0], step, step_fast, format);
    */
    public static native boolean InputDouble(String label, double[] v, float step, float step_fast, String format);

    /*[-C++;-NATIVE]
        return ImGui::InputDouble(label, &v[0], step, step_fast, format, flags);
    */
    public static native boolean InputDouble(String label, double[] v, float step, float step_fast, String format, int flags);

}
