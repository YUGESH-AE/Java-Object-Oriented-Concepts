package com.yugesh.dsa.problems.algorithm._3_k_selection_sorting_Heap.Easy.sortingKSelection.hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedKSelection {

    public static void main(String[] args) {

        int[] minDiff = { 4, 2, 1, 3 };
        System.out.println(minimumAbsDiffPair(minDiff));

        int[] toyArray = { 1, 12, 5, 111, 200, 1000, 10 };
        System.out.println(markToys(toyArray, 50));

        String[] s = { "31415926535897932384626433832795",
                "1",
                "3",
                "10",
                "3",
                "5" };
        System.out.println(sortLarge(s));
    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #20
     * Closest Numbers
     * (Source: HackerRank)
     * 🧩 Problem Statement
     * Given an integer array arr[], find all pairs of elements that have the
     * minimum absolute difference between them.
     * Return the pairs in ascending order.
     * 📥 Input
     * arr[]: integer array (size ≥ 2)
     * 📤 Output
     * A list of integers representing pairs
     * (each pair printed as a b, flattened as [a, b, c, d, ...] depending on
     * platform)
     * 
     * @param a
     * @return
     */
    public static List<Integer> minimumAbsDiffPair(int[] a) {
        if (a.length < 2)
            throw new IllegalArgumentException("Size should be gretaer than or equal two");
        int min = Integer.MAX_VALUE;
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) {
            int diff = a[i] - a[i - 1];
            min = Math.min(min, diff);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < a.length; i++) {
            int diff = a[i] - a[i - 1];
            if (diff == min) {
                list.add(a[i - 1]);
                list.add(a[i]);
            }
        }
        return list;
    }

    /**
     * Problem #21
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #21
     * Mark and Toys
     * (Source: HackerRank)
     * 🧩 Problem Statement
     * You are given:
     * An array prices[] where prices[i] is the price of the i-th toy
     * An integer k representing the amount of money you have
     * You want to buy as many toys as possible without exceeding k.
     * Return the maximum number of toys you can buy.
     * 📥 Input
     * prices[]: integer array
     * k: integer (budget)
     * 📤 Output
     * Integer (maximum number of toys)
     * 
     * @param a
     * @param k
     * @return
     */
    public static int markToys(int[] a, int k) {
        Arrays.sort(a);
        int count = 0;
        for (int j : a) {
            k -= j;
            if (k >= 0) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #22
     * Big Sorting
     * (Source: HackerRank)
     * 🧩 Problem Statement
     * You are given an array of very large numbers, represented as strings.
     * Your task is to sort these numbers in ascending numerical order and print
     * them.
     * 
     * @param s
     * @return
     */
    public static List<String> sortLarge(String[] s) {
        List<String> list = new ArrayList<>(Arrays.asList(s));

        list.sort((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        return list;
    }
}
