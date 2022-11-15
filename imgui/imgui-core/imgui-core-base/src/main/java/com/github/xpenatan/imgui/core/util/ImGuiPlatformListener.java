package com.github.xpenatan.imgui.core.util;

import com.github.xpenatan.imgui.core.ImGuiViewport;
import com.github.xpenatan.imgui.core.ImVec2;

public interface ImGuiPlatformListener {
    public void CreateWindow(ImGuiViewport viewport);

    public void DestroyWindow(long platformHandle, int platformUserData);

    public void ShowWindow(long platformHandle, int platformUserData);

    public void SetWindowPos(long platformHandle, int platformUserData, float x, float y);

    public ImVec2 GetWindowPos(long platformHandle, int platformUserData);

    public void SetWindowSize(long platformHandle, int platformUserData, float width, float height);

    public ImVec2 GetWindowSize(long platformHandle, int platformUserData);

    public void SetWindowFocus(long platformHandle, int platformUserData);

    public boolean GetWindowFocus(long platformHandle, int platformUserData);

    public boolean GetWindowMinimized(long platformHandle, int platformUserData);

    public void SetWindowTitle(long platformHandle, int platformUserData, String title);

    public void PlatformRenderWindow(long platformHandle, int platformUserData);

    public void RendererRenderWindow(ImGuiViewport viewport);

    public void SwapBuffers(long platformHandle, int platformUserData);
}