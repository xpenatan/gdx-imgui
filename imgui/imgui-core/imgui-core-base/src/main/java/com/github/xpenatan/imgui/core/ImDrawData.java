package com.github.xpenatan.imgui.core;


public final class ImDrawData extends ImGuiBase {

    /*[-C++;-NATIVE]
        #include "imgui.h"
    */

    public static int MAX_VERTICES = 100000;
    public static int MAX_INDICES = 100000;
    public static int MAX_CMD = 1000;

    private int cmdListsCount; // Number of ImDrawList* to render
    private int totalIdxCount; // For convenience, sum of all ImDrawList's IdxBuffer.Size
    private int totalVtxCount;
    private int totalCmdCount;

    private float displayPosX;
    private float displayPosY;

    private float displaySizeX;
    private float displaySizeY;

    private float framebufferScaleX;
    private float framebufferScaleY;


    private ImDrawList imDrawList = new ImDrawList(false);

    public ImDrawData(boolean cMemoryOwn) {
    }

//    public ByteBuffer byteBuffer =  ByteBuffer.allocateDirect(25000).order(ByteOrder.nativeOrder());
//    public ByteBuffer iByteBuffer;
//    public ByteBuffer cmdByteBuffer;


//    public ImDrawData(ByteBuffer vByteBuffer, ByteBuffer iByteBuffer, ByteBuffer cmdByteBuffer) {
//        this.vByteBuffer = vByteBuffer;
//        this.iByteBuffer = iByteBuffer;
//        this.cmdByteBuffer = cmdByteBuffer;
//    }

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
        var jsObj = nativeObject.get_CmdLists()[index];
        return ImGui.getPointer(jsObj); ;
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
