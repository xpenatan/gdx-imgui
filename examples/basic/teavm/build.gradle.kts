plugins {
    id("java")
    id("org.gretty") version("3.1.0")
}

gretty {
    contextPath = "/"
    extraResourceBase("build/dist/webapp")
}

java {
    sourceCompatibility = JavaVersion.toVersion(LibExt.java11Target)
    targetCompatibility = JavaVersion.toVersion(LibExt.java11Target)
}

dependencies {
    implementation(project(":examples:basic:base"))
    implementation(project(":examples:basic:core"))
    implementation(project(":examples:impl:gdx"))

    if(LibExt.useRepoLibs) {
        implementation("com.github.xpenatan.xImGui:imgui-teavm:-SNAPSHOT")
    }
    else {
        implementation(project(":imgui:imgui-teavm"))
    }

    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation("com.github.xpenatan.gdx-teavm:backend-teavm:${LibExt.gdxTeaVMVersion}")
}

val mainClassName = "imgui.example.basic.Build"

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