package com.xpenatan.imgui.gdx;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;
import com.xpenatan.imgui.ImGui;
import com.xpenatan.imgui.ImGuiIO;
import com.xpenatan.imgui.enums.ImGuiFocusedFlags;

/**
 * ImGui use this class to update UI inputs. It will also block (return true) some inputs that is triggered inside ImGui window.
 *
 * @author xpenatan
 */
public class ImGuiGdxInput implements InputProcessor {

	static private final char DELETE = 127;

	boolean ctrlKey = false;
	boolean shiftKey = false;
	boolean altKey = false;
	boolean superKey = false;

	boolean mouseDown0;
	boolean mouseDown1;
	boolean mouseDown2;

	private boolean wantCaptureMouse;

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(button == Buttons.LEFT)
			mouseDown0 =  true;
		if(button == Buttons.RIGHT)
			mouseDown1 = true;
		if(button == Buttons.MIDDLE)
			mouseDown2 = true;
		ImGuiIO getIO = ImGui.GetIO();
		wantCaptureMouse = getIO.WantCaptureMouse;

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
		if(wantCaptureMouse)
			return true;
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if(button == Buttons.LEFT)
			mouseDown0 =  false;
		if(button == Buttons.RIGHT)
			mouseDown1 = false;
		if(button == Buttons.MIDDLE)
			mouseDown2 = false;
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
		if(keycode == Keys.CONTROL_LEFT || keycode == Keys.CONTROL_RIGHT)
			ctrlKey = true;
		if(keycode == Keys.SHIFT_LEFT || keycode == Keys.SHIFT_RIGHT)
			shiftKey = true;
		if(keycode == Keys.ALT_LEFT || keycode == Keys.ALT_RIGHT)
			altKey = true;
		if(keycode == Keys.SYM)
			superKey = true;
		ImGui.UpdateKey(keycode, true, false, ctrlKey, shiftKey, altKey, superKey);
		if(ImGui.IsWindowFocused(ImGuiFocusedFlags.AnyWindow))
			return true;
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.CONTROL_LEFT || keycode == Keys.CONTROL_RIGHT)
			ctrlKey = false;
		if(keycode == Keys.SHIFT_LEFT || keycode == Keys.SHIFT_RIGHT)
			shiftKey = false;
		if(keycode == Keys.ALT_LEFT || keycode == Keys.ALT_RIGHT)
			altKey = false;
		if(keycode == Keys.SYM)
			superKey = false;
		ImGui.UpdateKey(keycode, false, true, ctrlKey, shiftKey, altKey, superKey);
		if(ImGui.IsWindowFocused(ImGuiFocusedFlags.AnyWindow))
			return true;
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		ImGui.UpdateScroll(0, amount);
		ImGuiIO getIO = ImGui.GetIO();
		if(getIO.WantCaptureMouse)
			return true;
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		//Experimental. There is a issue with deltaX/Y having high numbers if input is block
//		if(ImGui.IsWindowFocused(ImGuiFocusedFlags.AnyWindow))
//			return true;
		return false;
	}
}
