package hexlet.code;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Stylish {

    public static String stylishFormate(List<Map<String, Object>> mapes) throws IOException {

        StringBuilder sb = new StringBuilder();
        for (Map<String, Object> map : mapes) {
            if (map.get("type").equals("added")) {
                sb.append("+" + map.get("key") + ":" + map.get("value2") + "\n");
            }
            if (map.get("type").equals("deleted")) {
                sb.append("-" + map.get("key") + ":" + map.get("value1") + "\n");
            }
            if (map.get("type").equals("changed")) {
                sb.append("-" + map.get("key") + ":" + map.get("value1") + "\n");
                sb.append("+" + map.get("key") + ":" + map.get("value2") + "\n");
            }
            if (map.get("type").equals("unchanged")) {
                sb.append(" " + map.get("key") + ":" + map.get("value1") + "\n");
            }
        }

        String showDifference = sb.toString();
        return showDifference;
    }

}

