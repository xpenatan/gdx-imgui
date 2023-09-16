version = LibExt.imlayoutVersion

val moduleName = "imlayout-desktop"

val windowsFile = "$projectDir/../generator/build/c++/libs/imlayout64.dll"

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