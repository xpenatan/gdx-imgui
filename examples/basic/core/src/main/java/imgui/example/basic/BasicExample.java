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

        ImGuiStyle style = ImGui.getStyle();

        ImVec4 colors = style.colors(ImGuiCol_Header);

        System.out.println("Color before: R: " + colors.x() + " G: " + colors.y() + " B: " + colors.z() + " A: " + colors.w());
        style.colors(ImGuiCol_Header, 255, 0, 0, 255);
        System.out.println("Color adter: R: " + colors.x() + " G: " + colors.y() + " B: " + colors.z() + " A: " + colors.w());
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
            ImGui.showDemoWindow();

            if(init == false) {
                init = true;
                ImGui.setNextWindowSize(new ImVec2(400, 400), 1 << 1);
            }

            ImGui.begin("Hello World");
            renderItems();
            ImGui.end();
        }
    }
    private void renderItems() {
        if(ImGui.beginTabBar("##Renderer", ImGuiTabBarFlags.ImGuiTabBarFlags_FittingPolicyScroll | ImGuiTabBarFlags.ImGuiTabBarFlags_Reorderable)) {
            for(UIRenderer renderer : renderers) {
                if(ImGui.beginTabItem(renderer.getName())) {
                    renderer.render();
                    ImGui.endTabItem();
                }
            }
            ImGui.endTabBar();
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
        ImGuiViewport imGuiViewport = ImGui.getMainViewport();

        ImGui.setNextWindowPos(imGuiViewport.Pos());
        ImGui.setNextWindowSize(imGuiViewport.Size());

        // Create docking space
        ImGui.pushStyleVar(ImGuiStyleVar_WindowPadding, ImVec2.TMP_1.set(0.0f, 0.0f));
        ImGui.begin("DockSpace111", null, window_flags);
        ImGui.popStyleVar();

        dockspace_id = ImGui.getID("MyDockSpace");
        ImGui.dockSpace(dockspace_id, ImVec2.TMP_1.set(0f, 0f), dockspace_flags);

        ImGui.end();
        // End of docking space

        renderMenu();

        ImGui.showDemoWindow();

        ImGui.begin("Game Window");
        ImGui.end();
        ImGui.begin("Hierarchy");
        ImGui.end();
        ImGui.begin("Assets");
        ImGui.end();

        if(ImGui.begin("Inspector")) {
        }
        ImGui.end();

        if(ImGui.begin("Game Editor")) {
            renderItems();
        }
        ImGui.end();
        ImGui.begin("GUI Editor");
        ImGui.end();

        if (!first) {
            // Dock all windows when app start
            first = true;
            resetLayout(0);
        }
    }

    private void resetLayout(int layout) {
        ImGuiViewport imGuiViewport = ImGui.getMainViewport();

        ImGui.setWindowFocus(null);
        ImGuiInternal.dockBuilderRemoveNode(dockspace_id); // clear any previous layout
        ImGuiInternal.dockBuilderAddNode(dockspace_id, dockspace_flags | 1 << 10);
        ImGuiInternal.dockBuilderSetNodeSize(dockspace_id, imGuiViewport.Size());

        int centralID = 0;

        if(layout == 0 ) {
            int rightId = ImGuiInternal.dockBuilderSplitNode(dockspace_id, ImGuiDir_Right, 0.2f, null, IDLInt.TMP_1);
            int leftId = IDLInt.TMP_1.getValue();

            int bottomId = ImGuiInternal.dockBuilderSplitNode(leftId, ImGuiDir_Down, 0.3f, null, IDLInt.TMP_1);
            int topId = IDLInt.TMP_1.getValue();
            int topLeft = ImGuiInternal.dockBuilderSplitNode(topId, ImGuiDir_Left, 0.4f, null, IDLInt.TMP_1);
            centralID = IDLInt.TMP_1.getValue();

            int rightTopId = ImGuiInternal.dockBuilderSplitNode(rightId, ImGuiDir_Up, 0.5f, null, IDLInt.TMP_1);
            int rightBottomId = IDLInt.TMP_1.getValue();

            int bottomLeftId = ImGuiInternal.dockBuilderSplitNode(bottomId, ImGuiDir_Left, 0.4f, null, IDLInt.TMP_1);
            int bottomRightId = IDLInt.TMP_1.getValue();

            // Plug in all layout ids to window title
            ImGuiInternal.dockBuilderDockWindow("Game Editor", centralID);
            ImGuiInternal.dockBuilderDockWindow("GUI Editor", centralID);
            ImGuiInternal.dockBuilderDockWindow("Game Window", topLeft);
            ImGuiInternal.dockBuilderDockWindow("Dear ImGui Demo", bottomRightId);
            ImGuiInternal.dockBuilderDockWindow("Hierarchy", rightTopId);
            ImGuiInternal.dockBuilderDockWindow("Inspector", rightBottomId);
            ImGuiInternal.dockBuilderDockWindow("Assets", bottomLeftId);
        }
        else {
            int rightId = ImGuiInternal.dockBuilderSplitNode(dockspace_id, ImGuiDir_Right, 0.2f, null, IDLInt.TMP_1);

            int leftId = IDLInt.TMP_1.getValue();

            int bottomId = ImGuiInternal.dockBuilderSplitNode(leftId, ImGuiDir_Down, 0.2f, null, IDLInt.TMP_1);
            int topId = IDLInt.TMP_1.getValue();

            int leftLeftId = ImGuiInternal.dockBuilderSplitNode(topId, ImGuiDir_Left, 0.2f, null, IDLInt.TMP_1);
            int middleId = IDLInt.TMP_1.getValue();

            int middleLeftId = ImGuiInternal.dockBuilderSplitNode(middleId, ImGuiDir_Left, 0.5f, null, IDLInt.TMP_1);
            centralID = IDLInt.TMP_1.getValue();

            int rightTopId = ImGuiInternal.dockBuilderSplitNode(rightId, ImGuiDir_Up, 0.5f, null, IDLInt.TMP_1);
            int rightBottomId = IDLInt.TMP_1.getValue();

            ImGuiInternal.dockBuilderDockWindow("Game Editor", centralID);
            ImGuiInternal.dockBuilderDockWindow("GUI Editor", centralID);
            ImGuiInternal.dockBuilderDockWindow("Game Window", middleLeftId);
            ImGuiInternal.dockBuilderDockWindow("Dear ImGui Demo", rightBottomId);
            ImGuiInternal.dockBuilderDockWindow("Hierarchy", leftLeftId);
            ImGuiInternal.dockBuilderDockWindow("Inspector", rightTopId);
            ImGuiInternal.dockBuilderDockWindow("Assets", bottomId);
        }

        ImGuiDockNode node = ImGuiInternal.dockBuilderGetNode(centralID);
        // Select Game editor tab
        int id = ImGuiInternal.imHashStr("#TAB", 0, ImGuiInternal.imHashStr("Game Editor", 0, 0));
        node.SelectedTabId(id);

        ImGuiInternal.dockBuilderFinish(dockspace_id);
    }

    private void renderMenu() {
        if(ImGui.beginMainMenuBar()) {
            if(ImGui.beginMenu("File")) {
                if(ImGui.menuItem("Save")) {
                }
                if(ImGui.menuItem("Load")) {
                }
                ImGui.endMenu();
            }

            if(ImGui.beginMenu("View")) {
                if(ImGui.beginMenu("Layout")) {
                    if(ImGui.menuItem("Layout 01")) {
                        resetLayout(0);
                    }
                    if(ImGui.menuItem("Layout 02")) {
                        resetLayout(1);
                    }

                    ImGui.endMenu();
                }

                ImGui.endMenu();
            }
            ImGui.endMainMenuBar();
        }
    }
}