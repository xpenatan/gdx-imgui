#pragma once

#include "imgui.h"
#include "imgui_internal.h"

#if defined(_MSC_VER) && _MSC_VER <= 1500 // MSVC 2008 or earlier
#include <stddef.h>     // intptr_t
#include <string>     // string
#else
#include <stdint.h>     // intptr_t
#include <string>     // string
#endif

namespace ImGuiExt
{
	bool InputText(const char* label, char* buf, size_t buf_size, ImGuiInputTextFlags flags = 0, ImGuiInputTextCallback callback = NULL, void* user_data = NULL);
	bool InputScalar(const char* label, ImGuiDataType data_type, void* p_data, const void* p_step = NULL, const void* p_step_fast = NULL, const char* format = NULL, ImGuiInputTextFlags flags = 0);
	
	// Small change to set text in another frame so unfocusing a input text will set the buffer. The only changes are in comment "#### CHANGED HERE"
	bool InputTextEx(const char* label, const char* hint, char* buf, int buf_size, const ImVec2& size_arg, ImGuiInputTextFlags flags, ImGuiInputTextCallback callback = NULL, void* user_data = NULL);
};