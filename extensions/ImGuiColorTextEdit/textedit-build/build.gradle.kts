import de.undercouch.gradle.tasks.download.Download
import org.gradle.kotlin.dsl.support.unzipTo

plugins {
    id("de.undercouch.download") version("5.5.0")
}

val mainClassName = "imgui.extension.textedit.Main"

dependencies {
    implementation(project(":imgui:imgui-core"))
    implementation("com.github.xpenatan.jParser:core:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:builder:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:teavm:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:cpp:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:idl:${LibExt.jParserVersion}")
}

tasks.register<JavaExec>("build_project") {
    dependsOn("classes")
    group = "color_textedit"
    description = "Generate and build native project"
    mainClass.set(mainClassName)
    classpath = sourceSets["main"].runtimeClasspath
}

val zippedPath = "$buildDir/text-edit.zip"
val sourcePath = "$buildDir/text-edit/"
val sourceDestination = "$buildDir/ImGuiColorTextEdit/"

tasks.register<Download>("download_source") {
    group = "color_textedit"
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
