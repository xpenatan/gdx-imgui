
#pragma once

#include "imgui.h"
#include "imgui_internal.h"


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
    bool openDefault;

    ImGuiCollapseLayoutOptions();
    ImGuiCollapseLayoutOptions(float paddingLeft, float paddingRight, float paddingTop, float paddingBottom);
    void init();
};

class ImLayout {
    // Emscripten webidl don't support binding methods without a class so we need to create a wrapper
public:
    static const int WRAP_PARENT = 9999991;
    static const int MATCH_PARENT = 9999990;

    static void DrawBoundingBox_1(float x1, float y1, float x2, float y2, int r, int g, int b, int a = 50, bool clipping = false);
    static void DrawBoundingBox_2(ImVec2 min, ImVec2 max, int r, int g, int b, int a = 50, bool clipping = false);
    static void DrawBoundingBox_3(ImRect rect, int r, int g, int b, int a = 50, bool clipping = false);

    static void FillWidth(int r = 255, int g = 255, int b = 255, int a = 255, ImVec2 size = ImVec2(ImLayout::MATCH_PARENT, 20));
    static void ShowLayoutDebug();
    static void ShowLayoutDebugClipping();

    // Layout
    static ImVec2 GetLayoutSize();
    static void BeginLayoutEx(ImGuiID id);
    static void BeginLayoutEx(const char* id);
    static bool PrepareLayout(float x1, float y1, float x2, float y2, ImGuiLayoutOptions options = ImGuiLayoutOptions());
    static void PrepareLayoutType(float sizeX, float sizeY);
    static bool PrepareLayout(float sizeX, float sizeY, ImGuiLayoutOptions options);
    static bool BeginLayout(const char* id, float sizeX, float sizeY);
    static bool BeginLayout(const char* id, float sizeX, float sizeY, ImGuiLayoutOptions & options);
    static void EndLayout();
    static ImGuiLayout* GetCurrentLayout();

    // Align view
    static void BeginAlign(const char* id, float sizeX, float sizeY, float alignX = 0.0f, float alignY = 0.0f, float offsetX = 0, float offsetY = 0, ImGuiLayoutOptions options = ImGuiLayoutOptions());
    static void AlignLayout(float alignX = 0.0f, float alignY = 0.0f, float offsetX = 0, float offsetY = 0);
    static void EndAlign();

    // Custom Collapse Layout
    static bool BeginCollapseLayoutEx(const char* id, const char* title, float sizeX, float sizeY);
    static bool BeginCollapseLayoutEx(const char* id, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions & options);

    static bool BeginCollapseLayoutEx_2(int id, const char* title, float sizeX, float sizeY);
    static bool BeginCollapseLayoutEx_2(int id, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions & options);

    static void BeginCollapseLayoutEx_3(const char* id, bool* isOpen, const char* title, float sizeX, float sizeY);
    static void BeginCollapseLayoutEx_3(const char* id, bool* isOpen, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions & options);
    static bool PrepareCollapseLayout(const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options = ImGuiCollapseLayoutOptions());

    static bool BeginCollapseLayout(const char* id, const char* title, float sizeX, float sizeY);
    static bool BeginCollapseLayout(const char* id, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions & options);

    static void BeginCollapseLayout_2(const char* id, bool* isOpen, const char* title, float sizeX, float sizeY);
    static void BeginCollapseLayout_2(const char* id, bool* isOpen, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions & options);

    static void EndCollapseFrameLayout();
    static void EndCollapseLayout();

    // Calculate content size
    static void BeginBoundingBox();  // Its the same as using Begin/End group and getting the LastItemRect values
    static ImRect& EndBoundingBox();  // Its the same as using Begin/End group and getting the LastItemRect values

    static float GetTableContentHeight();  // call before moving to the next cell/row
};
