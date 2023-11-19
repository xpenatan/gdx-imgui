dependencies {
    implementation(project(":examples:basic:base"))

    if(LibExt.exampleUseRepoLibs) {
        implementation("com.github.xpenatan.gdx-imgui:core:1.0.0-SNAPSHOT")
        implementation("com.github.xpenatan.gdx-imgui:imlayout-core:1.0.0-SNAPSHOT")
        implementation("com.github.xpenatan.gdx-imgui:gdx:1.0.0-SNAPSHOT")
    }
    else {
        implementation(project(":imgui:core"))
        implementation(project(":extensions:imlayout:imlayout-core"))
        implementation(project(":extensions:gdx"))
    }

    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation("com.github.xpenatan.jParser:jParser-loader:${LibExt.jParserVersion}")
}
