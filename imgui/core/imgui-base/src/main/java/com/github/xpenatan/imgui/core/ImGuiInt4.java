package com.github.xpenatan.imgui.core;

public class ImGuiInt4 extends ImGuiBase {

    public static ImGuiInt4 TMP = new ImGuiInt4();

    /*[-C++;-NATIVE]
        #include "imgui_custom.h"
    */

    public ImGuiInt4() {
        initObject(createNative(), true);
    }

    public ImGuiInt4(int value) {
        initObject(createNative(), true);
    }

    /*[-teaVM;-NATIVE]
        var jsObj = new ImGui.IntArray(4);
        return ImGui.getPointer(jsObj);
    */
    /*[-C++;-NATIVE]
        return (jlong)new IntArray(4);
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

    public void setValue(int x, int y, int z, int w) {
        setValueNATIVE(getCPointer(), x, y, z, w);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.IntArray);
        nativeObject.setValue(0, x);
        nativeObject.setValue(1, y);
        nativeObject.setValue(2, z);
        nativeObject.setValue(3, w);
    */
    /*[-C++;-NATIVE]
        IntArray* nativeObject = (IntArray*)addr;
        nativeObject->setValue(0, x);
        nativeObject->setValue(1, y);
        nativeObject->setValue(2, z);
        nativeObject->setValue(3, w);
    */
    private static native void setValueNATIVE(long addr, int x, int y, int z, int w);

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

    public void setZ(int value) {
        setValueZNATIVE(getCPointer(), value);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.IntArray);
        nativeObject.setValue(2, value);
    */
    /*[-C++;-NATIVE]
        IntArray* nativeObject = (IntArray*)addr;
        nativeObject->setValue(2, value);
    */
    private static native void setValueZNATIVE(long addr, int value);

    public int getZ() {
        return getValueZNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.IntArray);
        return nativeObject.getValue(2);
    */
    /*[-C++;-NATIVE]
        IntArray* nativeObject = (IntArray*)addr;
        return nativeObject->getValue(2);
    */
    private static native int getValueZNATIVE(long addr);

    public void setW(int value) {
        setValueWNATIVE(getCPointer(), value);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.IntArray);
        nativeObject.setValue(3, value);
    */
    /*[-C++;-NATIVE]
        IntArray* nativeObject = (IntArray*)addr;
        nativeObject->setValue(3, value);
    */
    private static native void setValueWNATIVE(long addr, int value);

    public int getW() {
        return getValueWNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.IntArray);
        return nativeObject.getValue(3);
    */
    /*[-C++;-NATIVE]
        IntArray* nativeObject = (IntArray*)addr;
        return nativeObject->getValue(3);
    */
    private static native int getValueWNATIVE(long addr);

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
        return "x: " + getX() + " y:" + getY() + " z:" + getZ() + " w:" + getW();
    }
}
