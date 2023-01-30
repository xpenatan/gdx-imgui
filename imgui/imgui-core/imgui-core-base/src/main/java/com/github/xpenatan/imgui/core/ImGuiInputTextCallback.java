package com.github.xpenatan.imgui.core;

import com.github.xpenatan.imgui.core.enums.ImGuiInputTextFlags;

public class ImGuiInputTextCallback {
    private int onInputTextChange(long callbackDataAddr) {
        ImGuiInputTextCallbackData data = ImGuiInputTextCallbackData.TMP_EMPTY;
        data.setPointer(callbackDataAddr);
        int flags = data.getFlags();
        if(flags == ImGuiInputTextFlags.CallbackResize.getValue()) {
            int bufSize = data.getBufSize();
            int bufTextLen = data.getBufTextLen();
            int length = data.imGuiString.getData().length;
            if(bufSize > length) {
                int newSize = bufSize + 10;
                data.imGuiString.resizeBuffer(newSize);
                byte[] stringData = data.imGuiString.getData();
                data.setBuf(stringData);
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
