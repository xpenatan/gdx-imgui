dependencies {
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation("com.github.xpenatan.jParser:loader-core:${LibExt.jParserVersion}")

    implementation(project(":imgui:core"))
    implementation(project(":extensions:gdx"))
}
