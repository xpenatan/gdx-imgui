package com.github.xpenatan.imgui.core.util;

public interface ImGuiPlatformListener {
    public void CreateWindow(long viewportAddr);

    public void DestroyWindow(long platformHandle, int platformUserData);

    public void ShowWindow(long platformHandle, int platformUserData);

    public void SetWindowPos(long platformHandle, int platformUserData, float x, float y);

    public long GetWindowPos(long platformHandle, int platformUserData);

    public void SetWindowSize(long platformHandle, int platformUserData, float width, float height);

    public long GetWindowSize(long platformHandle, int platformUserData);

    public void SetWindowFocus(long platformHandle, int platformUserData);

    public boolean GetWindowFocus(long platformHandle, int platformUserData);

    public boolean GetWindowMinimized(long platformHandle, int platformUserData);

    public void SetWindowTitle(long platformHandle, int platformUserData, String title);

    public void PlatformRenderWindow(long platformHandle, int platformUserData);

    public void RendererRenderWindow(long viewportAddr);

    public void SwapBuffers(long platformHandle, int platformUserData);
}