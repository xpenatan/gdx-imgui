val moduleName = "core"

dependencies {
    implementation("com.github.xpenatan.jParser:jParser-loader:${LibExt.jParserVersion}")

    testImplementation(project(":imgui:desktop"))
    testImplementation("junit:junit:${LibExt.jUnitVersion}")
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