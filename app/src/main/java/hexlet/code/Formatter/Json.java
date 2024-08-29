package hexlet.code.Formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Json {
    public static String jsonFormate(List<Map<String, Object>> mapes) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapes);
    }
}
