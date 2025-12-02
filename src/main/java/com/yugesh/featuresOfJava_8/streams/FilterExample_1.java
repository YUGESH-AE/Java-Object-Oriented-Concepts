package com.yugesh.featuresOfJava_8.streams;

import java.util.List;
import java.util.stream.IntStream;

/**
 * filter() is an intermediate, stateless stream operation that takes a Predicate<T> and returns a new stream containing only the elements that satisfy the predicate.
 * Evaluates each element using the given predicate (a function returning true/false).
 * <p>
 * Keeps elements where predicate returns true.
 * <p>
 * Removes elements where predicate returns false.
 * <p>
 * Does not change the original stream; instead, it creates a new filtered stream.
 * <p>
 * Does not run until a terminal operation triggers the pipeline.
 * <p>
 * Works seamlessly with chaining (map, sorted, distinct etc.).
 */
public class FilterExample_1 {
    static void main() {

        // Basic numeric filtering
        List<Integer> nums = List.of(10, 5, 30, 18);

        var aboveTen = nums.stream()
                .filter(n -> n > 10)
                .toList();
        System.out.println(aboveTen);

        // Filtering strings by prefix
        List<String> names = List.of("arun", "bala", "aravind", "mani");

        var aNames = names.stream()
                .filter(n -> n.startsWith("a"))
                .toList();
        System.out.println(aNames);


        //Filtering index-based elements
        //Streams don’t have indexes, but you can cheat.
        List<String> items = List.of("A", "B", "C", "D");

        var evenIndex = IntStream.range(0, items.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(items::get)
                .toList();
        System.out.println(evenIndex);


    }
}
