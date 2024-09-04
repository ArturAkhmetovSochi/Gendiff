package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String file, String format) throws IOException {

        return switch (format) {
            case "yml" -> getYaml(file);
            case "json" -> getJson(file);
            default -> throw new IOException("Inccorect format type");
        };
    }

    public static Map<String, Object> getYaml(String file) throws IOException {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(file, new TypeReference<>() { });
    }

    public static Map<String, Object> getJson(String file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, new TypeReference<>() { });
    }
}
