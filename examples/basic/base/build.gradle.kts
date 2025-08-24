plugins {
    id("java")
}

java {
    sourceCompatibility = JavaVersion.toVersion(LibExt.java8Target)
    targetCompatibility = JavaVersion.toVersion(LibExt.java8Target)
}

dependencies {
    implementation("com.badlogicgames.gdx:gdx:${LibExt.gdxVersion}")

    if(LibExt.useRepoLibs) {
        implementation("com.github.xpenatan.xImGui:imgui-core:-SNAPSHOT")
    }
    else {
        implementation(project(":imgui:imgui-core"))
    }
}
