package com.github.xpenatan.xwindow;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;

/**
* This class was originally from XpeEngine and its now public. <br><br>
*
* A lower level class that combines inputs and rendering calls to draw to a texture using frameBuffer.
*
* @author xpenatan
*/
public abstract class EmuWindow {

	private boolean begin;

	private FrameBuffer frameBuffer;

	private Graphics gdxGraphics;
	private Input gdxInput;
	private GL20 gdxGL20;
	private GL30 gdxGL30;

	private EmuGraphics emuGraphics;
	private EmuInput emuInput;
	private EmuGL20 emuGL20;

	private boolean disposed;
	private boolean initialized = false;

	private boolean processInput = true;

	private boolean resume = true;
	private boolean resumeStateChanged = true;

	private int defaultHandler;

	private boolean isWindowFocused;
	private boolean isWindowHovered;
	private int windowX;
	private int windowY;
	private int windowWidth;
	private int windowHeight;

	public float u;;
	public float v;;
	public float u2;;
	public float v2;

	private boolean inputReleased = false;
	private boolean isViewportFocused;

	private boolean lastFrameFocus = isViewportFocused;

	private boolean reset;

	public EmuWindow() {
		this(new EmuInput(Gdx.input));
	}

	public EmuWindow(EmuInput input) {
		this.emuGraphics = new EmuGraphics(this, Gdx.graphics);
		this.emuInput = input;
		this.emuGL20 = Gdx.gl30 != null ? new EmuGL30(Gdx.gl30) : new EmuGL20(Gdx.gl20);
		frameBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, 2560, 1080, true);
	}

	public EmuInput getInput() {
		return emuInput;
	}

	public void begin (boolean isWindowFocused, boolean isWindowHovered, int windowX, int windowY, int windowWidth, int windowHeight) {
		if (begin == false) {
			begin = true;
			lastFrameFocus = this.isWindowFocused;
			this.isWindowFocused = isWindowFocused;
			this.isWindowHovered = isWindowHovered;
			this.windowX = windowX;
			this.windowY = windowY;
			this.windowWidth = windowWidth;
			this.windowHeight = windowHeight;

			defaultHandler = EmuFrameBuffer.getDefaultFramebufferHandle();
			int framebufferHandle = frameBuffer.getFramebufferHandle();
			EmuFrameBuffer.setDefaultFramebufferHandle(framebufferHandle);
			frameBuffer.bind();

			emuGL20.begin(0, 0, windowWidth, windowHeight);

			gdxGraphics = Gdx.graphics;
			gdxInput = Gdx.input;
			gdxGL20 = Gdx.gl20;
			gdxGL30 = Gdx.gl30;
			Gdx.graphics = emuGraphics;
			Gdx.input = emuInput;

			if(gdxGL30 != null)
				Gdx.gl30 = (GL30) emuGL20;
			Gdx.gl20 = emuGL20;
			Gdx.gl = emuGL20;

			emuGraphics.setSize(windowWidth, windowHeight);
			emuInput.setWindow(isWindowFocused, isWindowHovered, windowX, windowY, windowWidth, windowHeight);
		}
	}

	public void end () {
		if (begin) {
			begin = false;
			Gdx.graphics = gdxGraphics;
			Gdx.input = gdxInput;
			Gdx.gl = gdxGL30 != null ? gdxGL30 : gdxGL20;
			Gdx.gl20 = gdxGL20;
			Gdx.gl30 = gdxGL30;

			EmuFrameBuffer.setDefaultFramebufferHandle(defaultHandler);
			FrameBuffer.unbind();
			Gdx.gl20.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

			emuGL20.end();
			reset = false;
		}
	}

	public Texture getTexture() {
		Texture texture = frameBuffer.getColorBufferTexture();
		float srcX = 0;
		float srcY = 0;
		float srcWidth = windowWidth;
		float srcHeight = windowHeight;
		float invTexWidth = 1.0f / texture.getWidth();
		float invTexHeight = 1.0f / texture.getHeight();
		u = srcX * invTexWidth;
		v = (srcY + srcHeight) * invTexHeight;
		u2 = (srcX + srcWidth) * invTexWidth;
		v2 = srcY * invTexHeight;
		return texture;
	}

	public int getTextureID() {
		return getTexture().getTextureObjectHandle();
	}

	public boolean canUpdate() {
		return disposed == false && (resume || resumeStateChanged);
	}

	public void loop () {
		updateInput();
		if (canUpdate()) {
			update();
			Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			onRender();
		}
	}

	public void updateInput() {
		if(lastFrameFocus && !isWindowFocused) {
			inputReleased = false;
		}

		setProcessInput(isWindowFocused);
		if(!isWindowFocused && !inputReleased) {
			inputReleased = true;
			getInput().releaseInput(false, true);
		}
	}

	public void update() {
		if(reset) {
			onDispose();
			emuInput.setInputProcessor(null);
			emuGL20.reset();
			initialized = false;
		}


		if (initialized == false) {
			onCreate();
			emuGraphics.sizeChanged = true;
			initialized = true;
		}

		if (resumeStateChanged) {
			resumeStateChanged = false;
			if (resume == true)
				onResume();
			else
				onPause();
		}
		emuGraphics.update();
		if (processInput)
			emuInput.drain();
	}

	public void setProcessInput(boolean flag) {
		processInput = flag;
	}

	public void setResume (boolean toResume) {
		if (this.resume != toResume) {
			this.resume = toResume;
			resumeStateChanged = true;
		}
	}

	public void dispose () {
		if (disposed == false) {
			disposed = true;
			onPause();
			onDispose();
			emuGraphics.dispose();
			emuInput.dispose();
		}
	}

	public void reset() {
		reset = true;
	}

	protected abstract void onCreate ();

	protected abstract void onResize (int width, int height);

	protected abstract void onRender ();

	protected abstract void onPause ();

	protected abstract void onResume ();

	protected abstract void onDispose ();
}
