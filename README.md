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

    gdxVersion = "1.11.0"
    jDearImguiVersion = "1.0.0-SNAPSHOT"
    gdxFrameViewportVersion = "1.0.0-SNAPSHOT"

```groovy
// Add repository to Root gradle
repositories {
    mavenLocal()
    mavenCentral()
    maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
    maven { url "https://oss.sonatype.org/content/repositories/releases/" }
}

dependencies {
    implementation "com.badlogicgames.gdx:gdx-platform:$project.gdxVersion:natives-desktop"
    implementation "com.badlogicgames.gdx:gdx-backend-lwjgl3:$project.gdxVersion"

    // Required
    implementation "com.github.xpenatan.jDear-Imgui:core:$project.jDearImguiVersion"
    implementation "com.github.xpenatan.jDear-Imgui:gdx:$project.jDearImguiVersion"

    // Required Platform Natives
    implementation "com.github.xpenatan.jDear-Imgui:core-platform:$project.jDearImguiVersion:natives-desktop"
    //implementation "com.github.xpenatan.jDear-Imgui:core-platform:$project.jDearImguiVersion:natives-android"
    //implementation "com.github.xpenatan.jDear-Imgui:core-platform:$project.jDearImguiVersion:natives-ios"
    //implementation "com.github.xpenatan.jDear-Imgui:core-platform:$project.jDearImguiVersion:natives-teavm"

    // Optional
    implementation "com.github.xpenatan.jDear-Imgui:gdx-lwjgl3:$project.jDearImguiVersion"

    // Optional
    implementation "com.github.xpenatan.jDear-Imgui:ext-layout:$project.jDearImguiVersion"
    implementation "com.github.xpenatan.jDear-Imgui:ext-layout-platform:$project.jDearImguiVersion:natives-desktop"

    // Optional
    implementation "com.github.xpenatan.jDear-Imgui:ext-gdx-frame-viewport:$project.jDearImguiVersion"
    implementation "com.github.xpenatan:gdx-frame-viewport:$project.gdxFrameViewportVersion"
}
```

## Examples
<p align="center"><img src="https://i.imgur.com/ekZu3lS.png"/></p>
imgui-gdx-frame-viewport example:
<p align="center"><img src="https://i.imgur.com/rXk4Aq0.gif"/></p>