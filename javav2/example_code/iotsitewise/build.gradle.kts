plugins {
    kotlin("jvm") version "1.4.31"
    id("application")
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
    maven(url = "https://repo.gradle.org/gradle/libs-releases-local/")
}

application.mainClass.set("com.example.iotsitewise.ListAssets")

dependencies {
    implementation("software.amazon.awssdk:iotsitewise:2.16.20")
    // For automatic pagination
    implementation("com.github.awslabs:results-iterator-for-aws-java-sdk:18.0.1")
    // For fancy streams
    implementation("io.vavr:vavr:0.10.3")
}

