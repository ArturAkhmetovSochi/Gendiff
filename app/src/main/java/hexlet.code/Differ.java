package hexlet.code;

import java.io.IOException;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


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

    public static Map<String, Object> generate(String filepath1, String filepath2) throws IOException {

        Path path1 = Paths.get("/home/artur/java-project-71/app/src/main/java/hexlet.code/file1.json").toAbsolutePath().normalize();
        Path path2 = Paths.get("/home/artur/java-project-71/app/src/main/java/hexlet.code/file2.json").toAbsolutePath().normalize();

        String stringPath1 = Files.readString(path1);
        String stringPath2 = Files.readString(path2);

        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + "' does not exist");
        }

        if (!Files.exists(path2)) {
            throw new Exception("File '" + path2 + "' does not exist");
        }

        Map<String, Object> result1 =
                (Map<String, Object>) new ObjectMapper().readValue(stringPath1, Differ.class);

        Map<String, Object> result2 =
                (Map<String, Object>) new ObjectMapper().readValue(stringPath2, Differ.class);

        return result1;

    }

}