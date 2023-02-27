#pragma once

#include <jni.h>
#include "imgui.h"
#include "imgui_internal.h"

namespace ImGuiHelper
{
    void Init(JNIEnv* env);
    JNIEnv* GetEnv();
};