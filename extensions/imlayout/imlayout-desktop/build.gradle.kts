val windowsFile = "$projectDir/../imlayout-generator/build/c++/libs/windows/imlayout64.dll"

tasks.jar {
    from(windowsFile)
}