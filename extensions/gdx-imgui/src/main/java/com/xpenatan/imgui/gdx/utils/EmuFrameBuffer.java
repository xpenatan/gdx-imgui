package com.xpenatan.imgui.gdx.utils;

import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer;

/**
* This class was originally from XpeEngine and its now public. <br><br>
*
* @author xpenatan
*/
public class EmuFrameBuffer extends FrameBuffer {

	public EmuFrameBuffer(Format format, int width, int height, boolean hasDepth, boolean hasStencil) {
		super(format, width, height, hasDepth, hasStencil);
	}

	public EmuFrameBuffer(Format format, int width, int height, boolean hasDepth) {
		super(format, width, height, hasDepth);
	}

	public EmuFrameBuffer(GLFrameBufferBuilder<? extends GLFrameBuffer<Texture>> bufferBuilder) {
		super(bufferBuilder);
	}

	public static void setDefaultFramebufferHandle(int bufferHandler) {
		GLFrameBuffer.defaultFramebufferHandle = bufferHandler;
	}

	public static int getDefaultFramebufferHandle() {
		return GLFrameBuffer.defaultFramebufferHandle;
	}

	public static void setDefaultFramebufferHandleInitialized(boolean flag) {
		GLFrameBuffer.defaultFramebufferHandleInitialized = flag;
	}

	public static boolean getDefaultFramebufferHandleInitialized() {
		return GLFrameBuffer.defaultFramebufferHandleInitialized;
	}
}
