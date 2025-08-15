plugins {
    id("java")
}

java {
    sourceCompatibility = JavaVersion.toVersion(LibExt.java8Target)
    targetCompatibility = JavaVersion.toVersion(LibExt.java8Target)
}

dependencies {
    implementation(project(":imgui:imgui-teavm"))
    implementation("com.github.xpenatan.jParser:loader-core:${LibExt.jParserVersion}")
}