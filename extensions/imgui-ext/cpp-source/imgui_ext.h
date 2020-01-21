
#include "imgui.h"
#include "imgui_internal.h"

#pragma once


struct EditTextData
{
public:
	const char* leftLabel;
	ImU32 leftLabelColor = 0;
	const char* tooltip;
	float tooltipDelay = 1.00f;
	EditTextData() {
		this->leftLabel = NULL;
		this->tooltip = NULL;
	}
	EditTextData(const char* leftLabel, const char* tooltip = NULL) {
		this->leftLabel = leftLabel;
		this->tooltip = tooltip;
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
	void EditTextF(const char* id, int size, void* valueArray, EditTextData * dataArray);
	void EditTextF3(const char* id, float* value01, float* value02, float* value03, EditTextData data01, EditTextData data02, EditTextData data03);
	void EditTextF4(const char* id, float* value01, float* value02, float* value03, float* value04, EditTextData data01, EditTextData data02, EditTextData data03, EditTextData data04);

};
