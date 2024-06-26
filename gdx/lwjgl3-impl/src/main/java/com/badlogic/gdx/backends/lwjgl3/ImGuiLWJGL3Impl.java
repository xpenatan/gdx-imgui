package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.BufferUtils;
import com.github.xpenatan.imgui.core.ImDrawData;
import com.github.xpenatan.imgui.core.ImGui;
import com.github.xpenatan.imgui.core.ImGuiViewport;
import com.github.xpenatan.imgui.core.ImVec2;
import com.github.xpenatan.imgui.core.enums.ImGuiConfigFlags;
import com.github.xpenatan.imgui.core.enums.ImGuiViewportFlags;
import com.github.xpenatan.imgui.core.jnicode.ImGuiPlatformNative;
import com.github.xpenatan.imgui.core.util.ImGuiPlatformListener;
import com.github.xpenatan.imgui.gdx.ImGuiGdxImpl;
import java.nio.IntBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWMonitorCallback;
import org.lwjgl.glfw.GLFWVidMode;

/**
 * @author xpenatan
 */
public class ImGuiLWJGL3Impl extends ImGuiGdxImpl implements ImGuiPlatformListener {
    private Lwjgl3Application app;

    private boolean updateMonitors = false;
    private Array<Lwjgl3Window> monitors;
    private Lwjgl3Window mainWindow;

    private int nextUserData = 1;

    private final IntBuffer tmpBuffer;
    private final IntBuffer tmpBuffer2;

    public ImGuiLWJGL3Impl() {
        app = (Lwjgl3Application)Gdx.app;
        monitors = app.windows;
        mainWindow = monitors.get(0);
        this.tmpBuffer = BufferUtils.newIntBuffer(1);
        this.tmpBuffer2 = BufferUtils.newIntBuffer(1);
        long windowHandle = mainWindow.getWindowHandle();
        ImGuiPlatformNative.InitPlatformInterface(this, windowHandle, nextUserData);
        updateMonitors();
        GLFW.glfwSetMonitorCallback(new GLFWMonitorCallback() {
            @Override
            public void invoke(long monitor, int event) {
                updateMonitors = true;
            }
        });

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
    protected void updateFrame(float deltaTime, int width, int height, int backBufferWidth, int backBufferHeight) {
        // TODO improve viewport impl
//        if(ImGui.GetIO().ContainsConfigFlags(ImGuiConfigFlags.ViewportsEnable)) {
//            for(int i = 0; i < monitors.size; i++) {
//                Lwjgl3Window lwjgl3Window = monitors.get(i);
//                long platformHandle = lwjgl3Window.getWindowHandle();
//                boolean focused = GLFW.glfwGetWindowAttrib(platformHandle, GLFW.GLFW_FOCUSED) != 0;
//                if(focused) {
//                    Lwjgl3Input input = lwjgl3Window.getInput();
//                    GLFW.glfwGetWindowPos(platformHandle, tmpBuffer, tmpBuffer2);
//                    mouseX = input.getX();
//                    mouseY = input.getY();
//                    int windowX = tmpBuffer.get(0);
//                    int windowY = tmpBuffer2.get(0);
//                    mouseX = mouseX + windowX;
//                    mouseY = mouseY + windowY;
//                    mouseDown0 = mouseDown0 || input.isButtonPressed(Input.Buttons.LEFT);
//                    mouseDown1 = mouseDown1 || input.isButtonPressed(Input.Buttons.MIDDLE);
//                    mouseDown2 = mouseDown2 || input.isButtonPressed(Input.Buttons.RIGHT);
//                }
//            }
//        }
        super.updateFrame(deltaTime, width, height, backBufferWidth, backBufferHeight);
    }

    @Override
    public void render(ImDrawData drawData) {
        super.render(drawData);
        if(ImGui.GetIO().ContainsConfigFlags(ImGuiConfigFlags.ViewportsEnable)) {
            ImGui.UpdatePlatformWindows();
            ImGui.RenderPlatformWindowsDefault();
        }
    }

    private void updateMonitors() {
        ImGuiPlatformNative.PlatformResize(0);
        for(int i = 0; i < monitors.size; i++) {
            Lwjgl3Window lwjgl3Window = monitors.get(i);
            long platformHandle = lwjgl3Window.getWindowHandle();
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

    public Lwjgl3Window findWindow(long platformHandle) {
        for(int i = 0; i < monitors.size; i++) {
            Lwjgl3Window lwjgl3Window = monitors.get(i);
            if(lwjgl3Window.getWindowHandle() == platformHandle) {
                return lwjgl3Window;
            }
        }
        return null;
    }

    @Override
    public void CreateWindow(long viewportAddr) {
        ImGuiViewport viewport = ImGuiViewport.TMP_EMPTY;
        ImGuiViewport.TMP_EMPTY.setCSPointer(viewportAddr);
        nextUserData++;
        viewport.setPlatformUserData(nextUserData);

        int viewportFlags = viewport.getFlags();
        boolean noDecoration = (viewportFlags & ImGuiViewportFlags.NoDecoration.getValue()) == ImGuiViewportFlags.NoDecoration.getValue();
        boolean isTopMost = (viewportFlags & ImGuiViewportFlags.TopMost.getValue()) == ImGuiViewportFlags.TopMost.getValue();

        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        ImVec2 pos = viewport.getPos();
        ImVec2 size = viewport.getSize();
        config.setWindowPosition((int)pos.getX(), (int)pos.getY());
        config.setWindowedMode((int)size.getX(), (int)size.getY());
        config.windowDecorated = !noDecoration;
        config.title = "Empty";

        ImGuiApplication imGuiApplication = new ImGuiApplication(this);
        Lwjgl3Window lwjgl3Window = new Lwjgl3Window(imGuiApplication, config, app);
        imGuiApplication.lwjgl3Window = lwjgl3Window;
        long mainWindowHandle = mainWindow.getWindowHandle();
        app.createWindow(lwjgl3Window, config, mainWindowHandle);
        monitors.add(lwjgl3Window);

        viewport.setPlatformHandle(lwjgl3Window.getWindowHandle());
        lwjgl3Window.makeCurrent();
        GLFW.glfwSwapInterval(0);
    }

    @Override
    public void DestroyWindow(long platformHandle, int platformUserData) {
        Lwjgl3Window window = findWindow(platformHandle);
        if(window != null) {
            window.closeWindow();
        }
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
    public long GetWindowPos(long platformHandle, int platformUserData) {
        ImVec2 tmp = ImVec2.TMP;
        GLFW.glfwGetWindowPos(platformHandle, tmpBuffer, tmpBuffer2);
        tmp.set(tmpBuffer.get(0), tmpBuffer2.get(0));
        return tmp.getCPointer();
    }

    @Override
    public void SetWindowSize(long platformHandle, int platformUserData, float width, float height) {
        GLFW.glfwSetWindowSize(platformHandle, (int)width, (int)height);
    }

    @Override
    public long GetWindowSize(long platformHandle, int platformUserData) {
        ImVec2 tmp = ImVec2.TMP;
        GLFW.glfwGetWindowSize(platformHandle, tmpBuffer, tmpBuffer2);
        tmp.set(tmpBuffer.get(0), tmpBuffer2.get(0));
        return tmp.getCPointer();
    }

    @Override
    public void SetWindowFocus(long platformHandle, int platformUserData) {
        GLFW.glfwFocusWindow(platformHandle);
    }

    @Override
    public boolean GetWindowFocus(long platformHandle, int platformUserData) {
        return GLFW.glfwGetWindowAttrib(platformHandle, GLFW.GLFW_FOCUSED) != 0;
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
    }

    @Override
    public void RendererRenderWindow(long viewportAddr) {
        ImGuiViewport viewport = ImGuiViewport.TMP_EMPTY;
        viewport.setCPointer(viewportAddr);
    }

    @Override
    public void SwapBuffers(long platformHandle, int platformUserData) {
    }

    public Input getWindowInput(Lwjgl3Window window) {
        if(window == null)
            return null;
        return window.getInput();
    }
}