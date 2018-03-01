import java.util.Arrays;
import java.util.LinkedList;

public class LessonTwelve {
    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList();
        LinkedList<String> names = new LinkedList<String>();
        names.add("Ahmed Bennani");
        names.add("Ali Syed");
        names.addLast("Nathan Martin");
        names.addFirst("Joshua Smith");
        names.add(1, "Noah Peters");
        names.remove(4);
        names.remove("Joshua Smith");

        System.out.println("\nFirst Index: " + names.get(0));
        for (String name : names) {
            System.out.println(name );
        }

        LinkedList<String> nameCopy = new LinkedList<String>(names);
        System.out.println("\nnameCopy: " + nameCopy);

        nameCopy.push("Ali Peterson ");
        nameCopy.push("Max Mustermann");
        String poppedString = nameCopy.pop();
        String x = nameCopy.peek();

        for (String name : nameCopy) {
            System.out.println(name);
        }


        System.out.println("poppedString: " + poppedString);
        System.out.println("peekedElem: " + x);

        Object[] nameArray = new Object[4];
        nameArray = names.toArray();
        System.out.println(Arrays.toString(nameArray));

    }
}



