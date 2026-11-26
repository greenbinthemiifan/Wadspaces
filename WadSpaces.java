import java.nio.file.Files;
import java.nio.file.Path;

public class WadSpaces {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java WadSpaces <build-directory>");
            return;
        }

        Path buildDir = Path.of(args[0]);

        if (!Files.isDirectory(buildDir)) {
            throw new IllegalArgumentException(
                "Build directory does not exist: " + buildDir
            );
        }

        try (var files = Files.walk(buildDir)) {
            long count = files.filter(Files::isRegularFile).count();
            System.out.println("Found " + count + " file(s) in " + buildDir);
        } catch (Exception exception) {
            throw new RuntimeException("Could not inspect build directory", exception);
        }
    }
}
