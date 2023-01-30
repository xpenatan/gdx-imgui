package com.github.xpenatan.imgui.core;

import com.github.xpenatan.imgui.core.enums.ImGuiConfigFlags;
import com.github.xpenatan.imgui.core.jnicode.ImGuiNative;

public class ImGuiIO extends ImGuiBase {

    /*[-C++;-NATIVE]
        #include "imgui.h"
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
        return getDisplayPosXNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiIO);
        return nativeObject.get_WantCaptureMouse();
    */
    /*[-C++;-NATIVE]
        ImGuiIO* nativeObject = (ImGuiIO*)addr;
        return nativeObject->WantCaptureMouse;
    */
    private static native boolean getDisplayPosXNATIVE(long addr);
}
