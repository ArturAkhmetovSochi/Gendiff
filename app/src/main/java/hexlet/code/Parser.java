package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String filepath, String format) throws IOException {

        return switch (format) {
            case "yml" -> getYaml(filepath);
            case "json" -> getJson(filepath);
            default -> throw new IOException("Inccorect format type");
        };
    }

    public static Map<String, Object> getYaml(String filepath) throws IOException {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(filepath, new TypeReference<>() { });
    }

    public static Map<String, Object> getJson(String filepath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(filepath, new TypeReference<>() { });
    }
}
