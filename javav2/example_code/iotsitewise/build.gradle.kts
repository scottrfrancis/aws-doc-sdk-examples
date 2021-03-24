plugins {
    kotlin("jvm") version "1.4.31"
    id("application")
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))

repositories {
    mavenCentral()
}

application.mainClass.set("com.example.iotsitewise.ListAssets")

dependencies {
    implementation("software.amazon.awssdk:iotsitewise:2.16.20")
}
