import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TestDataReader {
    public static List<String> getProductList(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}
