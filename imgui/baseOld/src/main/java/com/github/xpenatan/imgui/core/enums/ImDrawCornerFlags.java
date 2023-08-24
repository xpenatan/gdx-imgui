package com.github.xpenatan.imgui.core.enums;

public class ImDrawCornerFlags {
    private static ImDrawCornerFlags Custom = new ImDrawCornerFlags(0);
    public static ImDrawCornerFlags TopLeft = new ImDrawCornerFlags(ImDrawFlags.RoundCornersTopLeft.getValue());
    public static ImDrawCornerFlags TopRight = new ImDrawCornerFlags(ImDrawFlags.RoundCornersTopRight.getValue());
    public static ImDrawCornerFlags BotLeft = new ImDrawCornerFlags(ImDrawFlags.RoundCornersBottomLeft.getValue());
    public static ImDrawCornerFlags BotRight = new ImDrawCornerFlags(ImDrawFlags.RoundCornersBottomRight.getValue());
    public static ImDrawCornerFlags All = new ImDrawCornerFlags(ImDrawFlags.RoundCornersAll.getValue());
    public static ImDrawCornerFlags Top = new ImDrawCornerFlags(TopLeft.getValue() | TopRight.getValue());
    public static ImDrawCornerFlags Bot = new ImDrawCornerFlags(BotLeft.getValue() | BotRight.getValue());
    public static ImDrawCornerFlags Left = new ImDrawCornerFlags(TopLeft.getValue() | BotLeft.getValue());
    public static ImDrawCornerFlags Right = new ImDrawCornerFlags(TopRight.getValue() | BotRight.getValue());

    int value;

    private ImDrawCornerFlags(int code) {
        value = code;
    }

    public ImDrawCornerFlags or(ImDrawCornerFlags otherEnum) {
        ImDrawCornerFlags.Custom.value = value | otherEnum.value;
        return ImDrawCornerFlags.Custom;
    }

    public int getValue() {
        return value;
    }
}
