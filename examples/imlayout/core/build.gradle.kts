dependencies {
    implementation(project(":examples:basic:base"))

    if(LibExt.exampleUseRepoLibs) {
        implementation("com.github.xpenatan.gdx-imgui:imgui-ext-core:-SNAPSHOT")
        implementation("com.github.xpenatan.gdx-imgui:gdx-impl:-SNAPSHOT")
    }
    else {
        implementation(project(":imgui-ext:ext-core"))
        implementation(project(":gdx:gdx-impl"))
    }

    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation("com.github.xpenatan.jParser:jParser-loader:${LibExt.jParserVersion}")
}
