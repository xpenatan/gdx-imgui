val mainExtensionsClassName = "imgui.BuildImGuiExtensions"

dependencies {
    implementation(project(":imgui:imgui-build"))
    implementation("com.github.xpenatan.jParser:core:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:builder:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:teavm:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:cpp:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:idl:${LibExt.jParserVersion}")
}

tasks.register<JavaExec>("build_project") {
    dependsOn("classes")
    group = "imgui-ext"
    description = "Generate ImGui with extensions"
    mainClass.set(mainExtensionsClassName)
    classpath = sourceSets["main"].runtimeClasspath
}