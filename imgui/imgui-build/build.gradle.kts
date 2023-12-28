import de.undercouch.gradle.tasks.download.Download
import org.gradle.kotlin.dsl.support.unzipTo

plugins {
    id("de.undercouch.download") version("5.4.0")
}

val mainClassName = "BuildImGui"

dependencies {
    implementation(project(":imgui:imgui-base"))
    implementation("com.github.xpenatan.jParser:core:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:builder:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:teavm:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:cpp:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:idl:${LibExt.jParserVersion}")
}

tasks.register<JavaExec>("build_project") {
    dependsOn("classes")
    group = "imgui"
    description = "Generate and build native project"
    mainClass.set(mainClassName)
    classpath = sourceSets["main"].runtimeClasspath
}

val buildDir = layout.buildDirectory.get().asFile
val zippedPath = "${buildDir}/imgui-source.zip"
val sourcePath = "${buildDir}/imgui-source"
val sourceDestination = "${buildDir}/imgui/"

tasks.register<Download>("download_source") {
    group = "imgui"
    description = "Download imgui source"
    src("https://github.com/ocornut/imgui/archive/docking.zip")
    dest(File(zippedPath))
    doLast {
        unzipTo(File(sourcePath), dest)
        copy{
            from(sourcePath)
            into(sourceDestination)

            eachFile {
                val paths = relativePath.segments.drop(1)
                relativePath = RelativePath(true, *paths.toTypedArray())
            }
        }
        delete(sourcePath)
        delete(zippedPath)
    }
}