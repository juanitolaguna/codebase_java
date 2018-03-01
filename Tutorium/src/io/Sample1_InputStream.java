package io;
import java.io.*;

/**
 * Created on 01.05.17.
 */
public class Sample1_InputStream {
    public static void main(String[] args) throws IOException {
        try {
            InputStream input = new FileInputStream("/Users/pawel/Desktop/picasso copy.txt");
            System.out.println("File opened");

            int data = input.read();
            while (data != -1) {
                data = input.read();
                System.out.println(data);
            }

        } catch (IOException e) {
            System.err.println("File opening failed...");
            e.printStackTrace();
        }

        OutputStream output = new FileOutputStream("/Users/pawel/Desktop/picasso copy.txt");
        output.write("Hello World... ganz viel text".getBytes());
        output.close();

    }
}
/*
The class java.io.InputStream is the base class for all Java IO input streams.
The class java.io.OutputStream is the base class of all Java IO output streams.

Some of the classes in the Java IO API are designed to help you parse input. These classes are:

PusbackInputStream
PusbackReader
StreamTokenizer
PushbackReader
LineNumberReader






 */