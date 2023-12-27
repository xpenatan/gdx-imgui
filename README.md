# gdx-imgui
![Deploy Libs](https://github.com/xpenatan/gdx-imgui/workflows/Deploy%20Libs/badge.svg)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/r/com.github.xpenatan.gdx-imgui/imgui-core?nexusVersion=2&server=https%3A%2F%2Foss.sonatype.org&label=release)](https://repo.maven.apache.org/maven2/com/github/xpenatan/gdx-imgui/)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/com.github.xpenatan.gdx-imgui/imgui-core?server=https%3A%2F%2Foss.sonatype.org&label=snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/github/xpenatan/gdx-imgui/)


gdx-imgui is a java binding for C++ [dear-imgui](https://github.com/ocornut/imgui). <br>
It's meant to be small and close 1-1 to C++. 

<p align="center"><img src="https://i.imgur.com/rXk4Aq0.gif"/></p>

## Examples
* [basic](https://xpenatan.github.io/gdx-imgui/basic/)

## Build

#### WINDOWS:
    // ImGui
    // Requirements: Java 11, mingw64 and emscripten
    ./gradlew :imgui:generator:download_source
    ./gradlew :imgui:generator:build_project

    // ImLayout
    ./gradlew :extensions:imlayout:imlayout-generator:build_project_imlayout

#### LINUX:
    TODO

#### MAC:
    TODO

### Gradle

Only SNAPSHOTS are currently available. Release will be ready when ImGui docking api goes to master.

    gdxVersion = "1.12.1"
    gdxImguiVersion = "1.0.0-SNAPSHOT"


```groovy

// Add repository to Root gradle
repositories {
    mavenLocal()
    mavenCentral()
    maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
    maven { url "https://oss.sonatype.org/content/repositories/releases/" }
}

dependencies {
    // Required implementation
    implementation "com.github.xpenatan.gdx-imgui:gdx-impl:$project.gdxImguiVersion"
    
    // ImGui only
    implementation "com.github.xpenatan.gdx-imgui:imgui-core:$project.gdxImguiVersion"
    
    // ImGui only platform natives
    implementation "com.github.xpenatan.gdx-imgui:imgui-desktop:$project.gdxImguiVersion"
    //implementation "com.github.xpenatan.gdx-imgui:imgui-android:$project.gdxImguiVersion"
    //implementation "com.github.xpenatan.gdx-imgui:imgui-ios:$project.gdxImguiVersion"
    implementation "com.github.xpenatan.gdx-imgui:imgui-teavm:$project.gdxImguiVersion"

    // ImGui with extensions
    implementation "com.github.xpenatan.gdx-imgui:imgui-ext-core:$project.gdxImguiVersion"
    
    // ImGui with extensions platform natives
    implementation "com.github.xpenatan.gdx-imgui:imgui-ext-desktop:$project.gdxImguiVersion"
    //implementation "com.github.xpenatan.gdx-imgui:imgui-ext-android:$project.gdxImguiVersion"
    //implementation "com.github.xpenatan.gdx-imgui:imgui-ext-ios:$project.gdxImguiVersion"
    implementation "com.github.xpenatan.gdx-imgui:imgui-ext-teavm:$project.gdxImguiVersion"
}
```