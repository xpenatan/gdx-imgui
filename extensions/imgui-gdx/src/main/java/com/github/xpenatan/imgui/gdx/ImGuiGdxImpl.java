package com.github.xpenatan.imgui.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.BufferUtils;
import com.github.xpenatan.imgui.ImDrawData;
import com.github.xpenatan.imgui.ImGui;
import com.github.xpenatan.imgui.TexDataRGBA32;
import com.github.xpenatan.imgui.enums.ImGuiKey;

import java.nio.IntBuffer;

/**
 *
 * @author xpenatan
 */
public class ImGuiGdxImpl {

	private VertexAttributes vertexAttributes;

	private int VboHandle;
	private int ElementsHandle;
	private Matrix4 matrix = new Matrix4();

	private ShaderProgram shader;

	private int g_FontTexture;



	private String vertex_shader_glsl_130 = "uniform mat4 ProjMtx;\n" + "attribute vec2 Position;\n" + "attribute vec2 UV;\n"
			+ "attribute vec4 Color;\n" + "varying vec2 Frag_UV;\n" + "varying vec4 Frag_Color;\n" + "void main()\n"
			+ "{\n" + "    Frag_UV = UV;\n" + "    Frag_Color = Color;\n"
			+ "    gl_Position = ProjMtx * vec4(Position.xy,0,1);\n" + "}\n";

	private String fragment_shader_glsl_130 = "#ifdef GL_ES\n" + "    precision mediump float;\n" + "#endif\n"
			+ "uniform sampler2D Texture;\n" + "varying vec2 Frag_UV;\n" + "varying vec4 Frag_Color;\n"
			+ "void main()\n" + "{\n" + "    gl_FragColor = Frag_Color * texture2D(Texture, Frag_UV.st);\n" + "}\n";

	private final IntBuffer glTmpBuffer;

	public ImGuiGdxImpl() {
		glTmpBuffer = BufferUtils.newIntBuffer(1);
		vertexAttributes = new VertexAttributes(new VertexAttribute[] {
				new VertexAttribute(Usage.Position, 2, GL20.GL_FLOAT, false, "Position"),
				new VertexAttribute(Usage.TextureCoordinates, 2, GL20.GL_FLOAT, false, "UV"),
				new VertexAttribute(Usage.ColorPacked, 4, GL20.GL_UNSIGNED_BYTE, true, "Color") });

		shader = new ShaderProgram(vertex_shader_glsl_130, fragment_shader_glsl_130);
		if (shader.isCompiled() == false) {
			Gdx.app.log("ShaderTest", shader.getLog());
			Gdx.app.exit();
		}

		prepareFont();
		initKeyMap();
		createBufferObject();
	}

	private void initKeyMap() {
		int [] keys = new int[ImGuiKey.COUNT.getValue()];
		keys[ImGuiKey.Tab.getValue()] = Input.Keys.TAB;
		keys[ImGuiKey.LeftArrow.getValue()] = Input.Keys.LEFT;
		keys[ImGuiKey.RightArrow.getValue()] = Input.Keys.RIGHT;
		keys[ImGuiKey.UpArrow.getValue()] = Input.Keys.UP;
		keys[ImGuiKey.DownArrow.getValue()] = Input.Keys.DOWN;
		keys[ImGuiKey.PageUp.getValue()] = Input.Keys.PAGE_UP;
		keys[ImGuiKey.PageDown.getValue()] = Input.Keys.PAGE_DOWN;
		keys[ImGuiKey.Home.getValue()] = Input.Keys.HOME;
		keys[ImGuiKey.End.getValue()] = Input.Keys.END;
		keys[ImGuiKey.Insert.getValue()] = Input.Keys.INSERT;
		keys[ImGuiKey.Delete.getValue()] =Input.Keys. FORWARD_DEL;
		keys[ImGuiKey.Backspace.getValue()] = Input.Keys.BACKSPACE;
		keys[ImGuiKey.Space.getValue()] = Input.Keys.SPACE;
		keys[ImGuiKey.Enter.getValue()] = Input.Keys.ENTER;
		keys[ImGuiKey.Escape.getValue()] = Input.Keys.ESCAPE;
		keys[ImGuiKey.KeyPadEnter.getValue()] = Input.Keys.NUMPAD_ENTER;
		keys[ImGuiKey.A.getValue()] = Input.Keys.A;
		keys[ImGuiKey.C.getValue()] = Input.Keys.C;
		keys[ImGuiKey.V.getValue()] = Input.Keys.V;
		keys[ImGuiKey.X.getValue()] = Input.Keys.X;
		keys[ImGuiKey.Y.getValue()] = Input.Keys.Y;
		keys[ImGuiKey.Z.getValue()] = Input.Keys.Z;
		ImGui.initKeyMap(keys);
	}

	private void prepareFont() {
		TexDataRGBA32 texData = new TexDataRGBA32();
		ImGui.GetTexDataAsRGBA32(texData, texData.pixelBuffer);

		g_FontTexture = Gdx.gl.glGenTexture();

		Gdx.gl.glBindTexture(GL20.GL_TEXTURE_2D, g_FontTexture);
		Gdx.gl.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MIN_FILTER, GL20.GL_LINEAR);
		Gdx.gl.glTexParameteri(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MAG_FILTER, GL20.GL_LINEAR);

		Gdx.gl.glPixelStorei(GL20.GL_UNPACK_ALIGNMENT, 1);
		Gdx.gl.glTexImage2D(GL20.GL_TEXTURE_2D, 0, GL20.GL_RGBA, texData.width, texData.height, 0, GL20.GL_RGBA,
				GL20.GL_UNSIGNED_BYTE, texData.pixelBuffer);

		ImGui.SetFontTexID(g_FontTexture);
	}

	private void createBufferObject() {
		VboHandle = Gdx.gl20.glGenBuffer();
		ElementsHandle = Gdx.gl20.glGenBuffer();
//		Gdx.gl20.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, ibufferHandle);
//		Gdx.gl20.glBufferData(GL20.GL_ELEMENT_ARRAY_BUFFER, drawData.iByteBuffer.capacity(), null, GL20.GL_STATIC_DRAW);
//		Gdx.gl20.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, 0);
	}

	public void update() {
		update(null);
	}

	public void update(ImGuiGdxInput inputProcessor) {
		float deltaTime = Gdx.graphics.getDeltaTime();
		int x = Gdx.input.getX();
		int y = Gdx.input.getY();
		int width = Gdx.graphics.getWidth();
		int height = Gdx.graphics.getHeight();

		int backBufferWidth = Gdx.graphics.getBackBufferWidth();
		int backBufferHeight = Gdx.graphics.getBackBufferHeight();

		boolean mouseDown0 = Gdx.input.isButtonPressed(Buttons.LEFT);
		boolean mouseDown1 = Gdx.input.isButtonPressed(Buttons.RIGHT);
		boolean mouseDown2 = Gdx.input.isButtonPressed(Buttons.MIDDLE);

		if(inputProcessor != null) {
			mouseDown0 = inputProcessor.mouseDown0;
			mouseDown1 = inputProcessor.mouseDown1;
			mouseDown2 = inputProcessor.mouseDown2;
		}
		updateFrame(deltaTime, width, height, backBufferWidth, backBufferHeight,
				x, y, mouseDown0, mouseDown1, mouseDown2);
	}

	protected void updateFrame(float deltaTime, int width, int height, int backBufferWidth, int backBufferHeight,
							   int mouseX, int mouseY, boolean mouseDown0, boolean mouseDown1, boolean mouseDown2) {
		ImGui.UpdateDisplayAndInputAndFrame(deltaTime, width, height, backBufferWidth, backBufferHeight,
				mouseX, mouseY, mouseDown0, mouseDown1, mouseDown2);
	}

	public void render(ImDrawData drawData) {
		renderDrawData(drawData);
	}

	public void renderDrawData(ImDrawData drawData) {
		if (drawData.cmdListsCount > 0) {
			Gdx.gl.glGetIntegerv(GL20.GL_CURRENT_PROGRAM, glTmpBuffer);
			int last_program = glTmpBuffer.get(0);
			Gdx.gl.glGetIntegerv(GL20.GL_TEXTURE_BINDING_2D, glTmpBuffer);
			int last_texture = glTmpBuffer.get(0);
			Gdx.gl.glGetIntegerv(GL20.GL_ARRAY_BUFFER_BINDING, glTmpBuffer);
			int last_array_buffer = glTmpBuffer.get(0);

			boolean last_enable_blend = Gdx.gl.glIsEnabled(GL20.GL_BLEND);
			boolean last_enable_cull_face = Gdx.gl.glIsEnabled(GL20.GL_CULL_FACE);
			boolean last_enable_depth_test = Gdx.gl.glIsEnabled(GL20.GL_DEPTH_TEST);
			boolean last_enable_stencil_test = Gdx.gl.glIsEnabled(GL20.GL_STENCIL_TEST);
			boolean last_enable_scissor_test = Gdx.gl.glIsEnabled(GL20.GL_SCISSOR_TEST);

			int fb_width = (int) (drawData.displaySizeX * drawData.framebufferScaleX);
			int fb_height = (int) (drawData.displaySizeY * drawData.framebufferScaleY);

			setupRenderState(drawData, fb_width, fb_height);

			float clip_offX = drawData.displayPosX; // (0,0) unless using multi-viewports
			float clip_offY = drawData.displayPosY;
			float clip_scaleX = drawData.framebufferScaleX; // (1,1) unless using retina display which are often (2,2)
			float clip_scaleY = drawData.framebufferScaleY;

//			bind(drawData);

			int verticesOffset = 0;
			int indicesOffset = 0;

			for(int i = 0; i < drawData.cmdListsCount; i++) {
				drawData.vByteBuffer.limit(verticesOffset + 4);
				int verticeSize = (int)drawData.vByteBuffer.getFloat(verticesOffset);

				drawData.iByteBuffer.limit(indicesOffset + 2);
				short indexSize = (short)drawData.iByteBuffer.getShort(indicesOffset);
				int cmdSize = (int)drawData.cmdByteBuffer.getFloat();

				int verticesStartOffset = verticesOffset + 4;
				int indexStartOffset = indicesOffset + 2;

				drawData.vByteBuffer.position(verticesStartOffset);
				drawData.iByteBuffer.position(indexStartOffset);

				int newVlimit = verticesStartOffset + verticeSize * ImDrawData.vBufferSize;
				int newIlimit = indexStartOffset + indexSize * ImDrawData.iBufferSize;

				drawData.vByteBuffer.limit(newVlimit);
				drawData.iByteBuffer.limit(newIlimit);

				Gdx.gl.glBufferData(GL20.GL_ARRAY_BUFFER, drawData.vByteBuffer.limit(), drawData.vByteBuffer, GL20.GL_STREAM_DRAW);
				Gdx.gl.glBufferData(GL20.GL_ELEMENT_ARRAY_BUFFER, drawData.iByteBuffer.limit(), drawData.iByteBuffer, GL20.GL_STREAM_DRAW);

				verticesOffset += ((verticeSize) * ImDrawData.vBufferSize) + 4;
				indicesOffset += ((indexSize) * ImDrawData.iBufferSize) + 2;

				for (int j = 0; j < cmdSize; j++) {

					float clipRectX = drawData.cmdByteBuffer.getFloat();
					float clipRectY = drawData.cmdByteBuffer.getFloat();
					float clipRectZ = drawData.cmdByteBuffer.getFloat();
					float clipRectW = drawData.cmdByteBuffer.getFloat();
					int textureID = (int) drawData.cmdByteBuffer.getFloat();
					int vtxOffset = (int) drawData.cmdByteBuffer.getFloat();
					int idxOffset = (int) drawData.cmdByteBuffer.getFloat();
					int elemCount = (int) drawData.cmdByteBuffer.getFloat();
					float clip_minX = (clipRectX - clip_offX) * clip_scaleX;
					float clip_minY = (clipRectY - clip_offY) * clip_scaleY;
					float clip_maxX = (clipRectZ - clip_offX) * clip_scaleX;
					float clip_maxY = (clipRectW - clip_offY) * clip_scaleY;

					if (clip_maxX < clip_minX || clip_maxY < clip_minY)
						continue;

					Gdx.gl.glScissor((int) clip_minX, (int) (fb_height - clip_maxY), (int) (clip_maxX - clip_minX), (int) (clip_maxY - clip_minY));
					Gdx.gl.glBindTexture(GL20.GL_TEXTURE_2D, textureID);
					Gdx.gl.glDrawElements(GL20.GL_TRIANGLES, elemCount, GL20.GL_UNSIGNED_SHORT, idxOffset * 2);
				}
			}

			unbind();

			if(last_enable_blend) {
				Gdx.gl.glEnable(GL20.GL_BLEND);
			}
			else {
				Gdx.gl.glDisable(GL20.GL_BLEND);
			}
			if(last_enable_cull_face) {
				Gdx.gl.glEnable(GL20.GL_CULL_FACE);
			}
			else {
				Gdx.gl.glDisable(GL20.GL_CULL_FACE);
			}
			if(last_enable_depth_test) {
				Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);
			}
			else {
				Gdx.gl.glDisable(GL20.GL_DEPTH_TEST);
			}
			if(last_enable_stencil_test) {
				Gdx.gl.glEnable(GL20.GL_STENCIL_TEST);
			}
			else {
				Gdx.gl.glDisable(GL20.GL_STENCIL_TEST);
			}
			if(last_enable_scissor_test) {
				Gdx.gl.glEnable(GL20.GL_SCISSOR_TEST);
			}
			else {
				Gdx.gl.glDisable(GL20.GL_SCISSOR_TEST);
			}
		}
	}

	private void setupRenderState(ImDrawData drawData, int fb_width, int fb_height) {
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendEquation(GL20.GL_FUNC_ADD);
		Gdx.gl.glBlendFuncSeparate(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA, GL20.GL_ONE, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glDisable(GL20.GL_CULL_FACE);
		Gdx.gl.glDisable(GL20.GL_DEPTH_TEST);
		Gdx.gl.glDisable(GL20.GL_STENCIL_TEST);
		Gdx.gl.glEnable(GL20.GL_SCISSOR_TEST);
		Gdx.gl.glEnable(GL20.GL_SCISSOR_TEST);

		float L = drawData.displayPosX;
		float R = drawData.displayPosX + drawData.displaySizeX;
		float T = drawData.displayPosY;
		float B = drawData.displayPosY + drawData.displaySizeY;

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

		shader.bind();
		shader.setUniformi("Texture", 0);
		shader.setUniformMatrix("ProjMtx", matrix);

		Gdx.gl.glBindBuffer(GL20.GL_ARRAY_BUFFER, VboHandle);
		Gdx.gl.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, ElementsHandle);

		// bind vertices/indices
		final int numAttributes = vertexAttributes.size();
		for (int i = 0; i < numAttributes; i++) {
			final VertexAttribute attribute = vertexAttributes.get(i);
			final int location = shader.getAttributeLocation(attribute.alias);
			if (location < 0) continue;
			shader.enableVertexAttribute(location);
			shader.setVertexAttribute(location, attribute.numComponents, attribute.type, attribute.normalized,
					vertexAttributes.vertexSize, attribute.offset);
		}
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

		// TODO fix exception
//		ImGui.DestroyPlatformWindows();
		Gdx.gl.glBindBuffer(GL20.GL_ELEMENT_ARRAY_BUFFER, 0);
		Gdx.gl.glDeleteBuffer(ElementsHandle);
		ElementsHandle = 0;
	}
}
