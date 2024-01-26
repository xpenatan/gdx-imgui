val genPath = File("$projectDir/../nodeeditor-cpp/src/main/java")
println("Path " + genPath.canonicalPath)
sourceSets["main"].java {
    srcDir(genPath)
}

dependencies {
    implementation(project(":imgui:imgui-core"))
}