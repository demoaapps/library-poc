import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    `java-platform`
    id("org.springframework.boot") apply false
}

//dependencyManagement {
//    imports {
//        mavenBom(SpringBootPlugin.BOM_COORDINATES)
//    }
//}

dependencies {
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
