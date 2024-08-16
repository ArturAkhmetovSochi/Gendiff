package hexlet.code;

import java.io.IOException;
import java.util.*;

public class Difference {
    public static List<Map<String, Object>> getDifference(Map<String, Object> map1, Map<String,
            Object> map2) throws IOException {
    Set<String> keySet = new TreeSet<>(map1.keySet());
        keySet.addAll(map2.keySet());

        List<Map<String, Object>> result = new ArrayList<>();

        for (String key : keySet) {
            Map<String, Object> differenceMap = makeDifferenceMap(map1, map2, key);
            result.add(differenceMap);
        }

        return result;
    }

    public static Map<String,Object> makeDifferenceMap(Map<String, Object> map1, Map<String,
            Object> map2, String key) throws IOException {

        Object value1 = map1.get(key);
        Object value2 = map2.get(key);

        Map<String, Object> map = new HashMap<>();
        map.put("key", key);

        if (!map2.containsKey(key)) {
            map.put("type", "deleted");
            map.put("value", value1);
        } else if (!map1.containsKey(key)) {
            map.put("type", "added");
            map.put("value", value2);
        } else if (map1.get(key) == map2.get(key))  {
            map.put("type", "unchanged");
            map.put("value", value1);
        } else {
            map.put("type", "changed");
            map.put("value1", value1);
            map.put("value2", value2);
        }

        return map;

    }
}
