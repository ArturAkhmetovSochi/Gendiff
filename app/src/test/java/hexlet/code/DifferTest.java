package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class DifferTest {

    private static String plainResult;
    private static String jsonResult;
    private static String stylishResult;

    public static String openFixture(String file) throws IOException {

        Path path = Paths.get(file).toAbsolutePath().normalize();
        return Files.readString(path);
    }

    @Test
    public void generateTest() throws IOException {
        this.jsonResult = openFixture("src/test/resources/fixtureJson.txt");
        this.plainResult = openFixture("src/test/resources/fixturePlain.txt");
        this.stylishResult = openFixture("src/test/resources/fixtureStylish.txt");

        Assertions.assertEquals(jsonResult, Differ.generate("src/test/resources/testFile1.yml",
                "src/test/resources/testFile2.yaml", "json"));
        Assertions.assertEquals(jsonResult, Differ.generate("src/test/resources/testFile1.json",
                "src/test/resources/testFile2.json", "json"));
        Assertions.assertEquals(plainResult, Differ.generate("src/test/resources/testFile1.yml",
                "src/test/resources/testFile2.yaml", "plain"));
        Assertions.assertEquals(plainResult, Differ.generate("src/test/resources/testFile1.json",
                "src/test/resources/testFile2.json", "plain"));
        Assertions.assertEquals(stylishResult, Differ.generate("src/test/resources/testFile1.yml",
                "src/test/resources/testFile2.yaml", "stylish"));
        Assertions.assertEquals(stylishResult, Differ.generate("src/test/resources/testFile1.json",
                "src/test/resources/testFile2.json"));
    }






}
