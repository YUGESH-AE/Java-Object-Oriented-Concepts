package com.yugesh.dsa.problems.algorithm._2_frequencyMap.easy.leetcode;

import java.util.*;

public class FrequencyMap_3 {
    static void main() {

        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(relativeSort(arr1, arr2));

        System.out.println(pangram("leetcode"));
    }

    /**
     * 🧩 Problem 14 — Relative Sort Array
     * Source: LeetCode
     * 📌 Problem Statement (clean)
     * You are given two integer arrays arr1 and arr2.
     * All elements of arr2 are distinct
     * All elements of arr2 appear in arr1
     * Sort arr1 so that:
     * Elements that appear in arr2 come first, in the same order as arr2
     * Remaining elements (not in arr2) come after, in ascending order
     * Return the sorted array.
     * 🧪 Examples
     * Input:
     * arr1 = [2,3,1,3,2,4,6,7,9,2,19]
     * arr2 = [2,1,4,3,9,6]
     * Output:
     * [2,2,2,1,4,3,3,9,6,7,19]
     * 🧠 Pattern
     * Frequency Map — EASY (priority ordering + leftovers)
     * This problem mixes:
     * Counting
     * External order control
     * Leftover sorting
     * Still Frequency Map — just with a twist.
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static List<Integer> relativeSort(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> arr1Map = new TreeMap<>();
        for (int i : arr1) {
            arr1Map.put(i, arr1Map.getOrDefault(i, 0) + 1);
        }

        for (int j : arr2) {
            if (arr1Map.containsKey(j)) {
                int value = arr1Map.get(j);
                while (value != 0) {
                    list.add(j);
                    value--;
                }
                arr1Map.remove(j);
            }
        }
        for (Map.Entry<Integer, Integer> m : arr1Map.entrySet()) {

            int key = m.getKey();
            int value = m.getValue();
            while (value != 0) {
                list.add(key);
                value--;
            }
        }
        return list;
    }

    /**
     * 🧩 Problem 15 — Check if the Sentence Is Pangram
     * Source: LeetCode
     * 📌 Problem Statement (clean)
     * A pangram is a sentence that contains every letter of the English alphabet at least once.
     * You are given a string sentence containing only lowercase English letters.
     * Return true if it is a pangram, otherwise false.
     * 🧩 Problem 15 — Check if the Sentence Is Pangram
     * Source: LeetCode
     * 📌 Problem Statement (clean)
     * A pangram is a sentence that contains every letter of the English alphabet at least once.
     * You are given a string sentence containing only lowercase English letters.
     * Return true if it is a pangram, otherwise false.
     *
     * @param s
     * @return
     */
    public static boolean pangram(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size() == 26;
    }
}
