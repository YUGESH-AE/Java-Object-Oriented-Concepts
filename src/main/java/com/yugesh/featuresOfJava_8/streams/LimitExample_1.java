package com.yugesh.featuresOfJava_8.streams;

import java.util.stream.Stream;

/**
 * limit() is an intermediate, stateful, short-circuiting stream operation
 * that returns a new stream containing only the first n elements of the original stream.
 * Takes the first N elements.
 * <p>
 * Useful for pagination, sampling, and preventing infinite stream overflow.
 * <p>
 * Short-circuits: it stops processing once enough elements are collected.
 */
public class LimitExample_1 {

    static void main() {

        //basic limit
        var first3 = Stream.of(10, 20, 30, 40, 50)
                .limit(3)
                .toList();

        System.out.println(first3);

        //limit() on infinite streams
        //Without limit(), this infinite stream would never terminate.
        var infinite = Stream.iterate(0, n -> n + 1)
                .limit(30)
                .toList();
        System.out.println(infinite);
    }
}
