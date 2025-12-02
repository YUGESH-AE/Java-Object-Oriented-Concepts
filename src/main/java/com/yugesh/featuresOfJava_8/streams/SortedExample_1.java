package com.yugesh.featuresOfJava_8.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * sorted() is an intermediate, stateful,
 * unbounded stream operation that returns a new stream whose elements are sorted according
 * It must see all elements before producing output → stateful.
 * <p>
 * Works for both numbers and objects.
 * <p>
 * Uses natural ordering unless a comparator is provided.
 * <p>
 * May be expensive for very large streams (needs full sort).
 * <p>
 * Respect encounter order + comparator order.
 */
public class SortedExample_1 {

    static void main() {

        //Basic sorted() — natural ordering
        List<Integer> nums = List.of(5, 1, 3, 2);

        var naturalSorting = nums.stream()
                .sorted()
                .toList();
        System.out.println(naturalSorting);

        //sorted() on Strings
        var sortedFruits = Stream.of("banana", "apple", "cherry")
                .sorted()
                .toList();
        System.out.println(sortedFruits);


        //Sort in descending order
        var des = Stream.of(38, 21, 1, 2, 3, 5, 99, 100, 10)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(des);

        //Sort strings by length
        var sortedByLength = Stream.of("java", "ai", "stream")
                .sorted(Comparator.comparing(String::length))
                .toList();
        System.out.println(sortedByLength);


    }
}
