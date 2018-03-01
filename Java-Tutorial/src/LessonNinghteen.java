import java.util.regex.*;

/**
 * Created on 28/03/2017.
 */
public class LessonNineteen {
    public static void main(String[] args) {
        String longString = " Derek Banas CA 12345 PA (412)555-1212 johnsmith@hotmail.com 412-555-1234 412 555-1234 ";
        String strangeString = " 1Z aaa **** *** {{{ {{ { ";

        //[0-9] - Any characters you want
        //[A-G] - Not A-G
        // \\s - match any whitespace - Java specific
        // \\S - not whitespace
        //{n,m} - anything that could be n to m times


        // Word that is 2 to 20 charscters length
        // [A-Za-Z]{2,20} <=> \\w{2,20} (\\w any character)
    }

    public static void regexChecker(String theRegex, String string2Check) {
        Pattern checkRegex = Pattern.compile(theRegex);
        Matcher regexMatcher = checkRegex.matcher(string2Check); //match compiled regex against the String(2 check)
        while (regexMatcher.find()) {
            if (regexMatcher.group().length() != 0) {
            }
        }
    }
}
