package com.github.xpenatan.gdx.example.imlayout;

import com.github.xpenatan.gdx.backends.teavm.TeaBuildConfiguration;
import com.github.xpenatan.gdx.backends.teavm.TeaBuilder;
import com.github.xpenatan.imgui.example.basic.BasicExample;
import java.io.File;

public class Build {

    public static void main(String[] args) {
        TeaBuildConfiguration teaBuildConfiguration = new TeaBuildConfiguration();
        teaBuildConfiguration.assetsPath.add(new File("../desktop/assets"));
        teaBuildConfiguration.webappPath = new File(".").getAbsolutePath();
        teaBuildConfiguration.obfuscate = false;
        teaBuildConfiguration.logClasses = false;
        teaBuildConfiguration.mainApplicationClass = BasicExample.class.getName();
        TeaBuilder.build(teaBuildConfiguration);
    }
}
