package imgui.gdx;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import imgui.ImGui;
import imgui.ImGuiFocusedFlags;
import imgui.ImGuiIO;
import imgui.ImGuiKey;

/**
 * ImGui use this class to update UI inputs. It will also block (return true) some inputs that is triggered inside ImGui window.
 *
 * @author xpenatan
 */
public class ImGuiGdxInput extends InputAdapter {

    static private final char DELETE = 127;
    static private final char ENTER = 10;

    boolean mouseDown0;
    boolean mouseDown1;
    boolean mouseDown2;

    private boolean wantCaptureMouse;

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        ImGuiIO io = ImGui.getIO();

        if(button == Buttons.LEFT)
            mouseDown0 = true;
        if(button == Buttons.RIGHT)
            mouseDown1 = true;
        if(button == Buttons.MIDDLE)
            mouseDown2 = true;
        ImGuiIO getIO = ImGui.getIO();
        wantCaptureMouse = getIO.getWantCaptureMouse();

        io.addMouseButtonEvent(button, true);

        if(wantCaptureMouse)
            return true;
        else {
            if(button == Buttons.RIGHT)
                ImGui.setWindowFocus(null);
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        ImGuiIO io = ImGui.getIO();
        io.addMousePosEvent(screenX, screenY);

        if(wantCaptureMouse)
            return true;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        ImGuiIO io = ImGui.getIO();
        if(button == Buttons.LEFT)
            mouseDown0 = false;
        if(button == Buttons.RIGHT)
            mouseDown1 = false;
        if(button == Buttons.MIDDLE)
            mouseDown2 = false;

        io.addMouseButtonEvent(button, false);
        wantCaptureMouse = false;
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        ImGuiIO io = ImGui.getIO();
        int charr = character;
        if((charr != DELETE && charr != ENTER)) // Ignore if char is delete key
            io.updateKeyTyped(character);
        if(ImGui.isWindowFocused(ImGuiFocusedFlags.ImGuiFocusedFlags_AnyWindow))
            return true;
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        ImGuiIO io = ImGui.getIO();

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
            io.addKeyEvent(ImGuiKey.ImGuiMod_Super, true);
        }
        else if(ctrlKey) {
            io.addKeyEvent(ImGuiKey.ImGuiMod_Ctrl, true);
        }
        else if(shiftKey) {
            io.addKeyEvent(ImGuiKey.ImGuiMod_Shift, true);
        }
        else if(altKey) {
            io.addKeyEvent(ImGuiKey.ImGuiMod_Alt, true);
        }

        io.addKeyEvent(imGuiKey, true);

        if(ImGui.isWindowFocused(ImGuiFocusedFlags.ImGuiFocusedFlags_AnyWindow))
            return true;
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        ImGuiIO io = ImGui.getIO();

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
            io.addKeyEvent(ImGuiKey.ImGuiMod_Super, false);
        }
        else if(ctrlKey) {
            io.addKeyEvent(ImGuiKey.ImGuiMod_Ctrl, false);
        }
        else if(shiftKey) {
            io.addKeyEvent(ImGuiKey.ImGuiMod_Shift, false);
        }
        else if(altKey) {
            io.addKeyEvent(ImGuiKey.ImGuiMod_Alt, false);
        }

        io.addKeyEvent(imGuiKey, false);

        if(ImGui.isWindowFocused(ImGuiFocusedFlags.ImGuiFocusedFlags_AnyWindow))
            return true;
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        ImGuiIO io = ImGui.getIO();
        io.addMousePosEvent(screenX, screenY);
        //Experimental. There is a issue with deltaX/Y having high numbers if input is block
//		if(ImGui.IsWindowFocused(ImGuiFocusedFlags.AnyWindow))
//			return true;
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        ImGuiIO io = ImGui.getIO();
        io.addMouseWheelEvent(amountX, -amountY);
        if(io.getWantCaptureMouse())
            return true;
        return false;
    }

    private static int getImGuiKey(int gdxKey) {
        switch(gdxKey) {
            case Keys.TAB:
                return ImGuiKey.ImGuiKey_Tab;
            case Keys.LEFT:
                return ImGuiKey.ImGuiKey_LeftArrow;
            case Keys.RIGHT:
                return ImGuiKey.ImGuiKey_RightArrow;
            case Keys.UP:
                return ImGuiKey.ImGuiKey_UpArrow;
            case Keys.DOWN:
                return ImGuiKey.ImGuiKey_DownArrow;
            case Keys.PAGE_UP:
                return ImGuiKey.ImGuiKey_PageUp;
            case Keys.PAGE_DOWN:
                return ImGuiKey.ImGuiKey_PageDown;
            case Keys.HOME:
                return ImGuiKey.ImGuiKey_Home;
            case Keys.END:
                return ImGuiKey.ImGuiKey_End;
            case Keys.INSERT:
                return ImGuiKey.ImGuiKey_Insert;
            case Keys.FORWARD_DEL:
                return ImGuiKey.ImGuiKey_Delete;
            case Keys.BACKSPACE:
                return ImGuiKey.ImGuiKey_Backspace;
            case Keys.SPACE:
                return ImGuiKey.ImGuiKey_Space;
            case Keys.ENTER:
                return ImGuiKey.ImGuiKey_Enter;
            case Keys.ESCAPE:
                return ImGuiKey.ImGuiKey_Escape;
            case Keys.APOSTROPHE:
                return ImGuiKey.ImGuiKey_Apostrophe;
            case Keys.COMMA:
                return ImGuiKey.ImGuiKey_Comma;
            case Keys.MINUS:
                return ImGuiKey.ImGuiKey_Minus;
            case Keys.PERIOD:
                return ImGuiKey.ImGuiKey_Period;
            case Keys.SLASH:
                return ImGuiKey.ImGuiKey_Slash;
            case Keys.SEMICOLON:
                return ImGuiKey.ImGuiKey_Semicolon;
            case Keys.EQUALS:
                return ImGuiKey.ImGuiKey_Equal;
            case Keys.LEFT_BRACKET:
                return ImGuiKey.ImGuiKey_LeftBracket;
            case Keys.BACKSLASH:
                return ImGuiKey.ImGuiKey_Backslash;
            case Keys.RIGHT_BRACKET:
                return ImGuiKey.ImGuiKey_RightBracket;
            case Keys.GRAVE:
                return ImGuiKey.ImGuiKey_GraveAccent;
            case Keys.CAPS_LOCK:
                return ImGuiKey.ImGuiKey_CapsLock;
            case Keys.SCROLL_LOCK:
                return ImGuiKey.ImGuiKey_ScrollLock;
            case Keys.NUM_LOCK:
                return ImGuiKey.ImGuiKey_NumLock;
            case Keys.PRINT_SCREEN:
                return ImGuiKey.ImGuiKey_PrintScreen;
            case Keys.PAUSE:
                return ImGuiKey.ImGuiKey_Pause;
            case Keys.NUMPAD_0:
                return ImGuiKey.ImGuiKey_Keypad0;
            case Keys.NUMPAD_1:
                return ImGuiKey.ImGuiKey_Keypad1;
            case Keys.NUMPAD_2:
                return ImGuiKey.ImGuiKey_Keypad2;
            case Keys.NUMPAD_3:
                return ImGuiKey.ImGuiKey_Keypad3;
            case Keys.NUMPAD_4:
                return ImGuiKey.ImGuiKey_Keypad4;
            case Keys.NUMPAD_5:
                return ImGuiKey.ImGuiKey_Keypad5;
            case Keys.NUMPAD_6:
                return ImGuiKey.ImGuiKey_Keypad6;
            case Keys.NUMPAD_7:
                return ImGuiKey.ImGuiKey_Keypad7;
            case Keys.NUMPAD_8:
                return ImGuiKey.ImGuiKey_Keypad8;
            case Keys.NUMPAD_9:
                return ImGuiKey.ImGuiKey_Keypad9;
            case Keys.NUMPAD_DOT:
                return ImGuiKey.ImGuiKey_KeypadDecimal;
            case Keys.NUMPAD_DIVIDE:
                return ImGuiKey.ImGuiKey_KeypadDivide;
            case Keys.NUMPAD_MULTIPLY:
                return ImGuiKey.ImGuiKey_KeypadMultiply;
            case Keys.NUMPAD_SUBTRACT:
                return ImGuiKey.ImGuiKey_KeypadSubtract;
            case Keys.NUMPAD_ADD:
                return ImGuiKey.ImGuiKey_KeypadAdd;
            case Keys.NUMPAD_ENTER:
                return ImGuiKey.ImGuiKey_KeypadEnter;
            case Keys.NUMPAD_EQUALS:
                return ImGuiKey.ImGuiKey_KeypadEqual;
            case Keys.SHIFT_LEFT:
                return ImGuiKey.ImGuiKey_LeftShift;
            case Keys.CONTROL_LEFT:
                return ImGuiKey.ImGuiKey_LeftCtrl;
            case Keys.ALT_LEFT:
                return ImGuiKey.ImGuiKey_LeftAlt;
            case Keys.SYM:
                return ImGuiKey.ImGuiKey_LeftSuper;
            case Keys.SHIFT_RIGHT:
                return ImGuiKey.ImGuiKey_RightShift;
            case Keys.CONTROL_RIGHT:
                return ImGuiKey.ImGuiKey_RightCtrl;
            case Keys.ALT_RIGHT:
                return ImGuiKey.ImGuiKey_RightAlt;
//			case Keys.SYM: return ImGuiKey.RightSuper;
            case Keys.MENU:
                return ImGuiKey.ImGuiKey_Menu;
            case Keys.NUM_0:
                return ImGuiKey.ImGuiKey_0;
            case Keys.NUM_1:
                return ImGuiKey.ImGuiKey_1;
            case Keys.NUM_2:
                return ImGuiKey.ImGuiKey_2;
            case Keys.NUM_3:
                return ImGuiKey.ImGuiKey_3;
            case Keys.NUM_4:
                return ImGuiKey.ImGuiKey_4;
            case Keys.NUM_5:
                return ImGuiKey.ImGuiKey_5;
            case Keys.NUM_6:
                return ImGuiKey.ImGuiKey_6;
            case Keys.NUM_7:
                return ImGuiKey.ImGuiKey_7;
            case Keys.NUM_8:
                return ImGuiKey.ImGuiKey_8;
            case Keys.NUM_9:
                return ImGuiKey.ImGuiKey_9;
            case Keys.A:
                return ImGuiKey.ImGuiKey_A;
            case Keys.B:
                return ImGuiKey.ImGuiKey_B;
            case Keys.C:
                return ImGuiKey.ImGuiKey_C;
            case Keys.D:
                return ImGuiKey.ImGuiKey_D;
            case Keys.E:
                return ImGuiKey.ImGuiKey_E;
            case Keys.F:
                return ImGuiKey.ImGuiKey_F;
            case Keys.G:
                return ImGuiKey.ImGuiKey_G;
            case Keys.H:
                return ImGuiKey.ImGuiKey_H;
            case Keys.I:
                return ImGuiKey.ImGuiKey_I;
            case Keys.J:
                return ImGuiKey.ImGuiKey_J;
            case Keys.K:
                return ImGuiKey.ImGuiKey_K;
            case Keys.L:
                return ImGuiKey.ImGuiKey_L;
            case Keys.M:
                return ImGuiKey.ImGuiKey_M;
            case Keys.N:
                return ImGuiKey.ImGuiKey_N;
            case Keys.O:
                return ImGuiKey.ImGuiKey_O;
            case Keys.P:
                return ImGuiKey.ImGuiKey_P;
            case Keys.Q:
                return ImGuiKey.ImGuiKey_Q;
            case Keys.R:
                return ImGuiKey.ImGuiKey_R;
            case Keys.S:
                return ImGuiKey.ImGuiKey_S;
            case Keys.T:
                return ImGuiKey.ImGuiKey_T;
            case Keys.U:
                return ImGuiKey.ImGuiKey_U;
            case Keys.V:
                return ImGuiKey.ImGuiKey_V;
            case Keys.W:
                return ImGuiKey.ImGuiKey_W;
            case Keys.X:
                return ImGuiKey.ImGuiKey_X;
            case Keys.Y:
                return ImGuiKey.ImGuiKey_Y;
            case Keys.Z:
                return ImGuiKey.ImGuiKey_Z;
            case Keys.F1:
                return ImGuiKey.ImGuiKey_F1;
            case Keys.F2:
                return ImGuiKey.ImGuiKey_F2;
            case Keys.F3:
                return ImGuiKey.ImGuiKey_F3;
            case Keys.F4:
                return ImGuiKey.ImGuiKey_F4;
            case Keys.F5:
                return ImGuiKey.ImGuiKey_F5;
            case Keys.F6:
                return ImGuiKey.ImGuiKey_F6;
            case Keys.F7:
                return ImGuiKey.ImGuiKey_F7;
            case Keys.F8:
                return ImGuiKey.ImGuiKey_F8;
            case Keys.F9:
                return ImGuiKey.ImGuiKey_F9;
            case Keys.F10:
                return ImGuiKey.ImGuiKey_F10;
            case Keys.F11:
                return ImGuiKey.ImGuiKey_F11;
            case Keys.F12:
                return ImGuiKey.ImGuiKey_F12;
            default:
                return ImGuiKey.ImGuiKey_None;
        }
    }
}