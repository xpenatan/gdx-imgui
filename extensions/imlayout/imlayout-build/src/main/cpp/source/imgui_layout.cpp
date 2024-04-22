#include "imgui.h"
#include "imgui_internal.h"
#include "imgui_layout.h"

// ##################################  ImGuiLayout  ###############################################

ImGuiLayout::ImGuiLayout(ImGuiID id) {
    parentLayout = NULL;
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

bool ImGuiLayout::haveParent() {
    return parentLayout != NULL;
}

ImVec2 ImGuiLayout::getAbsoluteSize() {
    return ImVec2(position.x + size.x, position.y + size.y);
}

ImVec2 ImGuiLayout::getContentSize() {
    return ImVec2(position.x + contentSize.x, position.y + contentSize.y);
}

ImVec2 ImGuiLayout::getAbsoluteSizePadding() {
    return ImVec2(position.x + size.x - paddingRight, position.y + size.y - paddingBottom);
}

ImVec2 ImGuiLayout::getContentSizePadding() {
    return ImVec2(position.x + contentSize.x + paddingLeft, position.y + contentSize.y);
}

ImVec2 ImGuiLayout::getPositionPadding() {
    return ImVec2(position.x + paddingLeft, position.y + paddingTop);
}


void ImGuiLayout::drawSizeDebug() {
    // Render layout space
    //Green
    ImLayout::DrawBoundingBox_2(position, getAbsoluteSize(), 0, 255, 0);
}

void ImGuiLayout::drawContentDebug() {
    // Render content space
    // Blue
    ImVec2 max = ImVec2(positionContents.x + contentSize.x, positionContents.y + contentSize.y);
    //ImLayout::DrawBoundingBox(positionContents, max, 0, 0, 255);
}

void ImGuiLayout::drawPaddingAreaDebug() {
    // Render size with padding
    //ImLayout::DrawBoundingBox(getPositionPadding(), getAbsoluteSizePadding(), 255, 255, 255);
}

void ImGuiLayout::drawError() {
    ImLayout::DrawBoundingBox_2(position, getAbsoluteSize(), 255, 0, 0, true);
}

// ##################################  ImGuiLayoutOptions  ########################################

ImGuiLayoutOptions::ImGuiLayoutOptions() {
    init(0, 0, 0, 0, true);
}

ImGuiLayoutOptions::ImGuiLayoutOptions(float paddingLeft, float paddingRight, float paddingTop, float paddingBottom, bool clipping) {
    init(paddingLeft, paddingRight, paddingTop, paddingBottom, clipping);
}

void ImGuiLayoutOptions::init(float paddingLeft, float paddingRight, float paddingTop, float paddingBottom, bool clipping) {
    //fix delegating constructors are permitted only in C++11
    this->paddingLeft = paddingLeft;
    this->paddingRight = paddingRight;
    this->paddingTop = paddingTop;
    this->paddingBottom = paddingBottom;
    this->clipping = clipping;
}



// ##################################  ImGuiCollapseLayoutOptions  ################################

ImGuiCollapseLayoutOptions::ImGuiCollapseLayoutOptions() {
    ImGuiLayoutOptions::init(2, 2, 2, 2);
    init();
}

ImGuiCollapseLayoutOptions::ImGuiCollapseLayoutOptions(float paddingLeft, float paddingRight, float paddingTop, float paddingBottom) {
    ImGuiLayoutOptions::init(paddingLeft, paddingRight, paddingTop, paddingBottom);
    init();
}

void ImGuiCollapseLayoutOptions::init() {
    arrowColor = ImGui::GetColorU32(ImVec4(0xFF / 255.0f, 0xFF / 255.0f, 0xFF / 255.0f, 0xFF / 255.0f));
    arrowBackgroundHoveredColor = ImGui::GetColorU32(ImVec4(0x77 / 255.0f, 0x77 / 255.0f, 0x77 / 255.0f, 0xFF / 255.0f));
    arrowBackgroundClickedColor = ImGui::GetColorU32(ImVec4(0x55 / 255.0f, 0x55 / 255.0f, 0x55 / 255.0f, 0xFF / 255.0f));
    frameColor = ImGui::GetColorU32(ImVec4(0x24 / 255.0f, 0x24 / 255.0f, 0x24 / 255.0f, 255 / 255.0f));
    borderColor = ImGui::GetColorU32(ImVec4(0x40 / 255.0f, 0x40 / 255.0f, 0x49 / 255.0f, 255 / 255.0f));
    borderRound = 4;
    roundingCorners = ImDrawFlags_RoundCornersTopLeft | ImDrawFlags_RoundCornersTopRight;
}

// ##################################  ImGuiLayout  ###############################################

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

    ImGui::PushID(id);

    ImGuiLayout* childLayout = createOrFind(id);
    childLayout->parentLayout = parentLayout;
    childLayout->childsLayout.clear();
    if (parentLayout != NULL)
        parentLayout->childsLayout.push_back(childLayout);
    layoutStack.push_back(childLayout);
    return childLayout;
}

ImGuiLayout* ImLayout::GetCurrentLayout() {
    if (layoutStack.empty())
        return NULL;
    return layoutStack.back();
}

static void popLayout() {
    layoutStack.pop_back();
    ImGui::PopID();
}

void ImLayout::DrawBoundingBox_1(float x1, float y1, float x2, float y2, int r, int g, int b, int a, bool clipping) {
    ImDrawList* drawList = clipping ? ImGui::GetWindowDrawList() : ImGui::GetForegroundDrawList();
    int color = ImGui::GetColorU32(ImVec4(r / 255.0f, g / 255.0f, b / 255.0f, a / 255.0f));
    drawList->AddRect(ImVec2(x1, y1), ImVec2(x2, y2), color);
}

void ImLayout::DrawBoundingBox_2(ImVec2 min, ImVec2 max, int r, int g, int b, int a, bool clipping) {
    ImLayout::DrawBoundingBox_1(min.x, min.y, max.x, max.y, r, g, b, a, clipping);
}

void ImLayout::DrawBoundingBox_3(ImRect rect, int r, int g, int b, int a, bool clipping) {
    ImLayout::DrawBoundingBox_2(rect.Min, rect.Max, r, g, b, a, clipping);
}

void ImLayout::FillWidth(int r, int g, int b, int a, ImVec2 size) {
    ImU32 bgColor = ImGui::GetColorU32(ImVec4(r / 255.0f, g / 255.0f, b / 255.0f, a / 255.0f));
    ImDrawList* drawList = ImGui::GetWindowDrawList();
    ImVec2 regionMax = ImGui::GetContentRegionAvail();

    float height = regionMax.y;
    float width = ImGui::GetContentRegionAvail().x;

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

void ImLayout::ShowLayoutDebug() {
    ImGuiLayout* curLayout = ImLayout::GetCurrentLayout();
    if (curLayout != NULL) {
        curLayout->debug = true;
    }
}
void ImLayout::ShowLayoutDebugClipping() {
    ImGuiLayout* curLayout = ImLayout::GetCurrentLayout();
    if (curLayout != NULL) {
        curLayout->debugClipping = true;
    }
}

ImVec2 ImLayout::GetLayoutSize() {
    ImGuiLayout* curLayout = ImLayout::GetCurrentLayout();
    return curLayout->size;
}

void ImLayout::BeginLayoutEx(ImGuiID id)
{
    pushLayout(id);
}

void ImLayout::BeginLayoutEx(const char* strID)
{
    BeginLayoutEx(ImGui::GetID(strID));
}

void ImLayout::PrepareLayoutType(float sizeX, float sizeY)
{
    ImGuiLayout* curLayout = ImLayout::GetCurrentLayout();
    curLayout->isMatchParentX = sizeX == ImLayout::MATCH_PARENT;
    curLayout->isWrapParentX = sizeX == ImLayout::WRAP_PARENT;
    curLayout->isMatchParentY = sizeY == ImLayout::MATCH_PARENT;
    curLayout->isWrapParentY = sizeY == ImLayout::WRAP_PARENT;
}

bool ImLayout::PrepareLayout(float sizeX, float sizeY, ImGuiLayoutOptions options)
{
    ImGuiContext& g = *GImGui;
    ImGuiWindow* window = g.CurrentWindow;

    ImVec2 position = window->DC.CursorPos;

    ImLayout::PrepareLayoutType(sizeX, sizeY);

    float x2 = position.x + sizeX;
    float y2 = position.y + sizeY;

    return PrepareLayout(position.x, position.y, x2, y2, options);
}

bool ImLayout::PrepareLayout(float x1, float y1, float x2, float y2, ImGuiLayoutOptions options)
{
    ImGuiContext& g = *GImGui;
    ImGuiWindow* window = g.CurrentWindow;

    ImGuiLayout* curLayout = ImLayout::GetCurrentLayout();
    curLayout->clipping = options.clipping;
    bool ret = true;
    // Update layout

    // Backup windows data
    curLayout->DC = window->DC;
    curLayout->WorkRect = window->WorkRect;
    curLayout->skipping = window->SkipItems;
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
    curLayout->clippingMin = curLayout->position;
    curLayout->clippingMax = curLayout->getAbsoluteSize();

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

bool ImLayout::BeginLayout(const char* strID, float sizeX, float sizeY)
{
    ImGuiLayoutOptions options;
    return BeginLayout(strID, sizeX, sizeY, options);
}

bool ImLayout::BeginLayout(const char* strID, float sizeX, float sizeY, ImGuiLayoutOptions & options)
{
    BeginLayoutEx(strID);
    return PrepareLayout(sizeX, sizeY, options);
}

void ImLayout::EndLayout()
{
    ImGuiContext& g = *GImGui;
    ImGuiWindow* window = g.CurrentWindow;
    ImGuiLayout* curLayout = ImLayout::GetCurrentLayout();
    if (curLayout == NULL)
        return;

    if (curLayout->clipping)
        ImGui::PopClipRect();

    float x = window->DC.CursorPos.x;
    float y = window->DC.CursorPos.y;

    curLayout->contentSize.x = window->DC.CursorMaxPos.x - curLayout->positionContents.x - curLayout->paddingLeft;
    curLayout->contentSize.y = y - curLayout->positionContents.y - g.Style.ItemSpacing.y;

    // Restore windows data
    window->DC = curLayout->DC;
    window->WorkRect = curLayout->WorkRect;
    window->SkipItems = curLayout->skipping;
    window->Pos = curLayout->Pos;
    window->ContentRegionRect = curLayout->ContentsRegionRect;
    g.LastItemData.Rect.Min = curLayout->positionContents;
    g.LastItemData.Rect.Max = ImVec2(curLayout->positionContents.x + curLayout->contentSize.x, curLayout->positionContents.y + curLayout->contentSize.y);
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
        ImLayout::DrawBoundingBox_2(curLayout->clippingMin, curLayout->clippingMax, 255, 0, 0);
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

bool ImLayout::PrepareCollapseLayout(const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options)
{
    ImGuiContext& g = *GImGui;
    ImGuiWindow* window = g.CurrentWindow;
    ImDrawList* drawList = window->DrawList;
    ImGuiLayout* rootLayout = ImLayout::GetCurrentLayout();

    float frameHeight = ImGui::GetFrameHeight();

    bool flag = rootLayout->map.GetBool(OPEN_KEY, options.openDefault);
    bool* isOpen = &flag;

    sizeY = *isOpen ? sizeY : ImLayout::WRAP_PARENT;

    ImLayout::PrepareLayout(sizeX, sizeY, ImGuiLayoutOptions(1, 1, 1, 1));

    rootLayout->map.SetFloat(120, options.paddingLeft);
    rootLayout->map.SetFloat(121, options.paddingRight);
    rootLayout->map.SetFloat(122, options.paddingTop);
    rootLayout->map.SetFloat(123, options.paddingBottom);

    ImGuiLayoutOptions op(0, 0, 0, 0);
    ImLayout::BeginLayout("frame", ImLayout::MATCH_PARENT, frameHeight, op);
    ImGuiLayout* frameLayout = ImLayout::GetCurrentLayout();

    ImVec2 mousePos = ImGui::GetMousePos();

    drawList->AddRectFilled(rootLayout->position, ImVec2(rootLayout->getAbsoluteSize().x, frameLayout->getAbsoluteSize().y), options.frameColor, options.borderRound, options.roundingCorners);

    renderFrameArrow(isOpen, options.arrowColor, options.arrowBackgroundHoveredColor, options.arrowBackgroundClickedColor);

    rootLayout->map.SetBool(OPEN_KEY, *isOpen);

    ImGui::SameLine();

    ImLayout::BeginAlign("align", ImLayout::WRAP_PARENT, ImLayout::MATCH_PARENT, 0, 0.5f, 0, 0);

    ImGui::Text(title);

    ImLayout::EndAlign();

    ImGui::SameLine();

    return *isOpen;
}

bool ImLayout::BeginCollapseLayoutEx(const char* id, const char* title, float sizeX, float sizeY)
{
    ImGuiCollapseLayoutOptions op;
    return BeginCollapseLayoutEx(id, title, sizeX, sizeY, op);
}

bool ImLayout::BeginCollapseLayoutEx(const char* id, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions & options)
{
    ImLayout::BeginLayoutEx(id);
    return ImLayout::PrepareCollapseLayout(title, sizeX, sizeY, options);
}

bool ImLayout::BeginCollapseLayoutEx_2(int id, const char* title, float sizeX, float sizeY)
{
    ImGuiCollapseLayoutOptions options;
    return BeginCollapseLayoutEx_2(id, title, sizeX, sizeY, options);
}

bool ImLayout::BeginCollapseLayoutEx_2(int id, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions & options)
{
    ImLayout::BeginLayoutEx(id);
    return ImLayout::PrepareCollapseLayout(title, sizeX, sizeY, options);
}

void ImLayout::BeginCollapseLayoutEx_3(const char* id, bool* isOpen, const char* title, float sizeX, float sizeY)
{
    ImGuiCollapseLayoutOptions op;
    BeginCollapseLayoutEx_3(id, isOpen, title, sizeX, sizeY, op);
}

void ImLayout::BeginCollapseLayoutEx_3(const char* id, bool* isOpen, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions & options)
{
    ImLayout::BeginLayoutEx(id);
    ImGuiLayout* rootLayout = ImLayout::GetCurrentLayout();
    rootLayout->map.SetBool(OPEN_KEY, *isOpen);
    bool flag = ImLayout::PrepareCollapseLayout(title, sizeX, sizeY, options);
    *isOpen = flag;
}

bool ImLayout::BeginCollapseLayout(const char* id, const char* title, float sizeX, float sizeY)
{
    ImGuiCollapseLayoutOptions op;
    return BeginCollapseLayout(id, title, sizeX, sizeY, op);
}

bool ImLayout::BeginCollapseLayout(const char* id, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions & options)
{
    bool flag = ImLayout::BeginCollapseLayoutEx(id, title, sizeX, sizeY, options);
    ImLayout::EndCollapseFrameLayout();
    return flag;
}

void ImLayout::BeginCollapseLayout_2(const char* id, bool* isOpen, const char* title, float sizeX, float sizeY)
{
     ImGuiCollapseLayoutOptions options;
     BeginCollapseLayout_2(id, isOpen, title, sizeX, sizeY, options);
}

void ImLayout::BeginCollapseLayout_2(const char* id, bool* isOpen, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions & options)
{
    ImLayout::BeginCollapseLayoutEx_3(id, isOpen, title, sizeX, sizeY, options);
    ImLayout::EndCollapseFrameLayout();
}

void ImLayout::EndCollapseFrameLayout()
{
    ImGuiContext& g = *GImGui;
    float bk = g.Style.ItemSpacing.y;

    g.Style.ItemSpacing.y = 0;
    ImLayout::EndLayout(); // end frame
    g.Style.ItemSpacing.y = bk;
    ImGuiLayout* rootLayout = ImLayout::GetCurrentLayout();

    float paddingLeft = rootLayout->map.GetFloat(120, 0.0f);
    float paddingRight = rootLayout->map.GetFloat(121, 0.0f);
    float paddingTop = rootLayout->map.GetFloat(122, 0.0f);
    float paddingBottom = rootLayout->map.GetFloat(123, 0.0f);
    ImGuiLayoutOptions op(paddingLeft, paddingRight, paddingTop, paddingBottom);
    ImLayout::BeginLayout("content", ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, op);
    ImGuiLayout* collapseLayout = ImLayout::GetCurrentLayout();
}

void ImLayout::EndCollapseLayout()
{
    ImGuiContext& g = *GImGui;
    ImGuiWindow* window = g.CurrentWindow;
    ImDrawList* drawList = window->DrawList;

    ImU32 borderColor = ImGui::GetColorU32(ImVec4(0x40 / 255.0f, 0x40 / 255.0f, 0x49 / 255.0f, 255 / 255.0f));
    int borderRound = 4;
    int roundingCorners = ImDrawFlags_RoundCornersTopLeft | ImDrawFlags_RoundCornersTopRight;

    ImLayout::EndLayout(); // end content

    ImGuiLayout* rootLayout = ImLayout::GetCurrentLayout();

    ImLayout::EndLayout(); // end root

    ImVec2 borderPosition = rootLayout->position;
    ImVec2 borderSize = rootLayout->getAbsoluteSize();

    drawList->AddRect(borderPosition, borderSize, borderColor, borderRound, roundingCorners, 1.0f);
}

void ImLayout::BeginAlign(const char* strID, float sizeX, float sizeY, float alignX, float alignY, float offsetX, float offsetY, ImGuiLayoutOptions options) {
    ImLayout::BeginLayout(strID, sizeX, sizeY, options);
    ImLayout::AlignLayout(alignX, alignY, offsetX, offsetY);
}

void ImLayout::AlignLayout(float alignX, float alignY, float offsetX, float offsetY) {
    ImGuiContext& g = *GImGui;
    ImGuiWindow* window = g.CurrentWindow;
    ImGuiLayout* curLayout = ImLayout::GetCurrentLayout();
    if (curLayout == NULL)
        return;

    ImVec2 regionAvail = ImGui::GetContentRegionAvail();
    float totalX = regionAvail.x;
    float totalY = regionAvail.y;

    ImVec2 posPad = curLayout->getPositionPadding();
    ImVec2 absSizePad = curLayout->getAbsoluteSizePadding();

    if (alignX > 0.0f && curLayout->isWrapParentX == false) {

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

    if (alignY > 0.0f && curLayout->isWrapParentY == false) {
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

void ImLayout::EndAlign() {
    ImLayout::EndLayout();
}

void ImLayout::BeginBoundingBox() {
    ImGui::BeginGroup();
    ImGuiContext& g = *GImGui;
    ImGuiWindow* window = g.CurrentWindow;
}

ImRect& ImLayout::EndBoundingBox() {
    ImGuiContext& g = *GImGui;
    ImGuiWindow* window = g.CurrentWindow;
    ImGui::EndGroup();
    return g.LastItemData.Rect;
}

float ImLayout::GetTableContentHeight() {
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