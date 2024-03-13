package imgui.example.textedit;

import imgui.ImGui;
import imgui.example.renderer.ImGuiRenderer;
import imgui.extension.textedit.Coordinates;
import imgui.extension.textedit.LanguageDefinition;
import imgui.extension.textedit.TextEditor;
import imgui.idl.helper.IDLString;

public class TextEditExample extends ImGuiRenderer {

    private TextEditor editor;

    @Override
    public void show() {
        super.show();

        editor = new TextEditor();

        LanguageDefinition lua = LanguageDefinition.lua();
        editor.setLanguageDefinition(lua);

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
        editor.setText(text);
    }

    @Override
    public void renderImGui() {
        Coordinates coordinates = editor.getCursorPosition();

        ImGui.begin("Editor");

        String text = "\t" + (coordinates.mLine() + 1) + "/" + (coordinates.mColumn() + 1) + " " + editor.getTotalLines() + " lines | " + (editor.isOverwrite() ? "Ovr" : "Ins") + " | " + (editor.canUndo() ? "*" : " ") + " | " + editor.getLanguageDefinition().mName().c_str();
        ImGui.text(text);

        editor.render("Title");
        ImGui.end();
    }
}