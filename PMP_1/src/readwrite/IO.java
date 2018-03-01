package readwrite;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 03.07.17.
 */
public class IO {
    private static String path = "/Users/pawel/Desktop/IntelliJ-Projects/PMP_1/src/readwrite/picasso.txt";
    private static String pathWrite = "/Users/pawel/Desktop/IntelliJ-Projects/PMP_1/src/readwrite/picassowrite.txt";

    public static List<String> sortedFile(String Path) {
        List<String> ls = null;
        try {
            ls = Files.readAllLines(Paths.get(path)).stream()
                    .filter(d -> !d.matches(""))
                    .map(d -> Arrays.asList(d.split(" ")))
                    .sorted(Comparator.comparing(e -> e.get(e.size() - 1).toLowerCase()))
                    .map(d -> String.join(" ", d))
                    .peek(d -> System.out.println(d))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ls;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter(pathWrite));
        sortedFile(path).forEach(e -> {
            try {
                br.write(e);
                br.newLine();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });
        br.close();
    }
}
