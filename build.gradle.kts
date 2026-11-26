plugins {
    application
}

group = "dev.wadspaces"
version = "0.1.0-beta"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

// Main.java is currently at the repository root. Once it is moved to
// src/main/java/dev/wadspaces/Main.java, this can use Gradle's default source path.
sourceSets {
    main {
        java {
            setSrcDirs(listOf("."))
            include("Main.java")
        }
    }
}

application {
    mainClass.set("dev.wadspaces.Main")
}
