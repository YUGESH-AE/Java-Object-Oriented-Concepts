package com.yugesh.featuresOfJava_8.streams;

import java.util.List;
import java.util.stream.IntStream;

/**
 * map() is an intermediate, stateless stream operation that transforms each element of the stream by applying the given function and produces a new stream containing the transformed elements.
 * Applies the mapper function to every element.
 * <p>
 * Output stream may be of a different type than the input stream.
 * <p>
 * Produces a new stream without modifying the original.
 * <p>
 * Executes lazily (runs only when a terminal operation is called).
 */
public class MapExample_1 {

    static void main() {

        /// Basic Transformation
        List<String> words = List.of("apple", "ball", "cat");
        var lengths = words.stream()
                .map(String::length)
                .toList();
        System.out.println(lengths);

        /// Apply mathematical transformation
        List<Integer> nums = List.of(1, 2, 3, 4);

        var squares = nums.stream()
                .map(n -> n * n)
                .toList();
        System.out.println(squares);
        //Mapping indexes manually
        //(Streams don’t have indexes, but you can fake it)


        List<String> names = List.of("A", "B", "C");

        var withIndex = IntStream.range(0, names.size())
                .mapToObj(i -> i + " → " + names.get(i))
                .toList();

        System.out.println(withIndex);


    }
}
