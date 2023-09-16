val moduleName = "imgui-desktop"

val windowsFile = "$projectDir/../generator/build/c++/libs/imgui64.dll"

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