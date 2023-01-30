package com.github.xpenatan.imgui.core;

public class ImGuiInputTextCallbackData extends ImGuiBase {

    /*[-C++;-NATIVE]
        #include "imgui.h"
    */

    public ImGuiString imGuiString = null;

    public static ImGuiInputTextCallbackData TMP_EMPTY = new ImGuiInputTextCallbackData(false);

    public ImGuiInputTextCallbackData(boolean cMemoryOwn) {
    }

    public byte[] getBuf() {
        return getBufNATIVE(getCPointer());
    }

    //TODO teavm

    /*[-C++;-NATIVE]
        ImGuiInputTextCallbackData* nativeObject = (ImGuiInputTextCallbackData*)addr;
        jbyteArray Array = env->NewByteArray(nativeObject->BufSize);
        env->SetByteArrayRegion(Array, 0, nativeObject->BufSize, (jbyte*)nativeObject->Buf);
        return Array;
    */
    private static native byte[] getBufNATIVE(long addr);

    public void setBuf(byte[] buf) {
        setBufNATIVE(getCPointer(), buf);
    }

    //TODO teavm

    /*[-C++;-NATIVE]
        ImGuiInputTextCallbackData* nativeObject = (ImGuiInputTextCallbackData*)addr;
        nativeObject->Buf = buf;
    */
    private static native void setBufNATIVE(long addr, byte[] buf);

    public int getBufSize() {
        return getBufSizeNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiInputTextCallbackData);
        return nativeObject.get_BufSize();
    */
    /*[-C++;-NATIVE]
        ImGuiInputTextCallbackData* nativeObject = (ImGuiInputTextCallbackData*)addr;
        return nativeObject->BufSize;
    */
    private static native int getBufSizeNATIVE(long addr);

    public boolean getBufDirty() {
        return BufDirtyNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiInputTextCallbackData);
        return nativeObject.get_BufDirty();
    */
    /*[-C++;-NATIVE]
        ImGuiInputTextCallbackData* nativeObject = (ImGuiInputTextCallbackData*)addr;
        return nativeObject->BufDirty;
    */
    private static native boolean BufDirtyNATIVE(long addr);

    public int getBufTextLen() {
        return getBufTextLenNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiInputTextCallbackData);
        return nativeObject.get_BufTextLen();
    */
    /*[-C++;-NATIVE]
        ImGuiInputTextCallbackData* nativeObject = (ImGuiInputTextCallbackData*)addr;
        return nativeObject->BufTextLen;
    */
    private static native int getBufTextLenNATIVE(long addr);

    public int getFlags() {
        return getFlagsNATIVE(getCPointer());
    }

    /*[-teaVM;-NATIVE]
        var nativeObject = ImGui.wrapPointer(addr, ImGui.ImGuiInputTextCallbackData);
        return nativeObject.get_Flags();
    */
    /*[-C++;-NATIVE]
        ImGuiInputTextCallbackData* nativeObject = (ImGuiInputTextCallbackData*)addr;
        return nativeObject->Flags;
    */
    private static native int getFlagsNATIVE(long addr);

}
