package hexlet.code;

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

        assertEquals(map1, map2);
    }

    @Test
    public void testGenerateDefault() throws IOException {

        String str1 = Differ.generate("testFile1.json",
                "testFile2.json");
        String str2 = ("{" + "\n" + "  -follow:true" + "\n" + "   host:hexlet.io" + "\n" + "  -proxy:777.777.777"
                + "\n" + "  -timeout:25" + "\n" + "  +timeout:55" + "\n" + "  +verbose:false" + "\n" + "}");

        assertEquals(str1, str2);
    }

    @Test
    public void testGenerateYamlInJsonFormat() throws IOException {

        String str1 = Differ.generate("testFile1.yml", "testFile2.yaml", "json");
        String str2 = ("[{\"type\":\"deleted\",\"value\":false,\"key\":\"checked\"},{\"value2\":[\"value1\""
                + ",\"value2\"],\"value1\":null,\"type\":\"changed\",\"key\":\"default\"},{\"value2\":null,"
                + "\"value1\":45,\"type\":\"changed\",\"key\":\"id\"},{\"type\":\"deleted\",\"value\":"
                + "\"value1\",\"key\":\"key1\"},{\"type\":\"added\",\"value\":\"value2\",\"key\":\"key2\"}"
                + ",{\"type\":\"unchanged\",\"value\":[1,2,3,4],\"key\":\"numbers1\"},{\"value2\":[22,33,44,55],"
                + "\"value1\":[2,3,4,5],\"type\":\"changed\",\"key\":\"numbers2\"},{\"type\":\"deleted\",\"value\""
                + ":[\"a\",\"b\",\"c\"],\"key\":\"numbers3\"},{\"type\":\"added\",\"value\":{\"nestedKey\":\"value\","
                + "\"isNested\":true},\"key\":\"obj1\"},{\"type\":\"deleted\",\"value\":\"Something\",\"key\""
                + ":\"setting1\"},{\"type\":\"added\",\"value\":777,\"key\":\"setting2\"},{\"value2\":\"none\""
                + ",\"value1\":true,\"type\":\"changed\",\"key\":\"setting3\"}]");

        assertEquals(str1, str2);
    }
    @Test
    public void testGeneratePlainFormat() throws IOException {

        String str1 = Differ.generate("file3.yml", "file4.yml", "plain");
        String str2 = ("Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'");

        assertEquals(str1, str2);
    }



}
