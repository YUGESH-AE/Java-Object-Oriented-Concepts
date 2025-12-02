package com.yugesh.featuresOfJava_8.streams;

import java.util.stream.Stream;

/**
 * distinct() is an intermediate, stateful, unbounded stream operation that returns a
 * new stream containing only unique elements,
 * removing duplicates based on equals() and hashCode().
 * Keeps the first occurrence of each element.
 * <p>
 * Removes the rest based on equality.
 * <p>
 * Relies on equals() + hashCode() for object comparison.
 * <p>
 * Needs to remember previously seen elements → stateful.
 * <p>
 * Works well for small/medium streams.
 * <p>
 * May be expensive for very large streams.
 */
public class DistinctExample_1 {

    static void main() {

        //Basic distinct() with numbers
        var result = Stream.of(1, 1, 2, 3, 4, 2, 3, 4, 1, 2, 3, 4, 5, 5, 5, 6, 6, 6, 6)
                .distinct()
                .toList();
        System.out.println(result);

        //distinct() + sorted()
        var results = Stream.of(5, 3, 5, 2, 3)
                .distinct()
                .sorted()
                .toList();
        System.out.println(results);


    }
}
