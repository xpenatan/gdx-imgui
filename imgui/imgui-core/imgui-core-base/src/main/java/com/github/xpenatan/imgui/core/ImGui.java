package com.github.xpenatan.imgui.core;

public class ImGui {

    /*[-cpp;-NATIVE]
        int value = testValue;
        value++;
        return value;
     */
    static public native int TestNative(int testValue);
}