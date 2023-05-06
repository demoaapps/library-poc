plugins {
    `java-library`
    `maven-publish`
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    api(platform(project(":bom")))
    api(project(":core"))

    compileOnly("org.projectlombok:lombok:${property("lombokVersion")}")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:${property("springBootVersion")}")
    annotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
