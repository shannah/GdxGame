plugins {
    application
}

apply(plugin = "java")

application {
    mainClass.set("com.gdx.game.desktop.DesktopLauncher")
}

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

tasks.register<Copy>("copyDependencies") {
    from(configurations.runtimeClasspath)
    into(layout.buildDirectory.dir("libs/lib"))
}

tasks.named<Jar>("jar") {
    dependsOn("copyDependencies")
    manifest {
        attributes(
            "Main-Class" to application.mainClass.get(),
            "Class-Path" to configurations.runtimeClasspath.get().map { "lib/" + it.name }.joinToString(" ")
        )
    }
}

tasks.register("buildExecutableJar") {
    dependsOn("jar")
    doLast {
        println("Built executable JAR: desktop/build/libs/desktop-2.6.1.jar")
    }
}