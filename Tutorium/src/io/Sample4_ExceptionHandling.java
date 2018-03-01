package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created on 02.05.17.
 */
public class Sample4_ExceptionHandling {
    public static void main(String[] args) {
        InputStream input = null;

        try {
            input = new FileInputStream("/Users/pawel/Desktop/picasso copy.txt");

            int data = input.read();
            while (data != -1) {
                //do something with data...
                //doSomethingWithData(data);

                data = input.read();
            }
        } catch (IOException e) {
            //do something with e... log, perhaps rethrow etc.
        } finally {
            try {
                if (input != null) input.close();
            } catch (IOException e) {
                e.printStackTrace(); //alternativen? .process...
            }
        }
    }
}
