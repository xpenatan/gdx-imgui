package imgui.example.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import imgui.ImFont;
import imgui.ImFontAtlas;
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
        ImGui.CreateContext();
        ImGuiIO io = ImGui.GetIO();
        io.ConfigFlags(ImGuiConfigFlags.ImGuiConfigFlags_DockingEnable);

        input = new ImGuiGdxInputMultiplexer();
        impl = new ImGuiGdxImpl();

        Gdx.input.setInputProcessor(input);

        ImFontAtlas fonts = ImGui.GetIO().Fonts();
        FileHandle fontFile01 = Gdx.files.internal("fonts/Cousine-Regular.ttf");
        FileHandle fontFile02 = Gdx.files.internal("fonts/DroidSans.ttf");

        fonts.AddFontFromMemoryTTF(fontFile01.readBytes(), 16).setName(fontFile01.name());
        fonts.AddFontFromMemoryTTF(fontFile02.readBytes(), 20).setName(fontFile02.name());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        impl.newFrame();

        renderImGui();

        ImGui.Render();
        ImDrawData drawData = ImGui.GetDrawData();
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
        impl.dispose();
        ImGui.disposeStatic();
        ImGui.DestroyContext();
    }
}