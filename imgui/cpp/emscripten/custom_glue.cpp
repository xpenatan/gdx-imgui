#include <emscripten.h>
#include <imgui.h>

typedef ImVector<ImDrawCmd> VecCmdBuffer;
typedef ImVector<ImDrawIdx> VecIdxBuffer;
typedef ImVector<ImDrawVert> VecVtxBuffer;

class Im {
    // Emscripten webidl don't support binding methods without a class so we need to create a wrapper
    public:
        static ImGuiContext* CreateContext() { return ImGui::CreateContext(); }
        static void DestroyContext(ImGuiContext* ctx = NULL) { ImGui::DestroyContext(ctx); }
        static ImGuiContext* GetCurrentContext() { return ImGui::GetCurrentContext(); }
        static void SetCurrentContext(ImGuiContext* ctx) { ImGui::SetCurrentContext(ctx); }

        static ImGuiIO& GetIO() { return ImGui::GetIO(); }
        static ImGuiStyle& GetStyle() { return ImGui::GetStyle(); }
        static void NewFrame() { ImGui::NewFrame(); }
        static void EndFrame() { ImGui::EndFrame(); }
        static void Render() { ImGui::Render(); }
        static ImDrawData* GetDrawData() { return ImGui::GetDrawData(); }

        static void ShowDemoWindow(bool* p_open = NULL) { ImGui::ShowDemoWindow(p_open); }
        static void ShowMetricsWindow(bool* p_open = NULL) { ImGui::ShowMetricsWindow(p_open); }
        static void ShowDebugLogWindow(bool* p_open = NULL) { ImGui::ShowDebugLogWindow(p_open); }
        static void ShowStackToolWindow(bool* p_open = NULL) { ImGui::ShowStackToolWindow(p_open); }
        static void ShowAboutWindow(bool* p_open = NULL) { ImGui::ShowAboutWindow(p_open); }
        static void ShowStyleEditor(ImGuiStyle* ref = NULL) { ImGui::ShowStyleEditor(ref); }
        static void ShowStyleSelector(const char* label) { ImGui::ShowStyleSelector(label); }
        static void ShowFontSelector(const char* label) { ImGui::ShowFontSelector(label); }
        static void ShowUserGuide() { ImGui::ShowUserGuide(); }
        static const char* GetVersion() { return ImGui::GetVersion(); }

        static void StyleColorsDark(ImGuiStyle* dst = NULL) { ImGui::StyleColorsDark(dst); }
        static void StyleColorsLight(ImGuiStyle* dst = NULL) { ImGui::StyleColorsLight(dst); }
        static void StyleColorsClassic(ImGuiStyle* dst = NULL) { ImGui::StyleColorsClassic(dst); }

        static bool Begin(const char* name, bool* p_open = NULL, ImGuiWindowFlags flags = 0) { return ImGui::Begin(name, p_open, flags); }
        static void End() { ImGui::End(); }

        static bool BeginChild(const char* str_id, const ImVec2& size = ImVec2(0, 0), bool border = false, ImGuiWindowFlags flags = 0) { return ImGui::BeginChild(str_id, size, border, flags); }
        static bool BeginChild2(ImGuiID id, const ImVec2& size = ImVec2(0, 0), bool border = false, ImGuiWindowFlags flags = 0) { return ImGui::BeginChild(id, size, border, flags); }
        static void EndChild() { ImGui::EndChild(); }

        static bool IsWindowAppearing() { return ImGui::IsWindowAppearing(); }
        static bool IsWindowCollapsed() { return ImGui::IsWindowCollapsed(); }
        static bool IsWindowFocused(ImGuiFocusedFlags flags=0) { return ImGui::IsWindowFocused(flags); }
        static bool IsWindowHovered(ImGuiHoveredFlags flags=0) { return ImGui::IsWindowHovered(flags); }
        static ImDrawList* GetWindowDrawList() { return ImGui::GetWindowDrawList(); }
        static float GetWindowDpiScale() { return ImGui::GetWindowDpiScale(); }
        static ImVec2 GetWindowPos() { return ImGui::GetWindowPos(); }
        static ImVec2 GetWindowSize() { return ImGui::GetWindowSize(); }
        static float GetWindowWidth() { return ImGui::GetWindowWidth(); }
        static float GetWindowHeight() { return ImGui::GetWindowHeight(); }
        static ImGuiViewport* GetWindowViewport() { return ImGui::GetWindowViewport(); }

        static void SetNextWindowPos(const ImVec2& pos, ImGuiCond cond = 0, const ImVec2& pivot = ImVec2(0, 0)) { ImGui::SetNextWindowPos(pos, cond, pivot); }
        static void SetNextWindowSize(const ImVec2& size, ImGuiCond cond = 0) { ImGui::SetNextWindowSize(size, cond); }
        static void SetNextWindowSizeConstraints(const ImVec2& size_min, const ImVec2& size_max, ImGuiSizeCallback custom_callback = NULL, void* custom_callback_data = NULL) { ImGui::SetNextWindowSizeConstraints(size_min, size_max, custom_callback, custom_callback_data); }
        static void SetNextWindowContentSize(const ImVec2& size) { ImGui::SetNextWindowContentSize(size); }
        static void SetNextWindowCollapsed(bool collapsed, ImGuiCond cond = 0) { ImGui::SetNextWindowCollapsed(collapsed, cond); }
        static void SetNextWindowFocus() { ImGui::SetNextWindowFocus(); }
        static void SetNextWindowScroll(const ImVec2& scroll) { ImGui::SetNextWindowScroll(scroll); }
        static void SetNextWindowBgAlpha(float alpha) { ImGui::SetNextWindowBgAlpha(alpha); }
        static void SetNextWindowViewport(ImGuiID viewport_id) { ImGui::SetNextWindowViewport(viewport_id); }
        static void SetWindowPos(const ImVec2& pos, ImGuiCond cond = 0) { ImGui::SetWindowPos(pos, cond); }
        static void SetWindowSize(const ImVec2& size, ImGuiCond cond = 0) { ImGui::SetWindowSize(size, cond); }
        static void SetWindowCollapsed(bool collapsed, ImGuiCond cond = 0) { ImGui::SetWindowCollapsed(collapsed, cond); }
        static void SetWindowFocus() { ImGui::SetWindowFocus(); }
        static void SetWindowFontScale(float scale) { ImGui::SetWindowFontScale(scale); }
        static void SetWindowPos2(const char* name, const ImVec2& pos, ImGuiCond cond = 0) { ImGui::SetWindowPos(name, pos, cond); }
        static void SetWindowSize2(const char* name, const ImVec2& size, ImGuiCond cond = 0) { ImGui::SetWindowSize(name, size, cond); }
        static void SetWindowCollapsed2(const char* name, bool collapsed, ImGuiCond cond = 0) { ImGui::SetWindowCollapsed(name, collapsed, cond); }
        static void SetWindowFocus2(const char* name) { ImGui::SetWindowFocus(name); }

        static ImVec2 GetContentRegionAvail() { return ImGui::GetContentRegionAvail(); }
        static ImVec2 GetContentRegionMax() { return ImGui::GetContentRegionMax(); }
        static ImVec2 GetWindowContentRegionMin() { return ImGui::GetWindowContentRegionMin(); }
        static ImVec2 GetWindowContentRegionMax() { return ImGui::GetWindowContentRegionMax(); }

        static float GetScrollX() { return ImGui::GetScrollX(); }
        static float GetScrollY() { return ImGui::GetScrollY(); }
        static void SetScrollX(float scroll_x) { ImGui::SetScrollX(scroll_x); }
        static void SetScrollY(float scroll_y) { ImGui::SetScrollY(scroll_y); }
        static float GetScrollMaxX() { return ImGui::GetScrollMaxX(); }
        static float GetScrollMaxY() { return ImGui::GetScrollMaxY(); }
        static void SetScrollHereX(float center_x_ratio = 0.5f) { ImGui::SetScrollHereX(center_x_ratio); }
        static void SetScrollHereY(float center_y_ratio = 0.5f) { ImGui::SetScrollHereY(center_y_ratio); }
        static void SetScrollFromPosX(float local_x, float center_x_ratio = 0.5f) { ImGui::SetScrollFromPosX(local_x, center_x_ratio); }
        static void SetScrollFromPosY(float local_y, float center_y_ratio = 0.5f) { ImGui::SetScrollFromPosY(local_y, center_y_ratio); }

        static void PushFont(ImFont* font) { ImGui::PushFont(font); }
        static void PopFont() { ImGui::PopFont(); }
        static void PushStyleColor(ImGuiCol idx, ImU32 col) { ImGui::PushStyleColor(idx, col); }
        static void PushStyleColor2(ImGuiCol idx, const ImVec4& col) { ImGui::PushStyleColor(idx, col); }
        static void PopStyleColor(int count = 1) { ImGui::PopStyleColor(count); }
        static void PushStyleVar(ImGuiStyleVar idx, float val) { ImGui::PushStyleVar(idx, val); }
        static void PushStyleVar2(ImGuiStyleVar idx, const ImVec2& val) { ImGui::PushStyleVar(idx, val); }
        static void PopStyleVar(int count = 1) { ImGui::PopStyleVar(count); }
        static void PushTabStop(bool tab_stop) { ImGui::PushTabStop(tab_stop); }
        static void PopTabStop() { ImGui::PopTabStop(); }
        static void PushButtonRepeat(bool repeat) { ImGui::PushButtonRepeat(repeat); }
        static void PopButtonRepeat() { ImGui::PopButtonRepeat(); }

        static void PushItemWidth(float item_width) { ImGui::PushItemWidth(item_width); }
        static void PopItemWidth() { ImGui::PopItemWidth(); }
        static void SetNextItemWidth(float item_width) { ImGui::SetNextItemWidth(item_width); }
        static float CalcItemWidth() { return ImGui::CalcItemWidth(); }
        static void PushTextWrapPos(float wrap_local_pos_x = 0.0f) { ImGui::PushTextWrapPos(wrap_local_pos_x); }
        static void PopTextWrapPos() { ImGui::PopTextWrapPos(); }

        static ImFont* GetFont() { return ImGui::GetFont(); }
        static float GetFontSize() { return ImGui::GetFontSize(); }
        static ImVec2 GetFontTexUvWhitePixel() { return ImGui::GetFontTexUvWhitePixel(); }
        static ImU32 GetColorU32(ImGuiCol idx, float alpha_mul = 1.0f) { return ImGui::GetColorU32(idx, alpha_mul); }
        static ImU32 GetColorU322(const ImVec4& col) { return ImGui::GetColorU32(col); }
        static ImU32 GetColorU323(ImU32 col) { return ImGui::GetColorU32(col); }
        static const ImVec4& GetStyleColorVec4(ImGuiCol idx) { return ImGui::GetStyleColorVec4(idx); }

        static void Separator() { ImGui::Separator(); }
        static void SameLine(float offset_from_start_x=0.0f, float spacing=-1.0f) { ImGui::SameLine(offset_from_start_x, spacing); }
        static void NewLine() { ImGui::NewLine(); }
        static void Spacing() { ImGui::Spacing(); }
        static void Dummy(const ImVec2& size) { ImGui::Dummy(size); }
        static void Indent(float indent_w = 0.0f) { ImGui::Indent(indent_w); }
        static void Unindent(float indent_w = 0.0f) { ImGui::Unindent(indent_w); }
        static void BeginGroup() { ImGui::BeginGroup(); }
        static void EndGroup() { ImGui::EndGroup(); }
        static ImVec2 GetCursorPos() { return ImGui::GetCursorPos(); }
        static float GetCursorPosX() { return ImGui::GetCursorPosX(); }
        static float GetCursorPosY() { return ImGui::GetCursorPosY(); }
        static void SetCursorPos(const ImVec2& local_pos) { ImGui::SetCursorPos(local_pos); }
        static void SetCursorPosX(float local_x) { ImGui::SetCursorPosX(local_x); }
        static void SetCursorPosY(float local_y) { ImGui::SetCursorPosY(local_y); }
        static ImVec2 GetCursorStartPos() { return ImGui::GetCursorStartPos(); }
        static ImVec2 GetCursorScreenPos() { return ImGui::GetCursorScreenPos(); }
        static void SetCursorScreenPos(const ImVec2& pos) { ImGui::SetCursorScreenPos(pos); }
        static void AlignTextToFramePadding() { ImGui::AlignTextToFramePadding(); }
        static float GetTextLineHeight() { return ImGui::GetTextLineHeight(); }
        static float GetTextLineHeightWithSpacing() { return ImGui::GetTextLineHeightWithSpacing(); }
        static float GetFrameHeight() { return ImGui::GetFrameHeight(); }
        static float GetFrameHeightWithSpacing() { return ImGui::GetFrameHeightWithSpacing(); }

        static void PushID(const char* str_id) { ImGui::PushID(str_id); }
        static void PushID2(const char* str_id_begin, const char* str_id_end) { ImGui::PushID(str_id_begin, str_id_end); }
        static void PushID3(const void* ptr_id) { ImGui::PushID(ptr_id); }
        static void PushID4(int int_id) { ImGui::PushID(int_id); }
        static void PopID() { ImGui::PopID(); }
        static ImGuiID GetID(const char* str_id) { return ImGui::GetID(str_id); }
        static ImGuiID GetID2(const char* str_id_begin, const char* str_id_end) { return ImGui::GetID(str_id_begin, str_id_end); }
        static ImGuiID GetID3(const void* ptr_id) { return ImGui::GetID(ptr_id); }

        static void TextUnformatted(const char* text, const char* text_end = NULL) { ImGui::TextUnformatted(text, text_end); }
        static void Text(const char* fmt) { ImGui::Text(fmt); }
        static void TextV(const char* fmt, va_list args) { ImGui::TextV(fmt, args); }
        static void TextColored(const ImVec4& col, const char* fmt) { ImGui::TextColored(col, fmt); }
        static void TextColoredV(const ImVec4& col, const char* fmt, va_list args) { ImGui::TextColoredV(col, fmt, args); }
        static void TextDisabled(const char* fmt) { ImGui::TextDisabled(fmt); }
        static void TextDisabledV(const char* fmt, va_list args) { ImGui::TextDisabled(fmt, args); }
        static void TextWrapped(const char* fmt) { ImGui::TextWrapped(fmt); }
        static void TextWrappedV(const char* fmt, va_list args) { ImGui::TextWrappedV(fmt, args); }
        static void LabelText(const char* label, const char* fmt) { ImGui::LabelText(label, fmt); }
        static void LabelTextV(const char* label, const char* fmt, va_list args) { ImGui::LabelTextV(label, fmt, args); }
        static void BulletText(const char* fmt) { ImGui::BulletText(fmt); }
        static void BulletTextV(const char* fmt,  va_list args) { ImGui::BulletTextV(fmt, args); }

        static bool Button(const char* label, const ImVec2& size = ImVec2(0, 0)) { return ImGui::Button(label, size); }
        static bool SmallButton(const char* label) { return ImGui::SmallButton(label); }
        static bool InvisibleButton(const char* str_id, const ImVec2& size, ImGuiButtonFlags flags = 0) { return ImGui::InvisibleButton(str_id, size, flags); }
        static bool ArrowButton(const char* str_id, ImGuiDir dir) { return ImGui::ArrowButton(str_id, dir); }
        static bool Checkbox(const char* label, bool* v) { return ImGui::Checkbox(label, v); }
        static bool CheckboxFlags(const char* label, int* flags, int flags_value) { return ImGui::CheckboxFlags(label, flags, flags_value); }
        static bool CheckboxFlags2(const char* label, unsigned int* flags, unsigned int flags_value) { return ImGui::CheckboxFlags(label, flags, flags_value); }
        static bool RadioButton(const char* label, bool active) { return ImGui::RadioButton(label, active); }
        static bool RadioButton2(const char* label, int* v, int v_button) { return ImGui::RadioButton(label, v, v_button); }
        static void ProgressBar(float fraction, const ImVec2& size_arg = ImVec2(-FLT_MIN, 0), const char* overlay = NULL) { ImGui::ProgressBar(fraction, size_arg, overlay); }
        static void Bullet() { ImGui::Bullet(); }
        static void Image(ImTextureID user_texture_id, const ImVec2& size, const ImVec2& uv0 = ImVec2(0, 0), const ImVec2& uv1 = ImVec2(1, 1), const ImVec4& tint_col = ImVec4(1, 1, 1, 1), const ImVec4& border_col = ImVec4(0, 0, 0, 0)) {
            ImGui::Image(user_texture_id, size, uv0, uv1, tint_col, border_col);
        }
        static bool ImageButton(const char* str_id, ImTextureID user_texture_id, const ImVec2& size, const ImVec2& uv0 = ImVec2(0, 0), const ImVec2& uv1 = ImVec2(1, 1), const ImVec4& bg_col = ImVec4(0, 0, 0, 0), const ImVec4& tint_col = ImVec4(1, 1, 1, 1)) {
            return ImGui::ImageButton(str_id, user_texture_id, size, uv0, uv1, bg_col, tint_col);
        }

        static bool BeginCombo(const char* label, const char* preview_value, ImGuiComboFlags flags = 0) { return ImGui::BeginCombo(label, preview_value, flags); }
        static void EndCombo() { ImGui::EndCombo(); }
        static bool Combo(const char* label, int* current_item, const char* const items[], int items_count, int popup_max_height_in_items = -1) { return ImGui::Combo(label, current_item, items, items_count, popup_max_height_in_items); }
        static bool Combo(const char* label, int* current_item, const char* items_separated_by_zeros, int popup_max_height_in_items = -1) { return ImGui::Combo(label, current_item, items_separated_by_zeros, popup_max_height_in_items); }
//        static bool Combo(const char* label, int* current_item, bool(*items_getter)(void* data, int idx, const char** out_text), void* data, int items_count, int popup_max_height_in_items = -1) { return ImGui::Combo(label, current_item, items_getter, data, idx, out_text); }

        static bool DragFloat(const char* label, float* v, float v_speed = 1.0f, float v_min = 0.0f, float v_max = 0.0f, const char* format = "%.3f", ImGuiSliderFlags flags = 0) { return ImGui::DragFloat(label, v, v_speed, v_min, v_max, format, flags); }
        static bool DragFloat2(const char* label, float v[2], float v_speed = 1.0f, float v_min = 0.0f, float v_max = 0.0f, const char* format = "%.3f", ImGuiSliderFlags flags = 0) { return ImGui::DragFloat2(label, v, v_speed, v_min, v_max, format, flags); }
        static bool DragFloat3(const char* label, float v[3], float v_speed = 1.0f, float v_min = 0.0f, float v_max = 0.0f, const char* format = "%.3f", ImGuiSliderFlags flags = 0) { return ImGui::DragFloat3(label, v, v_speed, v_min, v_max, format, flags); }
        static bool DragFloat4(const char* label, float v[4], float v_speed = 1.0f, float v_min = 0.0f, float v_max = 0.0f, const char* format = "%.3f", ImGuiSliderFlags flags = 0) { return ImGui::DragFloat4(label, v, v_speed, v_min, v_max, format, flags); }
        static bool DragFloatRange2(const char* label, float* v_current_min, float* v_current_max, float v_speed = 1.0f, float v_min = 0.0f, float v_max = 0.0f, const char* format = "%.3f", const char* format_max = NULL, ImGuiSliderFlags flags = 0) {
            return ImGui::DragFloatRange2(label, v_current_min, v_current_max, v_speed, v_min, v_max, format, format_max, flags);
        }
        static bool DragInt(const char* label, int* v, float v_speed = 1.0f, int v_min = 0, int v_max = 0, const char* format = "%d", ImGuiSliderFlags flags = 0) { return ImGui::DragInt(label, v, v_speed, v_min, v_max, format, flags); }
        static bool DragInt2(const char* label, int v[2], float v_speed = 1.0f, int v_min = 0, int v_max = 0, const char* format = "%d", ImGuiSliderFlags flags = 0) { return ImGui::DragInt2(label, v, v_speed, v_min, v_max, format, flags); }
        static bool DragInt3(const char* label, int v[3], float v_speed = 1.0f, int v_min = 0, int v_max = 0, const char* format = "%d", ImGuiSliderFlags flags = 0) { return ImGui::DragInt3(label, v, v_speed, v_min, v_max, format, flags); }
        static bool DragInt4(const char* label, int v[4], float v_speed = 1.0f, int v_min = 0, int v_max = 0, const char* format = "%d", ImGuiSliderFlags flags = 0) { return ImGui::DragInt4(label, v, v_speed, v_min, v_max, format, flags); }
        static bool DragIntRange2(const char* label, int* v_current_min, int* v_current_max, float v_speed = 1.0f, int v_min = 0, int v_max = 0, const char* format = "%d", const char* format_max = NULL, ImGuiSliderFlags flags = 0) { return ImGui::DragIntRange2(label, v_current_min, v_current_max, v_speed, v_min, v_max, format, format_max, flags); }
        static bool DragScalar(const char* label, ImGuiDataType data_type, void* p_data, float v_speed = 1.0f, const void* p_min = NULL, const void* p_max = NULL, const char* format = NULL, ImGuiSliderFlags flags = 0) { return ImGui::DragScalar(label, data_type, p_data, v_speed, p_min, p_max, format, flags); }
        static bool DragScalarN(const char* label, ImGuiDataType data_type, void* p_data, int components, float v_speed = 1.0f, const void* p_min = NULL, const void* p_max = NULL, const char* format = NULL, ImGuiSliderFlags flags = 0) { return ImGui::DragScalarN(label, data_type, p_data, components, v_speed, p_min, p_max, format, flags); }

        static bool SliderFloat(const char* label, float* v, float v_min, float v_max, const char* format = "%.3f", ImGuiSliderFlags flags = 0) { return ImGui::SliderFloat(label, v, v_min, v_max, format, flags); }
        static bool SliderFloat2(const char* label, float v[2], float v_min, float v_max, const char* format = "%.3f", ImGuiSliderFlags flags = 0) { return ImGui::SliderFloat2(label, v, v_min, v_max, format, flags); }
        static bool SliderFloat3(const char* label, float v[3], float v_min, float v_max, const char* format = "%.3f", ImGuiSliderFlags flags = 0) { return ImGui::SliderFloat3(label, v, v_min, v_max, format, flags); }
        static bool SliderFloat4(const char* label, float v[4], float v_min, float v_max, const char* format = "%.3f", ImGuiSliderFlags flags = 0) { return ImGui::SliderFloat4(label, v, v_min, v_max, format, flags); }
        static bool SliderAngle(const char* label, float* v_rad, float v_degrees_min = -360.0f, float v_degrees_max = +360.0f, const char* format = "%.0f deg", ImGuiSliderFlags flags = 0) { return ImGui::SliderAngle(label, v_rad, v_degrees_min, v_degrees_max, format, flags); }
        static bool SliderInt(const char* label, int* v, int v_min, int v_max, const char* format = "%d", ImGuiSliderFlags flags = 0) { return ImGui::SliderInt(label, v, v_min, v_max, format, flags); }
        static bool SliderInt2(const char* label, int v[2], int v_min, int v_max, const char* format = "%d", ImGuiSliderFlags flags = 0) { return ImGui::SliderInt2(label, v, v_min, v_max, format, flags); }
        static bool SliderInt3(const char* label, int v[3], int v_min, int v_max, const char* format = "%d", ImGuiSliderFlags flags = 0) { return ImGui::SliderInt3(label, v, v_min, v_max, format, flags); }
        static bool SliderInt4(const char* label, int v[4], int v_min, int v_max, const char* format = "%d", ImGuiSliderFlags flags = 0) { return ImGui::SliderInt4(label, v, v_min, v_max, format, flags); }
        static bool SliderScalar(const char* label, ImGuiDataType data_type, void* p_data, const void* p_min, const void* p_max, const char* format = NULL, ImGuiSliderFlags flags = 0) { return ImGui::SliderScalar(label, data_type, p_data, p_min, p_max, format, flags); }
        static bool SliderScalarN(const char* label, ImGuiDataType data_type, void* p_data, int components, const void* p_min, const void* p_max, const char* format = NULL, ImGuiSliderFlags flags = 0) { return ImGui::SliderScalarN(label, data_type, p_data, components, p_min, p_max, format, flags); }
        static bool VSliderFloat(const char* label, const ImVec2& size, float* v, float v_min, float v_max, const char* format = "%.3f", ImGuiSliderFlags flags = 0) { return ImGui::VSliderFloat(label, size, v, v_min, v_max, format, flags); }
        static bool VSliderInt(const char* label, const ImVec2& size, int* v, int v_min, int v_max, const char* format = "%d", ImGuiSliderFlags flags = 0) { return ImGui::VSliderInt(label, size, v, v_min, v_max, format, flags); }
        static bool VSliderScalar(const char* label, const ImVec2& size, ImGuiDataType data_type, void* p_data, const void* p_min, const void* p_max, const char* format = NULL, ImGuiSliderFlags flags = 0) { return ImGui::VSliderScalar(label, size, data_type, p_data, p_min, p_max, format, flags); }

        static bool InputText(const char* label, char* buf, size_t buf_size, ImGuiInputTextFlags flags = 0, ImGuiInputTextCallback callback = NULL, void* user_data = NULL) { return ImGui::InputText(label, buf, buf_size, flags, callback, user_data); }
        static bool InputTextMultiline(const char* label, char* buf, size_t buf_size, const ImVec2& size = ImVec2(0, 0), ImGuiInputTextFlags flags = 0, ImGuiInputTextCallback callback = NULL, void* user_data = NULL) { return ImGui::InputTextMultiline(label, buf, buf_size, size, flags, callback, user_data); }
        static bool InputTextWithHint(const char* label, const char* hint, char* buf, size_t buf_size, ImGuiInputTextFlags flags = 0, ImGuiInputTextCallback callback = NULL, void* user_data = NULL) { return ImGui::InputTextWithHint(label, hint, buf, buf_size, flags, callback, user_data); }
        static bool InputFloat(const char* label, float* v, float step = 0.0f, float step_fast = 0.0f, const char* format = "%.3f", ImGuiInputTextFlags flags = 0) { return ImGui::InputFloat(label, v, step, step_fast, format, flags); }
        static bool InputFloat2(const char* label, float v[2], const char* format = "%.3f", ImGuiInputTextFlags flags = 0) { return ImGui::InputFloat2(label, v, format, flags); }
        static bool InputFloat3(const char* label, float v[3], const char* format = "%.3f", ImGuiInputTextFlags flags = 0) { return ImGui::InputFloat3(label, v, format, flags); }
        static bool InputFloat4(const char* label, float v[4], const char* format = "%.3f", ImGuiInputTextFlags flags = 0) { return ImGui::InputFloat4(label, v, format, flags); }
        static bool InputInt(const char* label, int* v, int step = 1, int step_fast = 100, ImGuiInputTextFlags flags = 0) { return ImGui::InputInt(label, v, step, step_fast, flags); }
        static bool InputInt2(const char* label, int v[2], ImGuiInputTextFlags flags = 0) { return ImGui::InputInt2(label, v, flags); }
        static bool InputInt3(const char* label, int v[3], ImGuiInputTextFlags flags = 0) { return ImGui::InputInt3(label, v, flags); }
        static bool InputInt4(const char* label, int v[4], ImGuiInputTextFlags flags = 0) { return ImGui::InputInt4(label, v, flags); }
        static bool InputDouble(const char* label, double* v, double step = 0.0, double step_fast = 0.0, const char* format = "%.6f", ImGuiInputTextFlags flags = 0) { return ImGui::InputDouble(label, v, step, step_fast, format, flags); }
        static bool InputScalar(const char* label, ImGuiDataType data_type, void* p_data, const void* p_step = NULL, const void* p_step_fast = NULL, const char* format = NULL, ImGuiInputTextFlags flags = 0) { return ImGui::InputScalar(label, data_type, p_data, p_step, p_step_fast, format); }
        static bool InputScalarN(const char* label, ImGuiDataType data_type, void* p_data, int components, const void* p_step = NULL, const void* p_step_fast = NULL, const char* format = NULL, ImGuiInputTextFlags flags = 0) { return ImGui::InputScalarN(label, data_type, p_data, components, p_step, p_step_fast, format, flags); }

        static bool ColorEdit3(const char* label, float col[3], ImGuiColorEditFlags flags = 0) { return ImGui::ColorEdit3(label, col, flags); }
        static bool ColorEdit4(const char* label, float col[4], ImGuiColorEditFlags flags = 0) { return ImGui::ColorEdit4(label, col, flags); }
        static bool ColorPicker3(const char* label, float col[3], ImGuiColorEditFlags flags = 0) { return ImGui::ColorPicker3(label, col, flags); }
        static bool ColorPicker4(const char* label, float col[4], ImGuiColorEditFlags flags = 0, const float* ref_col = NULL) { return ImGui::ColorPicker4(label, col, flags); }
        static bool ColorButton(const char* desc_id, const ImVec4& col, ImGuiColorEditFlags flags = 0, const ImVec2& size = ImVec2(0, 0)) { return ImGui::ColorButton(desc_id, col, flags); }
        static void SetColorEditOptions(ImGuiColorEditFlags flags) { return ImGui::SetColorEditOptions(flags); }

        static bool TreeNode(const char* label) { return ImGui::TreeNode(label); }
        static bool TreeNode2(const char* str_id, const char* fmt) { return ImGui::TreeNode(str_id, fmt); }
        static bool TreeNode3(const void* ptr_id, const char* fmt) { return ImGui::TreeNode(ptr_id, fmt); }
        static bool TreeNodeV(const char* str_id, const char* fmt, va_list args) { return ImGui::TreeNodeV(str_id, fmt, args); }
        static bool TreeNodeV2(const void* ptr_id, const char* fmt, va_list args) { return ImGui::TreeNodeV(ptr_id, fmt, args); }
        static bool TreeNodeEx(const char* label, ImGuiTreeNodeFlags flags = 0) { return ImGui::TreeNodeEx(label, flags); }
        static bool TreeNodeEx2(const char* str_id, ImGuiTreeNodeFlags flags, const char* fmt) { return ImGui::TreeNodeEx(str_id, flags, fmt); }
        static bool TreeNodeEx3(const void* ptr_id, ImGuiTreeNodeFlags flags, const char* fmt) { return ImGui::TreeNodeEx(ptr_id, flags, fmt); }
        static bool TreeNodeExV(const char* str_id, ImGuiTreeNodeFlags flags, const char* fmt, va_list args) { return ImGui::TreeNodeExV(str_id, flags, fmt, args); }
        static bool TreeNodeExV2(const void* ptr_id, ImGuiTreeNodeFlags flags, const char* fmt, va_list args) { return ImGui::TreeNodeExV(ptr_id, flags, fmt, args); }
        static void TreePush(const char* str_id) { ImGui::TreePush(str_id); }
        static void TreePush2(const void* ptr_id) { ImGui::TreePush(ptr_id); }
        static void TreePop() { ImGui::TreePop(); }
        static float GetTreeNodeToLabelSpacing() { return ImGui::GetTreeNodeToLabelSpacing(); }
        static bool CollapsingHeader(const char* label, ImGuiTreeNodeFlags flags = 0) { return ImGui::CollapsingHeader(label, flags); }
        static bool CollapsingHeader2(const char* label, bool* p_visible, ImGuiTreeNodeFlags flags = 0) { return ImGui::CollapsingHeader(label, p_visible, flags); }
        static void SetNextItemOpen(bool is_open, ImGuiCond cond = 0) { ImGui::SetNextItemOpen(is_open, cond); }

        static bool Selectable(const char* label, bool selected = false, ImGuiSelectableFlags flags = 0, const ImVec2& size = ImVec2(0, 0)) { return ImGui::Selectable(label, selected, flags, size); }
        static bool Selectable2(const char* label, bool* p_selected, ImGuiSelectableFlags flags = 0, const ImVec2& size = ImVec2(0, 0)) { return ImGui::Selectable(label, p_selected, flags, size); }

        static bool BeginListBox(const char* label, const ImVec2& size = ImVec2(0, 0)) { return ImGui::BeginListBox(label, size); }
        static void EndListBox() { ImGui:EndListBox(); }
        static bool ListBox(const char* label, int* current_item, const char* const items[], int items_count, int height_in_items = -1) { return ImGui::ListBox(label, current_item, items, items_count, height_in_items); }
//       static bool ListBox(const char* label, int* current_item, bool (*items_getter)(void* data, int idx, const char** out_text), void* data, int items_count, int height_in_items = -1) { return ImGui::ListBox(label, current_item, items_getter, data, items_count, height_in_items); }

        static void PlotLines(const char* label, const float* values, int values_count, int values_offset = 0, const char* overlay_text = NULL, float scale_min = FLT_MAX, float scale_max = FLT_MAX, ImVec2 graph_size = ImVec2(0, 0), int stride = sizeof(float)) { ImGui::PlotLines(label, values, values_count, values_offset, overlay_text, scale_min, scale_max, graph_size, stride); }
//       static void PlotLines(const char* label, float(*values_getter)(void* data, int idx), void* data, int values_count, int values_offset = 0, const char* overlay_text = NULL, float scale_min = FLT_MAX, float scale_max = FLT_MAX, ImVec2 graph_size = ImVec2(0, 0)) { ImGui::(); }
        static void PlotHistogram(const char* label, const float* values, int values_count, int values_offset = 0, const char* overlay_text = NULL, float scale_min = FLT_MAX, float scale_max = FLT_MAX, ImVec2 graph_size = ImVec2(0, 0), int stride = sizeof(float)) { ImGui::PlotHistogram(label, values, values_count, values_offset, overlay_text, scale_min, scale_max, graph_size, stride); }
//       static void PlotHistogram(const char* label, float(*values_getter)(void* data, int idx), void* data, int values_count, int values_offset = 0, const char* overlay_text = NULL, float scale_min = FLT_MAX, float scale_max = FLT_MAX, ImVec2 graph_size = ImVec2(0, 0)) { ImGui::(); }

        static void Value(const char* prefix, bool b) { ImGui::Value(prefix, b); }
        static void Value2(const char* prefix, int v) { ImGui::Value(prefix, v); }
        static void Value3(const char* prefix, unsigned int v) { ImGui::Value(prefix, v); }
        static void Value4(const char* prefix, float v, const char* float_format = NULL) { ImGui::Value(prefix, v, float_format); }

        static bool BeginMenuBar() { return ImGui::BeginMenuBar(); }
        static void EndMenuBar() { ImGui::EndMenuBar(); }
        static bool BeginMainMenuBar() { return ImGui::BeginMainMenuBar(); }
        static void EndMainMenuBar() { ImGui::EndMainMenuBar(); }
        static bool BeginMenu(const char* label, bool enabled = true) { return ImGui::BeginMenu(label, enabled); }
        static void EndMenu() { ImGui::EndMenu(); }
        static bool MenuItem(const char* label, const char* shortcut = NULL, bool selected = false, bool enabled = true) { return ImGui::MenuItem(label, shortcut, selected, enabled); }
        static bool MenuItem2(const char* label, const char* shortcut, bool* p_selected, bool enabled = true) { return ImGui::MenuItem(label, shortcut, enabled); }

        static void BeginTooltip() { ImGui::BeginTooltip(); }
        static void EndTooltip() { ImGui::EndTooltip(); }
        static void SetTooltip(const char* fmt) { ImGui::SetTooltip(fmt); }
        static void SetTooltipV(const char* fmt, va_list args) { ImGui::SetTooltipV(fmt, args); }

        static bool BeginPopup(const char* str_id, ImGuiWindowFlags flags = 0) { return ImGui::BeginPopup(str_id, flags); }
        static bool BeginPopupModal(const char* name, bool* p_open = NULL, ImGuiWindowFlags flags = 0) { return ImGui::BeginPopupModal(name, p_open, flags); }
        static void EndPopup() { ImGui::EndPopup(); }

        static void OpenPopup(const char* str_id, ImGuiPopupFlags popup_flags = 0) { ImGui::OpenPopup(str_id, popup_flags); }
        static void OpenPopup2(ImGuiID id, ImGuiPopupFlags popup_flags = 0) { ImGui::OpenPopup(id, popup_flags); }
        static void OpenPopupOnItemClick(const char* str_id = NULL, ImGuiPopupFlags popup_flags = 1) { ImGui::OpenPopupOnItemClick(str_id, popup_flags); }
        static void CloseCurrentPopup() { ImGui::CloseCurrentPopup(); }

        static bool BeginPopupContextItem(const char* str_id = NULL, ImGuiPopupFlags popup_flags = 1) { return ImGui::BeginPopupContextItem(str_id, popup_flags); }
        static bool BeginPopupContextWindow(const char* str_id = NULL, ImGuiPopupFlags popup_flags = 1) { return ImGui::BeginPopupContextWindow(str_id, popup_flags); }
        static bool BeginPopupContextVoid(const char* str_id = NULL, ImGuiPopupFlags popup_flags = 1) { return ImGui::BeginPopupContextVoid(str_id, popup_flags); }

        static bool IsPopupOpen(const char* str_id, ImGuiPopupFlags flags = 0) { return ImGui::IsPopupOpen(str_id, flags); }

        static bool BeginTable(const char* str_id, int column, ImGuiTableFlags flags = 0, const ImVec2& outer_size = ImVec2(0.0f, 0.0f), float inner_width = 0.0f) { return ImGui::BeginTable(str_id, column, flags, outer_size, inner_width); }
        static void EndTable() { ImGui::EndTable(); }
        static void TableNextRow(ImGuiTableRowFlags row_flags = 0, float min_row_height = 0.0f) { ImGui::TableNextRow(row_flags, min_row_height); }
        static bool TableNextColumn() { return ImGui::TableNextColumn(); }
        static bool TableSetColumnIndex(int column_n) { return ImGui::TableSetColumnIndex(column_n); }

        static void TableSetupColumn(const char* label, ImGuiTableColumnFlags flags = 0, float init_width_or_weight = 0.0f, ImGuiID user_id = 0) { ImGui::TableSetupColumn(label, flags); }
        static void TableSetupScrollFreeze(int cols, int rows) { ImGui::TableSetupScrollFreeze(cols, rows); }
        static void TableHeadersRow() { ImGui::TableHeadersRow(); }
        static void TableHeader(const char* label) { ImGui::TableHeader(label); }

        static ImGuiTableSortSpecs* TableGetSortSpecs() { ImGui::TableGetSortSpecs(); }
        static int TableGetColumnCount() { return ImGui::TableGetColumnCount(); }
        static int TableGetColumnIndex() { return ImGui::TableGetColumnIndex(); }
        static int TableGetRowIndex() { return ImGui::TableGetRowIndex(); }
        static const char* TableGetColumnName(int column_n = -1) { return ImGui::TableGetColumnName(column_n); }
        static ImGuiTableColumnFlags TableGetColumnFlags(int column_n = -1) { return ImGui::TableGetColumnFlags(column_n); }
        static void TableSetColumnEnabled(int column_n, bool v) { ImGui::TableSetColumnEnabled(column_n, v); }
        static void TableSetBgColor(ImGuiTableBgTarget target, ImU32 color, int column_n = -1) { ImGui::TableSetBgColor(target, color, column_n); }

        static void Columns(int count = 1, const char* id = NULL, bool border = true) { ImGui::Columns(count, id, border); }
        static void NextColumn() { ImGui::NextColumn(); }
        static int GetColumnIndex() { return ImGui::GetColumnIndex(); }
        static float GetColumnWidth(int column_index = -1) { return ImGui::GetColumnWidth(column_index); }
        static void SetColumnWidth(int column_index, float width) { ImGui::SetColumnWidth(column_index, width); }
        static float GetColumnOffset(int column_index = -1) { return ImGui::GetColumnOffset(column_index); }
        static void SetColumnOffset(int column_index, float offset_x) { ImGui::SetColumnOffset(column_index, offset_x); }
        static int GetColumnsCount() { return ImGui::GetColumnsCount(); }

        static bool BeginTabBar(const char* str_id, ImGuiTabBarFlags flags = 0) { return ImGui::BeginTabBar(str_id, flags); }
        static void EndTabBar() { ImGui::EndTabBar(); }
        static bool BeginTabItem(const char* label, bool* p_open = NULL, ImGuiTabItemFlags flags = 0) { return ImGui::BeginTabItem(label, p_open, flags); }
        static void EndTabItem() { ImGui::EndTabItem(); }
        static bool TabItemButton(const char* label, ImGuiTabItemFlags flags = 0) { return ImGui::TabItemButton(label, flags); }
        static void SetTabItemClosed(const char* tab_or_docked_window_label) { ImGui::SetTabItemClosed(tab_or_docked_window_label); }

        static ImGuiID DockSpace(ImGuiID id, const ImVec2& size = ImVec2(0, 0), ImGuiDockNodeFlags flags = 0, const ImGuiWindowClass* window_class = NULL) { return ImGui::DockSpace(id, size, flags); }
        static ImGuiID DockSpaceOverViewport(const ImGuiViewport* viewport = NULL, ImGuiDockNodeFlags flags = 0, const ImGuiWindowClass* window_class = NULL) { return ImGui::DockSpaceOverViewport(viewport, flags, window_class); }
        static void SetNextWindowDockID(ImGuiID dock_id, ImGuiCond cond = 0) { ImGui::SetNextWindowDockID(dock_id, cond); }
        static void SetNextWindowClass(const ImGuiWindowClass* window_class) { ImGui::SetNextWindowClass(window_class); }
        static ImGuiID GetWindowDockID() { return ImGui::GetWindowDockID(); }
        static bool IsWindowDocked() { return ImGui::IsWindowDocked(); }

        static void LogToTTY(int auto_open_depth = -1) { ImGui::LogToTTY(auto_open_depth); }
        static void LogToFile(int auto_open_depth = -1, const char* filename = NULL) { ImGui::LogToFile(auto_open_depth); }
        static void LogToClipboard(int auto_open_depth = -1) { ImGui::LogToClipboard(auto_open_depth); }
        static void LogFinish() { ImGui::LogFinish(); }
        static void LogButtons() { ImGui::LogButtons(); }
        static void LogText(const char* fmt) { ImGui::LogText(fmt); }
        static void LogTextV(const char* fmt, va_list args) { ImGui::LogTextV(fmt, args); }

        static bool BeginDragDropSource(ImGuiDragDropFlags flags = 0) { return ImGui::BeginDragDropSource(flags); }
        static bool SetDragDropPayload(const char* type, const void* data, size_t sz, ImGuiCond cond = 0) { return ImGui::SetDragDropPayload(type, data, sz, cond); }
        static void EndDragDropSource() { ImGui::EndDragDropSource(); }
        static bool BeginDragDropTarget() { return ImGui::BeginDragDropTarget(); }
        static const ImGuiPayload* AcceptDragDropPayload(const char* type, ImGuiDragDropFlags flags = 0) { return ImGui::AcceptDragDropPayload(type, flags); }
        static void EndDragDropTarget() { ImGui::EndDragDropTarget(); }
        static const ImGuiPayload*  GetDragDropPayload() { return ImGui::GetDragDropPayload(); }

        static void BeginDisabled(bool disabled = true) { ImGui::BeginDisabled(disabled); }
        static void EndDisabled() { ImGui::EndDisabled(); }

        static void PushClipRect(const ImVec2& clip_rect_min, const ImVec2& clip_rect_max, bool intersect_with_current_clip_rect) { ImGui::PushClipRect(clip_rect_min, clip_rect_max, intersect_with_current_clip_rect); }
        static void PopClipRect() {  ImGui::PopClipRect(); }

        static void SetItemDefaultFocus() {  ImGui::SetItemDefaultFocus(); }
        static void SetKeyboardFocusHere(int offset = 0) { ImGui::SetKeyboardFocusHere(offset); }

        static bool IsItemHovered(ImGuiHoveredFlags flags = 0) { return ImGui::IsItemHovered(flags); }
        static bool IsItemActive() { return ImGui::IsItemActive(); }
        static bool IsItemFocused() { return ImGui::IsItemFocused(); }
        static bool IsItemClicked(ImGuiMouseButton mouse_button = 0) { return ImGui::IsItemClicked(mouse_button); }
        static bool IsItemVisible() { return ImGui::IsItemVisible(); }
        static bool IsItemEdited() { return ImGui::IsItemEdited(); }
        static bool IsItemActivated() { return ImGui::IsItemActivated(); }
        static bool IsItemDeactivated() { return ImGui::IsItemDeactivated(); }
        static bool IsItemDeactivatedAfterEdit() { return ImGui::IsItemDeactivatedAfterEdit(); }
        static bool IsItemToggledOpen() { return ImGui::IsItemToggledOpen(); }
        static bool IsAnyItemHovered() { return ImGui::IsAnyItemHovered(); }
        static bool IsAnyItemActive() { return ImGui::IsAnyItemActive(); }
        static bool IsAnyItemFocused() { return ImGui::IsAnyItemFocused(); }
        static ImGuiID GetItemID() { return ImGui::GetItemID(); }
        static ImVec2 GetItemRectMin() { return ImGui::GetItemRectMin(); }
        static ImVec2 GetItemRectMax() { return ImGui::GetItemRectMax(); }
        static ImVec2 GetItemRectSize() { return ImGui::GetItemRectSize(); }
        static void SetItemAllowOverlap() { ImGui::SetItemAllowOverlap(); }

        static ImGuiViewport* GetMainViewport() { return ImGui::GetMainViewport(); }

        static ImDrawList* GetBackgroundDrawList() { return ImGui::GetBackgroundDrawList(); }
        static ImDrawList* GetForegroundDrawList() { return ImGui::GetForegroundDrawList(); }
        static ImDrawList* GetBackgroundDrawList2(ImGuiViewport* viewport) { return ImGui::GetBackgroundDrawList(viewport); }
        static ImDrawList* GetForegroundDrawList2(ImGuiViewport* viewport) { return ImGui::GetForegroundDrawList(viewport); }

        static bool IsRectVisible(const ImVec2& size) { return ImGui::IsRectVisible(size); }
        static bool IsRectVisible2(const ImVec2& rect_min, const ImVec2& rect_max) { return ImGui::IsRectVisible(rect_min, rect_max); }
        static double GetTime() { return ImGui::GetTime(); }
        static int GetFrameCount() { return ImGui::GetFrameCount(); }
        static ImDrawListSharedData* GetDrawListSharedData() { return ImGui::GetDrawListSharedData(); }
        static const char* GetStyleColorName(ImGuiCol idx) { return ImGui::GetStyleColorName(idx); }
        static void SetStateStorage(ImGuiStorage* storage) { ImGui::SetStateStorage(storage); }
        static ImGuiStorage* GetStateStorage() { return ImGui::GetStateStorage(); }
        static bool BeginChildFrame(ImGuiID id, const ImVec2& size, ImGuiWindowFlags flags = 0) { return ImGui::BeginChildFrame(id, size, flags); }
        static void EndChildFrame() { ImGui::EndChildFrame(); }

        static ImVec2 CalcTextSize(const char* text, const char* text_end = NULL, bool hide_text_after_double_hash = false, float wrap_width = -1.0f) { return ImGui::CalcTextSize(text, text_end, hide_text_after_double_hash, wrap_width); }

        static ImVec4 ColorConvertU32ToFloat4(ImU32 in) { return ImGui::ColorConvertU32ToFloat4(in); }
        static ImU32 ColorConvertFloat4ToU32(const ImVec4& in) { return ImGui::ColorConvertFloat4ToU32(in); }
        static void ColorConvertRGBtoHSV(float r, float g, float b, float* out_h, float* out_s, float* out_v) {
            float & out_h2 = *out_h;
            float & out_s2 = *out_s;
            float & out_v2 = *out_v;
            // TODO test if this works.
            ImGui::ColorConvertRGBtoHSV(r, g, b, out_h2, out_s2, out_v2);
        }
        static void ColorConvertHSVtoRGB(float h, float s, float v, float* out_r, float* out_g, float* out_b) {
            float & out_r2 = *out_r;
            float & out_g2 = *out_g;
            float & out_b2 = *out_b;
            ImGui::ColorConvertHSVtoRGB(h, s, v, out_r2, out_g2, out_b2);
        }

        static bool IsKeyDown(ImGuiKey key) { return ImGui::IsKeyDown(key); }
        static bool IsKeyPressed(ImGuiKey key, bool repeat = true) { return ImGui::IsKeyPressed(key, repeat); }
        static bool IsKeyReleased(ImGuiKey key) { return ImGui::IsKeyReleased(key); }
        static int GetKeyPressedAmount(ImGuiKey key, float repeat_delay, float rate) { return ImGui::GetKeyPressedAmount(key, repeat_delay, rate); }
        static const char* GetKeyName(ImGuiKey key) { return ImGui::GetKeyName(key); }
        static void SetNextFrameWantCaptureKeyboard(bool want_capture_keyboard) { ImGui::SetNextFrameWantCaptureKeyboard(want_capture_keyboard); }

        static bool IsMouseDown(ImGuiMouseButton button) { return ImGui::IsMouseDown(button); }
        static bool IsMouseClicked(ImGuiMouseButton button, bool repeat = false) { return ImGui::IsMouseClicked(button); }
        static bool IsMouseReleased(ImGuiMouseButton button) { return ImGui::IsMouseReleased(button); }
        static bool IsMouseDoubleClicked(ImGuiMouseButton button) { return ImGui::IsMouseDoubleClicked(button); }
        static int GetMouseClickedCount(ImGuiMouseButton button) { return ImGui::GetMouseClickedCount(button); }
        static bool IsMouseHoveringRect(const ImVec2& r_min, const ImVec2& r_max, bool clip = true) { return ImGui::IsMouseHoveringRect(r_min, r_max, clip); }
        static bool IsMousePosValid(const ImVec2* mouse_pos = NULL) { return ImGui::IsMousePosValid(mouse_pos); }
        static bool IsAnyMouseDown() { return ImGui::IsAnyMouseDown(); }
        static ImVec2 GetMousePos() { return ImGui::GetMousePos(); }
        static ImVec2 GetMousePosOnOpeningCurrentPopup() { return ImGui::GetMousePosOnOpeningCurrentPopup(); }
        static bool IsMouseDragging(ImGuiMouseButton button, float lock_threshold = -1.0f) { return ImGui::IsMouseDragging(button, lock_threshold); }
        static ImVec2 GetMouseDragDelta(ImGuiMouseButton button = 0, float lock_threshold = -1.0f) { return ImGui::GetMouseDragDelta(button, lock_threshold); }
        static void ResetMouseDragDelta(ImGuiMouseButton button = 0) { ImGui::ResetMouseDragDelta(button); }
        static ImGuiMouseCursor GetMouseCursor() { return ImGui::GetMouseCursor(); }
        static void SetMouseCursor(ImGuiMouseCursor cursor_type) { ImGui::SetMouseCursor(cursor_type); }
        static void SetNextFrameWantCaptureMouse(bool want_capture_mouse) { ImGui::SetNextFrameWantCaptureMouse(want_capture_mouse); }

        static const char* GetClipboardText() { return ImGui::GetClipboardText(); }
        static void SetClipboardText(const char* text) { ImGui::SetClipboardText(text); }

        static void LoadIniSettingsFromDisk(const char* ini_filename) { ImGui::LoadIniSettingsFromDisk(ini_filename); }
        static void LoadIniSettingsFromMemory(const char* ini_data, size_t ini_size=0) { ImGui::LoadIniSettingsFromMemory(ini_data, ini_size); }
        static void SaveIniSettingsToDisk(const char* ini_filename) { ImGui::SaveIniSettingsToDisk(ini_filename); }
        static const char* SaveIniSettingsToMemory(size_t* out_ini_size = NULL) { return ImGui::SaveIniSettingsToMemory(out_ini_size); }

        static void DebugTextEncoding(const char* text) { ImGui::DebugTextEncoding(text); }
        static bool DebugCheckVersionAndDataLayout(const char* version_str, size_t sz_io, size_t sz_style, size_t sz_vec2, size_t sz_vec4, size_t sz_drawvert, size_t sz_drawidx) { return ImGui::DebugCheckVersionAndDataLayout(version_str, sz_io, sz_style, sz_vec2, sz_vec4, sz_drawvert, sz_drawidx); }

        static void SetAllocatorFunctions(ImGuiMemAllocFunc alloc_func, ImGuiMemFreeFunc free_func, void* user_data = NULL) { ImGui::SetAllocatorFunctions(alloc_func, free_func, user_data); }
        static void GetAllocatorFunctions(ImGuiMemAllocFunc* p_alloc_func, ImGuiMemFreeFunc* p_free_func, void** p_user_data) { ImGui::GetAllocatorFunctions(p_alloc_func, p_free_func, p_user_data); }
        static void* MemAlloc(size_t size) { return ImGui::MemAlloc(size); }
        static void MemFree(void* ptr) { ImGui::MemFree(ptr); }

        static ImGuiPlatformIO& GetPlatformIO() { return ImGui::GetPlatformIO(); }
        static void UpdatePlatformWindows() { ImGui::UpdatePlatformWindows(); }
        static void RenderPlatformWindowsDefault(void* platform_render_arg = NULL, void* renderer_render_arg = NULL) { ImGui::RenderPlatformWindowsDefault(platform_render_arg, renderer_render_arg); }
        static void DestroyPlatformWindows() { ImGui::DestroyPlatformWindows(); }
        static ImGuiViewport* FindViewportByID(ImGuiID id) { return ImGui::FindViewportByID(id); }
        static ImGuiViewport* FindViewportByPlatformHandle(void* platform_handle) { return ImGui::FindViewportByPlatformHandle(platform_handle); }
};