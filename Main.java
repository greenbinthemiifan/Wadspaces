package dev.wadspaces;

import java.util.Locale;

public final class Main {
    private static final String VERSION = "0.1.0-beta";
    private static final String NAME = "wdsp";

    private Main() {
        // Prevent instantiation.
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            printHelp();
            return;
        }

        switch (args[0].toLowerCase(Locale.ROOT)) {
            case "--help", "-h", "help" -> printHelp();
            case "--version", "-v", "version" -> System.out.println(VERSION);
            case "build" -> runBuild(args);
            default -> {
                System.err.println("Unknown command or option: " + args[0]);
                System.err.println("Run 'wdsp --help' for usage.");
                System.exit(1);
            }
        }
    }

    private static void runBuild(String[] args) {
        String title = null;
        String output = null;

        for (int i = 1; i < args.length; i++) {
            switch (args[i]) {
                case "--title" -> title = readOptionValue(args, ++i, "--title");
                case "--output" -> output = readOptionValue(args, ++i, "--output");
                case "--help", "-h" -> {
                    printBuildHelp();
                    return;
                }
                default -> {
                    System.err.println("Unknown build option: " + args[i]);
                    System.err.println("Run 'wdsp build --help' for usage.");
                    System.exit(1);
                }
            }
        }

        if (title == null || title.isBlank()) {
            System.err.println("Missing required option: --title");
            System.exit(1);
        }

        if (output == null || output.isBlank()) {
            System.err.println("Missing required option: --output");
            System.exit(1);
        }

        if (!output.toLowerCase(Locale.ROOT).endsWith(".wad")) {
            System.err.println("Invalid output: --output must end in .wad");
            System.exit(1);
        }

        if (output.toLowerCase(Locale.ROOT).endsWith(".wad.wad")) {
            System.err.println("Invalid output: nested WAD names are not supported");
            System.exit(1);
        }

        System.out.println("WadSpaces " + VERSION);
        System.out.println("Forwarder title: " + title);
        System.out.println("Output: " + output);
        System.out.println("Building is not implemented yet.");
    }

    private static String readOptionValue(String[] args, int index, String option) {
        if (index >= args.length) {
            System.err.println("Missing value for " + option);
            System.exit(1);
        }

        return args[index];
    }

    private static void printHelp() {
        System.out.println("""
                WadSpaces %s

                Usage:
                  wdsp <command> [options]

                Commands:
                  build       Build a forwarder WAD
                  help        Show this help message
                  version     Show the WadSpaces version

                Options:
                  -h, --help      Show help
                  -v, --version   Show the version

                Forwarder-only: WadSpaces does not create or install nested WAD files.
                """.formatted(VERSION));
    }

    private static void printBuildHelp() {
        System.out.println("""
                Usage:
                  wdsp build --title "My Forwarder" --output my-forwarder.wad

                Required options:
                  --title <name>    Forwarder title
                  --output <file>   Output file ending in .wad
                """);
    }
}
