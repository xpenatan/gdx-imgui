package imgui.example.imlayout.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import imgui.ImGui;
import imgui.ImGuiDir;
import imgui.ImVec2;
import imgui.extension.imlayout.ImLayout;
import imgui.idl.helper.IDLBoolArray;
import imgui.idl.helper.IDLFloatArray;
import imgui.idl.helper.IDLIntArray;

public class CollapseView {

    private Texture buttonTexture;

    private IDLBoolArray isDebug = new IDLBoolArray(1);

    private IDLBoolArray dummyCheckbox = new IDLBoolArray(1);

    private IDLBoolArray isCollapseOpen = new IDLBoolArray(1);
    private IDLBoolArray isCollapseOpen2 = new IDLBoolArray(1);

    private IDLFloatArray alignX = new IDLFloatArray(1);
    private IDLFloatArray offsetX = new IDLFloatArray(1);
    private IDLFloatArray alignY = new IDLFloatArray(1);
    private IDLFloatArray offsetY = new IDLFloatArray(1);

    private IDLIntArray guiInt = new IDLIntArray(1);

    public void init() {
        alignX.setValue(0, 0.5f);
        offsetX.setValue(0, 0.0f);
        alignY.setValue(0, 0.5f);
        offsetY.setValue(0, 0.0f);
        buttonTexture = new Texture(Gdx.files.internal("data/badlogicsmall.jpg"));
    }

    public void dispose() {
        buttonTexture.dispose();
    }

    public void render() {
        ImLayout.drawBoundingBox(100f, 100f,40f, 40f, 255, 0, 0);

        if(ImLayout.beginCollapseLayout("##idd", "Hello", ImLayout.MATCH_PARENT(), ImLayout.WRAP_PARENT())) {
            ImGui.button("HI");

        }
        ImLayout.endCollapseLayout();

        ImLayout.beginCollapseLayoutEx("##ID1", isCollapseOpen, "Stuff", ImLayout.MATCH_PARENT, ImLayout.WRAP_PARENT);

        if(isDebug.getValue(0)) {
            ImLayout.showLayoutDebug();
        }

        ImGui.checkbox("DummyCheckBox", dummyCheckbox);

        ImGui.sameLine();

        ImLayout.beginAlign("##ID2", ImLayout.MATCH_PARENT, ImLayout.MATCH_PARENT, 1.0f, 0.5f, -5, 0);
        ImGui.button("Ok");
        ImGui.sameLine();
        ImGui.text("Custom Align");
        ImLayout.endAlign();

        ImLayout.endCollapseFrameLayout();

        if(isCollapseOpen.getValue(0)) {

            ImGui.checkbox("LayoutDebug", isDebug);

            ImLayout.beginCollapseLayout("##ID3", isCollapseOpen2, "Alignment options", ImLayout.MATCH_PARENT, ImLayout.WRAP_PARENT);
            if(isCollapseOpen2.getValue(0)) {
                ImGui.sliderFloat("AlignX", alignX, 0.0f, 1.0f, "%.2f");
                ImGui.sliderFloat("OffsetX", offsetX, -10.0f, 10.0f, "%.2f");
                ImGui.sliderFloat("AlignY", alignY, 0.0f, 1.0f, "%.2f");
                ImGui.sliderFloat("OffsetY", offsetY, -10.0f, 10.0f, "%.2f");
            }
            ImLayout.endCollapseLayout();

            ImGui.arrowButton("##Left", ImGuiDir.ImGuiDir_Left);
            ImGui.sameLine();
            ImGui.arrowButton("##Right", ImGuiDir.ImGuiDir_Right);
            ImGui.sameLine();
            ImGui.arrowButton("##Up", ImGuiDir.ImGuiDir_Up);
            ImGui.sameLine();
            ImGui.arrowButton("##Down", ImGuiDir.ImGuiDir_Down);

            ImGui.radioButton("radio a", guiInt, 0);
            ImGui.sameLine();
            ImGui.radioButton("radio b", guiInt, 1);
            ImGui.sameLine();
            ImGui.radioButton("radio c", guiInt, 2);
            ImGui.sameLine();
            ImGui.radioButton("radio true", true);

            ImGui.bullet();
            ImGui.sameLine();
            ImGui.text("Bullet text");

            ImLayout.beginAlign("##ID4", ImLayout.MATCH_PARENT, 200, alignX.getValue(0), alignY.getValue(0), offsetX.getValue(0), offsetY.getValue(0));

            if(isDebug.getValue(0)) {
                ImLayout.showLayoutDebug();
            }

            ImGui.image(buttonTexture.getTextureObjectHandle(), ImVec2.TMP_1.set(32, 32));
            ImGui.imageButton("##textId", buttonTexture.getTextureObjectHandle(), ImVec2.TMP_1.set(42, 42));

            ImLayout.endAlign();
        }
        ImLayout.endCollapseLayout();
    }
}
