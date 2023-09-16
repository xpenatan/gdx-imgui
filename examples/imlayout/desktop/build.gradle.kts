dependencies {
    implementation(project(":examples:imlayout:core"))
    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:${LibExt.gdxVersion}")
    implementation("com.badlogicgames.gdx:gdx-platform:${LibExt.gdxVersion}:natives-desktop")

    implementation(project(":imgui:desktop"))
    implementation(project(":extensions:imlayout:desktop"))
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