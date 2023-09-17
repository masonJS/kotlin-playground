version = "0.0.0-beta.1"

plugins {
    alias(libs.plugins.kotiln.jvm)
    alias(libs.plugins.kotlinter)

    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.kotest)
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.jar {
    manifest {
        attributes(
            mapOf(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version,
            ),
        )
    }
}
