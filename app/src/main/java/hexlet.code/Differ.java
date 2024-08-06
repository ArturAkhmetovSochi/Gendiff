package hexlet.code;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;


public class Differ {

    private Boolean follow;
    private String host;
    private String proxy;
    private Integer timeout;
    private Boolean verbose;


    public Boolean getFollow() {
        return follow;
    }

    public void setFollow(Boolean follow) {
        this.follow = follow;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Boolean getVerbose() {
        return verbose;
    }

    public void setVerbose(Boolean verbose) {
        this.verbose = verbose;
    }

    public static Map<String, Object> makeMapFromPath(String filepath) throws IOException {

        Path path = Paths.get(filepath).toAbsolutePath().normalize();
        String stringPath = Files.readString(path);


        Map<String, Object> result = new ObjectMapper().readValue(stringPath, new TypeReference<>() {
        });

        return result;
    }

    public static String generate(String filepath1, String filepath2) throws IOException {

        StringBuilder sb = new StringBuilder();

        Map<String, Object> map1 = makeMapFromPath(filepath1);
        Map<String, Object> map2 = makeMapFromPath(filepath2);

        Set<String> keySet = new TreeSet<>(map1.keySet());
        keySet.addAll(map2.keySet());
        for (String key : keySet) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                sb.append("-" + key + ":" + map1.get(key) + "\n");
            }

            if (!map1.containsKey(key) && map2.containsKey(key)) {
                sb.append("+" + key + ":" + map2.get(key) + "\n");
            }

            if (map1.containsKey(key) && map2.containsKey(key)) {
                if(map1.get(key).equals(map2.get(key))) {
                    sb.append(" " + key + ":" + map1.get(key) +"\n");
                }
                if(!map1.get(key).equals(map2.get(key))) {
                    sb.append("-" + key + ":" + map1.get(key) + "\n");
                    sb.append("+" + key + ":" + map2.get(key) + "\n");
                }
            }
        }
        String showDifference = sb.toString();
        return showDifference;
    }

}


