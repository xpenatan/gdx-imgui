package com.github.xpenatan.imgui.core;

public class ImGuiStyle extends ImGuiBase {

    /*[-C++;-NATIVE]
        #include "imgui.h"
    */

    public ImGuiStyle(boolean cMemoryOwn) {
    }

    public ImVec2 getFramePadding() {
        long pointer = getFramePaddingNATIVE(getCPointer());
        ImVec2.TMP_EMPTY.setPointer(pointer);
        return ImVec2.TMP_EMPTY;
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiStyle);
        return ImGui.getPointer(nativeObject.get_FramePadding);
    */
    /*[-C++;-NATIVE]
        ImGuiStyle* nativeObject = (ImGuiStyle*)addr;
        return (jlong)&nativeObject->FramePadding;
    */
    private static native long getFramePaddingNATIVE(long addr);

    public ImVec2 getItemInnerSpacing() {
        long pointer = getItemInnerSpacingNATIVE(getCPointer());
        ImVec2.TMP_EMPTY.setPointer(pointer);
        return ImVec2.TMP_EMPTY;
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiStyle);
        return ImGui.getPointer(nativeObject.get_ItemInnerSpacing);
    */
    /*[-C++;-NATIVE]
        ImGuiStyle* nativeObject = (ImGuiStyle*)addr;
        return (jlong)&nativeObject->ItemInnerSpacing;
    */
    private static native long getItemInnerSpacingNATIVE(long addr);
}
