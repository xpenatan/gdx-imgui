package imgui.example.basic.renderer;

import imgui.ImGui;
import imgui.ImGuiDataType;
import imgui.ImGuiInternal;
import imgui.ImGuiMouseButton;
import imgui.ImGuiSliderFlags;
import imgui.ImGuiString;
import imgui.ImGuiWindow;
import imgui.idl.helper.IDLFloatArray;

public class EditTextRenderer implements UIRenderer {

    private final IDLFloatArray imguiFloat1 = new IDLFloatArray(1);
    private final IDLFloatArray imguiFloat2 = new IDLFloatArray(2);
    private final IDLFloatArray imguiFloat3 = new IDLFloatArray(3);
    private final IDLFloatArray imguiFloat4 = new IDLFloatArray(4);

    private final ImGuiString imguiString1 = new ImGuiString();

    public EditTextRenderer() {
    }

    boolean flag = false;

    public void render() {

        String format = "%.3f";


        int id = 93123;
        ImGuiWindow window = ImGuiInternal.getCurrentWindow();
        ImGui.text("Click Drag");
        if(ImGui.isItemClicked(ImGuiMouseButton.ImGuiMouseButton_Left)) {
            flag = true;
            System.out.println("Item Clicked");
        }
        if(flag && ImGui.isMouseReleased(ImGuiMouseButton.ImGuiMouseButton_Left)) {
            System.out.println("Mouse Released");
            flag = false;
        }
        if(flag) {
            ImGuiInternal.setActiveID(id, window);
        }
        int flags = ImGuiSliderFlags.ImGuiSliderFlags_None;
        if(ImGuiInternal.dragBehavior(id, ImGuiDataType.ImGuiDataType_Float, imguiFloat1.getPointer(), 0.1f, 0, 0, format, flags)) {
            System.out.println("Dragging");
        }

        ImGui.dragFloat("TestFloat", imguiFloat1);
        ImGui.dragFloat2("TestFloat2", imguiFloat2);
        ImGui.dragFloat3("TestFloat3", imguiFloat3);
        ImGui.dragFloat4("TestFloat4", imguiFloat4, 0.01f, -2, 2);

        if(ImGui.inputText("TestString2", imguiString1, imguiString1.getSize())) {
            String value = imguiString1.getValue();
            System.out.println("value: " + value);
        }
    }

    @Override
    public String getName() {
        return "EditText";
    }
}
