package hexlet.code;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Format {
    public static String format(List<Map<String, Object>> map, String format) throws IOException {

        String str = "";

        switch (format.toLowerCase()) {
            case "stylish":
                str = Stylish.stylishFormate(map);
            default:
        }

        return str;
    }
}
