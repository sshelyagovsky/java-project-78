import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    checkstyle
    jacoco
    id("com.adarshr.test-logger") version "3.1.0"
    id("se.patrikerdes.use-latest-versions") version "0.2.18"
    id("com.github.ben-manes.versions") version "0.42.0"
    id("io.freefair.lombok") version "6.4.1"
    id("net.ltgt.errorprone") version "2.0.2"
}

application {
    mainClass = "hexlet.code"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.compileJava {
    options.release = 21
}


dependencies {
    implementation("org.apache.commons:commons-lang3:3.12.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.slf4j:slf4j-log4j12:2.0.0-alpha6")
    testImplementation("org.assertj:assertj-core:3.22.0")
    implementation("com.google.errorprone:error_prone_core:2.11.0")
}



tasks.test {
    useJUnitPlatform()
}

tasks.test {
    useJUnitPlatform()
    // https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }