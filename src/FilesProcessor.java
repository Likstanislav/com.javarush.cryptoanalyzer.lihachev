import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FilesProcessor {
    private static final StandardOpenOption[] FILE_WRITE_OPTIONS =
            {StandardOpenOption.CREATE, StandardOpenOption.APPEND};

    public List<String> readFile(String fileName) {
        try {
            Path filePath = Path.of(fileName);
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void appendToFile(String fileName, String content) {
        try {
            Path filePath = Path.of(fileName);
            Files.writeString(filePath, content, FILE_WRITE_OPTIONS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
