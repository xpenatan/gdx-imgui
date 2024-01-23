import de.undercouch.gradle.tasks.download.Download
import org.gradle.kotlin.dsl.support.unzipTo

plugins {
    id("de.undercouch.download") version("5.5.0")
}

val mainClassName = "imgui.BuildTextEdit"

dependencies {
    implementation(project(":imgui:imgui-core"))
    implementation("com.github.xpenatan.jParser:jParser-core:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:jParser-build:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:jParser-teavm:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:jParser-cpp:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:jParser-idl:${LibExt.jParserVersion}")
}

tasks.register<JavaExec>("build_project") {
    dependsOn("classes")
    group = "textedit"
    description = "Generate and build native project"
    mainClass.set(mainClassName)
    classpath = sourceSets["main"].runtimeClasspath
}
val buildDir = layout.buildDirectory.get().asFile
val zippedPath = "${buildDir}/text-edit.zip"
val sourcePath = "${buildDir}/text-edit/"
val sourceDestination = "${buildDir}/ImGuiColorTextEdit/"

tasks.register<Download>("download_source") {
    group = "textedit"
    description = "Download source"
    src("https://github.com/BalazsJako/ImGuiColorTextEdit/archive/master.zip")
    dest(File(zippedPath))
    doLast {
        unzipTo(File(sourcePath), dest)
        copy{
            from("$sourcePath/ImGuiColorTextEdit-master")
            into(sourceDestination)
        }
        delete(sourcePath)
        delete(zippedPath)
    }
}
