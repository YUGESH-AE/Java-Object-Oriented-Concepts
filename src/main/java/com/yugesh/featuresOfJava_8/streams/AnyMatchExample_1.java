package com.yugesh.featuresOfJava_8.streams;

import java.util.stream.Stream;

/**
 * anyMatch() is a terminal, short-circuiting stream
 * operation that returns true if at least one element matches the predicate.
 * Returns true as soon as one match is found → short-circuiting
 * <p>
 * Stops processing early
 * <p>
 * Useful for “exists?” checks
 */
public class AnyMatchExample_1 {

    static void main() {

        //Check if any number is even
        boolean resultOfEven = Stream.of(1, 3, 5, 6)
                .anyMatch(n -> n % 2 == 0);
        System.out.println(resultOfEven);

        boolean hasJava = Stream.of("python", "java", "c++")
                .anyMatch(s -> s.equalsIgnoreCase("java"));

        System.out.println(hasJava);
    }
}
