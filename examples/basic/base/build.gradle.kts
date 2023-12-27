dependencies {
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")

    if(LibExt.exampleUseRepoLibs) {
        implementation("com.github.xpenatan.gdx-imgui:imgui-core:1.0.0-SNAPSHOT")
        implementation("com.github.xpenatan.gdx-imgui:gdx-impl:1.0.0-SNAPSHOT")
    }
    else {
        implementation(project(":imgui:imgui-core"))
        implementation(project(":gdx:gdx-impl"))
    }
}
