package com.yugesh.featuresOfJava_8.streams;

import java.util.stream.Stream;

/**
 * noneMatch() is a terminal, short-circuiting stream operation
 * that returns true when no elements match the predicate.
 * Returns true only when 0 elements satisfy predicate
 * <p>
 * Short-circuits as soon as one match is found
 */
public class NoneMatchExample_1 {

    static void main() {

        //Check if no number is negative
        boolean result = Stream.of(10, 20, 30)
                .noneMatch(n -> n < 0);

        System.out.println(result);

        //Check if a list contains no empty strings
        boolean noneEmpty = Stream.of("apple", "banana", "cherry")
                .noneMatch(String::isEmpty);

// true

    }
}
