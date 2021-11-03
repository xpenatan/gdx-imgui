#pragma once

#include <jni.h>
#include "imgui.h"
#include "imgui_internal.h"

namespace ImGuiHelper
{
    void Init(JNIEnv* env);
    JNIEnv* GetEnv();

    void SetImVec2(JNIEnv* env, jobject in, ImVec2* out);
    void SetImVec2(JNIEnv* env, ImVec2 in, jobject out);
};