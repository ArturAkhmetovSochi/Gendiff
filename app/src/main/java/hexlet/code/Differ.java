package hexlet.code;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws IOException {

        Map<String, Object> map1 = Parser.getMapFromFile(filepath1);
        Map<String, Object> map2 = Parser.getMapFromFile(filepath2);

        List<Map<String, Object>> differenceMap = Difference.getDifference(map1, map2);

        return Format.format(differenceMap, format);
    }

    public static String generate(String filepath1, String filepath2) throws IOException {

        String format = "stylish";

        return generate(filepath1, filepath2, format.toLowerCase());
    }

}



