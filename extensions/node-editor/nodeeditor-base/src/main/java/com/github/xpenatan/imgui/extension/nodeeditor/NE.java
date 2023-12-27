package com.github.xpenatan.imgui.extension.nodeeditor;

import com.github.xpenatan.jparser.loader.JParserLibraryLoader;

public class NE {

    private static boolean IMGUI_INIT = false;

    public static void init() {
        init(true);
    }

    public static void init(boolean saveIni) {
        if(NE.IMGUI_INIT)
            return;
        NE.IMGUI_INIT = true;
        loadNative();
    }

    private static void loadNative() {
        JParserLibraryLoader loader = new JParserLibraryLoader();
        String libCPP = "imgui-cpp";
        String libCore = "imgui-node-editore";
        loader.load(libCPP, libCore);
    }

    public static void dispose() {
//        ImGuiNative.DestroyContext();
    }

    protected NE() {
    }

//    public static ImGuiIO GetIO() {
//        imguiIO.setPointer(ImGuiNative.getIONATIVE());
//        return imguiIO;
//    }

}