plugins {
    id("java")
}

dependencies {
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")

    implementation(project(":imgui:imgui-core"))

    // Use JUnit test framework
    testImplementation("junit:junit:${LibExt.jUnitVersion}")
}

java {
    sourceCompatibility = JavaVersion.toVersion(LibExt.java8Target)
    targetCompatibility = JavaVersion.toVersion(LibExt.java8Target)
}

java {
    withJavadocJar()
    withSourcesJar()
}