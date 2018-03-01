//package io;
//
//import java.io.*;
//import java.util.Scanner;
//
///**
// * Created on 02.05.17.
// */
//public class Sample8_BufferedStreams {
//    public static void main(String[] args) {
//        try {
//            Scanner scanner =
//                    new Scanner(
//                            new BufferedReader(
//                                    new FileReader(
//                                            "/Users/pawel/Desktop/IntelliJ-Projects/Tutorium/src/io/picasso.txt")));
//
////            BufferedWriter out = new BufferedWriter(
////                    new FileWriter(
////                            "/Users/pawel/Desktop/IntelliJ-Projects/Tutorium/src/io/new_hamlet.xml"));
//
//            while (scanner.hasNext()) {
//                System.out.println(scanner.nextLine());
//
//            }
//            System.out.println("R/W COMPLETED!!!");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}
