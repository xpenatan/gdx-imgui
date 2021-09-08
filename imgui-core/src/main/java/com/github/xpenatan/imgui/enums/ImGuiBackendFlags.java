package com.github.xpenatan.imgui.enums;

/**
 * Back-end capabilities flags stored in io.BackendFlags. Set by imgui_impl_xxx or custom back-end.
 */
public class ImGuiBackendFlags {
	private static ImGuiBackendFlags Custom = new ImGuiBackendFlags(0);
	public static ImGuiBackendFlags None = new ImGuiBackendFlags(0);
	public static ImGuiBackendFlags HasGamepad = new ImGuiBackendFlags(1 << 0);
	public static ImGuiBackendFlags HasMouseCursors = new ImGuiBackendFlags(1 << 1);
	public static ImGuiBackendFlags HasSetMousePos = new ImGuiBackendFlags(1 << 2);
	public static ImGuiBackendFlags RendererHasVtxOffset = new ImGuiBackendFlags(1 << 3);
	public static ImGuiBackendFlags PlatformHasViewports = new ImGuiBackendFlags(1 << 10);
	public static ImGuiBackendFlags HasMouseHoveredViewport = new ImGuiBackendFlags(1 << 11);
	public static ImGuiBackendFlags RendererHasViewports = new ImGuiBackendFlags(1 << 12);

	int value;

	private ImGuiBackendFlags(int code) {
		value = code;
	}

	public ImGuiBackendFlags or(ImGuiBackendFlags otherEnum) {
		ImGuiBackendFlags.Custom.value = value | otherEnum.value;
		return ImGuiBackendFlags.Custom;
	}

	public int getValue() {
		return value;
	}
}
