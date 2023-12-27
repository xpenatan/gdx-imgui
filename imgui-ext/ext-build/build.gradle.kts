val mainExtensionsClassName = "MainExtensions"

dependencies {
    implementation(project(":imgui:base"))
    implementation("com.github.xpenatan.jParser:core:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:builder:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:teavm:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:cpp:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:idl:${LibExt.jParserVersion}")
}

tasks.register<JavaExec>("build_project_ext") {
    dependsOn("classes")
    group = "imgui"
    description = "Generate ImGui with extensions"
    mainClass.set(mainExtensionsClassName)
    classpath = sourceSets["main"].runtimeClasspath
}