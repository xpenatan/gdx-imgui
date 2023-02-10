package com.github.xpenatan.imgui.core;

public class ImGuiDouble extends ImGuiBase {
    public static ImGuiDouble TMP = new ImGuiDouble();

    /*[-C++;-NATIVE]
        #include "imgui_custom.h"
    */

    public ImGuiDouble() {
        initObject(createNative(), true);
    }

    public ImGuiDouble(double value) {
        initObject(createNative(), true);
        setValue(value);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = new ImGui.DoubleArray(1);
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        return (jlong)new DoubleArray(1);
    */
    private static native long createNative();

    @Override
    protected void deleteNative() {
        deleteNative(cPointer);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = ImGui.wrapPointer(addr, ImGui.DoubleArray);
        ImGui.destroy(jsObj);
    */
    /*[-C++;-NATIVE]
        delete (DoubleArray*)addr;
    */
    private static native void deleteNative(long addr);

    public void setValue(double value) {
        setValueNATIVE(getCPointer(), value);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.DoubleArray);
        nativeObject.setValue(0, value);
    */
    /*[-C++;-NATIVE]
        DoubleArray* nativeObject = (DoubleArray*)addr;
        nativeObject->setValue(0, value);
    */
    private static native void setValueNATIVE(long addr, double value);

    public double getValue() {
        return getValueNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.DoubleArray);
        return nativeObject.getValue(0);
    */
    /*[-C++;-NATIVE]
        DoubleArray* nativeObject = (DoubleArray*)addr;
        return nativeObject->getValue(0);
    */
    private static native double getValueNATIVE(long addr);

    public long getValuePointer() {
        return getValuePointerNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.DoubleArray);
        return nativeObject.getPointer();
    */
    /*[-C++;-NATIVE]
        DoubleArray* nativeObject = (DoubleArray*)addr;
        return (jlong)nativeObject->getPointer();
    */
    private static native long getValuePointerNATIVE(long addr);

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}
