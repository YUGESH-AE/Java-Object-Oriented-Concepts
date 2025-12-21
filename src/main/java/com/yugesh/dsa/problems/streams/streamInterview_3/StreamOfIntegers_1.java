package com.yugesh.dsa.problems.streams.streamInterview_3;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOfIntegers_1 {
    static void main() {

        int[] arr1 = {1, 6, 7, 8, 1, 1, 8, 8, 7};
        System.out.println(sumOfUniqueIntegers(arr1));

        int[] arr2 = {2, 3, 10, 14, 20, 24, 30, 34, 40, 44, 50, 54};
        System.out.println(groupByNumbers(arr2));
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
}
