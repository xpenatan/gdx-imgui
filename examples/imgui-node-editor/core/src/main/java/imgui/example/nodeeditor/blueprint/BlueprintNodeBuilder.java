package imgui.example.nodeeditor.blueprint;

import com.badlogic.gdx.math.Vector2;
import imgui.extension.nodeeditor.PinKind;

public class BlueprintNodeBuilder {

    public BlueprintNodeBuilder(int textureId, int textureWidth, int textureHeight) {

    }

    public void Begin(int nodeId) {

    }

    public void End() {

    }

    public void Header(int color) {

    }

    public void EndHeader() {

    }

    public void Input(int pinId) {

    }

    public void EndInput() {

    }

    public void Middle() {

    }

    public void Output(int pinId) {

    }

    public void EndOutput() {

    }

    private void SetStage(Stage stage) {

    }

    private void Pin(int pinId, PinKind kind) {

    }

    private void EndPin() {

    }

    int          HeaderTextureId;
    int          HeaderTextureWidth;
    int          HeaderTextureHeight;
    int          CurrentNodeId;
    Stage        CurrentStage;
    int          HeaderColor;
    Vector2      NodeMin;
    Vector2      NodeMax;
    Vector2      HeaderMin;
    Vector2      HeaderMax;
    Vector2      ContentMin;
    Vector2      ContentMax;
    boolean      HasHeader;

    public enum Stage {
        Invalid,
        Begin,
        Header,
        Content,
        Input,
        Output,
        Middle,
        End
    }
}