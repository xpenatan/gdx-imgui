package com.github.xpenatan.imgui.core;

public class ImGuiBoolean extends ImGuiBase {
    public static ImGuiBoolean TMP = new ImGuiBoolean();

    /*[-C++;-NATIVE]
        #include "imgui_custom.h"
    */

    public ImGuiBoolean() {
        initObject(createNative(), true);
    }

    public ImGuiBoolean(boolean value) {
        initObject(createNative(), true);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = new ImGui.BoolArray(1);
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        return (jlong)new BoolArray(1);
    */
    private static native long createNative();

    @Override
    protected void deleteNative() {
        deleteNative(cPointer);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = ImGui.wrapPointer(addr, ImGui.BoolArray);
        ImGui.destroy(jsObj);
    */
    /*[-C++;-NATIVE]
        delete (BoolArray*)addr;
    */
    private static native void deleteNative(long addr);

    public void setValue(boolean value) {
        setValueNATIVE(getCPointer(), value);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.BoolArray);
        nativeObject.setValue(0, value);
    */
    /*[-C++;-NATIVE]
        BoolArray* nativeObject = (BoolArray*)addr;
        nativeObject->setValue(0, value);
    */
    private static native void setValueNATIVE(long addr, boolean value);

    public boolean getValue() {
        return getValueNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.BoolArray);
        return nativeObject.getValue(0);
    */
    /*[-C++;-NATIVE]
        BoolArray* nativeObject = (BoolArray*)addr;
        return nativeObject->getValue(0);
    */
    private static native boolean getValueNATIVE(long addr);

    public long getValuePointer() {
        return getValuePointerNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.BoolArray);
        return nativeObject.getPointer();
    */
    /*[-C++;-NATIVE]
        BoolArray* nativeObject = (BoolArray*)addr;
        return (jlong)nativeObject->getPointer();
    */
    private static native long getValuePointerNATIVE(long addr);

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}
