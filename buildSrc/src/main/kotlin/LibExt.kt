import java.io.File
import java.util.*

object LibExt {
    const val groupId = "com.github.xpenatan.xImGui"
    const val libName = "xImGui"
    var isRelease = false
    var libVersion: String = ""
        get() {
            return getVersion()
        }

    const val java8Target = "1.8"
    const val java11Target = "11"

    const val gdxVersion = "1.13.5"
    const val teaVMVersion = "0.12.3"
    const val gdxTeaVMVersion = "1.2.4"
    const val jParserVersion = "1.0.0-b16"
    const val jUnitVersion = "4.12"

    const val useRepoLibs = true
}

private fun getVersion(): String {
    var libVersion = "-SNAPSHOT"
    val file = File("gradle.properties")
    if(file.exists()) {
        val properties = Properties()
        properties.load(file.inputStream())
        val version = properties.getProperty("version")
        if(LibExt.isRelease) {
            libVersion = version
        }
    }
    else {
        if(LibExt.isRelease) {
            throw RuntimeException("properties should exist")
        }
    }
    return libVersion
}