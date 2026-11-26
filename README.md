# WadSpaces

WadSpaces is a Java command-line project intended to make Wii WAD creation possible from GitHub Codespaces. The goal is to make the workflow easy to use in a browser-based development environment.

> **Early development:** Version `0.1.0-beta` is a work in progress. Actual WAD generation is not implemented yet. The current `build` command accepts a forwarder title and `.wad` output path, then reports that building is not implemented. It does not create or install WAD files.

## Requirements

- Java 21
- Gradle

You can use a GitHub Codespace or another environment with Java 21 and Gradle installed.

## Build and run

Build the project:

```bash
gradle build
```

Show the CLI help:

```bash
gradle run --args="--help"
```

Print the version:

```bash
gradle run --args="--version"
```

## CLI

The planned build command currently takes a forwarder title and an output path ending in `.wad`:

```bash
gradle run --args='build --title "My Forwarder" --output my-forwarder.wad'
```

At this stage, the command only validates the arguments and prints a status message; it does not produce a WAD.

## Development

The application entry point is `src/main/java/dev/wadspaces/Main.java`. The project uses Gradle's Kotlin DSL (`build.gradle.kts` and `settings.gradle.kts`) and targets Java 21.
