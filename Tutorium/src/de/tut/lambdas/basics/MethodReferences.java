package de.tut.lambdas.basics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created on 20/04/2017.
 */
public class MethodReferences {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9, 10);

        //external Iterators - means fullcontroll and is bad
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));  // Instance Method of a "PrintStream" Instance (named out???).
        }
        //external Iterators also
        for (int e : numbers) {
            System.out.println(e);
        }

        //internal Iterator
        //pass Object to a function vs. call a function on an object itself(and benefit from polymorphism)
        //polymorphism: you can vary what to do but you can vary the implementation based on the type of an object

//        numbers.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });

//        numbers.forEach((integer) -> System.out.println(integer));
        //Java 8 has type interference, but only for lambda expressions

//        numbers.forEach(integer -> System.out.println(integer));
        // parenthesis are optional, but only for one parameter lambdas
        // if no parameters, you have to put empty perenthesis, if more than one param, also parenthesis


        numbers.forEach(System.out::println);
        // not System.out.println(); to make clear that we are passing the funktion and not invoking the function,
        // so use "Method reference syntax. So we have replaced the Lambda with a Method reference to say "all my
        // intention is to receive that value and simply pass that value as an argument (in this case)"
        // lambda expressions should be glue code, (use no more than one line). Refactoring helps.
        // If you really have logic in your lambda, its the wrong place to put the logic. Move the logic into
        // a function (method), have the functionalized unit tested and than simply call that function within
        // in a lambda rather than having the logic in a lambda itself.


        /*
        - METHOD REFERENCES

        - parameter as an Argument
        - parameter as an Argument to a static method
        - parameter as a target
        - two parameters as arguments
        - two parameters, one as target the other as an argument



        - are only useful in the most simply and trivial cases
        - means: you are receiving an argument or parameter and pass through(not altered) - only case where MR useful.
        - probably the most ultimate glue code
         */

//        numbers.forEach(e -> System.out.println(e));
//        numbers.forEach(System.out::println); // Method reference to an INSTANCE METHOD

       /*
         - System.out is actually an OBJECT, so youre calling the method println
         which is an Instance method on this Object
         - we assume that println is static but it is, because we se it everywhere, but it is an Instance Method
         on System.out
         - So here we are passing the parameter as an argument to another Instance Method where
          the Target is already defined,(in this case System.out), that is the Object on which you are calling
         the println function
         */

//        numbers.stream()
//                // .map(e -> String.valueOf(e))
//                .map(String::valueOf) //Reference to a STATIC METHOD
//                .forEach(System.out::println);

//        numbers.stream()
//                .map(e -> String.valueOf(e))
//                // .map(e -> e.toString())
//                .map(String::toString) // same Structure but INSTANCE METHOD
//                .forEach(System.out::println);

//        System.out.println(
//                numbers.stream()
//                        .reduce(0, (total, e) -> Integer.sum(total, e))
//        );

        // reduce lambda to method reference
        // you can use method references as well with two params

        System.out.println(
                numbers.stream()
                        .reduce(0, Integer::sum)
        );


        System.out.println(
                numbers.stream()
                        .map(String::valueOf)
//                        .reduce("", (carry, str) -> carry.concat(str))
                        .reduce("", String::concat)
        );

        // Limitations: cannot use Method references if you are doing manipulation of data
        // if there is a conflict between instance method and static method
        // for example - Integer toString is both a static method and an instance method



    }
}
