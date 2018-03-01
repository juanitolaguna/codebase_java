package pmp3_io;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.language.ColognePhonetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Created on 03.05.17.
 */
public class CodeSnippets {
//    public static void main(String[] args) {
//        String filepath = "/Users/pawel/Desktop/IntelliJ-Projects/PMP_1/src/pmp3_io/picasso.txt";
//        List<String> sAry = SimpleIO.readToList(filepath);
//        List<List<String>> twoDimAry = new ArrayList<>();
//        //clean up sAry
//        sAry = sAry.stream()
//                .filter(e -> !e.isEmpty())
//                .collect(Collectors.toList());
//
//        List<String> line;
////        String lastWord = "";
////
//        for (String text : sAry) {
//            line = Arrays.asList(text.split(" "));
//            //clean up line
//            line = line.stream()
//                    .filter(e -> !e.isEmpty())
//                    .map(e -> e.replaceAll("[:,.-]", ""))
//                    .collect(Collectors.toList());
//            line.removeIf(e -> e.equals(""));
//            twoDimAry.add(line);
////            lastWord = line.get(line.size() - 1);
//
//        }
//
//        twoDimAry = twoDimAry.stream()
//                .sorted((e1, e2) -> (e1.get(e1.size() - 1).compareTo(e2.get(e2.size() - 1))))
//                .collect(Collectors.toList());
//
////
////        twoDimAry = twoDimAry.stream()
////                .map(e -> e.toString());
//
//
////        List<String> ary = Arrays;
////        System.out.println(twoDimAry);
//        Arrays.sort(SimpleIO.readToList(filepath));
//
//    }
}



