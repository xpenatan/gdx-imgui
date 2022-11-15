package com.github.xpenatan.imgui.gdx;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.github.xpenatan.imgui.core.ImGui;
import com.github.xpenatan.imgui.core.ImGuiIO;
import com.github.xpenatan.imgui.core.enums.ImGuiFocusedFlags;
import com.github.xpenatan.imgui.core.enums.ImGuiKey;

/**
 * ImGui use this class to update UI inputs. It will also block (return true) some inputs that is triggered inside ImGui window.
 *
 * @author xpenatan
 */
public class ImGuiGdxInput implements InputProcessor {

    static private final char DELETE = 127;

    boolean mouseDown0;
    boolean mouseDown1;
    boolean mouseDown2;

    private boolean wantCaptureMouse;

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(button == Buttons.LEFT)
            mouseDown0 = true;
        if(button == Buttons.RIGHT)
            mouseDown1 = true;
        if(button == Buttons.MIDDLE)
            mouseDown2 = true;
        ImGuiIO getIO = ImGui.GetIO();
        wantCaptureMouse = getIO.WantCaptureMouse;

        ImGui.AddMouseButtonEvent(button, true);

        if(wantCaptureMouse)
            return true;
        else {
            if(button == Buttons.RIGHT)
                ImGui.SetWindowFocus(null);
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        ImGui.AddMousePosEvent(screenX, screenY);

        if(wantCaptureMouse)
            return true;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(button == Buttons.LEFT)
            mouseDown0 = false;
        if(button == Buttons.RIGHT)
            mouseDown1 = false;
        if(button == Buttons.MIDDLE)
            mouseDown2 = false;

        ImGui.AddMouseButtonEvent(button, false);
        wantCaptureMouse = false;
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        int charr = character;
        if(charr != DELETE) // Ignore if char is delete key
            ImGui.UpdateKeyTyped(character);
        if(ImGui.IsWindowFocused(ImGuiFocusedFlags.AnyWindow))
            return true;
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        boolean ctrlKey = false;
        boolean shiftKey = false;
        boolean altKey = false;
        boolean superKey = false;

        if(keycode == Keys.CONTROL_LEFT || keycode == Keys.CONTROL_RIGHT)
            ctrlKey = true;
        if(keycode == Keys.SHIFT_LEFT || keycode == Keys.SHIFT_RIGHT)
            shiftKey = true;
        if(keycode == Keys.ALT_LEFT || keycode == Keys.ALT_RIGHT)
            altKey = true;
        if(keycode == Keys.SYM)
            superKey = true;
        int imGuiKey = getImGuiKey(keycode);
        if(superKey) {
            ImGui.AddKeyEvent(ImGuiKey.ModSuper, true);
        }
        else if(ctrlKey) {
            ImGui.AddKeyEvent(ImGuiKey.ModCtrl, true);
        }
        else if(shiftKey) {
            ImGui.AddKeyEvent(ImGuiKey.ModShift, true);
        }
        else if(altKey) {
            ImGui.AddKeyEvent(ImGuiKey.ModAlt, true);
        }

        ImGui.AddKeyEvent(imGuiKey, true);

        if(ImGui.IsWindowFocused(ImGuiFocusedFlags.AnyWindow))
            return true;
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        boolean ctrlKey = false;
        boolean shiftKey = false;
        boolean altKey = false;
        boolean superKey = false;

        if(keycode == Keys.CONTROL_LEFT || keycode == Keys.CONTROL_RIGHT)
            ctrlKey = true;
        if(keycode == Keys.SHIFT_LEFT || keycode == Keys.SHIFT_RIGHT)
            shiftKey = true;
        if(keycode == Keys.ALT_LEFT || keycode == Keys.ALT_RIGHT)
            altKey = true;
        if(keycode == Keys.SYM)
            superKey = true;
        int imGuiKey = getImGuiKey(keycode);
        if(superKey) {
            ImGui.AddKeyEvent(ImGuiKey.ModSuper, false);
        }
        else if(ctrlKey) {
            ImGui.AddKeyEvent(ImGuiKey.ModCtrl, false);
        }
        else if(shiftKey) {
            ImGui.AddKeyEvent(ImGuiKey.ModShift, false);
        }
        else if(altKey) {
            ImGui.AddKeyEvent(ImGuiKey.ModAlt, false);
        }

        ImGui.AddKeyEvent(imGuiKey, false);

        if(ImGui.IsWindowFocused(ImGuiFocusedFlags.AnyWindow))
            return true;
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {

        ImGui.AddMousePosEvent(screenX, screenY);
        //Experimental. There is a issue with deltaX/Y having high numbers if input is block
//		if(ImGui.IsWindowFocused(ImGuiFocusedFlags.AnyWindow))
//			return true;
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        ImGui.AddMouseWheelEvent(amountX, -amountY);
        ImGuiIO getIO = ImGui.GetIO();
        if(getIO.WantCaptureMouse)
            return true;
        return false;
    }

    private static int getImGuiKey(int gdxKey) {
        switch(gdxKey) {
            case Keys.TAB:
                return ImGuiKey.Tab;
            case Keys.LEFT:
                return ImGuiKey.LeftArrow;
            case Keys.RIGHT:
                return ImGuiKey.RightArrow;
            case Keys.UP:
                return ImGuiKey.UpArrow;
            case Keys.DOWN:
                return ImGuiKey.DownArrow;
            case Keys.PAGE_UP:
                return ImGuiKey.PageUp;
            case Keys.PAGE_DOWN:
                return ImGuiKey.PageDown;
            case Keys.HOME:
                return ImGuiKey.Home;
            case Keys.END:
                return ImGuiKey.End;
            case Keys.INSERT:
                return ImGuiKey.Insert;
            case Keys.FORWARD_DEL:
                return ImGuiKey.Delete;
            case Keys.BACKSPACE:
                return ImGuiKey.Backspace;
            case Keys.SPACE:
                return ImGuiKey.Space;
            case Keys.ENTER:
                return ImGuiKey.Enter;
            case Keys.ESCAPE:
                return ImGuiKey.Escape;
            case Keys.APOSTROPHE:
                return ImGuiKey.Apostrophe;
            case Keys.COMMA:
                return ImGuiKey.Comma;
            case Keys.MINUS:
                return ImGuiKey.Minus;
            case Keys.PERIOD:
                return ImGuiKey.Period;
            case Keys.SLASH:
                return ImGuiKey.Slash;
            case Keys.SEMICOLON:
                return ImGuiKey.Semicolon;
            case Keys.EQUALS:
                return ImGuiKey.Equal;
            case Keys.LEFT_BRACKET:
                return ImGuiKey.LeftBracket;
            case Keys.BACKSLASH:
                return ImGuiKey.Backslash;
            case Keys.RIGHT_BRACKET:
                return ImGuiKey.RightBracket;
            case Keys.GRAVE:
                return ImGuiKey.GraveAccent;
            case Keys.CAPS_LOCK:
                return ImGuiKey.CapsLock;
            case Keys.SCROLL_LOCK:
                return ImGuiKey.ScrollLock;
            case Keys.NUM_LOCK:
                return ImGuiKey.NumLock;
            case Keys.PRINT_SCREEN:
                return ImGuiKey.PrintScreen;
            case Keys.PAUSE:
                return ImGuiKey.Pause;
            case Keys.NUMPAD_0:
                return ImGuiKey.Keypad0;
            case Keys.NUMPAD_1:
                return ImGuiKey.Keypad1;
            case Keys.NUMPAD_2:
                return ImGuiKey.Keypad2;
            case Keys.NUMPAD_3:
                return ImGuiKey.Keypad3;
            case Keys.NUMPAD_4:
                return ImGuiKey.Keypad4;
            case Keys.NUMPAD_5:
                return ImGuiKey.Keypad5;
            case Keys.NUMPAD_6:
                return ImGuiKey.Keypad6;
            case Keys.NUMPAD_7:
                return ImGuiKey.Keypad7;
            case Keys.NUMPAD_8:
                return ImGuiKey.Keypad8;
            case Keys.NUMPAD_9:
                return ImGuiKey.Keypad9;
            case Keys.NUMPAD_DOT:
                return ImGuiKey.KeypadDecimal;
            case Keys.NUMPAD_DIVIDE:
                return ImGuiKey.KeypadDivide;
            case Keys.NUMPAD_MULTIPLY:
                return ImGuiKey.KeypadMultiply;
            case Keys.NUMPAD_SUBTRACT:
                return ImGuiKey.KeypadSubtract;
            case Keys.NUMPAD_ADD:
                return ImGuiKey.KeypadAdd;
            case Keys.NUMPAD_ENTER:
                return ImGuiKey.KeypadEnter;
            case Keys.NUMPAD_EQUALS:
                return ImGuiKey.KeypadEqual;
            case Keys.SHIFT_LEFT:
                return ImGuiKey.LeftShift;
            case Keys.CONTROL_LEFT:
                return ImGuiKey.LeftCtrl;
            case Keys.ALT_LEFT:
                return ImGuiKey.LeftAlt;
            case Keys.SYM:
                return ImGuiKey.LeftSuper;
            case Keys.SHIFT_RIGHT:
                return ImGuiKey.RightShift;
            case Keys.CONTROL_RIGHT:
                return ImGuiKey.RightCtrl;
            case Keys.ALT_RIGHT:
                return ImGuiKey.RightAlt;
//			case Keys.SYM: return ImGuiKey.RightSuper;
            case Keys.MENU:
                return ImGuiKey.Menu;
            case Keys.NUM_0:
                return ImGuiKey.NUM_0;
            case Keys.NUM_1:
                return ImGuiKey.NUM_1;
            case Keys.NUM_2:
                return ImGuiKey.NUM_2;
            case Keys.NUM_3:
                return ImGuiKey.NUM_3;
            case Keys.NUM_4:
                return ImGuiKey.NUM_4;
            case Keys.NUM_5:
                return ImGuiKey.NUM_5;
            case Keys.NUM_6:
                return ImGuiKey.NUM_6;
            case Keys.NUM_7:
                return ImGuiKey.NUM_7;
            case Keys.NUM_8:
                return ImGuiKey.NUM_8;
            case Keys.NUM_9:
                return ImGuiKey.NUM_9;
            case Keys.A:
                return ImGuiKey.A;
            case Keys.B:
                return ImGuiKey.B;
            case Keys.C:
                return ImGuiKey.C;
            case Keys.D:
                return ImGuiKey.D;
            case Keys.E:
                return ImGuiKey.E;
            case Keys.F:
                return ImGuiKey.F;
            case Keys.G:
                return ImGuiKey.G;
            case Keys.H:
                return ImGuiKey.H;
            case Keys.I:
                return ImGuiKey.I;
            case Keys.J:
                return ImGuiKey.J;
            case Keys.K:
                return ImGuiKey.K;
            case Keys.L:
                return ImGuiKey.L;
            case Keys.M:
                return ImGuiKey.M;
            case Keys.N:
                return ImGuiKey.N;
            case Keys.O:
                return ImGuiKey.O;
            case Keys.P:
                return ImGuiKey.P;
            case Keys.Q:
                return ImGuiKey.Q;
            case Keys.R:
                return ImGuiKey.R;
            case Keys.S:
                return ImGuiKey.S;
            case Keys.T:
                return ImGuiKey.T;
            case Keys.U:
                return ImGuiKey.U;
            case Keys.V:
                return ImGuiKey.V;
            case Keys.W:
                return ImGuiKey.W;
            case Keys.X:
                return ImGuiKey.X;
            case Keys.Y:
                return ImGuiKey.Y;
            case Keys.Z:
                return ImGuiKey.Z;
            case Keys.F1:
                return ImGuiKey.F1;
            case Keys.F2:
                return ImGuiKey.F2;
            case Keys.F3:
                return ImGuiKey.F3;
            case Keys.F4:
                return ImGuiKey.F4;
            case Keys.F5:
                return ImGuiKey.F5;
            case Keys.F6:
                return ImGuiKey.F6;
            case Keys.F7:
                return ImGuiKey.F7;
            case Keys.F8:
                return ImGuiKey.F8;
            case Keys.F9:
                return ImGuiKey.F9;
            case Keys.F10:
                return ImGuiKey.F10;
            case Keys.F11:
                return ImGuiKey.F11;
            case Keys.F12:
                return ImGuiKey.F12;
            default:
                return ImGuiKey.None;
        }
    }
}
