dependencies {
    implementation(project(":examples:imlayout:core"))

    if(LibExt.exampleUseRepoLibs) {
        implementation("com.github.xpenatan.gdx-imgui:desktop:1.0.0-SNAPSHOT")
        implementation("com.github.xpenatan.gdx-imgui:imlayout-desktop:1.0.0-SNAPSHOT")
    }
    else {
        implementation(project(":imgui:imgui-desktop"))
        implementation(project(":extensions:imlayout:imlayout-desktop"))
    }

    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:${LibExt.gdxVersion}")
    implementation("com.badlogicgames.gdx:gdx-platform:${LibExt.gdxVersion}:natives-desktop")
}

val mainClassName = "com.github.xpenatan.imgui.example.imlayout.Main"
val assetsDir = File("../assets");

tasks.register<JavaExec>("imlayout-run-desktop") {
    group = "example-desktop"
    description = "Run desktop app"
    mainClass.set(mainClassName)
    classpath = sourceSets["main"].runtimeClasspath
    workingDir = assetsDir
}