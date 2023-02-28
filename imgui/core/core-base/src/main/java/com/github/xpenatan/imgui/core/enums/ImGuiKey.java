package com.github.xpenatan.imgui.core.enums;

/**
 * User fill ImGuiIO.KeyMap[] array with indices into the ImGuiIO.KeysDown[512] array
 */
public class ImGuiKey {
    private static int ID = 512;

    // Keyboard
    public static int None = 0,
            Tab = ID++,             // == ImGuiKey_NamedKey_BEGIN
            LeftArrow = ID++,
            RightArrow = ID++,
            UpArrow = ID++,
            DownArrow = ID++,
            PageUp = ID++,
            PageDown = ID++,
            Home = ID++,
            End = ID++,
            Insert = ID++,
            Delete = ID++,
            Backspace = ID++,
            Space = ID++,
            Enter = ID++,
            Escape = ID++,
            LeftCtrl = ID++,
            LeftShift = ID++,
            LeftAlt = ID++,
            LeftSuper = ID++,
            RightCtrl = ID++,
            RightShift = ID++,
            RightAlt = ID++,
            RightSuper = ID++,
            Menu = ID++,
            NUM_0 = ID++, NUM_1 = ID++, NUM_2 = ID++, NUM_3 = ID++, NUM_4 = ID++, NUM_5 = ID++, NUM_6 = ID++, NUM_7 = ID++, NUM_8 = ID++, NUM_9 = ID++,
            A = ID++, B = ID++, C = ID++, D = ID++, E = ID++, F = ID++, G = ID++, H = ID++, I = ID++, J = ID++,
            K = ID++, L = ID++, M = ID++, N = ID++, O = ID++, P = ID++, Q = ID++, R = ID++, S = ID++, T = ID++,
            U = ID++, V = ID++, W = ID++, X = ID++, Y = ID++, Z = ID++,
            F1 = ID++, F2 = ID++, F3 = ID++, F4 = ID++, F5 = ID++, F6 = ID++,
            F7 = ID++, F8 = ID++, F9 = ID++, F10 = ID++, F11 = ID++, F12 = ID++,
            Apostrophe = ID++,        // '
            Comma = ID++,             // ,
            Minus = ID++,             // -
            Period = ID++,            // .
            Slash = ID++,             // /
            Semicolon = ID++,         // ;
            Equal = ID++,             // =
            LeftBracket = ID++,       // [
            Backslash = ID++,         // \ (this text inhibit multiline comment caused by backslash)
            RightBracket = ID++,      // ]
            GraveAccent = ID++,       // `
            CapsLock = ID++,
            ScrollLock = ID++,
            NumLock = ID++,
            PrintScreen = ID++,
            Pause = ID++,
            Keypad0 = ID++, Keypad1 = ID++, Keypad2 = ID++, Keypad3 = ID++, Keypad4 = ID++,
            Keypad5 = ID++, Keypad6 = ID++, Keypad7 = ID++, Keypad8 = ID++, Keypad9 = ID++,
            KeypadDecimal = ID++,
            KeypadDivide = ID++,
            KeypadMultiply = ID++,
            KeypadSubtract = ID++,
            KeypadAdd = ID++,
            KeypadEnter = ID++,
            KeypadEqual = ID++,
            GamepadStart = ID++,          // Menu (Xbox)          + (Switch)   Start/Options (PS) // --
            GamepadBack = ID++,           // View (Xbox)          - (Switch)   Share (PS)         // --
            GamepadFaceUp = ID++,         // Y (Xbox)             X (Switch)   Triangle (PS)      // -> ImGuiNavInput_Input
            GamepadFaceDown = ID++,       // A (Xbox)             B (Switch)   Cross (PS)         // -> ImGuiNavInput_Activate
            GamepadFaceLeft = ID++,       // X (Xbox)             Y (Switch)   Square (PS)        // -> ImGuiNavInput_Menu
            GamepadFaceRight = ID++,      // B (Xbox)             A (Switch)   Circle (PS)        // -> ImGuiNavInput_Cancel
            GamepadDpadUp = ID++,         // D-pad Up                                             // -> ImGuiNavInput_DpadUp
            GamepadDpadDown = ID++,       // D-pad Down                                           // -> ImGuiNavInput_DpadDown
            GamepadDpadLeft = ID++,       // D-pad Left                                           // -> ImGuiNavInput_DpadLeft
            GamepadDpadRight = ID++,      // D-pad Right                                          // -> ImGuiNavInput_DpadRight
            GamepadL1 = ID++,             // L Bumper (Xbox)      L (Switch)   L1 (PS)            // -> ImGuiNavInput_FocusPrev + ImGuiNavInput_TweakSlow
            GamepadR1 = ID++,             // R Bumper (Xbox)      R (Switch)   R1 (PS)            // -> ImGuiNavInput_FocusNext + ImGuiNavInput_TweakFast
            GamepadL2 = ID++,             // L Trigger (Xbox)     ZL (Switch)  L2 (PS) [Analog]
            GamepadR2 = ID++,             // R Trigger (Xbox)     ZR (Switch)  R2 (PS) [Analog]
            GamepadL3 = ID++,             // L Thumbstick (Xbox)  L3 (Switch)  L3 (PS)
            GamepadR3 = ID++,             // R Thumbstick (Xbox)  R3 (Switch)  R3 (PS)
            GamepadLStickLeft = ID++,     // [Analog]                                             // -> ImGuiNavInput_LStickLeft
            GamepadLStickRight = ID++,    // [Analog]                                             // -> ImGuiNavInput_LStickRight
            GamepadLStickUp = ID++,       // [Analog]                                             // -> ImGuiNavInput_LStickUp
            GamepadLStickDown = ID++,     // [Analog]                                             // -> ImGuiNavInput_LStickDown
            GamepadRStickLeft = ID++,     // [Analog]
            GamepadRStickRight = ID++,    // [Analog]
            GamepadRStickUp = ID++,       // [Analog]
            GamepadRStickDown = ID++,     // [Analog]
            MouseLeft = ID++,
            MouseRight = ID++,
            MouseMiddle = ID++,
            MouseX1 = ID++,
            MouseX2 = ID++,
            MouseWheelX = ID++,
            MouseWheelY = ID++,
            COUNT = 652,                 // No valid ImGuiKey is ever greater than this value
            ModNone = 0,
            ModCtrl = 1 << 12,
            ModShift = 1 << 13,
            ModAlt = 1 << 14,
            ModSuper = 1 << 15,
            ModMask = 0xF000;

    private final int code;

    private ImGuiKey(int code) {
        this.code = code;
    }

    public int getValue() {
        return code;
    }
}
