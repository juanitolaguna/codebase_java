import java.util.Arrays;

public class LessonThirteen {

    public static void main(String[] args) {

        String randomString = "I'm just a random String";
        String letters = "abcde";
        System.out.println(letters.endsWith("de"));
        System.out.println(letters.indexOf("cd"));
        System.out.println("length: " + letters.length());
        System.out.println(letters.replace("de", "xyz"));

        String[] letterArray = letters.split("");

        System.out.println(Arrays.toString(letterArray));

        char[] charArray = letters.toCharArray();
        System.out.println(Arrays.toString(charArray));
        System.out.println(letters.substring(1, 4));


        StringBuilder randSB = new StringBuilder("a random value");
        System.out.println(randSB.append(" again"));
        System.out.println(randSB);
        System.out.println(randSB.delete(15, 21));
        System.out.println(randSB.capacity()); //30 characters
        randSB.ensureCapacity(60);

        System.out.println(randSB.insert(1, "nother"));
        String oldSB = randSB.toString();
        System.out.println(randSB.charAt(4));
    }
}
