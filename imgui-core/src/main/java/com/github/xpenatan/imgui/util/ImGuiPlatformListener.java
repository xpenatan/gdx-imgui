package com.github.xpenatan.imgui.util;

import com.github.xpenatan.imgui.ImVec2;

public interface ImGuiPlatformListener {
    public void CreateWindow();
    public void ShowWindow();
    public void DestroyWindow();
    public void SetWindowPos();
    public ImVec2 GetWindowPos();
    public void SetWindowSize();
    public ImVec2 GetWindowSize();
    public void SetWindowFocus();
    public boolean GetWindowFocus();
    public boolean GetWindowMinimized();
    public void SetWindowTitle();
    public void RenderWindow();
    public void SwapBuffers();
}