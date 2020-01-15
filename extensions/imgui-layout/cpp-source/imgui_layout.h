
#include "imgui.h"
#include "imgui_internal.h"

#pragma once

namespace ImLayout
{
	static int WRAP_PARENT = 9999991;
	static int MATCH_PARENT = 9999990;
}

namespace ImGuiEx
{

	static int TOTAL_COLUMNS_KEY = 771;
	static int ROOT_COLUMN_CUR_INDEX = 772;
	static int COLUMN_INDEX = 773;
	static int LINES_POS = 774;
	static int COLUMN_LAYOUT_FULL_SIZE_X = 776; // Calculated by removing spliter space
	static int COLUMN_END_OFFSET_X = 777;
	static int TEMP_COLUMN_END_OFFSET_X = 779;
	static int COLUMN_SPLITTER_WIDTH = 780;
	static int COLUMN_SPLITTER_OFFSET_X = 781; // data saved for each column at line[0]
	static int COLUMN_RESIZING = 782;


	inline void DrawLine(ImDrawList* drawList, const ImVec2& p1, const ImVec2& p2, ImU32 col, float thickness) {
		//ImDrawListFlags_None
		ImDrawListFlags flags = drawList->Flags;
		drawList->Flags = ImDrawListFlags_None;
		//drawList->PathLineTo(p1);
		//drawList->PathLineTo(p2);
		//drawList->PathStroke(col, false, 1);
		

		ImVec2 points[] = {
			p1,
			p2,
		};
		drawList->AddPolyline(points, 2, col, false, 1);
		drawList->Flags = flags;
	}

	inline void drawBoundingBox(float x1, float y1, float x2, float y2, int r, int g, int b, bool clipping = false) {
		ImDrawList* drawList = clipping ? ImGui::GetWindowDrawList() : ImGui::GetForegroundDrawList();
		int color = ImGui::GetColorU32(ImVec4(r / 255.0f, g / 255.0f, b / 255.0f, 50.0f / 255.0f));
		//DrawLine(drawList, ImVec2(x1-1, y1), ImVec2(x2, y1), color, 1);
		//DrawLine(drawList, ImVec2(x2, y1), ImVec2(x2, y2+1), color, 1);
		//DrawLine(drawList, ImVec2(x2, y2), ImVec2(x1-1, y2), color, 1);
		//DrawLine(drawList, ImVec2(x1, y2+1), ImVec2(x1, y1), color, 1);

		drawList->AddRect(ImVec2(x1, y1), ImVec2(x2, y2), color);
	}

	inline void drawBoundingBox(ImVec2 min, ImVec2 max, int r, int g, int b, bool clipping = false) {
		ImGuiEx::drawBoundingBox(min.x, min.y, max.x, max.y, r, g, b, clipping);
	}
};

struct ImGuiLayout
{
public:
	ImGuiID id;
	ImGuiLayout* parentLayout;
	ImVector<ImGuiLayout*> childsLayout;

	bool clipping;
	bool debug;
	bool debugClipping;

	bool isWrapParentX;
	bool isWrapParentY;
	bool isMatchParentX;
	bool isMatchParentY;

	ImGuiStorage map;

	ImVec2 position;                    // Position of the layout
	ImVec2 size;                        // Size of the layout
	//ImVec2 sizeParam;                   // Size parameter used when calling beginLayout
	float paddingLeft;
	float paddingRight;
	float paddingTop;
	float paddingBottom;
	ImVec2 positionContents;            // Position of contents.
	ImVec2 contentSize;                // Size of contents. calculated after the first frame
	ImVec2 clippingMin;
	ImVec2 clippingMax;

	bool error;

	// Window Backup data
	ImGuiWindowTempData DC;
	ImRect WorkRect;
	bool skipping;
	int AutoFitChildAxises;
	ImVec2 Pos;
	ImRect ContentsRegionRect;

	ImGuiLayout(ImGuiID id) {
		this->id = id;
		paddingLeft = 0;
		paddingRight = 0;
		paddingTop = 0;
		paddingBottom = 0;
		clipping = false;
		debugClipping = false;
		debug = false;
		error = false;
		skipping = false;
		isWrapParentX = false;
		isMatchParentX = false;
		isWrapParentY = false;
		isMatchParentY = false;
	}

	bool haveParent() { return parentLayout != NULL; }

	ImVec2 getAbsoluteSize() {
		return ImVec2(position.x + size.x, position.y + size.y);
	}

	ImVec2 getContentSize() {
		return ImVec2(position.x + contentSize.x, position.y + contentSize.y);
	}

	ImVec2 getAbsoluteSizePadding() {
		return ImVec2(position.x + size.x - paddingRight, position.y + size.y - paddingBottom);
	}

	ImVec2 getContentSizePadding() {
		return ImVec2(position.x + contentSize.x + paddingLeft, position.y + contentSize.y);
	}

	ImVec2 getPositionPadding() {
		return ImVec2(position.x + paddingLeft, position.y + paddingTop);
	}

	void drawSizeDebug() {
		// Render layout space
		//Green
		ImGuiEx::drawBoundingBox(position, getAbsoluteSize(), 0, 255, 0);
	}

	inline void drawContentDebug() {
		// Render content space
		// Blue
		ImVec2 max = ImVec2(positionContents.x + contentSize.x, positionContents.y + contentSize.y);
		//ImGuiEx::drawBoundingBox(positionContents, max, 0, 0, 255);
	}

	void drawPaddingAreaDebug() {
		// Render size with padding
		//ImGuiEx::drawBoundingBox(getPositionPadding(), getAbsoluteSizePadding(), 255, 255, 255);
	}

	void drawError() {
		ImGuiEx::drawBoundingBox(position, getAbsoluteSize(), 255, 0, 0, true);
	}
};

struct ImGuiLayoutOptions
{
public:
	bool clipping;
	float paddingLeft;
	float paddingRight;
	float paddingTop;
	float paddingBottom;

	ImGuiLayoutOptions() {
		init(0, 0, 0, 0, true);
	}

	ImGuiLayoutOptions(float paddingLeft, float paddingRight, float paddingTop, float paddingBottom, bool clipping = true) {
		init(paddingLeft, paddingRight, paddingTop, paddingBottom, clipping);
	}

private:
	void init(float paddingLeft, float paddingRight, float paddingTop, float paddingBottom, bool clipping = true) {
		//fix delegating constructors are permitted only in C++11
		this->paddingLeft = paddingLeft;
		this->paddingRight = paddingRight;
		this->paddingTop = paddingTop;
		this->paddingBottom = paddingBottom;
		this->clipping = clipping;
	}
};

struct ImGuiCollapseLayoutOptions: public ImGuiLayoutOptions
{
public:
	float paddingLeft;
	float paddingRight;
	float paddingTop;
	float paddingBottom;
	ImU32 arrowColor;
	ImU32 arrowBackgroundHoveredColor;
	ImU32 arrowBackgroundClickedColor;
	ImU32 frameColor;
	ImU32 borderColor;
	int borderRound;
	int roundingCorners;

	ImGuiCollapseLayoutOptions() {
		paddingLeft = 2;
		paddingRight = 2;
		paddingTop = 2;
		paddingBottom = 2;
		arrowColor = ImGui::GetColorU32(ImVec4(0xFF / 255.0f, 0xFF / 255.0f, 0xFF / 255.0f, 0xFF / 255.0f));
		//arrowBackgroundHoveredColor = ImGui::GetColorU32(ImVec4(0x77 / 255.0f, 0x77 / 255.0f, 0x77 / 255.0f, 0xFF / 255.0f));
		//arrowBackgroundClickedColor = ImGui::GetColorU32(ImVec4(0x55 / 255.0f, 0x55 / 255.0f, 0x55 / 255.0f, 0xFF / 255.0f));
		//frameColor = ImGui::GetColorU32(ImVec4(0x24 / 255.0f, 0x24 / 255.0f, 0x24 / 255.0f, 255 / 255.0f));
		//borderColor = ImGui::GetColorU32(ImVec4(0x40 / 255.0f, 0x40 / 255.0f, 0x49 / 255.0f, 255 / 255.0f));
		borderRound = 4;
		roundingCorners = ImDrawCornerFlags_TopLeft | ImDrawCornerFlags_TopRight;
	}
};

namespace ImGuiEx
{
	void FillWidth(int r = 255, int g = 255, int b = 255, int a = 255, ImVec2 size = ImVec2(ImLayout::MATCH_PARENT, 20));
	void ShowLayoutDebug();
	void ShowLayoutClipping();

	ImGuiStorage* GetImGuiStorage(ImGuiID id);
	ImGuiStorage* GetImGuiStorage(const char* id_str);

	// Layout
	ImVec2 GetLayoutSize();
	void BeginLayoutEx(ImGuiID id);
	void BeginLayoutEx(const char* id);
	bool PrepareLayout(float x1, float y1, float x2, float y2, ImGuiLayoutOptions options = ImGuiLayoutOptions());
	void PrepareLayoutType(float sizeX, float sizeY);
	bool PrepareLayout(float sizeX, float sizeY, ImGuiLayoutOptions options);
	bool BeginLayout(const char* id, float sizeX, float sizeY, ImGuiLayoutOptions options = ImGuiLayoutOptions());
	void EndLayout();
	ImGuiLayout* GetCurrentLayout();

	// Custom Collapse Layout
	bool BeginCollapseLayoutEx(const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options = ImGuiCollapseLayoutOptions());
	void BeginCollapseLayoutEx(bool* isOpen, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options = ImGuiCollapseLayoutOptions());
	bool PrepareCollapseLayout(const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options = ImGuiCollapseLayoutOptions());
	bool BeginCollapseLayout(const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options = ImGuiCollapseLayoutOptions());
	void BeginCollapseLayout(bool* isOpen, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options = ImGuiCollapseLayoutOptions());
	void EndCollapseFrameLayout();
	void EndCollapseLayout();

	// Align view
	void BeginAlign(const char* id, float sizeX, float sizeY, float alignX = 0.0f, float alignY = 0.0f, float offsetX = 0, float offsetY = 0);
	void AlignLayout(float alignX = 0.0f, float alignY = 0.0f, float offsetX = 0, float offsetY = 0);
	void EndAlign();

	// Table
	float GetTableContentHeight(); // call before moving to the next cell/row
	void CalculateTableRowHeight(); // call before moving to the next cell/row
	float getTableRowHeight(); // call at the begining of new cell row

	// Experimental Column. Deprecated.
	float GetColumnPercentage(int columnIdx = -1);
	void BeginColumns(const char* id, int columns);
	void SetColumnWidthOffset(int columnIndex, int offset);
	void SetColumnWidth(int columnIndex, int width);
	void NextColumn();
	void EndColumns();

};
