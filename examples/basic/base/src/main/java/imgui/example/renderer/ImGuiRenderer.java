package imgui.example.renderer;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import imgui.gdx.ImGuiGdxImpl;
import imgui.gdx.ImGuiGdxInputMultiplexer;
import imgui.ImDrawData;
import imgui.ImGui;
import imgui.ImGuiConfigFlags;
import imgui.ImGuiIO;

public abstract class ImGuiRenderer extends ScreenAdapter {

    private ImGuiGdxImpl impl;

    protected ImGuiGdxInputMultiplexer input;

    @Override
    public void show() {
        if(Gdx.app.getType() == Application.ApplicationType.WebGL) {
            // Not possible to have ini filename with webgl
            ImGui.createContext(false);
        }
        else {
            ImGui.createContext(true);
        }

        ImGuiIO io = ImGui.getIO();
        io.configFlags(ImGuiConfigFlags.ImGuiConfigFlags_DockingEnable);

        input = new ImGuiGdxInputMultiplexer();
        impl = new ImGuiGdxImpl();
        Gdx.input.setInputProcessor(input);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        impl.update();

        renderImGui();

        ImGui.render();
        ImDrawData drawData = ImGui.getDrawData();
        impl.render(drawData);
    }

    public abstract void renderImGui();

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        ImGui.disposeStatic();
        ImGui.destroyContext();
    }
}