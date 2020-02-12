
#include "imgui.h"
#include "imgui_internal.h"

#pragma once

template<typename TYPE>
struct EditTextData
{
public:
	char* leftLabel;
	ImU32 leftLabelColor = 0;
	ImU32 leftLabelDragColor = 0;
	char* tooltip;
	float tooltipDelay = 1.00f;

	float v_speed = 1.0f;
	TYPE v_min;
	TYPE v_max;
	float power = 1.0f;
	char* format = "%.3f";

	EditTextData() {
		init(NULL, NULL);
	}
	EditTextData(char* leftLabel, char* tooltip = NULL) {
		init(leftLabel, tooltip);
	}

	void init(char* leftLabel, char* tooltip = NULL) {
		this->leftLabel = leftLabel;
		this->tooltip = tooltip;
	}
};

struct EditTextFloatData : EditTextData<float> {
public:
	EditTextFloatData() {
		init(NULL, NULL);
	}
	EditTextFloatData(char* leftLabel, char* tooltip = NULL) {
		init(leftLabel, tooltip);
	}

	void init(char* leftLabel, char* tooltip = NULL) {
		EditTextData::init(leftLabel, tooltip);
		v_min = 0.0f;
		v_max = 0.0f;
	}
};

namespace ImGuiExt
{
	ImGuiStorage* GetImGuiStorage(ImGuiID id);
	ImGuiStorage* GetImGuiStorage(const char* id_str);

	// Table
	float GetTableContentHeight(); // call before moving to the next cell/row
	void CalculateTableRowHeight(); // call before moving to the next cell/row
	float GetTableRowHeight(); // call at the begining of new cell row

	// Custom Widgets
	int EditTextF(const char* id, int size, void* valueArray, EditTextFloatData* dataArray);
	int EditTextF3(const char* id, float* value01, float* value02, float* value03, EditTextFloatData data01, EditTextFloatData data02, EditTextFloatData data03);
	int EditTextF4(const char* id, float* value01, float* value02, float* value03, float* value04, EditTextFloatData data01, EditTextFloatData data02, EditTextFloatData data03, EditTextFloatData data04);
};
