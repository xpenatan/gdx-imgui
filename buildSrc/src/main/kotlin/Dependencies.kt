object LibExt {
    const val groupId = "com.github.xpenatan.gdx-imgui"
    val libVersion: String = getVersion("1.0.0", "b1")

    val gdxImguiVersion = libVersion

    const val teaVMVersion = "0.10.0-dev-2"
    const val gdxTeaVMVersion = "1.0.0-b8"
    const val gdxVersion = "1.12.1"
    const val jniGenVersion = "2.3.1"
    const val gdxFrameViewportVersion = "1.0.0-SNAPSHOT"
    const val jUnitVersion = "4.12"
    const val jParserVersion = "1.0.0-SNAPSHOT"

    const val exampleUseRepoLibs = false
}

private fun getVersion(releaseVersion: String, suffix: String = ""): String {
    val isRelease = System.getenv("RELEASE")
    var libVersion = "${releaseVersion}-SNAPSHOT"
    if(isRelease != null && isRelease.toBoolean()) {
        libVersion = releaseVersion + if(suffix.isNotEmpty()) "-${suffix}" else ""
    }
    System.out.println("Lib Version: " + libVersion)
    return libVersion
}