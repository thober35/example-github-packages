import java.util.*
import java.io.FileInputStream

plugins {
    id("com.android.library")
    id("com.vanniktech.maven.publish")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        minSdkVersion(27)
        targetSdkVersion(30)

        versionName = "1"
        versionCode = 1
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk7", org.jetbrains.kotlin.config.KotlinCompilerVersion.VERSION))
}

val githubProperties = Properties()
githubProperties.load(FileInputStream(rootProject.file("github.properties")))
publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            credentials {
                username = githubProperties.get("gpr.usr") as String? ?: System.getenv("GPR_USER")
                password = githubProperties.get("gpr.key") as String? ?: System.getenv("GPR_API_KEY")

            }
            url = uri(githubProperties.get("gpr.url") as String? ?: System.getenv("GPR_URL"))
        }
    }
}
