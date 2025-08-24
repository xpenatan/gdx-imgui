plugins {
    id("java")
}

java {
    sourceCompatibility = JavaVersion.toVersion(LibExt.java11Target)
    targetCompatibility = JavaVersion.toVersion(LibExt.java11Target)
}

dependencies {
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation(project(":examples:basic:base"))
    if(LibExt.useRepoLibs) {
        implementation("com.github.xpenatan.xImGui:gdx-wgpu-impl:-SNAPSHOT")
        implementation("com.github.xpenatan.xImGui:imgui-core:-SNAPSHOT")
    }
    else {
        implementation(project(":gdx:gdx-wgpu-impl"))
        implementation(project(":imgui:imgui-core"))
    }

    implementation("io.github.monstroussoftware.gdx-webgpu:gdx-webgpu:${LibExt.gdxWebGPUVersion}")
}