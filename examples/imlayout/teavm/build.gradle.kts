plugins {
    id("org.gretty") version("3.1.0")
}

gretty {
    contextPath = "/"
    extraResourceBase("build/dist/webapp")
}

val mainClassName = "imgui.example.imlayout.Build"

dependencies {
    implementation(project(":examples:imlayout:core"))

    if(LibExt.exampleUseRepoLibs) {
        implementation("com.github.xpenatan.gdx-imgui:imgui-ext-teavm:-SNAPSHOT")
    }
    else {
        implementation(project(":imgui-ext:ext-teavm"))
    }

    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation("com.github.xpenatan.gdx-teavm:backend-teavm:${LibExt.gdxTeaVMVersion}")
}

tasks.register<JavaExec>("imlayout-build") {
    group = "example-teavm"
    description = "Build basic example"
    mainClass.set(mainClassName)
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.register("imlayout-run-teavm") {
    group = "example-teavm"
    description = "Run teavm app"
    val list = listOf("imlayout-build", "jettyRun")
    dependsOn(list)

    tasks.findByName("jettyRun")?.mustRunAfter("imlayout-build")
}