plugins {
}

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
        classpath("io.spring.gradle:dependency-management-plugin:1.1.0")
    }
}