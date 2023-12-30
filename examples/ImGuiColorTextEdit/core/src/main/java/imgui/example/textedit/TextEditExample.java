package imgui.example.textedit;

import imgui.example.renderer.ImGuiRenderer;
import imgui.extension.textedit.SelectMode;
import imgui.extension.textedit.TextEditor;

public class TextEditExample extends ImGuiRenderer {

    @Override
    public void show() {
        super.show();

        TextEditor textEditor = new TextEditor();

        System.out.println("line: " + SelectMode.Line);
        System.out.println("normal: " + SelectMode.Normal);
        System.out.println("word: " + SelectMode.Word);
    }

    @Override
    public void renderImGui() {

    }
}