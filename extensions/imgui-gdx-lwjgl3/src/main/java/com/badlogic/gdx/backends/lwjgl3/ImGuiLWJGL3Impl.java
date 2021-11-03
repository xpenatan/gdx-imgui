package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.github.xpenatan.imgui.DrawData;
import com.github.xpenatan.imgui.ImGui;
import com.github.xpenatan.imgui.ImVec2;
import com.github.xpenatan.imgui.enums.ImGuiConfigFlags;
import com.github.xpenatan.imgui.gdx.ImGuiGdxImpl;
import com.github.xpenatan.imgui.jnicode.ImGuiPlatformNative;
import com.github.xpenatan.imgui.util.ImGuiPlatformListener;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWMonitorCallback;

/**
 *
 * @author xpenatan
 */
public class ImGuiLWJGL3Impl extends ImGuiGdxImpl implements ImGuiPlatformListener {
    Lwjgl3Application app;

    private boolean updateMonitors = false;

    public ImGuiLWJGL3Impl() {
        app = (Lwjgl3Application)Gdx.app;
        Array<Lwjgl3Window> windows = app.windows;
        Lwjgl3Window lwjgl3Window = windows.get(0);
        long windowHandle = lwjgl3Window.getWindowHandle();
        ImGuiPlatformNative.InitPlatformInterface(this, windowHandle, lwjgl3Window);
        updateMonitors();
        GLFW.glfwSetMonitorCallback(new GLFWMonitorCallback() {
            @Override
            public void invoke(long monitor, int event) {
                updateMonitors = true;
            }
        });
    }

    @Override
    public void update() {
        super.update();
        if(updateMonitors) {
            updateMonitors = false;
            updateMonitors();
        }
    }

    @Override
    public void render(DrawData drawData) {
        super.render(drawData);
        if (ImGui.GetIO().ContainsConfigFlags(ImGuiConfigFlags.ViewportsEnable)) {
            ImGui.UpdatePlatformWindows();
            ImGui.RenderPlatformWindowsDefault();
        }
    }

    private void updateMonitors() {
        Array<Lwjgl3Window> windows = app.windows;

        ImGuiPlatformNative.PlatformResize(0);

        for(int i = 0; i < windows.size; i++) {
            Lwjgl3Window lwjgl3Window = windows.get(i);
            Lwjgl3Graphics graphics = lwjgl3Window.getGraphics();
            float positionX = lwjgl3Window.getPositionX();
            float positionY = lwjgl3Window.getPositionY();

            float width = graphics.getWidth();
            float height = graphics.getHeight();

            float workPosX = 0;
            float workPosY = 0;
            float workSizeX = 0;
            float workSizeY = 0;

            ImGuiPlatformNative.AddMonitors(positionX, positionY, width, height, positionX, positionY, width, height, 1);
        }
    }

    @Override
    public void CreateWindow() {

    }

    @Override
    public void ShowWindow() {

    }

    @Override
    public void DestroyWindow() {

    }

    @Override
    public void SetWindowPos() {

    }

    @Override
    public ImVec2 GetWindowPos() {
        ImVec2 tmp = ImVec2.TMP;
        tmp.x = 144;
        tmp.y = 0;
        return tmp;
    }

    @Override
    public void SetWindowSize() {

    }

    @Override
    public ImVec2 GetWindowSize() {
        ImVec2 tmp = ImVec2.TMP;
        tmp.x = 0;
        tmp.y = 0;
        return tmp;
    }

    @Override
    public void SetWindowFocus() {

    }

    @Override
    public boolean GetWindowFocus() {

        return false;
    }

    @Override
    public boolean GetWindowMinimized() {
        return false;
    }

    @Override
    public void SetWindowTitle() {

    }

    @Override
    public void RenderWindow() {

    }

    @Override
    public void SwapBuffers() {

    }
}