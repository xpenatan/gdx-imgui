package imgui.example.basic;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import imgui.example.renderer.ImGuiRenderer;
import imgui.example.basic.renderer.ColorRenderer;
import imgui.example.basic.renderer.DragAndDropRenderer;
import imgui.example.basic.renderer.EditTextRenderer;
import imgui.example.basic.renderer.SelectListRenderer;
import imgui.example.basic.renderer.UIRenderer;
import imgui.ImGui;
import imgui.ImGuiDockNode;
import imgui.ImGuiInternal;
import imgui.ImGuiStyle;
import imgui.ImGuiTabBarFlags;
import imgui.ImGuiViewport;
import imgui.ImVec2;
import imgui.ImVec4;
import imgui.idl.helper.IDLInt;
import static imgui.ImGuiCol.ImGuiCol_Header;
import static imgui.ImGuiDir.ImGuiDir_Down;
import static imgui.ImGuiDir.ImGuiDir_Left;
import static imgui.ImGuiDir.ImGuiDir_Right;
import static imgui.ImGuiDir.ImGuiDir_Up;
import static imgui.ImGuiDockNodeFlags.ImGuiDockNodeFlags_PassthruCentralNode;
import static imgui.ImGuiStyleVar.ImGuiStyleVar_WindowPadding;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_MenuBar;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_NoBackground;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_NoBringToFrontOnFocus;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_NoCollapse;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_NoDocking;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_NoMove;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_NoNavFocus;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_NoResize;
import static imgui.ImGuiWindowFlags.ImGuiWindowFlags_NoTitleBar;

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

        ImGuiStyle style = ImGui.GetStyle();

        ImVec4 colors = style.get_Colors(ImGuiCol_Header);

        System.out.println("Color before: R: " + colors.get_x() + " G: " + colors.get_y() + " B: " + colors.get_z() + " A: " + colors.get_w());
        style.set_Colors(ImGuiCol_Header, 255, 0, 0, 255);
        System.out.println("Color adter: R: " + colors.get_x() + " G: " + colors.get_y() + " B: " + colors.get_z() + " A: " + colors.get_w());
    }

    @Override
    public void renderImGui() {
        uiCam.update();
        batch.setProjectionMatrix(uiCam.combined);

        boolean showDocking = true;

        if(showDocking) {
            renderDock();
        }
        else {
            ImGui.ShowDemoWindow();

            if(init == false) {
                init = true;
                ImGui.SetNextWindowSize(new ImVec2(400, 400), 1 << 1);
            }

            ImGui.Begin("Hello World");
            renderItems();
            ImGui.End();
        }
    }
    private void renderItems() {
        if(ImGui.BeginTabBar("##Renderer", ImGuiTabBarFlags.ImGuiTabBarFlags_FittingPolicyScroll | ImGuiTabBarFlags.ImGuiTabBarFlags_Reorderable)) {
            for(UIRenderer renderer : renderers) {
                if(ImGui.BeginTabItem(renderer.getName())) {
                    renderer.render();
                    ImGui.EndTabItem();
                }
            }
            ImGui.EndTabBar();
        }
    }


    static boolean first = false;

    int dockspace_flags = ImGuiDockNodeFlags_PassthruCentralNode;
    int dockspace_id;

    private void renderDock() {

        int window_flags = ImGuiWindowFlags_MenuBar | ImGuiWindowFlags_NoDocking;

        window_flags |= ImGuiWindowFlags_NoTitleBar | ImGuiWindowFlags_NoCollapse | ImGuiWindowFlags_NoResize | ImGuiWindowFlags_NoMove;
        window_flags |= ImGuiWindowFlags_NoBringToFrontOnFocus | ImGuiWindowFlags_NoNavFocus;

        if ((dockspace_flags & ImGuiDockNodeFlags_PassthruCentralNode) > 0)
            window_flags |= ImGuiWindowFlags_NoBackground;
        ImGuiViewport imGuiViewport = ImGui.GetMainViewport();

        ImGui.SetNextWindowPos(imGuiViewport.get_Pos());
        ImGui.SetNextWindowSize(imGuiViewport.get_Size());

        // Create docking space
        ImGui.PushStyleVar(ImGuiStyleVar_WindowPadding, ImVec2.TMP_1.set(0.0f, 0.0f));
        ImGui.Begin("DockSpace111", null, window_flags);
        ImGui.PopStyleVar();

        dockspace_id = ImGui.GetID("MyDockSpace");
        ImGui.DockSpace(dockspace_id, ImVec2.TMP_1.set(0f, 0f), dockspace_flags);

        ImGui.End();
        // End of docking space

        renderMenu();

        ImGui.ShowDemoWindow();

        ImGui.Begin("Game Window");
        ImGui.End();
        ImGui.Begin("Hierarchy");
        ImGui.End();
        ImGui.Begin("Assets");
        ImGui.End();

        if(ImGui.Begin("Inspector")) {
        }
        ImGui.End();

        if(ImGui.Begin("Game Editor")) {
            renderItems();
        }
        ImGui.End();
        ImGui.Begin("GUI Editor");
        ImGui.End();

        if (!first) {
            // Dock all windows when app start
            first = true;
            resetLayout(0);
        }
    }

    private void resetLayout(int layout) {
        ImGuiViewport imGuiViewport = ImGui.GetMainViewport();

        ImGui.SetWindowFocus(null);
        ImGuiInternal.DockBuilderRemoveNode(dockspace_id); // clear any previous layout
        ImGuiInternal.DockBuilderAddNode(dockspace_id, dockspace_flags | 1 << 10);
        ImGuiInternal.DockBuilderSetNodeSize(dockspace_id, imGuiViewport.get_Size());

        int centralID = 0;

        if(layout == 0 ) {
            int rightId = ImGuiInternal.DockBuilderSplitNode(dockspace_id, ImGuiDir_Right, 0.2f, null, IDLInt.TMP_1);
            int leftId = IDLInt.TMP_1.getValue();

            int bottomId = ImGuiInternal.DockBuilderSplitNode(leftId, ImGuiDir_Down, 0.3f, null, IDLInt.TMP_1);
            int topId = IDLInt.TMP_1.getValue();
            int topLeft = ImGuiInternal.DockBuilderSplitNode(topId, ImGuiDir_Left, 0.4f, null, IDLInt.TMP_1);
            centralID = IDLInt.TMP_1.getValue();

            int rightTopId = ImGuiInternal.DockBuilderSplitNode(rightId, ImGuiDir_Up, 0.5f, null, IDLInt.TMP_1);
            int rightBottomId = IDLInt.TMP_1.getValue();

            int bottomLeftId = ImGuiInternal.DockBuilderSplitNode(bottomId, ImGuiDir_Left, 0.4f, null, IDLInt.TMP_1);
            int bottomRightId = IDLInt.TMP_1.getValue();

            // Plug in all layout ids to window title
            ImGuiInternal.DockBuilderDockWindow("Game Editor", centralID);
            ImGuiInternal.DockBuilderDockWindow("GUI Editor", centralID);
            ImGuiInternal.DockBuilderDockWindow("Game Window", topLeft);
            ImGuiInternal.DockBuilderDockWindow("Dear ImGui Demo", bottomRightId);
            ImGuiInternal.DockBuilderDockWindow("Hierarchy", rightTopId);
            ImGuiInternal.DockBuilderDockWindow("Inspector", rightBottomId);
            ImGuiInternal.DockBuilderDockWindow("Assets", bottomLeftId);
        }
        else {
            int rightId = ImGuiInternal.DockBuilderSplitNode(dockspace_id, ImGuiDir_Right, 0.2f, null, IDLInt.TMP_1);

            int leftId = IDLInt.TMP_1.getValue();

            int bottomId = ImGuiInternal.DockBuilderSplitNode(leftId, ImGuiDir_Down, 0.2f, null, IDLInt.TMP_1);
            int topId = IDLInt.TMP_1.getValue();

            int leftLeftId = ImGuiInternal.DockBuilderSplitNode(topId, ImGuiDir_Left, 0.2f, null, IDLInt.TMP_1);
            int middleId = IDLInt.TMP_1.getValue();

            int middleLeftId = ImGuiInternal.DockBuilderSplitNode(middleId, ImGuiDir_Left, 0.5f, null, IDLInt.TMP_1);
            centralID = IDLInt.TMP_1.getValue();

            int rightTopId = ImGuiInternal.DockBuilderSplitNode(rightId, ImGuiDir_Up, 0.5f, null, IDLInt.TMP_1);
            int rightBottomId = IDLInt.TMP_1.getValue();

            ImGuiInternal.DockBuilderDockWindow("Game Editor", centralID);
            ImGuiInternal.DockBuilderDockWindow("GUI Editor", centralID);
            ImGuiInternal.DockBuilderDockWindow("Game Window", middleLeftId);
            ImGuiInternal.DockBuilderDockWindow("Dear ImGui Demo", rightBottomId);
            ImGuiInternal.DockBuilderDockWindow("Hierarchy", leftLeftId);
            ImGuiInternal.DockBuilderDockWindow("Inspector", rightTopId);
            ImGuiInternal.DockBuilderDockWindow("Assets", bottomId);
        }

        ImGuiDockNode node = ImGuiInternal.DockBuilderGetNode(centralID);
        // Select Game editor tab
        int id = ImGuiInternal.ImHashStr("#TAB", 0, ImGuiInternal.ImHashStr("Game Editor", 0, 0));
        node.set_SelectedTabId(id);

        ImGuiInternal.DockBuilderFinish(dockspace_id);
    }

    private void renderMenu() {
        if(ImGui.BeginMainMenuBar()) {
            if(ImGui.BeginMenu("File")) {
                if(ImGui.MenuItem("Save")) {
                }
                if(ImGui.MenuItem("Load")) {
                }
                ImGui.EndMenu();
            }

            if(ImGui.BeginMenu("View")) {
                if(ImGui.BeginMenu("Layout")) {
                    if(ImGui.MenuItem("Layout 01")) {
                        resetLayout(0);
                    }
                    if(ImGui.MenuItem("Layout 02")) {
                        resetLayout(1);
                    }

                    ImGui.EndMenu();
                }

                ImGui.EndMenu();
            }
            ImGui.EndMainMenuBar();
        }
    }
}