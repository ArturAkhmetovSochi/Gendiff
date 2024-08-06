package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<Integer> {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Parameters(description = "path to first file", defaultValue =
            "/home/artur/java-project-71/app/src/main/java/hexlet.code/file1.json")
    String filepath1;

    @Parameters(description = "path to second file.", defaultValue =
            "/home/artur/java-project-71/app/src/main/java/hexlet.code/file2.json")
    String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    String format = "stylish";

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2));
        return 0;
    }
}
