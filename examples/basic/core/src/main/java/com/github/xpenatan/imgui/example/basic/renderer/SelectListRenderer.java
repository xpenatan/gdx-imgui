package com.github.xpenatan.imgui.example.basic.renderer;

import com.badlogic.gdx.utils.Array;
import com.github.xpenatan.imgui.core.ImGui;

public class SelectListRenderer {

    private Array<String> items;

    private int currentIndex = 0;

    public SelectListRenderer() {
        items = new Array<>();
        items.add("Item01");
        items.add("Item02");
        items.add("Item03");
        items.add("Item04");
    }

    public void render() {
        String selectedText = items.get(currentIndex);
        if(ImGui.BeginCombo("##selectListId", selectedText)) {
            for(int i = 0; i < items.size; i++) {
                String item = items.get(i);
                boolean selected = i == currentIndex;
                if(ImGui.Selectable(item, selected)) {
                    currentIndex = i;
                }
            }
            ImGui.EndCombo();
        }
    }
}
