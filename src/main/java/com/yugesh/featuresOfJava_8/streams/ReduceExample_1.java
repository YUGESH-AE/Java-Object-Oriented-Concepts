package com.yugesh.featuresOfJava_8.streams;

import java.util.stream.Stream;

/**
 * reduce() is a terminal operation that combines all elements of a stream
 * into one final value using a reducer function.
 * <p>
 * No identity value
 * <p>
 * Returns an Optional<T>
 * <p>
 * Used when you want the result to be the same type as the elements
 * <p>
 * Uses an identity (starting value)
 * <p>
 * Never returns Optional — always returns a T
 * <p>
 * Most commonly used overload
 */
public class ReduceExample_1 {

    static void main() {


        //Sum of numbers (identity + accumulator)
        int sumOfNNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(0, Integer::sum);

        System.out.println(sumOfNNumbers);


        //Find longest string using reduce
        String longestString = Stream.of("Java", "Angular", "React", "Python")
                .reduce("", (a, b) -> a.length() > b.length() ? a : b);
        System.out.println(longestString);
    }
}
