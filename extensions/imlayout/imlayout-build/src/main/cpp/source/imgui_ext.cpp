#include "imgui_ext.h"
#include "imgui_layout.h"

// ##################################  ImGuiExt  ###############################################

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

		float height = y - table->RowPosY1 - table->RowCellPaddingY - itemSpacingY;

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