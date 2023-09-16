val moduleName = "imlayout-core"

dependencies {
    implementation(project(":imgui:core"))
    implementation("com.github.xpenatan.jParser:jParser-loader:${LibExt.jParserVersion}")
}

tasks.named("clean") {
    doFirst {
        val srcPath = "$projectDir/src/main/java"
        project.delete(files(srcPath))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = moduleName
            from(components["java"])
        }
    }
}