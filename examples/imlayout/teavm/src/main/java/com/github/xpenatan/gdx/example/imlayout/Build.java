package com.github.xpenatan.gdx.example.imlayout;

import com.github.xpenatan.gdx.backends.teavm.config.TeaBuildConfiguration;
import com.github.xpenatan.gdx.backends.teavm.config.TeaBuilder;
import com.github.xpenatan.gdx.example.imlayout.launcher.Launcher;
import java.io.File;
import java.io.IOException;
import org.teavm.tooling.TeaVMTool;

public class Build {

    public static void main(String[] args) throws IOException {
        TeaBuildConfiguration teaBuildConfiguration = new TeaBuildConfiguration();
        teaBuildConfiguration.assetsPath.add(new File("../assets"));
        teaBuildConfiguration.webappPath = new File("build/dist").getCanonicalPath();
        teaBuildConfiguration.obfuscate = false;

        TeaVMTool tool = TeaBuilder.config(teaBuildConfiguration);
        tool.setMainClass(Launcher.class.getName());
        TeaBuilder.build(tool);
    }
}
