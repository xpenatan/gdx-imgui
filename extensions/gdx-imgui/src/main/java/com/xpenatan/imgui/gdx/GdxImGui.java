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
}
