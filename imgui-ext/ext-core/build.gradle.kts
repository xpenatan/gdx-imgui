import groovy.util.Node

plugins {
    id("java-library")
}

val moduleName = "imgui-ext-core"

dependencies {
    api("com.github.xpenatan.jParser:loader-core:${LibExt.jParserVersion}")
    implementation(project(":imgui:imgui-core"))
    implementation(project(":extensions:imlayout:imlayout-core"))
    implementation(project(":extensions:ImGuiColorTextEdit:textedit-core"))
    implementation(project(":extensions:imgui-node-editor:nodeeditor-core"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

java {
    withJavadocJar()
    withSourcesJar()
}

tasks.jar {
    archiveBaseName.set(moduleName)
    archiveClassifier.set("")

    dependsOn(tasks.named("classes")) // This project’s classes
    dependsOn(configurations["implementation"].dependencies.mapNotNull { dep ->
        if (dep is ProjectDependency) {
            dep.dependencyProject.tasks.findByName("classes")
        } else {
            null
        }
    })

    from(sourceSets.main.get().output)

    from({
        configurations["implementation"].dependencies
            .filterIsInstance<ProjectDependency>()
            .mapNotNull { dep ->
                val output = dep.dependencyProject.sourceSets.main.get().output
                output.takeIf { it.files.any { file -> file.exists() } }
            }
    })

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = moduleName
            from(components["java"])
            pom {
                withXml {
                    val rootNode = asNode()
                    // Find or create the <dependencies> node
                    val dependenciesNode = rootNode["dependencies"]?.let { it as groovy.util.NodeList }?.get(0) as groovy.util.Node?
                        ?: rootNode.appendNode("dependencies")

                    // Remove all existing <dependency> children safely
                    val childrenToRemove = dependenciesNode.children().toList()
                    childrenToRemove.forEach { child ->
                        dependenciesNode.remove(child as groovy.util.Node)
                    }

                    // Add only the api configuration dependencies
                    configurations["api"].dependencies.forEach { dep ->
                        val dependencyNode = dependenciesNode.appendNode("dependency")
                        dependencyNode.appendNode("groupId", dep.group)
                        dependencyNode.appendNode("artifactId", dep.name)
                        dependencyNode.appendNode("version", dep.version)
                        dependencyNode.appendNode("scope", "compile")
                    }
                }
            }
        }
    }
}