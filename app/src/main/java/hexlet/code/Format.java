package hexlet.code;

import hexlet.code.Formatter.Json;
import hexlet.code.Formatter.Plain;
import hexlet.code.Formatter.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Format {
    public static String format(List<Map<String, Object>> map, String format) throws IOException {

        String str = " ";

        switch (format.toLowerCase()) {
            case "stylish":
                str = Stylish.stylishFormate(map);
                break;
            case "plain":
                str = Plain.plainFormate(map);
                break;
            case "json":
                str = Json.jsonFormate(map);
                break;
            default:
                throw new IOException("no such format");
        }

        return str;
    }
}
