package com.github.xpenatan.imgui.core;

public class ImGuiFloat2 extends ImGuiBase {

    public static ImGuiFloat2 TMP = new ImGuiFloat2();

    /*[-C++;-NATIVE]
        #include "imgui_custom.h"
    */

    public ImGuiFloat2() {
        initObject(createNative(), true);
    }

    public ImGuiFloat2(float value) {
        initObject(createNative(), true);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = new ImGui.FloatArray(2);
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        return (jlong)new FloatArray(2);
    */
    private static native long createNative();

    @Override
    protected void deleteNative() {
        deleteNative(cPointer);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = ImGui.wrapPointer(addr, ImGui.FloatArray);
        ImGui.destroy(jsObj);
    */
    /*[-C++;-NATIVE]
        delete (FloatArray*)addr;
    */
    private static native void deleteNative(long addr);

    public void setValue(float x, float y) {
        setValueNATIVE(getCPointer(), x, y);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.FloatArray);
        nativeObject.setValue(0, x);
        nativeObject.setValue(1, y);
    */
    /*[-C++;-NATIVE]
        FloatArray* nativeObject = (FloatArray*)addr;
        nativeObject->setValue(0, x);
        nativeObject->setValue(1, y);
    */
    private static native void setValueNATIVE(long addr, float x, float y);

    public void setX(float value) {
        setValueXNATIVE(getCPointer(), value);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.FloatArray);
        nativeObject.setValue(0, value);
    */
    /*[-C++;-NATIVE]
        FloatArray* nativeObject = (FloatArray*)addr;
        nativeObject->setValue(0, value);
    */
    private static native void setValueXNATIVE(long addr, float value);

    public float getX() {
        return getValueXNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.FloatArray);
        return nativeObject.getValue(0);
    */
    /*[-C++;-NATIVE]
        FloatArray* nativeObject = (FloatArray*)addr;
        return nativeObject->getValue(0);
    */
    private static native float getValueXNATIVE(long addr);

    public void setY(float value) {
        setValueYNATIVE(getCPointer(), value);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.FloatArray);
        nativeObject.setValue(1, value);
    */
    /*[-C++;-NATIVE]
        FloatArray* nativeObject = (FloatArray*)addr;
        nativeObject->setValue(1, value);
    */
    private static native void setValueYNATIVE(long addr, float value);

    public float getY() {
        return getValueYNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.FloatArray);
        return nativeObject.getValue(1);
    */
    /*[-C++;-NATIVE]
        FloatArray* nativeObject = (FloatArray*)addr;
        return nativeObject->getValue(1);
    */
    private static native float getValueYNATIVE(long addr);

    @Override
    public String toString() {
        return "x: " + getX() + " y:" + getY();
    }
}
