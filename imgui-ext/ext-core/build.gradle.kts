plugins {
    id("java-library")
}

val moduleName = "imgui-ext-core"

dependencies {
    api(project(":imgui:imgui-core"))
    api(project(":extensions:imlayout:imlayout-core"))
//    api(project(":extensions:ImGuiColorTextEdit:textedit-core"))
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
