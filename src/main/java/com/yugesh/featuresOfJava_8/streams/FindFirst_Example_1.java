package com.yugesh.featuresOfJava_8.streams;


import java.util.List;
import java.util.Optional;

/**
 * findFirst is one of those gentle Stream operators —
 * it quietly walks through the stream and returns the very first element from the encounter order.
 * Let’s peel it open clearly, with crisp examples and a bit of friendly intuition.
 * findFirst() is a terminal, short-circuiting stream operation
 * that returns the first element of the stream wrapped inside an Optional<T>.
 * Returns Optional<T> (never null).
 * Stops as soon as the first element is found.
 * Always respects encounter order.
 * Very predictable for sequential streams.
 * Works well even in parallel streams — but it forces order, making it slightly slower than findAny().
 */
public class FindFirst_Example_1 {

    static void main() {


        //Basic Example
        List<String> names = List.of("Arun", "Vikram", "Yash");
        Optional<String> optionalName = names.stream().findFirst();
        System.out.println(optionalName.get());

        //Example with Empty Stream
        List<Integer> empty = List.of();
        Optional<Integer> first = empty.stream().findFirst();
        System.out.println(first.isPresent());  // false


        //findFirst() with filter()
        List<Integer> nums = List.of(5, 12, 20, 3);

        Optional<Integer> firstBig = nums.stream()
                .filter(n -> n > 10)
                .findFirst();
        System.out.println(firstBig.get());

    }
}
