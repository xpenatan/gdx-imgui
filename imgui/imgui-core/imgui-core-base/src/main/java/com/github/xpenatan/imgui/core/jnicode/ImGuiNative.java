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
        ImGui.Im.prototype.DestroyContext();
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
        ImGui.Im.prototype.ShowStyleEditor();
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
        ImGui.Im.prototype.ShowMetricsWindow();
    */
    /*[-C++;-NATIVE]
        ImGui::ShowMetricsWindow();
    */
    public static native void ShowMetricsWindow();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.ShowMetricsWindow(open);
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
        ImGui.Im.prototype.StyleColorsDark();
    */
    /*[-C++;-NATIVE]
        ImGui::StyleColorsDark();
    */
    public static native void StyleColorsDark();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.StyleColorsClassic();
    */
    /*[-C++;-NATIVE]
        ImGui::StyleColorsClassic();
    */
    public static native void StyleColorsClassic();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.StyleColorsLight();
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
        return ImGui.Im.prototype.BeginChild(str_id);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginChild(str_id);
    */
    public static native boolean BeginChild(String str_id);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginChild(str_id, sizeAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::BeginChild(str_id, *size);
    */
    public static native boolean BeginChild(String str_id, long sizeAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginChild(str_id, sizeAddr, border);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::BeginChild(str_id, *size, border);
    */
    public static native boolean BeginChild(String str_id, long sizeAddr, boolean border);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginChild(str_id, sizeAddr, border, flags);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::BeginChild(str_id, *size, border, flags);
    */
    public static native boolean BeginChild(String str_id, long sizeAddr, boolean border, int flags);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginChild2(imGuiID);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginChild(imGuiID);
    */
    public static native boolean BeginChild(int imGuiID);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginChild2(imGuiID, sizeAddr, border);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::BeginChild(imGuiID, *size, border);
    */
    public static native boolean BeginChild(int imGuiID, long sizeAddr, boolean border);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginChild2(imGuiID, sizeAddr, border, flags);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::BeginChild(imGuiID, *size, border, flags);
    */
    public static native boolean BeginChild(int imGuiID, long sizeAddr, boolean border, int flags);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.EndChild();
    */
    /*[-C++;-NATIVE]
        ImGui::EndChild();
    */
    public static native void EndChild();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsWindowAppearing();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsWindowAppearing();
    */
    public static native boolean IsWindowAppearing();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsWindowCollapsed();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsWindowCollapsed();
    */
    public static native boolean IsWindowCollapsed();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsWindowFocused();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsWindowFocused();
    */
    public static native boolean IsWindowFocused();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsWindowFocused(flags);
    */
    /*[-C++;-NATIVE]
        return ImGui::IsWindowFocused(flags);
    */
    public static native boolean IsWindowFocused(int flags);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsWindowHovered();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsWindowHovered();
    */
    public static native boolean IsWindowHovered();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsWindowHovered(flags);
    */
    /*[-C++;-NATIVE]
        return ImGui::IsWindowHovered(flags);
    */
    public static native boolean IsWindowHovered(int flags);

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
        return ImGui.Im.prototype.GetWindowWidth();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetWindowWidth();
    */
    public static native float GetWindowWidth();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetWindowHeight();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetWindowHeight();
    */
    public static native float GetWindowHeight();

    /*[-teaVM;-NATIVE]
        var viewport = ImGui.Im.prototype.GetWindowViewport();
        return ImGui.getPointer(viewport);
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* viewport = ImGui::GetWindowViewport();
        return (jlong)viewport;
    */
    public static native long GetWindowViewport();

    // Prefer using SetNextXXX functions (before Begin) rather that SetXXX functions (after Begin).

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetNextWindowPos(posAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * pos = (ImVec2*)posAddr;
        ImGui::SetNextWindowPos(*pos);
    */
    public static native void SetNextWindowPos(long posAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetNextWindowPos(posAddr, cond);
    */
    /*[-C++;-NATIVE]
        ImVec2 * pos = (ImVec2*)posAddr;
        ImGui::SetNextWindowPos(*pos, cond);
    */
    public static native void SetNextWindowPos(long posAddr, int cond);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetNextWindowPos(posAddr, cond, pivotAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * pos = (ImVec2*)posAddr;
        ImVec2 * pivot = (ImVec2*)pivotAddr;
        ImGui::SetNextWindowPos(*pos, cond, *pivot);
    */
    public static native void SetNextWindowPos(long posAddr, int cond, long pivotAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetNextWindowSize(sizeAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        ImGui::SetNextWindowSize(*size);
    */
    public static native void SetNextWindowSize(long sizeAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetNextWindowSize(sizeAddr, cond);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        ImGui::SetNextWindowSize(*size, cond);
    */
    public static native void SetNextWindowSize(long sizeAddr, int cond);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetNextWindowSizeConstraints(minSizeAddr, maxSizeAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * minSize = (ImVec2*)minSizeAddr;
        ImVec2 * maxSize = (ImVec2*)maxSizeAddr;
        ImGui::SetNextWindowSizeConstraints(*minSize, *maxSize);
    */
    public static native void SetNextWindowSizeConstraints(long minSizeAddr, long maxSizeAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetNextWindowContentSize(sizeAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        ImGui::SetNextWindowContentSize(*size);
    */
    public static native void SetNextWindowContentSize(long sizeAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetNextWindowCollapsed(collapsed);
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowCollapsed(collapsed);
    */
    public static native void SetNextWindowCollapsed(boolean collapsed);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetNextWindowCollapsed(collapsed, cond);
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowCollapsed(collapsed, cond);
    */
    public static native void SetNextWindowCollapsed(boolean collapsed, int cond);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetNextWindowFocus();
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowFocus();
    */
    public static native void SetNextWindowFocus();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetNextWindowBgAlpha(alpha);
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowBgAlpha(alpha);
    */
    public static native void SetNextWindowBgAlpha(float alpha);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetWindowPos(posAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * pos = (ImVec2*)posAddr;
        ImGui::SetWindowPos(*pos);
    */
    public static native void SetWindowPos(long posAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetWindowPos(posAddr, cond);
    */
    /*[-C++;-NATIVE]
        ImVec2 * pos = (ImVec2*)posAddr;
        ImGui::SetWindowPos(*pos, cond);
    */
    public static native void SetWindowPos(long posAddr, int cond);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetWindowSize(sizeAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        ImGui::SetWindowSize(*size);
    */
    public static native void SetWindowSize(long sizeAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetWindowSize(sizeAddr, cond);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        ImGui::SetWindowSize(*size, cond);
    */
    public static native void SetWindowSize(long sizeAddr, int cond);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetWindowCollapsed(collapsed, cond);
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowCollapsed(collapsed, cond);
    */
    public static native void SetWindowCollapsed(boolean collapsed, int cond);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetWindowFocus();
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowFocus();
    */
    public static native void SetWindowFocus();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetWindowFontScale(scale);
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowFontScale(scale);
    */
    public static native void SetWindowFocus(float scale);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetWindowPos(name, posAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * pos = (ImVec2*)posAddr;
        ImGui::SetWindowPos(name, *pos);
    */
    public static native void SetWindowPos(String name, long posAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetWindowPos(name, posAddr, cond);
    */
    /*[-C++;-NATIVE]
        ImVec2 * pos = (ImVec2*)posAddr;
        ImGui::SetWindowPos(name, *pos, cond);
    */
    public static native void SetWindowPos(String name, long posAddr, int cond);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetWindowCollapsed(name, collapsed);
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowCollapsed(name, collapsed);
    */
    public static native void SetWindowCollapsed(String name, boolean collapsed);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetWindowCollapsed(name, collapsed, cond);
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowCollapsed(name, collapsed, cond);
    */
    public static native void SetWindowCollapsed(String name, boolean collapsed, int cond);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetWindowFocus2(name);
    */
    /*[-C++;-NATIVE]
        ImGui::SetWindowFocus(name);
    */
    public static native void SetWindowFocus(String name);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetWindowFocus2(null);
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
        return ImGui.Im.prototype.GetWindowContentRegionWidth();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetWindowContentRegionWidth();
    */
    public static native float GetWindowContentRegionWidth();

    // Windows Scrolling

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetScrollX();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetScrollX();
    */
    public static native float GetScrollX();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetScrollY();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetScrollY();
    */
    public static native float GetScrollY();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetScrollMaxX();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetScrollMaxX();
    */
    public static native float GetScrollMaxX();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetScrollMaxY();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetScrollMaxY();
    */
    public static native float GetScrollMaxY();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetScrollX(scroll_x);
    */
    /*[-C++;-NATIVE]
        ImGui::SetScrollX(scroll_x);
    */
    public static native void SetScrollX(float scroll_x);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetScrollY(scroll_y);
    */
    /*[-C++;-NATIVE]
        ImGui::SetScrollY(scroll_y);
    */
    public static native void SetScrollY(float scroll_y);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetScrollFromPosX(local_x);
    */
    /*[-C++;-NATIVE]
        ImGui::SetScrollFromPosX(local_x);
    */
    public static native void SetScrollFromPosX(float local_x);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetScrollFromPosX(local_x, center_x_ratio);
    */
    /*[-C++;-NATIVE]
        ImGui::SetScrollFromPosX(local_x, center_x_ratio);
    */
    public static native void SetScrollFromPosX(float local_x, float center_x_ratio);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetScrollFromPosY(local_y);
    */
    /*[-C++;-NATIVE]
        ImGui::SetScrollFromPosY(local_y);
    */
    public static native void SetScrollFromPosY(float local_y);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetScrollFromPosY(local_y, center_y_ratio);
    */
    /*[-C++;-NATIVE]
        ImGui::SetScrollFromPosY(local_y, center_y_ratio);
    */
    public static native void SetScrollFromPosY(float local_y, float center_y_ratio);

    // Parameters stacks (shared)

    //TODO impl

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PushFont(fontAddr);
    */
    /*[-C++;-NATIVE]
        ImFont * font = (ImFont*)fontAddr;
        ImGui::PushFont(font);
    */
    public static native void PushFont(long fontAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PopFont();
    */
    /*[-C++;-NATIVE]
        ImGui::PopFont();
    */
    public static native void PopFont();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PushStyleColor(idx, col);
    */
    /*[-C++;-NATIVE]
        ImGui::PushStyleColor(idx, col);
    */
    public static native void PushStyleColor(int idx, int col);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PushStyleColor2(idx, colorAddr);
    */
    /*[-C++;-NATIVE]
        ImVec4 * color = (ImVec4*)colorAddr;
        ImGui::PushStyleColor(idx, *color);
    */
    public static native void PushStyleColor(int idx, long colorAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PopStyleColor();
    */
    /*[-C++;-NATIVE]
        ImGui::PopStyleColor();
    */
    public static native void PopStyleColor();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PopStyleColor(count);
    */
    /*[-C++;-NATIVE]
        ImGui::PopStyleColor(count);
    */
    public static native void PopStyleColor(int count);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PushStyleVar(idx, val);
    */
    /*[-C++;-NATIVE]
        ImGui::PushStyleVar(idx, val);
    */
    public static native void PushStyleVar(int idx, float val);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PushStyleVar2(idx, valAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * val = (ImVec2*)valAddr;
        ImGui::PushStyleVar(idx, *val);
    */
    public static native void PushStyleVar(int idx, long valAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PopStyleVar();
    */
    /*[-C++;-NATIVE]
        ImGui::PopStyleVar();
    */
    public static native void PopStyleVar();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PopStyleVar(count);
    */
    /*[-C++;-NATIVE]
        ImGui::PopStyleVar(count);
    */
    public static native void PopStyleVar(int count);

    /*[-teaVM;-NATIVE]
        var colorVec4 = ImGui.Im.prototype.GetStyleColorVec4(idx);
        return ImGui.getPointer(colorVec4);
    */
    /*[-C++;-NATIVE]
        ImVec4 val = ImGui::GetStyleColorVec4(idx);
        return (jlong)&val;
    */
    public static native long GetStyleColorVec4(int idx);

    //TODO impl

    /*[-teaVM;-NATIVE]
        var font = ImGui.Im.prototype.GetFont();
        return ImGui.getPointer(font);
    */
    /*[-C++;-NATIVE]
        ImFont * font = ImGui::GetFont();
        return (jlong)font;
    */
    public static native long GetFont();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetFontSize();
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
        return ImGui.Im.prototype.GetColorU32(idx);
    */
    /*[-C++;-NATIVE]
        return ImGui::GetColorU32((ImGuiCol)idx);
    */
    public static native int GetColorU32(int idx);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetColorU32(idx, alpha_mul);
    */
    /*[-C++;-NATIVE]
        return ImGui::GetColorU32(idx, alpha_mul);
    */
    public static native int GetColorU32(int idx, float alpha_mul);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetColorU322(colorAddr);
    */
    /*[-C++;-NATIVE]
        ImVec4 * color = (ImVec4*)colorAddr;
        return ImGui::GetColorU32(*color);
    */
    public static native int GetColorU32(long colorAddr);

    // Parameters stacks (current window)

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PushItemWidth(item_width);
    */
    /*[-C++;-NATIVE]
        ImGui::PushItemWidth(item_width);
    */
    public static native void PushItemWidth(float item_width);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PopItemWidth();
    */
    /*[-C++;-NATIVE]
        ImGui::PopItemWidth();
    */
    public static native void PopItemWidth();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetNextItemWidth(item_width);
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextItemWidth(item_width);
    */
    public static native void SetNextItemWidth(float item_width);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.CalcItemWidth();
    */
    /*[-C++;-NATIVE]
        return ImGui::CalcItemWidth();
    */
    public static native float CalcItemWidth();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PushTextWrapPos(wrap_local_pos_x);
    */
    /*[-C++;-NATIVE]
        ImGui::PushTextWrapPos(wrap_local_pos_x);
    */
    public static native void PushTextWrapPos(float wrap_local_pos_x);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PushTextWrapPos();
    */
    /*[-C++;-NATIVE]
        ImGui::PushTextWrapPos();
    */
    public static native void PushTextWrapPos();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PopTextWrapPos();
    */
    /*[-C++;-NATIVE]
        ImGui::PopTextWrapPos();
    */
    public static native void PopTextWrapPos();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PushAllowKeyboardFocus(allow_keyboard_focus);
    */
    /*[-C++;-NATIVE]
        ImGui::PushAllowKeyboardFocus(allow_keyboard_focus);
    */
    public static native void PushAllowKeyboardFocus(boolean allow_keyboard_focus);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PopAllowKeyboardFocus();
    */
    /*[-C++;-NATIVE]
        ImGui::PopAllowKeyboardFocus();
    */
    public static native void PopAllowKeyboardFocus();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PushButtonRepeat(repeat);
    */
    /*[-C++;-NATIVE]
        ImGui::PushButtonRepeat(repeat);
    */
    public static native void PushButtonRepeat(boolean repeat);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PopButtonRepeat();
    */
    /*[-C++;-NATIVE]
        ImGui::PopButtonRepeat();
    */
    public static native void PopButtonRepeat();

    // Cursor / Layout
    // - By "cursor" we mean the current output position.
    // - The typical widget behavior is to output themselves at the current cursor position, then move the cursor one line down.

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.Separator();
    */
    /*[-C++;-NATIVE]
        ImGui::Separator();
    */
    public static native void Separator();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SameLine();
    */
    /*[-C++;-NATIVE]
        ImGui::SameLine();
    */
    public static native void SameLine();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SameLine(offsetFromStartX);
    */
    /*[-C++;-NATIVE]
        ImGui::SameLine(offsetFromStartX);
    */
    public static native void SameLine(float offsetFromStartX);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SameLine(offsetFromStartX, spacing);
    */
    /*[-C++;-NATIVE]
        ImGui::SameLine(offsetFromStartX, spacing);
    */
    public static native void SameLine(float offsetFromStartX, float spacing);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.NewLine();
    */
    /*[-C++;-NATIVE]
        ImGui::NewLine();
    */
    public static native void NewLine();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.Spacing();
    */
    /*[-C++;-NATIVE]
        ImGui::Spacing();
    */
    public static native void Spacing();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.Dummy(sizeAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        ImGui::Dummy(*size);
    */
    public static native void Dummy(long sizeAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.Indent();
    */
    /*[-C++;-NATIVE]
        ImGui::Indent();
    */
    public static native void Indent();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.Indent(indentW);
    */
    /*[-C++;-NATIVE]
        ImGui::Indent(indentW);
    */
    public static native void Indent(float indentW);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.Unindent();
    */
    /*[-C++;-NATIVE]
        ImGui::Unindent();
    */
    public static native void Unindent();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.Unindent(indentW);
    */
    /*[-C++;-NATIVE]
        ImGui::Unindent(indentW);
    */
    public static native void Unindent(float indentW);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.BeginGroup();
    */
    /*[-C++;-NATIVE]
        ImGui::BeginGroup();
    */
    public static native void BeginGroup();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.EndGroup();
    */
    /*[-C++;-NATIVE]
        ImGui::EndGroup();
    */
    public static native void EndGroup();

    /*[-teaVM;-NATIVE]
        var out = ImGui.wrapPointer(vec2Addr, ImGui.ImVec2);
        var nativeObject = ImGui.Im.prototype.GetCursorPos();
        out.set_x(nativeObject.get_x());
        out.set_y(nativeObject.get_y());
    */
    /*[-C++;-NATIVE]
        ImVec2 vec = ImGui::GetCursorPos();
        ImVec2 * out = (ImVec2*)vec2Addr;
        out->x = vec.x;
        out->y = vec.y;
    */
    public static native void GetCursorPos(long vec2Addr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetCursorPosX();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetCursorPosX();
    */
    public static native float GetCursorPosX();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetCursorPosY();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetCursorPosY();
    */
    public static native float GetCursorPosY();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetCursorPos(posAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * pos = (ImVec2*)posAddr;
        ImGui::SetCursorPos(*pos);
    */
    public static native void SetCursorPos(long posAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetCursorPosX(x);
    */
    /*[-C++;-NATIVE]
        ImGui::SetCursorPosX(x);
    */
    public static native void SetCursorPosX(float x);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetCursorPosY(y);
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
        ImGui.Im.prototype.SetCursorScreenPos(posAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * pos = (ImVec2*)posAddr;
        ImGui::SetCursorScreenPos(*pos);
    */
    public static native void SetCursorScreenPos(long posAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.AlignTextToFramePadding();
    */
    /*[-C++;-NATIVE]
        ImGui::AlignTextToFramePadding();
    */
    public static native void AlignTextToFramePadding();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetTextLineHeight();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetTextLineHeight();
    */
    public static native float GetTextLineHeight();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetTextLineHeightWithSpacing();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetTextLineHeightWithSpacing();
    */
    public static native float GetTextLineHeightWithSpacing();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetFrameHeight();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetFrameHeight();
    */
    public static native float GetFrameHeight();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetFrameHeightWithSpacing();
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
        ImGui.Im.prototype.PushID(str_id);
    */
    /*[-C++;-NATIVE]
        ImGui::PushID(str_id);
    */
    public static native void PushID(String str_id);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PushID2(str_id_begin, str_id_end);
    */
    /*[-C++;-NATIVE]
        ImGui::PushID(str_id_begin, str_id_end);
    */
    public static native void PushID(String str_id_begin, String str_id_end);

    /*[-teaVM;-NATIVE]
       ImGui.Im.prototype.PushID4(int_id);
    */
    /*[-C++;-NATIVE]
        ImGui::PushID(int_id);
    */
    public static native void PushID(int int_id);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.PopID();
    */
    /*[-C++;-NATIVE]
        ImGui::PopID();
    */
    public static native void PopID();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetID(str_id);
    */
    /*[-C++;-NATIVE]
        return ImGui::GetID(str_id);
    */
    public static native int GetID(String str_id);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetID(str_id_begin, str_id_end);
    */
    /*[-C++;-NATIVE]
        return ImGui::GetID(str_id_begin, str_id_end);
    */
    public static native int GetID(String str_id_begin, String str_id_end);

    // Widgets: Text

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TextUnformatted(text);
    */
    /*[-C++;-NATIVE]
        ImGui::TextUnformatted(text);
    */
    public static native void TextUnformatted(String text);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TextUnformatted(text, text_end);
    */
    /*[-C++;-NATIVE]
        ImGui::TextUnformatted(text, text_end);
    */
    public static native void TextUnformatted(String text, String text_end);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.Text(text);
    */
    /*[-C++;-NATIVE]
        ImGui::Text(text);
    */
    public static native void Text(String text);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.Text(text);
    */
    /*[-C++;-NATIVE]
        ImGui::Text(text);
    */
    public static native void Text(byte[] text);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TextColored(colorAddr, text);
    */
    /*[-C++;-NATIVE]
        ImVec4 * color = (ImVec4*)colorAddr;
        ImGui::TextColored(*color, text);
    */
    public static native void TextColored(long colorAddr, String text);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TextDisabled(text);
    */
    /*[-C++;-NATIVE]
        ImGui::TextDisabled(text);
    */
    public static native void TextDisabled(String text);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TextWrapped(text);
    */
    /*[-C++;-NATIVE]
        ImGui::TextWrapped(text);
    */
    public static native void TextWrapped(String text);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.LabelText(label, text);
    */
    /*[-C++;-NATIVE]
        ImGui::LabelText(label, text);
    */
    public static native void LabelText(String label, String text);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.BulletText();
    */
    /*[-C++;-NATIVE]
        ImGui::BulletText(text);
    */
    public static native void BulletText(String text);

    // Widgets: Main
    // - Most widgets return true when the value has been changed or when pressed/selected

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.Button(label);
    */
    /*[-C++;-NATIVE]
        return ImGui::Button(label);
    */
    public static native boolean Button(String label);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.Button(label, imVec2Addr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * imVec2 = (ImVec2*)imVec2Addr;
        return ImGui::Button(label, *imVec2);
    */
    public static native boolean Button(String label, long imVec2Addr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SmallButton(label);
    */
    /*[-C++;-NATIVE]
        return ImGui::SmallButton(label);
    */
    public static native boolean SmallButton(String label);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.SmallButton(label, imVec2Addr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * imVec2 = (ImVec2*)imVec2Addr;
        return ImGui::InvisibleButton(strId, *imVec2);
    */
    public static native boolean InvisibleButton(String strId, long imVec2Addr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.ArrowButton(strId, dir);
    */
    /*[-C++;-NATIVE]
        return ImGui::ArrowButton(strId, dir);
    */
    public static native boolean ArrowButton(String strId, int dir);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.Image(textureID, imVec2Addr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * imVec2 = (ImVec2*)imVec2Addr;
        ImGui::Image((ImTextureID)textureID, *imVec2);
    */
    public static native void Image(int textureID, long imVec2Addr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.Image(textureID, imVec2Addr, uv0Addr, uv1Addr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * imVec2 = (ImVec2*)imVec2Addr;
        ImVec2 * uv0 = (ImVec2*)uv0Addr;
        ImVec2 * uv1 = (ImVec2*)uv1Addr;
        ImGui::Image((ImTextureID)textureID, *imVec2, *uv0, *uv1);
    */
    public static native void Image(int textureID, long imVec2Addr, long uv0Addr, long uv1Addr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.Image(textureID, imVec2Addr, uv0Addr, uv1Addr, tintColorAddr, borderColAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * imVec2 = (ImVec2*)imVec2Addr;
        ImVec2 * uv0 = (ImVec2*)uv0Addr;
        ImVec2 * uv1 = (ImVec2*)uv1Addr;
        ImVec4 * tintColor = (ImVec4*)tintColorAddr;
        ImVec4 * borderCol = (ImVec4*)borderColAddr;
        ImGui::Image((ImTextureID)textureID, *imVec2, *uv0, *uv1, *tintColor, *borderCol);
    */
    public static native void Image(int textureID, long imVec2Addr, long uv0Addr, long uv1Addr, long tintColorAddr, long borderColAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.ImageButton(textureID, sizeAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::ImageButton((ImTextureID)textureID, *size);
    */
    public static native boolean ImageButton(int textureID, long sizeAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.ImageButton(textureID, sizeAddr, uv0Addr, uv1Addr, frame_padding);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        ImVec2 * uv0 = (ImVec2*)uv0Addr;
        ImVec2 * uv1 = (ImVec2*)uv1Addr;
        return ImGui::ImageButton((ImTextureID)textureID, *size, *uv0, *uv1, frame_padding);
    */
    public static native boolean ImageButton(int textureID, long sizeAddr, long uv0Addr, long uv1Addr, int frame_padding);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.ImageButton(textureID, sizeAddr, uv0Addr, uv1Addr, frame_padding, colorAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        ImVec2 * uv0 = (ImVec2*)uv0Addr;
        ImVec2 * uv1 = (ImVec2*)uv1Addr;
        ImVec4 * color = (ImVec4*)colorAddr;
        return ImGui::ImageButton((ImTextureID)textureID, *size, *uv0, *uv1, frame_padding, *color);
    */
    public static native boolean ImageButton(int textureID, long sizeAddr, long uv0Addr, long uv1Addr, int frame_padding, long colorAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.ImageButton(textureID, sizeAddr, uv0Addr, uv1Addr, frame_padding, colorAddr, tintAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        ImVec2 * uv0 = (ImVec2*)uv0Addr;
        ImVec2 * uv1 = (ImVec2*)uv1Addr;
        ImVec4 * color = (ImVec4*)colorAddr;
        ImVec4 * tint = (ImVec4*)tintAddr;
        return ImGui::ImageButton((ImTextureID)textureID, *size, *uv0, *uv1, frame_padding, *color, *tint);
    */
    public static native boolean ImageButton(int textureID, long sizeAddr, long uv0Addr, long uv1Addr, int frame_padding, long colorAddr, long tintAddr);

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
        return ImGui.Im.prototype.CheckboxFlags(label, dataAddr, flagsValue);
    */
    /*[-C++;-NATIVE]
        int * data = (int*)dataAddr;
        return ImGui::CheckboxFlags(label, (unsigned int*)&data[0], flagsValue);
    */
    public static native boolean CheckboxFlags(String label, long dataAddr, int flagsValue);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.RadioButton(label, active);
    */
    /*[-C++;-NATIVE]
        return ImGui::RadioButton(label, active);
    */
    public static native boolean RadioButton(String label, boolean active);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.RadioButton(label, dataAddr, v_button);
    */
    /*[-C++;-NATIVE]
        int * data = (int*)dataAddr;
        return ImGui::RadioButton(label, &data[0], v_button);
    */
    public static native boolean RadioButton(String label, long dataAddr, int v_button);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.ProgressBar(fraction);
    */
    /*[-C++;-NATIVE]
        ImGui::ProgressBar(fraction);
    */
    public static native void ProgressBar(float fraction);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.ProgressBar(fraction);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        ImGui::ProgressBar(fraction, *size);
    */
    public static native void ProgressBar(float fraction, long sizeAddr);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.Bullet();
    */
    /*[-C++;-NATIVE]
        ImGui::Bullet();
    */
    public static native void Bullet();

    // Widgets: Combo Box
    // - The new BeginCombo()/EndCombo() api allows you to manage your contents and selection state however you want it, by creating e.g. Selectable() items.
    // - The old Combo() api are helpers over BeginCombo()/EndCombo() which are kept available for convenience purpose.

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginCombo(label, preview_value);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginCombo(label, preview_value);
    */
    public static native boolean BeginCombo(String label, String preview_value);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginCombo(label, preview_value, flags);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginCombo(label, preview_value, flags);
    */
    public static native boolean BeginCombo(String label, String preview_value, int flags);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.EndCombo();
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
        return ImGui.Im.prototype.Combo(label, current_itemAddr, items_separated_by_zeros);
    */
    /*[-C++;-NATIVE]
        int * current_item = (int*)current_itemAddr;
        return ImGui::Combo(label, &current_item[0], items_separated_by_zeros);
    */
    public static native boolean Combo(String label, long current_itemAddr, String items_separated_by_zeros);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.Combo(label, current_itemAddr, items_separated_by_zeros, popup_max_height_in_items);
    */
    /*[-C++;-NATIVE]
        int * current_item = (int*)current_itemAddr;
        return ImGui::Combo(label, &current_item[0], items_separated_by_zeros, popup_max_height_in_items);
    */
    public static native boolean Combo(String label, long current_itemAddr, String items_separated_by_zeros, int popup_max_height_in_items);

    // Widgets: Trees
    // - TreeNode functions return true when the node is open, in which case you need to also call TreePop() when you are finished displaying the tree node contents.

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.TreeNode(label);
    */
    /*[-C++;-NATIVE]
        return ImGui::TreeNode(label);
    */
    public static native boolean TreeNode(String label);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.TreeNode2(str_id, label);
    */
    /*[-C++;-NATIVE]
        return ImGui::TreeNode(str_id, label);
    */
    public static native boolean TreeNode(String str_id, String label);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.TreeNode3(ptr_id, label);
    */
    /*[-C++;-NATIVE]
        return ImGui::TreeNode((void*)(intptr_t)ptr_id, label);
    */
    public static native boolean TreeNode(int ptr_id, String label);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.TreeNodeEx(label);
    */
    /*[-C++;-NATIVE]
        return ImGui::TreeNodeEx(label);
    */
    public static native boolean TreeNodeEx(String label);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.TreeNodeEx(label, flags);
    */
    /*[-C++;-NATIVE]
        return ImGui::TreeNodeEx(label, flags);
    */
    public static native boolean TreeNodeEx(String label, int flags);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.TreeNodeEx2(label, flags, label);
    */
    /*[-C++;-NATIVE]
        return ImGui::TreeNodeEx(str_id, flags, label);
    */
    public static native boolean TreeNodeEx(String str_id, int flags, String label);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.TreeNodeEx2(ptr_id, flags, label);
    */
    /*[-C++;-NATIVE]
        return ImGui::TreeNodeEx((void*)(intptr_t)ptr_id, flags, label);
    */
    public static native boolean TreeNodeEx(int ptr_id, int flags, String label);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TreePush(str_id);
    */
    /*[-C++;-NATIVE]
        ImGui::TreePush(str_id);
    */
    public static native void TreePush(String str_id);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TreePush(ptr_id);
    */
    /*[-C++;-NATIVE]
        ImGui::TreePush((void*)(intptr_t)ptr_id);
    */
    public static native void TreePush(int ptr_id);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TreePop();
    */
    /*[-C++;-NATIVE]
        ImGui::TreePop();
    */
    public static native void TreePop();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetTreeNodeToLabelSpacing();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetTreeNodeToLabelSpacing();
    */
    public static native float GetTreeNodeToLabelSpacing();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.CollapsingHeader(label);
    */
    /*[-C++;-NATIVE]
        return ImGui::CollapsingHeader(label);
    */
    public static native boolean CollapsingHeader(String label);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.CollapsingHeader(label, flags);
    */
    /*[-C++;-NATIVE]
        return ImGui::CollapsingHeader(label, flags);
    */
    public static native boolean CollapsingHeader(String label, int flags);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.CollapsingHeader2(label, p_openAddr);
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
        return ImGui.Im.prototype.CollapsingHeader2(label, p_openAddr, flags);
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
        return ImGui.Im.prototype.Selectable(label);
    */
    /*[-C++;-NATIVE]
        return ImGui::Selectable(label);
    */
    public static native boolean Selectable(String label);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.Selectable(label, selected);
    */
    /*[-C++;-NATIVE]
        return ImGui::Selectable(label, selected);
    */
    public static native boolean Selectable(String label, boolean selected);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.Selectable(label, selected, flags, sizeAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::Selectable(label, selected, flags, *size);
    */
    public static native boolean Selectable(String label, boolean selected, int flags, long sizeAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.Selectable(label, selectedAddr);
    */
    /*[-C++;-NATIVE]
        bool * selected = (bool*)selectedAddr;
        return ImGui::Selectable(label, selected);
    */
    public static native boolean Selectable(String label, long selectedAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.Selectable(label, selectedAddr, flags, sizeAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        bool * selected = (bool*)selectedAddr;
        return ImGui::Selectable(label, selected, flags, *size);
    */
    public static native boolean Selectable(String label, long selectedAddr, int flags, long sizeAddr);

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
        return ImGui.Im.prototype.ListBoxHeader(label);
    */
    /*[-C++;-NATIVE]
        return ImGui::ListBoxHeader(label);
    */
    public static native boolean ListBoxHeader(String label);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.ListBoxHeader(label, sizeAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::ListBoxHeader(label, *size);
    */
    public static native boolean ListBoxHeader(String label, long sizeAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.ListBoxHeader(label, items_count);
    */
    /*[-C++;-NATIVE]
        return ImGui::ListBoxHeader(label, items_count);
    */
    public static native boolean ListBoxHeader(String label, int items_count);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.ListBoxHeader(label, items_count, height_in_items);
    */
    /*[-C++;-NATIVE]
        return ImGui::ListBoxHeader(label, items_count, height_in_items);
    */
    public static native boolean ListBoxHeader(String label, int items_count, int height_in_items);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.ListBoxFooter();
    */
    /*[-C++;-NATIVE]
        ImGui::ListBoxFooter();
    */
    public static native void ListBoxFooter();

    // Widgets: Menus

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginMainMenuBar();
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginMainMenuBar();
    */
    public static native boolean BeginMainMenuBar();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.EndMainMenuBar();
    */
    /*[-C++;-NATIVE]
        ImGui::EndMainMenuBar();
    */
    public static native void EndMainMenuBar();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginMenuBar();
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginMenuBar();
    */
    public static native boolean BeginMenuBar();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.EndMenuBar();
    */
    /*[-C++;-NATIVE]
        ImGui::EndMenuBar();
    */
    public static native void EndMenuBar();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginMenu(label);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginMenu(label);
    */
    public static native boolean BeginMenu(String label);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginMenu(label, enabled);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginMenu(label, enabled);
    */
    public static native boolean BeginMenu(String label, boolean enabled);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.EndMenu();
    */
    /*[-C++;-NATIVE]
        ImGui::EndMenu();
    */
    public static native void EndMenu();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.MenuItem(label);
    */
    /*[-C++;-NATIVE]
        return ImGui::MenuItem(label);
    */
    public static native boolean MenuItem(String label);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.MenuItem(label, null, selected);
    */
    /*[-C++;-NATIVE]
        return ImGui::MenuItem(label, NULL, selected);
    */
    public static native boolean MenuItem(String label, boolean selected);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.MenuItem(label, null, selected, enabled);
    */
    /*[-C++;-NATIVE]
        return ImGui::MenuItem(label, NULL, selected, enabled);
    */
    public static native boolean MenuItem(String label, boolean selected, boolean enabled);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.MenuItem(label, shortcut, selected);
    */
    /*[-C++;-NATIVE]
        return ImGui::MenuItem(label, shortcut, selected);
    */
    public static native boolean MenuItem(String label, String shortcut, boolean selected);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.MenuItem(label, shortcut, selected, enabled);
    */
    /*[-C++;-NATIVE]
        return ImGui::MenuItem(label, shortcut, selected, enabled);
    */
    public static native boolean MenuItem(String label, String shortcut, boolean selected, boolean enabled);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.MenuItem(label, shortcut, selectedAddr);
    */
    /*[-C++;-NATIVE]
        bool * p_selected = (bool*)selectedAddr;
        return ImGui::MenuItem(label, shortcut, p_selected);
    */
    public static native boolean MenuItem(String label, String shortcut, long selectedAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.MenuItem(label, p_selectedAddr, enabled);
    */
    /*[-C++;-NATIVE]
        bool * p_selected = (bool*)p_selectedAddr;
        return ImGui::MenuItem(label, shortcut, p_selected, enabled);
    */
    public static native boolean MenuItem(String label, String shortcut, long p_selectedAddr, boolean enabled);

    // Tooltips

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.BeginTooltip();
    */
    /*[-C++;-NATIVE]
        ImGui::BeginTooltip();
    */
    public static native void BeginTooltip();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.EndTooltip();
    */
    /*[-C++;-NATIVE]
        ImGui::EndTooltip();
    */
    public static native void EndTooltip();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetTooltip(text);
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
        ImGui.Im.prototype.OpenPopup(str_id);
    */
    /*[-C++;-NATIVE]
        ImGui::OpenPopup(str_id);
    */
    public static native void OpenPopup(String str_id);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginPopup(str_id);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopup(str_id);
    */
    public static native boolean BeginPopup(String str_id);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginPopup(str_id, flags);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopup(str_id, flags);
    */
    public static native boolean BeginPopup(String str_id, int flags);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginPopupContextItem();
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupContextItem();
    */
    public static native boolean BeginPopupContextItem();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginPopupContextItem(str_id, mouse_button);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupContextItem(str_id, mouse_button);
    */
    public static native boolean BeginPopupContextItem(String str_id, int mouse_button);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginPopupContextWindow();
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupContextWindow();
    */
    public static native boolean BeginPopupContextWindow();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginPopupContextWindow(str_id, flags);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupContextWindow(str_id, flags);
    */
    public static native boolean BeginPopupContextWindow(String str_id, int flags);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginPopupContextVoid();
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupContextVoid();
    */
    public static native boolean BeginPopupContextVoid();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginPopupContextVoid(str_id, mouse_button);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupContextVoid(str_id, mouse_button);
    */
    public static native boolean BeginPopupContextVoid(String str_id, int mouse_button);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginPopupModal(name);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupModal(name);
    */
    public static native boolean BeginPopupModal(String name);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginPopupModal(name, null, flags);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginPopupModal(name, NULL, flags);
    */
    public static native boolean BeginPopupModal(String name, int flags);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginPopupModal(name, p_openAddr, flags);
    */
    /*[-C++;-NATIVE]
        bool * p_open = (bool*)p_openAddr;
        return ImGui::BeginPopupModal(name, p_open, flags);
    */
    public static native boolean BeginPopupModal(String name, long p_openAddr, int flags);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.EndPopup();
    */
    /*[-C++;-NATIVE]
        ImGui::EndPopup();
    */
    public static native void EndPopup();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.OpenPopupOnItemClick();
    */
    /*[-C++;-NATIVE]
        ImGui::OpenPopupOnItemClick();
    */
    public static native void OpenPopupOnItemClick();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.IsPopupOpen(str_id, mouse_button);
    */
    /*[-C++;-NATIVE]
        ImGui::OpenPopupOnItemClick(str_id, mouse_button);
    */
    public static native void OpenPopupOnItemClick(String str_id, int mouse_button);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsPopupOpen(str_id);
    */
    /*[-C++;-NATIVE]
        return ImGui::IsPopupOpen(str_id);
    */
    public static native boolean IsPopupOpen(String str_id);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.CloseCurrentPopup();
    */
    /*[-C++;-NATIVE]
        ImGui::CloseCurrentPopup();
    */
    public static native void CloseCurrentPopup();

    // Tables

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginTable(id, columns_count);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTable(id, columns_count);
    */
    public static native boolean BeginTable(String id, int columns_count);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginTable(id, columns_count, flags);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTable(id, columns_count, flags);
    */
    public static native boolean BeginTable(String id, int columns_count, int flags);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginTable(id, columns_count, flags, outer_sizeAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * outerSize = (ImVec2*)outer_sizeAddr;
        return ImGui::BeginTable(id, columns_count, flags, *outerSize);
    */
    public static native boolean BeginTable(String id, int columns_count, int flags, long outer_sizeAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginTable(id, columns_count, flags, outer_sizeAddr, inner_width);
    */
    /*[-C++;-NATIVE]
        ImVec2 * outerSize = (ImVec2*)outer_sizeAddr;
        return ImGui::BeginTable(id, columns_count, flags, *outerSize, inner_width);
    */
    public static native boolean BeginTable(String id, int columns_count, int flags, long outer_sizeAddr, float inner_width);

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
        ImGui.Im.prototype.EndTable();
    */
    /*[-C++;-NATIVE]
        ImGui::EndTable();
    */
    public static native void EndTable();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TableNextRow();
    */
    /*[-C++;-NATIVE]
        ImGui::TableNextRow();
    */
    public static native void TableNextRow();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TableNextRow(row_flags);
    */
    /*[-C++;-NATIVE]
        ImGui::TableNextRow(row_flags);
    */
    public static native void TableNextRow(int row_flags);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TableNextRow(row_flags, min_row_height);
    */
    /*[-C++;-NATIVE]
        ImGui::TableNextRow(row_flags, min_row_height);
    */
    public static native void TableNextRow(int row_flags, float min_row_height);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.TableNextColumn();
    */
    /*[-C++;-NATIVE]
        return ImGui::TableNextColumn();
    */
    public static native boolean TableNextColumn();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.TableSetColumnIndex(column_n);
    */
    /*[-C++;-NATIVE]
        return ImGui::TableSetColumnIndex(column_n);
    */
    public static native boolean TableSetColumnIndex(int column_n);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.TableGetColumnIndex();
    */
    /*[-C++;-NATIVE]
        return ImGui::TableGetColumnIndex();
    */
    public static native int TableGetColumnIndex();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.TableGetRowIndex();
    */
    /*[-C++;-NATIVE]
        return ImGui::TableGetRowIndex();
    */
    public static native int TableGetRowIndex();

    // Tables: Headers & Columns declaration

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.TableSetupColumn(label);
    */
    /*[-C++;-NATIVE]
        ImGui::TableSetupColumn(label);
    */
    public static native void TableSetupColumn(String label);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.TableSetupColumn(label, flags);
    */
    /*[-C++;-NATIVE]
        ImGui::TableSetupColumn(label, flags);
    */
    public static native void TableSetupColumn(String label, int flags);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TableSetupColumn(label, flags);
    */
    /*[-C++;-NATIVE]
        ImGui::TableSetupColumn(label, flags);
    */
    public static native void TableSetupColumn(byte[] label, int flags);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TableSetupColumn(label, flags, init_width_or_weight);
    */
    /*[-C++;-NATIVE]
        ImGui::TableSetupColumn(label, flags, init_width_or_weight);
    */
    public static native void TableSetupColumn(String label, int flags, float init_width_or_weight);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TableSetupColumn(label, flags, init_width_or_weight, user_id);
    */
    /*[-C++;-NATIVE]
        ImGui::TableSetupColumn(label, flags, init_width_or_weight, user_id);
    */
    public static native void TableSetupColumn(String label, int flags, float init_width_or_weight, int user_id);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TableHeadersRow();
    */
    /*[-C++;-NATIVE]
        ImGui::TableHeadersRow();
    */
    public static native void TableHeadersRow();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.TableHeader(label);
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
        return ImGui.Im.prototype.TableGetColumnCount();
    */
    /*[-C++;-NATIVE]
        return ImGui::TableGetColumnCount();
    */
    public static native int TableGetColumnCount();

    // Tab Bars, Tabs
    // [BETA API] API may evolve!

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginTabBar(str_id);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTabBar(str_id);
    */
    public static native boolean BeginTabBar(String str_id);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginTabBar(str_id, flags);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTabBar(str_id, flags);
    */
    public static native boolean BeginTabBar(String str_id, int flags);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.EndTabBar();
    */
    /*[-C++;-NATIVE]
        ImGui::EndTabBar();
    */
    public static native void EndTabBar();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginTabItem(label);
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginTabItem(label);
    */
    public static native boolean BeginTabItem(String label);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginTabItem(label, p_openAddr, flags);
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
        ImGui.Im.prototype.EndTabItem();
    */
    /*[-C++;-NATIVE]
        ImGui::EndTabItem();
    */
    public static native void EndTabItem();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetTabItemClosed(tab_or_docked_window_label);
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
        return ImGui.Im.prototype.DockSpace(id);
    */
    /*[-C++;-NATIVE]
        return ImGui::DockSpace(id);
    */
    public static native int DockSpace(int id);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DockSpace(id, sizeAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::DockSpace(id, *size);
    */
    public static native int DockSpace(int id, long sizeAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DockSpace(id, sizeAddr, flags);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::DockSpace(id, *size, flags);
    */
    public static native int DockSpace(int id, long sizeAddr, int flags);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DockSpaceOverViewport();
    */
    /*[-C++;-NATIVE]
        return ImGui::DockSpaceOverViewport();
    */
    public static native int DockSpaceOverViewport();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DockSpaceOverViewport(viewportAddr, flags);
    */
    /*[-C++;-NATIVE]
        ImGuiViewport * viewport = (ImGuiViewport*)viewportAddr;
        return ImGui::DockSpaceOverViewport(viewport, flags);
    */
    public static native int DockSpaceOverViewport(long viewportAddr, int flags);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetNextWindowDockID(dock_id, cond);
    */
    /*[-C++;-NATIVE]
        ImGui::SetNextWindowDockID(dock_id, cond);
    */
    public static native void SetNextWindowDockID(int dock_id, int cond);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetWindowDockID();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetWindowDockID();
    */
    public static native int GetWindowDockID();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsWindowDocked();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsWindowDocked();
    */
    public static native boolean IsWindowDocked();

    // Drag and Drop

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginDragDropSource(flags);
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
        ImGui.Im.prototype.EndDragDropSource();
    */
    /*[-C++;-NATIVE]
        ImGui::EndDragDropSource();
    */
    public static native void EndDragDropSource();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginDragDropTarget();
    */
    /*[-C++;-NATIVE]
        return ImGui::BeginDragDropTarget();
    */
    public static native boolean BeginDragDropTarget();

    // TODO return ImGuiPayload pointer

    /*[-teaVM;-NATIVE]
        var test = 0;
        return false;
    */
    /*[-C++;-NATIVE]
        return ImGui::AcceptDragDropPayload(type, flags) != NULL;
    */
    public static native boolean AcceptDragDropPayload(String type, int flags);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.EndDragDropTarget();
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
        ImGui.Im.prototype.BeginDisabled(disabled);
    */
    /*[-C++;-NATIVE]
        ImGui::BeginDisabled(disabled);
    */
    public static native void BeginDisabled(boolean disabled);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.EndDisabled();
    */
    /*[-C++;-NATIVE]
        ImGui::EndDisabled();
    */
    public static native void EndDisabled();

    // Focus, Activation
    // - Prefer using "SetItemDefaultFocus()" over "if (IsWindowAppearing()) SetScrollHereY()" when applicable to signify "this is the default item"

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetItemDefaultFocus();
    */
    /*[-C++;-NATIVE]
        ImGui::SetItemDefaultFocus();
    */
    public static native void SetItemDefaultFocus();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetKeyboardFocusHere();
    */
    /*[-C++;-NATIVE]
        ImGui::SetKeyboardFocusHere();
    */
    public static native void SetKeyboardFocusHere();

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.SetKeyboardFocusHere(offset);
    */
    /*[-C++;-NATIVE]
        ImGui::SetKeyboardFocusHere(offset);
    */
    public static native void SetKeyboardFocusHere(int offset);

    // Item/Widgets Utilities
    // - Most of the functions are referring to the last/previous item we submitted.
    // - See Demo Window under "Widgets->Querying Status" for an interactive visualization of most of those functions.

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsItemHovered();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemHovered();
    */
    public static native boolean IsItemHovered();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsItemHovered(flags);
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemHovered(flags);
    */
    public static native boolean IsItemHovered(int flags);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsItemActive();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemActive();
    */
    public static native boolean IsItemActive();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsItemFocused();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemFocused();
    */
    public static native boolean IsItemFocused();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsItemClicked();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemClicked();
    */
    public static native boolean IsItemClicked();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsItemClicked(mouse_button);
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemClicked(mouse_button);
    */
    public static native boolean IsItemClicked(int mouse_button);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsItemVisible();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemVisible();
    */
    public static native boolean IsItemVisible();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsItemEdited();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemEdited();
    */
    public static native boolean IsItemEdited();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsItemActivated();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemActivated();
    */
    public static native boolean IsItemActivated();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsItemDeactivated();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemDeactivated();
    */
    public static native boolean IsItemDeactivated();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsItemDeactivatedAfterEdit();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsItemDeactivatedAfterEdit();
    */
    public static native boolean IsItemDeactivatedAfterEdit();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsAnyItemHovered();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsAnyItemHovered();
    */
    public static native boolean IsAnyItemHovered();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsAnyItemActive();
    */
    /*[-C++;-NATIVE]
        return ImGui::IsAnyItemActive();
    */
    public static native boolean IsAnyItemActive();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsAnyItemFocused();
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
        ImGui.Im.prototype.SetItemAllowOverlap();
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
        return ImGui.Im.prototype.GetMainViewport(updateDrawData);
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* viewport = ImGui::GetMainViewport();
        return (jlong)viewport;
    */
    public static native long GetMainViewport(boolean updateDrawData);

    // Miscellaneous Utilities

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.GetFrameCount();
    */
    /*[-C++;-NATIVE]
        return ImGui::GetFrameCount();
    */
    public static native int GetFrameCount();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginChildFrame(sizeAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::BeginChildFrame(id, *size);
    */
    public static native boolean BeginChildFrame(int id, long sizeAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.BeginChildFrame(sizeAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * size = (ImVec2*)sizeAddr;
        return ImGui::BeginChildFrame(id, *size, flags);
    */
    public static native boolean BeginChildFrame(int id,  long sizeAddr, int flags);

    /*[-teaVM;-NATIVE]
        ImGui.Im.prototype.EndChildFrame();
    */
    /*[-C++;-NATIVE]
        ImGui::EndChildFrame();
    */
    public static native void EndChildFrame();

    // Inputs Utilities

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsMouseDown(button);
    */
    /*[-C++;-NATIVE]
        return ImGui::IsMouseDown(button);
    */
    public static native boolean IsMouseDown(int button);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsMouseClicked(button);
    */
    /*[-C++;-NATIVE]
        return ImGui::IsMouseClicked(button);
    */
    public static native boolean IsMouseClicked(int button);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsMouseClicked(button, repeat);
    */
    /*[-C++;-NATIVE]
        bool flag = repeat;
        return ImGui::IsMouseClicked(button, flag);
    */
    public static native boolean IsMouseClicked(int button, boolean repeat);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsMouseReleased(button);
    */
    /*[-C++;-NATIVE]
        return ImGui::IsMouseReleased(button);
    */
    public static native boolean IsMouseReleased(int button);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsMouseDragging(button);
    */
    /*[-C++;-NATIVE]
        return ImGui::IsMouseDragging(button);
    */
    public static native boolean IsMouseDragging(int button);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsMouseDragging(button, lock_threshold);
    */
    /*[-C++;-NATIVE]
        return ImGui::IsMouseDragging(button, lock_threshold);
    */
    public static native boolean IsMouseDragging(int button, float lock_threshold);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsMouseHoveringRect(minAddr, maxAddr);
    */
    /*[-C++;-NATIVE]
        ImVec2 * min = (ImVec2*)minAddr;
        ImVec2 * max = (ImVec2*)maxAddr;
        return ImGui::IsMouseHoveringRect(*min, *max);
    */
    public static native boolean IsMouseHoveringRect(long minAddr, long maxAddr);

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.IsMouseHoveringRect(minAddr, maxAddr, clip);
    */
    /*[-C++;-NATIVE]
        ImVec2 * min = (ImVec2*)minAddr;
        ImVec2 * max = (ImVec2*)maxAddr;
        return ImGui::IsMouseHoveringRect(*min, *max, clip);
    */
    public static native boolean IsMouseHoveringRect(long minAddr, long maxAddr, boolean clip);

    // (Optional) Platform/OS interface for multi-viewport support

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.UpdatePlatformWindows();
    */
    /*[-C++;-NATIVE]
        ImGui::UpdatePlatformWindows();
    */
    public static native void UpdatePlatformWindows();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.RenderPlatformWindowsDefault();
    */
    /*[-C++;-NATIVE]
        ImGui::RenderPlatformWindowsDefault();
    */
    public static native void RenderPlatformWindowsDefault();

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.DestroyPlatformWindows();
    */
    /*[-C++;-NATIVE]
        ImGui::DestroyPlatformWindows();
    */
    public static native void DestroyPlatformWindows();

    // Custom search because handle is int64 pointer.

    /*[-teaVM;-NATIVE]
        return ImGui.Im.prototype.FindViewportByPlatformHandle(platformHandle);
    */
    /*[-C++;-NATIVE]
        long platHandler = platformHandle;
        return (jlong)ImGui::FindViewportByPlatformHandle((void*)platHandler);
    */
    public static native long FindViewportByPlatformHandle(long platformHandle);

    private ImGuiNative() {
    }
}
