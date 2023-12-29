package imgui.example.textedit;

import com.badlogic.gdx.Game;

public class ImGuiGame extends Game {

    @Override
    public void create() {
        setScreen(new ImGuiInitScreen(this));
    }
}
