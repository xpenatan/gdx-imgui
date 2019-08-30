package com.github.xpenatan.imgui.gdx.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.IntSet;
import com.badlogic.gdx.utils.IntSet.IntSetIterator;

/**
 * This class was originally from XpeEngine and its now public. <br><br>
 *
 * Class to emulate input when its touched inside a viewport. <br>
 * ViewportX/Y needs to be updated so mouse position is converted correctly to the rendering scene. <br>
 * Needs to call drain to process events.
 *
 * @author xpenatan
 */
public class EmuInput extends EmuEventQueue implements Input, Disposable {

	private boolean enable = true;
	private InputProcessor processor; // the viewport/game input
	private Input gdxInput;

	private boolean keyJustPressed = false;
	private boolean[] justPressedButtons = new boolean[5];
	private boolean[] justPressedKeys = new boolean[256];
	private boolean justTouched;

	private IntSet[] buttonPressed = new IntSet[10];
	private IntSet keyDown = new IntSet();
	private IntSet keyPressed = new IntSet();
	private int deltaX, deltaY;
	private int mouseX, mouseY;

	private boolean releaseAtDrain;

	private IntSet touchDownInside = new IntSet();
	private boolean isWindowFocused;
	private boolean isWindowHovered;
	private int viewportX;
	private int viewportY;
	private int viewportWidth;
	private int viewportHeight;

	public EmuInput(Input gdxInput) {
		super();
		this.gdxInput = gdxInput;

		for(int i = 0; i < 10; i++)
			buttonPressed[i] = new IntSet();

		// Processed when calling drain
		InputProcessor inputProcessor = new InputProcessor() {
			@Override
			public boolean keyDown (int keycode) {
				if (enable == false)
					return false;

				keyJustPressed = true;
				justPressedKeys[keycode] = true;
				keyPressed.add(keycode);
				Gdx.graphics.requestRendering();
				return processor != null ? processor.keyDown(keycode) : false;
			}

			@Override
			public boolean keyUp (int keycode) {
				if (enable == false)
					return false;

				keyPressed.remove(keycode);
				Gdx.graphics.requestRendering();
				return processor != null ? processor.keyUp(keycode) : false;
			}

			@Override
			public boolean keyTyped (char character) {
				if (enable == false)
					return false;

				Gdx.graphics.requestRendering();
				return processor != null ? processor.keyTyped(character) : false;
			}

			@Override
			public boolean touchDown (int screenX, int screenY, int pointer, int button) {
				if (enable == false)
					return false;
				screenX = toWindowX(screenX);
				screenY = toWindowY(screenY);
				mouseX = screenX;
				mouseY = screenY;
				deltaX = 0;
				deltaY = 0;
				buttonPressed[pointer].add(button);
				justTouched = true;
				justPressedButtons[button] = true;
				Gdx.graphics.requestRendering();
				return processor != null ? processor.touchDown(mouseX, mouseY, pointer, button) : false;
			}

			@Override
			public boolean touchUp (int screenX, int screenY, int pointer, int button) {
				if (enable == false)
					return false;

				buttonPressed[pointer].remove(button);
				Gdx.graphics.requestRendering();

				return processor != null ? processor.touchUp(mouseX, mouseY, pointer, button) : false;
			}

			@Override
			public boolean touchDragged (int screenX, int screenY, int pointer) {
				if (enable == false)
					return false;

				screenX = toWindowX(screenX);
				screenY = toWindowY(screenY);

				deltaX = screenX - mouseX;
				deltaY = screenY - mouseY;
				mouseX = screenX;
				mouseY = screenY;

				Gdx.graphics.requestRendering();
				return processor != null ? processor.touchDragged(mouseX, mouseY, pointer) : false;
			}

			@Override
			public boolean mouseMoved (int screenX, int screenY) {
				if (enable == false)
					return false;

				screenX = toWindowX(screenX);
				screenY = toWindowY(screenY);

				deltaX = screenX - mouseX;
				deltaY = screenY - mouseY;

				mouseX = screenX;
				mouseY = screenY;
				Gdx.graphics.requestRendering();
				return processor != null ? processor.mouseMoved(mouseX, mouseY) : false;
			}

			@Override
			public boolean scrolled (int amount) {
				if (enable == false)
					return false;

				Gdx.graphics.requestRendering();
				return processor != null ? processor.scrolled(amount) : false;
			}
		};
		setProcessor(inputProcessor);
	}

	private int toWindowX(int screenX) {
		return screenX - viewportX;
	}

	private int toWindowY(int screenY) {
		return screenY - viewportY;
	}

	public void setWindow(boolean isWindowFocused, boolean isWindowHovered, int x, int y, int width, int height) {
		this.isWindowHovered = isWindowHovered;
		if(this.isWindowFocused != isWindowFocused) {
			this.isWindowFocused = isWindowFocused;
			if(isWindowFocused) {
				if(!keyDown.isEmpty()) {
					IntSetIterator iterator = keyDown.iterator();
					while(iterator.hasNext) {
						int keyDownCode = iterator.next();
						if(getKeyDownIndex(keyDownCode) != -1)
							throw new GdxRuntimeException("Index should be -1");
						super.keyDown(keyDownCode);
					}
				}
			}
		}
		this.viewportX = x;
		this.viewportY = y;
		this.viewportWidth = width;
		this.viewportHeight = height;
	}

	@Override
	public void drain() {
		justTouched = false;
		if (keyJustPressed) {
			keyJustPressed = false;
			for (int i = 0; i < justPressedKeys.length; i++)
				justPressedKeys[i] = false;
		}
		for (int i = 0; i < justPressedButtons.length; i++)
			justPressedButtons[i] = false;

		if(releaseAtDrain)
			releaseInput(false, false);
		deltaX = 0;
		deltaY = 0;
		super.drain();
	}

	public void releaseInput (boolean releaseAtDrain, boolean drain) {
		this.releaseAtDrain = releaseAtDrain;
		if(!releaseAtDrain) {
			justTouched = false;
			keyJustPressed = false;
			for (int i = 0; i < justPressedKeys.length; i++) {
				justPressedKeys[i] = false;
			}

			for (int i = 0; i < justPressedButtons.length; i++)
				justPressedButtons[i] = false;

			for(int i = 0; i < 10; i++) {
				IntSet pressed = buttonPressed[i];
				IntSetIterator iterator = pressed.iterator();
				while (iterator.hasNext) {
					int buttonKey = iterator.next();
					iterator.remove();
					super.touchUp(getX(), getY(), 0, buttonKey);
				}
			}

			IntSetIterator iterator = keyPressed.iterator();
			while (iterator.hasNext) {
				int keyboardKey = iterator.next();
				iterator.remove();
				super.keyUp(keyboardKey);
			}

			if(drain)
				super.drain();
			deltaX = 0;
			deltaY = 0;
		}
	}

	public void clear() {
		for(int i = 0; i < 5; i++)
			justPressedButtons[i] = false;
		for(int i = 0; i < 256; i++)
			justPressedKeys[i] = false;
		justTouched = false;
		keyJustPressed= false;
		for(int i = 0; i < 10; i++) {
			IntSet pressed = buttonPressed[i];
			pressed.clear();
		}
		keyPressed.clear();
		deltaX = 0;
		deltaY = 0;
		mouseX = 0;
		mouseY = 0;
		releaseAtDrain = false;
		touchDownInside.clear();
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(isWindowHovered) { // Fix when window is focus and goes out of focus and pass input to window. ImGui needs a least 1 frame delay to process input
			touchDownInside.add(button);
			return super.touchDown(screenX, screenY, pointer, button);
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if(!touchDownInside.isEmpty())
			return super.touchDragged(screenX, screenY, pointer);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		boolean removed = touchDownInside.remove(button); // release mouse if it was pressed inside window
		if(isWindowHovered || removed) { // Fix when window is focus and goes out of focus and pass input to window. ImGui needs a least 1 frame delay to process input
			return super.touchUp(screenX, screenY, pointer, button);
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		if(isWindowFocused)
			return super.keyTyped(character);
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		keyDown.add(keycode);
		if(isWindowFocused)
			return super.keyDown(keycode);
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		keyDown.remove(keycode);
		if(isWindowFocused)
			return super.keyUp(keycode);
		return false;
	}

	private int getKeyDownIndex(int keycode) {
		int[] q = queue.items;
		for (int i = 0; i < queue.size;) {
			int type = q[i++];
			int index = i-1;
			float currentEwventTime = (long)q[i++] << 32 | q[i++] & 0xFFFFFFFFL;
			switch (type) {
			case SKIP:
				i += q[i];
				break;
			case KEY_DOWN:
				int key = q[i++];
				if(key == keycode) {
					return index;
				}
				break;
			case KEY_UP:
				i++;
				break;
			case KEY_TYPED:
				i++;
				break;
			case TOUCH_DOWN:
				i++;
				i++;
				i++;
				i++;
				break;
			case TOUCH_UP:
				i++;
				i++;
				i++;
				i++;
				break;
			case TOUCH_DRAGGED:
				i++;
				i++;
				i++;
				break;
			case MOUSE_MOVED:
				i++;
				i++;
				break;
			case SCROLLED:
				i++;
				break;
			default:
				throw new RuntimeException();
			}

		}
		return -1;
	}

	@Override
	public boolean scrolled(int amount) {
		if(isWindowFocused && isWindowHovered)
			return super.scrolled(amount);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		if(isWindowFocused) {
			return super.mouseMoved(screenX, screenY);
		}
		return false;
	}

	public boolean isEnable () {
		return enable;
	}

	public void setEnable (boolean enable) {
		this.enable = enable;
	}

	@Override
	public int getX() {
		return mouseX;
	}

	@Override
	public int getX(int pointer) {
		return mouseX;
	}

	@Override
	public int getY() {
		return mouseY;
	}

	@Override
	public int getY(int pointer) {
		return mouseY;
	}

	@Override
	public int getDeltaX() {
		return deltaX;
	}

	@Override
	public int getDeltaX(int pointer) {
		return deltaX;
	}

	@Override
	public int getDeltaY() {
		return deltaY;
	}

	@Override
	public int getDeltaY(int pointer) {
		return deltaY;
	}

	@Override
	public boolean isTouched() {
		return buttonPressed[0].contains(0) || buttonPressed[0].contains(1) || buttonPressed[0].contains(2);
	}

	@Override
	public boolean justTouched() {
		return justTouched;
	}

	@Override
	public boolean isTouched(int pointer) {
		return buttonPressed[pointer].contains(pointer) ;
	}

	@Override
	public boolean isButtonPressed(int button) {
		return buttonPressed[0].contains(button);
	}

	@Override
	public boolean isButtonJustPressed(int button) {
		return justPressedButtons[button];
	}

	@Override
	public boolean isKeyPressed(int key) {
		return keyPressed.contains(key);
	}

	@Override
	public boolean isKeyJustPressed(int key) {
		if (key < 0 || key > 256)
			return false;
		if (key == Input.Keys.ANY_KEY)
			return keyJustPressed;
		return justPressedKeys[key];
	}

	@Override
	public float getAccelerometerX() {
		return gdxInput.getAccelerometerX();
	}

	@Override
	public float getAccelerometerY() {
		return gdxInput.getAccelerometerY();
	}

	@Override
	public float getAccelerometerZ() {
		return gdxInput.getAccelerometerZ();
	}

	@Override
	public float getGyroscopeX() {
		return gdxInput.getGyroscopeX();
	}

	@Override
	public float getGyroscopeY() {
		return gdxInput.getGyroscopeY();
	}

	@Override
	public float getGyroscopeZ() {
		return gdxInput.getGyroscopeZ();
	}

	@Override
	public int getMaxPointers() {
		return gdxInput.getMaxPointers();
	}

	@Override
	public float getPressure() {
		return gdxInput.getPressure();
	}

	@Override
	public float getPressure(int pointer) {
		return gdxInput.getPressure();
	}

	@Override
	public void getTextInput(TextInputListener listener, String title, String text, String hint) {
		gdxInput.getTextInput(listener, title, text, hint);
	}

	@Override
	public void setOnscreenKeyboardVisible(boolean visible) {
		gdxInput.setOnscreenKeyboardVisible(visible);
	}

	@Override
	public void vibrate(int milliseconds) {
		gdxInput.vibrate(milliseconds);
	}

	@Override
	public void vibrate(long[] pattern, int repeat) {
		gdxInput.vibrate(pattern, repeat);
	}

	@Override
	public void cancelVibrate() {
		gdxInput.cancelVibrate();
	}

	@Override
	public float getAzimuth() {
		return gdxInput.getAzimuth();
	}

	@Override
	public float getPitch() {
		return gdxInput.getPitch();
	}

	@Override
	public float getRoll() {
		return gdxInput.getRoll();
	}

	@Override
	public void getRotationMatrix(float[] matrix) {
		gdxInput.getRotationMatrix(matrix);
	}

	@Override
	public void setCatchBackKey(boolean catchBack) {
		gdxInput.setCatchBackKey(catchBack);
	}

	@Override
	public boolean isCatchBackKey() {
		return gdxInput.isCatchBackKey();
	}

	@Override
	public void setCatchMenuKey(boolean catchMenu) {
		gdxInput.setCatchMenuKey(catchMenu);
	}

	@Override
	public boolean isCatchMenuKey() {
		return gdxInput.isCatchBackKey();
	}

	@Override
	public void setInputProcessor(InputProcessor processor) {
		this.processor = processor;
	}

	@Override
	public InputProcessor getInputProcessor() {
		return processor;
	}

	@Override
	public boolean isPeripheralAvailable(Peripheral peripheral) {
		return gdxInput.isPeripheralAvailable(peripheral);
	}

	@Override
	public int getRotation() {
		return gdxInput.getRotation();
	}

	@Override
	public Orientation getNativeOrientation() {
		return gdxInput.getNativeOrientation();
	}

	@Override
	public void setCursorCatched(boolean catched) {
		gdxInput.setCursorCatched(catched);
	}

	@Override
	public boolean isCursorCatched() {
		return gdxInput.isCursorCatched();
	}

	@Override
	public void setCursorPosition(int x, int y) {
		gdxInput.setCursorPosition(x, y);
	}

	@Override
	public void setCatchKey(int keycode, boolean catchKey) {
	}

	@Override
	public boolean isCatchKey(int keycode) {
		return false;
	}

	@Override
	public void dispose() {
	}

}
