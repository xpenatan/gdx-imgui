package com.github.xpenatan.imgui.example.basic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.github.xpenatan.imgui.example.basic.renderer.ColorRenderer;
import com.github.xpenatan.imgui.example.basic.renderer.DragAndDropRenderer;
import com.github.xpenatan.imgui.example.basic.renderer.EditTextRenderer;
import com.github.xpenatan.imgui.example.basic.renderer.SelectListRenderer;
import com.github.xpenatan.imgui.example.basic.renderer.UIRenderer;
import imgui.ImGui;
import imgui.ImGuiBoolean;
import imgui.ImGuiTabBarFlags;
import imgui.ImVec2;

public class BasicExample extends ImGuiRenderer {

    private OrthographicCamera uiCam;
    private SpriteBatch batch;

    private boolean init = false;

    private Array<UIRenderer> renderers = new Array<>();

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void show() {
        super.show();

        renderers.add(new EditTextRenderer());
        renderers.add(new SelectListRenderer());
        renderers.add(new ColorRenderer());
        renderers.add(new DragAndDropRenderer());

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

        if(ImGui.BeginTabBar("##Renderer", ImGuiTabBarFlags.ImGuiTabBarFlags_FittingPolicyScroll | ImGuiTabBarFlags.ImGuiTabBarFlags_Reorderable)) {
            for(UIRenderer renderer : renderers) {
                if(ImGui.BeginTabItem(renderer.getName())) {
                    renderer.render();
                    ImGui.EndTabItem();
                }
            }
            ImGui.EndTabBar();
        }
        ImGui.End();

        ImGui.ShowDemoWindow();
    }
}