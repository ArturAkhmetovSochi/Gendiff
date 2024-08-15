package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    public void testMakeMapFromPath() throws IOException {

        String filepath = "testFile1.json";
        Map<String, Object> map1 = Map.of("host", "hexlet.io", "timeout", 25,
                "proxy", "777.777.777", "follow", true);
        Map<String, Object> map2 = Parser.getMapFromFile(filepath);

        Assertions.assertTrue(map1.equals(map2));
    }

    @Test
    public void testGenerate() throws IOException {

        String str1 = Differ.generate("testFile1.json",
                "testFile2.json");
        String str2 = ("-follow:true" + "\n" + " host:hexlet.io" + "\n" + "-proxy:777.777.777"
            + "\n" + "-timeout:25" + "\n" + "+timeout:55" + "\n" + "+verbose:false" + "\n");

        assertEquals(str1, str2);
    }
}
