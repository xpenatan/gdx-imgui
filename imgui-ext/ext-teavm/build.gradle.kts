plugins {
    id("java-library")
}

val moduleName = "imgui-ext-teavm"

val emscriptenFile = "$projectDir/../../imgui/imgui-build/build/c++/libs/emscripten/ext/imgui.wasm.js"

tasks.jar {
    from(emscriptenFile)
}

dependencies {
    api(project(":imgui:imgui-teavm"))
    api(project(":extensions:imlayout:imlayout-teavm"))
    api(project(":extensions:ImGuiColorTextEdit:textedit-teavm"))

    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation("com.github.xpenatan.jParser:loader-core:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:loader-teavm:${LibExt.jParserVersion}")
    implementation("org.teavm:teavm-jso:${LibExt.teaVMVersion}")
}

tasks.named("clean") {
    doFirst {
        val srcPath = "$projectDir/src/main/java"
        val jsPath = "$projectDir/src/main/resources/imgui.wasm.js"
        project.delete(files(srcPath, jsPath))
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = moduleName
            from(components["java"])
        }
    }
}