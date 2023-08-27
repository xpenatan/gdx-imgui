#include "imgui_helper.h"
#include <cstring>
#if defined(_MSC_VER) && _MSC_VER <= 1500 // MSVC 2008 or earlier
#include <stddef.h>     // intptr_t
#else
#include <stdint.h>     // intptr_t
#endif

static JavaVM *jvm;

void ImGuiHelper::Init(JNIEnv* env) {
    jint rs = env->GetJavaVM(&jvm);
    assert (rs == JNI_OK);
}

JNIEnv* ImGuiHelper::GetEnv() {
    JNIEnv *env;
    jint rs = jvm->AttachCurrentThread((void **)&env, NULL);
    assert (rs == JNI_OK);
    return env;
}