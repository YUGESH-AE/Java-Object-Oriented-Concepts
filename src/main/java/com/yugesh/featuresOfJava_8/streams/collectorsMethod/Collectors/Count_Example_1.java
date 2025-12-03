package com.yugesh.featuresOfJava_8.streams.collectorsMethod.Collectors;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Counts the number of elements in the stream — returns a Long.
 */
public class Count_Example_1 {

    static void main() {

        long count = Stream.of("A", "B", "C")
                .collect(Collectors.counting());
        System.out.println(count);

    }
}
