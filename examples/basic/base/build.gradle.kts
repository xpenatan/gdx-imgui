dependencies {
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")

    if(LibExt.exampleUseRepoLibs) {
        implementation("com.github.xpenatan.gdx-imgui:core:1.0.0-SNAPSHOT")
        implementation("com.github.xpenatan.gdx-imgui:gdx:1.0.0-SNAPSHOT")
    }
    else {
        implementation(project(":imgui:core"))
        implementation(project(":extensions:gdx"))
    }
}
