package com.github.xpenatan.imgui.gdx.utils;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import com.badlogic.gdx.graphics.GL20;

/**
* This class was originally from XpeEngine and its now public. <br><br>
*
* @author xpenatan
*/
public class EmuGL20<T extends GL20> implements GL20 {

	protected T gdxGL;

	public int lastViewportX;
	public int lastViewportY;
	public int lastViewportWidth;
	public int lastViewportHeight;

	private boolean viewportCalled;

	public EmuGL20(T gdxGL20) {
		this.gdxGL = gdxGL20;
	}

	public void reset() {
		viewportCalled = false;
	}

	public void begin(int x, int y, int width, int height) {
		if(!viewportCalled) {
			lastViewportX = x;
			lastViewportY = y;
			lastViewportWidth = width;
			lastViewportHeight = height;
		}
		gdxGL.glViewport(lastViewportX, lastViewportY, lastViewportWidth, lastViewportHeight);
	}

	public void end() {
	}


	@Override
	public void glViewport(int x, int y, int width, int height) {
		// since there can be multiple windows we cache the viewport data so we dont need to call resize multiple time
		viewportCalled = true;
		lastViewportX = x;
		lastViewportY = y;
		lastViewportWidth = width;
		lastViewportHeight = height;
		gdxGL.glViewport(x, y, width, height);
	}

	@Override
	public void glScissor(int x, int y, int width, int height) {
		gdxGL.glScissor(x, y, width, height);
	}

	@Override
	public void glBindTexture(int target, int texture) {
		gdxGL.glBindTexture(target, texture);
	}

	@Override
	public void glEnable(int cap) {
		gdxGL.glEnable(cap);
	}

	@Override
	public void glDisable(int cap) {
		gdxGL.glDisable(cap);
	}

	@Override
	public void glActiveTexture(int texture) {
		gdxGL.glActiveTexture(texture);
	}

	@Override
	public void glBlendFunc(int sfactor, int dfactor) {
		gdxGL.glBlendFunc(sfactor, dfactor);
	}

	@Override
	public void glClear(int mask) {
		gdxGL.glClear(mask);
	}

	@Override
	public void glClearColor(float red, float green, float blue, float alpha) {
		gdxGL.glClearColor(red, green, blue, alpha);
	}

	@Override
	public void glClearDepthf(float depth) {
		gdxGL.glClearDepthf(depth);
	}

	@Override
	public void glClearStencil(int s) {
		gdxGL.glClearStencil(s);
	}

	@Override
	public void glColorMask(boolean red, boolean green, boolean blue, boolean alpha) {
		gdxGL.glColorMask(red, green, blue, alpha);
	}

	@Override
	public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border,
			int imageSize, Buffer data) {
		gdxGL.glCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize,
				data);
	}

	@Override
	public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height,
			int format, int imageSize, Buffer data) {
		gdxGL.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize,
				data);
	}

	@Override
	public void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height,
			int border) {
		gdxGL.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border);
	}

	@Override
	public void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width,
			int height) {
		gdxGL.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
	}

	@Override
	public void glCullFace(int mode) {
		gdxGL.glCullFace(mode);
	}

	@Override
	public void glDeleteTextures(int n, IntBuffer textures) {
		gdxGL.glDeleteTextures(n, textures);
	}

	@Override
	public void glDeleteTexture(int texture) {
		gdxGL.glDeleteTexture(texture);
	}

	@Override
	public void glDepthFunc(int func) {
		gdxGL.glDepthFunc(func);
	}

	@Override
	public void glDepthMask(boolean flag) {
		gdxGL.glDepthMask(flag);
	}

	@Override
	public void glDepthRangef(float zNear, float zFar) {
		gdxGL.glDepthRangef(zNear, zFar);
	}

	@Override
	public void glDrawArrays(int mode, int first, int count) {
		gdxGL.glDrawArrays(mode, first, count);
	}

	@Override
	public void glDrawElements(int mode, int count, int type, Buffer indices) {
		gdxGL.glDrawElements(mode, count, type, indices);
	}

	@Override
	public void glFinish() {
		gdxGL.glFinish();
	}

	@Override
	public void glFlush() {
		gdxGL.glFlush();
	}

	@Override
	public void glFrontFace(int mode) {
		gdxGL.glFrontFace(mode);
	}

	@Override
	public void glGenTextures(int n, IntBuffer textures) {
		gdxGL.glGenTextures(n, textures);
	}

	@Override
	public int glGenTexture() {
		return gdxGL.glGenTexture();
	}

	@Override
	public int glGetError() {
		return gdxGL.glGetError();
	}

	@Override
	public void glGetIntegerv(int pname, IntBuffer params) {
		gdxGL.glGetIntegerv(pname, params);
	}

	@Override
	public String glGetString(int name) {
		return gdxGL.glGetString(name);
	}

	@Override
	public void glHint(int target, int mode) {
		gdxGL.glHint(target, mode);
	}

	@Override
	public void glLineWidth(float width) {
		gdxGL.glLineWidth(width);
	}

	@Override
	public void glPixelStorei(int pname, int param) {
		gdxGL.glPixelStorei(pname, param);
	}

	@Override
	public void glPolygonOffset(float factor, float units) {
		gdxGL.glPolygonOffset(factor, units);
	}

	@Override
	public void glReadPixels(int x, int y, int width, int height, int format, int type, Buffer pixels) {
		gdxGL.glReadPixels(x, y, width, height, format, type, pixels);
	}

	@Override
	public void glStencilFunc(int func, int ref, int mask) {
		gdxGL.glStencilFunc(func, ref, mask);
	}

	@Override
	public void glStencilMask(int mask) {
		gdxGL.glStencilMask(mask);
	}

	@Override
	public void glStencilOp(int fail, int zfail, int zpass) {
		gdxGL.glStencilOp(fail, zfail, zpass);
	}

	@Override
	public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format,
			int type, Buffer pixels) {
		gdxGL.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
	}

	@Override
	public void glTexParameterf(int target, int pname, float param) {
		gdxGL.glTexParameterf(target, pname, param);
	}

	@Override
	public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format,
			int type, Buffer pixels) {
		gdxGL.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
	}

	@Override
	public void glAttachShader(int program, int shader) {
		gdxGL.glAttachShader(program, shader);
	}

	@Override
	public void glBindAttribLocation(int program, int index, String name) {
		gdxGL.glBindAttribLocation(program, index, name);
	}

	@Override
	public void glBindBuffer(int target, int buffer) {
		gdxGL.glBindBuffer(target, buffer);
	}

	@Override
	public void glBindFramebuffer(int target, int framebuffer) {
		gdxGL.glBindFramebuffer(target, framebuffer);
	}

	@Override
	public void glBindRenderbuffer(int target, int renderbuffer) {
		gdxGL.glBindRenderbuffer(target, renderbuffer);
	}

	@Override
	public void glBlendColor(float red, float green, float blue, float alpha) {
		gdxGL.glBlendColor(red, green, blue, alpha);
	}

	@Override
	public void glBlendEquation(int mode) {
		gdxGL.glBlendEquation(mode);
	}

	@Override
	public void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
		gdxGL.glBlendEquationSeparate(modeRGB, modeAlpha);
	}

	@Override
	public void glBlendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
		gdxGL.glBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
	}

	@Override
	public void glBufferData(int target, int size, Buffer data, int usage) {
		gdxGL.glBufferData(target, size, data, usage);
	}

	@Override
	public void glBufferSubData(int target, int offset, int size, Buffer data) {
		gdxGL.glBufferSubData(target, offset, size, data);
	}

	@Override
	public int glCheckFramebufferStatus(int target) {
		return gdxGL.glCheckFramebufferStatus(target);
	}

	@Override
	public void glCompileShader(int shader) {
		gdxGL.glCompileShader(shader);
	}

	@Override
	public int glCreateProgram() {
		return gdxGL.glCreateProgram();
	}

	@Override
	public int glCreateShader(int type) {
		return gdxGL.glCreateShader(type);
	}

	@Override
	public void glDeleteBuffer(int buffer) {
		gdxGL.glDeleteBuffer(buffer);
	}

	@Override
	public void glDeleteBuffers(int n, IntBuffer buffers) {
		gdxGL.glDeleteBuffers(n, buffers);
	}

	@Override
	public void glDeleteFramebuffer(int framebuffer) {
		gdxGL.glDeleteFramebuffer(framebuffer);
	}

	@Override
	public void glDeleteFramebuffers(int n, IntBuffer framebuffers) {
		gdxGL.glDeleteFramebuffers(n, framebuffers);
	}

	@Override
	public void glDeleteProgram(int program) {
		gdxGL.glDeleteProgram(program);
	}

	@Override
	public void glDeleteRenderbuffer(int renderbuffer) {
		gdxGL.glDeleteRenderbuffer(renderbuffer);
	}

	@Override
	public void glDeleteRenderbuffers(int n, IntBuffer renderbuffers) {
		gdxGL.glDeleteRenderbuffers(n, renderbuffers);
	}

	@Override
	public void glDeleteShader(int shader) {
		gdxGL.glDeleteShader(shader);
	}

	@Override
	public void glDetachShader(int program, int shader) {
		gdxGL.glDetachShader(program, shader);
	}

	@Override
	public void glDisableVertexAttribArray(int index) {
		gdxGL.glDisableVertexAttribArray(index);
	}

	@Override
	public void glDrawElements(int mode, int count, int type, int indices) {
		gdxGL.glDrawElements(mode, count, type, indices);
	}

	@Override
	public void glEnableVertexAttribArray(int index) {
		gdxGL.glEnableVertexAttribArray(index);
	}

	@Override
	public void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
		gdxGL.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
	}

	@Override
	public void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
		gdxGL.glFramebufferTexture2D(target, attachment, textarget, texture, level);
	}

	@Override
	public int glGenBuffer() {
		return gdxGL.glGenBuffer();
	}

	@Override
	public void glGenBuffers(int n, IntBuffer buffers) {
		gdxGL.glGenBuffers(n, buffers);
	}

	@Override
	public void glGenerateMipmap(int target) {
		gdxGL.glGenerateMipmap(target);
	}

	@Override
	public int glGenFramebuffer() {
		return gdxGL.glGenFramebuffer();
	}

	@Override
	public void glGenFramebuffers(int n, IntBuffer framebuffers) {
		gdxGL.glGenFramebuffers(n, framebuffers);
	}

	@Override
	public int glGenRenderbuffer() {
		return gdxGL.glGenRenderbuffer();
	}

	@Override
	public void glGenRenderbuffers(int n, IntBuffer renderbuffers) {
		gdxGL.glGenRenderbuffers(n, renderbuffers);
	}

	@Override
	public String glGetActiveAttrib(int program, int index, IntBuffer size, Buffer type) {
		return gdxGL.glGetActiveAttrib(program, index, size, type);
	}

	@Override
	public String glGetActiveUniform(int program, int index, IntBuffer size, Buffer type) {
		return gdxGL.glGetActiveUniform(program, index, size, type);
	}

	@Override
	public void glGetAttachedShaders(int program, int maxcount, Buffer count, IntBuffer shaders) {
		gdxGL.glGetAttachedShaders(program, maxcount, count, shaders);
	}

	@Override
	public int glGetAttribLocation(int program, String name) {
		return gdxGL.glGetAttribLocation(program, name);
	}

	@Override
	public void glGetBooleanv(int pname, Buffer params) {
		gdxGL.glGetBooleanv(pname, params);
	}

	@Override
	public void glGetBufferParameteriv(int target, int pname, IntBuffer params) {
		gdxGL.glGetBufferParameteriv(target, pname, params);
	}

	@Override
	public void glGetFloatv(int pname, FloatBuffer params) {
		gdxGL.glGetFloatv(pname, params);
	}

	@Override
	public void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, IntBuffer params) {
		gdxGL.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
	}

	@Override
	public void glGetProgramiv(int program, int pname, IntBuffer params) {
		gdxGL.glGetProgramiv(program, pname, params);
	}

	@Override
	public String glGetProgramInfoLog(int program) {
		return gdxGL.glGetProgramInfoLog(program);
	}

	@Override
	public void glGetRenderbufferParameteriv(int target, int pname, IntBuffer params) {
		gdxGL.glGetRenderbufferParameteriv(target, pname, params);
	}

	@Override
	public void glGetShaderiv(int shader, int pname, IntBuffer params) {
		gdxGL.glGetShaderiv(shader, pname, params);
	}

	@Override
	public String glGetShaderInfoLog(int shader) {
		return gdxGL.glGetShaderInfoLog(shader);
	}

	@Override
	public void glGetShaderPrecisionFormat(int shadertype, int precisiontype, IntBuffer range, IntBuffer precision) {
		gdxGL.glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
	}

	@Override
	public void glGetTexParameterfv(int target, int pname, FloatBuffer params) {
		gdxGL.glGetTexParameterfv(target, pname, params);
	}

	@Override
	public void glGetTexParameteriv(int target, int pname, IntBuffer params) {
		gdxGL.glGetTexParameteriv(target, pname, params);
	}

	@Override
	public void glGetUniformfv(int program, int location, FloatBuffer params) {
		gdxGL.glGetUniformfv(program, location, params);
	}

	@Override
	public void glGetUniformiv(int program, int location, IntBuffer params) {
		gdxGL.glGetUniformiv(program, location, params);
	}

	@Override
	public int glGetUniformLocation(int program, String name) {
		return gdxGL.glGetUniformLocation(program, name);
	}

	@Override
	public void glGetVertexAttribfv(int index, int pname, FloatBuffer params) {
		gdxGL.glGetVertexAttribfv(index, pname, params);
	}

	@Override
	public void glGetVertexAttribiv(int index, int pname, IntBuffer params) {
		gdxGL.glGetVertexAttribiv(index, pname, params);
	}

	@Override
	public void glGetVertexAttribPointerv(int index, int pname, Buffer pointer) {
		gdxGL.glGetVertexAttribPointerv(index, pname, pointer);
	}

	@Override
	public boolean glIsBuffer(int buffer) {
		return gdxGL.glIsBuffer(buffer);
	}

	@Override
	public boolean glIsEnabled(int cap) {
		return gdxGL.glIsEnabled(cap);
	}

	@Override
	public boolean glIsFramebuffer(int framebuffer) {
		return gdxGL.glIsFramebuffer(framebuffer);
	}

	@Override
	public boolean glIsProgram(int program) {
		return gdxGL.glIsProgram(program);
	}

	@Override
	public boolean glIsRenderbuffer(int renderbuffer) {
		return gdxGL.glIsRenderbuffer(renderbuffer);
	}

	@Override
	public boolean glIsShader(int shader) {
		return gdxGL.glIsShader(shader);
	}

	@Override
	public boolean glIsTexture(int texture) {
		return gdxGL.glIsTexture(texture);
	}

	@Override
	public void glLinkProgram(int program) {
		gdxGL.glLinkProgram(program);
	}

	@Override
	public void glReleaseShaderCompiler() {
		gdxGL.glReleaseShaderCompiler();
	}

	@Override
	public void glRenderbufferStorage(int target, int internalformat, int width, int height) {
		gdxGL.glRenderbufferStorage(target, internalformat, width, height);
	}

	@Override
	public void glSampleCoverage(float value, boolean invert) {
		gdxGL.glSampleCoverage(value, invert);
	}

	@Override
	public void glShaderBinary(int n, IntBuffer shaders, int binaryformat, Buffer binary, int length) {
		gdxGL.glShaderBinary(n, shaders, binaryformat, binary, length);
	}

	@Override
	public void glShaderSource(int shader, String string) {
		gdxGL.glShaderSource(shader, string);
	}

	@Override
	public void glStencilFuncSeparate(int face, int func, int ref, int mask) {
		gdxGL.glStencilFuncSeparate(face, func, ref, mask);
	}

	@Override
	public void glStencilMaskSeparate(int face, int mask) {
		gdxGL.glStencilMaskSeparate(face, mask);
	}

	@Override
	public void glStencilOpSeparate(int face, int fail, int zfail, int zpass) {
		gdxGL.glStencilOpSeparate(face, fail, zfail, zpass);
	}

	@Override
	public void glTexParameterfv(int target, int pname, FloatBuffer params) {
		gdxGL.glTexParameterfv(target, pname, params);
	}

	@Override
	public void glTexParameteri(int target, int pname, int param) {
		gdxGL.glTexParameteri(target, pname, param);
	}

	@Override
	public void glTexParameteriv(int target, int pname, IntBuffer params) {
		gdxGL.glTexParameteriv(target, pname, params);
	}

	@Override
	public void glUniform1f(int location, float x) {
		gdxGL.glUniform1f(location, x);
	}

	@Override
	public void glUniform1fv(int location, int count, FloatBuffer v) {
		gdxGL.glUniform1fv(location, count, v);
	}

	@Override
	public void glUniform1fv(int location, int count, float[] v, int offset) {
		gdxGL.glUniform1fv(location, count, v, offset);
	}

	@Override
	public void glUniform1i(int location, int x) {
		gdxGL.glUniform1i(location, x);
	}

	@Override
	public void glUniform1iv(int location, int count, IntBuffer v) {
		gdxGL.glUniform1iv(location, count, v);
	}

	@Override
	public void glUniform1iv(int location, int count, int[] v, int offset) {
		gdxGL.glUniform1iv(location, count, v, offset);
	}

	@Override
	public void glUniform2f(int location, float x, float y) {
		gdxGL.glUniform2f(location, x, y);
	}

	@Override
	public void glUniform2fv(int location, int count, FloatBuffer v) {
		gdxGL.glUniform2fv(location, count, v);
	}

	@Override
	public void glUniform2fv(int location, int count, float[] v, int offset) {
		gdxGL.glUniform2fv(location, count, v, offset);
	}

	@Override
	public void glUniform2i(int location, int x, int y) {
		gdxGL.glUniform2i(location, x, y);
	}

	@Override
	public void glUniform2iv(int location, int count, IntBuffer v) {
		gdxGL.glUniform2iv(location, count, v);
	}

	@Override
	public void glUniform2iv(int location, int count, int[] v, int offset) {
		gdxGL.glUniform2iv(location, count, v, offset);
	}

	@Override
	public void glUniform3f(int location, float x, float y, float z) {
		gdxGL.glUniform3f(location, x, y, z);
	}

	@Override
	public void glUniform3fv(int location, int count, FloatBuffer v) {
		gdxGL.glUniform3fv(location, count, v);
	}

	@Override
	public void glUniform3fv(int location, int count, float[] v, int offset) {
		gdxGL.glUniform3fv(location, count, v, offset);
	}

	@Override
	public void glUniform3i(int location, int x, int y, int z) {
		gdxGL.glUniform3i(location, x, y, z);
	}

	@Override
	public void glUniform3iv(int location, int count, IntBuffer v) {
		gdxGL.glUniform3iv(location, count, v);
	}

	@Override
	public void glUniform3iv(int location, int count, int[] v, int offset) {
		gdxGL.glUniform3iv(location, count, v, offset);
	}

	@Override
	public void glUniform4f(int location, float x, float y, float z, float w) {
		gdxGL.glUniform4f(location, x, y, z, w);
	}

	@Override
	public void glUniform4fv(int location, int count, FloatBuffer v) {
		gdxGL.glUniform4fv(location, count, v);
	}

	@Override
	public void glUniform4fv(int location, int count, float[] v, int offset) {
		gdxGL.glUniform4fv(location, count, v, offset);
	}

	@Override
	public void glUniform4i(int location, int x, int y, int z, int w) {
		gdxGL.glUniform4i(location, x, y, z, w);
	}

	@Override
	public void glUniform4iv(int location, int count, IntBuffer v) {
		gdxGL.glUniform4iv(location, count, v);
	}

	@Override
	public void glUniform4iv(int location, int count, int[] v, int offset) {
		gdxGL.glUniform4iv(location, count, v, offset);
	}

	@Override
	public void glUniformMatrix2fv(int location, int count, boolean transpose, FloatBuffer value) {
		gdxGL.glUniformMatrix2fv(location, count, transpose, value);
	}

	@Override
	public void glUniformMatrix2fv(int location, int count, boolean transpose, float[] value, int offset) {
		gdxGL.glUniformMatrix2fv(location, count, transpose, value, offset);
	}

	@Override
	public void glUniformMatrix3fv(int location, int count, boolean transpose, FloatBuffer value) {
		gdxGL.glUniformMatrix3fv(location, count, transpose, value);
	}

	@Override
	public void glUniformMatrix3fv(int location, int count, boolean transpose, float[] value, int offset) {
		gdxGL.glUniformMatrix3fv(location, count, transpose, value, offset);
	}

	@Override
	public void glUniformMatrix4fv(int location, int count, boolean transpose, FloatBuffer value) {
		gdxGL.glUniformMatrix4fv(location, count, transpose, value);
	}

	@Override
	public void glUniformMatrix4fv(int location, int count, boolean transpose, float[] value, int offset) {
		gdxGL.glUniformMatrix4fv(location, count, transpose, value, offset);
	}

	@Override
	public void glUseProgram(int program) {
		gdxGL.glUseProgram(program);
	}

	@Override
	public void glValidateProgram(int program) {
		gdxGL.glValidateProgram(program);
	}

	@Override
	public void glVertexAttrib1f(int indx, float x) {
		gdxGL.glVertexAttrib1f(indx, x);
	}

	@Override
	public void glVertexAttrib1fv(int indx, FloatBuffer values) {
		gdxGL.glVertexAttrib1fv(indx, values);
	}

	@Override
	public void glVertexAttrib2f(int indx, float x, float y) {
		gdxGL.glVertexAttrib2f(indx, x, y);
	}

	@Override
	public void glVertexAttrib2fv(int indx, FloatBuffer values) {
		gdxGL.glVertexAttrib2fv(indx, values);
	}

	@Override
	public void glVertexAttrib3f(int indx, float x, float y, float z) {
		gdxGL.glVertexAttrib3f(indx, x, y, z);
	}

	@Override
	public void glVertexAttrib3fv(int indx, FloatBuffer values) {
		gdxGL.glVertexAttrib3fv(indx, values);
	}

	@Override
	public void glVertexAttrib4f(int indx, float x, float y, float z, float w) {
		gdxGL.glVertexAttrib4f(indx, x, y, z, w);
	}

	@Override
	public void glVertexAttrib4fv(int indx, FloatBuffer values) {
		gdxGL.glVertexAttrib4fv(indx, values);
	}

	@Override
	public void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, Buffer ptr) {
		gdxGL.glVertexAttribPointer(indx, size, type, normalized, stride, ptr);
	}

	@Override
	public void glVertexAttribPointer(int indx, int size, int type, boolean normalized, int stride, int ptr) {
		gdxGL.glVertexAttribPointer(indx, size, type, normalized, stride, ptr);
	}

}
