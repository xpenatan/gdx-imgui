dependencies {
    implementation(project(":examples:basic:base"))

    if(LibExt.exampleUseRepoLibs) {
        implementation("com.github.xpenatan.gdx-imgui:imgui-core:-SNAPSHOT")
    }
    else {
        implementation(project(":imgui:imgui-core"))
    }

    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation("com.github.xpenatan.jParser:loader-core:${LibExt.jParserVersion}")
}
