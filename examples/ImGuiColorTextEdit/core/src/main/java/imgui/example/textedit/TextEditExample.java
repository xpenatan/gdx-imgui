package imgui.example.textedit;

import imgui.ImGui;
import imgui.example.renderer.ImGuiRenderer;
import imgui.extension.textedit.LanguageDefinitionId;
import imgui.extension.textedit.TextEditor;
import imgui.idl.helper.IDLString;

public class TextEditExample extends ImGuiRenderer {

    private TextEditor editor;

    @Override
    public void show() {
        super.show();

        editor = new TextEditor();

        int lua = LanguageDefinitionId.Lua;
        editor.SetLanguageDefinition(lua);

        IDLString text = new IDLString();

        String code = "\n" +
                "function onCreate()\n" +
                "\n" +
                "end\n" +
                "\n\n" +
                "function onRender(delta)\n" +
                "\n" +
                "end\n";
        text.append(code);
        editor.SetText(text);
    }

    @Override
    public void renderImGui() {
//        Coordinates coordinates = editor.GetCursorPosition();

        ImGui.Begin("Editor");

//        String text = "\t" + (coordinates.mLine() + 1) + "/" + (coordinates.mColumn() + 1) + " " + editor.GetTotalLines() + " lines | " + (editor.IsOverwrite() ? "Ovr" : "Ins") + " | " + (editor.CanUndo() ? "*" : " ") + " | " + editor.GetLanguageDefinition().mName().c_str();
//        ImGui.Text(text);

        editor.Render("Title");
        ImGui.End();
    }
}