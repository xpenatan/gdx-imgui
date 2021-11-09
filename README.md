# jDear-imgui
![Deploy Libs](https://github.com/xpenatan/jDear-imgui/workflows/Deploy%20Libs/badge.svg)

jDear-imgui is a java binding for C++ [dear-imgui](https://github.com/ocornut/imgui). <br>
It's meant to be small and close 1-1 to C++. 

It use libgdx for rendering. Your free to use any other rendering frameworks. DrawData object gives you all the vertices/indexes you need to render it (Java side). 

Try out gdx-imgui-demo and see it working.


## Build

To build from source you need mingw. You can find the instructions at https://github.com/libgdx/libgdx/wiki/jnigen.

When project is ready, run buildImGuiNatives from gralde GUI and publishToMavenLocal to test your changes.

![img.png](https://i.imgur.com/a1MyyzF.png)

### Gradle

Only SNAPSHOTS are currently available. Release will be ready when ImGui docking api goes to master.

    gdxVersion = "1.9.11-SNAPSHOT"
    jDearImguiVersion = "1.0.0-SNAPSHOT"
    jDearImguiLayoutVersion = "1.0.0-SNAPSHOT"
    jDearImguiGdxVersion = "1.0.0-SNAPSHOT"
    jDearImguiGdxFrameViewportVersion = "1.0.0-SNAPSHOT"
    gdxFrameViewportVersion = "1.0.0-SNAPSHOT"

```groovy
dependencies {
    // Add repository to Root gradle
    repositories {
        mavenLocal()
        jcenter()
        mavenCentral()
        maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
        maven { url "https://oss.sonatype.org/content/repositories/releases/" }
    }

    // Required
    implementation "com.badlogicgames.gdx:gdx-platform:$project.gdxVersion:natives-desktop"
    implementation "com.badlogicgames.gdx:gdx-backend-lwjgl3:$project.gdxVersion"
    implementation "com.github.xpenatan.jDear-Imgui:imgui-core:$project.jDearImguiVersion"
    implementation "com.github.xpenatan.jDear-Imgui:imgui-core-platform:$project.jDearImguiVersion:natives-desktop"
    implementation "com.github.xpenatan.jDear-Imgui:imgui-gdx:$project.jDearImguiGdxVersion"

    // Optional. Used for multi viewports. Currently WIP.
    implementation "com.github.xpenatan.jDear-Imgui:imgui-gdx-lwjgl3:$project.jDearImguiGdxVersion"

    // Optional
    implementation "com.github.xpenatan.jDear-Imgui:imgui-ext:$project.jDearImguiLayoutVersion"
    implementation "com.github.xpenatan.jDear-Imgui:imgui-ext-platform:$project.jDearImguiLayoutVersion:natives-desktop"
    implementation "com.github.xpenatan.jDear-Imgui:imgui-gdx-frame-viewport:$project.jDearImguiGdxFrameViewportVersion"
    implementation "com.github.xpenatan:gdx-frame-viewport:$project.gdxFrameViewportVersion"
}
```

## Examples
<p align="center"><img src="https://i.imgur.com/ekZu3lS.png"/></p>
imgui-gdx-frame-viewport example:
<p align="center"><img src="https://i.imgur.com/rXk4Aq0.gif"/></p>