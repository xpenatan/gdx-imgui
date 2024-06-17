package imgui.example.textedit;

import imgui.ImGui;
import imgui.example.renderer.ImGuiRenderer;
import imgui.extension.textedit.LanguageDefinitionId;
import imgui.extension.textedit.TextEditor;
import imgui.idl.helper.IDLInt;
import imgui.idl.helper.IDLString;

public class TextEditExample extends ImGuiRenderer {

    private TextEditor editor;

    private IDLInt outLine;
    private IDLInt outColumn;

    @Override
    public void show() {
        super.show();

        outLine = new IDLInt();
        outColumn = new IDLInt();

        editor = new TextEditor();

        int lua = LanguageDefinitionId.Lua;
        editor.SetLanguageDefinition(lua);


        String code = "\n" +
                "function onCreate()\n" +
                "\n" +
                "end\n" +
                "\n\n" +
                "function onRender(delta)\n" +
                "\n" +
                "end\n";
        editor.SetText(code);
    }

    @Override
    public void renderImGui() {
        editor.GetCursorPosition(outLine, outColumn);

        ImGui.Begin("Editor");

        String text = "\t" + (outLine.getValue() + 1) + "/" + (outColumn.getValue() + 1) + " " + editor.GetLineCount() + " lines | " + (editor.IsOverwriteEnabled() ? "Ovr" : "Ins") + " | " + (editor.CanUndo() ? "*" : " ") + " | " + editor.GetLanguageDefinitionName().c_str();
        ImGui.Text(text);

        editor.Render("Title");
        ImGui.End();
    }
}