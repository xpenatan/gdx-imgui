#pragma once

#include "imgui.h"
#include "imgui_internal.h"

struct ImGuiAlign
{

public:
    char* idStr;
    ImGuiID id;
    ImGuiAlign* parentAlign;
    ImVec2 positionContents;
    ImVec2 sizeContents;
    ImVec2 position;
    ImVec2 size;
    ImVec2 sizeParam;

	bool clipping;
    bool debug;

    ImGuiWindowTempData DC;
    ImRect WorkRect;
    ImVec2 Pos;
    ImRect ContentsRegionRect;

    ImGuiAlign(const char* idStr) {
        this->idStr = ImStrdup(idStr);
        this->id = ImHashStr(idStr);
		debug = false;
		clipping = true;
    }

    void drawSizeDebug() {
        ImDrawList* drawList = ImGui::GetForegroundDrawList();
        float rounding = 0;
        // Render layout space
        //Green
        int color = ImGui::GetColorU32(ImVec4(0.0f / 255.0f, 255.0f / 255.0f, 0.0f / 255.0f, 205.0f / 255.0f));
        drawList->AddRect(position, ImVec2(position.x + size.x, position.y + size.y), color, rounding);
    }

    void drawContentDebug() {
        ImDrawList* drawList = ImGui::GetForegroundDrawList();
        float rounding = 0;
        // Render content space
        //Blue
        int color = ImGui::GetColorU32(ImVec4(0.0f / 255.0f, 0.0f / 255.0f, 255.0f / 255.0f, 205.0f / 255.0f));
        drawList->AddRect(positionContents, ImVec2(positionContents.x + sizeContents.x, positionContents.y + sizeContents.y), color, rounding);
    }
};

struct ImGuiLayout
{

public:
    char* idStr;
    ImGuiID id;
    ImGuiLayout* parentLayout;

	bool clipping;
    bool debug;

	ImGuiStorage map;

    ImVec2 position;                    // Position of the layout
    ImVec2 size;                        // Size of the layout
    ImVec2 sizeParam;                   // Size parameter used when calling beginLayout
    float paddingLeft;
    float paddingRight;
    float paddingTop;
    float paddingBottom;
    ImVec2 sizeContents;                // Size of contents. calculated after the first frame

    bool error;

    // Window Backup data
    ImGuiWindowTempData DC;            
    ImRect WorkRect;              
    bool skipping;
    int AutoFitChildAxises;
    ImVec2 Pos;
    ImRect ContentsRegionRect;

    ImGuiLayout(const char* idStr) {
        this->idStr = ImStrdup(idStr);
        this->id = ImHashStr(idStr);
		paddingLeft = 0;
		paddingRight = 0;
		paddingTop = 0;
		paddingBottom = 0;
		clipping = true;
		debug = false;
		error = false;
		skipping = false;
    }

    bool haveParent() { return parentLayout != NULL; }

    ImVec2 getAbsoluteSize() {
        return ImVec2(position.x + size.x, position.y + size.y);
    }

    ImVec2 getContentSize() {
        return ImVec2(position.x + sizeContents.x, position.y + sizeContents.y);
    }

    ImVec2 getAbsoluteSizePadding() {
        return ImVec2(position.x + size.x - paddingRight, position.y + size.y - paddingBottom);
    }

    ImVec2 getContentSizePadding() {
        return ImVec2(position.x + sizeContents.x + paddingLeft, position.y + sizeContents.y);
    }

    ImVec2 getPositionPadding() {
        return ImVec2(position.x + paddingLeft, position.y + paddingTop);
    }


    void drawSizeDebug() {
        ImDrawList* drawList = ImGui::GetForegroundDrawList();
        float rounding = 0;
        // Render layout space
        //Green
        int color = ImGui::GetColorU32(ImVec4(0.0f / 255.0f, 255.0f / 255.0f, 0.0f / 255.0f, 205.0f / 255.0f));
        drawList->AddRect(position, getAbsoluteSize(), color, rounding);
    }

    inline void drawContentDebug() {
        ImDrawList* drawList = ImGui::GetForegroundDrawList();
        //float rounding = 0;
        // Render content space
        // Blue
        //int color = ImGui::GetColorU32(ImVec4(0.0f / 255.0f, 0.0f / 255.0f, 255.0f / 255.0f, 205.0f / 255.0f));
        //drawList->AddRect(getPositionPadding(), getContentSizePadding(), color, rounding, ImDrawCornerFlags_None, 1.0f);
    }

    void drawPaddingAreaDebug() {
        ImDrawList* drawList = ImGui::GetForegroundDrawList();
        float rounding = 0;
        // Render size with padding
        int color = ImGui::GetColorU32(ImVec4(255.0f / 255.0f, 255.0f / 255.0f, 255.0f / 255.0f, 205.0f / 255.0f));
        drawList->AddRect(getPositionPadding(), getAbsoluteSizePadding(), color, rounding);
    }

    void drawError() {
        ImDrawList* drawList = ImGui::GetForegroundDrawList();
        float rounding = 0;
        int color = ImGui::GetColorU32(ImVec4(255.0f / 255.0f, 0.0f / 255.0f, 0.0f / 255.0f, 205.0f / 255.0f));
        drawList->AddRect(position, getAbsoluteSize(), color, rounding);
    }
};

struct ImGuiCollapseLayoutOptions
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
		arrowBackgroundHoveredColor = ImGui::GetColorU32(ImVec4(0x77 / 255.0f, 0x77 / 255.0f, 0x77 / 255.0f, 0xFF / 255.0f));
		arrowBackgroundClickedColor = ImGui::GetColorU32(ImVec4(0x55 / 255.0f, 0x55 / 255.0f, 0x55 / 255.0f, 0xFF / 255.0f));
		frameColor = ImGui::GetColorU32(ImVec4(0x24 / 255.0f, 0x24 / 255.0f, 0x24 / 255.0f, 255 / 255.0f));
		borderColor = ImGui::GetColorU32(ImVec4(0x40 / 255.0f, 0x40 / 255.0f, 0x49 / 255.0f, 255 / 255.0f));
		borderRound = 4;
		roundingCorners = ImDrawCornerFlags_TopLeft | ImDrawCornerFlags_TopRight;
	}
};

namespace ImGui
{
    void ShowLayoutDebug();

    bool BeginLayout(const char* id, float sizeX, float sizeY, float paddingLeft = 0, float paddingRight = 0, float paddingTop = 0, float paddingBottom = 0);
    void EndLayout();
    ImGuiLayout* GetCurrentLayout();

    void BeginCollapseLayoutEx(bool* isOpen, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options = ImGuiCollapseLayoutOptions());
    void BeginCollapseLayout(bool* isOpen, const char* title, float sizeX, float sizeY, ImGuiCollapseLayoutOptions options = ImGuiCollapseLayoutOptions());
    void EndCollapseFrameLayout();
    void EndCollapseLayout();

    void ShowAlignDebug();
    void BeginAlign(const char* id, float sizeX, float sizeY, float alignX = 0.5f, float alignY = 0.5f, float contentAlignX = 0.0f, float contentAlignY = 0.0f, float paddingX = 0, float paddingY = 0);
    void EndAlign();
    ImGuiAlign* GetCurrentAlign();
};

namespace ImLayout
{
	static float WRAP_PARENT = 0;
	static float MATCH_PARENT = -0.1f;
}