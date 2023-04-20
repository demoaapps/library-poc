plugins {
}

allprojects {

    group = "net.prasenjit.poc"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "maven-publish")
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:3.0.5")
        classpath("io.spring.gradle:dependency-management-plugin:1.1.0")
    }
}