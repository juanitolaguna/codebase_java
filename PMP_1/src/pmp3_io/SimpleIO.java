package pmp3_io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created on 02.05.17.
 */

public class SimpleIO {

    public static List<String> readToList(String filepath) {
        List<String> sAry = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(filepath)));
            while (scanner.hasNext()) {
                sAry.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sAry;
    }

    public static List<List<String>> readToTwoDim(String filepath) {
        List<String> listOfStrings = readToList(filepath);
        //clean up List
        listOfStrings = listOfStrings.stream()
                .filter(e -> !e.isEmpty())
                .collect(Collectors.toList());

        List<List<String>> twoDimList = new ArrayList<>();
        List<String> line;

        for (String text : listOfStrings) {
            // split line to Array
            line = Arrays.asList(text.split(" "));
            twoDimList.add(line);
        }

        return twoDimList;
    }

    public static void write(List<List<String>> list, String filepath) {


        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath));
            for (List<String> satz : list) {
                bufferedWriter.write(String.join(" ", satz));
                bufferedWriter.newLine();
//                bufferedWriter.flush();
            }
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        String filepath1 = "/Users/pawel/Desktop/IntelliJ-Projects/PMP_1/src/pmp3_io/picasso.txt";
//        String filepath2 = "/Users/pawel/Desktop/IntelliJ-Projects/PMP_1/src/pmp3_io/picasso_write.txt";
//        write(readToTwoDim(filepath1),filepath2);
//    }

}