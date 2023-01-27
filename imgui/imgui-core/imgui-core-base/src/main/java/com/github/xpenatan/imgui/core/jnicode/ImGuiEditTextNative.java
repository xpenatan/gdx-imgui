package com.github.xpenatan.imgui.core.jnicode;

import com.github.xpenatan.imgui.core.ImGuiInputTextData;

public class ImGuiEditTextNative {

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

    // Widgets: Drags
    // - CTRL+Click on any drag box to turn them into an input box. Manually input values aren't clamped and can go off-bounds.
    // - For all the Float2/Float3/Float4/Int2/Int3/Int4 versions of every functions, note that a 'float v[X]' function argument is the same as 'float* v', the array syntax is just a way to document the number of elements that are expected to be accessible. You can pass address of your first element out of a contiguous set, e.g. &myvector.x
    // - Adjust format string to decorate the value with a prefix, a suffix, or adapt the editing and display precision e.g. "%.3f" -> 1.234; "%5.2f secs" -> 01.23 secs; "Biscuit: %.0f" -> Biscuit: 1; etc.
    // - Speed are per-pixel of mouse movement (v_speed=0.2f: mouse needs to move by 5 pixels to increase value by 1). For gamepad/keyboard navigation, minimum speed is Max(v_speed, minimum_step_at_given_precision).

    /*[-C++;-NATIVE]
        return ImGui::DragFloat(label, &v[0]);
    */
    public static native boolean DragFloat(String label, float[] v);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat(label, &v[0], v_speed);
    */
    public static native boolean DragFloat(String label, float[] v, float v_speed);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat(label, &v[0], v_speed, v_min, v_max);
    */
    public static native boolean DragFloat(String label, float[] v, float v_speed, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat(label, &v[0], v_speed, v_min, v_max, format);
    */
    public static native boolean DragFloat(String label, float[] v, float v_speed, float v_min, float v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat(label, &v[0], v_speed, v_min, v_max, format, power);
    */
    public static native boolean DragFloat(String label, float[] v, float v_speed, float v_min, float v_max, String format, float power);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat2(label, v);
    */
    public static native boolean DragFloat2(String label, float[] v);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat2(label, &v[0], v_speed);
    */
    public static native boolean DragFloat2(String label, float[] v, float v_speed);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat2(label, &v[0], v_speed, v_min, v_max);
    */
    public static native boolean DragFloat2(String label, float[] v, float v_speed, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat2(label, &v[0], v_speed, v_min, v_max, format);
    */
    public static native boolean DragFloat2(String label, float[] v, float v_speed, float v_min, float v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat2(label, v, v_speed, v_min, v_max, format, power);
    */
    public static native boolean DragFloat2(String label, float[] v, float v_speed, float v_min, float v_max, String format, float power);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat3(label, v);
    */
    public static native boolean DragFloat3(String label, float[] v);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat3(label, v, v_speed);
    */
    public static native boolean DragFloat3(String label, float[] v, float v_speed);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat3(label, v, v_speed, v_min, v_max);
    */
    public static native boolean DragFloat3(String label, float[] v, float v_speed, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat3(label, v, v_speed, v_min, v_max, format);
    */
    public static native boolean DragFloat3(String label, float[] v, float v_speed, float v_min, float v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat3(label, v, v_speed, v_min, v_max, format, power);
    */
    public static native boolean DragFloat3(String label, float[] v, float v_speed, float v_min, float v_max, String format, float power);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat4(label, v);
    */
    public static native boolean DragFloat4(String label, float[] v);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat4(label, v, v_speed);
    */
    public static native boolean DragFloat4(String label, float[] v, float v_speed);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat4(label, v, v_speed, v_min, v_max);
    */
    public static native boolean DragFloat4(String label, float[] v, float v_speed, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat4(label, v, v_speed, v_min, v_max, format);
    */
    public static native boolean DragFloat4(String label, float[] v, float v_speed, float v_min, float v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::DragFloat4(label, v, v_speed, v_min, v_max, format, power);
    */
    public static native boolean DragFloat4(String label, float[] v, float v_speed, float v_min, float v_max, String format, float power);

    /*[-C++;-NATIVE]
        return ImGui::DragFloatRange2(label, &v_current_min[0], &v_current_max[0]);
    */
    public static native boolean DragFloatRange2(String label, float[] v_current_min, float[] v_current_max);

    /*[-C++;-NATIVE]
        return ImGui::DragFloatRange2(label, &v_current_min[0], &v_current_max[0], v_speed, v_min, v_max, format, format_max, power);
    */
    public static native boolean DragFloatRange2(String label, float[] v_current_min, float[] v_current_max, float v_speed, float v_min, float v_max, String format, String format_max, float power);

    /*[-C++;-NATIVE]
        return ImGui::DragInt(label, &v[0]);
    */
    public static native boolean DragInt(String label, int[] v);

    /*[-C++;-NATIVE]
        return ImGui::DragInt(label, &v[0], v_speed);
    */
    public static native boolean DragInt(String label, int[] v, float v_speed);

    /*[-C++;-NATIVE]
        return ImGui::DragInt(label, &v[0], v_speed, v_min, v_max);
    */
    public static native boolean DragInt(String label, int[] v, float v_speed, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::DragInt(label, &v[0], v_speed, v_min, v_max, format);
    */
    public static native boolean DragInt(String label, int[] v, float v_speed, float v_min, float v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::DragInt2(label, v);
    */
    public static native boolean DragInt2(String label, int[] v);

    /*[-C++;-NATIVE]
        return ImGui::DragInt2(label, v, v_speed);
    */
    public static native boolean DragInt2(String label, int[] v, float v_speed);

    /*[-C++;-NATIVE]
        return ImGui::DragInt2(label, v, v_speed, v_min, v_max);
    */
    public static native boolean DragInt2(String label, int[] v, float v_speed, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::DragInt2(label, v, v_speed, v_min, v_max, format);
    */
    public static native boolean DragInt2(String label, int[] v, float v_speed, float v_min, float v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::DragInt2(label, v);
    */
    public static native boolean DragInt3(String label, int[] v);

    /*[-C++;-NATIVE]
        return ImGui::DragInt2(label, v, v_speed);
    */
    public static native boolean DragInt3(String label, int[] v, float v_speed);

    /*[-C++;-NATIVE]
        return ImGui::DragInt2(label, v, v_speed, v_min, v_max);
    */
    public static native boolean DragInt3(String label, int[] v, float v_speed, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::DragInt2(label, v, v_speed, v_min, v_max, format);
    */
    public static native boolean DragInt3(String label, int[] v, float v_speed, float v_min, float v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::DragInt4(label, v);
    */
    public static native boolean DragInt4(String label, int[] v);

    /*[-C++;-NATIVE]
        return ImGui::DragInt4(label, v, v_speed);
    */
    public static native boolean DragInt4(String label, int[] v, float v_speed);

    /*[-C++;-NATIVE]
        return ImGui::DragInt4(label, v, v_speed, v_min, v_max);
    */
    public static native boolean DragInt4(String label, int[] v, float v_speed, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::DragInt4(label, v, v_speed, v_min, v_max, format);
    */
    public static native boolean DragInt4(String label, int[] v, float v_speed, float v_min, float v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::DragIntRange2(label, &v_current_min[0], &v_current_max[0]);
    */
    public static native boolean DragIntRange2(String label, int[] v_current_min, int[] v_current_max);

    /*[-C++;-NATIVE]
        return ImGui::DragIntRange2(label, &v_current_min[0], &v_current_max[0], v_speed, v_min, v_max, format, format_max);
    */
    public static native boolean DragIntRange2(String label, int[] v_current_min, int[] v_current_max, float v_speed, float v_min, float v_max, String format, String format_max);

    //TODO impl other types
    /*[-C++;-NATIVE]
        return ImGui::DragScalar(label, data_type, &v[0], v_speed);
    */
    public static native boolean DragScalar(String label, int data_type, int[] v, float v_speed);

    //TODO impl other types
    /*[-C++;-NATIVE]
        return ImGui::DragScalar(label, data_type, &v[0], v_speed, &v_min, &v_max, format, power);
    */
    public static native boolean DragScalar(String label, int data_type, int[] v, float v_speed, float v_min, float v_max, String format, float power);

    // Widgets: Sliders
    // - CTRL+Click on any slider to turn them into an input box. Manually input values aren't clamped and can go off-bounds.
    // - Adjust format string to decorate the value with a prefix, a suffix, or adapt the editing and display precision e.g. "%.3f" -> 1.234; "%5.2f secs" -> 01.23 secs; "Biscuit: %.0f" -> Biscuit: 1; etc.

    /*[-C++;-NATIVE]
        return ImGui::SliderFloat(label, &v[0],v_min, v_max);
    */
    public static native boolean SliderFloat(String label, float[] v, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::SliderFloat(label, &v[0], v_min, v_max, format);
    */
    public static native boolean SliderFloat(String label, float[] v, float v_min, float v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::SliderFloat(label, &v[0], v_min, v_max, format, power);
    */
    public static native boolean SliderFloat(String label, float[] v, float v_min, float v_max, String format, float power);

    /*[-C++;-NATIVE]
        return ImGui::SliderFloat2(label, v, v_min, v_max);
    */
    public static native boolean SliderFloat2(String label, float[] v, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::SliderFloat2(label, v, v_min, v_max, format);
    */
    public static native boolean SliderFloat2(String label, float[] v, float v_min, float v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::SliderFloat2(label, v, v_min, v_max, format, power);
    */
    public static native boolean SliderFloat2(String label, float[] v, float v_min, float v_max, String format, float power);

    /*[-C++;-NATIVE]
        return ImGui::SliderFloat3(label, v, v_min, v_max);
    */
    public static native boolean SliderFloat3(String label, float[] v, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::SliderFloat3(label, v, v_min, v_max, format);
    */
    public static native boolean SliderFloat3(String label, float[] v, float v_min, float v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::SliderFloat3(label, v, v_min, v_max, format, power);
    */
    public static native boolean SliderFloat3(String label, float[] v, float v_min, float v_max, String format, float power);

    /*[-C++;-NATIVE]
        return ImGui::SliderFloat4(label, v, v_min, v_max);
    */
    public static native boolean SliderFloat4(String label, float[] v, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::SliderFloat4(label, v, v_min, v_max, format);
    */
    public static native boolean SliderFloat4(String label, float[] v, float v_min, float v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::SliderFloat4(label, v, v_min, v_max, format, power);
    */
    public static native boolean SliderFloat4(String label, float[] v, float v_min, float v_max, String format, float power);

    /*[-C++;-NATIVE]
        return ImGui::SliderAngle(label, &v_rad[0]);
    */
    public static native boolean SliderAngle(String label, float[] v_rad);

    /*[-C++;-NATIVE]
        return ImGui::SliderAngle(label, &v_rad[0], v_degrees_min, v_degrees_max, format);
    */
    public static native boolean SliderAngle(String label, float[] v_rad, float v_degrees_min, float v_degrees_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::SliderInt(label, &v[0], v_min, v_max);
    */
    public static native boolean SliderInt(String label, int[] v, int v_min, int v_max);

    /*[-C++;-NATIVE]
        return ImGui::SliderInt(label, &v[0], v_min, v_max, format);
    */
    public static native boolean SliderInt(String label, int[] v, int v_min, int v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::SliderInt2(label, v, v_min, v_max);
    */
    public static native boolean SliderInt2(String label, int[] v, int v_min, int v_max);

    /*[-C++;-NATIVE]
        return ImGui::SliderInt2(label, v, v_min, v_max, format);
    */
    public static native boolean SliderInt2(String label, int[] v, int v_min, int v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::SliderInt3(label, v, v_min, v_max);
    */
    public static native boolean SliderInt3(String label, int[] v, int v_min, int v_max);

    /*[-C++;-NATIVE]
        return ImGui::SliderInt3(label, v, v_min, v_max, format);
    */
    public static native boolean SliderInt3(String label, int[] v, int v_min, int v_max, String format);

    /*[-C++;-NATIVE]
        return ImGui::SliderInt4(label, v, v_min, v_max);
    */
    public static native boolean SliderInt4(String label, int[] v, int v_min, int v_max);

    /*[-C++;-NATIVE]
        return ImGui::SliderInt4(label, v, v_min, v_max, format);
    */
    public static native boolean SliderInt4(String label, int[] v, int v_min, int v_max, String format);

    //TODO impl other types
    /*[-C++;-NATIVE]
        return ImGui::SliderScalar(label, data_type, &v[0], &v_min, &v_max);
    */
    public static native boolean SliderScalar(String label, int data_type, int[] v, int v_min, int v_max);

    /*[-C++;-NATIVE]
        return ImGui::SliderScalar(label, data_type, &v[0], &v_min, &v_max, format, power);
    */
    public static native boolean SliderScalar(String label, int data_type, int[] v, float v_min, float v_max, String format, float power);

    /*[-C++;-NATIVE]
        return ImGui::SliderScalar(label, data_type, &v[0], &v_min, &v_max);
    */
    public static native boolean SliderScalar(String label, int data_type, float[] v, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::SliderScalar(label, data_type, &v[0], &v_min, &v_max, format, power);
    */
    public static native boolean SliderScalar(String label, int data_type, float[] v, float v_min, float v_max, String format, float power);

    /*[-C++;-NATIVE]
        return ImGui::VSliderFloat(label, ImVec2(sizeX, sizeY), &v[0], v_min, v_max);
    */
    public static native boolean VSliderFloat(String label, float sizeX, float sizeY, float[] v, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::VSliderFloat(label, ImVec2(sizeX, sizeY), &v[0], v_min, v_max, format, power);
    */
    public static native boolean VSliderFloat(String label, float sizeX, float sizeY, float[] v, float v_min, float v_max, String format, float power);

    /*[-C++;-NATIVE]
        return ImGui::VSliderInt(label, ImVec2(sizeX, sizeY), &v[0], v_min, v_max);
    */
    public static native boolean VSliderInt(String label, float sizeX, float sizeY, int[] v, int v_min, int v_max);

    /*[-C++;-NATIVE]
        return ImGui::VSliderInt(label, ImVec2(sizeX, sizeY), &v[0], v_min, v_max, format);
    */
    public static native boolean VSliderInt(String label, float sizeX, float sizeY, int[] v, int v_min, int v_max, String format);

    //TODO impl other types
    /*[-C++;-NATIVE]
        return ImGui::VSliderScalar(label, ImVec2(sizeX, sizeY), data_type, &v[0], &v_min, &v_max);
    */
    public static native boolean VSliderScalar(String label, float sizeX, float sizeY, int data_type, int[] v, int v_min, int v_max);

    /*[-C++;-NATIVE]
        return ImGui::VSliderScalar(label, ImVec2(sizeX, sizeY), data_type, &v[0], &v_min, &v_max, format, power);
    */
    public static native boolean VSliderScalar(String label, float sizeX, float sizeY, int data_type, int[] v, int v_min, int v_max, String format, float power);

    /*[-C++;-NATIVE]
        return ImGui::VSliderScalar(label, ImVec2(sizeX, sizeY), data_type, &v[0], &v_min, &v_max);
    */
    public static native boolean VSliderScalar(String label, float sizeX, float sizeY, int data_type, float[] v, float v_min, float v_max);

    /*[-C++;-NATIVE]
        return ImGui::VSliderScalar(label, ImVec2(sizeX, sizeY), data_type, &v[0], &v_min, &v_max, format, power);
    */
    public static native boolean VSliderScalar(String label, float sizeX, float sizeY, int data_type, float[] v, float v_min, float v_max, String format, float power);

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

    // Widgets: Color Editor/Picker (tip: the ColorEdit* functions have a little color square that can be left-clicked to open a picker, and right-clicked to open an option menu.)
    // - Note that in C++ a 'float v[X]' function argument is the _same_ as 'float* v', the array syntax is just a way to document the number of elements that are expected to be accessible.
    // - You can pass the address of a first float element out of a contiguous structure, e.g. &myvector.x

    /*[-C++;-NATIVE]
        return ImGui::ColorEdit3(label, col, flags);
    */
    public static native boolean ColorEdit3(String label, float[] col, int flags);

    /*[-C++;-NATIVE]
        return ImGui::ColorEdit4(label, col, flags);
    */
    public static native boolean ColorEdit4(String label, float[] col, int flags);

    /*[-C++;-NATIVE]
        return ImGui::ColorPicker3(label, col, flags);
    */
    public static native boolean ColorPicker3(String label, float[] col, int flags);

    /*[-C++;-NATIVE]
        return ImGui::ColorPicker4(label, col, flags);
    */
    public static native boolean ColorPicker4(String label, float[] col, int flags);
}
