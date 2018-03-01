package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created on 02.05.17.
 */
public class Sample6_RWBytestreams {
    public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream("/Users/pawel/Desktop/IntelliJ-Projects/Tutorium/src/io/YDXJ0370.JPG");
            FileOutputStream out = new FileOutputStream("/Users/pawel/Desktop/IntelliJ-Projects/Tutorium/src/io/newcopy.JPG");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

