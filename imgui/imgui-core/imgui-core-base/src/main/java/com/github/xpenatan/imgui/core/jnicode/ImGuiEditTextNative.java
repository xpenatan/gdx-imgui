package com.github.xpenatan.imgui.core.jnicode;

import com.github.xpenatan.imgui.core.ImGuiInputTextCallback;
import com.github.xpenatan.imgui.core.ImGuiInputTextCallbackData;
import com.github.xpenatan.imgui.core.ImGuiString;

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
        static jmethodID imOnInputTextChangeID = 0;
    */


    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]

        ImGuiHelper::Init(env);
        jclass jImGuiInputTextCallbackClass = env->FindClass("com/github/xpenatan/imgui/core/ImGuiInputTextCallback");

        imOnInputTextChangeID = env->GetMethodID(jImGuiInputTextCallbackClass, "onInputTextChange", "(J)I");
    */
    public static native void init();

    // Widgets: Drags
    // - CTRL+Click on any drag box to turn them into an input box. Manually input values aren't clamped and can go off-bounds.
    // - For all the Float2/Float3/Float4/Int2/Int3/Int4 versions of every functions, note that a 'float v[X]' function argument is the same as 'float* v', the array syntax is just a way to document the number of elements that are expected to be accessible. You can pass address of your first element out of a contiguous set, e.g. &myvector.x
    // - Adjust format string to decorate the value with a prefix, a suffix, or adapt the editing and display precision e.g. "%.3f" -> 1.234; "%5.2f secs" -> 01.23 secs; "Biscuit: %.0f" -> Biscuit: 1; etc.
    // - Speed are per-pixel of mouse movement (v_speed=0.2f: mouse needs to move by 5 pixels to increase value by 1). For gamepad/keyboard navigation, minimum speed is Max(v_speed, minimum_step_at_given_precision).

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat(label, vAddr);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat(label, &v[0]);
    */
    public static native boolean DragFloat(String label, long vAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat(label, vAddr, v_speed);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat(label, &v[0], v_speed);
    */
    public static native boolean DragFloat(String label, long vAddr, float v_speed);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat(label, vAddr, v_speed, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat(label, &v[0], v_speed, v_min, v_max);
    */
    public static native boolean DragFloat(String label, long vAddr, float v_speed, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat(label, vAddr, v_speed, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat(label, &v[0], v_speed, v_min, v_max, format);
    */
    public static native boolean DragFloat(String label, long vAddr, float v_speed, float v_min, float v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat(label, vAddr, v_speed, v_min, v_max, format, power);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat(label, &v[0], v_speed, v_min, v_max, format, power);
    */
    public static native boolean DragFloat(String label, long vAddr, float v_speed, float v_min, float v_max, String format, float power);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat2(label, vAddr);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat2(label, v);
    */
    public static native boolean DragFloat2(String label, long vAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat2(label, vAddr, v_speed);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat2(label, &v[0], v_speed);
    */
    public static native boolean DragFloat2(String label, long vAddr, float v_speed);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat2(label, vAddr, v_speed, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat2(label, &v[0], v_speed, v_min, v_max);
    */
    public static native boolean DragFloat2(String label, long vAddr, float v_speed, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat2(label, vAddr, v_speed, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat2(label, &v[0], v_speed, v_min, v_max, format);
    */
    public static native boolean DragFloat2(String label, long vAddr, float v_speed, float v_min, float v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat2(label, vAddr, v_speed, v_min, v_max, format, power);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat2(label, v, v_speed, v_min, v_max, format, power);
    */
    public static native boolean DragFloat2(String label, long vAddr, float v_speed, float v_min, float v_max, String format, float power);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat3(label, vAddr);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat3(label, v);
    */
    public static native boolean DragFloat3(String label, long vAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat3(label, vAddr, v_speed);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat3(label, v, v_speed);
    */
    public static native boolean DragFloat3(String label, long vAddr, float v_speed);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat3(label, vAddr, v_speed, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat3(label, v, v_speed, v_min, v_max);
    */
    public static native boolean DragFloat3(String label, long vAddr, float v_speed, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat3(label, vAddr, v_speed, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat3(label, v, v_speed, v_min, v_max, format);
    */
    public static native boolean DragFloat3(String label, long vAddr, float v_speed, float v_min, float v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat3(label, vAddr, v_speed, v_min, v_max, format, power);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat3(label, v, v_speed, v_min, v_max, format, power);
    */
    public static native boolean DragFloat3(String label, long vAddr, float v_speed, float v_min, float v_max, String format, float power);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat4(label, vAddr);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat4(label, v);
    */
    public static native boolean DragFloat4(String label, long vAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat4(label, vAddr, v_speed);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat4(label, v, v_speed);
    */
    public static native boolean DragFloat4(String label, long vAddr, float v_speed);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat4(label, vAddr, v_speed, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat4(label, v, v_speed, v_min, v_max);
    */
    public static native boolean DragFloat4(String label, long vAddr, float v_speed, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat4(label, vAddr, v_speed, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat4(label, v, v_speed, v_min, v_max, format);
    */
    public static native boolean DragFloat4(String label, long vAddr, float v_speed, float v_min, float v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloat4(label, vAddr, v_speed, v_min, v_max, format, power);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::DragFloat4(label, v, v_speed, v_min, v_max, format, power);
    */
    public static native boolean DragFloat4(String label, long vAddr, float v_speed, float v_min, float v_max, String format, float power);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloatRange2(label, v_current_minAddr, v_current_maxAddr);
    */
    /*[-C++;-NATIVE]
        float * v_current_min = (float*)v_current_minAddr;
        float * v_current_max = (float*)v_current_maxAddr;
        return ImGui::DragFloatRange2(label, &v_current_min[0], &v_current_max[0]);
    */
    public static native boolean DragFloatRange2(String label, long v_current_minAddr, long v_current_maxAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragFloatRange2(label, v_current_minAddr, v_current_maxAddr, v_speed, v_min, v_max, format, format_max, power);
    */
    /*[-C++;-NATIVE]
        float * v_current_min = (float*)v_current_minAddr;
        float * v_current_max = (float*)v_current_maxAddr;
        return ImGui::DragFloatRange2(label, &v_current_min[0], &v_current_max[0], v_speed, v_min, v_max, format, format_max, power);
    */
    public static native boolean DragFloatRange2(String label, long v_current_minAddr, long v_current_maxAddr, float v_speed, float v_min, float v_max, String format, String format_max, float power);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt(label, vAddr);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt(label, &v[0]);
    */
    public static native boolean DragInt(String label, long vAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt(label, vAddr, v_speed);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt(label, &v[0], v_speed);
    */
    public static native boolean DragInt(String label, long vAddr, float v_speed);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt(label, vAddr, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt(label, &v[0], v_speed, v_min, v_max);
    */
    public static native boolean DragInt(String label, long vAddr, float v_speed, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt(label, vAddr, v_speed, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt(label, &v[0], v_speed, v_min, v_max, format);
    */
    public static native boolean DragInt(String label, long vAddr, float v_speed, float v_min, float v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt2(label, vAddr);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt2(label, v);
    */
    public static native boolean DragInt2(String label, long vAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt2(label, vAddr, v_speed);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt2(label, v, v_speed);
    */
    public static native boolean DragInt2(String label, long vAddr, float v_speed);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt2(label, vAddr, v_speed, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt2(label, v, v_speed, v_min, v_max);
    */
    public static native boolean DragInt2(String label, long vAddr, float v_speed, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt2(label, vAddr, v_speed, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt2(label, v, v_speed, v_min, v_max, format);
    */
    public static native boolean DragInt2(String label, long vAddr, float v_speed, float v_min, float v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt3(label, vAddr);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt2(label, v);
    */
    public static native boolean DragInt3(String label, long vAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt3(label, vAddr, v_speed);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt2(label, v, v_speed);
    */
    public static native boolean DragInt3(String label, long vAddr, float v_speed);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt3(label, vAddr, v_speed, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt2(label, v, v_speed, v_min, v_max);
    */
    public static native boolean DragInt3(String label, long vAddr, float v_speed, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt3(label, vAddr, v_speed, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt2(label, v, v_speed, v_min, v_max, format);
    */
    public static native boolean DragInt3(String label, long vAddr, float v_speed, float v_min, float v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt4(label, vAddr);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt4(label, v);
    */
    public static native boolean DragInt4(String label, long vAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt4(label, vAddr, v_speed);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt4(label, v, v_speed);
    */
    public static native boolean DragInt4(String label, long vAddr, float v_speed);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt4(label, vAddr, v_speed, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt4(label, v, v_speed, v_min, v_max);
    */
    public static native boolean DragInt4(String label, long vAddr, float v_speed, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragInt4(label, vAddr, v_speed, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragInt4(label, v, v_speed, v_min, v_max, format);
    */
    public static native boolean DragInt4(String label, long vAddr, float v_speed, float v_min, float v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragIntRange2(label, v_current_minAddr, v_current_maxAddr);
    */
    /*[-C++;-NATIVE]
        int * v_current_min = (int*)v_current_minAddr;
        int * v_current_max = (int*)v_current_maxAddr;
        return ImGui::DragIntRange2(label, &v_current_min[0], &v_current_max[0]);
    */
    public static native boolean DragIntRange2(String label, long v_current_minAddr, long v_current_maxAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragIntRange2(label, v_current_minAddr, v_current_maxAddr, v_speed, v_min, v_max, format, format_max);
    */
    /*[-C++;-NATIVE]
        int * v_current_min = (int*)v_current_minAddr;
        int * v_current_max = (int*)v_current_maxAddr;
        return ImGui::DragIntRange2(label, &v_current_min[0], &v_current_max[0], v_speed, v_min, v_max, format, format_max);
    */
    public static native boolean DragIntRange2(String label, long v_current_minAddr, long v_current_maxAddr, float v_speed, float v_min, float v_max, String format, String format_max);

    //TODO impl other types

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragScalar(label, data_type, vAddr, v_speed);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragScalar(label, data_type, &v[0], v_speed);
    */
    public static native boolean DragScalar(String label, int data_type, long vAddr, float v_speed);

    //TODO impl other types

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DragScalar(label, data_type, vAddr, v_speed, v_min, v_max, format, power);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::DragScalar(label, data_type, &v[0], v_speed, &v_min, &v_max, format, power);
    */
    public static native boolean DragScalar(String label, int data_type, long vAddr, float v_speed, float v_min, float v_max, String format, float power);

    // Widgets: Sliders
    // - CTRL+Click on any slider to turn them into an input box. Manually input values aren't clamped and can go off-bounds.
    // - Adjust format string to decorate the value with a prefix, a suffix, or adapt the editing and display precision e.g. "%.3f" -> 1.234; "%5.2f secs" -> 01.23 secs; "Biscuit: %.0f" -> Biscuit: 1; etc.

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderFloat(label, vAddr, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::SliderFloat(label, &v[0],v_min, v_max);
    */
    public static native boolean SliderFloat(String label, long vAddr, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderFloat(label, vAddr, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::SliderFloat(label, &v[0], v_min, v_max, format);
    */
    public static native boolean SliderFloat(String label, long vAddr, float v_min, float v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderFloat(label, vAddr, v_min, v_max, format, power);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::SliderFloat(label, &v[0], v_min, v_max, format, power);
    */
    public static native boolean SliderFloat(String label, long vAddr, float v_min, float v_max, String format, float power);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderFloat2(label, vAddr, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::SliderFloat2(label, v, v_min, v_max);
    */
    public static native boolean SliderFloat2(String label, long vAddr, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderFloat2(label, vAddr, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::SliderFloat2(label, v, v_min, v_max, format);
    */
    public static native boolean SliderFloat2(String label, long vAddr, float v_min, float v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderFloat2(label, vAddr, v_min, v_max, format, power);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::SliderFloat2(label, v, v_min, v_max, format, power);
    */
    public static native boolean SliderFloat2(String label, long vAddr, float v_min, float v_max, String format, float power);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderFloat3(label, vAddr, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::SliderFloat3(label, v, v_min, v_max);
    */
    public static native boolean SliderFloat3(String label, long vAddr, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderFloat3(label, vAddr, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::SliderFloat3(label, v, v_min, v_max, format);
    */
    public static native boolean SliderFloat3(String label, long vAddr, float v_min, float v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderFloat3(label, vAddr, v_min, v_max, format, power);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::SliderFloat3(label, v, v_min, v_max, format, power);
    */
    public static native boolean SliderFloat3(String label, long vAddr, float v_min, float v_max, String format, float power);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderFloat4(label, vAddr, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::SliderFloat4(label, v, v_min, v_max);
    */
    public static native boolean SliderFloat4(String label, long vAddr, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderFloat4(label, vAddr, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::SliderFloat4(label, v, v_min, v_max, format);
    */
    public static native boolean SliderFloat4(String label, long vAddr, float v_min, float v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderFloat4(label, vAddr, v_min, v_max, format, power);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::SliderFloat4(label, v, v_min, v_max, format, power);
    */
    public static native boolean SliderFloat4(String label, long vAddr, float v_min, float v_max, String format, float power);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderAngle(label, v_radAddr);
    */
    /*[-C++;-NATIVE]
        float * v_rad = (float*)v_radAddr;
        return ImGui::SliderAngle(label, &v_rad[0]);
    */
    public static native boolean SliderAngle(String label, long v_radAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderAngle(label, v_radAddr, v_degrees_min, v_degrees_max, format);
    */
    /*[-C++;-NATIVE]
        float * v_rad = (float*)v_radAddr;
        return ImGui::SliderAngle(label, &v_rad[0], v_degrees_min, v_degrees_max, format);
    */
    public static native boolean SliderAngle(String label, long v_radAddr, float v_degrees_min, float v_degrees_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderInt(label, vAddr, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::SliderInt(label, &v[0], v_min, v_max);
    */
    public static native boolean SliderInt(String label, long vAddr, int v_min, int v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderInt(label, vAddr, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::SliderInt(label, &v[0], v_min, v_max, format);
    */
    public static native boolean SliderInt(String label, long vAddr, int v_min, int v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderInt2(label, vAddr, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::SliderInt2(label, v, v_min, v_max);
    */
    public static native boolean SliderInt2(String label, long vAddr, int v_min, int v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderInt2(label, vAddr, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::SliderInt2(label, v, v_min, v_max, format);
    */
    public static native boolean SliderInt2(String label, long vAddr, int v_min, int v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderInt3(label, vAddr, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::SliderInt3(label, v, v_min, v_max);
    */
    public static native boolean SliderInt3(String label, long vAddr, int v_min, int v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderInt3(label, vAddr, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::SliderInt3(label, v, v_min, v_max, format);
    */
    public static native boolean SliderInt3(String label, long vAddr, int v_min, int v_max, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderInt4(label, vAddr, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::SliderInt4(label, v, v_min, v_max);
    */
    public static native boolean SliderInt4(String label, long vAddr, int v_min, int v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderInt4(label, vAddr, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::SliderInt4(label, v, v_min, v_max, format);
    */
    public static native boolean SliderInt4(String label, long vAddr, int v_min, int v_max, String format);

    //TODO impl other types

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderScalar(label, data_type, vAddr, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::SliderScalar(label, data_type, &v[0], &v_min, &v_max);
    */
    public static native boolean SliderScalar(String label, int data_type, long vAddr, int v_min, int v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SliderScalar(label, data_type, vAddr, v_min, v_max, format, power);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::SliderScalar(label, data_type, &v[0], &v_min, &v_max, format, power);
    */
    public static native boolean SliderScalar(String label, int data_type, long vAddr, float v_min, float v_max, String format, float power);

    /*[-teaVM;-NATIVE]
        return false;
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::SliderScalar(label, data_type, &v[0], &v_min, &v_max);
    */
    public static native boolean SliderScalar(String label, int data_type, long vAddr, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::SliderScalar(label, data_type, &v[0], &v_min, &v_max, format, power);
    */
    public static native boolean SliderScalar(String label, int data_type, float[] v, float v_min, float v_max, String format, float power);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.VSliderFloat(label, sizeAddr, vAddr, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::VSliderFloat(label, *size, &v[0], v_min, v_max);
    */
    public static native boolean VSliderFloat(String label, long sizeAddr, long vAddr, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.VSliderFloat(label, sizeAddr, vAddr, v_min, v_max, format, power);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::VSliderFloat(label, *size, &v[0], v_min, v_max, format, power);
    */
    public static native boolean VSliderFloat(String label, long sizeAddr, long vAddr, float v_min, float v_max, String format, float power);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.VSliderInt(label, sizeAddr, vAddr, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::VSliderInt(label, *size, &v[0], v_min, v_max);
    */
    public static native boolean VSliderInt(String label, long sizeAddr, long vAddr, int v_min, int v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.VSliderInt(label, sizeAddr, vAddr, v_min, v_max, format);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::VSliderInt(label, *size, &v[0], v_min, v_max, format);
    */
    public static native boolean VSliderInt(String label, long sizeAddr, long vAddr, int v_min, int v_max, String format);

    //TODO impl other types


    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.VSliderScalar(label, sizeAddr, data_type, vAddr, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::VSliderScalar(label, *size, data_type, &v[0], &v_min, &v_max);
    */
    public static native boolean VSliderScalar(String label, long sizeAddr, int data_type, long vAddr, int v_min, int v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.VSliderScalar(label, sizeAddr, data_type, vAddr, v_min, v_max, format, power);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::VSliderScalar(label, *size, data_type, &v[0], &v_min, &v_max, format, power);
    */
    public static native boolean VSliderScalar(String label, long sizeAddr, int data_type, long vAddr, int v_min, int v_max, String format, float power);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.VSliderScalar(label, sizeAddr, data_type, vAddr, v_min, v_max);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::VSliderScalar(label, *size, data_type, &v[0], &v_min, &v_max);
    */
    public static native boolean VSliderScalar(String label, long sizeAddr, int data_type, long vAddr, float v_min, float v_max);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.VSliderScalar(label, sizeAddr, data_type, vAddr, v_min, v_max, format, power);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::VSliderScalar(label, *size, data_type, &v[0], &v_min, &v_max, format, power);
    */
    public static native boolean VSliderScalar(String label, long sizeAddr, int data_type, long vAddr, float v_min, float v_max, String format, float power);

    // Widgets: Input with Keyboard
    // - If you want to use InputText() with a dynamic string type such as std::string or your own, see misc/cpp/imgui_stdlib.h
    // - Most of the ImGuiInputTextFlags flags are only useful for InputText() and not for InputFloatX, InputIntX, InputDouble etc.

    /*[-C++;-NATIVE]
        struct InputTextCallback_Data {
            JNIEnv* env;
            jobject* obj;
        };

        static int InputTextCallback(ImGuiInputTextCallbackData* data) {
            InputTextCallback_Data* userData = (InputTextCallback_Data*)data->UserData;
            return userData->env->CallIntMethod(*userData->obj, imOnInputTextChangeID, (jlong)data);
        }
    */

    public static boolean InputText(String label, ImGuiString text, int bufSize, int flags, ImGuiInputTextCallback callback) {
        ImGuiInputTextCallbackData.TMP_EMPTY.imGuiString = text;
        boolean ret = InputTextInternal(label, text.getData(), bufSize, flags, callback);
        ImGuiInputTextCallbackData.TMP_EMPTY.imGuiString = null;
        return ret;
    }

    /*[-teaVM;-NATIVE]
        return false;
    */
    /*[-C++;-NATIVE]
        int size = (int)strlen(buf);
        InputTextCallback_Data callbackData;
        callbackData.obj = &callback;
        callbackData.env = env;
        return ImGui::InputText(label, buf, bufSize, flags | ImGuiInputTextFlags_CallbackResize, &InputTextCallback, &callbackData);
    */
    private static native boolean InputTextInternal(String label, byte[] buf, int bufSize, int flags, ImGuiInputTextCallback callback);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.InputFloat(label, vAddr);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::InputFloat(label, &v[0]);
    */
    public static native boolean InputFloat(String label, long vAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.InputFloat(label, vAddr, step, step_fast, format);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::InputFloat(label, &v[0], step, step_fast, format);
    */
    public static native boolean InputFloat(String label, long vAddr, float step, float step_fast, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.InputFloat(label, vAddr, step, step_fast, format, flags);
    */
    /*[-C++;-NATIVE]
        float * v = (float*)vAddr;
        return ImGui::InputFloat(label, &v[0], step, step_fast, format, flags);
    */
    public static native boolean InputFloat(String label, long vAddr, float step, float step_fast, String format, int flags);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.InputInt(label, vAddr);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::InputInt(label, &v[0]);
    */
    public static native boolean InputInt(String label, long vAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.InputInt(label, vAddr, step, step_fast);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::InputInt(label, &v[0], step, step_fast);
    */
    public static native boolean InputInt(String label, long vAddr, float step, float step_fast);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.InputInt(label, vAddr, step, step_fast, flags);
    */
    /*[-C++;-NATIVE]
        int * v = (int*)vAddr;
        return ImGui::InputInt(label, &v[0], step, step_fast, flags);
    */
    public static native boolean InputInt(String label, long vAddr, float step, float step_fast, int flags);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.InputDouble(label, vAddr);
    */
    /*[-C++;-NATIVE]
        double * v = (double*)vAddr;
        return ImGui::InputDouble(label, &v[0]);
    */
    public static native boolean InputDouble(String label, long vAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.InputDouble(label, vAddr, step, step_fast, format);
    */
    /*[-C++;-NATIVE]
        double * v = (double*)vAddr;
        return ImGui::InputDouble(label, &v[0], step, step_fast, format);
    */
    public static native boolean InputDouble(String label, long vAddr, float step, float step_fast, String format);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.InputDouble(label, vAddr, step, step_fast, format, flags);
    */
    /*[-C++;-NATIVE]
        double * v = (double*)vAddr;
        return ImGui::InputDouble(label, &v[0], step, step_fast, format, flags);
    */
    public static native boolean InputDouble(String label, long vAddr, float step, float step_fast, String format, int flags);

    // Widgets: Color Editor/Picker (tip: the ColorEdit* functions have a little color square that can be left-clicked to open a picker, and right-clicked to open an option menu.)
    // - Note that in C++ a 'float v[X]' function argument is the _same_ as 'float* v', the array syntax is just a way to document the number of elements that are expected to be accessible.
    // - You can pass the address of a first float element out of a contiguous structure, e.g. &myvector.x

    /*[-teaVM;-NATIVE]
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::ColorEdit3(label, col, flags);
    */
    public static native boolean ColorEdit3(String label, float[] col, int flags);

    /*[-teaVM;-NATIVE]
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::ColorEdit4(label, col, flags);
    */
    public static native boolean ColorEdit4(String label, float[] col, int flags);

    /*[-teaVM;-NATIVE]
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::ColorPicker3(label, col, flags);
    */
    public static native boolean ColorPicker3(String label, float[] col, int flags);

    /*[-teaVM;-NATIVE]
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::ColorPicker4(label, col, flags);
    */
    public static native boolean ColorPicker4(String label, float[] col, int flags);
}
