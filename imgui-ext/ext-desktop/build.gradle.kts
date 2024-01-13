val moduleName = "imgui-ext-desktop"

val windowsFile = "$projectDir/../../imgui/imgui-build/build/c++/libs/windows/ext/imgui64.dll"
val linuxFile = "$projectDir/../../imgui/imgui-build/build/c++/libs/linux/ext/libimgui64.dll"

tasks.jar {
    from(windowsFile)
    from(linuxFile)
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