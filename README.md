# gdx-imgui
![Deploy Libs](https://github.com/xpenatan/gdx-imgui/workflows/Deploy%20Libs/badge.svg)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/r/com.github.xpenatan.gdx-imgui/imgui-core?nexusVersion=2&server=https%3A%2F%2Foss.sonatype.org&label=release)](https://repo.maven.apache.org/maven2/com/github/xpenatan/gdx-imgui/)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/com.github.xpenatan.gdx-imgui/imgui-core?server=https%3A%2F%2Foss.sonatype.org&label=snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/github/xpenatan/gdx-imgui/)


gdx-imgui is a java binding for C++ [dear-imgui](https://github.com/ocornut/imgui). <br>
It uses webidl file to generate java methods with the help of [jParser](https://github.com/xpenatan/jParser). <br>
It's meant to be small and 1-1 to C++. ImGui::Begin() is ImGui.Begin() and so on.

<p align="center"><img src="https://i.imgur.com/rXk4Aq0.gif"/></p>

## Examples
* [basic](https://xpenatan.github.io/gdx-imgui/basic/)

### ImGui current state:

| Emscripten | Windows | Linux | Mac | Android | iOS |
|:----------:|:-------:|:-----:|:---:|:-------:|:---:|
|     ✅      | ✅ | ✅ | ✅¹  | ⚠️ | ❌ |

* ✅: Have a working build.
* ⚠️: Have a working build, but it's not ready yet.
* ❌: Build not ready.

¹ arm build not working

Note: 
```
* Only snapshot builds are currently available. 
* It's best to try the examples first to see how it works before adding to your project.
* There are 2 ImGui builds. The first contains ImGui only. The second (Ext) contains ImGui with extensions. 
```

## How to run examples
There are two ways to run examples. 
* Build the source and run:
```./gradlew :examples:basic:desktop:basic-run-desktop```
* Change LibExt.exampleUseRepoLibs to true in Dependencies.kt and that will make all examples use snapshot from repository

## Setup

    gdxVersion = "1.12.1"
    gdxImguiVersion = "-SNAPSHOT"

```groovy
// Add repository to Root gradle
repositories {
    mavenLocal()
    mavenCentral()
    maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
    maven { url "https://oss.sonatype.org/content/repositories/releases/" }
}
```

### Core module
```groovy
dependencies {
    implementation("com.github.xpenatan.gdx-imgui:gdx-impl:$project.gdxImguiVersion")
    implementation("com.github.xpenatan.gdx-imgui:imgui-core:$project.gdxImguiVersion")

    // Or the extension build
    implementation "com.github.xpenatan.gdx-imgui:imgui-ext-core:$project.gdxImguiVersion"
}
```

### Desktop module
```groovy
dependencies {
    implementation("com.github.xpenatan.gdx-imgui:imgui-desktop:$project.gdxImguiVersion")

    // Or the extension build
    implementation "com.github.xpenatan.gdx-imgui:imgui-ext-desktop:$project.gdxImguiVersion"
}
```

### TeaVM module
```groovy
dependencies {
    implementation("com.github.xpenatan.gdx-imgui:imgui-teavm:$project.gdxImguiVersion")

    // Or the extension build
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