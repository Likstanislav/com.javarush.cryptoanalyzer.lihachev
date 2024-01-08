import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileNameValidation {
    private static final List<String> FORBIDDEN_PATH_FILES =
            List.of("Windows");

    public void validateForReading(String fileName) {
        Path path = validatePath(fileName);
        if (Files.notExists(path)) {
            throw new RuntimeException("File doesn't exits");
        }
        if (Files.isDirectory(path)) {
            throw new RuntimeException("File is directory");
        }
        if (!Files.isReadable(path)) {
            throw new RuntimeException("You don't have right to read from the file");
        }
    }
    public void validateForWriting(String fileName) {
        Path path = validatePath(fileName);
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {
                throw new RuntimeException("File is directory");
            }
            if (!Files.isWritable(path)) {
                throw new RuntimeException("File " + path + " is not accessible for writing");
            }
        }
    }

    private Path validatePath(String fileName) {
        for (String pathPart : fileName.split("\\\\")) {
            if (FORBIDDEN_PATH_FILES.contains(pathPart)) {
                throw new RuntimeException("Path contains forbidden part: " + pathPart);
            }
        }
        try {
            Path path = Path.of(fileName);
            return path;
        } catch (RuntimeException ex) {
            throw new RuntimeException("Invalid path reason: " + ex.getMessage());
        }
    }

}
