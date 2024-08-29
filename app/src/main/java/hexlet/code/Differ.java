package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws IOException {

        Map<String, Object> map1 = getMapFromFile(filepath1);
        Map<String, Object> map2 = getMapFromFile(filepath2);

        List<Map<String, Object>> differenceMap = Difference.getDifference(map1, map2);

        return Format.format(differenceMap, format);
    }

    public static String generate(String filepath1, String filepath2) throws IOException {

        String format = "stylish";

        return generate(filepath1, filepath2, format.toLowerCase());
    }

    public static Map<String, Object> getMapFromFile(String filepath) throws IOException {

        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        String stringPath = Files.readString(path);
        String format = getFormat(filepath);

        return Parser.parse(stringPath, format);

    }

    public static String getFormat(String filepath) throws IOException {
        String result = "";

        if (filepath.endsWith("json")) {
            result = "json";
        }

        if (filepath.endsWith("yml") || filepath.endsWith("yaml")) {
            result = "yml";
        }
        return result;
    }
}



