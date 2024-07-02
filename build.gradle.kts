plugins {
    id("java")
    id("maven-publish")
    id("signing")
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false
}

buildscript {
    repositories {
        mavenCentral()
        google()
    }

    val kotlinVersion = "1.8.10"

    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects  {

    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/releases/") }
    }

    configurations.configureEach {
        // Check for updates every sync
        resolutionStrategy.cacheChangingModulesFor(0, "seconds")
    }
}

configure(allprojects - project(":imgui:imgui-android") - project(":examples:basic:android")) {
    apply {
        plugin("java")
    }
    java.sourceCompatibility = JavaVersion.VERSION_11
    java.targetCompatibility = JavaVersion.VERSION_11
}

var libProjects = mutableSetOf(
    project(":imgui:imgui-core"),
    project(":imgui:imgui-desktop"),
    project(":imgui:imgui-teavm"),
    project(":imgui:imgui-android"),
    project(":gdx:gdx-impl"),
//        project(":gdx:lwjgl3-impl"),
)

var libProjects2 = mutableSetOf(
    project(":imgui-ext:ext-core"),
    project(":imgui-ext:ext-desktop"),
    project(":imgui-ext:ext-teavm")
)

configure(libProjects) {
    apply(plugin = "maven-publish")
    group = LibExt.groupId
    version = LibExt.libVersion
}

configure(libProjects2) {
    apply(plugin = "maven-publish")
    group = LibExt.groupId
    version = LibExt.libVersion
}

configure(libProjects + libProjects2) {
    apply(plugin = "signing")
    apply(plugin = "maven-publish")

    publishing {
        repositories {
            maven {
                url = uri {
                    val ver = project.version.toString()
                    val isSnapshot = ver.uppercase().contains("SNAPSHOT")
                    val repoUrl = "https://oss.sonatype.org/service/local/staging/deploy/maven2/"
                    val repoUrlSnapshot = "https://oss.sonatype.org/content/repositories/snapshots/"
                    if (isSnapshot) repoUrlSnapshot else repoUrl
                }
                credentials {
                    username = System.getenv("USER")
                    password = System.getenv("PASSWORD")
                }
            }
        }
    }

    tasks.withType<Javadoc> {
        options.encoding = "UTF-8"
        (options as StandardJavadocDocletOptions).addStringOption("Xdoclint:none", "-quiet")
    }

    publishing.publications.configureEach {
        if (this is MavenPublication) {
            pom {
                name.set("gdx-imgui")
                description.set("Java JNI based binding for imgui")
                url.set("https://github.com/xpenatan/gdx-imgui")
                developers {
                    developer {
                        id.set("Xpe")
                        name.set("Natan")
                    }
                }
                scm {
                    connection.set("scm:git:git://https://github.com/xpenatan/gdx-imgui.git")
                    developerConnection.set("scm:git:ssh://https://github.com/xpenatan/gdx-imgui.git")
                    url.set("http://https://github.com/xpenatan/gdx-imgui/tree/master")
                }
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
            }
        }
    }

    val signingKey = System.getenv("SIGNING_KEY")
    val signingPassword = System.getenv("SIGNING_PASSWORD")
    if (signingKey != null && signingPassword != null) {
        signing {
            useInMemoryPgpKeys(signingKey, signingPassword)
            publishing.publications.configureEach {
                sign(this)
            }
        }
    }
}

tasks.register("download_all_sources") {
    group = "imgui"
    description = "Download all sources"

    val source1 = ":imgui:imgui-build:download_source"
    val source2 = ":extensions:ImGuiColorTextEdit:textedit-build:download_source"
    val source3 = ":extensions:imgui-node-editor:nodeeditor-build:download_source"

    val list = listOf(source1, source2, source3)
    dependsOn(list)

    tasks.findByPath(source2)!!.mustRunAfter(source1)
    tasks.findByPath(source3)!!.mustRunAfter(source2)
}

tasks.register("build_all_projects") {
    group = "imgui"
    description = "build all sources"

    val imguiSrc = ":imgui:imgui-build:build_project_all"
    val source2 = ":extensions:ImGuiColorTextEdit:textedit-build:build_project_all"
    val source3 = ":extensions:imgui-node-editor:nodeeditor-build:build_project_all"
    val source4 = ":extensions:imlayout:imlayout-build:build_project_all"
    val extSrc = ":imgui-ext:ext-build:build_project_all"

    val list = listOf(imguiSrc, source2, source3, source4, extSrc)
    dependsOn(list)

    tasks.findByPath(source2)!!.mustRunAfter(imguiSrc)
    tasks.findByPath(source3)!!.mustRunAfter(source2)
    tasks.findByPath(source4)!!.mustRunAfter(source3)
    tasks.findByPath(extSrc)!!.mustRunAfter(imguiSrc, source2, source3, source4)
}