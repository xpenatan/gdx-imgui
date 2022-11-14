package com.github.xpenatan.imgui.core;

import com.badlogic.gdx.utils.SharedLibraryLoader;

public class ImGui {

    private static boolean IMGUI_INIT = false;

    public static void init() {
        init(true);
    }

    public static void init(boolean saveIni) {
        if(ImGui.IMGUI_INIT)
            return;
        ImGui.IMGUI_INIT = true;
        SharedLibraryLoader loader = new SharedLibraryLoader();
        loader.load("imgui-cpp");
        loader.load("imgui-core");
    }

    public static void dispose() {

    }

    /*[-teaVM;-NATIVE]
        var value = testValue;
        value++;
        return value;
     */
    /*[-cpp;-NATIVE]
        int value = testValue;
        value++;
        return value;
     */
    static public native int TestNative(int testValue);
}