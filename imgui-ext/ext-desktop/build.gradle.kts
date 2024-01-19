val moduleName = "imgui-ext-desktop"

val imguiDir = "$projectDir/../../imgui"
val windowsFile = "$imguiDir/imgui-build/build/c++/libs/windows/ext/imgui64.dll"
val linuxFile = "$imguiDir/imgui-build/build/c++/libs/linux/ext/libimgui64.so"
val macFile = "$imguiDir/imgui-build/build/c++/libs/mac/ext/libimgui64.dylib"
val macArmFile = "$imguiDir/imgui-build/build/c++/libs/mac/arm/ext/libimguiarm64.dylib"

tasks.jar {
    from(windowsFile)
    from(linuxFile)
    from(macFile)
    from(macArmFile)
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