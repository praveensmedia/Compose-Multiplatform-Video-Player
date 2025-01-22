plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization")
}

group = "in.xpertxyz.upcomingtrains"
version = "1.0.1"

fun composeDependency(groupWithArtifact: String) = "$groupWithArtifact:${libs.versions.compose}"

kotlin {

    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                implementation(libs.koin.core)
                implementation(libs.ktor.json)
                implementation(libs.ktor.client.logging)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.contentnegotiation)
                implementation(libs.ktor.serialization.json)
                implementation(libs.kotlin.serialization)
                implementation(libs.material.icon.extended)
                api(libs.image.loader)
                implementation(libs.compose.util)


            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
                implementation(libs.koin.core)
                implementation(libs.ktor.java)
                implementation(libs.koin.compose)
                implementation("uk.co.caprica:vlcj:4.7.0")

            }
        }
    }
}