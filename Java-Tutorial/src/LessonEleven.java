import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;

public class LessonEleven {

    public static void main(String[] args) {
        ArrayList arrayListOne;
        arrayListOne = new ArrayList();
        ArrayList arrayListTwo = new ArrayList();

        ArrayList<String> names = new ArrayList<String>();
        names.add("John Smith");
        names.add("Mohamed Alami");
        names.add("Oliver Miller");
        names.add(2, "Jack Ryan");
        names.remove(3);
        //names.removeRange(0, 1); - what means protected


//        for(int i = 0; i < names.size(); i++) {
//            System.out.println(names.get(i));
//
//        }
//        for (String i : names) {
//            System.out.println(i);
//        }
        //creates a new Iterator Object wit methods that allows you iterate
        // through the values that are currently in your ArrayList
        Iterator indivItems = names.iterator();
        while (indivItems.hasNext()) {
            System.out.println(indivItems.next()); // ohne .next() geht nicht!?
        }

        ArrayList nameCopy = new ArrayList();
        ArrayList nameBackup = new ArrayList();

        nameCopy.addAll(names);
        String paulYoung = "Paul Young";
        names.add(paulYoung);

        if (names.contains(paulYoung)) {
            System.out.println("Paul is here!");
        }

        if (names.containsAll(nameCopy)) {
            System.out.println("Everything in nameCopy is in Names");
        }

        names.clear();
        if (names.isEmpty()) {
            System.out.println("ArrayList  is empty");
        }

        Object[] moreNames = new Object[4];
        moreNames = nameCopy.toArray();
        System.out.println(Arrays.toString(moreNames));

    }
}
