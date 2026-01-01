package com.yugesh.dsa.problems.streams.streamInterview_3;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamOfIntegers_1 {
    static void main() {

        int[] arr1 = {1, 6, 7, 8, 1, 1, 8, 8, 7};
        System.out.println(sumOfUniqueIntegers(arr1));

        int[] arr2 = {2, 3, 10, 14, 20, 24, 30, 34, 40, 44, 50, 54};
        System.out.println(groupByNumbers(arr2));

        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println(multiplyAlternateNumbers(arr3));

        System.out.println(multiplyExtreme(arr3));

        int[] arr4 = {5, 0, 1, 0, 8, 0};
        System.out.println(moveZerosToBeginning(arr4));

        System.out.println(distinctArray(arr4));
    }

    /**
     * Given an array, find the sum of unique elements
     *
     * @param a
     * @return
     */

    public static int sumOfUniqueIntegers(int[] a) {

        return Arrays.stream(a)
                .distinct()
                .sum();
    }

    /**
     * Important
     * Given an array of integers, group the numbers by the range
     *
     * @param arr
     * @return
     */

    public static Map<Integer, List<Integer>> groupByNumbers(int[] arr) {

        return Arrays.stream(arr)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                x -> x / 10 * 10
                        )
                );
    }

    /**
     * Write a stream program to multiply alternative numbers in an array
     *
     * @param a
     * @return
     */
    public static int multiplyAlternateNumbers(int[] a) {

        return IntStream.range(0, a.length)
                .filter(x -> x % 2 == 0)
                .map(x -> a[x])
                .reduce(1, (c, d) -> c * d);
    }

    /**
     * Write a program to multiply 1st and last element, 2nd and 2nd last element etc.
     *
     * @param a
     * @return
     */
    public static List<Integer> multiplyExtreme(int[] a) {
        return IntStream
                .range(0, a.length / 2)
                .map(i -> a[i] * (a[a.length - 1 - i]))
                .boxed()
                .toList();
    }

    /**
     * Write a stream program to move all zero’s to beginning of array
     *
     * @param a
     * @return
     */
    public static List<Integer> moveZerosToBeginning(int[] a) {

        return Arrays.stream(a)
                .boxed()
                .collect(
                        Collectors.partitioningBy(x -> x != 0)
                ).values()
                .stream()
                .flatMap(Collection::stream)
                .toList();
    }

    /**
     * In a given array of integers, return true if it contains distinct values
     *
     * @param a
     * @return
     */
    public static boolean distinctArray(int[] a) {

        return Arrays.stream(a)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                ).values()
                .stream()
                .allMatch(x -> x == 1);
    }
}
