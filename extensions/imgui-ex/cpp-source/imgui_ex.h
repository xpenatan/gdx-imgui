
#include "imgui.h"
#include "imgui_internal.h"

#pragma once

namespace ImGuiEx
{
	ImGuiStorage* GetImGuiStorage(ImGuiID id);
	ImGuiStorage* GetImGuiStorage(const char* id_str);

	// Table
	float GetTableContentHeight(); // call before moving to the next cell/row
	void CalculateTableRowHeight(); // call before moving to the next cell/row
	float GetTableRowHeight(); // call at the begining of new cell row

};
