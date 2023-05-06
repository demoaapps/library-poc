plugins {
    java
    application
    `maven-publish`
    id("org.springframework.boot")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    implementation(platform(project(":bom")))
    implementation("org.springframework.boot:spring-boot-starter-log4j2")
//    implementation("org.springframework.cloud:spring-cloud-starter-vault-config")

    implementation(project(":core"))
    implementation(project(":billing"))

    compileOnly("org.projectlombok:lombok:${property("lombokVersion")}")
    developmentOnly("org.springframework.boot:spring-boot-devtools:${property("springBootVersion")}")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:${property("springBootVersion")}")
    annotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

configurations.all {
    exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifact(tasks.named("bootJar"))
        }
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
