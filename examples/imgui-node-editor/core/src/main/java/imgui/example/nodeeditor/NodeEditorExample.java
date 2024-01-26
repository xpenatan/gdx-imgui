package imgui.example.nodeeditor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import imgui.ImGui;
import imgui.ImVec2;
import imgui.example.renderer.ImGuiRenderer;
import imgui.extension.nodeeditor.Config;
import imgui.extension.nodeeditor.EditorContext;
import imgui.extension.nodeeditor.LoadSaveSettingsListener;
import imgui.extension.nodeeditor.NodeEditor;
import imgui.extension.nodeeditor.PinKind;
import imgui.idl.helper.IDLString;

public class NodeEditorExample extends ImGuiRenderer {

    private EditorContext editorContext;

    @Override
    public void show() {
        super.show();
        Config config  = new Config();
        editorContext = NodeEditor.CreateEditor(new LoadSaveSettingsListener() {
            @Override
            public void onLoad(IDLString data) {
                Preferences preferences = Gdx.app.getPreferences("NodeEditorData");
                String jsonData = preferences.getString("jsonData", "");
                data.append(jsonData);
            }

            @Override
            public boolean onSave(IDLString data, int reason) {
                Preferences preferences = Gdx.app.getPreferences("NodeEditorData");
                String str = data.c_str();
                preferences.putString("jsonData", str);
                preferences.flush();
                return true;
            }
        });
    }

    @Override
    public void renderImGui() {
        SimpleExample.render(editorContext);
    }

    @Override
    public void dispose() {
        super.dispose();

        NodeEditor.DestroyEditor(editorContext);
    }
}