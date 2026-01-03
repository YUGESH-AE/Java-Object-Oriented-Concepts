package com.yugesh.dsa.problems.algorithm._2_frequencyMap;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyEasyProblems {

    static void main() {

        int[] nonRepeating = {4, 5, 1, 2, 1, 4, 5};
        System.out.println(firstNonRepeating(nonRepeating));

        int[] a = {4, 6, 2, 6, 4, 6, 2};

        System.out.println(elementAppearingKTimes(a, 2));
        System.out.println(appearMoreThanOnce(a));
        System.out.println(highestFrequency(a));

        int[] evenFrequency = {1, 2, 3, 2, 3, 1};
        System.out.println(allFrequencyEven(evenFrequency));

    }

    /**
     * Problem 1: Count Frequency of Elements
     * Input:
     * int[] arr = {1, 2, 2, 3, 3, 3}
     *
     * @param a
     * @return
     */
    public static Map<Integer, Integer> frequency(int[] a) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : a) {
            map.compute(i, (k, v) -> v != null ? v + 1 : 1);
        }
        return map;
    }

    /**
     * Find the First Non-Repeating Element
     *
     * @param a
     * @return
     */
    public static int firstNonRepeating(int[] a) {

        return Arrays.stream(a)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }

    /**
     * Problem 3: Find the First Element That Appears Exactly K Times
     * Input:
     * int[] arr = {1, 7, 4, 3, 4, 8, 7}
     * k = 2
     *
     * @param a
     * @param k
     * @return
     */
    public static int elementAppearingKTimes(int[] a, int k) {
        Map<Integer, Integer> map = frequency(a);

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == k) {
                return m.getKey();
            }
        }
        return -1;
    }


    public static List<Integer> appearMoreThanOnce(int[] a) {
//        Map<Integer, Integer> map = frequency(a);
//
//        List<Integer> list = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
//            if (m.getValue() > 1) {
//                list.add(m.getKey());
//            }
//        }
//        return list;

        return Arrays.stream(a)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static boolean allFrequencyEven(int[] a) {
//        Map<Integer, Integer> map = frequency(a);
//
//        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
//            if (m.getValue() % 2 != 0) {
//                return false;
//            }
//        }
//        return true;
        return Arrays.stream(a)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .allMatch(x -> x.getValue() % 2 == 0);
    }

    /**
     * Element With Highest Frequency
     *
     * @param a
     * @return
     */
    public static int highestFrequency(int[] a) {
        Map<Integer, Integer> map = frequency(a);

        int maxValue = Integer.MIN_VALUE, maxKey = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > maxValue) {
                maxValue = m.getValue();
                maxKey = m.getKey();
            }
        }
        return maxKey;
    }
}
