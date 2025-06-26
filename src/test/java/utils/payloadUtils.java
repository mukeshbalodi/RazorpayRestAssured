package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class payloadUtils {

    public static String loadPayload(String relativePath) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/resources/" + relativePath)));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load payload from " + relativePath, e);
        }
    }
}
