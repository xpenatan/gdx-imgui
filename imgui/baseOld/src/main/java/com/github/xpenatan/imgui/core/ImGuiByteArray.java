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

    public int getSize() {
        return getSizeNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.CharArray);
        return nativeObject.get_size();
    */
    /*[-C++;-NATIVE]
        CharArray* nativeObject = (CharArray*)addr;
        return nativeObject->size;
    */
    private static native int getSizeNATIVE(long addr);

    public void resize(int newSize) {
        resizeNATIVE(getCPointer(), newSize);
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.CharArray);
        nativeObject.resize(newSize);
    */
    /*[-C++;-NATIVE]
        CharArray* nativeObject = (CharArray*)addr;
        nativeObject->resize(newSize);
    */
    private static native void resizeNATIVE(long addr, int newSize);

    public long getValuePointer() {
        return getValuePointerNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.CharArray);
        return nativeObject.getPointer();
    */
    /*[-C++;-NATIVE]
        CharArray* nativeObject = (CharArray*)addr;
        return (jlong)nativeObject->getPointer();
    */
    private static native long getValuePointerNATIVE(long addr);

    public void clear() {
        clearNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.CharArray);
        nativeObject.clear();
    */
    /*[-C++;-NATIVE]
        CharArray* nativeObject = (CharArray*)addr;
        nativeObject->clear();
    */
    private static native void clearNATIVE(long addr);

    public long getCPointer() {
        return cPointer;
    }

    public static void arraycopy(byte[] src,  int  srcPos,
                                 ImGuiByteArray dest, int destPos,
                                 int length) {
        int srcP = srcPos;
        int destP = destPos;
        int count = 0;
        while(count < length) {
            byte srcByte = src[srcP];
            srcP++;
            dest.setValue(destP, srcByte);
            destP++;
            count++;
        }
    }

    public static void arraycopy(ImGuiByteArray src,  int  srcPos,
                                 byte[] dest, int destPos,
                                 int length) {
        int srcP = srcPos;
        int destP = destPos;
        int count = 0;
        while(count < length) {
            byte srcByte = src.getValue(srcP);
            srcP++;
            dest[destP] = srcByte;
            destP++;
            count++;
        }
    }
}
