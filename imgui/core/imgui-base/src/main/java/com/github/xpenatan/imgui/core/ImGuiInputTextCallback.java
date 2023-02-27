package com.github.xpenatan.imgui.core;

import com.github.xpenatan.imgui.core.enums.ImGuiInputTextFlags;
import com.github.xpenatan.imgui.core.jnicode.ImGuiEditTextNative;

public class ImGuiInputTextCallback implements ImGuiEditTextNative.InputTextCallback {

    /*[-teaVM;-REPLACE]
    public int onInputTextChange(int callbackDataAddr) {
        ImGuiInputTextCallbackData data = ImGuiInputTextCallbackData.TMP_EMPTY;
        data.setPointer(callbackDataAddr);
        int flags = data.getFlags();
        if(flags == ImGuiInputTextFlags.CallbackResize.getValue()) {
            int bufSize = data.getBufSize();
            int bufTextLen = data.getBufTextLen();
            int length = data.imGuiString.data.getSize();
            if(bufSize > length) {
                int newSize = bufSize + 10;
                data.imGuiString.resizeBuffer(newSize);
                data.setBuf(data.imGuiString.data);
            }
            data.imGuiString.size = bufTextLen;
            data.imGuiString.isDirty = true;
        }
        return onInputTextChange(data);
    }
    */
    public int onInputTextChange(long callbackDataAddr) {
        ImGuiInputTextCallbackData data = ImGuiInputTextCallbackData.TMP_EMPTY;
        data.setPointer(callbackDataAddr);
        int flags = data.getFlags();
        if(flags == ImGuiInputTextFlags.CallbackResize.getValue()) {
            int bufSize = data.getBufSize();
            int bufTextLen = data.getBufTextLen();
            int length = data.imGuiString.data.getSize();
            if(bufSize > length) {
                int newSize = bufSize + 10;
                data.imGuiString.resizeBuffer(newSize);
                data.setBuf(data.imGuiString.data);
            }
            data.imGuiString.size = bufTextLen;
            data.imGuiString.isDirty = true;
        }
        return onInputTextChange(data);
    }
    public int onInputTextChange(ImGuiInputTextCallbackData data) {
        return 0;
    }
}
