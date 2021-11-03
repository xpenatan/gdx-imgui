#include "imgui_helper.h"

static JavaVM *jvm;

jfieldID imVec2XID;
jfieldID imVec2YID;

void ImGuiHelper::Init(JNIEnv* env) {
    jint rs = env->GetJavaVM(&jvm);
    assert (rs == JNI_OK);
    jclass jImVec2Class = env->FindClass("com/github/xpenatan/imgui/ImVec2");
    imVec2XID = env->GetFieldID(jImVec2Class, "x", "F");
    imVec2YID = env->GetFieldID(jImVec2Class, "y", "F");
}

JNIEnv* ImGuiHelper::GetEnv() {
    JNIEnv *env;
    jint rs = jvm->AttachCurrentThread((void **)&env, NULL);
    assert (rs == JNI_OK);
    return env;
}

void ImGuiHelper::SetImVec2(JNIEnv* env, jobject in, ImVec2* out) {
    float x = env->GetFloatField(in, imVec2XID);
    float y = env->GetFloatField(in, imVec2YID);
    out->x = x;
    out->y = y;
}

void ImGuiHelper::SetImVec2(JNIEnv* env, ImVec2 in, jobject out) {
    env->SetFloatField (out, imVec2XID, in.x);
    env->SetFloatField (out, imVec2YID, in.y);
}
