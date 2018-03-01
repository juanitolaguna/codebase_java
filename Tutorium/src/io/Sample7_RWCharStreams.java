package io;
import java.io.*;

/**
 * Created on 02.05.17.
 */
public class Sample7_RWCharStreams {
    public static void main(String[] args) {
            try {
                FileReader in = new FileReader("/Users/pawel/Desktop/IntelliJ-Projects/Tutorium/src/io/textfile.txt");
                FileWriter out = new FileWriter("/Users/pawel/Desktop/IntelliJ-Projects/Tutorium/src/io/new.txt");
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
