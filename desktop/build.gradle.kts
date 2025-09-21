apply(plugin = "java")

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configure<SourceSetContainer> {
    named("main") {
        java.srcDir("src/main/java/")
    }
    named("test") {
        java.srcDir("src/test/java/")
    }
}