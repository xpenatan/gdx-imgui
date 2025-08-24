plugins {
    id("java-library")
}

val moduleName = "gdx-wgpu-impl"

dependencies {
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")
    api(project(":gdx:gdx-shared-impl"))
    implementation(project(":imgui:imgui-core"))
    implementation("io.github.monstroussoftware.gdx-webgpu:gdx-webgpu:${LibExt.gdxWebGPUVersion}")
}

java {
    sourceCompatibility = JavaVersion.toVersion(LibExt.java8Target)
    targetCompatibility = JavaVersion.toVersion(LibExt.java8Target)
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