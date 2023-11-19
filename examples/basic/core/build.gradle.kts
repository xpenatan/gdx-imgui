dependencies {
    implementation(project(":examples:basic:base"))

    if(LibExt.exampleUseRepoLibs) {
        implementation("com.github.xpenatan.gdx-imgui:core:1.0.0-SNAPSHOT")
    }
    else {
        implementation(project(":imgui:core"))
    }

    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation("com.github.xpenatan.jParser:loader-core:${LibExt.jParserVersion}")
}
