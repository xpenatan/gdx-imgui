dependencies {
    implementation(project(":imgui:core"))
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation("com.github.xpenatan.jParser:loader-core:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:loader-teavm:${LibExt.jParserVersion}")
    implementation("org.teavm:teavm-jso:${LibExt.teaVMVersion}")
}