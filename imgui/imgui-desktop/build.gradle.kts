val moduleName = "imgui-desktop"

val windowsFile = "$projectDir/../imgui-build/build/c++/libs/windows/imgui64.dll"

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