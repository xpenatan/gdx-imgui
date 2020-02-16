
#include "imgui.h"
#include "imgui_internal.h"

#pragma once


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

	// Custom Widgets
	template<typename TYPE>
	int EditText(const char* id, int size, ImGuiDataType data_type, intptr_t* dataArray);
	int EditTextI(const char* id, EditTextData<int>* data01, EditTextData<int>* data02 = NULL, EditTextData<int>* data03 = NULL, EditTextData<int>* data04 = NULL);
	int EditTextF(const char* id, EditTextData<float>* data01, EditTextData<float>* data02 = NULL, EditTextData<float>* data03 = NULL, EditTextData<float>* data04 = NULL);
};