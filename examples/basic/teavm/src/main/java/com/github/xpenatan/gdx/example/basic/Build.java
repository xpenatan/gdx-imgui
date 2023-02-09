package com.github.xpenatan.gdx.example.basic;

import com.github.xpenatan.gdx.backends.teavm.TeaBuildConfiguration;
import com.github.xpenatan.gdx.backends.teavm.TeaBuilder;
import com.github.xpenatan.gdx.backends.web.gen.SkipClass;
import com.github.xpenatan.gdx.example.basic.launcher.Launcher;
import java.io.File;
import org.teavm.tooling.TeaVMTool;

@SkipClass
public class Build {

    public static void main(String[] args) {
        TeaBuildConfiguration teaBuildConfiguration = new TeaBuildConfiguration();
        teaBuildConfiguration.assetsPath.add(new File("../desktop/assets"));
        teaBuildConfiguration.webappPath = new File(".").getAbsolutePath();
        teaBuildConfiguration.obfuscate = false;

        TeaVMTool tool = TeaBuilder.config(teaBuildConfiguration);
        tool.setMainClass(Launcher.class.getName());
        TeaBuilder.build(tool);
    }
}
