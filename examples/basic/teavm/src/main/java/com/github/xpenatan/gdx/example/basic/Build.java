package com.github.xpenatan.gdx.example.basic;

import com.github.xpenatan.gdx.backends.teavm.TeaBuildConfiguration;
import com.github.xpenatan.gdx.backends.teavm.TeaBuilder;
import com.github.xpenatan.imgui.example.basic.BasicExample;
import java.io.File;
import org.teavm.tooling.TeaVMTool;

public class Build {

    public static void main(String[] args) {
        TeaBuildConfiguration teaBuildConfiguration = new TeaBuildConfiguration();
        teaBuildConfiguration.assetsPath.add(new File("../desktop/assets"));
        teaBuildConfiguration.webappPath = new File(".").getAbsolutePath();
        teaBuildConfiguration.obfuscate = false;
        teaBuildConfiguration.setApplicationListener(BasicExample.class);
        TeaVMTool tool = TeaBuilder.config(teaBuildConfiguration);
        TeaBuilder.build(tool);
    }
}
