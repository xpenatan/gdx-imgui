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

        ImLayout.BeginLayout("Stuff", ImLayout.WRAP_PARENT, ImLayout.WRAP_PARENT);
        ImLayout.ShowLayoutDebug();
        ImGuiLayout curLayout = ImLayout.GetCurrentLayout();
        ImVec2 position = curLayout.position();
        ImVec2 size = curLayout.size();
        float posX = position.x();
        float posY = position.y();
        float sizeX = size.x();
        float sizeY = size.y();
        float posSizeX = posX + sizeX;
        float posSizeY = posY + sizeY;

        ImGui.Text("MouseX: " + mouseX);
        ImGui.SameLine();
        ImGui.Text("MouseY: " + mouseY);
        ImGui.Text("posX: " + posX);
        ImGui.Text("posY: " + posY);
        ImGui.Text("posSizeX: " + posSizeX);
        ImGui.Text("posSizeY: " + posSizeY);

        ImLayout.EndLayout();

        renderTree();
    }

    private void renderTree() {
        float height = ImLayout.GetTreeHeight(20);
        ImLayout.BeginTree("RootId");
        ImLayout.BeginTreeLayout(height, false);
        ImGui.Text("Root");
        if(ImLayout.EndTreeLayout()) {
            {
                ImLayout.BeginTree("Assets");
                ImLayout.BeginTreeLayout(height, false);
                ImGui.Text("Assets");
                if(ImLayout.EndTreeLayout()) {

                    {
                        {
                            ImLayout.BeginTree("Item");
                            ImLayout.BeginTreeLayout(height, true);
                            ImGui.Text("Item");
                            if(ImLayout.EndTreeLayout()) {
                            }
                            ImLayout.EndTree();
                        }
                    }
                }
                ImLayout.EndTree();
            }
        }
        ImLayout.EndTree();
    }
}
