dependencies {
    implementation(project(":imgui:imgui-core"))
    implementation("com.github.xpenatan.jParser:jParser-loader:${LibExt.jParserVersion}")
}

tasks.named("clean") {
    doFirst {
        val srcPath = "$projectDir/src/main/java"
        project.delete(files(srcPath))
    }
}