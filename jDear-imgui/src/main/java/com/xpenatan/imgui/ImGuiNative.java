package com.xpenatan.imgui;

import java.nio.Buffer;

public class ImGuiNative {

	/*JNI
		#include <src/imgui.h>

		jfieldID totalVtxCountID;
		jfieldID totalIdxCountID;
		jfieldID totalCmdCountID;
		jfieldID CmdListsCountID;
		jfieldID displayPosXID;
		jfieldID displayPosYID;
		jfieldID displaySizeXID;
		jfieldID displaySizeYID;
		jfieldID framebufferScaleXID;
		jfieldID framebufferScaleYID;

		jfieldID WantCaptureMouseID;
		jfieldID WantCaptureKeyboardID;
		jfieldID WantTextInputID;
		jfieldID WantSetMousePosID;
		jfieldID WantSaveIniSettingsID;
		jfieldID NavActiveID;
		jfieldID NavVisibleID;
		jfieldID FramerateID;
		jfieldID MetricsRenderVerticesID;
		jfieldID MetricsRenderIndicesID;
		jfieldID MetricsRenderWindowsID;
		jfieldID MetricsActiveWindowsID;
		jfieldID MetricsActiveAllocationsID;
		jfieldID MouseDeltaXID;
		jfieldID MouseDeltaYID;
	*/

	public static native void init() /*-{ }-*/; /*
		jclass jDrawDataClass = env->FindClass("com/xpenatan/imgui/DrawData");
		jclass jImGuiIOClass = env->FindClass("com/xpenatan/imgui/ImGuiIO");

		// DrawData Prepare IDs
		totalVtxCountID = env->GetFieldID(jDrawDataClass, "totalVtxCount", "I");
		totalIdxCountID = env->GetFieldID(jDrawDataClass, "totalIdxCount", "I");
		totalCmdCountID = env->GetFieldID(jDrawDataClass, "totalCmdCount", "I");
		CmdListsCountID = env->GetFieldID(jDrawDataClass, "cmdListsCount", "I");
		displayPosXID = env->GetFieldID(jDrawDataClass, "displayPosX", "F");
		displayPosYID = env->GetFieldID(jDrawDataClass, "displayPosY", "F");
		displaySizeXID = env->GetFieldID(jDrawDataClass, "displaySizeX", "F");
		displaySizeYID = env->GetFieldID(jDrawDataClass, "displaySizeY", "F");
		framebufferScaleXID = env->GetFieldID(jDrawDataClass, "framebufferScaleX", "F");
		framebufferScaleYID = env->GetFieldID(jDrawDataClass, "framebufferScaleY", "F");

		// ImGuiIO Prepare IDs
		WantCaptureMouseID = env->GetFieldID(jImGuiIOClass, "WantCaptureMouse", "Z");
		WantCaptureKeyboardID = env->GetFieldID(jImGuiIOClass, "WantCaptureKeyboard", "Z");
		WantTextInputID = env->GetFieldID(jImGuiIOClass, "WantTextInput", "Z");
		WantSetMousePosID = env->GetFieldID(jImGuiIOClass, "WantSetMousePos", "Z");
		WantSaveIniSettingsID = env->GetFieldID(jImGuiIOClass, "WantSaveIniSettings", "Z");
		NavActiveID = env->GetFieldID(jImGuiIOClass, "NavActive", "Z");
		NavVisibleID = env->GetFieldID(jImGuiIOClass, "NavVisible", "Z");
		FramerateID = env->GetFieldID(jImGuiIOClass, "Framerate", "F");
		MetricsRenderVerticesID = env->GetFieldID(jImGuiIOClass, "MetricsRenderVertices", "I");
		MetricsRenderIndicesID = env->GetFieldID(jImGuiIOClass, "MetricsRenderIndices", "I");
		MetricsRenderWindowsID = env->GetFieldID(jImGuiIOClass, "MetricsRenderWindows", "I");
		MetricsActiveWindowsID = env->GetFieldID(jImGuiIOClass, "MetricsActiveWindows", "I");
		MetricsActiveAllocationsID = env->GetFieldID(jImGuiIOClass, "MetricsActiveAllocations", "I");
		MouseDeltaXID = env->GetFieldID(jImGuiIOClass, "MouseDeltaX", "F");
		MouseDeltaYID = env->GetFieldID(jImGuiIOClass, "MouseDeltaY", "F");
	*/

	public static native void CreateContext() /*-{ }-*/; /*
		ImGui::CreateContext();
		ImGui::GetIO().IniFilename = NULL;
	*/

	public static native void UpdateDisplayAndInputAndFrame(ImGuiIO jImguiIO, float deltaTime, float w, float h, float display_w, float display_h,
			float mouseX, float mouseY, boolean mouseDown0, boolean mouseDown1, boolean mouseDown2, boolean mouseDown3, boolean mouseDown4, boolean mouseDown5) /*-{ }-*/; /*
		ImGuiIO& io = ImGui::GetIO();

		io.DisplaySize = ImVec2(w, h);
		if (w > 0 && h > 0)
			io.DisplayFramebufferScale = ImVec2((float)display_w / w, (float)display_h / h);
		io.DeltaTime = deltaTime;

		bool m0 = mouseDown0;
		bool m1 = mouseDown1;
		bool m2 = mouseDown2;
		bool m3 = mouseDown3;
		bool m4 = mouseDown4;
		bool m5 = mouseDown5;

		io.MouseDown[0] = m0;
		io.MouseDown[1] = m1;
		io.MouseDown[2] = m2;
		io.MouseDown[3] = m3;
		io.MouseDown[4] = m4;
		io.MouseDown[5] = m5;

		if (io.WantSetMousePos) {
		}
		else {
			io.MousePos = ImVec2(mouseX, mouseY);
		}

		ImGui::NewFrame();

		// Update ImGuiIO
		env->SetBooleanField (jImguiIO, WantCaptureMouseID, io.WantCaptureMouse);
		env->SetBooleanField (jImguiIO, WantCaptureKeyboardID, io.WantCaptureKeyboard);
		env->SetBooleanField (jImguiIO, WantTextInputID, io.WantTextInput);
		env->SetBooleanField (jImguiIO, WantSetMousePosID, io.WantSetMousePos);
		env->SetBooleanField (jImguiIO, WantSaveIniSettingsID, io.WantSaveIniSettings);
		env->SetBooleanField (jImguiIO, NavActiveID, io.NavActive);
		env->SetBooleanField (jImguiIO, NavVisibleID, io.NavVisible);
		env->SetBooleanField (jImguiIO, FramerateID, io.Framerate);
		env->SetBooleanField (jImguiIO, MetricsRenderVerticesID, io.MetricsRenderVertices);
		env->SetBooleanField (jImguiIO, MetricsRenderIndicesID, io.MetricsRenderIndices);
		env->SetBooleanField (jImguiIO, MetricsRenderWindowsID, io.MetricsRenderWindows);
		env->SetBooleanField (jImguiIO, MetricsActiveWindowsID, io.MetricsActiveWindows);
		env->SetBooleanField (jImguiIO, MetricsActiveAllocationsID, io.MetricsActiveAllocations);
		env->SetBooleanField (jImguiIO, MouseDeltaXID, io.MouseDelta.x);
		env->SetBooleanField (jImguiIO, MouseDeltaYID, io.MouseDelta.y);
	*/

	public static native void Render() /*-{ }-*/; /*
		ImGui::Render();
	*/

	public static native void ShowDemoWindow(boolean open) /*-{ }-*/; /*
		bool toOpen = open;
		ImGui::ShowDemoWindow(&toOpen);
	*/

	public static native void GetTexDataAsRGBA32(TexDataRGBA32 jTexData, Buffer pixelBuffer) /*-{ }-*/; /*
		jclass jTexDataClass = env->GetObjectClass(jTexData);
			if(jTexDataClass == NULL)
				return;

		jfieldID widthID = env->GetFieldID(jTexDataClass, "width", "I");
		jfieldID heightID = env->GetFieldID(jTexDataClass, "height", "I");

		unsigned char* pixels;
		int width, height;

		ImGuiIO& io = ImGui::GetIO();
		io.Fonts->GetTexDataAsRGBA32(&pixels, &width, &height);

		env->SetIntField (jTexData, widthID, width);
		env->SetIntField (jTexData, heightID, height);

		memcpy(pixelBuffer, pixels, width * height * 4);
	*/

	public static native void SetFontTexID(int id) /*-{ }-*/; /*
		ImGuiIO& io = ImGui::GetIO();
		io.Fonts->TexID = (ImTextureID)id;
	*/

	public static native void GetDrawData(DrawData jDrawData, Buffer indexBuffer, Buffer vertexBuffer, Buffer cmdBuffer) /*-{ }-*/; /*
		ImDrawData * drawData = ImGui::GetDrawData();

		if(drawData != NULL) {
			int cmdListsCount = drawData->CmdListsCount;

			// Set values
			env->SetIntField (jDrawData, totalVtxCountID, drawData->TotalVtxCount);
			env->SetIntField (jDrawData, totalIdxCountID, drawData->TotalIdxCount);
			env->SetIntField (jDrawData, CmdListsCountID, cmdListsCount);

			env->SetFloatField (jDrawData, displayPosXID, drawData->DisplayPos.x);
			env->SetFloatField (jDrawData, displayPosYID, drawData->DisplayPos.y);

			env->SetFloatField (jDrawData, displaySizeXID, drawData->DisplaySize.x);
			env->SetFloatField (jDrawData, displaySizeYID, drawData->DisplaySize.y);

			env->SetFloatField (jDrawData, framebufferScaleXID, drawData->FramebufferScale.x);
			env->SetFloatField (jDrawData, framebufferScaleYID, drawData->FramebufferScale.y);

			ImDrawList** drawLists = drawData->CmdLists;

			int verticeOffset = 0;
			int indicesOffset = 0;
			int cmdOffset = 0;
			int cmdCount = 0;

			for(int i = 0; i < cmdListsCount; i++) {
				ImDrawList & drawList = *drawLists[i];
				ImVector<ImDrawCmd> & imDrawCmdList = drawList.CmdBuffer;
				ImVector<ImDrawIdx> & idxBuffer = drawList.IdxBuffer;
				ImVector<ImDrawVert> & vtxBuffer = drawList.VtxBuffer;

				int verticeSize = sizeof(ImDrawVert);
				int indicesSize = sizeof(ImDrawIdx);

				float * vertexArraySource = (float *)vtxBuffer.Data;
				short * indexArraySource = (short *)idxBuffer.Data;
				float * vertexArrayDest = (float *)vertexBuffer;
				short * indexArrayDest = (short *)indexBuffer;

				int colorSize = 1;

				int verticeItemSize = (4 + colorSize);

				vertexArrayDest[verticeOffset++] = vtxBuffer.Size;
				// copy vertices to Destination buffer
				for(int j = 0; j < vtxBuffer.Size; j++) {
					ImDrawVert v = vtxBuffer[j];
					float posX = v.pos.x;
					float posY = v.pos.y;
					float uvX = v.uv.x;
					float uvY = v.uv.y;

					int byteIndex = (j * verticeItemSize) + verticeOffset;

					float color = 0;
					memcpy(&color, &v.col, 4); // move unsigned int color to float

					vertexArrayDest[byteIndex + 0] = posX;
					vertexArrayDest[byteIndex + 1] = posY;
					vertexArrayDest[byteIndex + 2] = uvX;
					vertexArrayDest[byteIndex + 3] = uvY;
					vertexArrayDest[byteIndex + 4] = color;
				}
				verticeOffset += vtxBuffer.Size * verticeItemSize;

				// copy index to destination buffer
				indexArrayDest[indicesOffset++] = idxBuffer.Size;
				for(int j = 0; j < idxBuffer.Size; j++) {

					indexArrayDest[j + indicesOffset] = idxBuffer[j];
				}
				indicesOffset += idxBuffer.Size;

				float * cmdArrayDest = (float *)cmdBuffer;

				cmdArrayDest[cmdOffset++] = imDrawCmdList.Size;
				int bytesOffset = 0;
				int imDrawCmdSize = 1 + 4 + 1;
				for (int cmd_i = 0; cmd_i < imDrawCmdList.Size; cmd_i++) {
					const ImDrawCmd * pcmd = &imDrawCmdList[cmd_i];

					float  textureID = (float)(intptr_t)pcmd->TextureId;
					float tempArray [6] = {
						pcmd->ElemCount,
						pcmd->ClipRect.x,
						pcmd->ClipRect.y,
						pcmd->ClipRect.z,
						pcmd->ClipRect.w,
						textureID
					};

					memcpy((cmdArrayDest + (cmd_i * imDrawCmdSize) + cmdOffset), tempArray, imDrawCmdSize * 4);
					bytesOffset = bytesOffset + imDrawCmdSize;
				}
				cmdOffset += imDrawCmdList.Size * imDrawCmdSize;
				cmdCount +=  imDrawCmdList.Size;
			}

			env->SetIntField (jDrawData, totalCmdCountID, cmdCount);
		}
	*/

	public static native void StyleColorsDark() /*-{ }-*/; /*
		ImGui::StyleColorsDark();
	*/

	public static native void StyleColorsClassic() /*-{ }-*/; /*
		ImGui::StyleColorsClassic();
	*/

	public static native void StyleColorsLight() /*-{ }-*/; /*
		ImGui::StyleColorsLight();
	*/

	public static native boolean Begin(String title) /*-{ }-*/; /*
		return ImGui::Begin(title);
	*/

	public static native boolean Begin(String title, boolean [] p_open, int imGuiWindowFlags) /*-{ }-*/; /*
		return ImGui::Begin(title, &p_open[0], imGuiWindowFlags);
	*/

	public static native void End() /*-{ }-*/; /*
		ImGui::End();
	*/

	public static native boolean BeginChild(String str_id) /*-{ }-*/; /*
		return ImGui::BeginChild(str_id);
	*/

	public static native boolean BeginChild(String str_id, float width, float height, boolean border, int flags) /*-{ }-*/; /*
		return ImGui::BeginChild(str_id, ImVec2(width, height), border, flags);
	*/

	public static native boolean BeginChild(int imGuiID) /*-{ }-*/; /*
		return ImGui::BeginChild(imGuiID);
	*/

	public static native boolean BeginChild(int imGuiID, float width, float height, boolean border, int flags) /*-{ }-*/; /*
		return ImGui::BeginChild(imGuiID, ImVec2(width, height), border, flags);
	*/

	public static native void EndChild() /*-{ }-*/; /*
		ImGui::EndChild();
	*/

	public static native boolean IsWindowAppearing() /*-{ }-*/; /*
		return ImGui::IsWindowAppearing();
	*/

	public static native boolean IsWindowCollapsed() /*-{ }-*/; /*
		return ImGui::IsWindowCollapsed();
	*/

	public static native boolean IsWindowFocused() /*-{ }-*/; /*
		return ImGui::IsWindowFocused();
	*/

	public static native boolean IsWindowFocused(int flags) /*-{ }-*/; /*
		return ImGui::IsWindowFocused(flags);
	*/

	public static native boolean IsWindowHovered() /*-{ }-*/; /*
		return ImGui::IsWindowHovered();
	*/

	public static native boolean IsWindowHovered(int flags) /*-{ }-*/; /*
		return ImGui::IsWindowHovered(flags);
	*/

	public static native float GetWindowPosX() /*-{ }-*/; /*
		return ImGui::GetWindowPos().x;
	*/

	public static native float GetWindowPosY() /*-{ }-*/; /*
		return ImGui::GetWindowPos().y;
	 */

	public static native float GetWindowWidth() /*-{ }-*/; /*
		return ImGui::GetWindowWidth();
	 */

	public static native float GetWindowHeight() /*-{ }-*/; /*
		return ImGui::GetWindowHeight();
	 */

	// Prefer using SetNextXXX functions (before Begin) rather that SetXXX functions (after Begin).

	public static native void SetNextWindowPos(float x, float y) /*-{ }-*/; /*
		ImGui::SetNextWindowPos(ImVec2(x, y));
	 */

	public static native void SetNextWindowPos(float x, float y, int cond, float pivot_x, float pivot_y) /*-{ }-*/; /*
		ImGui::SetNextWindowPos(ImVec2(x, y), cond, ImVec2(pivot_x, pivot_y));
	 */

	public static native void SetNextWindowSize(float width, float height) /*-{ }-*/; /*
		ImGui::SetNextWindowSize(ImVec2(width, height));
	*/

	public static native void SetNextWindowSize(float width, float height, int cond) /*-{ }-*/; /*
		ImGui::SetNextWindowSize(ImVec2(width, height), cond);
	*/

	public static native void SetNextWindowSizeConstraints(float min_width, float min_height, float max_width, float max_height) /*-{ }-*/; /*
		ImGui::SetNextWindowSizeConstraints(ImVec2(min_width, min_height), ImVec2(max_width, max_height));
	*/

	public static native void SetNextWindowContentSize(float width, float height) /*-{ }-*/; /*
		ImGui::SetNextWindowContentSize(ImVec2(width, height));
	*/

	public static native void SetNextWindowCollapsed(boolean collapsed) /*-{ }-*/; /*
		ImGui::SetNextWindowCollapsed(collapsed);
	*/

	public static native void SetNextWindowCollapsed(boolean collapsed, int cond) /*-{ }-*/; /*
		ImGui::SetNextWindowCollapsed(collapsed, cond);
	*/

	public static native void SetNextWindowFocus() /*-{ }-*/; /*
		ImGui::SetNextWindowFocus();
	*/

	public static native void SetNextWindowBgAlpha(float alpha) /*-{ }-*/; /*
		ImGui::SetNextWindowBgAlpha(alpha);
	*/

	public static native void SetWindowPos(float x, float y) /*-{ }-*/; /*
		ImGui::SetWindowPos(ImVec2(x, y));
	*/

	public static native void SetWindowPos(float x, float y, int cond) /*-{ }-*/; /*
		ImGui::SetWindowPos(ImVec2(x, y), cond);
	*/

	public static native void SetWindowSize(float width, float height) /*-{ }-*/; /*
		ImGui::SetWindowSize(ImVec2(width, height));
	*/

	public static native void SetWindowSize(float width, float height, int cond) /*-{ }-*/; /*
		ImGui::SetWindowSize(ImVec2(width, height), cond);
	*/

	public static native void SetWindowCollapsed(boolean collapsed, int cond) /*-{ }-*/; /*
		ImGui::SetWindowCollapsed(collapsed, cond);
	*/

	public static native void SetWindowFocus() /*-{ }-*/; /*
		ImGui::SetWindowFocus();
	*/

	public static native void SetWindowFocus(float scale) /*-{ }-*/; /*
		ImGui::SetWindowFontScale(scale);
	*/

	public static native void SetWindowPos(String name, float x, float y) /*-{ }-*/; /*
		ImGui::SetWindowPos(name, ImVec2(x, y));
	*/

	public static native void SetWindowPos(String name, float x, float y, int cond) /*-{ }-*/; /*
		ImGui::SetWindowPos(name, ImVec2(x, y), cond);
	*/

	public static native void SetWindowCollapsed(String name, boolean collapsed) /*-{ }-*/; /*
		bool flag = collapsed;
		ImGui::SetWindowCollapsed(name, flag);
	*/

	public static native void SetWindowCollapsed(String name, boolean collapsed, int cond) /*-{ }-*/; /*
		ImGui::SetWindowCollapsed(name, collapsed, cond);
	*/

	public static native void SetWindowFocus(String name) /*-{ }-*/; /*
		ImGui::SetWindowFocus(name);
	*/

	// Content region
	// - Those functions are bound to be redesigned soon (they are confusing, incomplete and return values in local window coordinates which increases confusion)

	public static native void GetContentRegionMax(float [] value) /*-{ }-*/; /*
		ImVec2 val = ImGui::GetContentRegionMax();
		value[0] = val.x;
		value[1] = val.y;
	*/

	public static native void GetContentRegionAvail(float [] value) /*-{ }-*/; /*
		ImVec2 val = ImGui::GetContentRegionAvail();
		value[0] = val.x;
		value[1] = val.y;
	*/

	public static native float GetContentRegionAvailWidth() /*-{ }-*/; /*
		return ImGui::GetContentRegionAvailWidth();
	*/

	public static native void GetWindowContentRegionMin(float [] value) /*-{ }-*/; /*
		ImVec2 val = ImGui::GetWindowContentRegionMin();
		value[0] = val.x;
		value[1] = val.y;
	*/

	public static native void GetWindowContentRegionMax(float [] value) /*-{ }-*/; /*
		ImVec2 val = ImGui::GetWindowContentRegionMax();
		value[0] = val.x;
		value[1] = val.y;
	*/


	public static native float GetWindowContentRegionWidth() /*-{ }-*/; /*
		return ImGui::GetWindowContentRegionWidth();
	*/

	// Windows Scrolling

	public static native float GetScrollX() /*-{ }-*/; /*
		return ImGui::GetScrollX();
	*/

	public static native float GetScrollY() /*-{ }-*/; /*
		return ImGui::GetScrollY();
	*/

	public static native float GetScrollMaxX() /*-{ }-*/; /*
		return ImGui::GetScrollMaxX();
	*/

	public static native float GetScrollMaxY() /*-{ }-*/; /*
		return ImGui::GetScrollMaxY();
	*/

	public static native void SetScrollX(float scroll_x) /*-{ }-*/; /*
		ImGui::SetScrollX(scroll_x);
	*/

	public static native void SetScrollY(float scroll_y) /*-{ }-*/; /*
		ImGui::SetScrollY(scroll_y);
	*/

	public static native void SetScrollHereY() /*-{ }-*/; /*
		ImGui::SetScrollHereY();
	*/

	public static native void SetScrollHereY(float center_y_ratio) /*-{ }-*/; /*
		ImGui::SetScrollHereY(center_y_ratio);
	*/

	public static native void SetScrollFromPosY(float local_y) /*-{ }-*/; /*
		ImGui::SetScrollFromPosY(local_y);
	*/

	public static native void SetScrollFromPosY(float local_y, float center_y_ratio) /*-{ }-*/; /*
		ImGui::SetScrollFromPosY(local_y, center_y_ratio);
	*/

	// Parameters stacks (shared)

	//TODO impl
	public static native void PushFont(int index) /*-{ }-*/; /*
		ImGuiIO& io = ImGui::GetIO();
		ImFontAtlas* atlas = io.Fonts;
		ImFont* font = atlas->Fonts[index];
		ImGui::PushFont(font);
	*/

	public static native void PopFont() /*-{ }-*/; /*
		ImGui::PopFont();
	*/

	public static native void PushStyleColor(int idx, int col) /*-{ }-*/; /*
		ImGui::PushStyleColor(idx, col);
	*/

	public static native void PushStyleColor(int idx, float r, float g, float b, float a) /*-{ }-*/; /*
		ImGui::PushStyleColor(idx, ImVec4(r, g, b, a));
	*/

	public static native void PopStyleColor() /*-{ }-*/; /*
		ImGui::PopStyleColor();
	*/

	public static native void PopStyleColor(int count) /*-{ }-*/; /*
		ImGui::PopStyleColor(count);
	*/

	public static native void PushStyleVar(int idx, float val) /*-{ }-*/; /*
		ImGui::PushStyleVar(idx, val);
	*/

	public static native void PushStyleVar(int idx, float val_x, float val_y) /*-{ }-*/; /*
		ImGui::PushStyleVar(idx, ImVec2(val_x, val_y));
	*/

	public static native void PopStyleVar() /*-{ }-*/; /*
		ImGui::PopStyleVar();
	*/

	public static native void PopStyleVar(int count) /*-{ }-*/; /*
		ImGui::PopStyleVar(count);
	*/

	public static native void GetStyleColorVec4(int idx, float [] value) /*-{ }-*/; /*
		ImVec4 val = ImGui::GetStyleColorVec4(idx);
		value[0] = val.x;
		value[1] = val.y;
		value[2] = val.z;
		value[3] = val.w;
	*/

	//TODO impl
	public static native void GetFont() /*-{ }-*/; /*
		ImFont * font = ImGui::GetFont();
	*/

	public static native int GetFontSize() /*-{ }-*/; /*
		return ImGui::GetFontSize();
	*/

	public static native void GetFontTexUvWhitePixel(float [] value) /*-{ }-*/; /*
		ImVec2 val = ImGui::GetFontTexUvWhitePixel();
		value[0] = val.x;
		value[1] = val.y;
	*/

	public static native int GetColorU32(int idx) /*-{ }-*/; /*
		return ImGui::GetColorU32((ImGuiCol)idx);
	*/

	public static native int GetColorU32(int idx, float alpha_mul) /*-{ }-*/; /*
		return ImGui::GetColorU32(idx, alpha_mul);
	*/

	public static native int GetColorU32(float col_x, float col_y, float col_z, float col_w) /*-{ }-*/; /*
		return ImGui::GetColorU32(ImVec4(col_x, col_y, col_z, col_w));
	 */

	// Parameters stacks (current window)

	public static native void PushItemWidth(float item_width) /*-{ }-*/; /*
		ImGui::PushItemWidth(item_width);
	*/

	public static native void PopItemWidth() /*-{ }-*/; /*
		ImGui::PopItemWidth();
	*/

	public static native void SetNextItemWidth(float item_width) /*-{ }-*/; /*
		ImGui::SetNextItemWidth(item_width);
	*/

	public static native float CalcItemWidth() /*-{ }-*/; /*
		return ImGui::CalcItemWidth();
	*/

	public static native void PushTextWrapPos(float wrap_local_pos_x) /*-{ }-*/; /*
		ImGui::PushTextWrapPos(wrap_local_pos_x);
	*/

	public static native void PushTextWrapPos() /*-{ }-*/; /*
		ImGui::PushTextWrapPos();
	*/

	public static native void PopTextWrapPos() /*-{ }-*/; /*
		ImGui::PopTextWrapPos();
	*/

	public static native void PushAllowKeyboardFocus(boolean allow_keyboard_focus) /*-{ }-*/; /*
		ImGui::PushAllowKeyboardFocus(allow_keyboard_focus);
	*/

	public static native void PopAllowKeyboardFocus() /*-{ }-*/; /*
		ImGui::PopAllowKeyboardFocus();
	*/

	public static native void PushButtonRepeat(boolean repeat) /*-{ }-*/; /*
		ImGui::PushButtonRepeat(repeat);
	*/

	public static native void PopButtonRepeat() /*-{ }-*/; /*
		ImGui::PopButtonRepeat();
	*/

	// Cursor / Layout
	// - By "cursor" we mean the current output position.
	// - The typical widget behavior is to output themselves at the current cursor position, then move the cursor one line down.

	public static native void Separator() /*-{ }-*/; /*
		ImGui::Separator();
	*/

	public static native void SameLine() /*-{ }-*/; /*
		ImGui::SameLine();
	*/

	public static native void SameLine(float offsetFromStartX, float spacing) /*-{ }-*/; /*
		ImGui::SameLine(offsetFromStartX, spacing);
	*/

	public static native void NewLine() /*-{ }-*/; /*
		ImGui::NewLine();
	*/

	public static native void Spacing() /*-{ }-*/; /*
		ImGui::Spacing();
	*/

	public static native void Dummy(float width, float height) /*-{ }-*/; /*
		ImGui::Dummy(ImVec2(width, height));
	*/

	public static native void Indent() /*-{ }-*/; /*
		ImGui::Indent();
	*/

	public static native void Indent(float indentW) /*-{ }-*/; /*
		ImGui::Indent(indentW);
	*/

	public static native void Unindent() /*-{ }-*/; /*
		ImGui::Unindent();
	*/

	public static native void Unindent(float indentW) /*-{ }-*/; /*
		ImGui::Unindent(indentW);
	*/

	public static native void BeginGroup() /*-{ }-*/; /*
		ImGui::BeginGroup();
	*/

	public static native void EndGroup() /*-{ }-*/; /*
		ImGui::EndGroup();
	*/

	public static native void GetCursorPos(float [] vec2) /*-{ }-*/; /*
		ImVec2 vec = ImGui::GetCursorPos();
		vec2[0] = vec.x;
		vec2[1] = vec.y;
	*/

	public static native float GetCursorPosX() /*-{ }-*/; /*
		return ImGui::GetCursorPosX();
	*/

	public static native float GetCursorPosY() /*-{ }-*/; /*
		return ImGui::GetCursorPosY();
	*/

	public static native void SetCursorPos(float x, float y) /*-{ }-*/; /*
		ImGui::SetCursorPos(ImVec2(x, y));
	*/

	public static native void SetCursorPosX(float x) /*-{ }-*/; /*
		ImGui::SetCursorPosX(x);
	*/

	public static native void SetCursorPosY(float y) /*-{ }-*/; /*
		ImGui::SetCursorPosY(y);
	*/

	public static native void GetCursorStartPos(float [] vec2) /*-{ }-*/; /*
		ImVec2 vec = ImGui::GetCursorStartPos();
		vec2[0] = vec.x;
		vec2[1] = vec.y;
	*/

	public static native void GetCursorScreenPos(float [] vec2) /*-{ }-*/; /*
		ImVec2 vec = ImGui::GetCursorScreenPos();
		vec2[0] = vec.x;
		vec2[1] = vec.y;
	*/

	public static native void SetCursorScreenPos(float x, float y) /*-{ }-*/; /*
		ImGui::SetCursorScreenPos(ImVec2(x, y));
	*/

	public static native void AlignTextToFramePadding() /*-{ }-*/; /*
		ImGui::AlignTextToFramePadding();
	*/

	public static native float GetTextLineHeight() /*-{ }-*/; /*
		return ImGui::GetTextLineHeight();
	*/

	public static native float GetTextLineHeightWithSpacing() /*-{ }-*/; /*
		return ImGui::GetTextLineHeightWithSpacing();
	*/

	public static native float GetFrameHeight() /*-{ }-*/; /*
		return ImGui::GetFrameHeight();
	*/

	public static native float GetFrameHeightWithSpacing() /*-{ }-*/; /*
		return ImGui::GetFrameHeightWithSpacing();
	*/

	// ID stack/scopes
	// - Read the FAQ for more details about how ID are handled in dear imgui. If you are creating widgets in a loop you most
	//   likely want to push a unique identifier (e.g. object pointer, loop index) to uniquely differentiate them.
	// - The resulting ID are hashes of the entire stack.
	// - You can also use the "Label##foobar" syntax within widget label to distinguish them from each others.
	// - In this header file we use the "label"/"name" terminology to denote a string that will be displayed and used as an ID,
	//   whereas "str_id" denote a string that is only used as an ID and not normally displayed.

	public static native void PushID(String str_id) /*-{ }-*/; /*
		ImGui::PushID(str_id);
	*/

	public static native void PushID(String str_id_begin, String str_id_end) /*-{ }-*/; /*
		ImGui::PushID(str_id_begin, str_id_end);
	*/

	public static native void PushID(int int_id) /*-{ }-*/; /*
		ImGui::PushID(int_id);
	*/

	public static native void PopID() /*-{ }-*/; /*
		ImGui::PopID();
	*/

	public static native int GetID(String str_id) /*-{ }-*/; /*
		return ImGui::GetID(str_id);
	*/

	public static native int GetID(String str_id_begin, String str_id_end) /*-{ }-*/; /*
		return ImGui::GetID(str_id_begin, str_id_end);
	*/

	// Widgets: Text

	public static native void TextUnformatted(String text) /*-{ }-*/; /*
		ImGui::TextUnformatted(text);
	*/

	public static native void TextUnformatted(String text, String text_end) /*-{ }-*/; /*
		ImGui::TextUnformatted(text, text_end);
	*/

	public static native void Text(String text) /*-{ }-*/; /*
		ImGui::Text(text);
	*/

	public static native void TextColored(float r, float g, float b, float a, String text) /*-{ }-*/; /*
		ImGui::TextColored(ImVec4(r, g, b, a), text);
	*/

	public static native void TextDisabled(String text) /*-{ }-*/; /*
		ImGui::TextDisabled(text);
	*/

	public static native void TextWrapped(String text) /*-{ }-*/; /*
		ImGui::TextWrapped(text);
	*/

	public static native void LabelText(String label, String text) /*-{ }-*/; /*
		ImGui::LabelText(label, text);
	*/

	public static native void BulletText(String text) /*-{ }-*/; /*
		ImGui::BulletText(text);
	*/

	// Widgets: Main
	// - Most widgets return true when the value has been changed or when pressed/selected

	public static native boolean Button(String label) /*-{ }-*/; /*
		return ImGui::Button(label);
	*/

	public static native boolean Button(String label, float width, float height) /*-{ }-*/; /*
		return ImGui::Button(label, ImVec2(width, height));
	*/

	public static native boolean SmallButton(String label) /*-{ }-*/; /*
		return ImGui::SmallButton(label);
	*/

	public static native boolean InvisibleButton(String strId, float width, float height) /*-{ }-*/; /*
		return ImGui::InvisibleButton(strId, ImVec2(width, height));
	*/

	public static native boolean ArrowButton(String strId, int dir) /*-{ }-*/; /*
		return ImGui::ArrowButton(strId, dir);
	*/

	public static native boolean Checkbox(String label, boolean [] data) /*-{ }-*/; /*
		return ImGui::Checkbox(label, &data[0]);
	*/

	//TODO check if its working
	public static native boolean CheckboxFlags(String label, long [] data, int flagsValue) /*-{ }-*/; /*
		return ImGui::CheckboxFlags(label, (unsigned int*)&data[0], flagsValue);
	*/

	public static native boolean RadioButton(String label, boolean active) /*-{ }-*/; /*
		return ImGui::RadioButton(label, active);
	*/

	public static native boolean RadioButton(String label, int [] data, int v_button) /*-{ }-*/; /*
		return ImGui::RadioButton(label, &data[0], v_button);
	*/

	public static native void ProgressBar(float fraction) /*-{ }-*/; /*
		ImGui::ProgressBar(fraction);
	*/

	public static native void ProgressBar(float fraction, float size_arg_x, float size_arg_y) /*-{ }-*/; /*
		ImGui::ProgressBar(fraction, ImVec2(size_arg_x, size_arg_y));
	*/

	public static native void Bullet() /*-{ }-*/; /*
		ImGui::Bullet();
	*/

	// Widgets: Combo Box
	// - The new BeginCombo()/EndCombo() api allows you to manage your contents and selection state however you want it, by creating e.g. Selectable() items.
	// - The old Combo() api are helpers over BeginCombo()/EndCombo() which are kept available for convenience purpose.

	public static native boolean BeginCombo(String label, String preview_value) /*-{ }-*/; /*
		return ImGui::BeginCombo(label, preview_value);
	 */

	public static native boolean BeginCombo(String label, String preview_value, int flags) /*-{ }-*/; /*
		return ImGui::BeginCombo(label, preview_value, flags);
	*/

	public static native void EndCombo() /*-{ }-*/; /*
		ImGui::EndCombo();
	*/

	public static native boolean Combo(String label, int [] current_item, String [] items, int items_count) /*-{ }-*/; /*
		const char* listbox_items[items_count];
		for(int i = 0; i < items_count; i++) {
			jstring string = (jstring) (env->GetObjectArrayElement(items, i));
			const char *rawString = env->GetStringUTFChars(string, 0);
			listbox_items[i] = rawString;
		}
		return ImGui::Combo(label, &current_item[0], listbox_items, items_count);
	*/

	public static native boolean Combo(String label, int [] current_item, String [] items, int items_count, int popup_max_height_in_items) /*-{ }-*/; /*
		const char* listbox_items[items_count];
		for(int i = 0; i < items_count; i++) {
			jstring string = (jstring) (env->GetObjectArrayElement(items, i));
			const char *rawString = env->GetStringUTFChars(string, 0);
			listbox_items[i] = rawString;
		}
		return ImGui::Combo(label, &current_item[0], listbox_items, items_count, popup_max_height_in_items);
	*/

	public static native boolean Combo(String label, int [] current_item, String items_separated_by_zeros) /*-{ }-*/; /*
		return ImGui::Combo(label, &current_item[0], items_separated_by_zeros);
	*/

	public static native boolean Combo(String label, int [] current_item, String items_separated_by_zeros, int popup_max_height_in_items) /*-{ }-*/; /*
		return ImGui::Combo(label, &current_item[0], items_separated_by_zeros, popup_max_height_in_items);
	*/

	// Widgets: Drags
	// - CTRL+Click on any drag box to turn them into an input box. Manually input values aren't clamped and can go off-bounds.
	// - For all the Float2/Float3/Float4/Int2/Int3/Int4 versions of every functions, note that a 'float v[X]' function argument is the same as 'float* v', the array syntax is just a way to document the number of elements that are expected to be accessible. You can pass address of your first element out of a contiguous set, e.g. &myvector.x
	// - Adjust format string to decorate the value with a prefix, a suffix, or adapt the editing and display precision e.g. "%.3f" -> 1.234; "%5.2f secs" -> 01.23 secs; "Biscuit: %.0f" -> Biscuit: 1; etc.
	// - Speed are per-pixel of mouse movement (v_speed=0.2f: mouse needs to move by 5 pixels to increase value by 1). For gamepad/keyboard navigation, minimum speed is Max(v_speed, minimum_step_at_given_precision).

	public static native boolean DragFloat(String label, float [] v) /*-{ }-*/; /*
		return ImGui::DragFloat(label, &v[0]);
	*/

	public static native boolean DragFloat(String label, float [] v, float v_speed, float v_min, float v_max, String format, float power) /*-{ }-*/; /*
		return ImGui::DragFloat(label, &v[0], v_speed, v_min, v_max, format, power);
	*/

	public static native boolean DragFloat2(String label, float [] v) /*-{ }-*/; /*
		return ImGui::DragFloat2(label, v);
	*/

	public static native boolean DragFloat2(String label, float [] v, float v_speed, float v_min, float v_max, String format, float power) /*-{ }-*/; /*
		return ImGui::DragFloat2(label, v, v_speed, v_min, v_max, format, power);
	*/

	public static native boolean DragFloat3(String label, float [] v) /*-{ }-*/; /*
		return ImGui::DragFloat3(label, v);
	*/

	public static native boolean DragFloat3(String label, float [] v, float v_speed, float v_min, float v_max, String format, float power) /*-{ }-*/; /*
		return ImGui::DragFloat3(label, v, v_speed, v_min, v_max, format, power);
	*/

	public static native boolean DragFloat4(String label, float [] v) /*-{ }-*/; /*
		return ImGui::DragFloat4(label, v);
	*/

	public static native boolean DragFloat4(String label, float [] v, float v_speed, float v_min, float v_max, String format, float power) /*-{ }-*/; /*
		return ImGui::DragFloat4(label, v, v_speed, v_min, v_max, format, power);
	*/

	public static native boolean DragFloatRange2(String label, float [] v_current_min, float [] v_current_max) /*-{ }-*/; /*
		return ImGui::DragFloatRange2(label, &v_current_min[0], &v_current_max[0]);
	*/

	public static native boolean DragFloatRange2(String label, float [] v_current_min, float [] v_current_max, float v_speed, float v_min, float v_max, String format, String format_max, float power) /*-{ }-*/; /*
		return ImGui::DragFloatRange2(label, &v_current_min[0], &v_current_max[0], v_speed, v_min, v_max, format, format_max, power);
	*/

	public static native boolean DragInt(String label, int [] v) /*-{ }-*/; /*
		return ImGui::DragInt(label, &v[0]);
	*/

	public static native boolean DragInt(String label, int [] v, float v_speed, float v_min, float v_max, String format) /*-{ }-*/; /*
		return ImGui::DragInt(label, &v[0], v_speed, v_min, v_max, format);
	*/

	public static native boolean DragInt2(String label, int [] v) /*-{ }-*/; /*
		return ImGui::DragInt2(label, v);
	*/

	public static native boolean DragInt2(String label, int [] v, float v_speed, float v_min, float v_max, String format) /*-{ }-*/; /*
		return ImGui::DragInt2(label, v, v_speed, v_min, v_max, format);
	*/

	public static native boolean DragInt3(String label, int [] v) /*-{ }-*/; /*
		return ImGui::DragInt2(label, v);
	*/

	public static native boolean DragInt3(String label, int [] v, float v_speed, float v_min, float v_max, String format) /*-{ }-*/; /*
		return ImGui::DragInt2(label, v, v_speed, v_min, v_max, format);
	*/

	public static native boolean DragInt4(String label, int [] v) /*-{ }-*/; /*
		return ImGui::DragInt4(label, v);
	*/

	public static native boolean DragInt4(String label, int [] v, float v_speed, float v_min, float v_max, String format) /*-{ }-*/; /*
		return ImGui::DragInt4(label, v, v_speed, v_min, v_max, format);
	*/

	public static native boolean DragIntRange2(String label, int [] v_current_min, int [] v_current_max) /*-{ }-*/; /*
		return ImGui::DragIntRange2(label, &v_current_min[0], &v_current_max[0]);
	*/

	public static native boolean DragIntRange2(String label, int [] v_current_min, int [] v_current_max, float v_speed, float v_min, float v_max, String format, String format_max) /*-{ }-*/; /*
		return ImGui::DragIntRange2(label, &v_current_min[0], &v_current_max[0], v_speed, v_min, v_max, format, format_max);
	*/

	//TODO impl other types
	public static native boolean DragScalar(String label, int data_type, int[] v, float v_speed) /*-{ }-*/; /*
		return ImGui::DragScalar(label, data_type, &v[0], v_speed);
	*/

	//TODO impl other types
	public static native boolean DragScalar(String label, int data_type, int[] v, float v_speed, float v_min, float v_max, String format, float power) /*-{ }-*/; /*
		return ImGui::DragScalar(label, data_type, &v[0], v_speed, &v_min, &v_max, format, power);
	*/

	// Widgets: Sliders
	// - CTRL+Click on any slider to turn them into an input box. Manually input values aren't clamped and can go off-bounds.
	// - Adjust format string to decorate the value with a prefix, a suffix, or adapt the editing and display precision e.g. "%.3f" -> 1.234; "%5.2f secs" -> 01.23 secs; "Biscuit: %.0f" -> Biscuit: 1; etc.

	public static native boolean SliderFloat(String label, float [] v, float v_min, float v_max) /*-{ }-*/; /*
		return ImGui::SliderFloat(label, &v[0],v_min, v_max);
	*/

	public static native boolean SliderFloat(String label, float [] v, float v_min, float v_max, String format, float power) /*-{ }-*/; /*
		return ImGui::SliderFloat(label, &v[0], v_min, v_max, format, power);
	*/

	public static native boolean SliderFloat2(String label, float [] v, float v_min, float v_max) /*-{ }-*/; /*
		return ImGui::SliderFloat2(label, v, v_min, v_max);
	*/

	public static native boolean SliderFloat2(String label, float [] v, float v_min, float v_max, String format, float power) /*-{ }-*/; /*
		return ImGui::SliderFloat2(label, v, v_min, v_max, format, power);
	*/

	public static native boolean SliderFloat3(String label, float [] v, float v_min, float v_max) /*-{ }-*/; /*
		return ImGui::SliderFloat3(label, v, v_min, v_max);
	*/

	public static native boolean SliderFloat3(String label, float [] v, float v_min, float v_max, String format, float power) /*-{ }-*/; /*
		return ImGui::SliderFloat3(label, v, v_min, v_max, format, power);
	*/

	public static native boolean SliderFloat4(String label, float [] v, float v_min, float v_max) /*-{ }-*/; /*
		return ImGui::SliderFloat4(label, v, v_min, v_max);
	*/

	public static native boolean SliderFloat4(String label, float [] v, float v_min, float v_max, String format, float power) /*-{ }-*/; /*
		return ImGui::SliderFloat4(label, v, v_min, v_max, format, power);
	*/

	public static native boolean SliderAngle(String label, float [] v_rad) /*-{ }-*/; /*
		return ImGui::SliderAngle(label, &v_rad[0]);
	*/

	public static native boolean SliderAngle(String label, float [] v_rad, float v_degrees_min, float v_degrees_max, String format) /*-{ }-*/; /*
		return ImGui::SliderAngle(label, &v_rad[0], v_degrees_min, v_degrees_max, format);
	*/

	public static native boolean SliderInt(String label, int [] v, int v_min, int v_max) /*-{ }-*/; /*
		return ImGui::SliderInt(label, &v[0], v_min, v_max);
	*/

	public static native boolean SliderInt(String label, int [] v, int v_min, int v_max, String format) /*-{ }-*/; /*
		return ImGui::SliderInt(label, &v[0], v_min, v_max, format);
	*/

	public static native boolean SliderInt2(String label, int [] v, int v_min, int v_max) /*-{ }-*/; /*
		return ImGui::SliderInt2(label, v, v_min, v_max);
	*/

	public static native boolean SliderInt2(String label, int [] v, int v_min, int v_max, String format) /*-{ }-*/; /*
		return ImGui::SliderInt2(label, v, v_min, v_max, format);
	*/

	public static native boolean SliderInt3(String label, int [] v, int v_min, int v_max) /*-{ }-*/; /*
		return ImGui::SliderInt3(label, v, v_min, v_max);
	*/

	public static native boolean SliderInt3(String label, int [] v, int v_min, int v_max, String format) /*-{ }-*/; /*
		return ImGui::SliderInt3(label, v, v_min, v_max, format);
	*/

	public static native boolean SliderInt4(String label, int [] v, int v_min, int v_max) /*-{ }-*/; /*
		return ImGui::SliderInt4(label, v, v_min, v_max);
	*/

	public static native boolean SliderInt4(String label, int [] v, int v_min, int v_max, String format) /*-{ }-*/; /*
		return ImGui::SliderInt4(label, v, v_min, v_max, format);
	*/

	//TODO impl other types
	public static native boolean SliderScalar(String label, int data_type, int[] v, int v_min, int v_max) /*-{ }-*/; /*
		return ImGui::SliderScalar(label, data_type, &v[0], &v_min, &v_max);
	*/

	public static native boolean SliderScalar(String label, int data_type, int[] v, float v_min, float v_max, String format, float power) /*-{ }-*/; /*
		return ImGui::SliderScalar(label, data_type, &v[0], &v_min, &v_max, format, power);
	*/

	public static native boolean SliderScalar(String label, int data_type, float[] v, float v_min, float v_max) /*-{ }-*/; /*
		return ImGui::SliderScalar(label, data_type, &v[0], &v_min, &v_max);
	*/

	public static native boolean SliderScalar(String label, int data_type, float[] v, float v_min, float v_max, String format, float power) /*-{ }-*/; /*
		return ImGui::SliderScalar(label, data_type, &v[0], &v_min, &v_max, format, power);
	*/

	public static native boolean VSliderFloat(String label, float sizeX, float sizeY, float [] v, float v_min, float v_max) /*-{ }-*/; /*
		return ImGui::VSliderFloat(label, ImVec2(sizeX, sizeY), &v[0], v_min, v_max);
	*/

	public static native boolean VSliderFloat(String label, float sizeX, float sizeY, float [] v, float v_min, float v_max, String format, float power) /*-{ }-*/; /*
		return ImGui::VSliderFloat(label, ImVec2(sizeX, sizeY), &v[0], v_min, v_max, format, power);
	*/

	public static native boolean VSliderInt(String label, float sizeX, float sizeY, int [] v, int v_min, int v_max) /*-{ }-*/; /*
		return ImGui::VSliderInt(label, ImVec2(sizeX, sizeY), &v[0], v_min, v_max);
	*/

	public static native boolean VSliderInt(String label, float sizeX, float sizeY, int [] v, int v_min, int v_max, String format) /*-{ }-*/; /*
		return ImGui::VSliderInt(label, ImVec2(sizeX, sizeY), &v[0], v_min, v_max, format);
	*/

	//TODO impl other types
	public static native boolean VSliderScalar(String label, float sizeX, float sizeY, int data_type, int [] v, int v_min, int v_max) /*-{ }-*/; /*
		return ImGui::VSliderScalar(label, ImVec2(sizeX, sizeY), data_type, &v[0], &v_min, &v_max);
	*/

	public static native boolean VSliderScalar(String label, float sizeX, float sizeY, int data_type, int [] v, int v_min, int v_max, String format, float power) /*-{ }-*/; /*
		return ImGui::VSliderScalar(label, ImVec2(sizeX, sizeY), data_type, &v[0], &v_min, &v_max, format, power);
	*/

	public static native boolean VSliderScalar(String label, float sizeX, float sizeY, int data_type, float [] v, float v_min, float v_max) /*-{ }-*/; /*
		return ImGui::VSliderScalar(label, ImVec2(sizeX, sizeY), data_type, &v[0], &v_min, &v_max);
	*/

	public static native boolean VSliderScalar(String label, float sizeX, float sizeY, int data_type, float [] v, float v_min, float v_max, String format, float power) /*-{ }-*/; /*
		return ImGui::VSliderScalar(label, ImVec2(sizeX, sizeY), data_type, &v[0], &v_min, &v_max, format, power);
	*/

	// Widgets: Selectables
	// - A selectable highlights when hovered, and can display another color when selected.
	// - Neighbors selectable extend their highlight bounds in order to leave no gap between them.

	public static native boolean Selectable(String label) /*-{ }-*/; /*
		return ImGui::Selectable(label);
	*/

	public static native boolean Selectable(String label, boolean selected) /*-{ }-*/; /*
		return ImGui::Selectable(label, selected);
	*/

	public static native boolean Selectable(String label, boolean selected, int flags, float sizeX, float sizeY) /*-{ }-*/; /*
		return ImGui::Selectable(label, selected, flags, ImVec2(sizeX, sizeY));
	*/

	public static native boolean Selectable(String label, boolean [] selected) /*-{ }-*/; /*
		return ImGui::Selectable(label, &selected[0]);
	*/

	public static native boolean Selectable(String label, boolean [] selected, int flags, float sizeX, float sizeY) /*-{ }-*/; /*
		return ImGui::Selectable(label,  &selected[0], flags, ImVec2(sizeX, sizeY));
	*/

	// Widgets: List Boxes
	// - FIXME: To be consistent with all the newer API, ListBoxHeader/ListBoxFooter should in reality be called BeginListBox/EndListBox. Will rename them.

	public static native boolean ListBox(String label, int [] current_item, String [] items, int items_count) /*-{ }-*/; /*
		const char* listbox_items[items_count];
		for(int i = 0; i < items_count; i++) {
			jstring string = (jstring) (env->GetObjectArrayElement(items, i));
			const char *rawString = env->GetStringUTFChars(string, 0);
			listbox_items[i] = rawString;
		}
		return ImGui::ListBox(label, &current_item[0], listbox_items, items_count);
	*/

	public static native boolean ListBoxHeader(String label) /*-{ }-*/; /*
		return ImGui::ListBoxHeader(label);
	*/

	public static native boolean ListBoxHeader(String label, float sizeX, float sizeY) /*-{ }-*/; /*
		return ImGui::ListBoxHeader(label, ImVec2(sizeX, sizeY));
	*/

	public static native boolean ListBoxHeader(String label, int items_count) /*-{ }-*/; /*
		return ImGui::ListBoxHeader(label, items_count);
	*/

	public static native boolean ListBoxHeader(String label, int items_count, int height_in_items) /*-{ }-*/; /*
		return ImGui::ListBoxHeader(label, items_count, height_in_items);
	*/

	public static native void ListBoxFooter() /*-{ }-*/; /*
		ImGui::ListBoxFooter();
	*/

	// Widgets: Menus

	public static native boolean BeginMainMenuBar() /*-{ }-*/; /*
		return ImGui::BeginMainMenuBar();
	*/

	public static native void EndMainMenuBar() /*-{ }-*/; /*
		ImGui::EndMainMenuBar();
	*/

	public static native boolean BeginMenuBar() /*-{ }-*/; /*
		return ImGui::BeginMenuBar();
	*/

	public static native void EndMenuBar() /*-{ }-*/; /*
		ImGui::EndMenuBar();
	*/

	public static native boolean BeginMenu(String label) /*-{ }-*/; /*
		return ImGui::BeginMenu(label);
	*/

	public static native boolean BeginMenu(String label, boolean enabled) /*-{ }-*/; /*
		return ImGui::BeginMenu(label, enabled);
	*/

	public static native void EndMenu() /*-{ }-*/; /*
		ImGui::EndMenu();
	*/

	public static native boolean MenuItem(String label) /*-{ }-*/; /*
		return ImGui::MenuItem(label);
	*/

	public static native boolean MenuItem(String label, String shortcut, boolean selected, boolean enabled) /*-{ }-*/; /*
		return ImGui::MenuItem(label, shortcut, selected, enabled);
	*/

	public static native boolean MenuItem(String label, String shortcut, boolean [] p_selected) /*-{ }-*/; /*
		return ImGui::MenuItem(label, shortcut, &p_selected[0]);
	*/

	public static native boolean MenuItem(String label, String shortcut, boolean [] p_selected, boolean enabled) /*-{ }-*/; /*
		return ImGui::MenuItem(label, shortcut, &p_selected[0], enabled);
	*/

	// Tooltips

	public static native void BeginTooltip() /*-{ }-*/; /*
		ImGui::BeginTooltip();
	*/

	public static native void EndTooltip() /*-{ }-*/; /*
		ImGui::EndTooltip();
	*/

	public static native void SetTooltip(String text) /*-{ }-*/; /*
		ImGui::SetTooltip(text);
	*/

	// Popups, Modals
	// The properties of popups windows are:
	// - They block normal mouse hovering detection outside them. (*)
	// - Unless modal, they can be closed by clicking anywhere outside them, or by pressing ESCAPE.
	// - Their visibility state (~bool) is held internally by imgui instead of being held by the programmer as we are used to with regular Begin() calls.
	//   User can manipulate the visibility state by calling OpenPopup().
	// (*) One can use IsItemHovered(ImGuiHoveredFlags_AllowWhenBlockedByPopup) to bypass it and detect hovering even when normally blocked by a popup.
	// Those three properties are connected. The library needs to hold their visibility state because it can close popups at any time.

	public static native void OpenPopup(String str_id) /*-{ }-*/; /*
		ImGui::OpenPopup(str_id);
	*/

	public static native boolean BeginPopup(String str_id) /*-{ }-*/; /*
		return ImGui::BeginPopup(str_id);
	*/

	public static native boolean BeginPopup(String str_id, int flags) /*-{ }-*/; /*
		return ImGui::BeginPopup(str_id, flags);
	*/

	public static native boolean BeginPopupContextItem() /*-{ }-*/; /*
		return ImGui::BeginPopupContextItem();
	*/

	public static native boolean BeginPopupContextItem(String str_id, int mouse_button) /*-{ }-*/; /*
		return ImGui::BeginPopupContextItem(str_id, mouse_button);
	*/

	public static native boolean BeginPopupContextWindow() /*-{ }-*/; /*
		return ImGui::BeginPopupContextWindow();
	*/

	public static native boolean BeginPopupContextWindow(String str_id, int mouse_button, boolean also_over_items) /*-{ }-*/; /*
		return ImGui::BeginPopupContextWindow(str_id, mouse_button, also_over_items);
	*/

	public static native boolean BeginPopupContextVoid() /*-{ }-*/; /*
		return ImGui::BeginPopupContextVoid();
	 */

	public static native boolean BeginPopupContextVoid(String str_id, int mouse_button) /*-{ }-*/; /*
		return ImGui::BeginPopupContextVoid(str_id, mouse_button);
	*/

	public static native boolean BeginPopupModal(String name) /*-{ }-*/; /*
		return ImGui::BeginPopupModal(name);
	*/

	public static native boolean BeginPopupModal(String name, boolean [] p_open, int flags) /*-{ }-*/; /*
		return ImGui::BeginPopupModal(name, &p_open[0], flags);
	*/

	public static native void EndPopup() /*-{ }-*/; /*
		ImGui::EndPopup();
	*/

	public static native boolean OpenPopupOnItemClick() /*-{ }-*/; /*
		return ImGui::OpenPopupOnItemClick();
	*/

	public static native boolean OpenPopupOnItemClick(String str_id, int mouse_button) /*-{ }-*/; /*
		return ImGui::OpenPopupOnItemClick(str_id, mouse_button);
	*/

	public static native boolean IsPopupOpen(String str_id) /*-{ }-*/; /*
		return ImGui::IsPopupOpen(str_id);
	*/

	public static native void CloseCurrentPopup() /*-{ }-*/; /*
		ImGui::CloseCurrentPopup();
	*/

	// Columns
	// - You can also use SameLine(pos_x) to mimic simplified columns.
	// - The columns API is work-in-progress and rather lacking (columns are arguably the worst part of dear imgui at the moment!)

	public static native void Columns() /*-{ }-*/; /*
		ImGui::Columns();
	*/

	public static native void Columns(int count, String id, boolean border) /*-{ }-*/; /*
		ImGui::Columns(count, id, border);
	*/

	public static native void NextColumn() /*-{ }-*/; /*
		ImGui::NextColumn();
	*/

	public static native int GetColumnIndex() /*-{ }-*/; /*
		return ImGui::GetColumnIndex();
	 */

	public static native float GetColumnWidth() /*-{ }-*/; /*
		return ImGui::GetColumnWidth();
	*/

	public static native float GetColumnWidth(int column_index) /*-{ }-*/; /*
		return ImGui::GetColumnWidth(column_index);
	*/

	public static native void SetColumnWidth(int column_index, float width) /*-{ }-*/; /*
		ImGui::SetColumnWidth(column_index, width);
	*/

	public static native float GetColumnOffset() /*-{ }-*/; /*
		return ImGui::GetColumnOffset();
	*/

	public static native float GetColumnOffset(int column_index) /*-{ }-*/; /*
		return ImGui::GetColumnOffset(column_index);
	*/

	public static native void SetColumnOffset(int column_index, float offset_x) /*-{ }-*/; /*
		ImGui::SetColumnOffset(column_index, offset_x);
	*/

	public static native int GetColumnsCount() /*-{ }-*/; /*
		return ImGui::GetColumnsCount();
	*/

	// Tab Bars, Tabs
	// [BETA API] API may evolve!

	public static native boolean BeginTabBar(String str_id) /*-{ }-*/; /*
		return ImGui::BeginTabBar(str_id);
	*/

	public static native boolean BeginTabBar(String str_id, int flags) /*-{ }-*/; /*
		return ImGui::BeginTabBar(str_id, flags);
	*/

	public static native void EndTabBar() /*-{ }-*/; /*
		ImGui::EndTabBar();
	*/

	public static native boolean BeginTabItem(String label) /*-{ }-*/; /*
		return ImGui::BeginTabItem(label);
	*/

	public static native boolean BeginTabItem(String label, boolean [] p_open, int flags) /*-{ }-*/; /*
		return ImGui::BeginTabItem(label, &p_open[0], flags);
	*/

	public static native void EndTabItem() /*-{ }-*/; /*
		ImGui::EndTabItem();
	*/

	public static native void SetTabItemClosed(String tab_or_docked_window_label) /*-{ }-*/; /*
		ImGui::SetTabItemClosed(tab_or_docked_window_label);
	*/


	private ImGuiNative() {}

}
