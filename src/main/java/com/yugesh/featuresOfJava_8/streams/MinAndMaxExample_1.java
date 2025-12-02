package com.yugesh.featuresOfJava_8.streams;

import java.util.Comparator;
import java.util.List;

/**
 * min() is a terminal, non–short-circuiting operation that returns the minimum
 * element of the stream according to the given comparator.
 * Returns an Optional<T> (empty if stream is empty).
 * <p>
 * Needs to check all elements → stateful.
 * <p>
 * Works with any type as long as a comparator is provided.
 * <p>
 * <p>
 * <p>
 * max() is the mirror image of min().
 * Returns the largest element.
 * <p>
 * Requires a comparator.
 * <p>
 * Returns Optional (never null).
 * <p>
 * Must inspect entire stream.
 */
public class MinAndMaxExample_1 {

    static void main() {

        List<Integer> nums = List.of(5, 10, 2, 25, 7);

        var minInteger = nums.stream()
                .min(Integer::compareTo)
                .get();
        System.out.println(minInteger);

        var maxInteger = nums.stream()
                .max(Integer::compareTo)
                .get();
        System.out.println(maxInteger);

        List<String> words = List.of("apple", "banana", "kiwi");

        //Finding shortest and longest string
        var shortest = words.stream()
                .min(Comparator.comparing(String::length))
                .get();  // "kiwi"

        var longest = words.stream()
                .max(Comparator.comparing(String::length))
                .get();  // "banana"

        System.out.println(longest);
        System.out.println(shortest);

    }
}
