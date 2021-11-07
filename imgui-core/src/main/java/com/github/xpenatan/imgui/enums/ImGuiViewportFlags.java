package com.github.xpenatan.imgui.enums;

public class ImGuiViewportFlags {
	private static ImGuiViewportFlags Custom = new ImGuiViewportFlags(0);
	public static ImGuiViewportFlags None = new ImGuiViewportFlags(0);
	public static ImGuiViewportFlags IsPlatformWindow = new ImGuiViewportFlags(1 << 0);
	public static ImGuiViewportFlags IsPlatformMonitor = new ImGuiViewportFlags(1 << 1);
	public static ImGuiViewportFlags OwnedByApp = new ImGuiViewportFlags(1 << 2);
	public static ImGuiViewportFlags NoDecoration = new ImGuiViewportFlags(1 << 3);
	public static ImGuiViewportFlags NoTaskBarIcon = new ImGuiViewportFlags(1 << 4);
	public static ImGuiViewportFlags NoFocusOnAppearing = new ImGuiViewportFlags(1 << 5);
	public static ImGuiViewportFlags NoFocusOnClick = new ImGuiViewportFlags(1 << 6);
	public static ImGuiViewportFlags NoInputs = new ImGuiViewportFlags(1 << 7);
	public static ImGuiViewportFlags NoRendererClear = new ImGuiViewportFlags(1 << 8);
	public static ImGuiViewportFlags TopMost = new ImGuiViewportFlags(1 << 9);
	public static ImGuiViewportFlags Minimized = new ImGuiViewportFlags(1 << 10);
	public static ImGuiViewportFlags NoAutoMerge = new ImGuiViewportFlags(1 << 11);
	public static ImGuiViewportFlags CanHostOtherWindows = new ImGuiViewportFlags(1 << 12);

	int value;

	private ImGuiViewportFlags(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public ImGuiViewportFlags or(ImGuiViewportFlags otherEnum) {
		ImGuiViewportFlags.Custom.value = value | otherEnum.value;
		return ImGuiViewportFlags.Custom;
	}
}
