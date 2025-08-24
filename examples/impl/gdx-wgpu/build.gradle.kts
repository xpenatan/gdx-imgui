plugins {
    id("java-library")
}

java {
    sourceCompatibility = JavaVersion.toVersion(LibExt.java11Target)
    targetCompatibility = JavaVersion.toVersion(LibExt.java11Target)
}

dependencies {
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation(project(":examples:basic:base"))
    if(LibExt.useRepoLibs) {
        api("com.github.xpenatan.xImGui:gdx-wgpu-impl:-SNAPSHOT")
        implementation("com.github.xpenatan.xImGui:imgui-core:-SNAPSHOT")
    }
    else {
        api(project(":gdx:gdx-wgpu-impl"))
        implementation(project(":imgui:imgui-core"))
    }
}