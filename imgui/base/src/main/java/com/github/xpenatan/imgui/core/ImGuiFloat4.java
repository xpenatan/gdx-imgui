package com.github.xpenatan.imgui.core;

public class ImGuiFloat4 extends ImGuiBase {

    public static ImGuiFloat4 TMP = new ImGuiFloat4();

    /*[-C++;-NATIVE]
        #include "imgui_custom.h"
    */

    public ImGuiFloat4() {
        initObject(createNative(), true);
    }

    public ImGuiFloat4(float value) {
        initObject(createNative(), true);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = new ImGui.FloatArray(4);
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        return (jlong)new FloatArray(4);
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

    public void setValue(float x, float y, float z, float w) {
        setValueNATIVE(getCPointer(), x, y, z, w);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.FloatArray);
        nativeObject.setValue(0, x);
        nativeObject.setValue(1, y);
        nativeObject.setValue(2, z);
        nativeObject.setValue(3, w);
    */
    /*[-C++;-NATIVE]
        FloatArray* nativeObject = (FloatArray*)addr;
        nativeObject->setValue(0, x);
        nativeObject->setValue(1, y);
        nativeObject->setValue(2, z);
        nativeObject->setValue(3, w);
    */
    private static native void setValueNATIVE(long addr, float x, float y, float z, float w);

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

    public void setZ(float value) {
        setValueZNATIVE(getCPointer(), value);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.FloatArray);
        nativeObject.setValue(2, value);
    */
    /*[-C++;-NATIVE]
        FloatArray* nativeObject = (FloatArray*)addr;
        nativeObject->setValue(2, value);
    */
    private static native void setValueZNATIVE(long addr, float value);

    public float getZ() {
        return getValueZNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.FloatArray);
        return nativeObject.getValue(2);
    */
    /*[-C++;-NATIVE]
        FloatArray* nativeObject = (FloatArray*)addr;
        return nativeObject->getValue(2);
    */
    private static native float getValueZNATIVE(long addr);

    public void setW(float value) {
        setValueWNATIVE(getCPointer(), value);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.FloatArray);
        nativeObject.setValue(3, value);
    */
    /*[-C++;-NATIVE]
        FloatArray* nativeObject = (FloatArray*)addr;
        nativeObject->setValue(3, value);
    */
    private static native void setValueWNATIVE(long addr, float value);

    public float getW() {
        return getValueWNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.FloatArray);
        return nativeObject.getValue(3);
    */
    /*[-C++;-NATIVE]
        FloatArray* nativeObject = (FloatArray*)addr;
        return nativeObject->getValue(3);
    */
    private static native float getValueWNATIVE(long addr);

    public long getValuePointer() {
        return getValuePointerNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.FloatArray);
        return nativeObject.getPointer();
    */
    /*[-C++;-NATIVE]
        FloatArray* nativeObject = (FloatArray*)addr;
        return (jlong)nativeObject->getPointer();
    */
    private static native long getValuePointerNATIVE(long addr);

    @Override
    public String toString() {
        return "x: " + getX() + " y:" + getY() + " z:" + getZ() + " w:" + getW();
    }
}
