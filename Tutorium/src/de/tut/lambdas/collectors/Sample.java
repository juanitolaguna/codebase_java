package de.tut.lambdas.collectors;
import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * Created on 28/04/2017.
 */
public class Sample {
    public static List<Person> createPeople() {
        return Arrays.asList(
                new Person("Sara", Gender.FEMALE, 20),
                new Person("Sara", Gender.FEMALE, 22),
                new Person("Bob", Gender.MALE, 20),
                new Person("Paula", Gender.FEMALE, 32),
                new Person("Paul", Gender.MALE, 32),
                new Person("Jack", Gender.MALE, 2),
                new Person("Jack", Gender.MALE, 72),
                new Person("Jill", Gender.FEMALE, 12)
        );
    }

    public static void main(String[] args) {
        List<Person> people = createPeople();

        //create a mapwith name and age as keys and the person as value

//        System.out.println(
//                people.stream()
//                        .collect(toMap(
//                                person -> person.getName() + "-" + person.getAge(),to
//                                person -> person))
//
//        );

        //given a list of people, create a map where
        //their name is a key and value is all the people with that name.

        //normally:
        // create empty map - take the list - take the firs elem of the list -
        // - its a person, get the name of the person - does persons name exist as a key in the map?
        // - if no create empty list, add person object to the empty list - put on the map, name ->
        // new List<person> -> go on looping
        System.out.println(
                people.stream()
                        .collect(groupingBy(Person::getName, mapping((Person::getAge), toList()))));

        //Collectors interface as toMap


    }


}
