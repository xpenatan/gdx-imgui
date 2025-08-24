// Core
include(":imgui:imgui-build")
include(":imgui:imgui-base")
include(":imgui:imgui-core")
include(":imgui:imgui-desktop")
include(":imgui:imgui-teavm")
include(":imgui:imgui-android")

include(":imgui-ext:ext-build")
include(":imgui-ext:ext-core")
include(":imgui-ext:ext-desktop")
include(":imgui-ext:ext-teavm")

// Implementation
include(":gdx:gdx-shared-impl")
include(":gdx:gdx-impl")
include(":gdx:gdx-wgpu-impl")
//include(":gdx:lwjgl3-impl")

// Extension ImLayout
include(":extensions:imlayout:imlayout-build")
include(":extensions:imlayout:imlayout-base")
include(":extensions:imlayout:imlayout-core")
include(":extensions:imlayout:imlayout-teavm")

// Extension ImGuiColorTextEdit
include(":extensions:ImGuiColorTextEdit:textedit-build")
include(":extensions:ImGuiColorTextEdit:textedit-base")
include(":extensions:ImGuiColorTextEdit:textedit-core")
include(":extensions:ImGuiColorTextEdit:textedit-desktop")
include(":extensions:ImGuiColorTextEdit:textedit-teavm")

// Extension imgui-node-editor
include(":extensions:imgui-node-editor:nodeeditor-build")
include(":extensions:imgui-node-editor:nodeeditor-base")
include(":extensions:imgui-node-editor:nodeeditor-cpp")
include(":extensions:imgui-node-editor:nodeeditor-core")
include(":extensions:imgui-node-editor:nodeeditor-teavm")

// Examples
include(":examples:impl:gdx")
include(":examples:impl:gdx-wgpu")

include(":examples:basic:base")
include(":examples:basic:core")
include(":examples:basic:desktop")
include(":examples:basic:desktop-wgpu")
include(":examples:basic:teavm")
include(":examples:basic:android")

include(":examples:imlayout:core")
include(":examples:imlayout:desktop")
include(":examples:imlayout:teavm")

include(":examples:ImGuiColorTextEdit:core")
include(":examples:ImGuiColorTextEdit:desktop")
include(":examples:ImGuiColorTextEdit:teavm")

include(":examples:imgui-node-editor:core")
include(":examples:imgui-node-editor:desktop")
include(":examples:imgui-node-editor:teavm")

//
//include(":examples:node-editor:core")
//include(":examples:node-editor:desktop")
//include(":examples:node-editor:teavm")

//include ":examples:gdx-tests:core"
//include ":examples:gdx-tests:desktop"
//includeBuild('D:\\Dev\\Projects\\java\\libgdx') {
//}

//includeBuild("E:\\Dev\\Projects\\java\\gdx-teavm") {
//    dependencySubstitution {
//        substitute(module("com.github.xpenatan.gdx-teavm:backend-teavm")).using(project(":backends:backend-teavm"))
//    }
//}
//
//includeBuild("E:\\Dev\\Projects\\java\\jParser") {
//    dependencySubstitution {
//        substitute(module("com.github.xpenatan.jParser:jParser-base")).using(project(":jParser:base"))
//        substitute(module("com.github.xpenatan.jParser:jParser-build")).using(project(":jParser:builder"))
//        substitute(module("com.github.xpenatan.jParser:jParser-build-tool")).using(project(":jParser:builder-tool"))
//        substitute(module("com.github.xpenatan.jParser:jParser-core")).using(project(":jParser:core"))
//        substitute(module("com.github.xpenatan.jParser:jParser-cpp")).using(project(":jParser:cpp"))
//        substitute(module("com.github.xpenatan.jParser:jParser-idl")).using(project(":jParser:idl"))
//        substitute(module("com.github.xpenatan.jParser:jParser-teavm")).using(project(":jParser:teavm"))
//        substitute(module("com.github.xpenatan.jParser:loader-core")).using(project(":jParser:loader:loader-core"))
//        substitute(module("com.github.xpenatan.jParser:loader-teavm")).using(project(":jParser:loader:loader-teavm"))
//    }
//}