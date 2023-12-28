val moduleName = "imgui-ext-desktop"

val windowsFile = "$projectDir/../../imgui/imgui-build/build/c++/libs/windows/ext/imgui64.dll"

tasks.jar {
    from(windowsFile)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = moduleName
            from(components["java"])
        }
    }
}