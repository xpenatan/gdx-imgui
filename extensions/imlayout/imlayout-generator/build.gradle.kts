val mainClassName = "imgui.BuildImLayout"

dependencies {
    implementation(project(":imgui:core")) // Will use IDL helper class form imgui core
    implementation(project(":extensions:imlayout:imlayout-base"))
    implementation("com.github.xpenatan.jParser:core:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:builder:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:teavm:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:cpp:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:idl:${LibExt.jParserVersion}")
}

tasks.register<JavaExec>("build_project_imlayout") {
    dependsOn("classes")
    group = "imgui"
    description = "Generate and build native project"
    mainClass.set(mainClassName)
    classpath = sourceSets["main"].runtimeClasspath
}