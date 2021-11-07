package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.LongArray;
import com.github.xpenatan.imgui.ImDrawData;
import com.github.xpenatan.imgui.ImGui;
import com.github.xpenatan.imgui.ImGuiViewport;
import com.github.xpenatan.imgui.ImVec2;
import com.github.xpenatan.imgui.enums.ImGuiConfigFlags;
import com.github.xpenatan.imgui.enums.ImGuiViewportFlags;
import com.github.xpenatan.imgui.gdx.ImGuiGdxImpl;
import com.github.xpenatan.imgui.jnicode.ImGuiPlatformNative;
import com.github.xpenatan.imgui.util.ImGuiPlatformListener;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWMonitorCallback;
import org.lwjgl.glfw.GLFWVidMode;

import java.nio.IntBuffer;

/**
 *
 * @author xpenatan
 */
public class ImGuiLWJGL3Impl extends ImGuiGdxImpl implements ImGuiPlatformListener {
    private Lwjgl3Application app;

    private boolean updateMonitors = false;
    private LongArray monitors = new LongArray();
    private Lwjgl3Window mainWindow;

    private int nextUserData = 1;

    private final IntBuffer tmpBuffer;
    private final IntBuffer tmpBuffer2;

    public ImGuiLWJGL3Impl() {
        app = (Lwjgl3Application)Gdx.app;
        Array<Lwjgl3Window> windows = app.windows;
        mainWindow = windows.get(0);
        this.tmpBuffer = BufferUtils.newIntBuffer(1);
        this.tmpBuffer2 = BufferUtils.newIntBuffer(1);
        long windowHandle = mainWindow.getWindowHandle();
        monitors.add(windowHandle);
        ImGuiPlatformNative.InitPlatformInterface(this, windowHandle, nextUserData);
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
    protected void updateFrame(float deltaTime, int width, int height, int backBufferWidth, int backBufferHeight, int mouseX, int mouseY, boolean mouseDown0, boolean mouseDown1, boolean mouseDown2) {
        if(ImGui.GetIO().ContainsConfigFlags(ImGuiConfigFlags.ViewportsEnable)) {
            long platformHandle = mainWindow.getWindowHandle();
            GLFW.glfwGetWindowPos(platformHandle, tmpBuffer, tmpBuffer2);
            int windowX = tmpBuffer.get(0);
            int windowY = tmpBuffer2.get(0);
            mouseX = mouseX + windowX;
            mouseY = mouseY + windowY;
        }
        super.updateFrame(deltaTime, width, height, backBufferWidth, backBufferHeight, mouseX, mouseY, mouseDown0, mouseDown1, mouseDown2);
    }

    @Override
    public void render(ImDrawData drawData) {
        super.render(drawData);
        if(ImGui.GetIO().ContainsConfigFlags(ImGuiConfigFlags.ViewportsEnable)) {
            ImGui.UpdatePlatformWindows();
            ImGui.RenderPlatformWindowsDefault();
            mainWindow.makeCurrent();
        }
    }

    private void updateMonitors() {
        ImGuiPlatformNative.PlatformResize(0);
        for(int i = 0; i < monitors.size; i++) {
            long platformHandle = monitors.get(i);
            GLFW.glfwGetMonitorPos(platformHandle, tmpBuffer, tmpBuffer2);
            GLFWVidMode vid_mode = GLFW.glfwGetVideoMode(platformHandle);
            float positionX = tmpBuffer.get(0);
            float positionY = tmpBuffer2.get(0);
            float width = vid_mode.width();
            float height = vid_mode.height();

            if(width == 0 || height == 0) {
                GLFW.glfwGetWindowSize(platformHandle, tmpBuffer, tmpBuffer2);
                width = tmpBuffer.get(0);
                height = tmpBuffer2.get(0);
            }
            ImGuiPlatformNative.AddMonitors(positionX, positionY, width, height, positionX, positionY, width, height, 1);
        }
    }

    @Override
    public void CreateWindow(ImGuiViewport viewport) {
        nextUserData++;
        viewport.platformUserData = nextUserData;

        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_FOCUSED, GLFW.GLFW_FALSE);
//        if (GLFW.glfwHasFocusOnShow) {
//            GLFW.glfwWindowHint(GLFW.GLFW_FOCUS_ON_SHOW, GLFW.GLFW_FALSE);
//        }

        boolean noDecoration = (viewport.flags & ImGuiViewportFlags.NoDecoration.getValue()) == ImGuiViewportFlags.NoDecoration.getValue();
        boolean isTopMost = (viewport.flags & ImGuiViewportFlags.TopMost.getValue()) == ImGuiViewportFlags.TopMost.getValue();
        GLFW.glfwWindowHint(GLFW.GLFW_DECORATED, noDecoration ? GLFW.GLFW_FALSE : GLFW.GLFW_TRUE);
//        if (GLFW.glfwHawWindowTopmost) {
            GLFW.glfwWindowHint(GLFW.GLFW_FLOATING, isTopMost ? GLFW.GLFW_TRUE : GLFW.GLFW_FALSE);
//        }

//        Lwjgl3Window lwjgl3Window = app.newWindow(new ImGuiApplication(), config);
        long mainWindowHandle = mainWindow.getWindowHandle();
        long newPlatformHandle = GLFW.glfwCreateWindow((int) viewport.sizeX, (int) viewport.sizeY, "No Title Yet", 0, mainWindowHandle);
        viewport.platformHandle = newPlatformHandle;
        GLFW.glfwSetWindowPos(newPlatformHandle, (int) viewport.posX, (int) viewport.posY);

        GLFW.glfwMakeContextCurrent(newPlatformHandle);
        GLFW.glfwSwapInterval(0);
        monitors.add(newPlatformHandle);
    }

    @Override
    public void DestroyWindow(long platformHandle, int platformUserData) {
        if(mainWindow.getWindowHandle() == platformHandle)
            return;

        monitors.removeValue(platformHandle);
        GLFW.glfwDestroyWindow(platformHandle);
    }

    @Override
    public void ShowWindow(long platformHandle, int platformUserData) {
        GLFW.glfwShowWindow(platformHandle);
    }

    @Override
    public void SetWindowPos(long platformHandle, int platformUserData, float x, float y) {
        GLFW.glfwSetWindowPos(platformHandle, (int)x, (int)y);
    }

    @Override
    public ImVec2 GetWindowPos(long platformHandle, int platformUserData) {
        ImVec2 tmp = ImVec2.TMP;
        tmp.x = 0;
        tmp.y = 0;
        GLFW.glfwGetWindowPos(platformHandle, tmpBuffer, tmpBuffer2);
        tmp.x = tmpBuffer.get(0);
        tmp.y = tmpBuffer2.get(0);
        return tmp;
    }

    @Override
    public void SetWindowSize(long platformHandle, int platformUserData, float width, float height) {
        GLFW.glfwSetWindowSize(platformHandle, (int)width, (int)height);
    }

    @Override
    public ImVec2 GetWindowSize(long platformHandle, int platformUserData) {
        ImVec2 tmp = ImVec2.TMP;
        tmp.x = 0;
        tmp.y = 0;
        GLFW.glfwGetWindowSize(platformHandle, tmpBuffer, tmpBuffer2);
        tmp.x = tmpBuffer.get(0);
        tmp.y = tmpBuffer2.get(0);
        return tmp;
    }

    @Override
    public void SetWindowFocus(long platformHandle, int platformUserData) {
        GLFW.glfwFocusWindow(platformHandle);
    }

    @Override
    public boolean GetWindowFocus(long platformHandle, int platformUserData) {
        final boolean focused = GLFW.glfwGetWindowAttrib(platformHandle, GLFW.GLFW_FOCUSED) != 0;
        return focused;
    }

    @Override
    public boolean GetWindowMinimized(long platformHandle, int platformUserData) {
        return GLFW.glfwGetWindowAttrib(platformHandle, GLFW.GLFW_ICONIFIED) != 0;
    }

    @Override
    public void SetWindowTitle(long platformHandle, int platformUserData, String title) {
        GLFW.glfwSetWindowTitle(platformHandle, title);
    }

    @Override
    public void PlatformRenderWindow(long platformHandle, int platformUserData) {
        GLFW.glfwMakeContextCurrent(platformHandle);
    }

    @Override
    public void RendererRenderWindow(ImGuiViewport viewport) {
        int flag = viewport.flags & ImGuiViewportFlags.NoRendererClear.getValue();
        if(!(flag == ImGuiViewportFlags.NoRendererClear.getValue())) {
            Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }
        renderDrawData(viewport.drawData);
    }

    @Override
    public void SwapBuffers(long platformHandle, int platformUserData) {
        GLFW.glfwMakeContextCurrent(platformHandle);
        GLFW.glfwSwapBuffers(platformHandle);
    }
}