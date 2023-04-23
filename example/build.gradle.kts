import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    java
    application
    id("io.spring.dependency-management")
    id("org.springframework.boot")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    implementation(project(":core"))
    implementation(project(":billing"))

    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

configurations.all {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
}
