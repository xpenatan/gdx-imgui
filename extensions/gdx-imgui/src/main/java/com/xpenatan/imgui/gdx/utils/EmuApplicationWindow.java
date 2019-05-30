package com.xpenatan.imgui.gdx.utils;

import com.badlogic.gdx.ApplicationListener;

/**
* This class was originally from XpeEngine and its now public. <br><br>
*
* This class is to emulate Gdx game frame.
*
* @author xpenatan
*/
public class EmuApplicationWindow extends EmuWindow {
	private ApplicationListener oldListener;
	private ApplicationListener applicationListener;

	public EmuApplicationWindow() {
	}


	public EmuApplicationWindow(EmuInput input) {
		super(input);
	}

	public EmuApplicationWindow(ApplicationListener applicationListener) {
		oldListener = this.applicationListener;
		this.applicationListener = applicationListener;
	}

	public void setApplicationListener(ApplicationListener applicationListener) {
		this.applicationListener = applicationListener;
		reset();
	}

	@Override
	protected void onCreate() {
		if(applicationListener != null)
			applicationListener.create();
	}

	@Override
	protected void onResize(int width, int height) {
		if(applicationListener != null)
			applicationListener.resize(width, height);
	}

	@Override
	protected void onRender() {
		if(applicationListener != null)
			applicationListener.render();
	}

	@Override
	protected void onPause() {
		if(applicationListener != null)
			applicationListener.pause();
	}

	@Override
	protected void onResume() {
		if(applicationListener != null)
			applicationListener.resume();
	}

	@Override
	protected void onDispose() {
		if(oldListener != null) {
			oldListener.dispose();
			oldListener = null;
		}
	}
}
