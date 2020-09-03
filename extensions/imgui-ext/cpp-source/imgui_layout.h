
#pragma once

#include "imgui.h"
#include "imgui_internal.h"

namespace ImLayout
{
	static int WRAP_PARENT = 9999991;
	static int MATCH_PARENT = 9999990;
}

namespace ImGuiExt
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
};

struct ImGuiLayout
{
public:
	ImGuiStorage map;

	ImVec2 position;                    // Position of the layout
	ImVec2 size;                        // Size of the layout
	float paddingLeft;
	float paddingRight;
	float paddingTop;
	float paddingBottom;
	ImVec2 positionContents;           // Contents start position
	ImVec2 contentSize;                // Contents size. Calculated after the first iteration
	ImVec2 clippingMin;                // Clipping min position
	ImVec2 clippingMax;                // Clipping max position

	bool error;

	// Intenral attributes

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

	// Backup window data
	ImGuiWindowTempData DC;
	ImRect WorkRect;
	bool skipping;
	int AutoFitChildAxises;
	ImVec2 Pos;
	ImRect ContentsRegionRect;

	ImGuiLayout(ImGuiID id);
	bool haveParent();
	ImVec2 getAbsoluteSize();
	ImVec2 getContentSize();
	ImVec2 getAbsoluteSizePadding();
	ImVec2 getContentSizePadding();
	ImVec2 getPositionPadding();
	void drawSizeDebug();
	void drawContentDebug();
	void drawPaddingAreaDebug();
	void drawError();
};

struct ImGuiLayoutOptions
{
public:
	bool clipping;
	float paddingLeft;
	float paddingRight;
	float paddingTop;
	float paddingBottom;

	ImGuiLayoutOptions();
	ImGuiLayoutOptions(float paddingLeft, float paddingRight, float paddingTop, float paddingBottom, bool clipping = true);
	void init(float paddingLeft, float paddingRight, float paddingTop, float paddingBottom, bool clipping = true);
};

struct ImGuiCollapseLayoutOptions: public ImGuiLayoutOptions
{
public:
	ImU32 arrowColor;
	ImU32 arrowBackgroundHoveredColor;
	ImU32 arrowBackgroundClickedColor;
	ImU32 frameColor;
	ImU32 borderColor;
	int borderRound;
	int roundingCorners;

	ImGuiCollapseLayoutOptions();
	ImGuiCollapseLayoutOptions(float paddingLeft, float paddingRight, float paddingTop, float paddingBottom);
	void init();
};

namespace ImGuiExt
{
	void DrawBoundingBox(float x1, float y1, float x2, float y2, int r, int g, int b, int a = 50, bool clipping = false);
	void DrawBoundingBox(ImVec2 min, ImVec2 max, int r, int g, int b, int a = 50, bool clipping = false);

	void FillWidth(int r = 255, int g = 255, int b = 255, int a = 255, ImVec2 size = ImVec2(ImLayout::MATCH_PARENT, 20));
	void ShowLayoutDebug();
	void ShowLayoutDebugClipping();

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

	// Align view
	void BeginAlign(const char* id, float sizeX, float sizeY, float alignX = 0.0f, float alignY = 0.0f, float offsetX = 0, float offsetY = 0, ImGuiLayoutOptions options = ImGuiLayoutOptions());
	void AlignLayout(float alignX = 0.0f, float alignY = 0.0f, float offsetX = 0, float offsetY = 0);
	void EndAlign();

	// Custom Collapse Layout
	bool BeginCollapseLayoutEx(const char* id, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options = ImGuiCollapseLayoutOptions());
	void BeginCollapseLayoutEx(const char* id, bool* isOpen, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options = ImGuiCollapseLayoutOptions());
	bool PrepareCollapseLayout(const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options = ImGuiCollapseLayoutOptions());
	bool BeginCollapseLayout(const char* id, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options = ImGuiCollapseLayoutOptions());
	void BeginCollapseLayout(const char* id, bool* isOpen, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options = ImGuiCollapseLayoutOptions());
	void EndCollapseFrameLayout();
	void EndCollapseLayout();

	// Calculate content size
	void BeginBoundingBox();  // Its the same as using Begin/End group and getting the LastItemRect values
	ImRect EndBoundingBox();  // Its the same as using Begin/End group and getting the LastItemRect values
};
