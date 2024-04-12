package imgui.example.basic.renderer;

import imgui.ImGui;
import imgui.ImGuiDockNodeFlags;
import imgui.ImGuiViewport;
import imgui.ImGuiWindowClass;
import imgui.ImVec2;
import static imgui.ImGuiStyleVar.ImGuiStyleVar_WindowPadding;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_NoBringToFrontOnFocus;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_NoCollapse;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_NoDocking;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_NoMove;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_NoNavFocus;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_NoResize;

public class SubWindowRenderer implements UIRenderer {

    private ImGuiWindowClass rootWindowClass;
    private ImGuiWindowClass windowClass1;
    private ImGuiWindowClass windowClass2;

    public SubWindowRenderer() {
    }

    @Override
    public void render() {
        if(rootWindowClass == null) {
            rootWindowClass = new ImGuiWindowClass();
            windowClass1 = new ImGuiWindowClass();
            windowClass2 = new ImGuiWindowClass();
        }

        ImGuiWindowClass TopLevelEditorWindowClass = rootWindowClass;
        TopLevelEditorWindowClass.ClassId(1111);
        TopLevelEditorWindowClass.DockingAllowUnclassed(false);

        ImGuiWindowClass ToolWindowsClass01 = windowClass1;
        ToolWindowsClass01.DockingAllowUnclassed(false);
        ToolWindowsClass01.DockingAlwaysTabBar(false);
        ToolWindowsClass01.ClassId(22221);

        ImGuiWindowClass ToolWindowsClass02 = windowClass2;
        ToolWindowsClass02.DockingAllowUnclassed(false);
        ToolWindowsClass02.DockingAlwaysTabBar(false);
        ToolWindowsClass02.ClassId(3333);

        ImGuiViewport viewport = ImGui.getMainViewport();
        ImGui.setNextWindowPos(viewport.Pos());
        ImGui.setNextWindowSize(viewport.Size());

        int flags = 0;
        flags |= ImGuiWindowFlags_NoDocking | ImGuiWindowFlags_NoCollapse | ImGuiWindowFlags_NoResize | ImGuiWindowFlags_NoMove;
        flags |= ImGuiWindowFlags_NoBringToFrontOnFocus | ImGuiWindowFlags_NoNavFocus;

        ImGui.pushStyleVar(ImGuiStyleVar_WindowPadding, ImVec2.TMP_1.set(0.0f, 0.0f));
        ImGui.begin("No document###DocumentRoot", null, flags);
        ImGui.popStyleVar();
        int root_dockspace_id = 99999;
        ImGui.dockSpace(root_dockspace_id, ImVec2.TMP_1.set(0, 0), 0, TopLevelEditorWindowClass);
        ImGui.end();

        ImGui.begin("Dock 01");
        int dockspace_id01 = 11211;
        ImVec2 dockspace_size1 = ImGui.getContentRegionAvail();
        ImGui.dockSpace(dockspace_id01, dockspace_size1, ImGuiDockNodeFlags.ImGuiDockNodeFlags_None, ToolWindowsClass01);
        ImGui.end();

        ImGui.begin("Dock 02");
        int dockspace_id02 = 22222;
        ImVec2 dockspace_size2 = ImGui.getContentRegionAvail();
        ImGui.dockSpace(dockspace_id02, dockspace_size2, 0, ToolWindowsClass02);
        ImGui.end();

        ImGui.setNextWindowClass(ToolWindowsClass01);
        ImGui.begin("Tool 01");
        ImGui.end();

        ImGui.setNextWindowClass(ToolWindowsClass01);
        ImGui.begin("Game 01");
        ImGui.end();

        ImGui.setNextWindowClass(ToolWindowsClass02);
        ImGui.begin("Tool 02");
        ImGui.end();

        ImGui.setNextWindowClass(ToolWindowsClass02);
        ImGui.begin("Game 02");
        ImGui.end();
    }

    @Override
    public String getName() {
        return "SubWindow";
    }
}