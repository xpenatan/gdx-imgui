package imgui.example.textedit;

import imgui.ImGui;
import imgui.example.renderer.ImGuiRenderer;
import imgui.extension.textedit.Coordinates;
import imgui.extension.textedit.TextEditor;

public class TextEditExample extends ImGuiRenderer {

    private TextEditor editor;

    @Override
    public void show() {
        super.show();

        editor = new TextEditor();
    }

    @Override
    public void renderImGui() {
        Coordinates coordinates = editor.GetCursorPosition();

        ImGui.Begin("Editor");

        String text = "\t" + (coordinates.get_mLine() + 1) + "/" + (coordinates.get_mColumn() + 1) + " " + editor.GetTotalLines() + " lines | " + (editor.IsOverwrite() ? "Ovr" : "Ins") + " | " + (editor.CanUndo() ? "*" : " ");
//                editor.GetLanguageDefinition().mName.c_str(), fileToEdit);
        ImGui.Text(text);

        editor.Render("Title");
        ImGui.End();
    }
}