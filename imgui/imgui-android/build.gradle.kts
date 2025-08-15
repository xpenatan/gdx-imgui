plugins {
    id("com.android.library")
    kotlin("android")
}

val moduleName = "imgui-android"

android {
    namespace = "imgui"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
    }

    sourceSets {
        named("main") {
            jniLibs.srcDirs("$projectDir/../imgui-build/build/c++/libs/android")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(LibExt.java11Target)
        targetCompatibility = JavaVersion.toVersion(LibExt.java11Target)
    }
    kotlinOptions {
        jvmTarget = LibExt.java11Target
    }
}

dependencies {
}

// TODO Uncomment when android is ready
//publishing {
//    publications {
//        create<MavenPublication>("maven") {
//            artifactId = moduleName
//            afterEvaluate {
//                from(components["release"])
//            }
//        }
//    }
//}