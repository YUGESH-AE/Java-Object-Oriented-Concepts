package com.yugesh.featuresOfJava_8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * forEach() is a terminal stream operation that performs the given action on each element of the stream.
 * It does not return a value — it consumes the stream.
 * Executes the provided Consumer on every element of the stream.
 * <p>
 * Often used for side effects (printing, logging, updating external structures).
 * <p>
 * Does not guarantee encounter order in parallel streams.
 * <p>
 * Ends and consumes the entire stream pipeline.
 */
public class ForEachExamples_1 {


    static void main() {

        // forEach() with lambda logic
        List<String> names = List.of("Arun", "Vikram", "Yash");
        names.stream().forEach(System.out::println);

        //forEach() causing side effects on a data structure
        List<Integer> nums = List.of(1, 2, 3);
        List<Integer> doubled = new ArrayList<>();
        nums.stream().forEach(n -> doubled.add(n * n));
        System.out.println(doubled);

        //forEach() on a parallel stream — unordered output
        Stream.of("A", "B", "C", "D")
                .parallel()
                .forEach(System.out::println);


        //forEachOrdered() to preserve order
        Stream.of("A", "B", "C", "D")
                .parallel()
                .forEachOrdered(System.out::println);

    }
}
