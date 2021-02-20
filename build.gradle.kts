import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.30"
    id("org.jlleitschuh.gradle.ktlint") version "10.0.0"
    id("idea")
    application
}

group = "me.dnfetheus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val log4jVersion = "2.14.0"

    implementation(kotlin("reflect"))
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")

    implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion")
    implementation("io.github.microutils:kotlin-logging:2.0.4")
}

tasks {
    test {
        useJUnitPlatform()
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }

    // TODO: Pre-commit
}

application {
    mainClassName = "MainKt"
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
