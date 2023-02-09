package com.github.xpenatan.imgui.core;

import com.github.xpenatan.imgui.core.enums.ImGuiConfigFlags;
import com.github.xpenatan.imgui.core.jnicode.ImGuiNative;

public class ImGuiIO extends ImGuiBase {

    /*[-C++;-NATIVE]
        #include "imgui.h"
        #include "imgui_custom.h"
    */

    public static ImGuiIO TMP_EMPTY = new ImGuiIO(false);

    public ImGuiIO(boolean cMemoryOwn) {
    }

    public void SetConfigFlags(ImGuiConfigFlags flags) {
        ImGuiNative.SetConfigFlags(flags.getValue());
    }

    public boolean ContainsConfigFlags(ImGuiConfigFlags flags) {
        return ImGuiNative.ContainsConfigFlags(flags.getValue());
    }

    public void SetDockingFlags(boolean ConfigDockingNoSplit, boolean ConfigDockingWithShift, boolean ConfigDockingAlwaysTabBar, boolean ConfigDockingTransparentPayload) {
        ImGuiNative.SetDockingFlags(ConfigDockingNoSplit, ConfigDockingWithShift, ConfigDockingAlwaysTabBar, ConfigDockingTransparentPayload);
    }

    public void SetFontGlobalScale(float scale) {
        ImGuiNative.SetFontGlobalScale(scale);
    }

    public boolean getWantCaptureMouse() {
        return getWantCaptureMouseNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var io = ImGui.wrapPointer(addr, ImGui.ImGuiIO);
        return io.get_WantCaptureMouse();
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        return io->WantCaptureMouse;
    */
    private static native boolean getWantCaptureMouseNATIVE(long addr);

    //TODO fix replace. generator not yet cast int on multiple methods.

    /*[-teaVM;-REPLACE]
    public void setIniFilename(String fileName) {
        long cPointer1 = getCPointer();
        if(fileName == null) {
            removeIniFilenameNATIVE((int)cPointer1);
        }else {
            setIniFilenameNATIVE((int)cPointer1, fileName.getBytes());
        }
    }
    */
    public void setIniFilename(String fileName) {
        long cPointer1 = getCPointer();
        if(fileName == null) {
            removeIniFilenameNATIVE(cPointer1);
        }else {
            setIniFilenameNATIVE(cPointer1, fileName.getBytes());
        }
    }

    /*[-teaVM;-NATIVE]
        var io = ImGui.wrapPointer(addr, ImGui.ImGuiIO);
        ImGui.ImHelper.prototype.setIniFilename(io, fileName);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->IniFilename = fileName;
    */
    private static native void setIniFilenameNATIVE(long addr, byte[] fileName);

    /*[-teaVM;-NATIVE]
        var io = ImGui.wrapPointer(addr, ImGui.ImGuiIO);
        ImGui.ImHelper.prototype.removeIniFilename(io);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->IniFilename = NULL;
    */
    private static native void removeIniFilenameNATIVE(long addr);

    public boolean containsIniFilename() {
        return containsIniFilenameNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var io = ImGui.wrapPointer(addr, ImGui.ImGuiIO);
        return ImGui.ImHelper.prototype.containsIniFilename();
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        return io->IniFilename != NULL;
    */
    private static native boolean containsIniFilenameNATIVE(long addr);

    public void GetTexDataAsRGBA32(ImGuiByteArray pixelBuffer, ImGuiInt outWidth, ImGuiInt outHeight, ImGuiInt outBytesPerPixel) {
        GetTexDataAsRGBA32NATIVE(getCPointer(), pixelBuffer.getCPointer(), outWidth.getCPointer(), outHeight.getCPointer(), outBytesPerPixel.getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var io = ImGui.wrapPointer(addr, ImGui.ImGuiIO);
        var widthIntArray = ImGui.wrapPointer(widthAddr, ImGui.IntArray);
        var heightIntArray = ImGui.wrapPointer(heightAddr, ImGui.IntArray);
        var bytesPerPixelArray = ImGui.wrapPointer(bytesPerPixelAddr, ImGui.IntArray);
        var pixelBufferArray = ImGui.wrapPointer(pixelBufferAddr, ImGui.CharArray);
        var widthArr = widthIntArray.getPointer();
        var heightArr = heightIntArray.getPointer();
        var bytesPerPixelArr = bytesPerPixelArray.getPointer();
        var pixelBufferArr = pixelBufferArray.getPointer();
        ImGui.ImHelper.prototype.memcpyFont(io, pixelBufferArr, widthArr, heightArr, bytesPerPixelArr);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        IntArray* widthIntArray = (IntArray*)widthAddr;
        IntArray* heightIntArray = (IntArray*)heightAddr;
        IntArray* bytesPerPixel = (IntArray*)bytesPerPixelAddr;
        CharArray* pixelBuffer = (CharArray*)pixelBufferAddr;
        ImHelper::memcpyFont(io, (void*)pixelBuffer->data, (int*)widthIntArray->data, (int*)heightIntArray->data, (int*)bytesPerPixel->data);
    */
    private static native void GetTexDataAsRGBA32NATIVE(long addr, long pixelBufferAddr, long widthAddr, long heightAddr, long bytesPerPixelAddr);

    public void SetFontTexID(int id) {
        SetFontTexIDNATIVE(getCPointer(), id);
    }

    /*[-teaVM;-NATIVE]
        var io = ImGui.wrapPointer(addr, ImGui.ImGuiIO);
        io.get_Fonts().set_TexID(id);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->Fonts->TexID = (ImTextureID)id;
    */
    private static native void SetFontTexIDNATIVE(long addr, int id);

    public void UpdateKeyTyped(int c) {
        updateKeyTyped(getCPointer(), c);
    }

    /*[-teaVM;-NATIVE]
        var io = ImGui.wrapPointer(addr, ImGui.ImGuiIO);
        if (c > 0 && c < 0x10000)
            io.AddInputCharacter(c);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        if (c > 0 && c < 0x10000)
            io->AddInputCharacter((unsigned short)c);
    */
    private static native void updateKeyTyped(long addr, int c);

    public void AddKeyEvent(int imGuiKey, boolean down) {
        AddKeyEventNATIVE(getCPointer(), imGuiKey, down);
    }

    /*[-teaVM;-NATIVE]
        var io = ImGui.wrapPointer(addr, ImGui.ImGuiIO);
        io.AddKeyEvent(imGuiKey, down);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->AddKeyEvent((ImGuiKey)imGuiKey, down);
    */
    private static native void AddKeyEventNATIVE(long addr, int imGuiKey, boolean down);

    public void AddMousePosEvent(float x, float y) {
        AddMousePosEventNATIVE(getCPointer(), x, y);
    }

    /*[-teaVM;-NATIVE]
        var io = ImGui.wrapPointer(addr, ImGui.ImGuiIO);
        io.AddMousePosEvent(x, y);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->AddMousePosEvent(x, y);
    */
    private static native void AddMousePosEventNATIVE(long addr, float x, float y);

    public void AddMouseButtonEvent(int button, boolean down) {
        AddMouseButtonEventNATIVE(getCPointer(), button, down);
    }

    /*[-teaVM;-NATIVE]
        var io = ImGui.wrapPointer(addr, ImGui.ImGuiIO);
        io.AddMouseButtonEvent(button, down);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->AddMouseButtonEvent(button, down);
    */
    private static native void AddMouseButtonEventNATIVE(long addr, int button, boolean down);

    public void AddMouseWheelEvent(float xOffset, float yOffset) {
        AddMouseWheelEventNATIVE(getCPointer(), xOffset, yOffset);
    }

    /*[-teaVM;-NATIVE]
        var io = ImGui.wrapPointer(addr, ImGui.ImGuiIO);
        io.AddMouseWheelEvent(xOffset, yOffset);
    */
    /*[-C++;-NATIVE]
        ImGuiIO* io = (ImGuiIO*)addr;
        io->AddMouseWheelEvent(xOffset, yOffset);
    */
    private static native void AddMouseWheelEventNATIVE(long addr, float xOffset, float yOffset);
}
