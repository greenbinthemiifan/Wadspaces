# Wadspaces

Wadspaces is a Java 21 command-line tool for building Wadspaces projects.

**Version:** `0.1.0-beta`

## Requirements

- Java 21 or newer
- Gradle (or the Gradle wrapper, if present)

## Build

Build the project with Gradle:

```bash
./gradlew build
```

If the wrapper is unavailable, use your installed Gradle version:

```bash
gradle build
```

## Usage

Run the application:

```bash
./gradlew run
```

### Command-line options

```text
--help       Show command-line help
--version    Print the Wadspaces version
```

### Build a project

```bash
java -jar build/libs/Wadspaces.jar build --title "My Project" --output dist
```

- `build` starts the build command.
- `--title` sets the project title.
- `--output` sets the output directory.

## Source layout

```text
src/main/java/dev/wadspaces/Main.java
build.gradle
settings.gradle
```

## Development

Compile and run the application:

```bash
./gradlew run
```

Run the test suite:

```bash
./gradlew test
```
