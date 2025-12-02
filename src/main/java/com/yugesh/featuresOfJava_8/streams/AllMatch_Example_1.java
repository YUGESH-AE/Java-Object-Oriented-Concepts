package com.yugesh.featuresOfJava_8.streams;

import java.util.stream.Stream;

/**
 * allMatch() is a terminal, short-circuiting stream
 * operation that returns true only if every element matches the predicate.
 * Fails fast (short-circuits)
 * <p>
 * Returns false as soon as one element does not match
 */
public class AllMatch_Example_1 {
    static void main() {

        //Check if all numbers are positive
        boolean isPositive = Stream.of(10, 20, 30)
                .allMatch(n -> n > 0);
        System.out.println(isPositive);

        //Check if all strings have length > 3
        boolean ok = Stream.of("java", "angular", "react")
                .allMatch(n -> n.length() > 3);
        System.out.println(ok);
    }
}
