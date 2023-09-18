val moduleName = "imlayout-teavm"

val emscriptenFile = "$projectDir/../imlayout-generator/build/c++/libs/imlayout.wasm.js"

tasks.jar {
    from(emscriptenFile)
}

dependencies {
    implementation(project(":imgui:core"))
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    implementation("com.github.xpenatan.jParser:loader-core:${LibExt.jParserVersion}")
    implementation("com.github.xpenatan.jParser:loader-teavm:${LibExt.jParserVersion}")
    implementation("org.teavm:teavm-jso:${LibExt.teaVMVersion}")
}

tasks.named("clean") {
    doFirst {
        val srcPath = "$projectDir/src/main/java"
        val jsPath = "$projectDir/src/main/resources/imlayout.wasm.js"
        project.delete(files(srcPath, jsPath))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = moduleName
            from(components["java"])
        }
    }
}