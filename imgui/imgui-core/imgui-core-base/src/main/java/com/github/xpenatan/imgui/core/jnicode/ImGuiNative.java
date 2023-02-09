package com.github.xpenatan.imgui.core.jnicode;


public class ImGuiNative {
    /*[-C++;-NATIVE]
        #include "imgui_helper.h"
        #include "imgui_custom.h"

        #include <imgui.h>
        #include <cstring>
        #if defined(_MSC_VER) && _MSC_VER <= 1500 // MSVC 2008 or earlier
        #include <stddef.h>     // intptr_t
        #else
        #include <stdint.h>     // intptr_t
        #endif

        static int DRAWLIST_TYPE_DEFAULT = 0;
        static int DRAWLIST_TYPE_BACKGROUND = 1;
        static int DRAWLIST_TYPE_FOREGROUND = 2;
    */

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGuiHelper::Init(env);
    */
    public static native void init();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.CreateContext();
    */
    /*[-C++;-NATIVE]
        ImGui::CreateContext();
        if(saveIni == false) {
            ImGui::GetIO().IniFilename = NULL;
        }
        ImGui::GetIO().BackendFlags |= ImGuiBackendFlags_HasMouseCursors;
    */
    public static native void CreateContext(boolean saveIni);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::DestroyContext();
    */
    public static native void DestroyContext();

    /*[-teaVM;-NATIVE]
        var jsObj = ImGui.Im.prototype.GetIO();
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        return (jlong)&ImGui::GetIO();
    */
    public static native long getIONATIVE();

    /*[-teaVM;-NATIVE]
        var jsObj = ImGui.Im.prototype.GetStyle();
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        return (jlong)&ImGui::GetStyle();
    */
    public static native long GetStyleNATIVE();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGuiIO& io = ImGui::GetIO();
        io.ConfigFlags = flag;
    */
    public static native void SetConfigFlags(int flag);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        ImGuiIO& io = ImGui::GetIO();
        int newFlag = io.ConfigFlags & flag;
        return newFlag == flag;
    */
    public static native boolean ContainsConfigFlags(int flag);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGuiIO& io = ImGui::GetIO();
        io.ConfigDockingNoSplit = ConfigDockingNoSplit;
        io.ConfigDockingWithShift = ConfigDockingWithShift;
        io.ConfigDockingAlwaysTabBar = ConfigDockingAlwaysTabBar;
        io.ConfigDockingTransparentPayload = ConfigDockingTransparentPayload;
    */
    public static native void SetDockingFlags(boolean ConfigDockingNoSplit, boolean ConfigDockingWithShift, boolean ConfigDockingAlwaysTabBar, boolean ConfigDockingTransparentPayload);

    /*[-teaVM;-NATIVE]
        var io = ImGui.wrapPointer(imguiIOAddr, ImGui.ImGuiIO);
        io.get_DisplaySize().set_x(width);
        io.get_DisplaySize().set_y(height);
        if (width > 0 && height > 0) {
            io.get_DisplayFramebufferScale().set_x(display_w / width);
            io.get_DisplayFramebufferScale().set_y(display_h / height);
        }
        io.set_DeltaTime = deltaTime;
        ImGui.Im.prototype.NewFrame();
    */
    /*[-C++;-NATIVE]
        ImGuiIO * io = (ImGuiIO*)imguiIOAddr;

        io->DisplaySize = ImVec2(width, height);
        if (width > 0 && height > 0)
            io->DisplayFramebufferScale = ImVec2((float)display_w / width, (float)display_h / height);
        io->DeltaTime = deltaTime;

        ImGui::NewFrame();
    */
    public static native void UpdateDisplayAndInputAndFrame(long imguiIOAddr, float deltaTime, int width, int height, int display_w, int display_h);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.Render();
    */
    /*[-C++;-NATIVE]
        ImGui::Render();
    */
    public static native void Render();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::ShowStyleEditor();
    */
    public static native void ShowStyleEditor();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.ShowDemoWindow();
    */
    /*[-C++;-NATIVE]
        ImGui::ShowDemoWindow();
    */
    public static native void ShowDemoWindow();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.ShowDemoWindow(open);
    */
    /*[-C++;-NATIVE]
        bool toOpen = open;
        ImGui::ShowDemoWindow(&toOpen);
    */
    public static native void ShowDemoWindow(boolean open);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::ShowMetricsWindow();
    */
    public static native void ShowMetricsWindow();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        bool toOpen = open;
        ImGui::ShowMetricsWindow(&toOpen);
    */
    public static native void ShowMetricsWindow(boolean open);

    /*[-teaVM;-NATIVE]
        var jsObj = ImGui.Im.prototype.GetDrawData();
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        ImDrawData * drawData = ImGui::GetDrawData();
        return (jlong)drawData;
    */
    public static native long GetDrawData();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::StyleColorsDark();
    */
    public static native void StyleColorsDark();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::StyleColorsClassic();
    */
    public static native void StyleColorsClassic();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::StyleColorsLight();
    */
    public static native void StyleColorsLight();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.Begin(title);
    */
    /*[-C++;-NATIVE]
        return ImGui::Begin(title);
    */
    public static native boolean Begin(String title);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.Begin(title, imGuiWindowFlags);
    */
    /*[-C++;-NATIVE]
        return ImGui::Begin(title, NULL, imGuiWindowFlags);
    */
    public static native boolean Begin(String title, int imGuiWindowFlags);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.Begin(title, p_open, imGuiWindowFlags);
    */
    /*[-C++;-NATIVE]
        bool * p_open = (bool*)p_openAddr;
        bool flag = p_open[0];
        bool ret = ImGui::Begin(title, &flag, imGuiWindowFlags);
        p_open[0] = flag;
        return flag;
    */
    public static native boolean Begin(String title, long p_openAddr, int imGuiWindowFlags);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.End();
    */
    /*[-C++;-NATIVE]
        ImGui::End();
    */
    public static native void End();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginChild(str_id);
    */
    public static native boolean BeginChild(String str_id);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginChild(str_id, ImVec2(width, height));
    */
    public static native boolean BeginChild(String str_id, float width, float height);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginChild(str_id, ImVec2(width, height), border);
    */
    public static native boolean BeginChild(String str_id, float width, float height, boolean border);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginChild(str_id, ImVec2(width, height), border, flags);
    */
    public static native boolean BeginChild(String str_id, float width, float height, boolean border, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginChild(imGuiID);
    */
    public static native boolean BeginChild(int imGuiID);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginChild(imGuiID, ImVec2(width, height), border);
    */
    public static native boolean BeginChild(int imGuiID, float width, float height, boolean border);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginChild(imGuiID, ImVec2(width, height), border, flags);
    */
    public static native boolean BeginChild(int imGuiID, float width, float height, boolean border, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::EndChild();
    */
    public static native void EndChild();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsWindowAppearing();
    */
    public static native boolean IsWindowAppearing();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsWindowCollapsed();
    */
    public static native boolean IsWindowCollapsed();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsWindowFocused();
    */
    public static native boolean IsWindowFocused();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsWindowFocused(flags);
    */
    public static native boolean IsWindowFocused(int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsWindowHovered();
    */
    public static native boolean IsWindowHovered();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsWindowHovered(flags);
    */
    public static native boolean IsWindowHovered(int flags);

    // DrawList

    /*[-C++;-NATIVE]
        ImDrawList * getDrawList(int type) {
            ImDrawList* drawList = NULL;
            if(type == DRAWLIST_TYPE_DEFAULT)
                drawList = ImGui::GetWindowDrawList();
            else if(type == DRAWLIST_TYPE_BACKGROUND)
                drawList = ImGui::GetBackgroundDrawList();
            else if(type == DRAWLIST_TYPE_FOREGROUND)
                drawList = ImGui::GetForegroundDrawList();
            return drawList;
        }
    */

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddLine(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col);
    */
    public static native void AddLine(int type, float a_x, float a_y, float b_x, float b_y, int col);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddLine(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col, thinkness);
    */
    public static native void AddLine(int type, float a_x, float a_y, float b_x, float b_y, int col, float thinkness);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRect(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col);
    */
    public static native void AddRect(int type, float a_x, float a_y, float b_x, float b_y, int col);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRect(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col, rounding);
    */
    public static native void AddRect(int type, float a_x, float a_y, float b_x, float b_y, int col, float rounding);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRect(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col, rounding, rounding_corners_flags);
    */
    public static native void AddRect(int type, float a_x, float a_y, float b_x, float b_y, int col, float rounding, int rounding_corners_flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRect(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col, rounding, rounding_corners_flags, thickness);
    */
    public static native void AddRect(int type, float a_x, float a_y, float b_x, float b_y, int col, float rounding, int rounding_corners_flags, float thickness);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRectFilled(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col);
    */
    public static native void AddRectFilled(int type, float a_x, float a_y, float b_x, float b_y, int col);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRectFilled(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col, rounding);
    */
    public static native void AddRectFilled(int type, float a_x, float a_y, float b_x, float b_y, int col, float rounding);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRectFilled(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col, rounding, rounding_corners_flags);
    */
    public static native void AddRectFilled(int type, float a_x, float a_y, float b_x, float b_y, int col, float rounding, int rounding_corners_flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddRectFilledMultiColor(ImVec2(a_x, a_y), ImVec2(b_x, b_y), col_upr_left, col_upr_right, col_bot_right, col_bot_left);
    */
    public static native void AddRectFilledMultiColor(int type, float a_x, float a_y, float b_x, float b_y, int col_upr_left, float col_upr_right, int col_bot_right, int col_bot_left);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddQuad(ImVec2(a_x, a_y), ImVec2(b_x, b_y), ImVec2(c_x, c_y), ImVec2(d_x, d_y), col);
    */
    public static native void AddQuad(int type, float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, float d_x, float d_y, int col);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddQuad(ImVec2(a_x, a_y), ImVec2(b_x, b_y), ImVec2(c_x, c_y), ImVec2(d_x, d_y), col, thickness);
    */
    public static native void AddQuad(int type, float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, float d_x, float d_y, int col, float thickness);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddQuadFilled(ImVec2(a_x, a_y), ImVec2(b_x, b_y), ImVec2(c_x, c_y), ImVec2(d_x, d_y), col);
    */
    public static native void AddQuadFilled(int type, float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, float d_x, float d_y, int col);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddTriangle(ImVec2(a_x, a_y), ImVec2(b_x, b_y), ImVec2(c_x, c_y), col);
    */
    public static native void AddTriangle(int type, float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, int col);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddTriangle(ImVec2(a_x, a_y), ImVec2(b_x, b_y), ImVec2(c_x, c_y), col, thickness);
    */
    public static native void AddTriangle(int type, float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, int col, float thickness);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddTriangleFilled(ImVec2(a_x, a_y), ImVec2(b_x, b_y), ImVec2(c_x, c_y), col);
    */
    public static native void AddTriangleFilled(int type, float a_x, float a_y, float b_x, float b_y, float c_x, float c_y, int col);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddCircle(ImVec2(centre_x, centre_y), radius, col);
    */
    public static native void AddCircle(int type, float centre_x, float centre_y, float radius, float col);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddCircle(ImVec2(centre_x, centre_y), radius, col, num_segments, thickness);
    */
    public static native void AddCircle(int type, float centre_x, float centre_y, float radius, float col, int num_segments, float thickness);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddCircleFilled(ImVec2(centre_x, centre_y), radius, col);
    */
    public static native void AddCircleFilled(int type, float centre_x, float centre_y, float radius, float col);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddCircleFilled(ImVec2(centre_x, centre_y), radius, col, num_segments);
    */
    public static native void AddCircleFilled(int type, float centre_x, float centre_y, float radius, float col, int num_segments);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddText(ImVec2(pos_x, pos_y), col, text_begin);
    */
    public static native void AddText(int type, float pos_x, float pos_y, int col, String text_begin);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddText(ImVec2(pos_x, pos_y), col, text_begin, text_end);
    */
    public static native void AddText(int type, float pos_x, float pos_y, int col, String text_begin, String text_end);

//TODO	IMGUI_API void  AddText(const ImFont* font, float font_size, const ImVec2& pos, ImU32 col, const char* text_begin, const char* text_end = NULL, float wrap_width = 0.0f, const ImVec4* cpu_fine_clip_rect = NULL);
//TODO	IMGUI_API void  AddPolyline(const ImVec2* points, int num_points, ImU32 col, ImDrawFlags flags, float thickness);
//TODO	IMGUI_API void  AddConvexPolyFilled(const ImVec2* points, int num_points, ImU32 col); // Note: Anti-aliased filling requires points to be in clockwise order.
//TODO	IMGUI_API void  AddBezierCubic(const ImVec2& p1, const ImVec2& p2, const ImVec2& p3, const ImVec2& p4, ImU32 col, float thickness, int num_segments = 0); // Cubic Bezier (4 control points)
//TODO	IMGUI_API void  AddBezierQuadratic(const ImVec2& p1, const ImVec2& p2, const ImVec2& p3, ImU32 col, float thickness, int num_segments = 0);               // Quadratic Bezier (3 control points)

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddImage((void *)textureID, ImVec2(a_x, a_y), ImVec2(b_x, b_y));
    */
    public static native void AddImage(int type, int textureID, float a_x, float a_y, float b_x, float b_y);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->AddImage((void *)textureID, ImVec2(a_x, a_y), ImVec2(b_x, b_y), ImVec2(uv_a_x, uv_a_y), ImVec2(uv_b_x, uv_b_y));
    */
    public static native void AddImage(int type, int textureID, float a_x, float a_y, float b_x, float b_y, float uv_a_x, float uv_a_y, float uv_b_x, float uv_b_y);

//TODO	IMGUI_API void  AddImageQuad(ImTextureID user_texture_id, const ImVec2& p1, const ImVec2& p2, const ImVec2& p3, const ImVec2& p4, const ImVec2& uv1 = ImVec2(0, 0), const ImVec2& uv2 = ImVec2(1, 0), const ImVec2& uv3 = ImVec2(1, 1), const ImVec2& uv4 = ImVec2(0, 1), ImU32 col = IM_COL32_WHITE);
//TODO	IMGUI_API void  AddImageRounded(ImTextureID user_texture_id, const ImVec2& p_min, const ImVec2& p_max, const ImVec2& uv_min, const ImVec2& uv_max, ImU32 col, float rounding, ImDrawFlags flags = 0);

    // Stateful path API, add points then finish with PathFillConvex() or PathStroke()

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->PathClear();
    */
    public static native void PathClear(int type);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->PathLineTo(ImVec2(pos_x, pos_y));
    */
    public static native void PathLineTo(int type, float pos_x, float pos_y);

//TODO	inline    void  PathLineToMergeDuplicate(const ImVec2& pos)                 { if (_Path.Size == 0 || memcmp(&_Path.Data[_Path.Size - 1], &pos, 8) != 0) _Path.push_back(pos); }
//TODO	inline    void  PathFillConvex(ImU32 col)                                   { AddConvexPolyFilled(_Path.Data, _Path.Size, col); _Path.Size = 0; }  // Note: Anti-aliased filling requires points to be in clockwise order.

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->PathStroke(col);
    */
    public static native void PathStroke(int type, int col);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->PathStroke(col, flags);
    */
    public static native void PathStroke(int type, int col, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->PathStroke(col, flags, thickness);
    */
    public static native void PathStroke(int type, int col, int flags, float thickness);
//TODO	inline    void  PathStroke(ImU32 col, ImDrawFlags flags = 0, float thickness = 1.0f) { AddPolyline(_Path.Data, _Path.Size, col, flags, thickness); _Path.Size = 0; }

//TODO	IMGUI_API void  PathArcTo(const ImVec2& center, float radius, float a_min, float a_max, int num_segments = 0);
//TODO	IMGUI_API void  PathArcToFast(const ImVec2& center, float radius, int a_min_of_12, int a_max_of_12);                // Use precomputed angles for a 12 steps circle
//TODO	IMGUI_API void  PathBezierCubicCurveTo(const ImVec2& p2, const ImVec2& p3, const ImVec2& p4, int num_segments = 0); // Cubic Bezier (4 control points)
//TODO	IMGUI_API void  PathBezierQuadraticCurveTo(const ImVec2& p2, const ImVec2& p3, int num_segments = 0);               // Quadratic Bezier (3 control points)
//TODO	IMGUI_API void  PathRect(const ImVec2& rect_min, const ImVec2& rect_max, float rounding = 0.0f, ImDrawFlags flags = 0);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->ChannelsSplit(count);
    */
    public static native void ChannelsSplit(int type, int count);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->ChannelsMerge();
    */
    public static native void ChannelsMerge(int type);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImDrawList* drawList = getDrawList(type);
        drawList->ChannelsSetCurrent(n);
    */
    public static native void ChannelsSetCurrent(int type, int n);

    /*[-teaVM;-NATIVE]
        var out = ImGui.wrapPointer(vec2Addr, ImGui.ImVec2);
        var nativeObject = ImGui.Im.prototype.GetWindowPos();
        out.set_x(nativeObject.get_x());
        out.set_y(nativeObject.get_y());
    */
    /*[-C++;-NATIVE]
        ImVec2 nativeObject = ImGui::GetWindowPos();
        ImVec2 * out = (ImVec2*)vec2Addr;
        out->x = nativeObject.x;
        out->y = nativeObject.y;
    */
    public static native void GetWindowPos(long vec2Addr);

    /*[-teaVM;-NATIVE]
        var out = ImGui.wrapPointer(vec2Addr, ImGui.ImVec2);
        var nativeObject = ImGui.Im.prototype.GetWindowPos();
        return nativeObject.get_x();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetWindowPos().x;
    */
    public static native float GetWindowPosX();

    /*[-teaVM;-NATIVE]
        var out = ImGui.wrapPointer(vec2Addr, ImGui.ImVec2);
        var nativeObject = ImGui.Im.prototype.GetWindowPos();
        return nativeObject.get_y();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetWindowPos().y;
    */
    public static native float GetWindowPosY();

    /*[-teaVM;-NATIVE]
        var out = ImGui.wrapPointer(vec2Addr, ImGui.ImVec2);
        var nativeObject = ImGui.Im.prototype.GetWindowSize();
        out.set_x(nativeObject.get_x());
        out.set_y(nativeObject.get_y());
    */
    /*[-C++;-NATIVE]
        ImVec2 nativeObject = ImGui::GetWindowSize();
        ImVec2 * out = (ImVec2*)vec2Addr;
        out->x = nativeObject.x;
        out->y = nativeObject.y;
    */
    public static native void GetWindowSize(long vec2Addr);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetWindowWidth();
    */
    public static native float GetWindowWidth();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetWindowHeight();
    */
    public static native float GetWindowHeight();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* viewport = ImGui::GetWindowViewport();
        return (jlong)viewport;
    */
    public static native long GetWindowViewport();

    // Prefer using SetNextXXX functions (before Begin) rather that SetXXX functions (after Begin).

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowPos(ImVec2(x, y));
    */
    public static native void SetNextWindowPos(float x, float y);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowPos(ImVec2(x, y), cond);
    */
    public static native void SetNextWindowPos(float x, float y, int cond);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowPos(ImVec2(x, y), cond, ImVec2(pivot_x, pivot_y));
    */
    public static native void SetNextWindowPos(float x, float y, int cond, float pivot_x, float pivot_y);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetNextWindowSize(new ImGui.ImVec2(width, height));
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowSize(ImVec2(width, height));
    */
    public static native void SetNextWindowSize(float width, float height);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowSize(ImVec2(width, height), cond);
    */
    public static native void SetNextWindowSize(float width, float height, int cond);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowSizeConstraints(ImVec2(min_width, min_height), ImVec2(max_width, max_height));
    */
    public static native void SetNextWindowSizeConstraints(float min_width, float min_height, float max_width, float max_height);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowContentSize(ImVec2(width, height));
    */
    public static native void SetNextWindowContentSize(float width, float height);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowCollapsed(collapsed);
    */
    public static native void SetNextWindowCollapsed(boolean collapsed);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowCollapsed(collapsed, cond);
    */
    public static native void SetNextWindowCollapsed(boolean collapsed, int cond);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowFocus();
    */
    public static native void SetNextWindowFocus();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowBgAlpha(alpha);
    */
    public static native void SetNextWindowBgAlpha(float alpha);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowPos(ImVec2(x, y));
    */
    public static native void SetWindowPos(float x, float y);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowPos(ImVec2(x, y), cond);
    */
    public static native void SetWindowPos(float x, float y, int cond);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowSize(ImVec2(width, height));
    */
    public static native void SetWindowSize(float width, float height);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowSize(ImVec2(width, height), cond);
    */
    public static native void SetWindowSize(float width, float height, int cond);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowCollapsed(collapsed, cond);
    */
    public static native void SetWindowCollapsed(boolean collapsed, int cond);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowFocus();
    */
    public static native void SetWindowFocus();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowFontScale(scale);
    */
    public static native void SetWindowFocus(float scale);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowPos(name, ImVec2(x, y));
    */
    public static native void SetWindowPos(String name, float x, float y);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowPos(name, ImVec2(x, y), cond);
    */
    public static native void SetWindowPos(String name, float x, float y, int cond);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        bool flag = collapsed;
        ImGui::SetWindowCollapsed(name, flag);
    */
    public static native void SetWindowCollapsed(String name, boolean collapsed);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowCollapsed(name, collapsed, cond);
    */
    public static native void SetWindowCollapsed(String name, boolean collapsed, int cond);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowFocus(name);
    */
    public static native void SetWindowFocus(String name);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowFocus(NULL);
    */
    public static native void RemoveWindowFocus();

    // Content region
    // - Those functions are bound to be redesigned soon (they are confusing, incomplete and return values in local window coordinates which increases confusion)

    /*[-teaVM;-NATIVE]
        var out = ImGui.wrapPointer(vec2Addr, ImGui.ImVec2);
        var nativeObject = ImGui.Im.prototype.GetContentRegionMax();
        out.set_x(nativeObject.get_x());
        out.set_y(nativeObject.get_y());
    */
    /*[-C++;-NATIVE]
        ImVec2 nativeObject = ImGui::GetContentRegionMax();
        ImVec2 * out = (ImVec2*)vec2Addr;
        out->x = nativeObject.x;
        out->y = nativeObject.y;
    */
    public static native void GetContentRegionMax(long vec2Addr);

    /*[-teaVM;-NATIVE]
        var out = ImGui.wrapPointer(vec2Addr, ImGui.ImVec2);
        var nativeObject = ImGui.Im.prototype.GetContentRegionAvail();
        out.set_x(nativeObject.get_x());
        out.set_y(nativeObject.get_y());
    */
    /*[-C++;-NATIVE]
        ImVec2 nativeObject = ImGui::GetContentRegionAvail();
        ImVec2 * out = (ImVec2*)vec2Addr;
        out->x = nativeObject.x;
        out->y = nativeObject.y;
    */
    public static native void GetContentRegionAvail(long vec2Addr);

    /*[-teaVM;-NATIVE]
        var out = ImGui.wrapPointer(vec2Addr, ImGui.ImVec2);
        var nativeObject = ImGui.Im.prototype.GetWindowContentRegionMin();
        out.set_x(nativeObject.get_x());
        out.set_y(nativeObject.get_y());
    */
    /*[-C++;-NATIVE]
        ImVec2 nativeObject = ImGui::GetWindowContentRegionMin();
        ImVec2 * out = (ImVec2*)vec2Addr;
        out->x = nativeObject.x;
        out->y = nativeObject.y;
    */
    public static native void GetWindowContentRegionMin(long vec2Addr);

    /*[-teaVM;-NATIVE]
        var out = ImGui.wrapPointer(vec2Addr, ImGui.ImVec2);
        var nativeObject = ImGui.Im.prototype.GetWindowContentRegionMax();
        out.set_x(nativeObject.get_x());
        out.set_y(nativeObject.get_y());
    */
    /*[-C++;-NATIVE]
        ImVec2 nativeObject = ImGui::GetWindowContentRegionMax();
        ImVec2 * out = (ImVec2*)vec2Addr;
        out->x = nativeObject.x;
        out->y = nativeObject.y;
    */
    public static native void GetWindowContentRegionMax(long vec2Addr);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetWindowContentRegionWidth();
    */
    public static native float GetWindowContentRegionWidth();

    // Windows Scrolling

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetScrollX();
    */
    public static native float GetScrollX();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetScrollY();
    */
    public static native float GetScrollY();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetScrollMaxX();
    */
    public static native float GetScrollMaxX();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetScrollMaxY();
    */
    public static native float GetScrollMaxY();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetScrollX(scroll_x);
    */
    public static native void SetScrollX(float scroll_x);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetScrollY(scroll_y);
    */
    public static native void SetScrollY(float scroll_y);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetScrollFromPosY(local_y);
    */
    public static native void SetScrollFromPosY(float local_y);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetScrollFromPosY(local_y, center_y_ratio);
    */
    public static native void SetScrollFromPosY(float local_y, float center_y_ratio);

    // Parameters stacks (shared)

    //TODO impl

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGuiIO& io = ImGui::GetIO();
        ImFontAtlas* atlas = io.Fonts;
        ImFont* font = atlas->Fonts[index];
        ImGui::PushFont(font);
    */
    public static native void PushFont(int index);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PopFont();
    */
    public static native void PopFont();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PushStyleColor(idx, col);
    */
    public static native void PushStyleColor(int idx, int col);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PushStyleColor(idx, ImVec4(r, g, b, a));
    */
    public static native void PushStyleColor(int idx, float r, float g, float b, float a);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PopStyleColor();
    */
    public static native void PopStyleColor();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PopStyleColor(count);
    */
    public static native void PopStyleColor(int count);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PushStyleVar(idx, val);
    */
    public static native void PushStyleVar(int idx, float val);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PushStyleVar(idx, ImVec2(val_x, val_y));
    */
    public static native void PushStyleVar(int idx, float val_x, float val_y);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PopStyleVar();
    */
    public static native void PopStyleVar();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PopStyleVar(count);
    */
    public static native void PopStyleVar(int count);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImVec4 val = ImGui::GetStyleColorVec4(idx);
        value[0] = val.x;
        value[1] = val.y;
        value[2] = val.z;
        value[3] = val.w;
    */
    public static native void GetStyleColorVec4(int idx, float[] value);

    //TODO impl

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImFont * font = ImGui::GetFont();
    */
    public static native void GetFont();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetFontSize();
    */
    public static native int GetFontSize();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImVec2 val = ImGui::GetFontTexUvWhitePixel();
        value[0] = val.x;
        value[1] = val.y;
    */
    public static native void GetFontTexUvWhitePixel(float[] value);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetColorU32((ImGuiCol)idx);
    */
    public static native int GetColorU32(int idx);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetColorU32(idx, alpha_mul);
    */
    public static native int GetColorU32(int idx, float alpha_mul);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetColorU32(ImVec4(col_x, col_y, col_z, col_w));
    */
    public static native int GetColorU32(float col_x, float col_y, float col_z, float col_w);

    // Parameters stacks (current window)

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PushItemWidth(item_width);
    */
    public static native void PushItemWidth(float item_width);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PopItemWidth();
    */
    public static native void PopItemWidth();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextItemWidth(item_width);
    */
    public static native void SetNextItemWidth(float item_width);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::CalcItemWidth();
    */
    public static native float CalcItemWidth();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PushTextWrapPos(wrap_local_pos_x);
    */
    public static native void PushTextWrapPos(float wrap_local_pos_x);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PushTextWrapPos();
    */
    public static native void PushTextWrapPos();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PopTextWrapPos();
    */
    public static native void PopTextWrapPos();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PushAllowKeyboardFocus(allow_keyboard_focus);
    */
    public static native void PushAllowKeyboardFocus(boolean allow_keyboard_focus);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PopAllowKeyboardFocus();
    */
    public static native void PopAllowKeyboardFocus();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PushButtonRepeat(repeat);
    */
    public static native void PushButtonRepeat(boolean repeat);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PopButtonRepeat();
    */
    public static native void PopButtonRepeat();

    // Cursor / Layout
    // - By "cursor" we mean the current output position.
    // - The typical widget behavior is to output themselves at the current cursor position, then move the cursor one line down.

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::Separator();
    */
    public static native void Separator();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SameLine();
    */
    public static native void SameLine();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SameLine(offsetFromStartX);
    */
    public static native void SameLine(float offsetFromStartX);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SameLine(offsetFromStartX, spacing);
    */
    public static native void SameLine(float offsetFromStartX, float spacing);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::NewLine();
    */
    public static native void NewLine();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::Spacing();
    */
    public static native void Spacing();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::Dummy(ImVec2(width, height));
    */
    public static native void Dummy(float width, float height);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::Indent();
    */
    public static native void Indent();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::Indent(indentW);
    */
    public static native void Indent(float indentW);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::Unindent();
    */
    public static native void Unindent();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::Unindent(indentW);
    */
    public static native void Unindent(float indentW);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::BeginGroup();
    */
    public static native void BeginGroup();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::EndGroup();
    */
    public static native void EndGroup();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImVec2 vec = ImGui::GetCursorPos();
        vec2[0] = vec.x;
        vec2[1] = vec.y;
    */
    public static native void GetCursorPos(float[] vec2);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetCursorPosX();
    */
    public static native float GetCursorPosX();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetCursorPosY();
    */
    public static native float GetCursorPosY();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetCursorPos(ImVec2(x, y));
    */
    public static native void SetCursorPos(float x, float y);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetCursorPosX(x);
    */
    public static native void SetCursorPosX(float x);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetCursorPosY(y);
    */
    public static native void SetCursorPosY(float y);

    /*[-teaVM;-NATIVE]
        var out = ImGui.wrapPointer(vec2Addr, ImGui.ImVec2);
        var nativeObject = ImGui.Im.prototype.GetCursorStartPos();
        out.set_x(nativeObject.get_x());
        out.set_y(nativeObject.get_y());
    */
    /*[-C++;-NATIVE]
        ImVec2 nativeObject = ImGui::GetCursorStartPos();
        ImVec2 * out = (ImVec2*)vec2Addr;
        out->x = nativeObject.x;
        out->y = nativeObject.y;
    */
    public static native void GetCursorStartPos(long vec2Addr);

    /*[-teaVM;-NATIVE]
        var out = ImGui.wrapPointer(vec2Addr, ImGui.ImVec2);
        var nativeObject = ImGui.Im.prototype.GetCursorScreenPos();
        out.set_x(nativeObject.get_x());
        out.set_y(nativeObject.get_y());
    */
    /*[-C++;-NATIVE]
        ImVec2 nativeObject = ImGui::GetCursorScreenPos();
        ImVec2 * out = (ImVec2*)vec2Addr;
        out->x = nativeObject.x;
        out->y = nativeObject.y;
    */
    public static native void GetCursorScreenPos(long vec2Addr);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetCursorScreenPos(ImVec2(x, y));
    */
    public static native void SetCursorScreenPos(float x, float y);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::AlignTextToFramePadding();
    */
    public static native void AlignTextToFramePadding();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetTextLineHeight();
    */
    public static native float GetTextLineHeight();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetTextLineHeightWithSpacing();
    */
    public static native float GetTextLineHeightWithSpacing();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetFrameHeight();
    */
    public static native float GetFrameHeight();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetFrameHeightWithSpacing();
    */
    public static native float GetFrameHeightWithSpacing();

    // ID stack/scopes
    // - Read the FAQ for more details about how ID are handled in dear imgui. If you are creating widgets in a loop you most
    //   likely want to push a unique identifier (e.g. object pointer, loop index) to uniquely differentiate them.
    // - The resulting ID are hashes of the entire stack.
    // - You can also use the "Label##foobar" syntax within widget label to distinguish them from each others.
    // - In this header file we use the "label"/"name" terminology to denote a string that will be displayed and used as an ID,
    //   whereas "str_id" denote a string that is only used as an ID and not normally displayed.

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PushID(str_id);
    */
    public static native void PushID(String str_id);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PushID(str_id_begin, str_id_end);
    */
    public static native void PushID(String str_id_begin, String str_id_end);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PushID(int_id);
    */
    public static native void PushID(int int_id);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::PopID();
    */
    public static native void PopID();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetID(str_id);
    */
    public static native int GetID(String str_id);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetID(str_id_begin, str_id_end);
    */
    public static native int GetID(String str_id_begin, String str_id_end);

    // Widgets: Text

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TextUnformatted(text);
    */
    public static native void TextUnformatted(String text);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TextUnformatted(text, text_end);
    */
    public static native void TextUnformatted(String text, String text_end);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::Text(text);
    */
    public static native void Text(String text);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::Text(text);
    */
    public static native void Text(byte[] text);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TextColored(ImVec4(r, g, b, a), text);
    */
    public static native void TextColored(float r, float g, float b, float a, String text);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TextDisabled(text);
    */
    public static native void TextDisabled(String text);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TextWrapped(text);
    */
    public static native void TextWrapped(String text);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::LabelText(label, text);
    */
    public static native void LabelText(String label, String text);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::BulletText(text);
    */
    public static native void BulletText(String text);

    // Widgets: Main
    // - Most widgets return true when the value has been changed or when pressed/selected

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::Button(label);
    */
    public static native boolean Button(String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::Button(label, ImVec2(width, height));
    */
    public static native boolean Button(String label, float width, float height);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::SmallButton(label);
    */
    public static native boolean SmallButton(String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::InvisibleButton(strId, ImVec2(width, height));
    */
    public static native boolean InvisibleButton(String strId, float width, float height);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::ArrowButton(strId, dir);
    */
    public static native boolean ArrowButton(String strId, int dir);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::Image((ImTextureID)textureID, ImVec2(sizeX, sizeY));
    */
    public static native void Image(int textureID, float sizeX, float sizeY);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::Image((ImTextureID)textureID, ImVec2(sizeX, sizeY), ImVec2(uv0_x, uv0_y), ImVec2(uv1_x, uv1_y));
    */
    public static native void Image(int textureID, float sizeX, float sizeY, float uv0_x, float uv0_y, float uv1_x, float uv1_y);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::Image((ImTextureID)textureID, ImVec2(sizeX, sizeY), ImVec2(uv0_x, uv0_y), ImVec2(uv1_x, uv1_y), ImVec4(tint_color_r, tint_color_g, tint_color_b, tint_color_a), ImVec4(border_col_r, border_col_g, border_col_b, border_col_a));
    */
    public static native void Image(int textureID, float sizeX, float sizeY, float uv0_x, float uv0_y, float uv1_x, float uv1_y, float tint_color_r, float tint_color_g, float tint_color_b, float tint_color_a, float border_col_r, float border_col_g, float border_col_b, float border_col_a);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::ImageButton((ImTextureID)textureID, ImVec2(sizeX, sizeY));
    */
    public static native boolean ImageButton(int textureID, float sizeX, float sizeY);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::ImageButton((ImTextureID)textureID, ImVec2(sizeX, sizeY), ImVec2(uv0_x, uv0_y), ImVec2(uv1_x, uv1_y), frame_padding);
    */
    public static native boolean ImageButton(int textureID, float sizeX, float sizeY, float uv0_x, float uv0_y, float uv1_x, float uv1_y, int frame_padding);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::ImageButton((ImTextureID)textureID, ImVec2(sizeX, sizeY), ImVec2(uv0_x, uv0_y), ImVec2(uv1_x, uv1_y), frame_padding, ImVec4(bg_color_r, bg_color_g, bg_color_b, bg_color_a), ImVec4(tint_col_r, tint_col_g, tint_col_b, tint_col_a));
    */
    public static native boolean ImageButton(int textureID, float sizeX, float sizeY, float uv0_x, float uv0_y, float uv1_x, float uv1_y, int frame_padding, float bg_color_r, float bg_color_g, float bg_color_b, float bg_color_a, float tint_col_r, float tint_col_g, float tint_col_b, float tint_col_a);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.Checkbox(label, dataAddr);
    */
    /*[-C++;-NATIVE]
        bool * data = (bool*)dataAddr;
        bool flag = data[0];
        bool ret = ImGui::Checkbox(label, &flag);
        data[0] = flag;
        return ret;
    */
    public static native boolean Checkbox(String label, long dataAddr);

    //TODO check if its working

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        int * data = (int*)dataAddr;
        return ImGui::CheckboxFlags(label, (unsigned int*)&data[0], flagsValue);
    */
    public static native boolean CheckboxFlags(String label, long dataAddr, int flagsValue);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::RadioButton(label, active);
    */
    public static native boolean RadioButton(String label, boolean active);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        int * data = (int*)dataAddr;
        return ImGui::RadioButton(label, &data[0], v_button);
    */
    public static native boolean RadioButton(String label, long dataAddr, int v_button);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::ProgressBar(fraction);
    */
    public static native void ProgressBar(float fraction);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::ProgressBar(fraction, ImVec2(size_arg_x, size_arg_y));
    */
    public static native void ProgressBar(float fraction, float size_arg_x, float size_arg_y);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::Bullet();
    */
    public static native void Bullet();

    // Widgets: Combo Box
    // - The new BeginCombo()/EndCombo() api allows you to manage your contents and selection state however you want it, by creating e.g. Selectable() items.
    // - The old Combo() api are helpers over BeginCombo()/EndCombo() which are kept available for convenience purpose.

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginCombo(label, preview_value);
    */
    public static native boolean BeginCombo(String label, String preview_value);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginCombo(label, preview_value, flags);
    */
    public static native boolean BeginCombo(String label, String preview_value, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::EndCombo();
    */
    public static native void EndCombo();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        int * current_item = (int*)current_itemAddr;
        const char* listbox_items[items_count];
        for(int i = 0; i < items_count; i++) {
            jstring string = (jstring) (env->GetObjectArrayElement(items, i));
            const char *rawString = env->GetStringUTFChars(string, 0);
            listbox_items[i] = rawString;
        }
        return ImGui::Combo(label, &current_item[0], listbox_items, items_count);
    */
    public static native boolean Combo(String label, long current_itemAddr, String[] items, int items_count);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        int * current_item = (int*)current_itemAddr;
        const char* listbox_items[items_count];
        for(int i = 0; i < items_count; i++) {
            jstring string = (jstring) (env->GetObjectArrayElement(items, i));
            const char *rawString = env->GetStringUTFChars(string, 0);
            listbox_items[i] = rawString;
        }
        return ImGui::Combo(label, &current_item[0], listbox_items, items_count, popup_max_height_in_items);
    */
    public static native boolean Combo(String label, long current_itemAddr, String[] items, int items_count, int popup_max_height_in_items);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        int * current_item = (int*)current_itemAddr;
        return ImGui::Combo(label, &current_item[0], items_separated_by_zeros);
    */
    public static native boolean Combo(String label, long current_itemAddr, String items_separated_by_zeros);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        int * current_item = (int*)current_itemAddr;
        return ImGui::Combo(label, &current_item[0], items_separated_by_zeros, popup_max_height_in_items);
    */
    public static native boolean Combo(String label, long current_itemAddr, String items_separated_by_zeros, int popup_max_height_in_items);

    // Widgets: Trees
    // - TreeNode functions return true when the node is open, in which case you need to also call TreePop() when you are finished displaying the tree node contents.

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::TreeNode(label);
    */
    public static native boolean TreeNode(String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::TreeNode(str_id, label);
    */
    public static native boolean TreeNode(String str_id, String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::TreeNode((void*)(intptr_t)ptr_id, label);
    */
    public static native boolean TreeNode(int ptr_id, String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::TreeNodeEx(label);
    */
    public static native boolean TreeNodeEx(String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::TreeNodeEx(label, flags);
    */
    public static native boolean TreeNodeEx(String label, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::TreeNodeEx(str_id, flags, label);
    */
    public static native boolean TreeNodeEx(String str_id, int flags, String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::TreeNodeEx((void*)(intptr_t)ptr_id, flags, label);
    */
    public static native boolean TreeNodeEx(int ptr_id, int flags, String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TreePush(str_id);
    */
    public static native void TreePush(String str_id);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TreePush((void*)(intptr_t)ptr_id);
    */
    public static native void TreePush(int ptr_id);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TreePop();
    */
    public static native void TreePop();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetTreeNodeToLabelSpacing();
    */
    public static native float GetTreeNodeToLabelSpacing();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::CollapsingHeader(label);
    */
    public static native boolean CollapsingHeader(String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::CollapsingHeader(label, flags);
    */
    public static native boolean CollapsingHeader(String label, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        bool * p_open = (bool*)p_openAddr;
        bool flag = p_open[0];
        bool ret = ImGui::CollapsingHeader(label, &flag);
        p_open[0] = flag;
        return ret;
    */
    public static native boolean CollapsingHeader(long p_openAddr, String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        bool * p_open = (bool*)p_openAddr;
        bool flag = p_open[0];
        bool ret = ImGui::CollapsingHeader(label, &flag, flags);
        p_open[0] = flag;
        return ret;
    */
    public static native boolean CollapsingHeader(String label, long p_openAddr, int flags);

    // Widgets: Selectables
    // - A selectable highlights when hovered, and can display another color when selected.
    // - Neighbors selectable extend their highlight bounds in order to leave no gap between them.

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::Selectable(label);
    */
    public static native boolean Selectable(String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::Selectable(label, selected);
    */
    public static native boolean Selectable(String label, boolean selected);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::Selectable(label, selected, flags, ImVec2(sizeX, sizeY));
    */
    public static native boolean Selectable(String label, boolean selected, int flags, float sizeX, float sizeY);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        bool * selected = (bool*)selectedAddr;
        bool flag = selected[0];
        bool ret = ImGui::Selectable(label, &flag);
        selected[0] = flag;
        return ret;
    */
    public static native boolean Selectable(String label, long selectedAddr);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        bool * selected = (bool*)selectedAddr;
        bool flag = selected[0];
        bool ret = ImGui::Selectable(label,  &flag, flags, ImVec2(sizeX, sizeY));
        selected[0] = flag;
        return ret;
    */
    public static native boolean Selectable(String label, long selectedAddr, int flags, float sizeX, float sizeY);

    // Widgets: List Boxes
    // - FIXME: To be consistent with all the newer API, ListBoxHeader/ListBoxFooter should in reality be called BeginListBox/EndListBox. Will rename them.

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        int * current_item = (int*)current_item;
        const char* listbox_items[items_count];
        for(int i = 0; i < items_count; i++) {
            jstring string = (jstring) (env->GetObjectArrayElement(items, i));
            const char *rawString = env->GetStringUTFChars(string, 0);
            listbox_items[i] = rawString;
        }
        return ImGui::ListBox(label, &current_item[0], listbox_items, items_count);
    */
    public static native boolean ListBox(String label, long current_itemAddr, String[] items, int items_count);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::ListBoxHeader(label);
    */
    public static native boolean ListBoxHeader(String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::ListBoxHeader(label, ImVec2(sizeX, sizeY));
    */
    public static native boolean ListBoxHeader(String label, float sizeX, float sizeY);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::ListBoxHeader(label, items_count);
    */
    public static native boolean ListBoxHeader(String label, int items_count);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::ListBoxHeader(label, items_count, height_in_items);
    */
    public static native boolean ListBoxHeader(String label, int items_count, int height_in_items);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::ListBoxFooter();
    */
    public static native void ListBoxFooter();

    // Widgets: Menus

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginMainMenuBar();
    */
    public static native boolean BeginMainMenuBar();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::EndMainMenuBar();
    */
    public static native void EndMainMenuBar();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginMenuBar();
    */
    public static native boolean BeginMenuBar();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::EndMenuBar();
    */
    public static native void EndMenuBar();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginMenu(label);
    */
    public static native boolean BeginMenu(String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginMenu(label, enabled);
    */
    public static native boolean BeginMenu(String label, boolean enabled);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::EndMenu();
    */
    public static native void EndMenu();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::MenuItem(label);
    */
    public static native boolean MenuItem(String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::MenuItem(label, NULL, selected);
    */
    public static native boolean MenuItem(String label, boolean selected);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::MenuItem(label, NULL, selected, enabled);
    */
    public static native boolean MenuItem(String label, boolean selected, boolean enabled);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::MenuItem(label, shortcut, selected);
    */
    public static native boolean MenuItem(String label, String shortcut, boolean selected);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::MenuItem(label, shortcut, selected, enabled);
    */
    public static native boolean MenuItem(String label, String shortcut, boolean selected, boolean enabled);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        bool * p_selected = (bool*)selectedAddr;
        bool flag = p_selected[0];
        bool ret = ImGui::MenuItem(label, shortcut, &flag);
        p_selected[0] = flag;
        return ret;
    */
    public static native boolean MenuItem(String label, String shortcut, long selectedAddr);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        bool * p_selected = (bool*)p_selectedAddr;
        bool flag = p_selected[0];
        bool ret = ImGui::MenuItem(label, shortcut, &flag, enabled);
        p_selected[0] = flag;
        return ret;
    */
    public static native boolean MenuItem(String label, String shortcut, long p_selectedAddr, boolean enabled);

    // Tooltips

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::BeginTooltip();
    */
    public static native void BeginTooltip();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::EndTooltip();
    */
    public static native void EndTooltip();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetTooltip(text);
    */
    public static native void SetTooltip(String text);

    // Popups, Modals
    // The properties of popups windows are:
    // - They block normal mouse hovering detection outside them. (*)
    // - Unless modal, they can be closed by clicking anywhere outside them, or by pressing ESCAPE.
    // - Their visibility state (~bool) is held internally by imgui instead of being held by the programmer as we are used to with regular Begin() calls.
    //   User can manipulate the visibility state by calling OpenPopup().
    // (*) One can use IsItemHovered(ImGuiHoveredFlags_AllowWhenBlockedByPopup) to bypass it and detect hovering even when normally blocked by a popup.
    // Those three properties are connected. The library needs to hold their visibility state because it can close popups at any time.

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::OpenPopup(str_id);
    */
    public static native void OpenPopup(String str_id);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopup(str_id);
    */
    public static native boolean BeginPopup(String str_id);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopup(str_id, flags);
    */
    public static native boolean BeginPopup(String str_id, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupContextItem();
    */
    public static native boolean BeginPopupContextItem();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupContextItem(str_id, mouse_button);
    */
    public static native boolean BeginPopupContextItem(String str_id, int mouse_button);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupContextWindow();
    */
    public static native boolean BeginPopupContextWindow();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupContextWindow(str_id, flags);
    */
    public static native boolean BeginPopupContextWindow(String str_id, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupContextVoid();
    */
    public static native boolean BeginPopupContextVoid();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupContextVoid(str_id, mouse_button);
    */
    public static native boolean BeginPopupContextVoid(String str_id, int mouse_button);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupModal(name);
    */
    public static native boolean BeginPopupModal(String name);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupModal(name, NULL, flags);
    */
    public static native boolean BeginPopupModal(String name, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        bool * p_open = (bool*)p_openAddr;
        bool flag = p_open[0];
        bool ret = ImGui::BeginPopupModal(name, &flag, flags);
        p_open[0] = flag;
        return ret;
    */
    public static native boolean BeginPopupModal(String name, long p_openAddr, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::EndPopup();
    */
    public static native void EndPopup();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::OpenPopupOnItemClick();
    */
    public static native void OpenPopupOnItemClick();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::OpenPopupOnItemClick(str_id, mouse_button);
    */
    public static native void OpenPopupOnItemClick(String str_id, int mouse_button);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsPopupOpen(str_id);
    */
    public static native boolean IsPopupOpen(String str_id);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::CloseCurrentPopup();
    */
    public static native void CloseCurrentPopup();

    // Tables

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTable(id, columns_count);
    */
    public static native boolean BeginTable(String id, int columns_count);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTable(id, columns_count, flags);
    */
    public static native boolean BeginTable(String id, int columns_count, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTable(id, columns_count, flags, ImVec2(outer_sizeX, outer_sizeY));
    */
    public static native boolean BeginTable(String id, int columns_count, int flags, float outer_sizeX, float outer_sizeY);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTable(id, columns_count, flags, ImVec2(outer_sizeX, outer_sizeY), inner_width);
    */
    public static native boolean BeginTable(String id, int columns_count, int flags, float outer_sizeX, float outer_sizeY, float inner_width);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTable(id, columns_count);
    */
    public static native boolean BeginTable(byte[] id, int columns_count);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTable(id, columns_count, flags);
    */
    public static native boolean BeginTable(byte[] id, int columns_count, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTable(id, columns_count, flags, ImVec2(outer_sizeX, outer_sizeY));
    */
    public static native boolean BeginTable(byte[] id, int columns_count, int flags, float outer_sizeX, float outer_sizeY);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTable(id, columns_count, flags, ImVec2(outer_sizeX, outer_sizeY), inner_width);
    */
    public static native boolean BeginTable(byte[] id, int columns_count, int flags, float outer_sizeX, float outer_sizeY, float inner_width);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::EndTable();
    */
    public static native void EndTable();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TableNextRow();
    */
    public static native void TableNextRow();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TableNextRow(row_flags);
    */
    public static native void TableNextRow(int row_flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TableNextRow(row_flags, min_row_height);
    */
    public static native void TableNextRow(int row_flags, float min_row_height);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::TableNextColumn();
    */
    public static native boolean TableNextColumn();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::TableSetColumnIndex(column_n);
    */
    public static native boolean TableSetColumnIndex(int column_n);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::TableGetColumnIndex();
    */
    public static native int TableGetColumnIndex();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::TableGetRowIndex();
    */
    public static native int TableGetRowIndex();

    // Tables: Headers & Columns declaration

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TableSetupColumn(label);
    */
    public static native void TableSetupColumn(String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TableSetupColumn(label, flags);
    */
    public static native void TableSetupColumn(String label, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TableSetupColumn(label, flags);
    */
    public static native void TableSetupColumn(byte[] label, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TableSetupColumn(label, flags, init_width_or_weight);
    */
    public static native void TableSetupColumn(String label, int flags, float init_width_or_weight);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TableSetupColumn(label, flags, init_width_or_weight, user_id);
    */
    public static native void TableSetupColumn(String label, int flags, float init_width_or_weight, int user_id);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TableHeadersRow();
    */
    public static native void TableHeadersRow();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::TableHeader(label);
    */
    public static native void TableHeader(String label);

    // Tables: Miscellaneous functions

//TODO Fix return string
//	public static native char[] TableGetColumnName(); /*[-C++;-NATIVE]
//		return ImGui::TableGetColumnName();
//	*/

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::TableGetColumnCount();
    */
    public static native int TableGetColumnCount();

    // Tab Bars, Tabs
    // [BETA API] API may evolve!

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTabBar(str_id);
    */
    public static native boolean BeginTabBar(String str_id);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTabBar(str_id, flags);
    */
    public static native boolean BeginTabBar(String str_id, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        ImGui::EndTabBar();
    */
    public static native void EndTabBar();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTabItem(label);
    */
    public static native boolean BeginTabItem(String label);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        bool * p_open = (bool*)p_openAddr;
        bool flag = p_open[0];
        bool ret = ImGui::BeginTabItem(label, &flag, flags);
        p_open[0] = flag;
        return ret;
    */
    public static native boolean BeginTabItem(String label, long p_openAddr, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::EndTabItem();
    */
    public static native void EndTabItem();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetTabItemClosed(tab_or_docked_window_label);
    */
    public static native void SetTabItemClosed(String tab_or_docked_window_label);

    // Docking
    // [BETA API] Enable with io.ConfigFlags |= ImGuiConfigFlags_DockingEnable.
    // Note: you DO NOT need to call DockSpace() to use most Docking facilities!
    // To dock windows: if io.ConfigDockingWithShift == false: drag window from their title bar.
    // To dock windows: if io.ConfigDockingWithShift == true: hold SHIFT anywhere while moving windows.
    // Use DockSpace() to create an explicit dock node _within_ an existing window. See Docking demo for details.

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::DockSpace(id);
    */
    public static native int DockSpace(int id);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::DockSpace(id, ImVec2(sizeX, sizeY));
    */
    public static native int DockSpace(int id, float sizeX, float sizeY);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::DockSpace(id, ImVec2(sizeX, sizeY), flags);
    */
    public static native int DockSpace(int id, float sizeX, float sizeY, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::DockSpaceOverViewport();
    */
    public static native int DockSpaceOverViewport();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        ImGuiViewport * viewport = (ImGuiViewport*)viewportAddr;
        return ImGui::DockSpaceOverViewport(viewport, flags);
    */
    public static native int DockSpaceOverViewport(long viewportAddr, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowDockID(dock_id, cond);
    */
    public static native void SetNextWindowDockID(int dock_id, int cond);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetWindowDockID();
    */
    public static native int GetWindowDockID();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsWindowDocked();
    */
    public static native boolean IsWindowDocked();

    // Drag and Drop

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginDragDropSource(flags);
    */
    public static native boolean BeginDragDropSource(int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        char myByte = 0;
        return ImGui::SetDragDropPayload(type, &myByte, 1);
    */
    public static native boolean SetDragDropPayload(String type);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::EndDragDropSource();
    */
    public static native void EndDragDropSource();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginDragDropTarget();
    */
    public static native boolean BeginDragDropTarget();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::AcceptDragDropPayload(type, flags) != NULL;
    */
    public static native boolean AcceptDragDropPayload(String type, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::EndDragDropTarget();
    */
    public static native void EndDragDropTarget();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetDragDropPayload()->Data != NULL;
    */
    public static native boolean HasDragDropPayloadData();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::BeginDisabled(disabled);
    */
    public static native void BeginDisabled(boolean disabled);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::EndDisabled();
    */
    public static native void EndDisabled();

    // Focus, Activation
    // - Prefer using "SetItemDefaultFocus()" over "if (IsWindowAppearing()) SetScrollHereY()" when applicable to signify "this is the default item"

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetItemDefaultFocus();
    */
    public static native void SetItemDefaultFocus();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetKeyboardFocusHere();
    */
    public static native void SetKeyboardFocusHere();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetKeyboardFocusHere(offset);
    */
    public static native void SetKeyboardFocusHere(int offset);

    // Item/Widgets Utilities
    // - Most of the functions are referring to the last/previous item we submitted.
    // - See Demo Window under "Widgets->Querying Status" for an interactive visualization of most of those functions.

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemHovered();
    */
    public static native boolean IsItemHovered();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemHovered(flags);
    */
    public static native boolean IsItemHovered(int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemActive();
    */
    public static native boolean IsItemActive();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemFocused();
    */
    public static native boolean IsItemFocused();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemClicked();
    */
    public static native boolean IsItemClicked();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemClicked(mouse_button);
    */
    public static native boolean IsItemClicked(int mouse_button);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemVisible();
    */
    public static native boolean IsItemVisible();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemEdited();
    */
    public static native boolean IsItemEdited();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemActivated();
    */
    public static native boolean IsItemActivated();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemDeactivated();
    */
    public static native boolean IsItemDeactivated();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemDeactivatedAfterEdit();
    */
    public static native boolean IsItemDeactivatedAfterEdit();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsAnyItemHovered();
    */
    public static native boolean IsAnyItemHovered();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsAnyItemActive();
    */
    public static native boolean IsAnyItemActive();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsAnyItemFocused();
    */
    public static native boolean IsAnyItemFocused();

    /*[-teaVM;-NATIVE]
        var out = ImGui.wrapPointer(vec2Addr, ImGui.ImVec2);
        var nativeObject = ImGui.Im.prototype.GetItemRectMin();
        out.set_x(nativeObject.get_x());
        out.set_y(nativeObject.get_y());
    */
    /*[-C++;-NATIVE]
        ImVec2 nativeObject = ImGui::GetItemRectMin();
        ImVec2 * out = (ImVec2*)vec2Addr;
        out->x = nativeObject.x;
        out->y = nativeObject.y;
    */
    public static native void GetItemRectMin(long vec2Addr);

    /*[-teaVM;-NATIVE]
        var out = ImGui.wrapPointer(vec2Addr, ImGui.ImVec2);
        var nativeObject = ImGui.Im.prototype.GetItemRectMax();
        out.set_x(nativeObject.get_x());
        out.set_y(nativeObject.get_y());
    */
    /*[-C++;-NATIVE]
        ImVec2 nativeObject = ImGui::GetItemRectMax();
        ImVec2 * out = (ImVec2*)vec2Addr;
        out->x = nativeObject.x;
        out->y = nativeObject.y;
    */
    public static native void GetItemRectMax(long vec2Addr);

    /*[-teaVM;-NATIVE]
        var out = ImGui.wrapPointer(vec2Addr, ImGui.ImVec2);
        var nativeObject = ImGui.Im.prototype.GetItemRectSize();
        out.set_x(nativeObject.get_x());
        out.set_y(nativeObject.get_y());
    */
    /*[-C++;-NATIVE]
        ImVec2 nativeObject = ImGui::GetItemRectSize();
        ImVec2 * out = (ImVec2*)vec2Addr;
        out->x = nativeObject.x;
        out->y = nativeObject.y;
    */
    public static native void GetItemRectSize(long vec2Addr);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::SetItemAllowOverlap();
    */
    public static native void SetItemAllowOverlap();

    // Viewports
    // - Currently represents the Platform Window created by the application which is hosting our Dear ImGui windows.
    // - In 'docking' branch with multi-viewport enabled, we extend this concept to have multiple active viewports.
    // - In the future we will extend this concept further to also represent Platform Monitor and support a "no main platform window" operation mode.

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* viewport = ImGui::GetMainViewport();
        return (jlong)viewport;
    */
    public static native long GetMainViewport(boolean updateDrawData);

    // Miscellaneous Utilities

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        return ImGui::GetFrameCount();
    */
    public static native int GetFrameCount();

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginChildFrame(id, ImVec2(width, height));
    */
    public static native boolean BeginChildFrame(int id, float width, float height);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginChildFrame(id, ImVec2(width, height), flags);
    */
    public static native boolean BeginChildFrame(int id, float width, float height, int flags);

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::EndChildFrame();
    */
    public static native void EndChildFrame();

    // Inputs Utilities

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsMouseDown(button);
    */
    public static native boolean IsMouseDown(int button);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsMouseClicked(button);
    */
    public static native boolean IsMouseClicked(int button);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        bool flag = repeat;
        return ImGui::IsMouseClicked(button, flag);
    */
    public static native boolean IsMouseClicked(int button, boolean repeat);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsMouseReleased(button);
    */
    public static native boolean IsMouseReleased(int button);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsMouseDragging(button);
    */
    public static native boolean IsMouseDragging(int button);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsMouseDragging(button, lock_threshold);
    */
    public static native boolean IsMouseDragging(int button, float lock_threshold);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsMouseHoveringRect(ImVec2(minX, minY), ImVec2(maxX, maxY));
    */
    public static native boolean IsMouseHoveringRect(float minX, float minY, float maxX, float maxY);

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::IsMouseHoveringRect(ImVec2(minX, minY), ImVec2(maxX, maxY), clip);
    */
    public static native boolean IsMouseHoveringRect(float minX, float minY, float maxX, float maxY, boolean clip);

    // (Optional) Platform/OS interface for multi-viewport support

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::UpdatePlatformWindows();
    */
    public static native void UpdatePlatformWindows();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::RenderPlatformWindowsDefault();
    */
    public static native void RenderPlatformWindowsDefault();

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGui::DestroyPlatformWindows();
    */
    public static native void DestroyPlatformWindows();

    // Custom search because handle is int64 pointer.

    /*[-teaVM;-NATIVE]
        var test = 0;
        return 0;
    */
    /*[-C++;-NATIVE]
        int64_t handle = platformHandle;
        ImGuiContext& g = *GImGui;
        for (int i = 0; i != g.Viewports.Size; i++) {
            ImGuiViewport* viewport = g.Viewports[i];
            if(viewport->PlatformHandle != NULL) {
                int64_t viewportHandle = *(int64_t*)viewport->PlatformHandle;
                if (viewportHandle == handle) {
                    return (jlong)viewport;
                }
            }
        }
        return 0;
    */
    public static native long FindViewportByPlatformHandle(long platformHandle, boolean updateDrawData);

    // ImGuiIO setters

    /*[-teaVM;-NATIVE]
        var test = 0;
    */
    /*[-C++;-NATIVE]
        ImGuiIO& io = ImGui::GetIO();
        io.FontGlobalScale = scale;
    */
    public static native void SetFontGlobalScale(float scale);

    private ImGuiNative() {
    }
}
