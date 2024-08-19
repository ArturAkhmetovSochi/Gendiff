package hexlet.code.Formatter;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String valueCheck(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        }

        return value.toString();
    }

    public static String plainFormate(List<Map<String, Object>> mapes) {

        StringBuilder sb = new StringBuilder();

        for (Map<String, Object> map : mapes) {
            if (map.get("type").equals("added")) {
                sb.append("Property '" + map.get("key") + "' was added with value: "
                        + valueCheck(map.get("value")) + "\n");
            } else if (map.get("type").equals("deleted")) {
                sb.append("Property '" + map.get("key") + "' was removed" + "\n");
            } else if (map.get("type").equals("changed")) {
                sb.append("Property '" + map.get("key") + "' was updated. From "
                        + valueCheck(map.get("value1")) + " to " + valueCheck(map.get("value2")) + "\n");
            }
        }

        String showDifference = sb.toString();

        return showDifference;
    }

}

