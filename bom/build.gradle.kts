import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    `java-platform`
    `maven-publish`
    id("org.springframework.boot") apply false
}

dependencies {
    api(platform(SpringBootPlugin.BOM_COORDINATES))
    api(platform("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}"))
    constraints {
        api(project(":core"))
        api(project(":billing"))
    }
}

javaPlatform {
    allowDependencies()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["javaPlatform"])
        }
    }
}
