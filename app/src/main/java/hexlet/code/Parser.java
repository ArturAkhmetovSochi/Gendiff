package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static ObjectMapper getMapperFromFile(String filepath) throws IOException {

        ObjectMapper result = null;

        if (filepath.endsWith("json")) {
            result = new ObjectMapper();

        }
        if (filepath.endsWith("yml") || filepath.endsWith("yaml")) {
            result = new YAMLMapper();

        }

        return result;
    }

    public static Map<String, Object> getMapFromFile(String filepath) throws IOException {

        Path path = Paths.get("src/main/java/hexlet/code/" + filepath).toAbsolutePath().normalize();
        String stringPath = Files.readString(path);

        ObjectMapper mapper = getMapperFromFile(filepath);
        return mapper.readValue(stringPath, new TypeReference<>() { });
    }
}
