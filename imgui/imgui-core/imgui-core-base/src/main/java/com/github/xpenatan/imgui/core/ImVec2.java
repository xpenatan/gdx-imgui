package com.github.xpenatan.imgui.core;

public class ImVec2 extends ImGuiBase {
    public static ImVec2 TMP = new ImVec2(true);
    public static ImVec2 TMP_EMPTY = new ImVec2(false);

    /*[-C++;-NATIVE]
        #include "imgui.h"
    */

    public ImVec2(boolean cMemoryOwn) {
        if(cMemoryOwn) {
            initObject(createNative(), true);
        }
    }

    public ImVec2(float x, float y) {
        long aNative = createNative();
        initObject(aNative, true);
        set(x, y);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = new ImGui.ImVec2();
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        return (jlong)new ImVec2();
    */
    private static native long createNative();

    @Override
    protected void deleteNative() {
        deleteNative(cPointer);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = ImGui.wrapPointer(addr, ImGui.ImVec2);
        ImGui.destroy(jsObj);
    */
    /*[-C++;-NATIVE]
        delete (ImVec2*)addr;
    */
    private static native void deleteNative(long addr);

    public void setX(float x) {
        setXNATIVE(getCPointer(), x);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImVec2);
        nativeObject.set_x(value);
    */
    /*[-C++;-NATIVE]
        ImVec2* nativeObject = (ImVec2*)addr;
        nativeObject->x = value;
    */
    private static native void setXNATIVE(long addr, float value);

    public float getX() {
        return getXNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImVec2);
        return nativeObject.get_x();
    */
    /*[-C++;-NATIVE]
        ImVec2* nativeObject = (ImVec2*)addr;
        return nativeObject->x;
    */
    private static native float getXNATIVE(long addr);

    public void setY(float y) {
        setYNATIVE(getCPointer(), y);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImVec2);
        nativeObject.set_y(value);
    */
    /*[-C++;-NATIVE]
        ImVec2* nativeObject = (ImVec2*)addr;
        nativeObject->y = value;
    */
    private static native void setYNATIVE(long addr, float value);

    public float getY() {
        return getYNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImVec2);
        return nativeObject.get_y();
    */
    /*[-C++;-NATIVE]
        ImVec2* nativeObject = (ImVec2*)addr;
        return nativeObject->y;
    */
    private static native float getYNATIVE(long addr);

    public void set(float x, float y) {
        setNATIVE(getCPointer(), x, y);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImVec2);
        nativeObject.set_x(x);
        nativeObject.set_y(y);
    */
    /*[-C++;-NATIVE]
        ImVec2* nativeObject = (ImVec2*)addr;
        nativeObject->x = x;
        nativeObject->y = y;
    */
    private static native void setNATIVE(long addr, float x, float y);
}