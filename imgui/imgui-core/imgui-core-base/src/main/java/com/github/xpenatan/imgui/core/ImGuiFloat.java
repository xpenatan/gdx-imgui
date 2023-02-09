package com.github.xpenatan.imgui.core;

public class ImGuiFloat extends ImGuiBase {

    public static ImGuiFloat TMP = new ImGuiFloat();

    /*[-C++;-NATIVE]
        #include "imgui_custom.h"
    */

    public ImGuiFloat() {
        initObject(createNative(), true);
    }

    public ImGuiFloat(float value) {
        initObject(createNative(), true);
        setValue(value);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = new ImGui.FloatArray(1);
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        return (jlong)new FloatArray(1);
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

    public void setValue(float value) {
        setValueNATIVE(getCPointer(), value);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.FloatArray);
        nativeObject.setValue(0, value);
    */
    /*[-C++;-NATIVE]
        FloatArray* nativeObject = (FloatArray*)addr;
        nativeObject->setValue(0, value);
    */
    private static native void setValueNATIVE(long addr, float value);

    public float getValue() {
        return getValueNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.FloatArray);
        return nativeObject.getValue(0);
    */
    /*[-C++;-NATIVE]
        FloatArray* nativeObject = (FloatArray*)addr;
        return nativeObject->getValue(0);
    */
    private static native float getValueNATIVE(long addr);

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
        return String.valueOf(getValue());
    }
}
