package com.github.xpenatan.imgui.gdx.utils;

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

import com.badlogic.gdx.graphics.GL30;

/**
* This class was originally from XpeEngine and its now public. <br><br>
*
* @author xpenatan
*/
public class EmuGL30 extends EmuGL20<GL30> implements GL30 {

	public EmuGL30(GL30 gdxGL30) {
		super(gdxGL30);
	}

	@Override
	public void glReadBuffer (int mode)
	{
		gdxGL.glReadBuffer(mode);
	}

	@Override
	public void glDrawRangeElements (int mode, int start, int end, int count, int type, Buffer indices)
	{
		gdxGL.glDrawRangeElements(mode, start, end, count, type, indices);
	}

	@Override
	public void glDrawRangeElements (int mode, int start, int end, int count, int type, int offset)
	{
		gdxGL.glDrawRangeElements(mode, start, end, count, type, offset);
	}

	@Override
	public void glTexImage3D (int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, Buffer pixels)
	{
		gdxGL.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, pixels);
	}

	@Override
	public void glTexImage3D (int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, int offset)
	{
		gdxGL.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, offset);
	}

	@Override
	public void glTexSubImage3D (int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Buffer pixels)
	{
		gdxGL.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
	}

	@Override
	public void glTexSubImage3D (int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, int offset)
	{
		gdxGL.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, offset);
	}

	@Override
	public void glCopyTexSubImage3D (int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height)
	{
		gdxGL.glCopyTexSubImage3D(target, level, xoffset, yoffset, zoffset, x, y, width, height);
	}

	@Override
	public void glGenQueries (int n, int[] ids, int offset)
	{
		gdxGL.glGenQueries(n, ids, offset);
	}

	@Override
	public void glGenQueries (int n, IntBuffer ids)
	{
		gdxGL.glGenQueries(n, ids);
	}

	@Override
	public void glDeleteQueries (int n, int[] ids, int offset)
	{
		gdxGL.glDeleteQueries(n, ids, offset);
	}

	@Override
	public void glDeleteQueries (int n, IntBuffer ids)
	{
		gdxGL.glDeleteQueries(n, ids);
	}

	@Override
	public boolean glIsQuery (int id)
	{
		return gdxGL.glIsQuery(id);
	}

	@Override
	public void glBeginQuery (int target, int id)
	{
		gdxGL.glBeginQuery(target, id);
	}

	@Override
	public void glEndQuery (int target)
	{
		gdxGL.glEndQuery(target);
	}

	@Override
	public void glGetQueryiv (int target, int pname, IntBuffer params)
	{
		gdxGL.glGetQueryiv(target, pname, params);
	}

	@Override
	public void glGetQueryObjectuiv (int id, int pname, IntBuffer params)
	{
		gdxGL.glGetQueryObjectuiv(id, pname, params);
	}

	@Override
	public boolean glUnmapBuffer (int target)
	{
		return gdxGL.glUnmapBuffer(target);
	}

	@Override
	public Buffer glGetBufferPointerv (int target, int pname)
	{
		return gdxGL.glGetBufferPointerv(target, pname);
	}

	@Override
	public void glDrawBuffers (int n, IntBuffer bufs)
	{
		gdxGL.glDrawBuffers(n, bufs);
	}

	@Override
	public void glUniformMatrix2x3fv (int location, int count, boolean transpose, FloatBuffer value)
	{
		gdxGL.glUniformMatrix2x3fv(location, count, transpose, value);
	}

	@Override
	public void glUniformMatrix3x2fv (int location, int count, boolean transpose, FloatBuffer value)
	{
		gdxGL.glUniformMatrix3x2fv(location, count, transpose, value);
	}

	@Override
	public void glUniformMatrix2x4fv (int location, int count, boolean transpose, FloatBuffer value)
	{
		gdxGL.glUniformMatrix2x4fv(location, count, transpose, value);
	}

	@Override
	public void glUniformMatrix4x2fv (int location, int count, boolean transpose, FloatBuffer value)
	{
		gdxGL.glUniformMatrix4x2fv(location, count, transpose, value);
	}

	@Override
	public void glUniformMatrix3x4fv (int location, int count, boolean transpose, FloatBuffer value)
	{
		gdxGL.glUniformMatrix3x4fv(location, count, transpose, value);
	}

	@Override
	public void glUniformMatrix4x3fv (int location, int count, boolean transpose, FloatBuffer value)
	{
		gdxGL.glUniformMatrix4x3fv(location, count, transpose, value);
	}

	@Override
	public void glBlitFramebuffer (int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter)
	{
		gdxGL.glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
	}

	@Override
	public void glRenderbufferStorageMultisample (int target, int samples, int internalformat, int width, int height)
	{
		gdxGL.glRenderbufferStorageMultisample(target, samples, internalformat, width, height);
	}

	@Override
	public void glFramebufferTextureLayer (int target, int attachment, int texture, int level, int layer)
	{
		gdxGL.glFramebufferTextureLayer(target, attachment, texture, level, layer);
	}

	@Override
	public void glFlushMappedBufferRange (int target, int offset, int length)
	{
		gdxGL.glFlushMappedBufferRange(target, offset, length);
	}

	@Override
	public void glBindVertexArray (int array)
	{
		gdxGL.glBindVertexArray(array);
	}

	@Override
	public void glDeleteVertexArrays (int n, int[] arrays, int offset)
	{
		gdxGL.glDeleteVertexArrays(n, arrays, offset);
	}

	@Override
	public void glDeleteVertexArrays (int n, IntBuffer arrays)
	{
		gdxGL.glDeleteVertexArrays(n, arrays);
	}

	@Override
	public void glGenVertexArrays (int n, int[] arrays, int offset)
	{
		gdxGL.glGenVertexArrays(n, arrays, offset);
	}

	@Override
	public void glGenVertexArrays (int n, IntBuffer arrays)
	{
		gdxGL.glGenVertexArrays(n, arrays);
	}

	@Override
	public boolean glIsVertexArray (int array)
	{
		return gdxGL.glIsVertexArray(array);
	}

	@Override
	public void glBeginTransformFeedback (int primitiveMode)
	{
		gdxGL.glBeginTransformFeedback(primitiveMode);
	}

	@Override
	public void glEndTransformFeedback ()
	{
		gdxGL.glEndTransformFeedback();
	}

	@Override
	public void glBindBufferRange (int target, int index, int buffer, int offset, int size)
	{
		gdxGL.glBindBufferRange(target, index, buffer, offset, size);
	}

	@Override
	public void glBindBufferBase (int target, int index, int buffer)
	{
		gdxGL.glBindBufferBase(target, index, buffer);
	}

	@Override
	public void glTransformFeedbackVaryings (int program, String[] varyings, int bufferMode)
	{
		gdxGL.glTransformFeedbackVaryings(program, varyings, bufferMode);
	}

	@Override
	public void glVertexAttribIPointer (int index, int size, int type, int stride, int offset)
	{
		gdxGL.glVertexAttribIPointer(index, size, type, stride, offset);
	}

	@Override
	public void glGetVertexAttribIiv (int index, int pname, IntBuffer params)
	{
		gdxGL.glGetVertexAttribIiv(index, pname, params);
	}

	@Override
	public void glGetVertexAttribIuiv (int index, int pname, IntBuffer params)
	{
		gdxGL.glGetVertexAttribIuiv(index, pname, params);
	}

	@Override
	public void glVertexAttribI4i (int index, int x, int y, int z, int w)
	{
		gdxGL.glVertexAttribI4i(index, x, y, z, w);
	}

	@Override
	public void glVertexAttribI4ui (int index, int x, int y, int z, int w)
	{
		gdxGL.glVertexAttribI4ui(index, x, y, z, w);
	}

	@Override
	public void glGetUniformuiv (int program, int location, IntBuffer params)
	{
		gdxGL.glGetUniformuiv(program, location, params);
	}

	@Override
	public int glGetFragDataLocation (int program, String name)
	{
		return gdxGL.glGetFragDataLocation(program, name);
	}

	@Override
	public void glUniform1uiv (int location, int count, IntBuffer value)
	{
		gdxGL.glUniform1uiv(location, count, value);
	}

	@Override
	public void glUniform3uiv (int location, int count, IntBuffer value)
	{
		gdxGL.glUniform3uiv(location, count, value);
	}

	@Override
	public void glUniform4uiv (int location, int count, IntBuffer value)
	{
		gdxGL.glUniform4uiv(location, count, value);
	}

	@Override
	public void glClearBufferiv (int buffer, int drawbuffer, IntBuffer value)
	{
		gdxGL.glClearBufferiv(buffer, drawbuffer, value);
	}

	@Override
	public void glClearBufferuiv (int buffer, int drawbuffer, IntBuffer value)
	{
		gdxGL.glClearBufferuiv(buffer, drawbuffer, value);
	}

	@Override
	public void glClearBufferfv (int buffer, int drawbuffer, FloatBuffer value)
	{
		gdxGL.glClearBufferfv(buffer, drawbuffer, value);
	}

	@Override
	public void glClearBufferfi (int buffer, int drawbuffer, float depth, int stencil)
	{
		gdxGL.glClearBufferfi(buffer, drawbuffer, depth, stencil);
	}

	@Override
	public String glGetStringi (int name, int index)
	{
		return gdxGL.glGetStringi(name, index);
	}

	@Override
	public void glCopyBufferSubData (int readTarget, int writeTarget, int readOffset, int writeOffset, int size)
	{
		gdxGL.glCopyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size);
	}

	@Override
	public void glGetUniformIndices (int program, String[] uniformNames, IntBuffer uniformIndices)
	{
		gdxGL.glGetUniformIndices(program, uniformNames, uniformIndices);
	}

	@Override
	public void glGetActiveUniformsiv (int program, int uniformCount, IntBuffer uniformIndices, int pname, IntBuffer params)
	{
		gdxGL.glGetActiveUniformsiv(program, uniformCount, uniformIndices, pname, params);
	}

	@Override
	public int glGetUniformBlockIndex (int program, String uniformBlockName)
	{
		return gdxGL.glGetUniformBlockIndex(program, uniformBlockName);
	}

	@Override
	public void glGetActiveUniformBlockiv (int program, int uniformBlockIndex, int pname, IntBuffer params)
	{
		gdxGL.glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params);
	}

	@Override
	public void glGetActiveUniformBlockName (int program, int uniformBlockIndex, Buffer length, Buffer uniformBlockName)
	{
		gdxGL.glGetActiveUniformBlockName(program, uniformBlockIndex, length, uniformBlockName);
	}

	@Override
	public String glGetActiveUniformBlockName (int program, int uniformBlockIndex)
	{
		return gdxGL.glGetActiveUniformBlockName(program, uniformBlockIndex);
	}

	@Override
	public void glUniformBlockBinding (int program, int uniformBlockIndex, int uniformBlockBinding)
	{
		gdxGL.glUniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding);
	}

	@Override
	public void glDrawArraysInstanced (int mode, int first, int count, int instanceCount)
	{
		gdxGL.glDrawArraysInstanced(mode, first, count, instanceCount);
	}

	@Override
	public void glDrawElementsInstanced (int mode, int count, int type, int indicesOffset, int instanceCount)
	{
		gdxGL.glDrawElementsInstanced(mode, count, type, indicesOffset, instanceCount);
	}

	@Override
	public void glGetInteger64v (int pname, LongBuffer params)
	{
		gdxGL.glGetInteger64v(pname, params);
	}

	@Override
	public void glGetBufferParameteri64v (int target, int pname, LongBuffer params)
	{
		gdxGL.glGetBufferParameteri64v(target, pname, params);
	}

	@Override
	public void glGenSamplers (int count, int[] samplers, int offset)
	{
		gdxGL.glGenSamplers(count, samplers, offset);
	}

	@Override
	public void glGenSamplers (int count, IntBuffer samplers)
	{
		gdxGL.glGenSamplers(count, samplers);
	}

	@Override
	public void glDeleteSamplers (int count, int[] samplers, int offset)
	{
		gdxGL.glDeleteSamplers(count, samplers, offset);
	}

	@Override
	public void glDeleteSamplers (int count, IntBuffer samplers)
	{
		gdxGL.glDeleteSamplers(count, samplers);
	}

	@Override
	public boolean glIsSampler (int sampler)
	{
		return gdxGL.glIsSampler(sampler);
	}

	@Override
	public void glBindSampler (int unit, int sampler)
	{
		gdxGL.glBindSampler(unit, sampler);
	}

	@Override
	public void glSamplerParameteri (int sampler, int pname, int param)
	{
		gdxGL.glSamplerParameteri(sampler, pname, param);
	}

	@Override
	public void glSamplerParameteriv (int sampler, int pname, IntBuffer param)
	{
		gdxGL.glSamplerParameteriv(sampler, pname, param);
	}

	@Override
	public void glSamplerParameterf (int sampler, int pname, float param)
	{
		gdxGL.glSamplerParameterf(sampler, pname, param);
	}

	@Override
	public void glSamplerParameterfv (int sampler, int pname, FloatBuffer param)
	{
		gdxGL.glSamplerParameterfv(sampler, pname, param);
	}

	@Override
	public void glGetSamplerParameteriv (int sampler, int pname, IntBuffer params)
	{
		gdxGL.glGetSamplerParameteriv(sampler, pname, params);
	}

	@Override
	public void glGetSamplerParameterfv (int sampler, int pname, FloatBuffer params)
	{
		gdxGL.glGetSamplerParameterfv(sampler, pname, params);
	}

	@Override
	public void glVertexAttribDivisor (int index, int divisor)
	{
		gdxGL.glVertexAttribDivisor(index, divisor);
	}

	@Override
	public void glBindTransformFeedback (int target, int id)
	{
		gdxGL.glBindTransformFeedback(target, id);
	}

	@Override
	public void glDeleteTransformFeedbacks (int n, int[] ids, int offset)
	{
		gdxGL.glDeleteTransformFeedbacks(n, ids, offset);
	}

	@Override
	public void glDeleteTransformFeedbacks (int n, IntBuffer ids)
	{
		gdxGL.glDeleteTransformFeedbacks(n, ids);
	}

	@Override
	public void glGenTransformFeedbacks (int n, int[] ids, int offset)
	{
		gdxGL.glGenTransformFeedbacks(n, ids, offset);
	}

	@Override
	public void glGenTransformFeedbacks (int n, IntBuffer ids)
	{
		gdxGL.glGenTransformFeedbacks(n, ids);
	}

	@Override
	public boolean glIsTransformFeedback (int id)
	{
		return gdxGL.glIsTransformFeedback(id);
	}

	@Override
	public void glPauseTransformFeedback ()
	{
		gdxGL.glPauseTransformFeedback();
	}

	@Override
	public void glResumeTransformFeedback ()
	{
		gdxGL.glResumeTransformFeedback();
	}

	@Override
	public void glProgramParameteri (int program, int pname, int value)
	{
		gdxGL.glProgramParameteri(program, pname, value);
	}

	@Override
	public void glInvalidateFramebuffer (int target, int numAttachments, IntBuffer attachments)
	{
		gdxGL.glInvalidateFramebuffer(target, numAttachments, attachments);
	}

	@Override
	public void glInvalidateSubFramebuffer (int target, int numAttachments, IntBuffer attachments, int x, int y, int width, int height)
	{
		gdxGL.glInvalidateSubFramebuffer(target, numAttachments, attachments, x, y, width, height);
	}

}
