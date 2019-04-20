package com.xpenatan.imgui.gdx;

import java.nio.ByteBuffer;

import com.badlogic.gdx.utils.SharedLibraryLoader;
import com.xpenatan.imgui.DrawData;
import com.xpenatan.imgui.ImGui;
import com.xpenatan.imgui.ImGuiNative;

public class GdxImGui extends ImGui<GdxDrawData> {

	public static void init () {
		init(true);
	}

	public static void init (boolean logging) {
		new SharedLibraryLoader().load("gdx-imgui");
		ImGui.init(logging);
	}

	public GdxImGui() {
		super(new GdxDrawData());
	}


	@Deprecated
	public void getDrawDataOld() {
		renderDrawData(0);
		int size = drawData.cmdListsCount;

		for(int i = 1; i < size; i++) {
			renderDrawData(i);
		}
	}

	@Deprecated
	public void renderDrawData() {
		drawData.render();
	}

	@Deprecated
	public void renderDrawData(int index) {
		ByteBuffer cmdByteBuffer = drawData.cmdByteBuffer;
		ByteBuffer vByteBuffer = drawData.vByteBuffer;
		ByteBuffer iByteBuffer = drawData.iByteBuffer;

		vByteBuffer.position(0);
		vByteBuffer.limit(0);
		iByteBuffer.position(0);
		iByteBuffer.limit(0);
		cmdByteBuffer.position(0);
		cmdByteBuffer.limit(0);
		ImGuiNative.getDrawData(index, drawData, iByteBuffer, vByteBuffer, cmdByteBuffer);

		vByteBuffer.limit(drawData.vtxCount * DrawData.vBufferSize); // 4 color floats
		iByteBuffer.limit(drawData.idxCount * DrawData.iBufferSize);
		cmdByteBuffer.limit(drawData.cmdCount * DrawData.cmdBufferSize);
		drawData.render(null);
	}
}
