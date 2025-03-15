plugins {
    id("java-library")
}

val moduleName = "imgui-ext-core"

dependencies {
    api(project(":imgui:imgui-core"))
    api(project(":extensions:imlayout:imlayout-core"))
    api(project(":extensions:ImGuiColorTextEdit:textedit-core"))
    api(project(":extensions:imgui-node-editor:nodeeditor-core"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

val fromClasses = tasks.register<Jar>("fromClasses") {
    val dependencies = configurations
        .compileClasspath
        .get()
    from((dependencies).map(::zipTree))
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    dependsOn("assemble")
}

val sourcesJar = tasks.register<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(sourceSets["main"].allSource) {
    }
}

val javadocJar = tasks.register<Jar>("javadocJar") {
    archiveClassifier.set("javadoc")
    from(tasks.javadoc)
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = moduleName
            artifact(fromClasses)
            artifact(sourcesJar)
            artifact(javadocJar)

            pom.withXml {
                val dependenciesNode = asNode().appendNode("dependencies")
                val dependencyNode = dependenciesNode.appendNode("dependency")
                dependencyNode.appendNode("groupId", "com.github.xpenatan.jParser")
                dependencyNode.appendNode("artifactId", "loader-core")
                dependencyNode.appendNode("version", LibExt.jParserVersion)
            }
        }
    }
}