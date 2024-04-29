
#pragma once

#include "imgui.h"
#include "imgui_internal.h"

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

    bool hide;
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
    static void DrawBoundingBox_2(const ImVec2& min, const ImVec2& max, int r, int g, int b, int a = 50, bool clipping = false);
    static void DrawBoundingBox_3(const ImRect& rect, int r, int g, int b, int a = 50, bool clipping = false);

    static void FillWidth(int r = 255, int g = 255, int b = 255, int a = 255, ImVec2 size = ImVec2(ImLayout::MATCH_PARENT, 20));
    static void ShowLayoutDebug();
    static void ShowLayoutDebugClipping();

    // Layout
    static ImVec2 GetLayoutSize();
    static void BeginLayoutEx(ImGuiID id);
    static void BeginLayoutEx(const char* id);
    static void PrepareLayout(float x1, float y1, float x2, float y2, ImGuiLayoutOptions options = ImGuiLayoutOptions());
    static void PrepareLayoutType(float sizeX, float sizeY);
    static void PrepareLayout(float sizeX, float sizeY, ImGuiLayoutOptions options);
    static void BeginLayout(const char* id, float sizeX, float sizeY);
    static void BeginLayout(const char* id, float sizeX, float sizeY, ImGuiLayoutOptions & options);
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

    // Tree
    static void BeginTree(const char* treeIdStr);
    static void EndTree();
    static void BeginTreeLayout(float height, bool isLeaf);
    static void BeginTreeLayout(float height, bool isLeaf, bool isOpen);
    static bool EndTreeLayout(bool* isSelected = NULL);
    static float GetTreeHeight(float padding);
};
