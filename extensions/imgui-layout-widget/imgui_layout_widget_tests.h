#pragma once

#include "imgui.h"
#include "imgui_internal.h"
#include "imgui_layout_widget.h"
#include <iostream>


static void renderContent(bool verticalButtonFill) {
    ImGuiWindow* window = ImGui::GetCurrentWindow();
    ImGuiWindowTempData& DC = window->DC;
    ImGui::Button("B 00", ImVec2(ImLayout::MATCH_PARENT, 0));
    ImGui::Text("This is a Text");
    ImGui::TextWrapped("This is a WrappeddddddddddddddText");
    ImGui::Button("B 01", ImVec2(ImLayout::MATCH_PARENT, 0));
    ImGui::Button("B 02", ImVec2(0, verticalButtonFill ? ImLayout::MATCH_PARENT : 0));
}

static char* catStr(const char* one, const char* two) {
    char* three = new char[strlen(one) + strlen(two) + 1]{ '\0' };
    strcat_s(three, strlen(one) + 1, one);
    strcat_s(three, strlen(one) + strlen(two) + 1, two);
    return three;
}

static void paintLayout(ImU32 bgColor, ImVec2 size = ImVec2(0, 0)) {
    ImDrawList* drawList = ImGui::GetWindowDrawList();
    ImVec2 regionMax = ImGui::GetContentRegionAvail();

    float height = regionMax.y;
    float width = ImGui::GetWindowContentRegionWidth();

    ImVec2 cursorPos = ImGui::GetCursorScreenPos();

    if (size.x > 0 && size.y > 0) {
        width = size.x;
        height = size.y;
    }
    drawList->AddRectFilled(cursorPos, ImVec2(cursorPos.x + width, cursorPos.y + height), bgColor);
}

namespace ImGui
{
    static void HelpMarker(const char* desc)
    {
        ImGui::TextDisabled("(?)");
        if (ImGui::IsItemHovered())
        {
            ImGui::BeginTooltip();
            ImGui::PushTextWrapPos(ImGui::GetFontSize() * 35.0f);
            ImGui::TextUnformatted(desc);
            ImGui::PopTextWrapPos();
            ImGui::EndTooltip();
        }
    }

    inline void test01(const char* name, bool debug) {
        HelpMarker("Layout with\nX: WRAP_PARENT\nY: WRAP_PARENT\nPaddingLeft: 0\nPaddingRight: 0");
        char* idChild = catStr(name, "child");
        char* idChild2 = catStr(name, "child2");
        char* idChild3 = catStr(name, "child3");
        char* idChild4 = catStr(name, "child4");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild, ImLayout::WRAP_PARENT, ImLayout::WRAP_PARENT, 0, 0, 0, 0)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        HelpMarker("Layout with\nX: WRAP_PARENT\nY: WRAP_PARENT\nPaddingLeft: 40\nPaddingRight: 0");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild2, ImLayout::WRAP_PARENT, ImLayout::WRAP_PARENT, 40, 0, 0, 0)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        HelpMarker("Layout with\nX: WRAP_PARENT\nY: WRAP_PARENT\nPaddingLeft: 0\nPaddingRight: 40");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild3, ImLayout::WRAP_PARENT, ImLayout::WRAP_PARENT, 0, 40, 0, 0)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        HelpMarker("Layout with\nX: WRAP_PARENT\nY: WRAP_PARENT\nPaddingLeft: 40\nPaddingRight: 40");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild4, ImLayout::WRAP_PARENT, ImLayout::WRAP_PARENT, 40, 40, 0, 0)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));
        delete[] idChild;


    }

    inline void test02(const char* name, bool debug) {
        char* idChild = catStr(name, "child");
        char* idChild2 = catStr(name, "child2");
        char* idChild3 = catStr(name, "child3");
        char* idChild4 = catStr(name, "child4");
        HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingLeft: 0\nPaddingRight: 0");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, 2, 2, 0, 0)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingLeft: 40\nPaddingRight: 0");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild2, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, 40, 0, 0, 0)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingLeft: 0\nPaddingRight: 40");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild3, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, 0, 40, 0, 0)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingLeft: 40\nPaddingRight: 40");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild4, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, 40, 40, 0, 0)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        delete[] idChild;
    }

    inline void test03(const char* name, bool debug) {
        char* idChild = catStr(name, "child");
        char* idChild2 = catStr(name, "child2");
        char* idChild3 = catStr(name, "child3");
        char* idChild4 = catStr(name, "child4");

        HelpMarker("Layout with\nX: 300\nY: 110\nPaddingLeft: 0\nPaddingRight: 0");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {

            ImU32 bgColor = ImGui::GetColorU32(ImVec4(0xFF / 255.0f, 0x00 / 255.0f, 0x00 / 255.0f, 255 / 255.0f));
            paintLayout(bgColor, ImVec2(300, 110));

            if (ImGuiEx::BeginLayout(idChild, 300, 110, 0, 0, 0, 0)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        HelpMarker("Layout with\nX: 300\nY: 110\nPaddingLeft: 40\nPaddingRight: 0");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            ImU32 bgColor = ImGui::GetColorU32(ImVec4(0xFF / 255.0f, 0x00 / 255.0f, 0x00 / 255.0f, 255 / 255.0f));
            paintLayout(bgColor, ImVec2(300, 110));
            if (ImGuiEx::BeginLayout(idChild2, 300, 110, 40, 0, 0, 0)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        HelpMarker("Layout with\nX: 300\nY: 110\nPaddingLeft: 0\nPaddingRight: 40");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            ImU32 bgColor = ImGui::GetColorU32(ImVec4(0xFF / 255.0f, 0x00 / 255.0f, 0x00 / 255.0f, 255 / 255.0f));
            paintLayout(bgColor, ImVec2(300, 110));

            if (ImGuiEx::BeginLayout(idChild2, 300, 110, 0, 40, 0, 0)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        HelpMarker("Layout with\nX: 300\nY: 110\nPaddingLeft: 40\nPaddingRight: 40");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild4, 300, 110, 40, 40, 0, 0)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        delete[] idChild;
    }

    inline void test04(const char* name, bool debug) {
        char* idChild = catStr(name, "child");
        char* idChild2 = catStr(name, "child2");
        char* idChild3 = catStr(name, "child3");
        char* idChild4 = catStr(name, "child4");

        HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingTop: 40\nPaddingBottom: 0");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, 0, 0, 40, 00)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingTop: 0\nPaddingBottom: 40");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild2, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, 0, 0, 0, 40)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingTop: 40\nPaddingBottom: 40");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild3, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, 0, 0, 40, 40)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        delete[] idChild;
    }

    inline void test05(const char* name, bool debug) {
        HelpMarker("Layout with\nX: MATCH_PARENT\nY: MATCH_PARENT\nPaddingTop: 40\nPaddingBottom: 0");
        char* idChild = catStr(name, "child");
        char* idChild2 = catStr(name, "child2");
        char* idChild3 = catStr(name, "child3");
        char* idChild4 = catStr(name, "child4");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, 0, 0, 40, 0)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        delete[] idChild;
    }

    inline void test06(const char* name, bool debug) {
        HelpMarker("Layout with\nX: MATCH_PARENT\nY: MATCH_PARENT\nPaddingTop: 0\nPaddingBottom: 40");
        char* idChild = catStr(name, "child");
        char* idChild2 = catStr(name, "child2");
        char* idChild3 = catStr(name, "child3");
        char* idChild4 = catStr(name, "child4");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, 0, 0, 0, 40)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(true);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        delete[] idChild;
    }

    inline void test07(const char* name, bool debug) {
        HelpMarker("Layout with\nX: MATCH_PARENT\nY: MATCH_PARENT\nPaddingTop: 40\nPaddingBottom: 40");
        char* idChild = catStr(name, "child");
        char* idChild2 = catStr(name, "child2");
        char* idChild3 = catStr(name, "child3");
        char* idChild4 = catStr(name, "child4");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, 0, 0, 40, 40)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(true);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        delete[] idChild;
    }

    inline void test08(const char* name, bool debug) {
        HelpMarker("Layout with\nX: MATCH_PARENT\nY: 200\nPaddingTop: 0\nPaddingBottom: 40");
        char* idChild = catStr(name, "child");
        char* idChild2 = catStr(name, "child2");
        char* idChild3 = catStr(name, "child3");
        char* idChild4 = catStr(name, "child4");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild, ImLayout::MATCH_PARENT, 200, 0, 0, 0, 40)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(true);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        delete[] idChild;
    }

    inline void test09(const char* name, bool debug) {
        HelpMarker("Layout with\nX: MATCH_PARENT\nY: MATCH_PARENT\nPaddingLeft: 40\nPaddingRight: 40\nPaddingTop: 40\nPaddingBottom: 40");
        char* idChild = catStr(name, "child");
        char* idChild2 = catStr(name, "child2");
        char* idChild3 = catStr(name, "child3");
        char* idChild4 = catStr(name, "child4");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, 40, 40, 40, 40)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(true);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        delete[] idChild;
    }
    
    inline void test10(const char* name, bool debug) {
        HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingleft: 2\nPaddingRight: 2\nPaddingTop: 2\nPaddingBottom: 2");
        char* idChild = catStr(name, "child");
        char* idChild2 = catStr(name, "child2");
        char* idChild3 = catStr(name, "child3");
        char* idChild4 = catStr(name, "child4");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, 2, 2, 2, 2)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        delete[] idChild;
    }

    inline void test11(const char* name, bool debug) {
        HelpMarker("Multi child layout test");
        char* idChild = catStr(name, "child");
        char* idChild2 = catStr(name, "child2");
        char* idChild3 = catStr(name, "child3");
        char* idChild4 = catStr(name, "child4");
        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild, ImLayout::MATCH_PARENT, 200, 1, 1, 1, 1)) {

                ImGui::Button("Button Layout 01", ImVec2(ImLayout::MATCH_PARENT, 0));
                ImU32 bgColor = ImGui::GetColorU32(ImVec4(0xFF / 255.0f, 0x00 / 255.0f, 0x00 / 255.0f, 255 / 255.0f));
                paintLayout(bgColor);

                if (ImGuiEx::BeginLayout(idChild2, ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, 4, 4, 4, 4)) {
                    ImU32 bgColor = ImGui::GetColorU32(ImVec4(0x00 / 255.0f, 0xFF / 255.0f, 0x00 / 255.0f, 255 / 255.0f));
                    paintLayout(bgColor);

                    if (ImGuiEx::BeginLayout(idChild3, ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, 4, 4, 4, 4)) {
                        ImU32 bgColor = ImGui::GetColorU32(ImVec4(0x00 / 255.0f, 0x00 / 255.0f, 0xFF / 255.0f, 255 / 255.0f));
                        paintLayout(bgColor);
                    }
					ImGuiEx::EndLayout();
                }
				ImGuiEx::EndLayout();
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        delete[] idChild;
    }

    inline void test12(const char* name, bool debug) {
        ImGuiContext& g = *GImGui;
        HelpMarker("Multi child layout test");


		static float paddingLeft = 1.0f;
		static float paddingTop = 1.0f;
		static float paddingRight = 1.0f;
		static float paddingBottom = 1.0f;
		ImGui::SliderFloat("Layout Padding Left", &paddingLeft, 0.0f, 10.0f, "%.0f");
		ImGui::SliderFloat("Layout Padding Right", &paddingRight, 0.0f, 10.0f, "%.0f");
		ImGui::SliderFloat("Layout Padding Top", &paddingTop, 0.0f, 10.0f, "%.0f");
		ImGui::SliderFloat("Layout Padding Bottom", &paddingBottom, 0.0f, 10.0f, "%.0f");



		static float paddingLeft2 = 1.0f;
		static float paddingTop2 = 1.0f;
		static float paddingRight2 = 1.0f;
		static float paddingBottom2 = 1.0f;
		ImGui::SliderFloat("Layout Padding Left2", &paddingLeft2, 0.0f, 10.0f, "%.0f");
		ImGui::SliderFloat("Layout Padding Right2", &paddingRight2, 0.0f, 10.0f, "%.0f");
		ImGui::SliderFloat("Layout Padding Top2", &paddingTop2, 0.0f, 10.0f, "%.0f");
		ImGui::SliderFloat("Layout Padding Bottom2", &paddingBottom2, 0.0f, 10.0f, "%.0f");


        char* idChild = catStr(name, "child");
        char* idChild2 = catStr(name, "child2");
        char* idChild3 = catStr(name, "child3");
        char* idChild4 = catStr(name, "child4");
        ImGui::Button("Outside Begin", ImVec2(150, 0));
        {
			ImGuiEx::BeginLayout(idChild4, 200, ImLayout::WRAP_PARENT, 0, 0, 0, 0);

			ImU32 bgColor = ImGui::GetColorU32(ImVec4(0xFF / 255.0f, 0xFF / 255.0f, 0xFF / 255.0f, 255 / 255.0f));
			paintLayout(bgColor);
            if (ImGuiEx::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, paddingLeft, paddingRight, paddingTop, paddingBottom)) {
				ImU32 bgColor = ImGui::GetColorU32(ImVec4(0xFF / 255.0f, 0x00 / 255.0f, 0x00 / 255.0f, 255 / 255.0f));
				paintLayout(bgColor);
                if (ImGuiEx::BeginLayout(idChild3, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, paddingLeft2, paddingRight2, paddingTop2, paddingBottom2)) {
                    ImU32 bgColor = ImGui::GetColorU32(ImVec4(0x00 / 255.0f, 0x00 / 255.0f, 0xFF / 255.0f, 255 / 255.0f));
                    paintLayout(bgColor);
                    renderContent(false);
                }
				ImGuiEx::EndLayout();
            }
			ImGuiEx::EndLayout();

			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        delete[] idChild;
    }

    inline void test13(const char* name, bool debug) {
        ImGuiContext& g = *GImGui;
        HelpMarker("Combining IDs test");
        ImGui::Button("Outside Begin", ImVec2(150, 0));
        {
            if (ImGuiEx::BeginLayout(name, 200, 200, 1, 1, 1, 1)) {
				ImGuiEx::ShowLayoutDebug();
                if (ImGuiEx::BeginLayout("child", 170, 170, 2, 2, 2, 2)) {
					ImGuiEx::ShowLayoutDebug();
                    renderContent(false);
                }
				ImGuiEx::EndLayout();
            }
			ImGuiEx::EndLayout();

            if (ImGuiEx::BeginLayout("child", 150, 150, 2, 2, 2, 2)) {
				ImGuiEx::ShowLayoutDebug();
                renderContent(false);
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));
    }
    
    inline void test14(const char* name, bool debug) {
        ImGuiContext& g = *GImGui;
        HelpMarker("Test algin");

        static float paddingX = 0.0f;
        static float paddingY = 0.0f;
        static float alignX = 0.5f;
        static float offsetX = 0.0f;
        static float alignY = 0.5f;
        static float offsetY = 0.0f;
        ImGui::SliderFloat("Layout Padding X", &paddingX, 0.0f, 10.0f, "%.0f");
        ImGui::SliderFloat("Layout Padding Y", &paddingY, 0.0f, 10.0f, "%.0f");
		ImGui::SliderFloat("AlignX", &alignX, 0.0f, 1.0f, "%.2f");
        ImGui::SliderFloat("AlignY", &alignY, 0.0f, 1.0f, "%.2f");
        ImGui::SliderFloat("OffsetX", &offsetX, -10.0f, 10.0f, "%.2f");
        ImGui::SliderFloat("OffsetY", &offsetY, -10.0f, 10.0f, "%.2f");

        if (ImGuiEx::BeginLayout(name, ImLayout::MATCH_PARENT, 200, paddingX, paddingX, paddingY, paddingY)) {
            ImU32 bgColor = ImGui::GetColorU32(ImVec4(0x44 / 255.0f, 0x44 / 255.0f, 0x44 / 255.0f, 100 / 255.0f));
            paintLayout(bgColor);

			std::cout << "----------" << std::endl;
			std::cout << "Size 01: " << ImGui::GetContentRegionAvail().y << std::endl;

			ImGuiEx::AlignLayout(alignX, alignY, offsetX, offsetY);

			std::cout << "Size 02: " << ImGui::GetContentRegionAvail().y << std::endl;

            ImGui::Button("Hello   1", ImVec2(0, 40));
            ImGui::SameLine();

			std::cout << "Size 03: " << ImGui::GetContentRegionAvail().y << std::endl;

            ImGui::Button("Hello ", ImVec2(0, 0));
            ImGui::SameLine();
            ImGui::Button("Hello ", ImVec2(0, 60));

            ImGui::SameLine();
            ImGui::Button("Hello3", ImVec2(0, 0));
        }
		ImGuiEx::EndLayout();
    }
	
	inline void test15(const char* name, bool debug) {
        ImGuiContext& g = *GImGui;
		ImGuiWindow* window = g.CurrentWindow;
        HelpMarker("Test Layout with Columns");

        static float paddingX = 0.0f;
        static float paddingY = 0.0f;
        static float alignX = 0.5f;
        static float offsetX = 0.0f;
        static float alignY = 0.5f;
        static float offsetY = 0.0f;
        ImGui::SliderFloat("Layout Padding X", &paddingX, 0.0f, 10.0f, "%.0f");
        ImGui::SliderFloat("Layout Padding Y", &paddingY, 0.0f, 10.0f, "%.0f");
		ImGui::SliderFloat("AlignX", &alignX, 0.0f, 1.0f, "%.2f");
        ImGui::SliderFloat("AlignY", &alignY, 0.0f, 1.0f, "%.2f");
        ImGui::SliderFloat("OffsetX", &offsetX, -10.0f, 10.0f, "%.2f");
        ImGui::SliderFloat("OffsetY", &offsetY, -10.0f, 10.0f, "%.2f");

		ImGui::Columns(2);
   

		if(ImGui::GetColumnIndex() == 0)
			ImGui::Separator();


		ImVec2 content_avail = ImGui::GetContentRegionAvail();
		const ImU32 col = ImColor(ImVec4(1.0f, 1.0f, 0.4f, 1.0f));
		float xx = 0;
		float yy = 0;
		xx = window->DC.CursorPos.x;
		yy = window->DC.CurrentColumns->LineMinY;
		ImGui::GetWindowDrawList()->AddCircleFilled(ImVec2(xx, yy), 5, col , 24);

		std::cout << "content_avail: " << content_avail.y << std::endl;
		
		ImGui::Text("Left Item Column 01");
		
		
		ImGui::NextColumn();

		xx = window->DC.CursorPos.x;
		yy = window->DC.CurrentColumns->LineMinY;
		ImGui::GetWindowDrawList()->AddCircleFilled(ImVec2(xx, yy), 5, col, 24);

		content_avail = ImGui::GetContentRegionAvail();

		ImGui::Button("Right Button 01", ImVec2(0, 200));


		ImGui::NextColumn();

		xx = window->DC.CursorPos.x;
		yy = window->DC.CurrentColumns->LineMinY;
		ImGui::GetWindowDrawList()->AddCircleFilled(ImVec2(xx, yy), 5, col, 24);

		if (ImGui::GetColumnIndex() == 0)
			ImGui::Separator();

		ImGui::Text("Left Item Column 02");

		ImGui::NextColumn();

		ImGui::Button("Right Button 05");
		ImGui::Button("Right Button 06");
		ImGui::Button("Right Button 07");
		ImGui::Button("Right Button 08");

		ImGui::Columns(1);
    }

    inline void testFail01(const char* name, bool debug) {
        char* idChild = catStr(name, "child");
        char* idChild2 = catStr(name, "child2");
        char* idChild3 = catStr(name, "child3");
        char* idChild4 = catStr(name, "child4");
        char* idChild5 = catStr(name, "child5");
        char* idChild6 = catStr(name, "child6");
        char* idChild7 = catStr(name, "child7");

        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild4, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, 0, 0, 0, 0)) {
                renderContent(false);

                ImGui::SameLine();
                if (ImGuiEx::BeginLayout(idChild6, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, 0, 0, 0, 0)) {

                    ImGui::Text("This is a Texaaaaat");
                    ImGui::TextWrapped("This is a WrappeddddddddddddddText");
                    ImGui::Button("B 01", ImVec2(ImLayout::MATCH_PARENT, 0));
                    ImGui::Button("B 02", ImVec2(0, 0));
                }
				ImGuiEx::EndLayout();

                ImGui::SameLine();
                if (ImGuiEx::BeginLayout(idChild7, ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, 0, 0, 0, 0))
                    renderContent(false);
				ImGuiEx::EndLayout();

            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        delete[] idChild;
    }

    inline void testFail02(const char* name, bool debug) {
        char* idChild = catStr(name, "child");
        char* idChild2 = catStr(name, "child2");
        char* idChild3 = catStr(name, "child3");
        char* idChild4 = catStr(name, "child4");
        char* idChild5 = catStr(name, "child5");
        char* idChild6 = catStr(name, "child6");
        char* idChild7 = catStr(name, "child7");

        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            if (ImGuiEx::BeginLayout(idChild4, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, 0, 0, 0, 0)) {

                renderContent(false);

                ImGui::SameLine();

                if (ImGuiEx::BeginLayout(idChild6, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, 0, 0, 0, 0)) {

                    ImGui::Text("This is a Texaaaaat");
                    ImGui::TextWrapped("This is a WrappeddddddddddddddText");
                    ImGui::Button("B 01", ImVec2(ImLayout::MATCH_PARENT, 0));
                    ImGui::Button("B 02", ImVec2(0, 0));
                }
				ImGuiEx::EndLayout();

                ImGui::SameLine();
                if (ImGuiEx::BeginLayout(idChild7, 150, ImLayout::MATCH_PARENT, 0, 0, 0, 0))
                    renderContent(false);
				ImGuiEx::EndLayout();

                if (ImGuiEx::BeginLayout(idChild, 300, ImLayout::MATCH_PARENT, 0, 0, 0, 0))
                    renderContent(false);
				ImGuiEx::EndLayout();
            }
			ImGuiEx::EndLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));

        delete[] idChild;
    }

    inline void example01(const char* name) {
		static float paddingLeft = 0.0f;
		static float paddingTop = 0.0f;
		static float paddingRight = 0.0f;
		static float paddingBottom = 0.0f;
		ImGui::SliderFloat("Layout Padding Left", &paddingLeft, 0.0f, 10.0f, "%.0f");
		ImGui::SliderFloat("Layout Padding Right", &paddingRight, 0.0f, 10.0f, "%.0f");
		ImGui::SliderFloat("Layout Padding Top", &paddingTop, 0.0f, 10.0f, "%.0f");
		ImGui::SliderFloat("Layout Padding Bottom", &paddingBottom, 0.0f, 10.0f, "%.0f");
		ImGuiCollapseLayoutOptions options;
		options.paddingLeft = paddingLeft;
		options.paddingRight = paddingRight;
		options.paddingTop = paddingTop;
		options.paddingBottom = paddingBottom;

        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            bool isOpen = ImGuiEx::BeginCollapseLayout("Title", ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, options);
			if (isOpen) {
				ImU32 bgColor = ImGui::GetColorU32(ImVec4(0x44 / 255.0f, 0x44 / 255.0f, 0x44 / 255.0f, 100 / 255.0f));
				paintLayout(bgColor);
                renderContent(false);
			}
			ImGuiEx::EndCollapseLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));
    }
    
    inline void example02(const char* name) {
        static bool isOpen = false;
        static bool isOpen2 = false;
        static bool isOpen3 = false;


        ImGui::Button("Outside Begin", ImVec2(150, 0));
        {
			ImGuiEx::BeginCollapseLayout(&isOpen, "Left", 150, ImLayout::WRAP_PARENT);
            if (isOpen) {
                renderContent(false);
            }
			ImGuiEx::EndCollapseLayout();

            ImGui::SameLine();

			ImGuiEx::BeginCollapseLayout(&isOpen2, "Right", 150, ImLayout::WRAP_PARENT);
            if (isOpen2) {

                renderContent(false);

				ImGuiEx::BeginCollapseLayout(&isOpen3, "Child", ImLayout::MATCH_PARENT, 120);
             
				ImGuiEx::EndCollapseLayout();
            }
			ImGuiEx::EndCollapseLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));
    }

    inline void example03(const char* name) {
        static bool isOpen = false;
        static bool isOpen2 = false;
        static bool isOpen3 = false;


        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            ImGuiCollapseLayoutOptions options;
			ImGuiEx::BeginCollapseLayoutEx(&isOpen, "Left", ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, options);

			std::cout << "Size1: " << ImGui::GetContentRegionAvail().y << std::endl;

			ImGuiEx::BeginAlign("id011", ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, 1.0f, 0.5f, -5);

			float size = ImGui::GetContentRegionAvail().y;

			std::cout << "Size2: " << size << std::endl;
            ImGui::Text("Right Align Text");
			ImGuiEx::EndAlign();

			ImGuiEx::EndCollapseFrameLayout();
            if(isOpen) {
                renderContent(false);
            }
			ImGuiEx::EndCollapseLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));
    }

    inline void example04(const char* name) {

        ImGui::Button("Outside Begin", ImVec2(ImLayout::MATCH_PARENT, 0));
        {
            ImGuiCollapseLayoutOptions options;
            bool isOpen = ImGuiEx::BeginCollapseLayoutEx("Left", ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, options);

			std::cout << "Size1: " << ImGui::GetContentRegionAvail().y << std::endl;

			ImGuiEx::BeginAlign("id011", ImLayout::WRAP_PARENT, ImLayout::MATCH_PARENT, 0.0f, 0.5f);

			float size = ImGui::GetContentRegionAvail().y;

			std::cout << "Size2: " << ImGui::GetContentRegionAvail().y << std::endl;

			int padding = 2;
			ImGui::ImageButton(0, ImVec2(15, size - padding*2), ImVec2(0,0), ImVec2(1,1), padding);
			
			ImGuiEx::EndAlign();
     
			ImGui::SameLine();

			ImGuiEx::BeginAlign("id012", ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, 1.0f, 0.5f, -5);
			ImGuiEx::ShowLayoutDebug();

            ImGui::Text("Right Align Text");

			ImGuiEx::EndAlign();

			ImGuiEx::EndCollapseFrameLayout();
            if(isOpen) {
                renderContent(false);
            }
			ImGuiEx::EndCollapseLayout();
        }
        ImGui::Button("Outside End", ImVec2(ImLayout::MATCH_PARENT, 0));
    }

    inline void ShowLayoutTests()
    {
        static int e = 0;
        ImGui::Begin("Tests", NULL, ImGuiWindowFlags_HorizontalScrollbar);

        int i = 0;
        ImGui::RadioButton("test01", &e, i++);
        ImGui::RadioButton("test02", &e, i++);
        ImGui::RadioButton("test03", &e, i++);
        ImGui::RadioButton("test04", &e, i++);
        ImGui::RadioButton("test05", &e, i++);
        ImGui::RadioButton("test06", &e, i++);
        ImGui::RadioButton("test07", &e, i++);
        ImGui::RadioButton("test08", &e, i++);
        ImGui::RadioButton("test09", &e, i++);
        ImGui::RadioButton("test10", &e, i++);
        ImGui::RadioButton("test11", &e, i++);
        ImGui::RadioButton("test12", &e, i++);
        ImGui::RadioButton("test13", &e, i++);
        ImGui::RadioButton("test14", &e, i++);
        ImGui::RadioButton("test15", &e, i++);
        ImGui::RadioButton("example01", &e, i++);
        ImGui::RadioButton("example02", &e, i++);
        ImGui::RadioButton("example03", &e, i++);
        ImGui::RadioButton("example04", &e, i++);

        i = 0;
        ImGui::Begin("Test", NULL, ImGuiWindowFlags_HorizontalScrollbar);
        if(e == i++)
            test01("test01", false);
        if (e == i++)
            test02("test02", false);
        if (e == i++)
            test03("test03", false);
        if (e == i++)
            test04("test04", false);
        if (e == i++)
            test05("test05", false);
        if (e == i++)
            test06("test06", false);
        if (e == i++)
            test07("test07", false);
        if (e == i++)
            test08("test08", false);
        if (e == i++)
            test09("test09", false);
        if (e == i++)
            test10("test10", false);
        if (e == i++)
            test11("test10", false);
        if (e == i++)
            test12("test12", false);
        if (e == i++)
            test13("test13", false);
        if (e == i++)
            test14("test14", false);
        if (e == i++)
			test15("test15", false);
        if (e == i++)
            example01("example01");
        if (e == i++)
            example02("example02");
        if (e == i++)
            example03("example03");
        if (e == i++)
			example04("example04");
        ImGui::End();

        ImGui::End();
    };
}

