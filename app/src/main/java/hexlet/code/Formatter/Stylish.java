package hexlet.code.Formatter;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Stylish {

    public static String stylishFormate(List<Map<String, Object>> mapes) throws IOException {

        String space = " ".repeat(2);

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        for (Map<String, Object> map : mapes) {
            if (map.get("type").equals("added")) {
                sb.append(space + "+ " + map.get("key") + ": " + map.get("value") + "\n");
            } else if (map.get("type").equals("deleted")) {
                sb.append(space + "- " + map.get("key") + ": " + map.get("value") + "\n");
            } else if (map.get("type").equals("changed")) {
                sb.append(space + "- " + map.get("key") + ": " + map.get("value1") + "\n");
                sb.append(space + "+ " + map.get("key") + ": " + map.get("value2") + "\n");
            } else if (map.get("type").equals("unchanged")) {
                sb.append(space + "  " + map.get("key") + ": " + map.get("value") + "\n");
            }
        }

        sb.append("}");
        String showDifference = sb.toString();

        return showDifference;
    }

}

