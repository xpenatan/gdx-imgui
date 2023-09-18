dependencies {
    // Required
    implementation("com.badlogicgames.gdx:gdx-platform:${LibExt.gdxVersion}:natives-desktop")
    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:${LibExt.gdxVersion}")

    implementation(project(":imgui:core"))
    implementation(project(":examples:basic:base"))
    implementation(project(":extensions:gdx"))

    // Optional. Used for multi viewports. Currently WIP.
//    implementation(project(":extensions:lwjgl3"))

    // Optional
    implementation(project(":extensions:gdx-frame-viewport"))
    implementation("com.github.xpenatan:gdx-frame-viewport:${LibExt.gdxFrameViewportVersion}")
}