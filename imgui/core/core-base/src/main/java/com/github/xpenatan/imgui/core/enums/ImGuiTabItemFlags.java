package com.github.xpenatan.imgui.core.enums;

/**
 * Flags for ImGui::BeginTabItem()
 */
public class ImGuiTabItemFlags {
    private static ImGuiTabItemFlags Custom = new ImGuiTabItemFlags(0);
    public static ImGuiTabItemFlags None = new ImGuiTabItemFlags(0);
    public static ImGuiTabItemFlags UnsavedDocument = new ImGuiTabItemFlags(1 << 0);
    public static ImGuiTabItemFlags SetSelected = new ImGuiTabItemFlags(1 << 1);
    public static ImGuiTabItemFlags NoCloseWithMiddleMouseButton = new ImGuiTabItemFlags(1 << 2);
    public static ImGuiTabItemFlags NoPushId = new ImGuiTabItemFlags(1 << 3);
    public static ImGuiTabItemFlags NoTooltip = new ImGuiTabItemFlags(1 << 4);
    public static ImGuiTabItemFlags NoReorder = new ImGuiTabItemFlags(1 << 5);
    public static ImGuiTabItemFlags Leading = new ImGuiTabItemFlags(1 << 6);
    public static ImGuiTabItemFlags Trailing = new ImGuiTabItemFlags(1 << 7);

    int value;

    private ImGuiTabItemFlags(int code) {
        value = code;
    }

    public ImGuiTabItemFlags or(ImGuiTabItemFlags otherEnum) {
        ImGuiTabItemFlags.Custom.value = value | otherEnum.value;
        return ImGuiTabItemFlags.Custom;
    }

    public int getValue() {
        return value;
    }
}
