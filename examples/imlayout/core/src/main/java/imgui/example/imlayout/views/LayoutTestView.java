package imgui.example.imlayout.views;

import com.badlogic.gdx.Gdx;
import imgui.ImGui;
import imgui.ImGuiTableFlags;
import imgui.ImVec2;
import imgui.extension.imlayout.ImGuiLayout;
import imgui.extension.imlayout.ImLayout;
import imgui.extension.imlayout.ImOrientation;
import static imgui.ImGuiTableColumnFlags.ImGuiTableColumnFlags_WidthStretch;
import static imgui.ImGuiTableFlags.ImGuiTableFlags_Resizable;

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

        int flags = ImGuiTableFlags_Resizable | ImGuiTableFlags.ImGuiTableFlags_ScrollY;
        if(ImGui.BeginTable("ContentBrowser", 2, flags)) {

            ImGui.TableSetupColumn("C0", ImGuiTableColumnFlags_WidthStretch, 0.2f);
            ImGui.TableSetupColumn("C1", ImGuiTableColumnFlags_WidthStretch, 0.8f);

            ImGui.TableNextRow();
            ImGui.TableSetColumnIndex(0);

            renderTree();

            ImGui.TableSetColumnIndex(1);

            ImGui.EndTable();
        }
    }

    private void renderTree() {
        float height = 10;
        ImLayout.BeginTree("RootId");
        ImLayout.BeginTreeLayout(ImLayout.GetTreeHeight(height), false, false);
        ImLayout.SetOrientation(ImOrientation.HORIZONTAL);
        {
            ImLayout.BeginAlign("111", ImLayout.MATCH_PARENT, ImLayout.MATCH_PARENT, 0f, 0.5f);
            ImGui.Text("Root");

            ImLayout.ShowLayoutDebug();
            ImLayout.EndAlign();
            ImGui.SameLine();
        }

        {
            ImLayout.BeginAlign("222", ImLayout.MATCH_PARENT, ImLayout.MATCH_PARENT, 0.5f, 0.5f);
            ImGui.Text("- " + 2);
            ImLayout.ShowLayoutDebug();
            ImLayout.EndAlign();
        }

        ImLayout.EndTreeLayout();
        if(ImLayout.IsTreeOpen()) {
            {
                ImLayout.BeginTree("Assets");
                ImLayout.BeginTreeLayout(ImLayout.GetTreeHeight(height), false, false);
                ImGui.Text("Assets");
                ImLayout.EndTreeLayout();
                if(ImLayout.IsTreeOpen()) {
                    {
                        ImLayout.BeginTree("Item01");
                        ImLayout.BeginTreeLayout(ImLayout.GetTreeHeight(height), true, false);
                        ImGui.Text("Item01");

                        ImGui.SameLine();

                        if(ImGui.Button("HELLO")) {
                            System.out.println("HELLOO");
                        }
                        ImLayout.EndTreeLayout();
                        if(ImLayout.IsTreeOpen()) {
                        }
                        ImLayout.EndTree();
                    }
                    {
                        ImLayout.BeginTree("Item02");
                        ImLayout.BeginTreeLayout(ImLayout.GetTreeHeight(height), true, false);
                        ImGui.Text("Item02");
                        ImLayout.EndTreeLayout();
                        if(ImLayout.IsTreeOpen()) {
                        }
                        ImLayout.EndTree();
                    }
                    {
                        ImLayout.BeginTree("Item03");
                        ImLayout.BeginTreeLayout(ImLayout.GetTreeHeight(height), true, false);
                        ImGui.Text("Item03");
                        ImLayout.EndTreeLayout();
                        if(ImLayout.IsTreeOpen()) {
                        }
                        ImLayout.EndTree();
                    }
                    {
                        ImLayout.BeginTree("Item04");
                        ImLayout.BeginTreeLayout(ImLayout.GetTreeHeight(height), true, false);
                        ImGui.Text("Item04");
                        ImLayout.EndTreeLayout();
                        if(ImLayout.IsTreeOpen()) {
                        }
                        ImLayout.EndTree();
                    }
                }
                ImLayout.EndTree();
            }
        }
        ImLayout.EndTree();
    }
}
