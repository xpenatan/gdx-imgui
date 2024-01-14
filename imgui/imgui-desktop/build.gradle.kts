val moduleName = "imgui-desktop"

val windowsFile = "$projectDir/../imgui-build/build/c++/libs/windows/imgui64.dll"
val linuxFile = "$projectDir/../imgui-build/build/c++/libs/linux/libimgui64.so"
val macArmFile = "$projectDir/../imgui-build/build/c++/libs/mac/libimguiarm64.dylib"
val macFile = "$projectDir/../imgui-build/build/c++/libs/mac/libimgui64.dylib"

tasks.jar {
    from(windowsFile)
    from(linuxFile)
    from(macArmFile)
    from(macFile)
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