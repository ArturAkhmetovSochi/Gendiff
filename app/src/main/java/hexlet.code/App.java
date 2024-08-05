package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.Map;
import java.util.concurrent.Callable;
import java.io.File;

import static hexlet.code.Differ.makeMapFromPath;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Parameters(description = "path to first file", defaultValue = "file1.json")
    private String filepath1;

    @Parameters(description = "path to second file.", defaultValue = "file2.json")
    private String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    String format = "stylish";

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate("/home/artur/java-project-71/app/src/main/java/hexlet.code/file1.json", "/home/artur/java-project-71/app/src/main/java/hexlet.code/file2.json"));
        return 0;
    }
}
