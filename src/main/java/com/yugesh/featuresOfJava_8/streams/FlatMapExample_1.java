package com.yugesh.featuresOfJava_8.streams;

import java.util.Collection;
import java.util.List;

/**
 * flatMap() is an intermediate, stateless stream operation that transforms each element into another stream and then flattens all those inner streams into a single continuous stream.
 * map() → transforms one element → one element
 * <p>
 * flatMap() → transforms one element → many elements, then flattens the result
 * <p>
 * Removes nesting (Stream<Stream<T>> → Stream<T>)
 */
public class FlatMapExample_1 {

    static void main() {

        //Flatten a list of lists
        List<List<Integer>> data = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );

        var flatList = data.stream()
                .flatMap(Collection::stream)
                .map(Math::sqrt)
                .toList();
        System.out.println(flatList);
    }
}
