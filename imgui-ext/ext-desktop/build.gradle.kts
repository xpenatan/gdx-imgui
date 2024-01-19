val moduleName = "imgui-ext-desktop"

val windowsFile = "$projectDir/../../imgui/imgui-build/build/c++/libs/windows/ext/imgui64.dll"
val linuxFile = "$projectDir/../../imgui/imgui-build/build/c++/libs/linux/ext/libimgui64.so"
val macArmFile = "$projectDir/../imgui-build/build/c++/libs/mac/ext/arm/libimguiarm64.dylib"
val macFile = "$projectDir/../imgui-build/build/c++/libs/mac/ext/libimgui64.dylib"

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