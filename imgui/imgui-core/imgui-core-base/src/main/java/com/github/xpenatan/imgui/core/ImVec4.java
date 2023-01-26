package com.github.xpenatan.imgui.core;

public class ImVec4 extends ImGuiBase {
    public static ImVec4 TMP = new ImVec4(true);
    public static ImVec4 TMP_EMPTY = new ImVec4(false);

    /*[-C++;-NATIVE]
        #include "imgui.h"
    */

    public ImVec4(boolean cMemoryOwn) {
        if(cMemoryOwn) {
            initObject(createNative(), true);
        }
    }

    public ImVec4(float x, float y, float z, float w) {
        long aNative = createNative();
        initObject(aNative, true);
        set(x, y, z, w);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = new ImGui.ImVec4();
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        return (jlong)new ImVec4();
    */
    private static native long createNative();

    @Override
    protected void deleteNative() {
        deleteNative(cPointer);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = ImGui.wrapPointer(addr, ImGui.ImVec4);
        ImGui.destroy(jsObj);
    */
    /*[-C++;-NATIVE]
        delete (ImVec4*)addr;
    */
    private static native void deleteNative(long addr);

    public void setX(float x) {
        setXNATIVE(getCPointer(), x);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImVec4);
        nativeObject.set_x(value);
    */
    /*[-C++;-NATIVE]
        ImVec4* nativeObject = (ImVec4*)addr;
        nativeObject->x = value;
    */
    private static native void setXNATIVE(long addr, float value);

    public float getX() {
        return getXNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImVec4);
        return nativeObject.get_x();
    */
    /*[-C++;-NATIVE]
        ImVec4* nativeObject = (ImVec4*)addr;
        return nativeObject->x;
    */
    private static native float getXNATIVE(long addr);

    public void setY(float y) {
        setYNATIVE(getCPointer(), y);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImVec4);
        nativeObject.set_y(value);
    */
    /*[-C++;-NATIVE]
        ImVec4* nativeObject = (ImVec4*)addr;
        nativeObject->y = value;
    */
    private static native void setYNATIVE(long addr, float value);

    public float getY() {
        return getYNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImVec4);
        return nativeObject.get_y();
    */
    /*[-C++;-NATIVE]
        ImVec4* nativeObject = (ImVec4*)addr;
        return nativeObject->y;
    */
    private static native float getYNATIVE(long addr);

    public void setZ(float z) {
        setZNATIVE(getCPointer(), z);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImVec4);
        nativeObject.set_z(value);
    */
    /*[-C++;-NATIVE]
        ImVec4* nativeObject = (ImVec4*)addr;
        nativeObject->z = value;
    */
    private static native void setZNATIVE(long addr, float value);

    public float getZ() {
        return getZNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImVec4);
        return nativeObject.get_z();
    */
    /*[-C++;-NATIVE]
        ImVec4* nativeObject = (ImVec4*)addr;
        return nativeObject->z;
    */
    private static native float getZNATIVE(long addr);

    public void setW(float z) {
        setWNATIVE(getCPointer(), z);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImVec4);
        nativeObject.set_w(value);
    */
    /*[-C++;-NATIVE]
        ImVec4* nativeObject = (ImVec4*)addr;
        nativeObject->w = value;
    */
    private static native void setWNATIVE(long addr, float value);

    public float getW() {
        return getWNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImVec4);
        return nativeObject.get_w();
    */
    /*[-C++;-NATIVE]
        ImVec4* nativeObject = (ImVec4*)addr;
        return nativeObject->w;
    */
    private static native float getWNATIVE(long addr);

    public void set(float x, float y, float z, float w) {
        setNATIVE(getCPointer(), x, y, z, w);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImVec4);
        nativeObject.set_x(x);
        nativeObject.set_y(y);
        nativeObject.set_z(z);
        nativeObject.set_w(w);
    */
    /*[-C++;-NATIVE]
        ImVec4* nativeObject = (ImVec4*)addr;
        nativeObject->x = x;
        nativeObject->y = y;
        nativeObject->z = z;
        nativeObject->w = w;
    */
    private static native void setNATIVE(long addr, float x, float y, float z, float w);
}
