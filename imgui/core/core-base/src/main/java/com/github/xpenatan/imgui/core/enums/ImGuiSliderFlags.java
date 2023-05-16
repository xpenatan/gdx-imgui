package com.github.xpenatan.imgui.core.enums;

public class ImGuiSliderFlags {
    private static ImGuiSliderFlags Custom = new ImGuiSliderFlags(0);
    public static ImGuiSliderFlags None = new ImGuiSliderFlags(0);
    public static ImGuiSliderFlags AlwaysClamp = new ImGuiSliderFlags(1 << 4);
    public static ImGuiSliderFlags Logarithmic = new ImGuiSliderFlags(1 << 5);
    public static ImGuiSliderFlags NoRoundToFormat = new ImGuiSliderFlags(1 << 6);
    public static ImGuiSliderFlags NoInput = new ImGuiSliderFlags(1 << 7);

    int value;

    private ImGuiSliderFlags(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ImGuiSliderFlags or(ImGuiSliderFlags otherEnum) {
        ImGuiSliderFlags.Custom.value = value | otherEnum.value;
        return ImGuiSliderFlags.Custom;
    }
}