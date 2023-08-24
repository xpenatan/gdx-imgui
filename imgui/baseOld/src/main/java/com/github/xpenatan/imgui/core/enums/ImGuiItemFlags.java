package com.github.xpenatan.imgui.core.enums;

/**
 * Flags for ImGui::PushItemFlag(...)
 */
public class ImGuiItemFlags {
    private static ImGuiItemFlags Custom = new ImGuiItemFlags(0);

    public static ImGuiItemFlags None = new ImGuiItemFlags(0);
    public static ImGuiItemFlags NoTabStop = new ImGuiItemFlags(1 << 0);  // false     // Disable keyboard tabbing (FIXME: should merge with _NoNav)
    public static ImGuiItemFlags ButtonRepeat = new ImGuiItemFlags(1 << 1);  // false     // Button() will return true multiple times based on io.KeyRepeatDelay and io.KeyRepeatRate settings.
    public static ImGuiItemFlags Disabled = new ImGuiItemFlags(1 << 2);  // false     // Disable interactions but doesn't affect visuals. See BeginDisabled()/EndDisabled(). See github.com/ocornut/imgui/issues/211
    public static ImGuiItemFlags NoNav = new ImGuiItemFlags(1 << 3);  // false     // Disable keyboard/gamepad directional navigation (FIXME: should merge with _NoTabStop)
    public static ImGuiItemFlags NoNavDefaultFocus = new ImGuiItemFlags(1 << 4);  // false     // Disable item being a candidate for default focus (e.g. used by title bar items)
    public static ImGuiItemFlags SelectableDontClosePopup = new ImGuiItemFlags(1 << 5);  // false     // Disable MenuItem/Selectable() automatically closing their popup window
    public static ImGuiItemFlags MixedValue = new ImGuiItemFlags(1 << 6);  // false     // [BETA] Represent a mixed/indeterminate value, generally multi-selection where values differ. Currently only supported by Checkbox() (later should support all sorts of widgets)
    public static ImGuiItemFlags ReadOnly = new ImGuiItemFlags(1 << 7);  // false     // [ALPHA] Allow hovering interactions but underlying value is not changed.
    public static ImGuiItemFlags Inputable = new ImGuiItemFlags(1 << 8);   // false     // [WIP] Auto-activate item when focused. Currently only used and supported by a few items before it becomes a generic feature.

    int value;

    private ImGuiItemFlags(int code) {
        value = code;
    }

    public ImGuiItemFlags or(ImGuiItemFlags otherEnum) {
        ImGuiItemFlags.Custom.value = value | otherEnum.value;
        return ImGuiItemFlags.Custom;
    }

    public int getValue() {
        return value;
    }
}
