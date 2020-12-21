#pragma once

#include "imgui.h"
#include "imgui_internal.h"
#include "imgui_layout.h"
#include "imgui_ext.h"
#include <iostream>
using namespace std;

static void renderContent(bool verticalButtonFill) {
	ImGuiWindow* window = ImGui::GetCurrentWindow();
	ImGuiWindowTempData& DC = window->DC;
	ImGui::Button("B 00", ImVec2(-0.1f, 0));
	ImGui::Text("This is a Text");
	ImGui::TextWrapped("This is a WrappeddddddddddddddText");
	ImGui::Button("B 01", ImVec2(-0.1f, 0));
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

namespace ImGuiExt
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
		ImGui::Button("Outside Begin", ImVec2(-0.1, 0));
		{
			if (ImGuiExt::BeginLayout(idChild, ImLayout::WRAP_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(0, 0, 0, 0))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		HelpMarker("Layout with\nX: WRAP_PARENT\nY: WRAP_PARENT\nPaddingLeft: 40\nPaddingRight: 0");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild2, ImLayout::WRAP_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(40, 0, 0, 0))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		HelpMarker("Layout with\nX: WRAP_PARENT\nY: WRAP_PARENT\nPaddingLeft: 0\nPaddingRight: 40");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild3, ImLayout::WRAP_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(0, 40, 0, 0))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		HelpMarker("Layout with\nX: WRAP_PARENT\nY: WRAP_PARENT\nPaddingLeft: 40\nPaddingRight: 40");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild4, ImLayout::WRAP_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(40, 40, 0, 0))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));
		delete[] idChild;


	}

	inline void test02(const char* name, bool debug) {
		char* idChild = catStr(name, "child");
		char* idChild2 = catStr(name, "child2");
		char* idChild3 = catStr(name, "child3");
		char* idChild4 = catStr(name, "child4");
		HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingLeft: 0\nPaddingRight: 0");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(2, 2, 0, 0))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingLeft: 40\nPaddingRight: 0");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild2, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(40, 0, 0, 0))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingLeft: 0\nPaddingRight: 40");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild3, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(0, 40, 0, 0))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingLeft: 40\nPaddingRight: 40");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild4, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(40, 40, 0, 0))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		delete[] idChild;
	}

	inline void test03(const char* name, bool debug) {
		char* idChild = catStr(name, "child");
		char* idChild2 = catStr(name, "child2");
		char* idChild3 = catStr(name, "child3");
		char* idChild4 = catStr(name, "child4");

		HelpMarker("Layout with\nX: 300\nY: 110\nPaddingLeft: 0\nPaddingRight: 0");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{

			ImU32 bgColor = ImGui::GetColorU32(ImVec4(0xFF / 255.0f, 0x00 / 255.0f, 0x00 / 255.0f, 255 / 255.0f));
			paintLayout(bgColor, ImVec2(300, 110));

			if (ImGuiExt::BeginLayout(idChild, 300, 110, ImGuiLayoutOptions(0, 0, 0, 0))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		HelpMarker("Layout with\nX: 300\nY: 110\nPaddingLeft: 40\nPaddingRight: 0");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			ImU32 bgColor = ImGui::GetColorU32(ImVec4(0xFF / 255.0f, 0x00 / 255.0f, 0x00 / 255.0f, 255 / 255.0f));
			paintLayout(bgColor, ImVec2(300, 110));
			if (ImGuiExt::BeginLayout(idChild2, 300, 110, ImGuiLayoutOptions(40, 0, 0, 0))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		HelpMarker("Layout with\nX: 300\nY: 110\nPaddingLeft: 0\nPaddingRight: 40");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			ImU32 bgColor = ImGui::GetColorU32(ImVec4(0xFF / 255.0f, 0x00 / 255.0f, 0x00 / 255.0f, 255 / 255.0f));
			paintLayout(bgColor, ImVec2(300, 110));

			if (ImGuiExt::BeginLayout(idChild2, 300, 110, ImGuiLayoutOptions(0, 40, 0, 0))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		HelpMarker("Layout with\nX: 300\nY: 110\nPaddingLeft: 40\nPaddingRight: 40");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild4, 300, 110, ImGuiLayoutOptions(40, 40, 0, 0))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		delete[] idChild;
	}

	inline void test04(const char* name, bool debug) {
		char* idChild = catStr(name, "child");
		char* idChild2 = catStr(name, "child2");
		char* idChild3 = catStr(name, "child3");
		char* idChild4 = catStr(name, "child4");

		HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingTop: 40\nPaddingBottom: 0");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(0, 0, 40, 00))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingTop: 0\nPaddingBottom: 40");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild2, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(0, 0, 0, 40))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingTop: 40\nPaddingBottom: 40");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild3, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(0, 0, 40, 40))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		delete[] idChild;
	}

	inline void test05(const char* name, bool debug) {
		HelpMarker("Layout with\nX: MATCH_PARENT\nY: MATCH_PARENT\nPaddingTop: 40\nPaddingBottom: 0");
		char* idChild = catStr(name, "child");
		char* idChild2 = catStr(name, "child2");
		char* idChild3 = catStr(name, "child3");
		char* idChild4 = catStr(name, "child4");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, ImGuiLayoutOptions(0, 0, 40, 0))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		delete[] idChild;
	}

	inline void test06(const char* name, bool debug) {
		HelpMarker("Layout with\nX: MATCH_PARENT\nY: MATCH_PARENT\nPaddingTop: 0\nPaddingBottom: 40");
		char* idChild = catStr(name, "child");
		char* idChild2 = catStr(name, "child2");
		char* idChild3 = catStr(name, "child3");
		char* idChild4 = catStr(name, "child4");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, ImGuiLayoutOptions(0, 0, 0, 40))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(true);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		delete[] idChild;
	}

	inline void test07(const char* name, bool debug) {
		HelpMarker("Layout with\nX: MATCH_PARENT\nY: MATCH_PARENT\nPaddingTop: 40\nPaddingBottom: 40");
		char* idChild = catStr(name, "child");
		char* idChild2 = catStr(name, "child2");
		char* idChild3 = catStr(name, "child3");
		char* idChild4 = catStr(name, "child4");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, ImGuiLayoutOptions(0, 0, 40, 40))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(true);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		delete[] idChild;
	}

	inline void test08(const char* name, bool debug) {
		HelpMarker("Layout with\nX: MATCH_PARENT\nY: 200\nPaddingTop: 0\nPaddingBottom: 40");
		char* idChild = catStr(name, "child");
		char* idChild2 = catStr(name, "child2");
		char* idChild3 = catStr(name, "child3");
		char* idChild4 = catStr(name, "child4");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild, ImLayout::MATCH_PARENT, 200, ImGuiLayoutOptions(0, 0, 0, 40))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(true);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		delete[] idChild;
	}

	inline void test09(const char* name, bool debug) {
		HelpMarker("Layout with\nX: MATCH_PARENT\nY: MATCH_PARENT\nPaddingLeft: 40\nPaddingRight: 40\nPaddingTop: 40\nPaddingBottom: 40");
		char* idChild = catStr(name, "child");
		char* idChild2 = catStr(name, "child2");
		char* idChild3 = catStr(name, "child3");
		char* idChild4 = catStr(name, "child4");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, ImGuiLayoutOptions(40, 40, 40, 40))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(true);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		delete[] idChild;
	}

	inline void test10(const char* name, bool debug) {
		HelpMarker("Layout with\nX: MATCH_PARENT\nY: WRAP_PARENT\nPaddingleft: 2\nPaddingRight: 2\nPaddingTop: 2\nPaddingBottom: 2");
		char* idChild = catStr(name, "child");
		char* idChild2 = catStr(name, "child2");
		char* idChild3 = catStr(name, "child3");
		char* idChild4 = catStr(name, "child4");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(2, 2, 2, 2))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		delete[] idChild;
	}

	inline void test11(const char* name, bool debug) {
		HelpMarker("Multi child layout test");
		char* idChild = catStr(name, "child");
		char* idChild2 = catStr(name, "child2");
		char* idChild3 = catStr(name, "child3");
		char* idChild4 = catStr(name, "child4");
		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild, ImLayout::MATCH_PARENT, 200, ImGuiLayoutOptions(1, 1, 1, 1))) {

				ImGui::Button("Button Layout 01", ImVec2(-0.1f, 0));
				ImU32 bgColor = ImGui::GetColorU32(ImVec4(0xFF / 255.0f, 0x00 / 255.0f, 0x00 / 255.0f, 255 / 255.0f));
				paintLayout(bgColor);

				if (ImGuiExt::BeginLayout(idChild2, ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, ImGuiLayoutOptions(4, 4, 4, 4))) {
					ImU32 bgColor = ImGui::GetColorU32(ImVec4(0x00 / 255.0f, 0xFF / 255.0f, 0x00 / 255.0f, 255 / 255.0f));
					paintLayout(bgColor);

					if (ImGuiExt::BeginLayout(idChild3, ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, ImGuiLayoutOptions(4, 4, 4, 4))) {
						ImU32 bgColor = ImGui::GetColorU32(ImVec4(0x00 / 255.0f, 0x00 / 255.0f, 0xFF / 255.0f, 255 / 255.0f));
						paintLayout(bgColor);
					}
					ImGuiExt::EndLayout();
				}
				ImGuiExt::EndLayout();
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

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
			ImGuiExt::BeginLayout(idChild4, 200, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(0, 0, 0, 0));

			ImU32 bgColor = ImGui::GetColorU32(ImVec4(0xFF / 255.0f, 0xFF / 255.0f, 0xFF / 255.0f, 255 / 255.0f));
			paintLayout(bgColor);
			if (ImGuiExt::BeginLayout(idChild, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(paddingLeft, paddingRight, paddingTop, paddingBottom))) {
				ImU32 bgColor = ImGui::GetColorU32(ImVec4(0xFF / 255.0f, 0x00 / 255.0f, 0x00 / 255.0f, 255 / 255.0f));
				paintLayout(bgColor);
				if (ImGuiExt::BeginLayout(idChild3, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(paddingLeft2, paddingRight2, paddingTop2, paddingBottom2))) {
					ImU32 bgColor = ImGui::GetColorU32(ImVec4(0x00 / 255.0f, 0x00 / 255.0f, 0xFF / 255.0f, 255 / 255.0f));
					paintLayout(bgColor);
					renderContent(false);
				}
				ImGuiExt::EndLayout();
			}
			ImGuiExt::EndLayout();

			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

		delete[] idChild;
	}

	inline void test13(const char* name, bool debug) {
		ImGuiContext& g = *GImGui;
		HelpMarker("Combining IDs test");
		ImGui::Button("Outside Begin", ImVec2(150, 0));
		{
			if (ImGuiExt::BeginLayout(name, 200, 200, ImGuiLayoutOptions(1, 1, 1, 1))) {
				ImGuiExt::ShowLayoutDebug();
				if (ImGuiExt::BeginLayout("child", 170, 170, ImGuiLayoutOptions(2, 2, 2, 2))) {
					ImGuiExt::ShowLayoutDebug();
					renderContent(false);
				}
				ImGuiExt::EndLayout();
			}
			ImGuiExt::EndLayout();

			if (ImGuiExt::BeginLayout("child", 150, 150, ImGuiLayoutOptions(2, 2, 2, 2))) {
				ImGuiExt::ShowLayoutDebug();
				renderContent(false);
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));
	}

	inline void test14(const char* name, bool debug) {
		ImGuiContext& g = *GImGui;
		HelpMarker("Test if a widget size match the same layout size if there is no padding");

		char* idChild = catStr(name, "child");
		char* idChild2 = catStr(name, "child2");
		char* idChild3 = catStr(name, "child3");

		static float paddingLeft = 0.0f;
		static float paddingTop = 0.0f;
		static float paddingRight = 0.0f;
		static float paddingBottom = 0.0f;
		ImGui::SliderFloat("Layout Padding Left", &paddingLeft, 0.0f, 100.0f, "%.0f");
		ImGui::SliderFloat("Layout Padding Right", &paddingRight, 0.0f, 100.0f, "%.0f");
		ImGui::SliderFloat("Layout Padding Top", &paddingTop, 0.0f, 100.0f, "%.0f");
		ImGui::SliderFloat("Layout Padding Bottom", &paddingBottom, 0.0f, 100.0f, "%.0f");

		float mouseX = g.IO.MousePos.x;
		float mouseY = g.IO.MousePos.y;
		//std::cout << "" << std::endl;
		//std::cout << "" << std::endl;
		//std::cout << "" << std::endl;
		//std::cout << "" << std::endl;
		//std::cout << "" << std::endl;
		//std::cout << "MouseX: " << mouseX << std::endl;
		//std::cout << "mouseY: " << mouseY << std::endl;

		ImGui::Button("Outside Begin", ImVec2(150, 0));
		{
			ImGui::Text("Layout SizeX: MATCH_PARENT, SizeY: 16");
			if (ImGuiExt::BeginLayout(idChild, ImLayout::MATCH_PARENT, 16, ImGuiLayoutOptions(paddingLeft, paddingRight, paddingTop, paddingBottom))) {
				ImGuiExt::ShowLayoutDebug();
				ImU32 bgColor = ImGui::GetColorU32(ImVec4(0x00 / 255.0f, 0x00 / 255.0f, 0xFF / 255.0f, 255 / 255.0f));
				paintLayout(bgColor);
			}
			ImGuiExt::EndLayout();
			
			ImGui::Text("Layout SizeX: 16, SizeY: WRAP_CONTENT");
			if (ImGuiExt::BeginLayout(idChild2, 16, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(paddingLeft, paddingRight, paddingTop, paddingBottom))) {
				ImGuiExt::ShowLayoutDebug();
				ImGui::Button("TEST", ImVec2(-0.1f, 0));
			}
			ImGuiExt::EndLayout();

			ImGui::Text("Layout SizeX: WRAP_PARENT, SizeY: MATCH_PARENT");
			if (ImGuiExt::BeginLayout(idChild3, ImLayout::WRAP_PARENT, ImLayout::MATCH_PARENT, ImGuiLayoutOptions(paddingLeft, paddingRight, paddingTop, paddingBottom))) {
				ImGuiExt::ShowLayoutDebug();
				ImGui::Button("TEST", ImVec2(0, -0.1f));
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));
	}

	inline void test15(const char* name, bool debug) {
		ImGuiContext& g = *GImGui;
		static float vec4f[4] = { 0.10f, 0.20f, 0.30f, 0.44f };

		static float value = 0;

		ImGui::SetNextItemWidth(-1);
		float calcWidth = ImGui::CalcItemWidth();

		float width = calcWidth / 3;

		ImGui::Text("calcWidth: %.3f", calcWidth);
		ImGui::Text("width: %.3f", width);
		ImGui::Text("g.Style.ItemInnerSpacing.x: %.3f", g.Style.ItemInnerSpacing.x);

		ImGuiExt::FillWidth(255, 0, 0, 255, ImVec2(calcWidth, 20));

		ImGuiExt::FillWidth(255, 0, 0, 255, ImVec2(width, 20));
		ImGui::SameLine(0, 0);
		ImGuiExt::FillWidth(0, 255, 0, 255, ImVec2(width, 20));
		ImGui::SameLine(0, 0);
		ImGuiExt::FillWidth(0, 0, 255, 255, ImVec2(width, 20));

		ImGui::SetNextItemWidth(-1);
		ImGui::DragFloat3("", vec4f, 0.01f, 0.0f, 1.0f);

		ImGui::SetNextItemWidth(-1);
		ImGui::DragFloat("", &value, 0.01f, 0, 0, "%.3f");

		static EditTextData<float> df1("%.3f", "X:", "Tooltip 01");
		static EditTextData<float> df2("%.2f", "Y:", "Tooltip 02");
		static EditTextData<float> df3("%.3f", "Z:", "Tooltip 03");
		static EditTextData<float> df4("%.3f", "W:", "Tooltip 04");

		static EditTextData<int> di1("%d", "X:", "Tooltip 01");
		static EditTextData<int> di2("%d", "Y:", "Tooltip 02");

		df1.leftLabelColor = IM_COL32(255, 0, 0, 255);
		df1.leftLabelDragColor = IM_COL32(255, 0, 255, 255);
		df2.leftLabelColor = IM_COL32(0, 255, 0, 255);
		df2.v_speed = 0.01f;
		df2.v_max = 4.3f;
		df2.v_min = -4.3f;
		df3.leftLabelColor = IM_COL32(0, 0, 255, 255);

		di2.v_min = -10;
		di2.v_max = 10;
		ImGui::PushItemFlag(ImGuiItemFlags_Disabled, true);
		ImGuiExt::EditTextF("##id1", &df1, NULL, NULL, NULL, 0);
		ImGui::PopItemFlag();

		ImGuiExt::EditTextF("##id2", &df1, &df2);

		int index = ImGuiExt::EditTextF("##id3", &df1, &df2, &df3);

		if (index != -1)
			cout << "Value changed index: " << index << endl;

		ImGuiExt::EditTextF("##id4", &df1, &df2, &df3, &df4);

		ImGuiExt::EditTextI("##id5", &di1, &di2);

		static EditTextData<std::string> text1(NULL, "S:", "Tooltip String");

		ImGuiExt::EditTextS("##id6", &text1);
	}

	inline void test16(const char* name, bool debug) {
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

		if (ImGuiExt::BeginLayout(name, ImLayout::MATCH_PARENT, 200, ImGuiLayoutOptions(paddingX, paddingX, paddingY, paddingY))) {
			ImU32 bgColor = ImGui::GetColorU32(ImVec4(0x44 / 255.0f, 0x44 / 255.0f, 0x44 / 255.0f, 100 / 255.0f));
			paintLayout(bgColor);

			//std::cout << "----------" << std::endl;
			//std::cout << "Size 01: " << ImGui::GetContentRegionAvail().y << std::endl;

			ImGuiExt::AlignLayout(alignX, alignY, offsetX, offsetY);

			//std::cout << "Size 02: " << ImGui::GetContentRegionAvail().y << std::endl;

			ImGui::Button("Hello   1", ImVec2(0, 40));
			ImGui::SameLine();

			//std::cout << "Size 03: " << ImGui::GetContentRegionAvail().y << std::endl;

			ImGui::Button("Hello ", ImVec2(0, 0));
			ImGui::SameLine();
			ImGui::Button("Hello ", ImVec2(0, 60));

			ImGui::SameLine();
			ImGui::Button("Hello3", ImVec2(0, 0));
		}
		ImGuiExt::EndLayout();
	}

	inline void test17(const char* name, bool debug) {
		ImGuiExt::BeginBoundingBox();
		ImGui::Button("TEST", ImVec2(50, 0));
		ImRect boundingBox = ImGuiExt::EndBoundingBox();
		ImGuiExt::DrawBoundingBox(boundingBox.Min, boundingBox.Max, 255, 0, 0, 90);

		ImGuiExt::BeginBoundingBox();
		ImGui::Button("TEST", ImVec2(50, 0));
		ImGui::Button("TEST", ImVec2(30, 0));
		boundingBox = ImGuiExt::EndBoundingBox();
		ImGuiExt::DrawBoundingBox(boundingBox.Min, boundingBox.Max, 255, 0, 0, 90);

		ImGuiExt::BeginBoundingBox();
		ImGui::Button("TEST", ImVec2(50, 0));
		ImGui::SameLine();
		ImGui::Button("TEST", ImVec2(30, 0));
		boundingBox = ImGuiExt::EndBoundingBox();
		ImGuiExt::DrawBoundingBox(boundingBox.Min, boundingBox.Max, 255, 0, 0, 90);
	}

	inline void test18(const char* name, bool debug) {
		ImGuiStyle& style = ImGui::GetStyle();

		// Set up sliders

		static float alignX = 0.5f;
		static float alignY = 0.5f;

		ImGui::SliderFloat("AlignX", &alignX, 0.0f, 1.0f, "%.2f");
		ImGui::SliderFloat("AlignY", &alignY, 0.0f, 1.0f, "%.2f");

		static float btnHeight01 = 90;
		ImGui::SliderFloat("Height01", &btnHeight01, 0.0f, 250.0f, "%.0f");

		static float btnHeight02 = 60;
		ImGui::SliderFloat("Height02", &btnHeight02, 0.0f, 250.0f, "%.0f");

		static float btnHeight03 = 70;
		ImGui::SliderFloat("Height03", &btnHeight03, 0.0f, 250.0f, "%.0f");

		static float btnHeight04 = 40;
		ImGui::SliderFloat("Height04", &btnHeight04, 0.0f, 250.0f, "%.0f");

		ImGui::SliderFloat2("CellPadding", (float*)&style.CellPadding, 0.0f, 20.0f, "%.0f");

		// FIRST TABLE

		if (ImGui::BeginTable("01", 4, ImGuiTableFlags_Borders | ImGuiTableFlags_Resizable | ImGuiTableFlags_Reorderable))
		{
			ImGui::TableSetupColumn("A0", ImGuiTableColumnFlags_WidthFixed);
			ImGui::TableSetupColumn("A1");
			ImGui::TableSetupColumn("A2");
			ImGui::TableSetupColumn("A3");
			ImGui::TableHeadersRow();

			ImGui::TableNextColumn();

			float maxHeight1 = ImGuiExt::GetTableRowHeight();

			ImGui::Text("Row Height: %.1f", maxHeight1);

			ImGui::Button("01", ImVec2(0, btnHeight01));

			float contentHeight01 = ImGuiExt::GetTableContentHeight();

			ImGuiExt::CalculateTableRowHeight();

			ImGui::TableNextColumn();

			ImGuiExt::BeginLayout("###idd", ImLayout::MATCH_PARENT, maxHeight1 == 0 ? ImLayout::WRAP_PARENT : maxHeight1);
			ImGuiExt::ShowLayoutDebug();
			ImGuiExt::AlignLayout(alignX, alignY);
			ImGui::Text("MyText");
			ImGuiExt::EndLayout();

			float contentHeight02 = ImGuiExt::GetTableContentHeight();
			//ImGuiExt::CalculateTableRowHeight(); // since this view depends of row height there is no need to calculate

			ImGui::TableNextColumn();

			ImGui::Button("03", ImVec2(0, btnHeight03));

			float contentHeight03 = ImGuiExt::GetTableContentHeight();

			ImGuiExt::CalculateTableRowHeight();

			ImGui::TableNextColumn();

			ImGui::Button("04", ImVec2(0, btnHeight04));

			float contentHeight04 = ImGuiExt::GetTableContentHeight();

			ImGuiExt::CalculateTableRowHeight();

			// Next row
			ImGui::TableNextColumn();
			ImGui::Text("contentHeight01: %.1f", contentHeight01);
			ImGui::TableNextColumn();
			ImGui::Text("contentHeight02: %.1f", contentHeight02);
			ImGui::TableNextColumn();
			ImGui::Text("contentHeight03: %.1f", contentHeight03);
			ImGui::TableNextColumn();
			ImGui::Text("contentHeight04: %.1f", contentHeight04);

			ImGui::EndTable();
		}

		// SECOND TABLE

		if (ImGui::BeginTable("02", 4, ImGuiTableFlags_Borders | ImGuiTableFlags_Resizable | ImGuiTableFlags_Reorderable))
		{
			ImGui::TableSetupColumn("B0");
			ImGui::TableSetupColumn("B1");
			ImGui::TableSetupColumn("B2");
			ImGui::TableSetupColumn("B3");
			ImGui::TableHeadersRow();

			ImGui::TableNextColumn();

			float maxHeight1 = ImGuiExt::GetTableRowHeight();

			ImGui::Text("Row Height: %.1f", maxHeight1);

			ImGui::Button("01", ImVec2(0, btnHeight01));


			static bool check = false;
			ImGui::Checkbox("check", &check);

			float contentHeight01 = ImGuiExt::GetTableContentHeight();

			ImGuiExt::CalculateTableRowHeight();

			ImGui::TableNextColumn();

			ImGui::Button("02", ImVec2(0, btnHeight02));

			float contentHeight02 = ImGuiExt::GetTableContentHeight();
			ImGuiExt::CalculateTableRowHeight();

			ImGui::TableNextColumn();

			ImGui::Button("03", ImVec2(0, btnHeight03));

			float contentHeight03 = ImGuiExt::GetTableContentHeight();

			ImGuiExt::CalculateTableRowHeight();

			ImGui::TableNextColumn();

			ImGui::Button("04", ImVec2(0, btnHeight04));

			float contentHeight04 = ImGuiExt::GetTableContentHeight();

			ImGuiExt::CalculateTableRowHeight();

			// Next row
			ImGui::TableNextColumn();
			ImGui::Text("contentHeight01: %.1f", contentHeight01);
			ImGui::TableNextColumn();
			ImGui::Text("contentHeight02: %.1f", contentHeight02);
			ImGui::TableNextColumn();
			ImGui::Text("contentHeight03: %.1f", contentHeight03);
			ImGui::TableNextColumn();
			ImGui::Text("contentHeight04: %.1f", contentHeight04);

			ImGui::EndTable();
		}
	}

	inline void testFail01(const char* name, bool debug) {
		char* idChild = catStr(name, "child");
		char* idChild2 = catStr(name, "child2");
		char* idChild3 = catStr(name, "child3");
		char* idChild4 = catStr(name, "child4");
		char* idChild5 = catStr(name, "child5");
		char* idChild6 = catStr(name, "child6");
		char* idChild7 = catStr(name, "child7");

		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild4, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(0, 0, 0, 0))) {
				renderContent(false);

				ImGui::SameLine();
				if (ImGuiExt::BeginLayout(idChild6, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(0, 0, 0, 0))) {

					ImGui::Text("This is a Texaaaaat");
					ImGui::TextWrapped("This is a WrappeddddddddddddddText");
					ImGui::Button("B 01", ImVec2(-0.1f, 0));
					ImGui::Button("B 02", ImVec2(0, 0));
				}
				ImGuiExt::EndLayout();

				ImGui::SameLine();
				if (ImGuiExt::BeginLayout(idChild7, ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, ImGuiLayoutOptions(0, 0, 0, 0)))
					renderContent(false);
				ImGuiExt::EndLayout();

			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

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

		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			if (ImGuiExt::BeginLayout(idChild4, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(0, 0, 0, 0))) {

				renderContent(false);

				ImGui::SameLine();

				if (ImGuiExt::BeginLayout(idChild6, ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, ImGuiLayoutOptions(0, 0, 0, 0))) {

					ImGui::Text("This is a Texaaaaat");
					ImGui::TextWrapped("This is a WrappeddddddddddddddText");
					ImGui::Button("B 01", ImVec2(-0.1f, 0));
					ImGui::Button("B 02", ImVec2(0, 0));
				}
				ImGuiExt::EndLayout();

				ImGui::SameLine();
				if (ImGuiExt::BeginLayout(idChild7, 150, ImLayout::MATCH_PARENT, ImGuiLayoutOptions(0, 0, 0, 0)))
					renderContent(false);
				ImGuiExt::EndLayout();

				if (ImGuiExt::BeginLayout(idChild, 300, ImLayout::MATCH_PARENT, ImGuiLayoutOptions(0, 0, 0, 0)))
					renderContent(false);
				ImGuiExt::EndLayout();
			}
			ImGuiExt::EndLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));

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

		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			bool isOpen = ImGuiExt::BeginCollapseLayout("##id01", "Title", ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, options);
			if (isOpen) {
				ImU32 bgColor = ImGui::GetColorU32(ImVec4(0x44 / 255.0f, 0x44 / 255.0f, 0x44 / 255.0f, 100 / 255.0f));
				paintLayout(bgColor);
				renderContent(false);
			}
			ImGuiExt::EndCollapseLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));
	}

	inline void example02(const char* name) {
		static bool isOpen = false;
		static bool isOpen2 = false;
		static bool isOpen3 = false;


		ImGui::Button("Outside Begin", ImVec2(150, 0));
		{
			ImGuiExt::BeginCollapseLayout("##id01", &isOpen, "Left", 150, ImLayout::WRAP_PARENT);
			if (isOpen) {
				renderContent(false);
			}
			ImGuiExt::EndCollapseLayout();

			ImGui::SameLine();

			ImGuiExt::BeginCollapseLayout("##id02", &isOpen2, "Right", 150, ImLayout::WRAP_PARENT);
			if (isOpen2) {

				renderContent(false);

				ImGuiExt::BeginCollapseLayout("##id03", &isOpen3, "Child", ImLayout::MATCH_PARENT, 120);

				ImGuiExt::EndCollapseLayout();
			}
			ImGuiExt::EndCollapseLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));
	}

	inline void example03(const char* name) {
		static bool isOpen = false;
		static bool isOpen2 = false;
		static bool isOpen3 = false;


		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			ImGuiCollapseLayoutOptions options;
			ImGuiExt::BeginCollapseLayoutEx("##id01", &isOpen, "Left", ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, options);

			//std::cout << "Size1: " << ImGui::GetContentRegionAvail().y << std::endl;

			ImGuiExt::BeginAlign("id011", ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, 1.0f, 0.5f, -5);

			float size = ImGui::GetContentRegionAvail().y;

			//std::cout << "Size2: " << size << std::endl;
			ImGui::Text("Right Align Text");
			ImGuiExt::EndAlign();

			ImGuiExt::EndCollapseFrameLayout();
			if (isOpen) {
				renderContent(false);
			}
			ImGuiExt::EndCollapseLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));
	}

	inline void example04(const char* name) {

		ImGui::Button("Outside Begin", ImVec2(-0.1f, 0));
		{
			ImGuiCollapseLayoutOptions options;
			bool isOpen = ImGuiExt::BeginCollapseLayoutEx("##id01", "Left", ImLayout::MATCH_PARENT, ImLayout::WRAP_PARENT, options);

			//std::cout << "Size1: " << ImGui::GetContentRegionAvail().y << std::endl;

			ImGuiExt::BeginAlign("##id02", ImLayout::WRAP_PARENT, ImLayout::MATCH_PARENT, 0.0f, 0.5f);

			float size = ImGui::GetContentRegionAvail().y;

			//std::cout << "Size2: " << ImGui::GetContentRegionAvail().y << std::endl;

			int padding = 2;
			ImGui::ImageButton(0, ImVec2(15, size - padding * 2), ImVec2(0, 0), ImVec2(1, 1), padding);

			ImGuiExt::EndAlign();

			ImGui::SameLine();

			ImGuiExt::BeginAlign("##id03", ImLayout::MATCH_PARENT, ImLayout::MATCH_PARENT, 1.0f, 0.5f, -5);
			ImGuiExt::ShowLayoutDebug();

			ImGui::Text("Right Align Text");

			ImGuiExt::EndAlign();

			ImGuiExt::EndCollapseFrameLayout();
			if (isOpen) {
				renderContent(false);
			}
			ImGuiExt::EndCollapseLayout();
		}
		ImGui::Button("Outside End", ImVec2(-0.1f, 0));
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
		ImGui::RadioButton("test16", &e, i++);
		ImGui::RadioButton("test17", &e, i++);
		ImGui::RadioButton("test18", &e, i++);
		ImGui::RadioButton("example01", &e, i++);
		ImGui::RadioButton("example02", &e, i++);
		ImGui::RadioButton("example03", &e, i++);
		ImGui::RadioButton("example04", &e, i++);

		i = 0;
		ImGui::Begin("Test", NULL, ImGuiWindowFlags_HorizontalScrollbar);
		if (e == i++)
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
			test16("test16", false);
		if (e == i++)
			test17("test17", false);
		if (e == i++)
			test18("test18", false);
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
