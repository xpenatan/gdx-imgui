plugins {
    id("org.gretty") version("3.1.0")
}

gretty {
    contextPath = "/"
    extraResourceBase("build/dist/webapp")
}

dependencies {
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation("com.github.xpenatan.gdx-teavm:backend-teavm:${LibExt.gdxTeaVMVersion}")

    implementation(project(":examples:basic:core"))
    implementation(project(":imgui:teavm"))
}

val mainClassName = "com.github.xpenatan.gdx.example.basic.Build"

tasks.register<JavaExec>("basic-build") {
    group = "example-teavm"
    description = "Build basic example"
    mainClass.set(mainClassName)
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.register("basic-run-teavm") {
    group = "example-teavm"
    description = "Run teavm app"
    val list = listOf("basic-build", "jettyRun")
    dependsOn(list)

    tasks.findByName("jettyRun")?.mustRunAfter("basic-build")
}