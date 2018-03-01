package io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created on 02.05.17.
 */
public class Sample2_Reader {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("/Users/pawel/Desktop/picasso copy.txt");

        int data = reader.read();
        while (data != -1) {
            char dataChar = (char) data;
            data = reader.read();
            System.out.print(dataChar);
        }
        reader.close();
    }
}
/*
The Java Reader is the base class of all Reader's in the Java IO API.
Subclasses include a BufferedReader, PushbackReader, InputStreamReader, StringReader and several others.

Notice, that while an InputStream returns one byte at a time,
meaning a value between 0 and 255 (or -1 if the stream has no more data),
the Reader returns a char at a time, meaning a value between 0 and 65535 (or -1 if the stream has no more data).




 */
