package com.github.xpenatan.imgui.core;

public class ImGuiInt2 extends ImGuiBase {

    public static ImGuiInt2 TMP = new ImGuiInt2();

    /*[-C++;-NATIVE]
        #include "imgui_custom.h"
    */

    public ImGuiInt2() {
        initObject(createNative(), true);
    }

    public ImGuiInt2(int value) {
        initObject(createNative(), true);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = new ImGui.IntArray(2);
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        return (jlong)new IntArray(2);
    */
    private static native long createNative();

    @Override
    protected void deleteNative() {
        deleteNative(cPointer);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = ImGui.wrapPointer(addr, ImGui.IntArray);
        ImGui.destroy(jsObj);
    */
    /*[-C++;-NATIVE]
        delete (IntArray*)addr;
    */
    private static native void deleteNative(long addr);

    public void setValue(int x, int y) {
        setValueNATIVE(getCPointer(), x, y);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.IntArray);
        nativeObject.setValue(0, x);
        nativeObject.setValue(1, y);
    */
    /*[-C++;-NATIVE]
        IntArray* nativeObject = (IntArray*)addr;
        nativeObject->setValue(0, x);
        nativeObject->setValue(1, y);
    */
    private static native void setValueNATIVE(long addr, int x, int y);

    public void setX(int value) {
        setValueXNATIVE(getCPointer(), value);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.IntArray);
        nativeObject.setValue(0, value);
    */
    /*[-C++;-NATIVE]
        IntArray* nativeObject = (IntArray*)addr;
        nativeObject->setValue(0, value);
    */
    private static native void setValueXNATIVE(long addr, int value);

    public int getX() {
        return getValueXNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.IntArray);
        return nativeObject.getValue(0);
    */
    /*[-C++;-NATIVE]
        IntArray* nativeObject = (IntArray*)addr;
        return nativeObject->getValue(0);
    */
    private static native int getValueXNATIVE(long addr);

    public void setY(int value) {
        setValueYNATIVE(getCPointer(), value);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.IntArray);
        nativeObject.setValue(1, value);
    */
    /*[-C++;-NATIVE]
        IntArray* nativeObject = (IntArray*)addr;
        nativeObject->setValue(1, value);
    */
    private static native void setValueYNATIVE(long addr, int value);

    public int getY() {
        return getValueYNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.IntArray);
        return nativeObject.getValue(1);
    */
    /*[-C++;-NATIVE]
        IntArray* nativeObject = (IntArray*)addr;
        return nativeObject->getValue(1);
    */
    private static native int getValueYNATIVE(long addr);

    @Override
    public String toString() {
        return "x: " + getX() + " y:" + getY();
    }
}
