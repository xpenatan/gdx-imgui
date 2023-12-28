plugins {
    id("java-library")
}

val moduleName = "core-ext"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    api(project(":imgui:imgui-core"))
    api(project(":extensions:imlayout:imlayout-core"))
//    api(project(":extensions:ImGuiColorTextEdit:textedit-core"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = moduleName
            from(components["java"])
        }
    }
}
