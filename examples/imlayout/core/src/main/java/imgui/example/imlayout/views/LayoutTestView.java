package imgui.example.imlayout.views;

import com.badlogic.gdx.Gdx;
import imgui.ImGui;
import imgui.ImVec2;
import imgui.extension.imlayout.ImGuiLayout;
import imgui.extension.imlayout.ImLayout;

public class LayoutTestView {

    public void render() {
        float mouseX = Gdx.input.getX();
        float mouseY = Gdx.input.getY();

        ImLayout.beginLayout("Stuff", ImLayout.WRAP_PARENT, ImLayout.WRAP_PARENT);
        ImLayout.showLayoutDebug();
        ImGuiLayout curLayout = ImLayout.getCurrentLayout();
        ImVec2 position = curLayout.position();
        ImVec2 size = curLayout.size();
        float posX = position.x();
        float posY = position.y();
        float sizeX = size.x();
        float sizeY = size.y();
        float posSizeX = posX + sizeX;
        float posSizeY = posY + sizeY;

        ImGui.text("MouseX: " + mouseX);
        ImGui.sameLine();
        ImGui.text("MouseY: " + mouseY);
        ImGui.text("posX: " + posX);
        ImGui.text("posY: " + posY);
        ImGui.text("posSizeX: " + posSizeX);
        ImGui.text("posSizeY: " + posSizeY);

        ImLayout.endLayout();
    }
}
