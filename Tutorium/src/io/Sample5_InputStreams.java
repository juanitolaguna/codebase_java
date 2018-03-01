package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created on 02.05.17.
 */
public class Sample5_InputStreams {
    public static void main(String[] args) throws IOException {
        try (InputStream inputstream = new FileInputStream("/Users/pawel/Desktop/picasso copy.txt")) {

            int data = inputstream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = inputstream.read();
            }
        }
    }
}
