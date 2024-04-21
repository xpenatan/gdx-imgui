
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

template<typename TYPE>
class EditTextData
{
public:
	TYPE value;
	char* leftLabel;
	ImU32 leftLabelColor = 0;
	ImU32 leftLabelDragColor = 0;
	char* tooltip;
	float tooltipDelay = 1.00f;

	float v_speed = 1.0f;
	TYPE v_min;
	TYPE v_max;
	float power = 1.0f;
	char* format;
	int maxChar = 30;
	bool isDragging = false;

	EditTextData(char* format = NULL) {
		init(format, NULL, NULL);
	}

	EditTextData(char* format, char* leftLabel, char* tooltip) {
		init(format, leftLabel, tooltip);
	}

	void init(char* format, char* leftLabel, char* tooltip) {
		this->format = format;
		this->leftLabel = leftLabel;
		this->tooltip = tooltip;
	}
};

namespace ImGuiExt
{
	ImGuiStorage* GetImGuiStorage(ImGuiID id);
	ImGuiStorage* GetImGuiStorage(const char* id_str);

	// Table
	float GetTableContentHeight();         // call before moving to the next cell/row
	void CalculateTableRowHeight();        // call before moving to the next cell/row
	float GetTableRowHeight();             // call at the begining of new cell row

};