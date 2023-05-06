plugins {
}

extra["springCloudVersion"] = "2022.0.2"
extra["springBootVersion"] = "3.0.6"
extra["lombokVersion"] = "1.18.26"

allprojects {

    group = "net.prasenjit.poc"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:3.0.6")
    }
}