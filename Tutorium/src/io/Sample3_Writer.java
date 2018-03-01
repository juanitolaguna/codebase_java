package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created on 02.05.17.
 */
public class Sample3_Writer {
    public static void main(String[] args) {
        Writer writer = null;
        try {
            writer = new FileWriter("/Users/pawel/Desktop/picasso copy.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.write("Hello World Writer");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
The Java Writer class is the base class of all Writers in the Java IO API.
Subclasses include BufferedWriter and PrintWriter among others.
 */