version = LibExt.gdxImguiVersion

val moduleName = "gdx-frame-viewport"

dependencies {
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation("com.github.xpenatan:gdx-frame-viewport:${LibExt.gdxFrameViewportVersion}")
    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:${LibExt.gdxVersion}")
    implementation(project(":extensions:gdx"))
//    implementation(project(":extensions:lwjgl3"))

    implementation(project(":imgui:core"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = moduleName
            from(components["java"])
        }
    }
}