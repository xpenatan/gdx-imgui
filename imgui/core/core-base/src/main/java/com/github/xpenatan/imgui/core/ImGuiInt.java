package com.github.xpenatan.imgui.core;

public class ImGuiInt extends ImGuiBase {

    public static ImGuiInt TMP = new ImGuiInt();

    /*[-C++;-NATIVE]
        #include "imgui_custom.h"
    */

    public ImGuiInt() {
        initObject(createNative(), true);
    }

    public ImGuiInt(int value) {
        initObject(createNative(), true);
        setValue(value);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = new ImGui.IntArray(1);
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        return (jlong)new IntArray(1);
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

    public void setValue(int value) {
        setValueNATIVE(getCPointer(), value);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.IntArray);
        nativeObject.setValue(0, value);
    */
    /*[-C++;-NATIVE]
        IntArray* nativeObject = (IntArray*)addr;
        nativeObject->setValue(0, value);
    */
    private static native void setValueNATIVE(long addr, int value);

    public int getValue() {
        return getValueNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.IntArray);
        return nativeObject.getValue(0);
    */
    /*[-C++;-NATIVE]
        IntArray* nativeObject = (IntArray*)addr;
        return nativeObject->getValue(0);
    */
    private static native int getValueNATIVE(long addr);

    public long getValuePointer() {
        return getValuePointerNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.IntArray);
        return nativeObject.getPointer();
    */
    /*[-C++;-NATIVE]
        IntArray* nativeObject = (IntArray*)addr;
        return (jlong)nativeObject->getPointer();
    */
    private static native long getValuePointerNATIVE(long addr);

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}
