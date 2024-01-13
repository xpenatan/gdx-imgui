dependencies {
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")

    if(LibExt.exampleUseRepoLibs) {
        implementation("com.github.xpenatan.gdx-imgui:imgui-core:-SNAPSHOT")
        implementation("com.github.xpenatan.gdx-imgui:gdx-impl:-SNAPSHOT")
    }
    else {
        implementation(project(":imgui:imgui-core"))
        implementation(project(":gdx:gdx-impl"))
    }
}
