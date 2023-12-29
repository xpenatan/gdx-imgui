package imgui.example.basic.renderer;

import imgui.ImGui;
import imgui.ImGuiString;
import imgui.idl.helper.IDLFloatArray;

public class EditTextRenderer implements UIRenderer {

    private final IDLFloatArray imguiFloat1 = new IDLFloatArray(1);
    private final IDLFloatArray imguiFloat2 = new IDLFloatArray(2);
    private final IDLFloatArray imguiFloat3 = new IDLFloatArray(3);
    private final IDLFloatArray imguiFloat4 = new IDLFloatArray(4);

    private final ImGuiString imguiString1 = new ImGuiString();

    public EditTextRenderer() {
    }

    public void render() {
        ImGui.DragFloat("TestFloat", imguiFloat1);
        ImGui.DragFloat2("TestFloat2", imguiFloat2);
        ImGui.DragFloat3("TestFloat3", imguiFloat3);
        ImGui.DragFloat4("TestFloat4", imguiFloat4, 0.01f, -2, 2);

        if(ImGui.InputText("TestString2", imguiString1, imguiString1.getSize())) {
            String value = imguiString1.getValue();
            System.out.println("value: " + value);
        }
    }

    @Override
    public String getName() {
        return "EditText";
    }
}
