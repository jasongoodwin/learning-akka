package akkademy;

import com.jasongoodwin.monads.Try;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArticleProvider {
    static Try<String> readArticleFromFile(String path) {
        return Try.ofFailable(() -> {
            //eagerly reads file into memory
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, StandardCharsets.UTF_8);
        });
    }
}
