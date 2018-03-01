package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 01/05/2017.
 */
public class GenericExamples {


    public void betterForCasting() {
        List<String> list = new ArrayList<>();
        list.add("a string");
        list.add("another string");

        String s = list.get(0);
        String s2 = list.get(1);
    }

    public void BoxesTest() {
        List<Box> boxes = new ArrayList<>();
        Box<String> box = new Box<>();
        box.set("new string");
        Box<String> box2 = new Box<>();
        box2.set("another string");

        boxes.add(box);
        boxes.add(box2);
    }
}
