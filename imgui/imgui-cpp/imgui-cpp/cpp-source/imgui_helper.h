#pragma once

#include <jni.h>
#include "imgui.h"
#include "imgui_internal.h"

namespace ImGuiHelper
{
    void Init(JNIEnv* env);
    JNIEnv* GetEnv();

    void SetImGuiViewport(JNIEnv* env, jobject in, ImGuiViewport* out);
    void SetImGuiViewport(JNIEnv* env, ImGuiViewport* in, jobject out, bool updateDrawData = false);

    void SetImDrawData(JNIEnv* env, ImDrawData* in, jobject out);

    jobject CreateJImGuiViewport(JNIEnv* env);
};