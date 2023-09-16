package com.github.xpenatan.imgui.example.basic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.github.xpenatan.imgui.example.basic.renderer.ColorRenderer;
import com.github.xpenatan.imgui.example.basic.renderer.EditTextRenderer;
import com.github.xpenatan.imgui.example.basic.renderer.SelectListRenderer;
import imgui.ImGui;
import imgui.ImGuiBoolean;
import imgui.ImVec2;

public class BasicExample extends ImGuiRenderer {

    private OrthographicCamera uiCam;
    private SpriteBatch batch;

    private boolean init = false;

    private ImGuiBoolean checkbox;

    private EditTextRenderer editTextRenderer;
    private SelectListRenderer selectListRenderer;
    private ColorRenderer colorRenderer;

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void show() {
        super.show();

        checkbox = new ImGuiBoolean();
        editTextRenderer = new EditTextRenderer();
        selectListRenderer = new SelectListRenderer();
        colorRenderer = new ColorRenderer();

        uiCam = new OrthographicCamera();
        uiCam.setToOrtho(true);
        batch = new SpriteBatch();
    }

    @Override
    public void renderImGui() {
        uiCam.update();
        batch.setProjectionMatrix(uiCam.combined);

        if(init == false) {
            init = true;
            ImGui.SetNextWindowSize(new ImVec2(400, 400), 1 << 1);
        }

        ImGui.Begin("Hello World");

        ImGui.Text("HelloText");

        ImGui.Checkbox("Check", checkbox);

        editTextRenderer.render();
        selectListRenderer.render();
        colorRenderer.render();

        ImGui.End();

        ImGui.ShowDemoWindow();

    }
}
