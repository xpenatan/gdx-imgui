plugins {
    id("com.android.library")
    kotlin("android")
}

val moduleName = "imgui-android"

android {
    namespace = "imgui"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
    }

    sourceSets {
        named("main") {
            jniLibs.srcDirs("$projectDir/../imgui-build/build/c++/libs/android")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = moduleName
            afterEvaluate {
                from(components["release"])
            }
        }
    }
}