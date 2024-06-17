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

val zippedVendorPath = "${buildDir}/regex.zip"
val sourceVendorPath = "${buildDir}/regex/"
val sourceVendorDestination = "${buildDir}/ImGuiColorTextEdit/vendor/regex"

tasks.register<Download>("download_textedit_source") {
    group = "textedit"
    description = "Download source"
    src("https://github.com/santaclose/ImGuiColorTextEdit/archive/master.zip")
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


tasks.register<Download>("download_vendor_source") {
    group = "textedit"
    description = "Download source"
    src("https://github.com/boostorg/regex/archive/4cbcd3078e6ae10d05124379623a1bf03fcb9350.zip")
    dest(File(zippedVendorPath))
    doLast {
        unzipTo(File(sourceVendorPath), dest)
        copy{
            from("$sourceVendorPath/regex-4cbcd3078e6ae10d05124379623a1bf03fcb9350/")
            into(sourceVendorDestination)
        }
        delete(sourceVendorPath)
        delete(zippedVendorPath)
    }
}

tasks.register("download_source") {
    group = "textedit"
    description = "Download source"

    val list = listOf("download_textedit_source", "download_vendor_source")
    dependsOn(list)

    tasks.findByName("download_vendor_source")?.mustRunAfter("download_textedit_source")
}