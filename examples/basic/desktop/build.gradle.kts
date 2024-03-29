import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform

dependencies {
    implementation(project(":examples:basic:core"))

    if(LibExt.exampleUseRepoLibs) {
        implementation("com.github.xpenatan.gdx-imgui:imgui-desktop:-SNAPSHOT")
    }
    else {
        implementation(project(":imgui:imgui-desktop"))
    }

    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:${LibExt.gdxVersion}")
    implementation("com.badlogicgames.gdx:gdx-platform:${LibExt.gdxVersion}:natives-desktop")
}

val mainClassName = "imgui.example.basic.Main"
val assetsDir = File("../assets");

tasks.register<JavaExec>("basic-run-desktop") {
    group = "example-desktop"
    description = "Run desktop app"
    mainClass.set(mainClassName)
    classpath = sourceSets["main"].runtimeClasspath
    workingDir = assetsDir

    if(DefaultNativePlatform.getCurrentOperatingSystem().isMacOsX) {
        jvmArgs("-XstartOnFirstThread")
    }
}