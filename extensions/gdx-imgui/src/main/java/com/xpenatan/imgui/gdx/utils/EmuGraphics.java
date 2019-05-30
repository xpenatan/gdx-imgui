package com.xpenatan.imgui.gdx.utils;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Cursor.SystemCursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.glutils.GLVersion;
import com.badlogic.gdx.utils.Disposable;

/**
* This class was originally from XpeEngine and its now public. <br><br>
*
* @author xpenatan
*/
public class EmuGraphics implements Graphics, Disposable{

	EmuWindow emuWindow;
	Graphics gdxGraphics;

	int width;
	int height;
	boolean sizeChanged;

	private long lastFrameTime = -1;
	private float deltaTime;
	private long frameId;
	private long frameCounterStart = 0;
	private int frames;
	private int fps;

	public boolean forceSizeUpdate = false;

	private String title;

	public EmuGraphics(EmuWindow emuWindow, Graphics gdxGraphics) {
		this.emuWindow = emuWindow;
		this.gdxGraphics = gdxGraphics;
	}

	public boolean setSize (int width, int height) {
		if (forceSizeUpdate || this.width != width || this.height != height) {
			forceSizeUpdate = false;
			this.width = width;
			this.height = height;
			sizeChanged = true;
			return true;
		}
		return false;
	}

	public void update() {
		if (sizeChanged) {
			sizeChanged = false;
			emuWindow.onResize(width, height);
		}
		long time = System.currentTimeMillis();
		if (lastFrameTime == -1)
			lastFrameTime = time;
		deltaTime = (time - lastFrameTime) / 1000.0f;
		lastFrameTime = time;

		if (time - frameCounterStart >= 1000) {
			fps = frames;
			frames = 0;
			frameCounterStart = time;
		}
		frames++;
		frameId++;
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean isGL30Available() {
		return gdxGraphics.isGL30Available();
	}

	@Override
	public GL20 getGL20() {
		return gdxGraphics.getGL20();
	}

	@Override
	public GL30 getGL30() {
		return gdxGraphics.getGL30();
	}

	@Override
	public void setGL20(GL20 gl20) {
		gdxGraphics.setGL20(gl20);
	}

	@Override
	public void setGL30(GL30 gl30) {
		gdxGraphics.setGL30(gl30);
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getBackBufferWidth() {
		return width;
	}

	@Override
	public int getBackBufferHeight() {
		return height;
	}

	@Override
	public long getFrameId() {
		return frameId;
	}

	@Override
	public float getDeltaTime() {
		return deltaTime;
	}

	@Override
	public float getRawDeltaTime() {
		return deltaTime;
	}

	@Override
	public int getFramesPerSecond() {
		return fps;
	}

	@Override
	public GraphicsType getType() {
		return gdxGraphics.getType();
	}

	@Override
	public GLVersion getGLVersion() {
		return gdxGraphics.getGLVersion();
	}

	@Override
	public float getPpiX() {
		return gdxGraphics.getPpiX();
	}

	@Override
	public float getPpiY() {
		return gdxGraphics.getPpiY();
	}

	@Override
	public float getPpcX() {
		return gdxGraphics.getPpcX();
	}

	@Override
	public float getPpcY() {
		return gdxGraphics.getPpcY();
	}

	@Override
	public float getDensity() {
		return gdxGraphics.getDensity();
	}

	@Override
	public boolean supportsDisplayModeChange() {
		// Not supported
		return false;
	}

	@Override
	public Monitor getPrimaryMonitor() {
		return gdxGraphics.getPrimaryMonitor();
	}

	@Override
	public Monitor getMonitor() {
		return gdxGraphics.getMonitor();
	}

	@Override
	public Monitor[] getMonitors() {
		return gdxGraphics.getMonitors();
	}

	@Override
	public DisplayMode[] getDisplayModes() {
		return gdxGraphics.getDisplayModes();
	}

	@Override
	public DisplayMode[] getDisplayModes(Monitor monitor) {
		return gdxGraphics.getDisplayModes(monitor);
	}

	@Override
	public DisplayMode getDisplayMode() {
		return gdxGraphics.getDisplayMode();
	}

	@Override
	public DisplayMode getDisplayMode(Monitor monitor) {
		return gdxGraphics.getDisplayMode(monitor);
	}

	@Override
	public boolean setFullscreenMode(DisplayMode displayMode) {
		// Not supported
		return false;
	}

	@Override
	public boolean setWindowedMode(int width, int height) {
		// Not supported
		return false;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public void setUndecorated(boolean undecorated) {
		// Not supported
	}

	@Override
	public void setResizable(boolean resizable) {
		// Not supported
	}

	@Override
	public void setVSync(boolean vsync) {
		// Not supported
	}

	@Override
	public BufferFormat getBufferFormat() {
		return gdxGraphics.getBufferFormat();
	}

	@Override
	public boolean supportsExtension(String extension) {
		return gdxGraphics.supportsExtension(extension);
	}

	@Override
	public void setContinuousRendering(boolean isContinuous) {
		// Not supported
	}

	@Override
	public boolean isContinuousRendering() {
		// Not supported
		return false;
	}

	@Override
	public void requestRendering() {
		// Not supported

	}

	@Override
	public boolean isFullscreen() {
		// Not supported
		return false;
	}

	@Override
	public Cursor newCursor(Pixmap pixmap, int xHotspot, int yHotspot) {
		return gdxGraphics.newCursor(pixmap, xHotspot, yHotspot);
	}

	@Override
	public void setCursor(Cursor cursor) {
		gdxGraphics.setCursor(cursor);
	}

	@Override
	public void setSystemCursor(SystemCursor systemCursor) {
		gdxGraphics.setSystemCursor(systemCursor);
	}

}
