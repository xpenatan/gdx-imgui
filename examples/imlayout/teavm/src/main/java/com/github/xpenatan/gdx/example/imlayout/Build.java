package com.github.xpenatan.gdx.example.imlayout;

import com.github.xpenatan.gdx.backends.teavm.TeaBuildConfiguration;
import com.github.xpenatan.gdx.backends.teavm.TeaBuilder;
import java.io.File;
import java.io.IOException;

public class Build {

    public static void main(String[] args) throws IOException {
        TeaBuildConfiguration teaBuildConfiguration = new TeaBuildConfiguration();
        teaBuildConfiguration.assetsPath.add(new File("../desktop/assets"));
        teaBuildConfiguration.webappPath = new File("build/dist").getCanonicalPath();
        teaBuildConfiguration.obfuscate = false;
//        teaBuildConfiguration.mainApplicationClass = Main.class.getName();
//        TeaBuilder.build(teaBuildConfiguration);
    }
}
