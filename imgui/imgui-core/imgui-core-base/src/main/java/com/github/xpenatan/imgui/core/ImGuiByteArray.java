package com.github.xpenatan.imgui.core;

public class ImGuiByteArray extends ImGuiBase {

    public static ImGuiInt TMP = new ImGuiInt();

    /*[-C++;-NATIVE]
        #include "imgui_custom.h"
    */

    public ImGuiByteArray(int size) {
        initObject(createNative(size), true);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = new ImGui.CharArray(size);
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        return (jlong)new CharArray(size);
    */
    private static native long createNative(int size);

    @Override
    protected void deleteNative() {
        deleteNative(cPointer);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = ImGui.wrapPointer(addr, ImGui.CharArray);
        ImGui.destroy(jsObj);
    */
    /*[-C++;-NATIVE]
        delete (CharArray*)addr;
    */
    private static native void deleteNative(long addr);

    public void setValue(int index, byte value) {
        setValueNATIVE(getCPointer(), index, value);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.CharArray);
        nativeObject.setValue(index, value);
    */
    /*[-C++;-NATIVE]
        CharArray* nativeObject = (CharArray*)addr;
        nativeObject->setValue(index, value);
    */
    private static native void setValueNATIVE(long addr, int index, byte value);

    public byte getValue(int index) {
        return getValueNATIVE(getCPointer(), index);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.CharArray);
        return nativeObject.getValue(index);
    */
    /*[-C++;-NATIVE]
        CharArray* nativeObject = (CharArray*)addr;
        return nativeObject->getValue(index);
    */
    private static native byte getValueNATIVE(long addr, int index);

    public long getCPointer() {
        return cPointer;
    }
}
