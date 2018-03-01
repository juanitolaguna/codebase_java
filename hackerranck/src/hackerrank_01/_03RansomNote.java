package hackerrank_01;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 01.09.17.
 */
public class _03RansomNote {
    private static String magazine = "give me one grand one today night night";
    private static String note = "give one grand today night";

    public static void main(String[] args) {

        List<String> magazineList = Arrays.asList(magazine.split(" "));
        List<String> noteList = Arrays.asList(note.split(" "));

        Map<String, Long> magazineMap = magazineList.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Map<String, Long> noteMap = noteList.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        noteList.forEach(e -> {
            if (magazineMap.containsKey(e)) {
                magazineMap.put(e, magazineMap.get(e) - 1);
            } else {
                magazineMap.put(e, -1L);
            }
        });


        // Make a List od values then stream them down....
        boolean result = magazineMap.values().stream().anyMatch(e -> e < 0);
        System.out.println(result);


//        Map<String, Long> noteMap =

//                noteList.stream().collect(Collectors.groupingBy(e1 -> e1, Collectors.reducing( -> {
//                    if (magazineMap.containsKey(e)) {
//                        magazineMap.put(e, magazineMap.get(e) - 1);
//                    }
//                })));


//        System.out.println(magazineMap);
//        System.out.println(noteMap);

//        boolean b = Stream.of(noteMap).allMatch((k,v) -> contains(k,v,magazineMap));

//        noteMap.forEach((k,v) -> System.out.println(contains(k,v,magazineMap)));

//        boolean b = false;
//        for (Map.Entry<String, Long> entry : noteMap.entrySet()) {
//            b = contains(entry.getKey(), entry.getValue(), magazineMap);
//            if (b == false) {
//                break;
//            }
//        }

//        Iterator<Map.Entry<String, Long>> noteEntries = noteMap.entrySet().iterator();
        Iterator<Map.Entry<String, Long>> magazineEntries = magazineMap.entrySet().iterator();
//
//        while (noteEntries.hasNext()) {
//            Map.Entry<String, Long> note = noteEntries.next();
//            while (magazineEntries.hasNext()) {
//                Map.Entry<String, Long> magazine = magazineEntries.next();
//
//                if (note.getKey().equals(magazine.getKey())) {
//                    if (note.getValue() == 1) {
//                        noteEntries.remove();
//                    } else {
//                        Long newValue = note.getValue() - 1;
//                        note.setValue(newValue);
//                    }
//                }
//
//            }
//        }

//        while (noteEntries.hasNext()) {
//            noteEntries.next();
//
//        }

        //You cannot Iterate two times!
        while (magazineEntries.hasNext()) {
            Map.Entry<String, Long> entry = magazineEntries.next();
            System.out.println("Key: " + entry.getKey() + " | Value: " + entry.getValue());
        }


        //Another Solution!
//        List<String> magazineWords = Arrays.stream(magazine).sorted().collect(Collectors.toList());
//        boolean notRemovedWord = Arrays.stream(ransom).anyMatch(word->!magazineWords.remove(word));
//        System.out.println(notRemovedWord ? "No" : "Yes");


        //Another Solution
        boolean result2 =  noteMap.keySet().stream()
                .noneMatch(k -> magazineMap
                        .compute(k, (key, value) -> value == null ? -1L : value - noteMap.get(k)) < 0L);


    }

}
