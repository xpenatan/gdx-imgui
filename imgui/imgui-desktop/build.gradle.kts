val moduleName = "imgui-desktop"

val windowsFile = "$projectDir/../imgui-build/build/c++/libs/windows/imgui64.dll"

tasks.jar {
    from(windowsFile)
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