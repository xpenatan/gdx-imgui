val mainClassName = "imgui.BuildImLayout"

dependencies {
    implementation(project(":imgui:imgui-core")) // Will use IDL helper class form imgui core
    implementation("com.github.xpenatan.jParser:jParser-core:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:jParser-build:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:jParser-teavm:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:jParser-cpp:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:jParser-idl:${LibExt.jParserVersion}")
}

tasks.register<JavaExec>("build_project") {
    dependsOn("classes")
    group = "imlayout"
    description = "Generate and build native project"
    mainClass.set(mainClassName)
    classpath = sourceSets["main"].runtimeClasspath
}