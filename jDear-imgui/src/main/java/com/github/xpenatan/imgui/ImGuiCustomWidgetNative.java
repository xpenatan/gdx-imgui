package com.github.xpenatan.imgui;

import com.github.xpenatan.imgui.enums.ImDrawCornerFlags;

public class ImGuiCustomWidgetNative {

	/*JNI
		#include <src/imgui.h>
		#include <src/imgui_internal.h>

		bool beginChildEx(const char* id, float sizeX, float paddingX, float paddingY) {
			ImGuiContext& g = *GImGui;
			ImGuiWindow* parent_window = g.CurrentWindow;

			ImGuiWindowFlags flags = 0;
			flags |= ImGuiWindowFlags_NoDecoration | ImGuiWindowFlags_NoTitleBar | ImGuiWindowFlags_NoResize | ImGuiWindowFlags_NoSavedSettings | ImGuiWindowFlags_ChildWindow | ImGuiWindowFlags_NoDocking | ImGuiWindowFlags_NoScrollbar | ImGuiWindowFlags_NoScrollWithMouse | ImGuiWindowFlags_AlwaysUseWindowPadding;
			flags |= (parent_window->Flags & ImGuiWindowFlags_NoMove);  // Inherit the NoMove flag

			ImGui::PushStyleVar(ImGuiStyleVar_WindowPadding, ImVec2(paddingX, paddingY));

			const float backup_border_size = g.Style.ChildBorderSize;
			g.Style.ChildBorderSize = 0.0f;
			bool ret = ImGui::Begin(id, NULL, flags);
			g.Style.ChildBorderSize = backup_border_size;

			ImGui::PopStyleVar();

			return ret;
		}

		void endChildEx(bool debug) {
			ImGuiContext& g = *GImGui;
			ImGuiWindow* window = g.CurrentWindow;

			float bottomOffset = g.Style.ItemSpacing.y;
			float y = ImGui::GetCursorPosY() - bottomOffset;

			ImDrawList* drawList = ImGui::GetWindowDrawList();
			ImVec2 vec = ImGui::GetCursorStartPos();

			float windowX = window->Pos.x + vec.x;
			float windowY = window->Pos.y + vec.y;

			float windowPaddingX = windowX - window->WindowPadding.x;
			float windowPaddingY = windowY - window->WindowPadding.y;

			float windowWidth = window->Size.x - window->WindowPadding.x * 2;
			float windowHeight = y - window->WindowPadding.y;

			float windowPaddingWidth = windowWidth + window->WindowPadding.x * 2;
			float windowPaddingHeight = windowHeight + window->WindowPadding.y * 2;

			ImGui::SetWindowSize(ImVec2(window->ParentWindow->ContentsRegionRect.GetWidth(), windowPaddingHeight));

			ImGui::EndChild();

			if (debug) {
				float rounding = 0;
				//Render space + padding
				drawList->AddRect(ImVec2(windowPaddingX, windowPaddingY), ImVec2(windowPaddingX + windowPaddingWidth, windowPaddingY + windowPaddingHeight), ImGui::GetColorU32(ImVec4(255.0f / 255.0f, 0.0f / 255.0f, 0.0f / 255.0f, 255.0f / 255.0f)), rounding);

				// Render space
				drawList->AddRect(ImVec2(windowX, windowY), ImVec2(windowX + windowWidth, windowY + windowHeight), ImGui::GetColorU32(ImVec4(0.0f / 255.0f, 255.0f / 255.0f, 0.0f / 255.0f, 255.0f / 255.0f)), rounding);
			}
		}

		bool renderFrameContent(const char* title, bool* value, int arrowColor, int arrowBackgroundHoveredColor, int arrowBackgroundClickedColor, int titleColor)
		{
			ImGui::BeginGroup();
			ImGui::PushID("frame");

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
						*value = !*value;
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

			ImVec2 textSize = ImGui::CalcTextSize(title, NULL);

			float offsetY = (getFrameHeight - textSize.y) / 2.0f;
			float offsetX = 5;

			drawList->AddText(ImVec2(x + halfSize * 2 + offsetX, screenPosY + offsetY), titleColor, title, NULL);

			drawList->AddTriangleFilled(ImVec2(triA_X, triA_Y), ImVec2(triB_X, triB_Y), ImVec2(triC_X, triC_Y), arrowColor);

			ImGui::PopID();
			ImGui::EndGroup();

			return *value;
		}

		bool beginCollapsingHeaderEx(const char* id, const char* title, bool* isOpen, float sizeX, float paddingX, float paddingY,
				int arrowColor, int arrowBackgroundHoveredColor, int arrowBackgroundClickedColor, int frameColor, int roundingCornerFlags, int borderRadius, int titleColor) {
			ImGuiContext& g = *GImGui;
			float getFrameHeight = ImGui::GetFrameHeight();
			ImGui::BeginGroup();

			ImGui::BeginGroup();
			ImGui::PushID("id");

			ImDrawList* drawList = ImGui::GetWindowDrawList();

			ImVec2 vec = ImGui::GetCursorScreenPos();
			float screenPosX = vec.x;
			float screenPosY = vec.y;
			float windowWidth = ImGui::GetWindowContentRegionWidth();


			drawList->AddRectFilled(ImVec2(screenPosX, screenPosY), ImVec2(screenPosX + windowWidth, screenPosY + getFrameHeight), frameColor, borderRadius, roundingCornerFlags);

			bool flag = renderFrameContent(title, isOpen, arrowColor, arrowBackgroundHoveredColor, arrowBackgroundClickedColor, titleColor);

			ImGui::PopID();
			ImGui::EndGroup();

			float bk = g.Style.ItemSpacing.y;
			g.Style.ItemSpacing.y = 0;
			int offset = 0;

			if (flag)
				offset = bk;

			ImGui::ItemSize(ImVec2(windowWidth, getFrameHeight - offset));
			g.Style.ItemSpacing.y = bk;

			float y = ImGui::GetCursorPosY();

			ImVec2 vec2 = ImGui::GetCursorScreenPos();

			float height = screenPosY + getFrameHeight;

			vec2 = ImGui::GetCursorScreenPos();

			if (flag)
				beginChildEx(id, sizeX, paddingX, paddingY);
			return flag;

		}

		void endCollapsingHeaderEx(bool isOpen, bool debug, int borderColor, float borderRadius, float roundingCornerFlags, float borderWidth)
		{
			ImGuiContext& g = *GImGui;

			float height = 0;

			ImGuiWindow* childWindow = NULL;
			ImGuiWindow* parentWindow = NULL;

			if (isOpen) {
				childWindow = g.CurrentWindow;
				endChildEx(debug);
			}

			parentWindow = g.CurrentWindow;

			float bk = g.Style.ItemSpacing.y;

			if (!isOpen)
				g.Style.ItemSpacing.y = 0;
			ImGui::EndGroup();
			if (!isOpen)
				g.Style.ItemSpacing.y = bk;

			float getFrameHeight = ImGui::GetFrameHeight();
			ImVec2 vec = ImGui::GetCursorScreenPos();
			float screenPosX = parentWindow->DC.CursorPos.x;
			float screenPosY = parentWindow->DC.CursorPosPrevLine.y;

			float windowWidth = ImGui::GetWindowContentRegionWidth();
			int offset = 0;
			if (isOpen)
				offset = g.Style.ItemSpacing.y;

			if (childWindow != NULL)
				 height = childWindow->Size.y + screenPosY + getFrameHeight;
			else
				height = screenPosY + getFrameHeight;

			ImDrawList* drawList = ImGui::GetWindowDrawList();

			windowWidth = ImGui::GetWindowContentRegionWidth();

			drawList->AddRect(ImVec2(screenPosX, screenPosY), ImVec2(screenPosX + windowWidth, height), borderColor, borderRadius, roundingCornerFlags, borderWidth);
		}
	*/

	static native boolean BeginChildEx(String id, float sizeX, float paddingX, float paddingY) /*-{ }-*/; /*
		return beginChildEx(id, sizeX, paddingX, paddingY);
	*/

	static native void EndChildEx(boolean debug) /*-{ }-*/; /*
		endChildEx(debug);
	*/

	static native boolean BeginCollapsingHeaderEx(String id, String title, boolean [] v, float sizeX, float paddingX, float paddingY,
			int arrowColor, int arrowBackgroundHoveredColor, int arrowBackgroundClickedColor, float borderRadius,
			int roundingCornerFlags, int frameColor, int titleColor, int layoutBackgroundColor) /*-{ }-*/; /*
		return beginCollapsingHeaderEx(id, title, &v[0], sizeX, paddingX, paddingY, arrowColor, arrowBackgroundHoveredColor, arrowBackgroundClickedColor, frameColor, roundingCornerFlags, borderRadius, titleColor);
	*/

	static native void EndCollapsingHeaderEx(boolean isOpen, boolean debug, int borderColor, float borderRadius, int roundingCornerFlags, float borderWidth) /*-{ }-*/; /*
		endCollapsingHeaderEx(isOpen, debug, borderColor, borderRadius, roundingCornerFlags, borderWidth);
	*/

	static CollpasingHeaderExOptions DEFAULT_COLLAPSE_OPTIONS = new CollpasingHeaderExOptions();

	public static class CollpasingHeaderExOptions {
		public boolean debug = false;
		public float layoutPaddingX = 4;
		public float layoutPaddingY = 4;
		public int arrowColor = ImGui.colorToIntBits(0xFF, 0xFF, 0xFF, 0xFF);
		public int arrowBackgroundHoveredColor = ImGui.colorToIntBits(0x77, 0x77, 0x77, 0xFF);
		public int arrowBackgroundClickedColor = ImGui.colorToIntBits(0x55, 0x55, 0x55, 0xFF);
		public int borderColor = ImGui.colorToIntBits(0x40, 0x40, 0x49, 0xFF);
		public float borderRadius = 5;
		public float borderWidth = 1.0f;
		public int roundingCornerFlags = ImDrawCornerFlags.TopLeft.or(ImDrawCornerFlags.TopRight).getValue();
		public int frameColor = ImGui.colorToIntBits(0x24, 0x24, 0x24, 0xFF);
		public int titleColor = ImGui.colorToIntBits(0xFF, 0xFF, 0xFF, 0xFF);
		public int layoutBackgroundColor = 0;
	}
}
