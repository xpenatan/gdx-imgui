package com.github.xpenatan.imgui.core;

import org.junit.BeforeClass;
import org.junit.Test;

public class ImGuiTest {

    @BeforeClass
    public static void setUp() throws Exception {
    }

    @Test
    public void testInit() {
        ImGui.init(false);
        ImGui.dispose();
    }
}