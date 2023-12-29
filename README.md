# gdx-imgui
![Deploy Libs](https://github.com/xpenatan/gdx-imgui/workflows/Deploy%20Libs/badge.svg)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/r/com.github.xpenatan.gdx-imgui/imgui-core?nexusVersion=2&server=https%3A%2F%2Foss.sonatype.org&label=release)](https://repo.maven.apache.org/maven2/com/github/xpenatan/gdx-imgui/)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/com.github.xpenatan.gdx-imgui/imgui-core?server=https%3A%2F%2Foss.sonatype.org&label=snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/github/xpenatan/gdx-imgui/)


gdx-imgui is a java binding for C++ [dear-imgui](https://github.com/ocornut/imgui). <br>
It's meant to be small and close 1-1 to C++. 

<p align="center"><img src="https://i.imgur.com/rXk4Aq0.gif"/></p>

## Examples
* [basic](https://xpenatan.github.io/gdx-imgui/basic/)

## How to run examples
There are two ways to run examples. 
* Build the source for your platform and run:
``` ./gradlew :examples:basic:desktop:basic-run-desktop```
* Change LibExt.exampleUseRepoLibs to true in Dependencies.kt and that will make all examples run snapshot from repository

## Setup

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

## Build source

* Requirements: Java 11, mingw64 and emscripten
* Windows only for now.

```
##### ImGui
./gradlew :imgui:imgui-build:download_source
./gradlew :imgui:imgui-build:build_project
```
```
##### ImGui with extensions. Need to build ImGui first
./gradlew :extensions:imlayout:imlayout-build:build_project
./gradlew :extensions:ImGuiColorTextEdit:textedit-build:download_source
./gradlew :extensions:ImGuiColorTextEdit:textedit-build:build_project
./gradlew :extensions:imgui-node-editor:nodeeditor-build:download_source
./gradlew :extensions:imgui-node-editor:nodeeditor-build:build_project
./gradlew :imgui:imgui-ext-build:build_project
```