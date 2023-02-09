package com.github.xpenatan.imgui.core;


public final class ImDrawData extends ImGuiBase {

    /*[-C++;-NATIVE]
        #include "imgui.h"
    */

    private ImDrawList imDrawList = new ImDrawList(false);

    public ImDrawData(boolean cMemoryOwn) {
    }

    public int getCmdListsCount() {
        return getCmdListsCountNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawData);
        return nativeObject.get_CmdListsCount();
    */
    /*[-C++;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return nativeObject->CmdListsCount;
    */
    private static native int getCmdListsCountNATIVE(long addr);

    public ImDrawList getCmdLists(int index) {
        long pointer = getCmdListsNATIVE(getCPointer(), index);
        imDrawList.setPointer(pointer);
        return imDrawList;
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawData);
        var cmdList = nativeObject.get_CmdLists(index);
        return ImGui.getPointer(cmdList);
    */
    /*[-C++;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return (jlong)nativeObject->CmdLists[index];
    */
    private static native long getCmdListsNATIVE(long addr, int index);

    public float getDisplayPosX() {
        return getDisplayPosXNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawData);
        return nativeObject.DisplayPos.get_x();
    */
    /*[-C++;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return nativeObject->DisplayPos.x;
    */
    private static native int getDisplayPosXNATIVE(long addr);

    public float getDisplayPosY() {
        return getDisplayPosYNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawData);
        return nativeObject.DisplayPos.get_y();
    */
    /*[-C++;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return nativeObject->DisplayPos.y;
    */
    private static native int getDisplayPosYNATIVE(long addr);

    public float getDisplaySizeX() {
        return getDisplaySizeXNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawData);
        return nativeObject.DisplaySize.get_x();
    */
    /*[-C++;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return nativeObject->DisplaySize.x;
    */
    private static native int getDisplaySizeXNATIVE(long addr);

    public float getDisplaySizeY() {
        return getDisplaySizeYNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawData);
        return nativeObject.DisplaySize.get_y();
    */
    /*[-C++;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return nativeObject->DisplaySize.y;
    */
    private static native int getDisplaySizeYNATIVE(long addr);

    public float getFramebufferScaleX() {
        return getFramebufferScaleXNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawData);
        return nativeObject.FramebufferScale.get_x();
    */
    /*[-C++;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return nativeObject->FramebufferScale.x;
    */
    private static native int getFramebufferScaleXNATIVE(long addr);

    public float getFramebufferScaleY() {
        return getFramebufferScaleYNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImDrawData);
        return nativeObject.FramebufferScale.get_y();
    */
    /*[-C++;-NATIVE]
        ImDrawData* nativeObject = (ImDrawData*)addr;
        return nativeObject->FramebufferScale.y;
    */
    private static native int getFramebufferScaleYNATIVE(long addr);
}
