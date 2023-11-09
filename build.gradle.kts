import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform") version "1.9.20"
    id("org.jetbrains.compose") version "1.5.10"
    `maven-publish`
    signing
    id("com.vanniktech.maven.publish") version "0.25.3"
    id("com.android.library") version "8.1.3"
}

val libName = "shapeofcomposable"
val libArtifact = "dev.datlag.$libName"
val libVersion = "1.0.2"

group = libArtifact
version = libVersion

repositories {
    google()
    mavenCentral()
}

kotlin {
    androidTarget()
    macosX64()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    jvm()
    js(IR) {
        browser()
        binaries.executable()
    }

    applyDefaultHierarchyTemplate()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
            }
        }
    }
}

android {
    compileSdk = 34
    namespace = libArtifact
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        minSdk = 21

        aarMetadata {
            minCompileSdk = 21
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        sourceCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
}

mavenPublishing {
    publishToMavenCentral(host = SonatypeHost.S01, automaticRelease = true)
    signAllPublications()

    coordinates(
        groupId = "dev.datlag",
        artifactId = libName,
        version = libVersion
    )

    pom {
        name.set(libName)
        description.set("ShapeOfComposable is a multi-platform compose library to clip any composeable to a custom shape.")
        url.set("https://github.com/DatL4g/ShapeOfComposable")

        licenses {
            license {
                name.set("Apache License 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        scm {
            url.set("https://github.com/DatL4g/ShapeOfComposable")
            connection.set("scm:git:git://github.com/DatL4g/ShapeOfComposable.git")
        }

        developers {
            developer {
                id.set("DatL4g")
                name.set("Jeff Retz (DatLag)")
                url.set("https://github.com/DatL4g")
            }
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
}
