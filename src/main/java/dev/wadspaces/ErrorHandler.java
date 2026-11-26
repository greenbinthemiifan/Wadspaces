package dev.wadspaces;

/**
 * Prints consistently formatted error messages for the WadSpaces CLI.
 */
public final class ErrorHandler {
    private ErrorHandler() {
        // Prevent instantiation.
    }

    /**
     * Prints a predefined error and its helpful tip to standard error.
     *
     * @param error the error category to report
     */
    public static void printError(ErrorType error) {
        if (error == null) {
            printError("An unknown error occurred.", "Try again. If the problem continues, report the error details.");
            return;
        }

        printError(error.message, error.tip);
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

    /** Predefined error categories and their user-facing messages. */
    public enum ErrorType {
        CONNECTION(
                "Connection failed.",
                "Check your internet connection and try again."),
        UNKNOWN(
                "An unexpected error occurred.",
                "Try again. If the problem continues, report the error details."),
        MEMORY(
                "Not enough memory to complete the operation.",
                "Close other applications and try again."),
        PARSING(
                "Could not parse the configuration file.",
                "Check details.wadspaces for valid key=\"value\" entries."),
        INVALID_WAD_DATA(
                "The WAD data is invalid or unreadable.",
                "Verify that the input file is a valid WAD and try again.");

        private final String message;
        private final String tip;

        ErrorType(String message, String tip) {
            this.message = message;
            this.tip = tip;
        }
    }
}
