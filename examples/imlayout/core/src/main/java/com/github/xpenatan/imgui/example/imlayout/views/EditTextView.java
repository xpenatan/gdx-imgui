package com.github.xpenatan.imgui.example.imlayout.views;

import com.github.xpenatan.imgui.core.ImGui;
import com.github.xpenatan.imgui.imlayout.ImLayout;
import com.github.xpenatan.imgui.imlayout.custom.EditTextFloatData;
import com.github.xpenatan.imgui.imlayout.custom.EditTextIntData;
import com.github.xpenatan.imgui.imlayout.custom.EditTextStringData;

public class EditTextView {

    private EditTextFloatData dF1 = new EditTextFloatData("X:", "Tooltip 01", ImGui.ColorToIntBits(255, 0, 0, 255), 0);
    private EditTextFloatData dF2 = new EditTextFloatData("Y:", "Tooltip 02");
    private EditTextFloatData dF3 = new EditTextFloatData("Z:", "Min Value=-5, Max Value=5");

    private EditTextIntData dI1 = new EditTextIntData("X:", "Tooltip 01", ImGui.ColorToIntBits(255, 0, 0, 255), 0);
    private EditTextIntData dI2 = new EditTextIntData("Y:", "Tooltip 02");
    private EditTextIntData dI3 = new EditTextIntData("Z:", "Min Value=-25, Max Value=25");

    private EditTextStringData dS1 = new EditTextStringData("S:", "Tooltip String");

    public void render() {
        renderFloatEditText();
        renderIntEditText();
        renderStringEditText();
    }

    private void renderFloatEditText() {
        // Render the first X, Y, Z edittext where the Z have min and max values and some configuration

        dF1.leftLabelDragColor = ImGui.ColorToIntBits(255, 255, 0, 255);
        dF2.format = "%.2f";
        dF3.v_min = -5f;
        dF3.v_max = 5f;
        dF3.v_speed = 0.01f;
        int index = ImLayout.EditTextF("##1", dF1, dF2, dF3);

        if(index != -1) {
            System.out.println("index: " + index);
            System.out.println("dF1.isDragging: " + dF1.isDragging);
            System.out.println("dF2.isDragging: " + dF2.isDragging);
            System.out.println("dF3.isDragging: " + dF3.isDragging);
        }
    }

    private void renderIntEditText() {
        // Render the second X, Y, Z edittext where the Z have min and max values
        dI3.v_min = -25;
        dI3.v_max = 25;
        ImLayout.EditTextI("##2", dI1, dI2, dI3);
    }

    private void renderStringEditText() {
        if(ImLayout.EditTextS("##S", dS1)) {
            String newValue = dS1.getValue();
            int length = newValue.length();
            System.out.println("newValue: " + newValue);
        }
    }
}
