package com.github.xpenatan.imgui.core.jnicode;

public class ImGuiInternalNative {


    /*[-cpp;-NATIVE]
        #include <imgui.h>
        #include <imgui_internal.h>
    */

    /*[-cpp;-NATIVE]
        ImGui::PushMultiItemsWidths(components, w_full);
    */
    public static native void PushMultiItemsWidths(int components, float w_full);

    /*[-cpp;-NATIVE]
        ImGui::ItemSize(ImVec2(x1, y1), text_offset_y);
    */
    public static native void ItemSize(float x1, float y1, float text_offset_y);

    /*[-cpp;-NATIVE]
        ImGui::ItemSize(ImRect(x1, y1, x2, y2), text_offset_y);
    */
    public static native void ItemSize(float x1, float y1, float x2, float y2, float text_offset_y);

    /*[-cpp;-NATIVE]
        ImGuiID imGuiID = ImGui::GetID(id);
        return ImGui::ItemAdd(ImRect(x1, y1, x2, y2), imGuiID);
    */
    public static native boolean ItemAdd(float x1, float y1, float x2, float y2, String id);

    /*[-cpp;-NATIVE]
        ImGui::PushItemFlag(option, enabled);
    */
    public static native void PushItemFlag(int option, boolean enabled);

    /*[-cpp;-NATIVE]
        ImGui::PopItemFlag();
    */
    public static native void PopItemFlag();

    /**
     * ##### Start ImGuiWindow
     */

    /*[-cpp;-NATIVE]
        ImGuiWindow* window = ImGui::GetCurrentWindow();
        return window->SkipItems;
    */
    public static native boolean GetWindowSkipItem();

    /*[-cpp;-NATIVE]
        ImGuiWindow* window = ImGui::GetCurrentWindow();
        return window->DC.CursorPos.x;
    */
    public static native float GetWindowDCCursorPosX();


    /*[-cpp;-NATIVE]
        ImGuiWindow* window = ImGui::GetCurrentWindow();
        return window->DC.CursorPos.y;
    */
    public static native float GetWindowDCCursorPosY();

    /**
     *  ##### End ImGuiWindow
     */

    /**
     * ##### Start ImGuiContext
     */

    /*[-cpp;-NATIVE]
        ImGuiContext& g = *GImGui;
        return g.Time;
    */
    public static native double GetContextTime();

    /**
     * ##### End ImGuiContext
     */
}
