package com.yugesh.featuresOfJava_8.streams;

import java.util.List;
import java.util.stream.Stream;

/**
 * peek() is an intermediate, stateless stream operation used to perform a side-effect
 * action (like logging, debugging, printing) on each element without modifying the stream.
 * Useful only for debugging or minimal side effects.
 * <p>
 * Does not modify stream elements.
 * <p>
 * Is lazy — runs only when a terminal operation exists.
 * <p>
 * Should not be used for business logic mutations.
 */
public class PeekExample_1 {

    static void main() {

        //Debug elements inside a pipeline
        var lists = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .peek(s -> System.out.println("Before Processing:" + s))
                .map(s -> s * s)
                .peek(s -> System.out.println("after processing:" + s))
                .toList();

        //Use peek() to inspect filtered values
        var list = List.of("apple", "ball", "cat");
        var result = list.stream()
                .filter(s -> s.length() > 3)
                .peek(s -> System.out.println("Passed filter: " + s))
                .map(String::toUpperCase)
                .toList();


    }
}
