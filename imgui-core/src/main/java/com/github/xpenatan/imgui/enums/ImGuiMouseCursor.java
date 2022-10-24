package com.github.xpenatan.imgui.enums;

/**
 * Enumeration for GetMouseCursor()
 * User code may request binding to display given cursor by calling SetMouseCursor(), which is why we have some cursors that are marked unused here
 */
public enum ImGuiMouseCursor {
    None(-1),
    Arrow(0),
    TextInput(1),
    ResizeAll(2),
    ResizeNS(3),
    ResizeEW(4),
    ResizeNESW(5),
    ResizeNWSE(6),
    Hand(7),
    NotAllowed(8),
    COUNT(9);

    int value;

    private ImGuiMouseCursor(int code) {
        value = code;
    }

    public int getValue() {
        return value;
    }
}
