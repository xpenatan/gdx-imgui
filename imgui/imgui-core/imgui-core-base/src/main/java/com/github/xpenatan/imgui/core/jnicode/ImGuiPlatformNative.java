package com.github.xpenatan.imgui.core.jnicode;

import com.github.xpenatan.imgui.core.util.ImGuiPlatformListener;

public class ImGuiPlatformNative {

    /*[-C++;-NATIVE]
        #include "imgui_helper.h"

        #include <imgui.h>
        #include <cstring>
        #if defined(_MSC_VER) && _MSC_VER <= 1500 // MSVC 2008 or earlier
        #include <stddef.h>     // intptr_t
        #else
        #include <stdint.h>     // intptr_t
        #endif

        static jobject jListener;
        static jobject jViewport;

        jmethodID mid_Platform_CreateWindow;
        jmethodID mid_Platform_ShowWindow;
        jmethodID mid_Platform_DestroyWindow;
        jmethodID mid_Platform_SetWindowPos;
        jmethodID mid_Platform_GetWindowPos;
        jmethodID mid_Platform_SetWindowSize;
        jmethodID mid_Platform_GetWindowSize;
        jmethodID mid_Platform_SetWindowFocus;
        jmethodID mid_Platform_GetWindowFocus;
        jmethodID mid_Platform_GetWindowMinimized;
        jmethodID mid_Platform_SetWindowTitle;
        jmethodID mid_Platform_RenderWindow;
        jmethodID mid_Platform_SwapBuffers;
        jmethodID mid_Renderer_RenderWindow;
    */

    /*[-C++;-NATIVE]
        static void ImGui_Platform_CreateWindow(ImGuiViewport* viewport) {
            JNIEnv *env = ImGuiHelper::GetEnv();
            int64_t* handler = new int64_t;
            *handler = 0;
            viewport->PlatformHandle = handler;
            viewport->PlatformUserData = NULL;
            ImGuiHelper::SetImGuiViewport(env, viewport, jViewport);
            env->CallVoidMethod(jListener, mid_Platform_CreateWindow, jViewport);
            ImGuiHelper::SetImGuiViewport(env, jViewport, viewport);
        }
        static void ImGui_Platform_DestroyWindow(ImGuiViewport* viewport) {
            JNIEnv *env = ImGuiHelper::GetEnv();
            int64_t platformHandle = -1;
            int platformUserData = -1;
            if(viewport->PlatformHandle != NULL) {
                platformHandle = *(int64_t*)viewport->PlatformHandle;
            }
            if(viewport->PlatformUserData != NULL) {
                intptr_t test = reinterpret_cast<intptr_t>(viewport->PlatformUserData);
                platformUserData = static_cast<int>(test);
            }
            env->CallVoidMethod(jListener, mid_Platform_DestroyWindow, platformHandle, platformUserData);
            if(viewport->PlatformHandle != NULL) {
                delete viewport->PlatformHandle;
                viewport->PlatformHandle = NULL;
            }
            viewport->PlatformUserData = NULL;
        }
        static void ImGui_Platform_ShowWindow(ImGuiViewport* viewport) {
            JNIEnv *env = ImGuiHelper::GetEnv();
            int64_t platformHandle = -1;
            int platformUserData = -1;
            if(viewport->PlatformHandle != NULL) {
                platformHandle = *(int64_t*)viewport->PlatformHandle;
            }
            if(viewport->PlatformUserData != NULL) {
                intptr_t test = reinterpret_cast<intptr_t>(viewport->PlatformUserData);
                platformUserData = static_cast<int>(test);
            }
            env->CallVoidMethod(jListener, mid_Platform_ShowWindow, platformHandle, platformUserData);
        }
        static void ImGui_Platform_SetWindowPos(ImGuiViewport* viewport, ImVec2 pos) {
            JNIEnv *env = ImGuiHelper::GetEnv();
            int64_t platformHandle = -1;
            int platformUserData = -1;
            if(viewport->PlatformHandle != NULL) {
                platformHandle = *(int64_t*)viewport->PlatformHandle;
            }
            if(viewport->PlatformUserData != NULL) {
                intptr_t test = reinterpret_cast<intptr_t>(viewport->PlatformUserData);
                platformUserData = static_cast<int>(test);
            }
            env->CallVoidMethod(jListener, mid_Platform_SetWindowPos, platformHandle, platformUserData, pos.x, pos.y);
        }
        static ImVec2 ImGui_Platform_GetWindowPos(ImGuiViewport* viewport) {
            JNIEnv *env = ImGuiHelper::GetEnv();
            int64_t platformHandle = -1;
            int platformUserData = -1;
            if(viewport->PlatformHandle != NULL) {
                platformHandle = *(int64_t*)viewport->PlatformHandle;
            }
            if(viewport->PlatformUserData != NULL) {
                intptr_t test = reinterpret_cast<intptr_t>(viewport->PlatformUserData);
                platformUserData = static_cast<int>(test);
            }
            long vec2Addr = env->CallLongMethod(jListener, mid_Platform_GetWindowPos, platformHandle, platformUserData);
            ImVec2 * input = (ImVec2*)vec2Addr;
            ImVec2 vec2 = ImVec2();
            vec2.x = input->x;
            vec2.y = input->y;
            return vec2;
        }
        static void ImGui_Platform_SetWindowSize(ImGuiViewport* viewport, ImVec2 size) {
            JNIEnv *env = ImGuiHelper::GetEnv();
            int64_t platformHandle = -1;
            int platformUserData = -1;
            if(viewport->PlatformHandle != NULL) {
                platformHandle = *(int64_t*)viewport->PlatformHandle;
            }
            if(viewport->PlatformUserData != NULL) {
                intptr_t test = reinterpret_cast<intptr_t>(viewport->PlatformUserData);
                platformUserData = static_cast<int>(test);
            }
            env->CallVoidMethod(jListener, mid_Platform_SetWindowSize, platformHandle, platformUserData, size.x, size.y);
        }
        static ImVec2 ImGui_Platform_GetWindowSize(ImGuiViewport* viewport) {
            JNIEnv *env = ImGuiHelper::GetEnv();
            int64_t platformHandle = -1;
            int platformUserData = -1;
            if(viewport->PlatformHandle != NULL) {
                platformHandle = *(int64_t*)viewport->PlatformHandle;
            }
            if(viewport->PlatformUserData != NULL) {
                intptr_t test = reinterpret_cast<intptr_t>(viewport->PlatformUserData);
                platformUserData = static_cast<int>(test);
            }
            long vec2Addr = env->CallLongMethod(jListener, mid_Platform_GetWindowSize, platformHandle, platformUserData);
            ImVec2 * input = (ImVec2*)vec2Addr;
            ImVec2 vec2 = ImVec2();
            vec2.x = input->x;
            vec2.y = input->y;
            return vec2;
        }
        static void ImGui_Platform_SetWindowFocus(ImGuiViewport* viewport) {
            JNIEnv *env = ImGuiHelper::GetEnv();
            int64_t platformHandle = -1;
            int platformUserData = -1;
            if(viewport->PlatformHandle != NULL) {
                platformHandle = *(int64_t*)viewport->PlatformHandle;
            }
            if(viewport->PlatformUserData != NULL) {
                intptr_t test = reinterpret_cast<intptr_t>(viewport->PlatformUserData);
                platformUserData = static_cast<int>(test);
            }
            env->CallVoidMethod(jListener, mid_Platform_SetWindowFocus, platformHandle, platformUserData);
        }
        static bool ImGui_Platform_GetWindowFocus(ImGuiViewport* viewport) {
            JNIEnv *env = ImGuiHelper::GetEnv();
            int64_t platformHandle = -1;
            int platformUserData = -1;
            if(viewport->PlatformHandle != NULL) {
                platformHandle = *(int64_t*)viewport->PlatformHandle;
            }
            if(viewport->PlatformUserData != NULL) {
                intptr_t test = reinterpret_cast<intptr_t>(viewport->PlatformUserData);
                platformUserData = static_cast<int>(test);
            }
            bool flag = false;
            flag = (bool)env->CallBooleanMethod(jListener, mid_Platform_GetWindowFocus, platformHandle, platformUserData);
            return flag;
        }
        static bool ImGui_Platform_GetWindowMinimized(ImGuiViewport* viewport) {
            JNIEnv *env = ImGuiHelper::GetEnv();
            int64_t platformHandle = -1;
            int platformUserData = -1;
            if(viewport->PlatformHandle != NULL) {
                platformHandle = *(int64_t*)viewport->PlatformHandle;
            }
            if(viewport->PlatformUserData != NULL) {
                intptr_t test = reinterpret_cast<intptr_t>(viewport->PlatformUserData);
                platformUserData = static_cast<int>(test);
            }
            bool flag = false;
            flag = (bool)env->CallBooleanMethod(jListener, mid_Platform_GetWindowMinimized, platformHandle, platformUserData);
            return flag;
        }
        static void ImGui_Platform_SetWindowTitle(ImGuiViewport* viewport, const char* title) {
            JNIEnv *env = ImGuiHelper::GetEnv();
            int64_t platformHandle = -1;
            int platformUserData = -1;
            if(viewport->PlatformHandle != NULL) {
                platformHandle = *(int64_t*)viewport->PlatformHandle;
            }
            if(viewport->PlatformUserData != NULL) {
                intptr_t test = reinterpret_cast<intptr_t>(viewport->PlatformUserData);
                platformUserData = static_cast<int>(test);
            }
            jstring jTitle = env->NewStringUTF(title);
            env->CallVoidMethod(jListener, mid_Platform_SetWindowTitle, platformHandle, platformUserData, jTitle);
        }
        static void ImGui_Platform_RenderWindow(ImGuiViewport* viewport, void*) {
            JNIEnv *env = ImGuiHelper::GetEnv();
            int64_t platformHandle = -1;
            int platformUserData = -1;
            if(viewport->PlatformHandle != NULL) {
                platformHandle = *(int64_t*)viewport->PlatformHandle;
            }
            if(viewport->PlatformUserData != NULL) {
                intptr_t test = reinterpret_cast<intptr_t>(viewport->PlatformUserData);
                platformUserData = static_cast<int>(test);
            }
            env->CallVoidMethod(jListener, mid_Platform_RenderWindow, platformHandle, platformUserData);
        }
        static void ImGui_Platform_SwapBuffers(ImGuiViewport* viewport, void*) {
            JNIEnv *env = ImGuiHelper::GetEnv();
            int64_t platformHandle = -1;
            int platformUserData = -1;
            if(viewport->PlatformHandle != NULL) {
                platformHandle = *(int64_t*)viewport->PlatformHandle;
            }
            if(viewport->PlatformUserData != NULL) {
                intptr_t test = reinterpret_cast<intptr_t>(viewport->PlatformUserData);
                platformUserData = static_cast<int>(test);
            }
            env->CallVoidMethod(jListener, mid_Platform_SwapBuffers, platformHandle, platformUserData);
        }

        static void ImGui_Renderer_RenderWindow(ImGuiViewport* viewport, void*) {
            JNIEnv *env = ImGuiHelper::GetEnv();
            ImGuiHelper::SetImGuiViewport(env, viewport, jViewport, true);
            env->CallVoidMethod(jListener, mid_Renderer_RenderWindow, jViewport);
        }
    */

    /*[-C++;-NATIVE]
        jListener = env->NewGlobalRef(platformListener);

        {
            jclass cls_platformListener = env->FindClass("com/github/xpenatan/imgui/core/util/ImGuiPlatformListener");
            mid_Platform_CreateWindow = env->GetMethodID(cls_platformListener, "CreateWindow", "(Lcom/github/xpenatan/imgui/core/ImGuiViewport;)V");
            mid_Platform_ShowWindow = env->GetMethodID(cls_platformListener, "ShowWindow", "(JI)V");
            mid_Platform_DestroyWindow = env->GetMethodID(cls_platformListener, "DestroyWindow", "(JI)V");
            mid_Platform_SetWindowPos = env->GetMethodID(cls_platformListener, "SetWindowPos", "(JIFF)V");
            mid_Platform_GetWindowPos = env->GetMethodID(cls_platformListener, "GetWindowPos", "(JI)J");
            mid_Platform_SetWindowSize = env->GetMethodID(cls_platformListener, "SetWindowSize", "(JIFF)V");
            mid_Platform_GetWindowSize = env->GetMethodID(cls_platformListener, "GetWindowSize", "(JI)J");
            mid_Platform_SetWindowFocus = env->GetMethodID(cls_platformListener, "SetWindowFocus", "(JI)V");
            mid_Platform_GetWindowFocus = env->GetMethodID(cls_platformListener, "GetWindowFocus", "(JI)Z");
            mid_Platform_GetWindowMinimized = env->GetMethodID(cls_platformListener, "GetWindowMinimized", "(JI)Z");
            mid_Platform_SetWindowTitle = env->GetMethodID(cls_platformListener, "SetWindowTitle", "(JILjava/lang/String;)V");
            mid_Platform_RenderWindow = env->GetMethodID(cls_platformListener, "PlatformRenderWindow", "(JI)V");
            mid_Platform_SwapBuffers = env->GetMethodID(cls_platformListener, "SwapBuffers", "(JI)V");
            mid_Renderer_RenderWindow = env->GetMethodID(cls_platformListener, "RendererRenderWindow", "(Lcom/github/xpenatan/imgui/core/ImGuiViewport;)V");
        }
        {
            jViewport = env->NewGlobalRef(ImGuiHelper::CreateJImGuiViewport(env));
        }

        ImGui::GetIO().BackendFlags |= ImGuiBackendFlags_PlatformHasViewports;
        ImGui::GetIO().BackendFlags |= ImGuiBackendFlags_RendererHasViewports;

        ImGuiPlatformIO& platform_io = ImGui::GetPlatformIO();
        platform_io.Platform_CreateWindow = ImGui_Platform_CreateWindow;
        platform_io.Platform_DestroyWindow = ImGui_Platform_DestroyWindow;
        platform_io.Platform_ShowWindow = ImGui_Platform_ShowWindow;
        platform_io.Platform_SetWindowPos = ImGui_Platform_SetWindowPos;
        platform_io.Platform_GetWindowPos = ImGui_Platform_GetWindowPos;
        platform_io.Platform_SetWindowSize = ImGui_Platform_SetWindowSize;
        platform_io.Platform_GetWindowSize = ImGui_Platform_GetWindowSize;
        platform_io.Platform_SetWindowFocus = ImGui_Platform_SetWindowFocus;
        platform_io.Platform_GetWindowFocus = ImGui_Platform_GetWindowFocus;
        platform_io.Platform_GetWindowMinimized = ImGui_Platform_GetWindowMinimized;
        platform_io.Platform_SetWindowTitle = ImGui_Platform_SetWindowTitle;
        platform_io.Platform_RenderWindow = ImGui_Platform_RenderWindow;
        platform_io.Platform_SwapBuffers = ImGui_Platform_SwapBuffers;
        platform_io.Renderer_RenderWindow = ImGui_Renderer_RenderWindow;

        ImGuiViewport* main_viewport = ImGui::GetMainViewport();

        int64_t* handler = new int64_t;
        *handler = windowHandle;
        main_viewport->PlatformUserData = (void*)userData;
        main_viewport->PlatformHandle = (void*)handler;
    */
    /*[-teaVM;-NATIVE]
        var test = 100;
    */
    public static native void InitPlatformInterface(ImGuiPlatformListener platformListener, long windowHandle, int userData);

    // Platform Utils

    /*[-C++;-NATIVE]
        ImGuiPlatformIO& platform_io = ImGui::GetPlatformIO();
        platform_io.Monitors.resize(value);
    */
    public static native void PlatformResize(int value);

    /*[-C++;-NATIVE]
        ImGuiPlatformIO& platform_io = ImGui::GetPlatformIO();
        ImGuiPlatformMonitor monitor;
        monitor.MainPos = ImVec2(mainPosX, mainPosY);
        monitor.MainSize = ImVec2(mainSizeX, mainSizeY);
        monitor.WorkPos = ImVec2(workPosX, workPosY);
        monitor.WorkSize = ImVec2(workSizeX, workSizeY);
        monitor.DpiScale = dpiScale;
        platform_io.Monitors.push_back(monitor);
    */
    public static native void AddMonitors(float mainPosX, float mainPosY, float mainSizeX, float mainSizeY, float workPosX, float workPosY, float workSizeX, float workSizeY, float dpiScale) /*-{ }-*/;
}