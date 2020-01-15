//extern "C"
//{
#include "imgui.h"
#include "imgui_internal.h"
//}
#include "imgui_layout.h"

//#include <iostream>
//using namespace std;

static ImVector<ImGuiLayout*> layoutStack;

static ImGuiLayout* createOrFind(ImGuiID id) {
	ImGuiContext& g = *GImGui;
	ImGuiLayout* childLayout = NULL;
	childLayout = (ImGuiLayout*)g.WindowsById.GetVoidPtr(id);
	if (childLayout == NULL) {
		childLayout = IM_NEW(ImGuiLayout)(id);
		g.WindowsById.SetVoidPtr(childLayout->id, childLayout);
	}
	return childLayout;
}

static ImGuiLayout* pushLayout(ImGuiID id) {
	ImGuiLayout* parentLayout = NULL;
	if (!layoutStack.empty())
		parentLayout = layoutStack.back();
	ImGuiLayout* childLayout = createOrFind(id);
	childLayout->parentLayout = parentLayout;
	childLayout->childsLayout.clear();
	if (parentLayout != NULL)
		parentLayout->childsLayout.push_back(childLayout);
	layoutStack.push_back(childLayout);
	return childLayout;
}

ImGuiLayout* ImGuiEx::GetCurrentLayout() {
	if (layoutStack.empty())
		return NULL;
	return layoutStack.back();
}

static void popLayout() {
	layoutStack.pop_back();
}

ImGuiStorage* ImGuiEx::GetImGuiStorage(ImGuiID id) {
	ImGuiContext& g = *GImGui;
	ImGuiStorage* childLayout = NULL;
	childLayout = (ImGuiStorage*)g.WindowsById.GetVoidPtr(id);
	if (childLayout == NULL) {
		childLayout = IM_NEW(ImGuiStorage)();
		g.WindowsById.SetVoidPtr(id, childLayout);
	}
	return childLayout;
}

ImGuiStorage* ImGuiEx::GetImGuiStorage(const char* id_str) {
	return ImGuiEx::GetImGuiStorage(ImHashStr(id_str));
}

void ImGuiEx::FillWidth(int r, int g, int b, int a, ImVec2 size) {
	ImU32 bgColor = ImGui::GetColorU32(ImVec4(r / 255.0f, g / 255.0f, b / 255.0f, a / 255.0f));
	ImDrawList* drawList = ImGui::GetWindowDrawList();
	ImVec2 regionMax = ImGui::GetContentRegionAvail();

	float height = regionMax.y;
	float width = ImGui::GetWindowContentRegionWidth();

	ImVec2 cursorPos = ImGui::GetCursorScreenPos();

	if (size.x != ImLayout::MATCH_PARENT && size.x > 0) {
		width = size.x;
	}

	if (size.y != ImLayout::MATCH_PARENT && size.y > 0) {
		height = size.y;
	}
	drawList->AddRectFilled(cursorPos, ImVec2(cursorPos.x + width, cursorPos.y + height), bgColor);

	ImGui::ItemSize(ImVec2(width, height));
}

void ImGuiEx::ShowLayoutDebug() {
	ImGuiLayout* curLayout = ImGuiEx::GetCurrentLayout();
	if (curLayout != NULL) {
		curLayout->debug = true;
	}
}
void ImGuiEx::ShowLayoutClipping() {
	ImGuiLayout* curLayout = ImGuiEx::GetCurrentLayout();
	if (curLayout != NULL) {
		curLayout->debugClipping = true;
	}
}

ImVec2 ImGuiEx::GetLayoutSize() {
	ImGuiLayout* curLayout = ImGuiEx::GetCurrentLayout();
	return curLayout->size;
}

void ImGuiEx::BeginLayoutEx(ImGuiID id)
{
	ImGuiLayout* parentLayout = ImGuiEx::GetCurrentLayout();
	char title[256];
	if (parentLayout)
		ImFormatString(title, IM_ARRAYSIZE(title), "%08X/%08X", parentLayout->id, id);
	else
		ImFormatString(title, IM_ARRAYSIZE(title), "%08X", id);

	pushLayout(ImHashStr(title));
}

void ImGuiEx::BeginLayoutEx(const char* strID)
{
	BeginLayoutEx(ImHashStr(strID));
}

void ImGuiEx::PrepareLayoutType(float sizeX, float sizeY)
{
	ImGuiLayout* curLayout = ImGuiEx::GetCurrentLayout();
	curLayout->isMatchParentX = sizeX == ImLayout::MATCH_PARENT;
	curLayout->isWrapParentX = sizeX == ImLayout::WRAP_PARENT;
	curLayout->isMatchParentY = sizeY == ImLayout::MATCH_PARENT;
	curLayout->isWrapParentY = sizeY == ImLayout::WRAP_PARENT;
}

bool ImGuiEx::PrepareLayout(float sizeX, float sizeY, ImGuiLayoutOptions options)
{
	ImGuiContext& g = *GImGui;
	ImGuiWindow* window = g.CurrentWindow;

	ImVec2 position = window->DC.CursorPos;

	ImGuiEx::PrepareLayoutType(sizeX, sizeY);

	float x2 = position.x + sizeX;
	float y2 = position.y + sizeY;

	return PrepareLayout(position.x, position.y, x2, y2, options);
}

bool ImGuiEx::PrepareLayout(float x1, float y1, float x2, float y2, ImGuiLayoutOptions options)
{
	ImGuiContext& g = *GImGui;
	ImGuiWindow* window = g.CurrentWindow;

	ImGuiLayout* curLayout = ImGuiEx::GetCurrentLayout();
	curLayout->clipping = options.clipping;
	bool ret = true;
	// Update layout

	// Backup windows data
	curLayout->DC = window->DC;
	curLayout->WorkRect = window->WorkRect;
	curLayout->skipping = window->SkipItems;
	curLayout->AutoFitChildAxises = window->AutoFitChildAxises;
	curLayout->Pos = window->Pos;
	curLayout->ContentsRegionRect = window->ContentRegionRect;
	// ******** End Backup windows data

	float sizeX = 0;
	float sizeY = 0;


	curLayout->position.x = x1;
	curLayout->position.y = y1;


	curLayout->paddingLeft = options.paddingLeft;
	curLayout->paddingRight = options.paddingRight;
	curLayout->paddingTop = options.paddingTop;
	curLayout->paddingBottom = options.paddingBottom;


	ImVec2 contentPosition = curLayout->getPositionPadding();

	curLayout->positionContents = curLayout->position;

	const ImVec2 content_avail = ImGui::GetContentRegionAvail();

	if (curLayout->isMatchParentX) {
		float sizeX = ImMax(content_avail.x, 4.0f);
		curLayout->size.x = sizeX;
	}
	else if (!curLayout->isWrapParentX) {
		curLayout->size.x = ImFloor(x2 - x1);
	}

	if (curLayout->isMatchParentY) {
		float sizeY = ImMax(content_avail.y, 4.0f);
		curLayout->size.y = sizeY;
	}
	else if (!curLayout->isWrapParentY) {
		curLayout->size.y = ImFloor(y2 - y1);
	}

	// ***** End Update Layout

	// Write to window object

	window->Pos.x = contentPosition.x;
	window->Pos.y = contentPosition.y;
	window->DC.Indent.x = 0;

	//window->DC.CursorMaxPos.x = contentPosition.x + curLayout->size.x - curLayout->paddingLeft - curLayout->paddingRight;
	//window->DC.CursorMaxPos.y = contentPosition.y + curLayout->size.y - curLayout->paddingTop - curLayout->paddingBottom;
	window->DC.CursorMaxPos.x = contentPosition.x;
	window->DC.CursorMaxPos.y = contentPosition.y;

	window->DC.CursorStartPos.x = contentPosition.x;
	window->DC.CursorStartPos.y = contentPosition.y;

	window->DC.CurrLineSize.y = 0; // necessary to keep position inside layout
	window->DC.CurrLineTextBaseOffset = 0;

	window->DC.CursorPos.x = contentPosition.x;
	window->DC.CursorPos.y = contentPosition.y;

	window->WorkRect.Min.x = contentPosition.x;
	window->WorkRect.Min.y = contentPosition.y;
	window->WorkRect.Max.x = contentPosition.x + curLayout->size.x - curLayout->paddingLeft - curLayout->paddingRight;
	window->WorkRect.Max.y = contentPosition.y + curLayout->size.y - curLayout->paddingTop - curLayout->paddingBottom;

	window->ContentRegionRect.Min.x = contentPosition.x;
	window->ContentRegionRect.Min.y = contentPosition.y;
	window->ContentRegionRect.Max.x = contentPosition.x + curLayout->size.x - curLayout->paddingLeft - curLayout->paddingRight;
	window->ContentRegionRect.Max.y = contentPosition.y + curLayout->size.y - curLayout->paddingTop - curLayout->paddingBottom;

	// ***** End Write to window object
	curLayout->clippingMin = curLayout->getPositionPadding();
	curLayout->clippingMax = curLayout->getAbsoluteSizePadding();

	if (curLayout->clipping)
		ImGui::PushClipRect(curLayout->clippingMin, curLayout->clippingMax, true);

	bool skip_items = false;
	if (window->Collapsed || !window->Active || window->Hidden)
		/* if (window->AutoFitFramesX <= 0 && window->AutoFitFramesY <= 0 && window->HiddenFramesCannotSkipItems <= 0)*/
		skip_items = true;
	window->SkipItems = skip_items;
	ret = !skip_items;
	return true;
}

bool ImGuiEx::BeginLayout(const char* strID, float sizeX, float sizeY, ImGuiLayoutOptions options)
{
	BeginLayoutEx(strID);
	return PrepareLayout(sizeX, sizeY, options);
}

void ImGuiEx::EndLayout()
{
	ImGuiContext& g = *GImGui;
	ImGuiWindow* window = g.CurrentWindow;
	ImGuiLayout* curLayout = ImGuiEx::GetCurrentLayout();
	if (curLayout == NULL)
		return;

	if (curLayout->clipping)
		ImGui::PopClipRect();

	float x = window->DC.CursorPos.x;
	float y = window->DC.CursorPos.y;

	//curLayout->contentSize.x = window->DC.CursorMaxPos.x - x; // dont work with table api but there is no test bug
	//curLayout->contentSize.y = y - curLayout->position.y - g.Style.ItemSpacing.y;
	//curLayout->contentSize.x = x - curLayout->positionContents.x; // werid bug in test but works with table api

	curLayout->contentSize.x = window->DC.CursorMaxPos.x - curLayout->positionContents.x - curLayout->paddingLeft; 
	curLayout->contentSize.y = y - curLayout->positionContents.y - g.Style.ItemSpacing.y;

	// Restore windows data
	window->DC = curLayout->DC;
	window->WorkRect = curLayout->WorkRect;
	window->SkipItems = curLayout->skipping;
	window->AutoFitChildAxises = curLayout->AutoFitChildAxises;
	window->Pos = curLayout->Pos;
	window->ContentRegionRect = curLayout->ContentsRegionRect;
	// ********************

	if (curLayout->isMatchParentX) {
		//sizeItem.x = curLayout->size.x;
		if (curLayout->size.x < curLayout->contentSize.x || curLayout->size.x > curLayout->contentSize.x) {
			//special case where dev used MATCH_CONTENT and WRAP_CONTENT wrong. The parent have a WRAP_CONTENT y size and the child have MATCH_CONTENT y size.
			/* curLayout->error = true;
			sizeItem.x = 10;*/
		}
	}
	else if (curLayout->isWrapParentX)
		curLayout->size.x = curLayout->contentSize.x + curLayout->paddingLeft + curLayout->paddingRight;

	if (curLayout->isMatchParentY) {
		//sizeItem.y = curLayout->size.y;
		if (curLayout->size.y < curLayout->contentSize.y) {
			//special case where dev used MATCH_CONTENT and WRAP_CONTENT wrong. The parent have a WRAP_CONTENT y size and the child have MATCH_CONTENT y size.
			   //curLayout->error = true;
			//sizeItem.y = curLayout->contentSize.y;
		}
	}
	else if (curLayout->isWrapParentY)
		curLayout->size.y = curLayout->contentSize.y + curLayout->paddingBottom;

	ImGui::ItemSize(curLayout->size);

	if (curLayout->debug) {
		curLayout->drawContentDebug();
		curLayout->drawPaddingAreaDebug();
		curLayout->drawSizeDebug();
		curLayout->debug = false;
	}

	if (curLayout->debugClipping) {
		ImGuiEx::drawBoundingBox(curLayout->clippingMin, curLayout->clippingMax, 255, 0, 0);
		curLayout->debugClipping = false;
	}

	if (curLayout->error) {
		curLayout->error = false;
		curLayout->drawError();
	}

	popLayout();
}

static bool renderFrameArrow(bool* value, int arrowColor, int arrowBackgroundHoveredColor, int arrowBackgroundClickedColor)
{
	ImGuiContext& g = *GImGui;
	ImGuiWindow* window = g.CurrentWindow;

	ImDrawList* drawList = ImGui::GetWindowDrawList();
	float getFrameHeight = ImGui::GetFrameHeight();
	float removedSize = 5.5f; // reduce few pixels
	float halfSize = (getFrameHeight) / 2.0f - removedSize;

	ImVec2 vec = ImGui::GetCursorScreenPos();

	float screenPosX = vec.x;
	float screenPosY = vec.y;
	float arrowPaddingLeft = 6;

	float x = screenPosX + halfSize + arrowPaddingLeft;
	float y = screenPosY + getFrameHeight / 2.0f;

	bool hovered = ImGui::IsMouseHoveringRect(ImVec2(x - halfSize - removedSize, y - halfSize - removedSize), ImVec2(x + halfSize + removedSize, y + halfSize + removedSize));
	ImU32 hoveredColor = arrowBackgroundHoveredColor;
	bool isWindowHovered = ImGui::IsWindowHovered();

	if (isWindowHovered) {
		if (hovered) {
			if (ImGui::IsMouseDown(0))
				hoveredColor = arrowBackgroundClickedColor;
			if (ImGui::IsMouseReleased(0))
				* value = !*value;
		}

		if (hovered)
			drawList->AddCircleFilled(ImVec2(x, y), halfSize * 2, hoveredColor);
	}

	float triA_X = 0;
	float triA_Y = 0;
	float triB_X = 0;
	float triB_Y = 0;
	float triC_X = 0;
	float triC_Y = 0;

	if (*value) {
		// arrow down
		float offset = -0.5f;
		triA_X = x - halfSize + offset;
		triA_Y = y - halfSize;
		triB_X = x + halfSize + offset;
		triB_Y = y - halfSize;
		triC_X = x + offset;
		triC_Y = y + halfSize;
	}
	else {
		// arrow right
		triA_X = x - halfSize;
		triA_Y = y - halfSize;
		triB_X = x + halfSize;
		triB_Y = y;
		triC_X = x - halfSize;
		triC_Y = y + halfSize;
	}

	drawList->AddTriangleFilled(ImVec2(triA_X, triA_Y), ImVec2(triB_X, triB_Y), ImVec2(triC_X, triC_Y), arrowColor);

	float bk = g.Style.ItemSpacing.y;
	g.Style.ItemSpacing.y = 0;
	ImGui::ItemSize(ImVec2(halfSize * 2 + 3, getFrameHeight));
	g.Style.ItemSpacing.y = bk;

	return *value;
}

static int OPEN_KEY = 13213;

bool ImGuiEx::PrepareCollapseLayout(const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options)
{
	ImGuiContext& g = *GImGui;
	ImGuiWindow* window = g.CurrentWindow;
	ImDrawList* drawList = window->DrawList;
	ImGuiLayout* rootLayout = ImGuiEx::GetCurrentLayout();

	float frameHeight = ImGui::GetFrameHeight();

	bool flag = rootLayout->map.GetBool(OPEN_KEY, false);
	bool* isOpen = &flag;

	sizeY = *isOpen ? sizeY : ImLayout::WRAP_PARENT;

	ImGuiEx::PrepareLayout(sizeX, sizeY, ImGuiLayoutOptions(1, 1, 1, 1));

	rootLayout->map.SetFloat(120, options.paddingLeft);
	rootLayout->map.SetFloat(121, options.paddingRight);
	rootLayout->map.SetFloat(122, options.paddingTop);
	rootLayout->map.SetFloat(123, options.paddingBottom);

	ImGuiEx::BeginLayout("frame", ImLayout::MATCH_PARENT, frameHeight, ImGuiLayoutOptions(0, 0, 0, 0));
	ImGuiLayout* frameLayout = ImGuiEx::GetCurrentLayout();

	ImVec2 mousePos = ImGui::GetMousePos();

	drawList->AddRectFilled(rootLayout->position, ImVec2(rootLayout->getAbsoluteSize().x, frameLayout->getAbsoluteSize().y), options.frameColor, options.borderRound, options.roundingCorners);

	renderFrameArrow(isOpen, options.arrowColor, options.arrowBackgroundHoveredColor, options.arrowBackgroundClickedColor);

	rootLayout->map.SetBool(OPEN_KEY, *isOpen);

	ImGui::SameLine();

	ImGuiEx::BeginAlign("align", ImLayout::WRAP_PARENT, ImLayout::MATCH_PARENT, 0, 0.5f, 0, 0);

	ImGui::Text(title);

	ImGuiEx::EndAlign();

	ImGui::SameLine();

	return *isOpen;
}

void ImGuiEx::BeginCollapseLayoutEx(bool* isOpen, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options)
{
	ImGuiEx::BeginLayoutEx(title);
	ImGuiLayout* rootLayout = ImGuiEx::GetCurrentLayout();
	rootLayout->map.SetBool(OPEN_KEY, *isOpen);
	bool flag = ImGuiEx::PrepareCollapseLayout(title, sizeX, sizeY, options);
	*isOpen = flag;
}

bool ImGuiEx::BeginCollapseLayoutEx(const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options)
{
	ImGuiEx::BeginLayoutEx(title);
	return ImGuiEx::PrepareCollapseLayout(title, sizeX, sizeY, options);
}

bool ImGuiEx::BeginCollapseLayout(const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options)
{
	bool flag = ImGuiEx::BeginCollapseLayoutEx(title, sizeX, sizeY, options);
	ImGuiEx::EndCollapseFrameLayout();
	return flag;
}

void ImGuiEx::BeginCollapseLayout(bool* isOpen, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options)
{
	ImGuiEx::BeginCollapseLayoutEx(isOpen, title, sizeX, sizeY, options);
	ImGuiEx::EndCollapseFrameLayout();
}

void ImGuiEx::EndCollapseFrameLayout()
{
	ImGuiContext& g = *GImGui;
	float bk = g.Style.ItemSpacing.y;

	g.Style.ItemSpacing.y = 0;
	ImGuiEx::EndLayout(); // end frame
	g.Style.ItemSpacing.y = bk;
	ImGuiLayout* rootLayout = ImGuiEx::GetCurrentLayout();

	float paddingLeft = rootLayout->map.GetFloat(120, 0.0f);
	float paddingRight = rootLayout->map.GetFloat(121, 0.0f);
	float paddingTop = rootLayout->map.GetFloat(122, 0.0f);
	float paddingBottom = rootLayout->map.GetFloat(123, 0.0f);

	ImGuiEx::BeginLayout("content", ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(paddingLeft, paddingRight, paddingTop, paddingBottom));
	ImGuiLayout* collapseLayout = ImGuiEx::GetCurrentLayout();
}

void ImGuiEx::EndCollapseLayout()
{
	ImGuiContext& g = *GImGui;
	ImGuiWindow* window = g.CurrentWindow;
	ImDrawList* drawList = window->DrawList;

	ImU32 borderColor = ImGui::GetColorU32(ImVec4(0x40 / 255.0f, 0x40 / 255.0f, 0x49 / 255.0f, 255 / 255.0f));
	int borderRound = 4;
	int roundingCorners = ImDrawCornerFlags_TopLeft | ImDrawCornerFlags_TopRight;

	ImGuiEx::EndLayout(); // end content

	ImGuiLayout* rootLayout = ImGuiEx::GetCurrentLayout();

	ImGuiEx::EndLayout(); // end root

	ImVec2 borderPosition = rootLayout->position;
	ImVec2 borderSize = rootLayout->getAbsoluteSize();

	drawList->AddRect(borderPosition, borderSize, borderColor, borderRound, roundingCorners, 1.0f);
}

void ImGuiEx::BeginAlign(const char* strID, float sizeX, float sizeY, float alignX, float alignY, float offsetX, float offsetY) {
	ImGuiEx::BeginLayout(strID, sizeX, sizeY, ImGuiLayoutOptions());
	ImGuiEx::AlignLayout(alignX, alignY, offsetX, offsetY);
}

void ImGuiEx::AlignLayout(float alignX, float alignY, float offsetX, float offsetY) {
	ImGuiContext& g = *GImGui;
	ImGuiWindow* window = g.CurrentWindow;
	ImGuiLayout* curLayout = ImGuiEx::GetCurrentLayout();
	if (curLayout == NULL)
		return;

	ImVec2 regionAvail = ImGui::GetContentRegionAvail();
	float totalX = regionAvail.x;
	float totalY = regionAvail.y;

	ImVec2 posPad = curLayout->getPositionPadding();
	ImVec2 absSizePad = curLayout->getAbsoluteSizePadding();

	if (alignX >= 0.0f && curLayout->isWrapParentX == false) {

		float addX = ImFloor((totalX - curLayout->contentSize.x) * alignX);
		float newX = posPad.x + addX + offsetX;
		if (newX < posPad.x) {
			curLayout->error = true;
			newX = posPad.x;
		}
		else if (newX + curLayout->contentSize.x > absSizePad.x) {
			curLayout->error = true;
			newX = absSizePad.x - curLayout->contentSize.x;
		}
		curLayout->positionContents.x = newX;
	}

	if (alignY >= 0.0f && curLayout->isWrapParentY == false) {
		float addY = ImFloor((totalY - curLayout->contentSize.y) * alignY);
		float newY = posPad.y + addY + offsetY;
		if (newY < posPad.y) {
			curLayout->error = true;
			newY = posPad.y;
		}
		else if (newY + curLayout->contentSize.y > absSizePad.y) {
			curLayout->error = true;
			newY = absSizePad.y - curLayout->contentSize.y;
		}
		curLayout->positionContents.y = newY;
	}
	window->DC.CursorMaxPos.x = curLayout->positionContents.x;
	window->DC.CursorMaxPos.y = curLayout->positionContents.y;

	window->DC.CursorStartPos.x = curLayout->positionContents.x;
	window->DC.CursorStartPos.y = curLayout->positionContents.y;

	window->Pos.x = curLayout->positionContents.x;
	window->Pos.y = curLayout->positionContents.y;

	window->DC.CursorPos.x = curLayout->positionContents.x;
	window->DC.CursorPos.y = curLayout->positionContents.y;
}

void ImGuiEx::EndAlign() {
	ImGuiEx::EndLayout();
}

static int TABLE_HEIGHT_KEY = 15000;
static int TABLE_HEIGHT_KEY_AUX = 150;

float ImGuiEx::GetTableContentHeight() {
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

void ImGuiEx::CalculateTableRowHeight() {
	ImGuiContext& g = *GImGui;
	ImGuiTable* table = g.CurrentTable;
	if (table != NULL) {
		float height = ImGuiEx::GetTableContentHeight();
		ImGuiStorage* storage = ImGuiEx::GetImGuiStorage(table->ID);
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

float ImGuiEx::getTableRowHeight() {
	ImGuiContext& g = *GImGui;
	ImGuiTable* table = g.CurrentTable;
	if (table != NULL) {
		ImGuiStorage* storage = ImGuiEx::GetImGuiStorage(table->ID);
		float curHeight = storage->GetFloat(TABLE_HEIGHT_KEY + table->CurrentRow, 0.0F);
		return curHeight;
	}
	return 0;
}

int calculateColumnWidth(int columnIndex, int columnLayoutSizeX, int totalColumns) {

	int toAddMod = columnLayoutSizeX % totalColumns;

	float widthPerColumn = columnLayoutSizeX / totalColumns;

	float widthColumnFix = widthPerColumn + (toAddMod - (columnIndex + 1) >= 0 ? 1 : 0);

	return widthColumnFix;
}

float getPercentageX(float lineMaxPosX, float positionPixelsX)
{
	float x = positionPixelsX / lineMaxPosX; // get percent
	return x;
}

float getValueX(float lineMaxPosX, float x)
{
	float value = (x * lineMaxPosX);
	return round(value);
}

int calculateColumnStartPositionX(ImGuiLayout* firstLineLayout, int columnIndex, int columnLayoutSizeX, int totalColumns, int spitterWidth, bool offsetX = false) {
	if (columnIndex == 0)
		return firstLineLayout->position.x;
	float totalWidth = firstLineLayout->position.x;
	for (int i = 0; i < totalColumns; i++) {
		//int columnStartOffsetX = firstLineLayout->childsLayout[columnIndex]->map.GetInt(COLUMN_START_OFFSET_X, 0);
		//int columnEndOffsetX = firstLineLayout->childsLayout[columnIndex]->map.GetInt(COLUMN_END_OFFSET_X, 0);

		int columnWidth = calculateColumnWidth(i, columnLayoutSizeX, totalColumns);
		totalWidth += columnWidth + spitterWidth;

		if (i + 1 == columnIndex) {
			break;
		}
	}
	return totalWidth;
}

int calculateColumnEndPositionX(ImGuiLayout* firstLineLayout, int columnIndex, int columnLayoutSizeX, int totalColumns, int spitterWidth, bool offsetX = false) {
	float totalWidth = 0;
	for (int i = 0; i < totalColumns; i++) {
		int columnWidth = calculateColumnWidth(i, columnLayoutSizeX, totalColumns);
		float columnEndOffsetPercentageX = firstLineLayout->childsLayout[i]->map.GetFloat(ImGuiEx::COLUMN_END_OFFSET_X, -1);
		if (offsetX && columnEndOffsetPercentageX != -1) {
			float tmpSizeX = getValueX(firstLineLayout->size.x, columnEndOffsetPercentageX) - totalWidth;
			columnWidth = tmpSizeX;
		}
		totalWidth += columnWidth;
		if (i == columnIndex) {
			break;
		}
		totalWidth += spitterWidth;
	}
	return totalWidth;
}

int calculateColumnEndX(ImGuiLayout* firstLineLayout, int columnIndex, int totalColumns, int splitterWidth, bool offsetX = false) {
	// calculae and return the end position of the column
	// offsetX true requires to know the other columns percentage value
	ImGuiLayout* rootLayout = firstLineLayout->parentLayout;
	if (rootLayout == NULL)
		return -1;

	int layoutWidth = firstLineLayout->size.x;
	int layoutWidthFix = (layoutWidth - ((totalColumns - 1) * splitterWidth)); // layoutWidth without spliiterWidth
	float totalWidth = 0;
	bool lastColumn = false;
	for (int i = 0; i < totalColumns; i++) {
		int columnWidth = calculateColumnWidth(i, layoutWidthFix, totalColumns);
		if (offsetX) {
			float columnEndOffsetPercentageX = firstLineLayout->childsLayout[i]->map.GetFloat(ImGuiEx::COLUMN_END_OFFSET_X, -1);
			if (columnEndOffsetPercentageX != -1) {
				float tmpSizeX = getValueX(layoutWidth, columnEndOffsetPercentageX) - totalWidth;
				columnWidth = tmpSizeX;
			}
		}
		lastColumn = i == totalColumns - 1;
		if (lastColumn)
			totalWidth = totalWidth + (layoutWidth - totalWidth);
		else
			totalWidth += columnWidth ;
		if (i == columnIndex)
			break;
		totalWidth += splitterWidth;
	}
	return totalWidth;
}

float getColumnPercent(ImGuiLayout* rootLayout, float columnIdx) {
	ImGuiLayout* firstLineLayout = rootLayout->childsLayout[0];
	int totalColumns = rootLayout->map.GetInt(ImGuiEx::TOTAL_COLUMNS_KEY, 0);
	int splitterWidth = rootLayout->map.GetInt(ImGuiEx::COLUMN_SPLITTER_WIDTH, 0);
	float rootWidth = rootLayout->size.x;
	int columnLayoutSizeX = rootLayout->map.GetInt(ImGuiEx::COLUMN_LAYOUT_FULL_SIZE_X, 0);
	if (columnIdx < 0 || columnIdx >= totalColumns)
		columnIdx = ImGuiEx::GetCurrentLayout()->map.GetInt(ImGuiEx::COLUMN_INDEX, -1);
	float percentage = -1;
	if (columnIdx >= 0 && columnIdx < totalColumns) {
		ImGuiLayout* columnLayout = firstLineLayout->childsLayout[columnIdx];
		percentage = columnLayout->map.GetFloat(ImGuiEx::COLUMN_END_OFFSET_X, -1);
		int testEndX = 0;
		if (percentage == -1) {
			testEndX = calculateColumnEndX(firstLineLayout, columnIdx, totalColumns, splitterWidth, false);
			//testEndX = calculateColumnEndPositionX(firstLineLayout, columnIdx, columnLayoutSizeX, totalColumns, splitterWidth, false) -1;
			percentage = getPercentageX(rootWidth, testEndX);
		}

		float valueX = getValueX(rootWidth, percentage) + rootLayout->position.x;

		//if (columnIdx == 0)
		{
			//cout << "valueX: " << valueX << endl;
			int green = ImGui::GetColorU32(ImVec4(0 / 255.0f, 255 / 255.0f, 0 / 255.0f, 250.0f / 255.0f));
			int red = ImGui::GetColorU32(ImVec4(255 / 255.0f, 0 / 255.0f, 0 / 255.0f, 250.0f / 255.0f));
			ImGui::GetForegroundDrawList()->AddLine(ImVec2(valueX, firstLineLayout->position.y + 5), ImVec2(valueX, firstLineLayout->position.y + 200), green);


			//ImGui::GetForegroundDrawList()->AddLine(ImVec2(columnLayout->position.x , firstLineLayout->position.y + 5), ImVec2(columnLayout->position.x, firstLineLayout->position.y + 200), red);
		}
	}
	return percentage;
}

float ImGuiEx::GetColumnPercentage(int columnIdx) {
	ImGuiLayout* columnLayout = ImGuiEx::GetCurrentLayout();
	ImGuiLayout* lineLayout = columnLayout->parentLayout;
	ImGuiLayout* rootLayout = lineLayout->parentLayout;
	float percentage = getColumnPercent(rootLayout, columnIdx);
	return percentage;
}

void newLine() {
	ImGuiLayout* rootLayout = ImGuiEx::GetCurrentLayout();
	int columnStartIndex = 0;
	rootLayout->map.SetInt(ImGuiEx::ROOT_COLUMN_CUR_INDEX, columnStartIndex);
	int lineCount = rootLayout->map.GetInt(ImGuiEx::LINES_POS, 0);
	ImGuiEx::BeginLayoutEx(lineCount);
	ImGuiEx::ShowLayoutDebug();
	ImGuiEx::PrepareLayout(ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions());
	ImGuiLayout* lineLayout = ImGuiEx::GetCurrentLayout();
	lineCount++;
	rootLayout->map.SetInt(ImGuiEx::LINES_POS, lineCount);
}

float getColumnPosition(ImGuiLayout* firstLineLayout, int columnIndex, bool nextColumnStartPosition) {
	ImGuiLayout* rootLayout = firstLineLayout->parentLayout;
	ImGuiLayout* curColumn = firstLineLayout->childsLayout[columnIndex];
	float deltaX = 0;
	int totalColumns = rootLayout->map.GetInt(ImGuiEx::TOTAL_COLUMNS_KEY, 0);
	float columnWidth = rootLayout->size.x / totalColumns;
	int columnLayoutSizeX = rootLayout->map.GetInt(ImGuiEx::COLUMN_LAYOUT_FULL_SIZE_X, 0);
	int splitterWidth = rootLayout->map.GetInt(ImGuiEx::COLUMN_SPLITTER_WIDTH, 0);
	int testStartX = calculateColumnStartPositionX(firstLineLayout, columnIndex, columnLayoutSizeX, totalColumns, splitterWidth, false) - firstLineLayout->position.x;
	int testEndX = calculateColumnEndPositionX(firstLineLayout, columnIndex, columnLayoutSizeX, totalColumns, splitterWidth, false) - firstLineLayout->position.x;
	float valueStartX = testStartX;
	float valueEndX = testEndX;


	float columnEndOffsetX = curColumn->map.GetFloat(ImGuiEx::COLUMN_END_OFFSET_X, -1); // 0.0 - 1.0

	if (columnEndOffsetX != -1) {
		valueEndX = getValueX(firstLineLayout->size.x, columnEndOffsetX);
	}
	valueStartX = valueEndX + 3;

	float newValueEndX = valueEndX + deltaX;
	float newValueStartX = valueStartX + deltaX;

	//float percentageEndX = getPercentageX(firstLineLayout->size.x, newValueEndX);
	//float percentageStartX = getPercentageX(firstLineLayout->size.x, newValueStartX);

	return nextColumnStartPosition ? newValueStartX : newValueEndX;
}

float getColumnPercentage(ImGuiLayout* firstLineLayout, int columnIndex, bool nextColumnStartPercentage) {
	float value = getColumnPosition(firstLineLayout, columnIndex, nextColumnStartPercentage);
	float percentage = getPercentageX(firstLineLayout->size.x, value);
	return percentage;
}

void newColumn() {
	ImGuiContext& g = *GImGui;
	ImGuiWindow* window = g.CurrentWindow;

	ImGuiLayout* lineLayout = ImGuiEx::GetCurrentLayout();
	ImGuiLayout* rootLayout = lineLayout->parentLayout;
	ImGuiLayout* firstLineLayout = rootLayout->childsLayout[0];
	int columnIndex = rootLayout->map.GetInt(ImGuiEx::ROOT_COLUMN_CUR_INDEX, 0);
	int columnLayoutSizeX = rootLayout->map.GetInt(ImGuiEx::COLUMN_LAYOUT_FULL_SIZE_X, 0);
	int totalColumns = rootLayout->map.GetInt(ImGuiEx::TOTAL_COLUMNS_KEY, 0);
	int originalColumnWidth = calculateColumnWidth(columnIndex, columnLayoutSizeX, totalColumns);

	int splitterWidth = rootLayout->map.GetInt(ImGuiEx::COLUMN_SPLITTER_WIDTH, 0);
	int columnWidth = originalColumnWidth;
	bool isLastColumn = (columnIndex == totalColumns - 1);

	int columnSize = firstLineLayout->childsLayout.size();


	ImGuiEx::BeginLayoutEx(columnIndex);

	ImGuiEx::ShowLayoutDebug();

	rootLayout->map.SetInt(ImGuiEx::ROOT_COLUMN_CUR_INDEX, columnIndex + 1);

	ImGuiLayout* columnLayout = ImGuiEx::GetCurrentLayout();
	ImGuiLayout* leftColumnLayout = NULL;
	if(columnIndex > 0)
		leftColumnLayout = firstLineLayout->childsLayout[columnIndex-1];
	columnLayout->map.SetInt(ImGuiEx::COLUMN_INDEX, columnIndex);
	float columnEndOffsetX = columnLayout->map.GetFloat(ImGuiEx::COLUMN_END_OFFSET_X, -1);
	float tempColumnOffset = columnLayout->map.GetFloat(ImGuiEx::TEMP_COLUMN_END_OFFSET_X, -1);


	float defaultColumnWidth = rootLayout->size.x / totalColumns;

	float height = ImLayout::WRAP_PARENT;
	if (columnLayout->size.y < lineLayout->size.y) {
		//height = lineLayout->size.y;
	}

	if (columnWidth < 0)
		columnWidth = 0;


	float sizeX = columnWidth;
	float sizeY = height;

	ImVec2 position = window->DC.CursorPos;

	ImGuiEx::PrepareLayoutType(sizeX, sizeY);

	float y2 = position.y + sizeY;

	//int coriginalColumnEndX = calculateColumnEndPositionX(firstLineLayout, columnIndex, columnLayoutSizeX, totalColumns, splitterWidth, false) ;
	int coriginalColumnEndX = calculateColumnEndX(firstLineLayout, columnIndex, totalColumns, splitterWidth, false);
	int columnEndX = coriginalColumnEndX + firstLineLayout->position.x;

	if (columnEndOffsetX != -1)
		columnEndX = getValueX(firstLineLayout->size.x, columnEndOffsetX) + firstLineLayout->position.x;

	int color = ImGui::GetColorU32(ImVec4(255 / 255.0f, 0 / 255.0f, 0 / 255.0f, 150.0f / 255.0f));
	int green = ImGui::GetColorU32(ImVec4(0 / 255.0f, 255 / 255.0f, 0 / 255.0f, 250.0f / 255.0f));



	ImGuiEx::PrepareLayout(position.x, position.y, columnEndX, y2, ImGuiLayoutOptions(0, 0, 0, 0));
}

//float val = getValueX(firstLineLayout->size.x, 0.98);
//ImGui::GetForegroundDrawList()->AddLine(ImVec2(coriginalColumnEndX - 1, firstLineLayout->position.y+5), ImVec2(coriginalColumnEndX - 1, firstLineLayout->position.y + 200), color);
//ImGui::GetForegroundDrawList()->AddLine(ImVec2(val - 1, firstLineLayout->position.y+5), ImVec2(val - 1, firstLineLayout->position.y + 200), green);


//ImGui::GetForegroundDrawList()->AddLine(ImVec2(fixedX, firstLineLayout->position.y), ImVec2(fixedX, firstLineLayout->position.y + 200), color);
//ImGui::GetForegroundDrawList()->AddLine(ImVec2(fixedSizeX-1, firstLineLayout->position.y), ImVec2(fixedSizeX-1, firstLineLayout->position.y + 200), color);

//ImGui::GetForegroundDrawList()->AddLine(ImVec2(testStartX, firstLineLayout->position.y), ImVec2(testStartX, firstLineLayout->position.y + 200), color);
//ImGui::GetForegroundDrawList()->AddLine(ImVec2(testEndX - 1, firstLineLayout->position.y), ImVec2(testEndX - 1, firstLineLayout->position.y + 200), color);

//cout << "-----: " << endl;
//cout << "X: " << x << endl;

//ImGui::GetForegroundDrawList()->AddLine(ImVec2(testStartX, firstLineLayout->position.y), ImVec2(testStartX, firstLineLayout->position.y + 200), green);
//if(!isLastColumn)
	//ImGui::GetForegroundDrawList()->AddLine(ImVec2(columnSplitterX -1, firstLineLayout->position.y), ImVec2(columnSplitterX -1, firstLineLayout->position.y + 300), color);

void ImGuiEx::BeginColumns(const char* id, int totalColumns) {
	ImGuiEx::BeginLayoutEx(id);
	ImGuiLayout* rootLayout = ImGuiEx::GetCurrentLayout();
	int splitterWidth = 4;
	rootLayout->map.SetInt(TOTAL_COLUMNS_KEY, totalColumns);
	rootLayout->map.SetInt(COLUMN_SPLITTER_WIDTH, splitterWidth);

	rootLayout->map.SetInt(LINES_POS, 0); // reset line count

	ImGuiEx::PrepareLayout(ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions());
	//ImGuiEx::PrepareLayout(27, ImLayout::WRAP_PARENT, ImGuiLayoutOptions());

	float rootWidth = rootLayout->size.x;

	float initialColumnSize = rootWidth / totalColumns;
	//if (initialColumnSize < 10)
		//initialColumnSize = 10;

	int cWidth = (rootWidth - ((totalColumns - 1) * splitterWidth));

	rootLayout->map.SetInt(COLUMN_LAYOUT_FULL_SIZE_X, cWidth);

	newLine();

	newColumn();
}

void ImGuiEx::NextColumn() {
	ImGuiContext& g = *GImGui;
	ImGuiLayout* lastColumnLayout = ImGuiEx::GetCurrentLayout();


	ImGuiEx::EndLayout();

	ImGuiLayout* lineLayout = ImGuiEx::GetCurrentLayout();

	ImGuiLayout* rootLayout = lineLayout->parentLayout;
	int splitterWidth = rootLayout->map.GetInt(COLUMN_SPLITTER_WIDTH, 0);
	int totalColumns = rootLayout->map.GetInt(TOTAL_COLUMNS_KEY, 0);
	int columnIndex = rootLayout->map.GetInt(ROOT_COLUMN_CUR_INDEX, 0);

	if (columnIndex == totalColumns) {
		ImGuiEx::EndLayout(); // end LineLayout
		ImGui::Separator();
		newLine();
	}
	else {
		ImGui::SameLine(0, splitterWidth);
	}
	newColumn();
}

float getColumnWidth(ImGuiLayout* firstLineLayout, int columnIndex) {
	ImGuiContext& g = *GImGui;
	ImGuiLayout* rootLayout = firstLineLayout->parentLayout;
	ImVector<ImGuiLayout*>& columns = firstLineLayout->childsLayout;
	int totalColumns = rootLayout->map.GetInt(ImGuiEx::TOTAL_COLUMNS_KEY, 0);
	int columnLayoutSizeX = rootLayout->map.GetInt(ImGuiEx::COLUMN_LAYOUT_FULL_SIZE_X, 0);
	int splitterWidth = rootLayout->map.GetInt(ImGuiEx::COLUMN_SPLITTER_WIDTH, 0);

	int testStartX = calculateColumnEndPositionX(firstLineLayout, columnIndex-1, columnLayoutSizeX, totalColumns, splitterWidth, true) + splitterWidth;
	int testEndX = calculateColumnEndPositionX(firstLineLayout, columnIndex, columnLayoutSizeX, totalColumns, splitterWidth, true);



	float left = getColumnPosition(firstLineLayout, columnIndex-1, false);
	float right = getColumnPosition(firstLineLayout, columnIndex, false);
	

	float norm = testEndX - testStartX;

	float norm2 = columns[columnIndex]->size.x;



	float originalColumnPercentageX = columns[columnIndex]->map.GetFloat(ImGuiEx::COLUMN_END_OFFSET_X, -1);
	float columnPercentageX1 = columns[columnIndex-1]->map.GetFloat(ImGuiEx::TEMP_COLUMN_END_OFFSET_X, -1);
	float columnPercentageX2 = columns[columnIndex]->map.GetFloat(ImGuiEx::TEMP_COLUMN_END_OFFSET_X, -1);

	float pos1 = getValueX(firstLineLayout->size.x, columnPercentageX1) ;
	float pos2 = getValueX(firstLineLayout->size.x, columnPercentageX2) ;

	int pos = pos2 - pos1 - splitterWidth;

	//cout << "-------" << endl;
	//cout << "norm: " << norm << endl;
	//cout << "norm2: " << norm2 << endl;
	//cout << "pos: " << pos << endl;
	
	//int testStartX = calculateColumnStartPositionX(firstLineLayout, columnIndex, columnLayoutSizeX, totalColumns, splitterWidth, true);
	//int testEndX = calculateColumnEndPositionX(firstLineLayout, columnIndex, columnLayoutSizeX, totalColumns, splitterWidth, true);
	//float valueStartX = testEndX;
	//float valueEndX = testEndX;
	//float newValueEndX = valueEndX - firstLineLayout->position.x;
	//float newValueStartX = valueStartX - firstLineLayout->position.x;
	return pos;
}

void SetColumnWidthOffset(ImGuiLayout* firstLineLayout, int columnIndex, float offset) {
	ImGuiContext& g = *GImGui;
	ImGuiLayout* rootLayout = firstLineLayout->parentLayout;
	ImGuiLayout* curColumn = firstLineLayout->childsLayout[columnIndex];
	int totalColumns = rootLayout->map.GetInt(ImGuiEx::TOTAL_COLUMNS_KEY, 0);
	int columnLayoutSizeX = rootLayout->map.GetInt(ImGuiEx::COLUMN_LAYOUT_FULL_SIZE_X, 0);
	int splitterWidth = rootLayout->map.GetInt(ImGuiEx::COLUMN_SPLITTER_WIDTH, 0);
	
	//int originalColumnWidth = calculateColumnWidth(columnIndex+1, columnLayoutSizeX, totalColumns);
	bool preserve_width = (columnIndex < totalColumns - 2);
	float width = preserve_width ? getColumnWidth(firstLineLayout, columnIndex + 1) : 0;

	//float tmpV = firstLineLayout->size.x - g.Style.ColumnsMinSpacing * (totalColumns - columnIndex);
	//cout << "columnIndex: " << columnIndex << endl;
	//cout << "width: " << width << endl;
	//cout << "offset: " << offset << endl;
	//offset = ImMin(offset, tmpV);
	float percentageX = getPercentageX(firstLineLayout->size.x, offset);

	float testValue = getValueX(firstLineLayout->size.x, percentageX);

	float newWidth = offset - curColumn->position.x;

	float newOffset = newWidth - curColumn->size.x;

	//if (newOffset != 0) {

		//cout << "-------" << endl;
		//cout << "column_index: " << columnIndex << " offset: " << offset << endl;
		//cout << "newWidth: " << newWidth << endl;
		//cout << "width: " << width << endl;
		//cout << " curColumn->position.x: " <<  curColumn->position.x << endl;
		//cout << "percentageX: " << percentageX << endl;
	//}
	
	curColumn->map.SetFloat(ImGuiEx::COLUMN_END_OFFSET_X, percentageX);


	if (preserve_width)
		SetColumnWidthOffset(firstLineLayout, columnIndex + 1, offset + ImMax(g.Style.ColumnsMinSpacing, width + splitterWidth));
}

void ImGuiEx::SetColumnWidthOffset(int columnIndex, int offset) {
	// Must be called inside a column
	ImGuiLayout* columnLayout = ImGuiEx::GetCurrentLayout();
	ImGuiLayout* lineLayout = columnLayout->parentLayout;
	ImGuiLayout* rootLayout = lineLayout->parentLayout;

	ImGuiLayout* firstLineLayout = rootLayout->childsLayout[0];
	ImGuiLayout* firstColumnLayout = firstLineLayout->childsLayout[columnIndex];
	//firstColumnLayout->map.SetInt(COLUMN_END_OFFSET_X, offset);
}

void ImGuiEx::SetColumnWidth(int columnIndex, int offset) {
	// Must be called inside a column
	//ImGuiLayout* columnLayout = ImGuiEx::GetCurrentLayout();
	//ImGuiLayout* lineLayout = columnLayout->parentLayout;
	//ImGuiLayout* rootLayout = lineLayout->parentLayout;

	//ImGuiLayout* firstLineLayout = rootLayout->childsLayout[0];
	//ImGuiLayout* firstColumnLayout = firstLineLayout->childsLayout[columnIndex];
	//firstColumnLayout->map.SetInt(COLUMN_OFFSET_X, offset);
}



void ImGuiEx::EndColumns() {
	ImGuiContext& g = *GImGui;

	ImGuiLayout* lastColumnLayout = ImGuiEx::GetCurrentLayout();
	ImGuiEx::EndLayout();

	ImGuiLayout* lineLayout = ImGuiEx::GetCurrentLayout();
	ImGuiEx::EndLayout();

	ImGuiLayout* rootLayout = ImGuiEx::GetCurrentLayout();

	ImVector<ImGuiLayout*>& linesLayout = rootLayout->childsLayout;
	int size = linesLayout.size();
	ImGuiLayout* firstLineLayout = linesLayout[0];
	ImVector<ImGuiLayout*>& columns = firstLineLayout->childsLayout;
	ImGuiLayout* dragging_column = NULL;
	int totalColumns = rootLayout->map.GetInt(TOTAL_COLUMNS_KEY, 0);
	float columnWidth = rootLayout->size.x / totalColumns;
	int columnLayoutSizeX = rootLayout->map.GetInt(COLUMN_LAYOUT_FULL_SIZE_X, 0);
	int splitterWidth = rootLayout->map.GetInt(COLUMN_SPLITTER_WIDTH, 0);

	ImGuiLayout* rightColumnLayout = NULL;
	for (int i = columns.size()-1; i >= 0; i--) {
		ImGuiLayout* columnLayout = columns[i];
		ImGuiLayout* rightLayout = NULL;

		if (i + 1 < columns.size())
			rightLayout = firstLineLayout->childsLayout[i + 1];

		if (columns.size() - 1 == i)
			continue;

		float x1 = columnLayout->position.x + columnLayout->size.x -1 + 1;
		float y1 = columnLayout->position.y -1;
		float x2 = columnLayout->position.x + columnLayout->size.x -1 + 1;
		float y2 = columnLayout->position.y + rootLayout->size.y -1;



		int offset = (int)(splitterWidth / 2);
		int color = ImGui::GetColorU32(ImVec4(255 / 255.0f, 255 / 255.0f, 255 / 255.0f, 205.0f / 255.0f));
		ImGui::GetWindowDrawList()->AddLine(ImVec2(x1 + offset, y1), ImVec2(x2 + offset, y2), color);

		bool hovered = false, held = false;
		int column_id = columnLayout->id + i + 100;
		ImGui::KeepAliveID(column_id);

		ImRect column_hit_rect(ImVec2(x1, y1), ImVec2(x2 + splitterWidth, y2));
		ImGui::ButtonBehavior(column_hit_rect, column_id, &hovered, &held, ImGuiButtonFlags_FlattenChildren | ImGuiButtonFlags_AllowItemOverlap);
		if (hovered || held)
			g.MouseCursor = ImGuiMouseCursor_ResizeEW;
		if (held) {
			dragging_column = columnLayout;
			rightColumnLayout = rightLayout;
		}
	}

	//float getPercentageX(float lineMaxPosX, float positionPixelsX)
	//float getValueX(float x, float lineMaxPosX)

	bool beingResized = false;

	if (dragging_column != NULL) {
		float columnIndex = dragging_column->map.GetInt(COLUMN_INDEX, -1);
		int testStartX = calculateColumnStartPositionX(firstLineLayout, columnIndex, columnLayoutSizeX, totalColumns, splitterWidth, false);
		int testEndX = calculateColumnEndPositionX(firstLineLayout, columnIndex, columnLayoutSizeX, totalColumns, splitterWidth, false) + firstLineLayout->position.x;
		float valueStartX = testEndX;
		float valueEndX = testEndX;


		float columnEndOffsetX = dragging_column->map.GetFloat(COLUMN_END_OFFSET_X, -1); // 0.0 - 1.0

		if (columnEndOffsetX != -1) {
			valueEndX = getValueX(firstLineLayout->size.x, columnEndOffsetX) + firstLineLayout->position.x;
		}
		valueStartX = valueEndX + 3;


		float deltaX = g.IO.MouseDelta.x;

		float newValueEndX = valueEndX + deltaX - firstLineLayout->position.x;
		float newValueStartX = valueStartX + deltaX - firstLineLayout->position.x;

		float percentageEndX = getPercentageX(firstLineLayout->size.x, newValueEndX);
		float percentageStartX = getPercentageX(firstLineLayout->size.x, newValueStartX);

		//if (newValueEndX >= 0.0f && newValueEndX + splitterWidth-2 < firstLineLayout->size.x) {
			//std::cout << "------: " << std::endl;
			//std::cout << "firstLineLayout->size.x: " << firstLineLayout->size.x << std::endl;
			//std::cout << "newValueEndX: " << newValueEndX << std::endl;
			//std::cout << "percentageEndX 1: " << percentageEndX << std::endl;
			//dragging_column->map.SetFloat(COLUMN_END_OFFSET_X, percentageEndX);

		int add = 0;

	

		bool resizing = rootLayout->map.GetBool(ImGuiEx::COLUMN_RESIZING, false);

		if (!resizing) {
			for (int i = 0; i < columns.size(); i++) {
				ImGuiLayout* columnLayout = columns[i];
				add += columnLayout->size.x;
				float columnEndOffsetPercentageX = getPercentageX(firstLineLayout->size.x, add);
				add += splitterWidth;
				columnLayout->map.SetFloat(ImGuiEx::TEMP_COLUMN_END_OFFSET_X, columnEndOffsetPercentageX);
			}
			rootLayout->map.SetBool(ImGuiEx::COLUMN_RESIZING, true);
		}

			SetColumnWidthOffset(firstLineLayout, columnIndex, newValueEndX);
;
		//}
	}
	else {
		rootLayout->map.SetBool(ImGuiEx::COLUMN_RESIZING, false);
	}



	ImGuiEx::EndLayout();
}
