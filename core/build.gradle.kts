apply(plugin = "java")

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configure<SourceSetContainer> {
    named("main") {
        java.srcDir("src/main/java/")
        resources.srcDir("src/main/resources")
    }
    named("test") {
        java.srcDir("src/test/java/")
    }
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
    compileTestJava {
        options.encoding = "UTF-8"
    }
}