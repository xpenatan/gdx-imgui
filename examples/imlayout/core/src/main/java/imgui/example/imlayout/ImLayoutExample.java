package imgui.example.imlayout;

import imgui.example.renderer.ImGuiRenderer;
import imgui.ImGui;
import imgui.ImVec2;

public class ImLayoutExample extends ImGuiRenderer {
    private boolean init = false;

    private ImLayoutView view;

    @Override
    public void show() {
        super.show();

        view = new ImLayoutView();
        view.init();
    }

    @Override
    public void renderImGui() {
        if(init == false) {
            init = true;
            ImGui.setNextWindowSize(new ImVec2(400, 400));
        }

        ImGui.begin("ImLayout Example");
        view.renderTabImGuiExtViews();
        ImGui.end();

        ImGui.showDemoWindow();
    }

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
        view.dispose();
        super.hide();
    }
}