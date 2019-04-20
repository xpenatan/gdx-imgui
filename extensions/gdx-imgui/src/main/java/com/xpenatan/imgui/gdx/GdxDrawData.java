package com.xpenatan.imgui.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.xpenatan.imgui.DrawData;
import com.xpenatan.imgui.ImGuiNative;
import com.xpenatan.imgui.TexDataRGBA32;

public class GdxDrawData extends DrawData {

	private VertexAttributes vertexAttributes;

	int vbufferHandle;
	int ibufferHandle;
	Matrix4 matrix = new Matrix4();

	ShaderProgram shader;

	int g_FontTexture;

	String vertex_shader_glsl_130 = "uniform mat4 ProjMtx;\n" + "attribute vec2 Position;\n" + "attribute vec2 UV;\n"
			+ "attribute vec4 Color;\n" + "varying vec2 Frag_UV;\n" + "varying vec4 Frag_Color;\n" + "void main()\n"
			+ "{\n" + "    Frag_UV = UV;\n" + "    Frag_Color = Color;\n"
			+ "    gl_Position = ProjMtx * vec4(Position.xy,0,1);\n" + "}\n";

	String fragment_shader_glsl_130 = "#ifdef GL_ES\n" + "    precision mediump float;\n" + "#endif\n"
			+ "uniform sampler2D Texture;\n" + "varying vec2 Frag_UV;\n" + "varying vec4 Frag_Color;\n"
			+ "void main()\n" + "{\n" + "    gl_FragColor = Frag_Color * texture2D(Texture, Frag_UV.st);\n" + "}\n";

	public GdxDrawData() {
		super(100000, 100000, 1000);

		vertexAttributes = new VertexAttributes(new VertexAttribute[] {
				new VertexAttribute(Usage.Position, 2, GL20.GL_FLOAT, false, "Position"),
				new VertexAttribute(Usage.TextureCoordinates, 2, GL20.GL_FLOAT, false, "UV"),
				new VertexAttribute(Usage.ColorPacked, 4, GL20.GL_UNSIGNED_BYTE, true, "Color") });

		vbufferHandle = Gdx.gl20.glGenBuffer();
		ibufferHandle = createBufferObject();

		shader = new ShaderProgram(vertex_shader_glsl_130, fragment_shader_glsl_130);
		if (shader.isCompiled() == false) {
			Gdx.app.log("ShaderTest", shader.getLog());
			Gdx.app.exit();
		}

	}

	@Override
	protected void prepareFont() {
		TexDataRGBA32 texData = new TexDataRGBA32();
		ImGuiNative.getTexDataAsRGBA32(texData, texData.pixelBuffer);

		g_FontTexture = Gdx.gl.glGenTexture();

		Gdx.gl.glBindTexture(GL20.GL_TEXTURE_2D, g_FontTexture);
		Gdx.gl.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MIN_FILTER, GL20.GL_LINEAR);
		Gdx.gl.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MAG_FILTER, GL20.GL_LINEAR);

		Gdx.gl.glPixelStorei(GL20.GL_UNPACK_ALIGNMENT, 1);
		Gdx.gl.glTexImage2D(GL20.GL_TEXTURE_2D, 0, GL20.GL_RGBA, texData.width, texData.height, 0, GL20.GL_RGBA,
				GL20.GL_UNSIGNED_BYTE, texData.pixelBuffer);

		ImGuiNative.setFontTexID(g_FontTexture);

	}

	private int createBufferObject() {
		int result = Gdx.gl20.glGenBuffer();
		Gdx.gl20.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, result);
		Gdx.gl20.glBufferData(GL20.GL_ELEMENT_ARRAY_BUFFER, iByteBuffer.capacity(), null, GL20.GL_STATIC_DRAW);
		Gdx.gl20.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, 0);
		return result;
	}

	public void render() {
		if (cmdListsCount > 0) {
			boolean last_enable_blend = Gdx.gl.glIsEnabled(GL20.GL_BLEND);
			boolean last_enable_cull_face = Gdx.gl.glIsEnabled(GL20.GL_CULL_FACE);
			boolean last_enable_depth_test = Gdx.gl.glIsEnabled(GL20.GL_DEPTH_TEST);
			boolean last_enable_scissor_test = Gdx.gl.glIsEnabled(GL20.GL_SCISSOR_TEST);

			int fb_width = (int) (displaySizeX * framebufferScaleX);
			int fb_height = (int) (displaySizeY * framebufferScaleY);

			bind();

			int verticeOffset = 0;
			int indexOffset = 0;

			for(int i = 0; i < cmdListsCount; i++) {
				vByteBuffer.limit(verticeOffset + 4);
				int verticeSize = (int)vByteBuffer.getFloat(verticeOffset);

				iByteBuffer.limit(indexOffset + 2);
				short indexSize = (short)iByteBuffer.getShort(indexOffset);
				int cmdSize = (int)cmdByteBuffer.getFloat();

				int verticeStartOffset = verticeOffset + 4;
				int indexStartOffset = indexOffset + 2;

				vByteBuffer.position(verticeStartOffset);
				iByteBuffer.position(indexStartOffset);

				int newVlimit = verticeStartOffset + verticeSize * DrawData.vBufferSize;
				int newIlimit = indexStartOffset + indexSize * DrawData.iBufferSize;

				vByteBuffer.limit(newVlimit);
				iByteBuffer.limit(newIlimit);

				Gdx.gl.glBufferData(GL20.GL_ARRAY_BUFFER, vByteBuffer.limit(), vByteBuffer, GL20.GL_STATIC_DRAW);
				Gdx.gl.glBufferData(GL20.GL_ELEMENT_ARRAY_BUFFER, iByteBuffer.limit(), iByteBuffer, GL20.GL_STATIC_DRAW);

				verticeOffset += ((verticeSize) * vBufferSize) + 4;
				indexOffset += ((indexSize) * iBufferSize) + 2;

				float clip_offX = displayPosX; // (0,0) unless using multi-viewports
				float clip_offY = displayPosY;
				float clip_scaleX = framebufferScaleX; // (1,1) unless using retina display which are often (2,2)
				float clip_scaleY = framebufferScaleY;

				int idx_buffer_offset = 0;

				for (int j = 0; j < cmdSize; j++) {

					int elemCount = (int) cmdByteBuffer.getFloat();
					float clipRectX = cmdByteBuffer.getFloat();
					float clipRectY = cmdByteBuffer.getFloat();
					float clipRectZ = cmdByteBuffer.getFloat();
					float clipRectW = cmdByteBuffer.getFloat();
					int textureID = (int) cmdByteBuffer.getFloat();

					float clip_rectX = (clipRectX - clip_offX) * clip_scaleX;
					float clip_rectY = (clipRectY - clip_offY) * clip_scaleY;
					float clip_rectZ = (clipRectZ - clip_offX) * clip_scaleX;
					float clip_rectW = (clipRectW - clip_offY) * clip_scaleY;

					if (clip_rectX < fb_width && clip_rectY < fb_height && clip_rectZ >= 0.0f && clip_rectW >= 0.0f) {
						Gdx.gl.glScissor((int) clip_rectX, (int) (fb_height - clip_rectW), (int) (clip_rectZ - clip_rectX),
								(int) (clip_rectW - clip_rectY));
						Gdx.gl.glBindTexture(GL20.GL_TEXTURE_2D, textureID);
						Gdx.gl.glDrawElements(GL20.GL_TRIANGLES, elemCount, GL20.GL_UNSIGNED_SHORT, idx_buffer_offset);
					}
					idx_buffer_offset += elemCount * 2;
				}
			}

			unbind();

			if (last_enable_blend) Gdx.gl.glEnable(GL20.GL_BLEND); else Gdx.gl.glDisable(GL20.GL_BLEND);
			if (last_enable_cull_face) Gdx.gl.glEnable(GL20.GL_CULL_FACE); else Gdx.gl.glDisable(GL20.GL_CULL_FACE);
			if (last_enable_depth_test) Gdx.gl.glEnable(GL20.GL_DEPTH_TEST); else Gdx.gl.glDisable(GL20.GL_DEPTH_TEST);
			if (last_enable_scissor_test) Gdx.gl.glEnable(GL20.GL_SCISSOR_TEST); else Gdx.gl.glDisable(GL20.GL_SCISSOR_TEST);
		}
	}

	@Deprecated
	public void render(Camera camera) {
		boolean last_enable_blend = Gdx.gl.glIsEnabled(GL20.GL_BLEND);
		boolean last_enable_cull_face = Gdx.gl.glIsEnabled(GL20.GL_CULL_FACE);
		boolean last_enable_depth_test = Gdx.gl.glIsEnabled(GL20.GL_DEPTH_TEST);
		boolean last_enable_scissor_test = Gdx.gl.glIsEnabled(GL20.GL_SCISSOR_TEST);

		bind();

		int fb_width = (int) (displaySizeX * framebufferScaleX);
		int fb_height = (int) (displaySizeY * framebufferScaleY);

		if (cmdListsCount > 0) {

			float clip_offX = displayPosX; // (0,0) unless using multi-viewports
			float clip_offY = displayPosY;
			float clip_scaleX = framebufferScaleX; // (1,1) unless using retina display which are often (2,2)
			float clip_scaleY = framebufferScaleY;

			int idx_buffer_offset = 0;

			Gdx.gl.glBufferData(GL20.GL_ARRAY_BUFFER, vByteBuffer.limit(), vByteBuffer, GL20.GL_STATIC_DRAW);
			Gdx.gl.glBufferData(GL20.GL_ELEMENT_ARRAY_BUFFER, iByteBuffer.limit(), iByteBuffer, GL20.GL_STATIC_DRAW);

			for (int j = 0; j < cmdCount; j++) {

				int elemCount = (int) cmdByteBuffer.getFloat();
				float clipRectX = cmdByteBuffer.getFloat();
				float clipRectY = cmdByteBuffer.getFloat();
				float clipRectZ = cmdByteBuffer.getFloat();
				float clipRectW = cmdByteBuffer.getFloat();
				int textureID = (int) cmdByteBuffer.getFloat();

				float clip_rectX = (clipRectX - clip_offX) * clip_scaleX;
				float clip_rectY = (clipRectY - clip_offY) * clip_scaleY;
				float clip_rectZ = (clipRectZ - clip_offX) * clip_scaleX;
				float clip_rectW = (clipRectW - clip_offY) * clip_scaleY;

				if (clip_rectX < fb_width && clip_rectY < fb_height && clip_rectZ >= 0.0f && clip_rectW >= 0.0f) {

					Gdx.gl.glScissor((int) clip_rectX, (int) (fb_height - clip_rectW), (int) (clip_rectZ - clip_rectX),
							(int) (clip_rectW - clip_rectY));
					Gdx.gl.glBindTexture(GL20.GL_TEXTURE_2D, textureID);
					Gdx.gl.glDrawElements(GL20.GL_TRIANGLES, elemCount, GL20.GL_UNSIGNED_SHORT, idx_buffer_offset);

				}

				idx_buffer_offset += elemCount * 2;
			}
		}

		unbind();

		if (last_enable_blend) Gdx.gl.glEnable(GL20.GL_BLEND); else Gdx.gl.glDisable(GL20.GL_BLEND);
		if (last_enable_cull_face) Gdx.gl.glEnable(GL20.GL_CULL_FACE); else Gdx.gl.glDisable(GL20.GL_CULL_FACE);
		if (last_enable_depth_test) Gdx.gl.glEnable(GL20.GL_DEPTH_TEST); else Gdx.gl.glDisable(GL20.GL_DEPTH_TEST);
		if (last_enable_scissor_test) Gdx.gl.glEnable(GL20.GL_SCISSOR_TEST); else Gdx.gl.glDisable(GL20.GL_SCISSOR_TEST);
	}

	public void bind() {
		Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);

		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendEquation(GL20.GL_FUNC_ADD);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glDisable(GL20.GL_CULL_FACE);
		Gdx.gl.glDisable(GL20.GL_DEPTH_TEST);
		Gdx.gl.glEnable(GL20.GL_SCISSOR_TEST);

		Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);

		float L = displayPosX;
		float R = displayPosX + displaySizeX;
		float T = displayPosY;
		float B = displayPosY + displaySizeY;

		//TODO use gdx camera
		matrix.val[0] = 2.0f / (R - L);
		matrix.val[1] = 0.0f;
		matrix.val[2] = 0.0f;
		matrix.val[3] = 0.0f;
		matrix.val[4] = 0.0f;
		matrix.val[5] = 2.0f / (T - B);
		matrix.val[6] = 0;
		matrix.val[7] = 0;
		matrix.val[8] = 0;
		matrix.val[9] = 0;
		matrix.val[10] = -1.0f;
		matrix.val[11] = 0f;
		matrix.val[12] = (R + L) / (L - R);
		matrix.val[13] = (T + B) / (B - T);
		matrix.val[14] = 0;
		matrix.val[15] = 1.0f;

		// bind vertice
		Gdx.gl.glBindBuffer(GL20.GL_ARRAY_BUFFER, vbufferHandle);
		final int numAttributes = vertexAttributes.size();
		for (int i = 0; i < numAttributes; i++) {
			final VertexAttribute attribute = vertexAttributes.get(i);
			final int location = shader.getAttributeLocation(attribute.alias);
			if (location < 0) continue;
			shader.enableVertexAttribute(location);
			shader.setVertexAttribute(location, attribute.numComponents, attribute.type, attribute.normalized,
					vertexAttributes.vertexSize, attribute.offset);
		}

		// bind index
		Gdx.gl.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, ibufferHandle);

		shader.begin();
		shader.setUniformMatrix("ProjMtx", matrix);
		shader.setUniformi("Texture", 0);
	}

	public void unbind() {
		// unbind vertice
		Gdx.gl.glBindBuffer(GL20.GL_ARRAY_BUFFER, 0);
		final int numAttributes = vertexAttributes.size();
		for (int i = 0; i < numAttributes; i++) {
			shader.disableVertexAttribute(vertexAttributes.get(i).alias);
		}

		// unbind index
		Gdx.gl.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, 0);
		Gdx.gl.glFlush();
		shader.end();
	}

	private void deleteTexture() {
		if (g_FontTexture != 0) {
			Gdx.gl.glDeleteTexture(g_FontTexture);
			g_FontTexture = 0;
		}
	}

	public void dispose() {
		deleteTexture();
		Gdx.gl.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, 0);
		Gdx.gl.glDeleteBuffer(ibufferHandle);
		ibufferHandle = 0;
	}

}
