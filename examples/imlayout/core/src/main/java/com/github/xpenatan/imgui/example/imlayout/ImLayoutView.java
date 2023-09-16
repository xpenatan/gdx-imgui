package com.github.xpenatan.imgui.example.imlayout;

import com.github.xpenatan.imgui.example.imlayout.views.CollapseView;
import com.github.xpenatan.imgui.example.imlayout.views.EditTextView;
import com.github.xpenatan.imgui.example.imlayout.views.LayoutTestView;

public class ImLayoutView {

    private EditTextView editTextView = new EditTextView();

    private CollapseView collapseView = new CollapseView();

    private LayoutTestView layoutTestView = new LayoutTestView();


    public void init() {
//        ImLayout.init();
        collapseView.init();;
    }

    public void dispose() {
        collapseView.dispose();
    }

    public void renderTabImGuiExtViews() {

        testContentSize();

        editTextView.render();

        collapseView.render();

        layoutTestView.render();
    }

    private void testContentSize() {
//        ImLayout.BeginBoundingBox();
//        ImGui.Button("Label");
//        ImGui.Button("Label Test");
//        ImRect boundingBox = ImLayout.EndBoundingBox();
//        ImLayout.DrawBoundingBox(boundingBox.minX, boundingBox.minY, boundingBox.maxX, boundingBox.maxY, 255, 0, 0, 255);
    }
}
