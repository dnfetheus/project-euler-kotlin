import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.30"
    // FIXME: Incompatible with Gradle 6.8.3
//    id("org.jlleitschuh.gradle.ktlint") version "10.0.0"
    id("idea")
    jacoco
    application
}

group = "me.dnfetheus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val log4jVersion = "2.14.0"
    val kotestVersion = "4.4.1"

    implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion")
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("io.github.microutils:kotlin-logging:2.0.4")

    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.kotest:kotest-property:$kotestVersion")
    testImplementation("io.mockk:mockk:1.10.6")

    implementation(kotlin("reflect"))
}

tasks {
    // TODO: Pre-commit hook
//    build {
//        finalizedBy(addKtlintFormatGitPreCommitHook)
//    }

    test {
        useJUnitPlatform()
        finalizedBy(jacocoTestReport)
    }

    jacocoTestReport {
        dependsOn(test)
        reports {
            html.isEnabled = true
            xml.isEnabled = true
            csv.isEnabled = false
        }
    }

    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
            useIR = true
            freeCompilerArgs = freeCompilerArgs + "-Xallow-result-return-type"
        }
    }
}

application {
    mainClass.set("MainKt")
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}
