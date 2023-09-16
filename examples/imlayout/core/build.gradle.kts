dependencies {
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation("com.github.xpenatan.jParser:jParser-loader:${LibExt.jParserVersion}")

    implementation(project(":examples:basic:base"))
    implementation(project(":imgui:core"))
    implementation(project(":extensions:imlayout:imlayout-core"))
    implementation(project(":extensions:gdx"))
}
