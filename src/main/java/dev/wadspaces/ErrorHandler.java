package dev.wadspaces;

/**
 * Prints consistently formatted error messages for the WadSpaces CLI.
 */
public final class ErrorHandler {
    private ErrorHandler() {
        // Prevent instantiation.
    }

    /**
     * Prints an error and a helpful tip to standard error.
     *
     * @param message the error message, without the "Error:" prefix
     * @param tip the suggested action, without the "Tip:" prefix
     */
    public static void printError(String message, String tip) {
        System.err.println("Error: " + message);
        System.err.println("Tip: " + tip);
    }
}
