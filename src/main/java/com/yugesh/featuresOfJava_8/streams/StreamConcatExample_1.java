package com.yugesh.featuresOfJava_8.streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Concatenates two streams into a single combined stream.
 * Order: all elements of a → then all elements of b.
 * <p>
 * Streams must NOT be reused after finishing (consumed once).
 */
public class StreamConcatExample_1 {

    static void main() {

        //Combine two streams
        Stream<String> s1 = Stream.of("A", "B", "D");
        Stream<String> s2 = Stream.of("S", "I", "J");

        Stream<String> concatStreams = Stream.concat(s1, s2).sorted();
        System.out.println(Arrays.toString(concatStreams.toArray(String[]::new)));


        //Combine filtered streams
        Integer[] evens = Stream.iterate(1, n -> n + 1)
                .filter(n -> n % 2 == 0)
                .limit(10)
                .toArray(Integer[]::new);

        Integer[] odd = Stream.iterate(1, n -> n + 1)
                .filter(n -> n % 2 != 0)
                .limit(10)
                .toArray(Integer[]::new);

        Stream<Integer> combined = Stream.concat(Arrays.stream(evens), Arrays.stream(odd)).sorted();

        System.out.println(Arrays.toString(combined.toArray()));

    }
}
