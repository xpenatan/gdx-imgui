package imgui.example.nodeeditor.demo;

import imgui.ImGui;
import imgui.ImVec2;
import imgui.extension.nodeeditor.EditorContext;
import imgui.extension.nodeeditor.NodeEditor;
import imgui.extension.nodeeditor.PinKind;

public class SimpleExample {

    public static void render(EditorContext editorContext) {
        NodeEditor.setCurrentEditor(editorContext);

        NodeEditor.begin("My Editor", ImVec2.TMP_1.set(0, 0));

        int uniqueId = 1;
        {
            NodeEditor.beginNode(uniqueId++);
            ImGui.text("Node A");
            {
                NodeEditor.beginPin(uniqueId++, PinKind.Input);
                ImGui.text("-> In");
                NodeEditor.endPin();
            }

            ImGui.sameLine();

            {
                NodeEditor.beginPin(uniqueId++, PinKind.Output);
                ImGui.text("-> Out");
                NodeEditor.endPin();
            }
            NodeEditor.endNode();
        }

        NodeEditor.end();
        NodeEditor.setCurrentEditor(null);
    }
}
