package hexlet.code;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    public static String generate(String filepath1, String filepath2) throws IOException {

        String format = "stylish";

        Map<String, Object> map1 = Parser.getMapFromFile(filepath1);
        Map<String, Object> map2 = Parser.getMapFromFile(filepath2);

        List<Map<String, Object>> differenceMap = Difference.getDifference(map1, map2);

        return Format.format(differenceMap, format);
    }

}



