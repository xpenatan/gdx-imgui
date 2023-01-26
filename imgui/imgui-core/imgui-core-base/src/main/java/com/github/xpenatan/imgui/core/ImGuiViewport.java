package com.github.xpenatan.imgui.core;

public class ImGuiViewport extends ImGuiBase {

    public static ImGuiViewport TMP_EMPTY = new ImGuiViewport(false);

    /*[-C++;-NATIVE]
        #include "imgui.h"

        #if defined(_MSC_VER) && _MSC_VER <= 1500 // MSVC 2008 or earlier
        #include <stddef.h>     // intptr_t
        #else
        #include <stdint.h>     // intptr_t
        #endif
    */

    private final ImDrawData drawData = new ImDrawData(false);

    public ImGuiViewport(boolean cMemoryOwn) {
    }

    public void setPlatformUserData(int platformUserData) {
        setPlatformUserDataNATIVE(getCPointer(), platformUserData);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiViewport);
        nativeObject.set_PlatformUserData(value);
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* nativeObject = (ImGuiViewport*)addr;
        nativeObject->PlatformUserData = (void*)value;
    */
    private static native void setPlatformUserDataNATIVE(long addr, int value);

    public int getPlatformUserData() {
        return getPlatformUserDataNATIVE(getCPointer());
    }

    //TODO fix teavm

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiViewport);
        return nativeObject.get_PlatformUserData();
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* nativeObject = (ImGuiViewport*)addr;
        if(nativeObject->PlatformUserData == NULL) {
            return 0;
        }
        else {
            intptr_t value = reinterpret_cast<intptr_t>(nativeObject->PlatformUserData);
            int platformUserData = static_cast<int>(value);
            return platformUserData;
        }
    */
    private static native int getPlatformUserDataNATIVE(long addr);

    public void setPlatformHandle(long platformHandle) {
        setPlatformHandleNATIVE(getCPointer(), platformHandle);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiViewport);
        nativeObject.set_PlatformHandle(value);
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* nativeObject = (ImGuiViewport*)addr;
        int64_t * handler = (int64_t*)nativeObject->PlatformHandle;
        *handler = value;
    */
    private static native void setPlatformHandleNATIVE(long addr, long value);

    public long getPlatformHandle() {
        return getPlatformHandleNATIVE(getCPointer());
    }

    //TODO fix teavm

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiViewport);
        return nativeObject.get_PlatformHandle();
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* nativeObject = (ImGuiViewport*)addr;
        if(nativeObject->PlatformHandle == NULL) {
            return 0;
        }
        else {
            int64_t * value = (int64_t*)nativeObject->PlatformHandle;
            return *value;
        }
    */
    private static native long getPlatformHandleNATIVE(long addr);

    public void setFlags(int flags) {
        setFlagsNATIVE(getCPointer(), flags);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiViewport);
        nativeObject.set_Flags(flags);
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* nativeObject = (ImGuiViewport*)addr;
        nativeObject->Flags = flags;
    */
    private static native void setFlagsNATIVE(long addr, int flags);

    public int getFlags() {
        return getFlagsNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiViewport);
        return nativeObject.get_Flags();
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* nativeObject = (ImGuiViewport*)addr;
        return nativeObject->Flags;
    */
    private static native int getFlagsNATIVE(long addr);

    public void setSize(float x, float y) {
        setSizeNATIVE(getCPointer(), x, y);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiViewport);
        var jsObj = nativeObject.get_Size();
        jsObj.set_x(x);
        jsObj.set_y(y);
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* nativeObject = (ImGuiViewport*)addr;
        nativeObject->Size.x = x;
        nativeObject->Size.y = y;
    */
    private static native void setSizeNATIVE(long addr, float x, float y);

    public ImVec2 getSize() {
        long pointer = getSizeNATIVE(getCPointer());
        ImVec2.TMP_EMPTY.setPointer(pointer);
        return ImVec2.TMP_EMPTY;
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiViewport);
        var jsObj = nativeObject.get_Size();
        return ImGui.getPointer(jsObj); ;
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* nativeObject = (ImGuiViewport*)addr;
        return (jlong)&nativeObject->Size;
    */
    private static native long getSizeNATIVE(long addr);

    public void setPos(float x, float y) {
        setPosNATIVE(getCPointer(), x, y);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiViewport);
        var jsObj = nativeObject.get_Pos();
        jsObj.set_x(x);
        jsObj.set_y(y);
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* nativeObject = (ImGuiViewport*)addr;
        nativeObject->Pos.x = x;
        nativeObject->Pos.y = y;
    */
    private static native void setPosNATIVE(long addr, float x, float y);

    public ImVec2 getPos() {
        long pointer = getPosNATIVE(getCPointer());
        ImVec2.TMP_EMPTY.setPointer(pointer);
        return ImVec2.TMP_EMPTY;
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiViewport);
        var jsObj = nativeObject.get_Pos();
        return ImGui.getPointer(jsObj); ;
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* nativeObject = (ImGuiViewport*)addr;
        return (jlong)&nativeObject->Pos;
    */
    private static native long getPosNATIVE(long addr);

    public ImDrawData getDrawData() {
        long pointer = getDrawDataNATIVE(getCPointer());
        drawData.setPointer(pointer);
        return drawData;
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiViewport);
        var jsObj = nativeObject.get_DrawData();
        return ImGui.getPointer(jsObj); ;
    */
    /*[-C++;-NATIVE]
        ImGuiViewport* nativeObject = (ImGuiViewport*)addr;
        return (jlong)nativeObject->DrawData;
    */
    private static native long getDrawDataNATIVE(long addr);
}
