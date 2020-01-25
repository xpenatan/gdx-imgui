#include "imgui.h"
#include "imgui_internal.h"
#include "imgui_ext.h"

#if defined(_MSC_VER) && _MSC_VER <= 1500 // MSVC 2008 or earlier
#include <stddef.h>     // intptr_t
#else
#include <stdint.h>     // intptr_t
#endif

ImGuiStorage* ImGuiExt::GetImGuiStorage(ImGuiID id) {
	ImGuiContext& g = *GImGui;
	ImGuiStorage* childLayout = NULL;
	childLayout = (ImGuiStorage*)g.WindowsById.GetVoidPtr(id);
	if (childLayout == NULL) {
		childLayout = IM_NEW(ImGuiStorage)();
		g.WindowsById.SetVoidPtr(id, childLayout);
	}
	return childLayout;
}

ImGuiStorage* ImGuiExt::GetImGuiStorage(const char* id_str) {
	return ImGuiExt::GetImGuiStorage(ImHashStr(id_str));
}

static int TABLE_HEIGHT_KEY = 15000;
static int TABLE_HEIGHT_KEY_AUX = 150;

float ImGuiExt::GetTableContentHeight() {
	ImGuiContext& g = *GImGui;
	ImGuiTable* table = g.CurrentTable;
	if (table != NULL) {
		ImGuiWindow* window = table->InnerWindow;
		float y = window->DC.CursorPos.y;
		float itemSpacingY = g.Style.ItemSpacing.y;

		float height = y - table->RowPosY1 - table->CellPaddingY - itemSpacingY;

		return height;
	}
	return 0;
}

void ImGuiExt::CalculateTableRowHeight() {
	ImGuiContext& g = *GImGui;
	ImGuiTable* table = g.CurrentTable;
	if (table != NULL) {
		float height = ImGuiExt::GetTableContentHeight();
		ImGuiStorage* storage = ImGuiExt::GetImGuiStorage(table->ID);
		int column = table->CurrentColumn;
		bool lastColumn = (column == table->ColumnsCount -1);
		int row = table->CurrentRow;
		float tempHeight = storage->GetFloat(TABLE_HEIGHT_KEY_AUX + row, 0.0F);
		if (column == 0)
			tempHeight = 0;
		if (height > tempHeight) {
			tempHeight = height;
			storage->SetFloat(TABLE_HEIGHT_KEY_AUX + row, tempHeight);
		}
		float curHeight = storage->GetFloat(TABLE_HEIGHT_KEY + row, 0.0F);
		float updateHeight = -1;
		if (height > curHeight)
			updateHeight = height;
		if (lastColumn && curHeight != tempHeight)
			updateHeight = tempHeight;  // if a view update its height it will update the new row height
		if(updateHeight >= 0 )
			storage->SetFloat(TABLE_HEIGHT_KEY + row, updateHeight);
	}
}

float ImGuiExt::GetTableRowHeight() {
	ImGuiContext& g = *GImGui;
	ImGuiTable* table = g.CurrentTable;
	if (table != NULL) {
		ImGuiStorage* storage = ImGuiExt::GetImGuiStorage(table->ID);
		float curHeight = storage->GetFloat(TABLE_HEIGHT_KEY + table->CurrentRow, 0.0F);
		return curHeight;
	}
	return 0;
}

static void singleEdittext(const int id, float* valueF, int * valueI, EditTextData data) {
	ImGuiContext& g = *GImGui;
	ImGui::PushID(id);
	ImGui::BeginGroup();

	if (data.leftLabel != NULL) {
		ImGui::AlignTextToFramePadding();
		if (data.leftLabelColor != 0)
			ImGui::PushStyleColor(ImGuiCol_Text, data.leftLabelColor);
		ImGui::Text(data.leftLabel);
		if (data.leftLabelColor != 0)
			ImGui::PopStyleColor();
		ImGui::SameLine(0, 0);
	}
	ImGui::SetNextItemWidth(-1);

	ImGui::DragFloat("", valueF, 0.01f, 0, 0, "%.3f");

	ImGui::EndGroup();

	if (ImGui::IsItemHovered() && data.tooltip != NULL && g.HoveredIdTimer > data.tooltipDelay) {
		ImGui::BeginTooltip();
		ImGui::SetTooltip(data.tooltip);
		ImGui::EndTooltip();
	}
	ImGui::PopID();
}

void ImGuiExt::EditTextF(const char* id, int size, void * valueArray, EditTextData* dataArray) {
	int flags = ImGuiTableFlags_BordersVFullHeight | ImGuiTableFlags_Resizable | ImGuiTableFlags_Reorderable;
	if (ImGui::BeginTable(id, size, flags)) {
		for (int i = 0; i < size; i++) {
			ImGui::TableNextCell();
			intptr_t* arr = (intptr_t*)valueArray;
			float * realPointer = (float*)arr[i];
			singleEdittext(i, realPointer, NULL, dataArray[i]);
		}
		ImGui::EndTable();
	}
}

void ImGuiExt::EditTextF3(const char* id, float* value01, float* value02, float* value03, EditTextData data01, EditTextData data02, EditTextData data03) {
	intptr_t values[3];
	EditTextData datas[3];
	values[0] = (intptr_t)value01;
	values[1] = (intptr_t)value02;
	values[2] = (intptr_t)value03;
	datas[0] = data01;
	datas[1] = data02;
	datas[2] = data03;
	ImGuiExt::EditTextF(id, 3, values, datas);
}

void ImGuiExt::EditTextF4(const char* id, float* value01, float* value02, float* value03, float* value04, EditTextData data01, EditTextData data02, EditTextData data03, EditTextData data04) {
	//ImGui::PushStyleVar(ImGuiStyleVar_CellPadding, ImVec2(0, 0));
	intptr_t values[4];
	EditTextData datas[4];
	values[0] = (intptr_t)value01;
	values[1] = (intptr_t)value02;
	values[2] = (intptr_t)value03;
	values[3] = (intptr_t)value04;
	datas[0] = data01;
	datas[1] = data02;
	datas[2] = data03;
	datas[3] = data04;
	ImGuiExt::EditTextF(id, 4, values, datas);
	//ImGui::PopStyleVar();
}