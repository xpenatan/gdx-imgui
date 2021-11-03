package com.github.xpenatan.imgui.jnicode;

import com.github.xpenatan.imgui.util.ImGuiPlatformListener;

public class ImGuiPlatformNative {

		/*JNI
		#include "imgui_helper.h"

		#include <imgui.h>
		#include <cstring>
		#if defined(_MSC_VER) && _MSC_VER <= 1500 // MSVC 2008 or earlier
		#include <stddef.h>     // intptr_t
		#else
		#include <stdint.h>     // intptr_t
		#endif

		#include <iostream>

		static jobject jListener;


		jmethodID mid_CreateWindow;
		jmethodID mid_ShowWindow;
		jmethodID mid_DestroyWindow;
		jmethodID mid_SetWindowPos;
		jmethodID mid_GetWindowPos;
		jmethodID mid_SetWindowSize;
		jmethodID mid_GetWindowSize;
		jmethodID mid_SetWindowFocus;
		jmethodID mid_GetWindowFocus;
		jmethodID mid_GetWindowMinimized;
		jmethodID mid_SetWindowTitle;
		jmethodID mid_RenderWindow;
		jmethodID mid_SwapBuffers;

	*/

		/*JNI
		static void ImGui_CreateWindow(ImGuiViewport* viewport) {
			JNIEnv *env = ImGuiHelper::GetEnv();
			env->CallVoidMethod(jListener, mid_CreateWindow);
		}
		static void ImGui_ShowWindow(ImGuiViewport* viewport) {
			JNIEnv *env = ImGuiHelper::GetEnv();
			env->CallVoidMethod(jListener, mid_ShowWindow);
		}
		static void ImGui_DestroyWindow(ImGuiViewport* viewport) {
			JNIEnv *env = ImGuiHelper::GetEnv();
			env->CallVoidMethod(jListener, mid_DestroyWindow);
		}
		static void ImGui_SetWindowPos(ImGuiViewport* viewport, ImVec2 pos) {
			JNIEnv *env = ImGuiHelper::GetEnv();
			env->CallVoidMethod(jListener, mid_SetWindowPos);
		}
		static ImVec2 ImGui_GetWindowPos(ImGuiViewport* viewport) {
			JNIEnv *env = ImGuiHelper::GetEnv();
			jobject jImVec2 = env->CallObjectMethod(jListener, mid_GetWindowPos);
			ImVec2 vec2 = ImVec2();
			ImGuiHelper::SetImVec2(env, jImVec2, &vec2);
			return vec2;
		}
		static void ImGui_SetWindowSize(ImGuiViewport* viewport, ImVec2 size) {
			JNIEnv *env = ImGuiHelper::GetEnv();
			env->CallVoidMethod(jListener, mid_SetWindowSize);
		}
		static ImVec2 ImGui_GetWindowSize(ImGuiViewport* viewport) {
			JNIEnv *env = ImGuiHelper::GetEnv();
			jobject jImVec2 = env->CallObjectMethod(jListener, mid_GetWindowSize);
			ImVec2 vec2 = ImVec2();
			ImGuiHelper::SetImVec2(env, jImVec2, &vec2);
			return vec2;
		}
		static void ImGui_SetWindowFocus(ImGuiViewport* viewport) {
			JNIEnv *env = ImGuiHelper::GetEnv();
			env->CallVoidMethod(jListener, mid_SetWindowFocus);
		}
		static bool ImGui_GetWindowFocus(ImGuiViewport* viewport) {
			JNIEnv *env = ImGuiHelper::GetEnv();
			bool flag = (bool)env->CallBooleanMethod(jListener, mid_GetWindowFocus);
			return flag;
		}
		static bool ImGui_GetWindowMinimized(ImGuiViewport* viewport) {
			JNIEnv *env = ImGuiHelper::GetEnv();
			bool flag = (bool)env->CallBooleanMethod(jListener, mid_GetWindowMinimized);
			return flag;
		}
		static void ImGui_SetWindowTitle(ImGuiViewport* viewport, const char* title) {
			JNIEnv *env = ImGuiHelper::GetEnv();
			env->CallVoidMethod(jListener, mid_SetWindowTitle);
		}
		static void ImGui_RenderWindow(ImGuiViewport* viewport, void*) {
			JNIEnv *env = ImGuiHelper::GetEnv();
			env->CallVoidMethod(jListener, mid_RenderWindow);
		}
		static void ImGui_SwapBuffers(ImGuiViewport* viewport, void*) {
			JNIEnv *env = ImGuiHelper::GetEnv();
			env->CallVoidMethod(jListener, mid_SwapBuffers);
		}
	 */

    public static native void InitPlatformInterface(ImGuiPlatformListener platformListener, long windowHandle, Object userData) /*-{ }-*/; /*
		jListener = env->NewGlobalRef(platformListener);

		jclass cls_platformListener = env->FindClass("com/github/xpenatan/imgui/util/ImGuiPlatformListener");

		mid_CreateWindow = env->GetMethodID(cls_platformListener, "CreateWindow", "()V");
		mid_ShowWindow = env->GetMethodID(cls_platformListener, "ShowWindow", "()V");
		mid_DestroyWindow = env->GetMethodID(cls_platformListener, "DestroyWindow", "()V");
		mid_SetWindowPos = env->GetMethodID(cls_platformListener, "SetWindowSize", "()V");
		mid_GetWindowPos = env->GetMethodID(cls_platformListener, "GetWindowPos", "()Lcom/github/xpenatan/imgui/ImVec2;");
		mid_SetWindowSize = env->GetMethodID(cls_platformListener, "SetWindowSize", "()V");
		mid_GetWindowSize = env->GetMethodID(cls_platformListener, "GetWindowSize", "()Lcom/github/xpenatan/imgui/ImVec2;");
		mid_SetWindowFocus = env->GetMethodID(cls_platformListener, "SetWindowFocus", "()V");
		mid_GetWindowFocus = env->GetMethodID(cls_platformListener, "GetWindowFocus", "()Z");
		mid_GetWindowMinimized = env->GetMethodID(cls_platformListener, "GetWindowMinimized", "()Z");
		mid_SetWindowTitle = env->GetMethodID(cls_platformListener, "SetWindowTitle", "()V");
		mid_RenderWindow = env->GetMethodID(cls_platformListener, "RenderWindow", "()V");
		mid_SwapBuffers = env->GetMethodID(cls_platformListener, "SwapBuffers", "()V");

		ImGui::GetIO().BackendFlags |= ImGuiBackendFlags_PlatformHasViewports;
		ImGui::GetIO().BackendFlags |= ImGuiBackendFlags_RendererHasViewports;

		ImGuiPlatformIO& platform_io = ImGui::GetPlatformIO();
		platform_io.Platform_CreateWindow = ImGui_CreateWindow;
		platform_io.Platform_DestroyWindow = ImGui_DestroyWindow;
		platform_io.Platform_ShowWindow = ImGui_ShowWindow;
		platform_io.Platform_SetWindowPos = ImGui_SetWindowPos;
		platform_io.Platform_GetWindowPos = ImGui_GetWindowPos;
		platform_io.Platform_SetWindowSize = ImGui_SetWindowSize;
		platform_io.Platform_GetWindowSize = ImGui_GetWindowSize;
		platform_io.Platform_SetWindowFocus = ImGui_SetWindowFocus;
		platform_io.Platform_GetWindowFocus = ImGui_GetWindowFocus;
		platform_io.Platform_GetWindowMinimized = ImGui_GetWindowMinimized;
		platform_io.Platform_SetWindowTitle = ImGui_SetWindowTitle;
		platform_io.Platform_RenderWindow = ImGui_RenderWindow;
		platform_io.Platform_SwapBuffers = ImGui_SwapBuffers;

		ImGuiViewport* main_viewport = ImGui::GetMainViewport();
		main_viewport->PlatformUserData = userData;
		main_viewport->PlatformHandle = (void*)windowHandle;
	*/

	// Platform Utils

	public static native void PlatformResize(int value) /*-{ }-*/; /*
		ImGuiPlatformIO& platform_io = ImGui::GetPlatformIO();
		platform_io.Monitors.resize(value);
	*/

	public static native void AddMonitors(float mainPosX, float mainPosY, float mainSizeX, float mainSizeY, float workPosX, float workPosY, float workSizeX, float workSizeY, float dpiScale) /*-{ }-*/; /*
		ImGuiPlatformIO& platform_io = ImGui::GetPlatformIO();
		ImGuiPlatformMonitor monitor;
		monitor.MainPos = ImVec2(mainPosX, mainPosY);
		monitor.MainSize = ImVec2(mainSizeX, mainSizeY);
		monitor.WorkPos = ImVec2(workPosX, workPosY);
		monitor.WorkSize = ImVec2(workSizeX, workSizeY);
		monitor.DpiScale = dpiScale;
		platform_io.Monitors.push_back(monitor);
	*/
}