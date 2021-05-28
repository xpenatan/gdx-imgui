# jDear-imgui
![Deploy Libs](https://github.com/xpenatan/jDear-imgui/workflows/Deploy%20Libs/badge.svg)

jDear-imgui is small pure java binding for C++ [dear-imgui](https://github.com/ocornut/imgui). No Kotlin ! <br>
It's meant to be small and close 1-1 to C++. 

For rendering it use libgdx. Your free to use any other rendering frameworks. DrawData object gives you all the vertices/indexes you need to render it (Java side). 

Try out gdx-imgui-demo and see it working.


**Usage:** <br>
Use the following classes For methods that requires checking UI state: <br>
**ImGuiBoolean**, **ImGuiInt**; **ImGuiDouble**; **ImGuiFloat**; 

## Build
### Gradle

Only SNAPSHOTS are currently available. Release will be ready when ImGui table and docking api goes to master.

    gdxVersion = "1.9.11-SNAPSHOT"
    jDearImguiVersion = "1.0.0-SNAPSHOT"
    jDearImguiLayoutVersion = "1.0.0-SNAPSHOT"
    jDearImguiGdxVersion = "1.0.0-SNAPSHOT"

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
    
    // Add implementation to your app project
    implementation "com.badlogicgames.gdx:gdx-jnigen:$project.jniGenVersion"
    implementation "com.badlogicgames.gdx:gdx-platform:$project.gdxVersion:natives-desktop"
    implementation "com.badlogicgames.gdx:gdx-backend-lwjgl:$project.gdxVersion"
    implementation "com.github.xpenatan.jDear-Imgui:imgui-core:$project.jDearImguiVersion"
    implementation "com.github.xpenatan.jDear-Imgui:imgui-core-platform:$project.jDearImguiVersion:natives-desktop"
    implementation "com.github.xpenatan.jDear-Imgui:imgui-gdx:$project.jDearImguiGdxVersion"
    implementation "com.github.xpenatan.jDear-Imgui:imgui-ext:$project.jDearImguiLayoutVersion"
    implementation "com.github.xpenatan.jDear-Imgui:imgui-ext-platform:$project.jDearImguiLayoutVersion:natives-desktop"
}


```

### Eclipse

To build with eclipse you need:<br>
1: Configure [MinGW](https://github.com/libgdx/libgdx/wiki/jnigen) <br>
2: Import "jDear-imgui" project <br>
3: Download imgui sources C++ files and put them in "jDear-imgui/jni/src/" <br>
4: Run "Build.java" class in "com.github.xpenatan.imgui.generate" package <br>

The compiled native jar will be at "Dear-imgui\libs" 

Note: You will also need "gdx-jnigen" project from libgdx souce (or import as a jar lib). The project will give a error at first import because native lib dont exist (remove and readd after its generated).

### Screenshot of how it will looks when you build it
<p align="center"><img src="https://i.imgur.com/dSTEWl0.png"/></p>

To run demo you need to have the source projects: "gdx" and "gdx-backend-lwjgl" (or import as jar lib)



## Examples
<p align="center"><img src="https://i.imgur.com/rXk4Aq0.gif"/></p>
<p align="center"><img src="https://i.imgur.com/ekZu3lS.png"/></p>
