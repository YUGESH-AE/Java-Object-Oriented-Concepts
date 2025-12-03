package com.yugesh.featuresOfJava_8.streams;

import java.util.List;
import java.util.stream.Stream;

/**
 * dropWhile() is an intermediate operation that SKIPS element
 * s WHILE the predicate is true, and then returns the rest of the stream unchanged.
 */
public class DropAWhileExample_1 {

    static void main() {


        //Basic behavior
        List<Integer> nums = Stream.of(1, 2, 3, 0, 4, 5, 6)
                .dropWhile(n -> n > 0)
                .toList();
        System.out.println(nums);

        var result = Stream.of("apple", "ant", "bat", "axis")
                .dropWhile(s -> s.startsWith("a"))
                .toList();

        System.out.println(result);
    }
}
