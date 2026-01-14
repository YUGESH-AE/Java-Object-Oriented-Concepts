package com.yugesh.dsa.problems.algorithm._3_k_selection_sorting_Heap.Easy.sortingKSelection.geeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedKSelection {

    public static void main(String[] args) {

        int[] diff = { 10, 3, 6, 8 };
        System.out.println(minimumDifferencePair(diff));

        int[] median = { 1, 2, 3, 4 };
        System.out.println(medianOfArray(median));

        int[] largeSecondLarge = { 10, 10, 10 };
        System.out.println(largestAndSecondLargest(largeSecondLarge));

        int[] minimumProductArray = { -1, -2, -3, 4 };
        System.out.println(minimumProduct(minimumProductArray));

        int[] kSmallestArray = { 7, 10, 4, 3, 20, 15 };
        System.out.println(kthSmallestElement(kSmallestArray, 3));

        int[] secondSmallestArray = { 10, 10, 10 };
        System.out.println(secondSmallest(secondSmallestArray));

        int[] thirdMax = {};
    }

    /**
     * 🧩 Problem Statement
     * Given an integer array arr[], find the minimum absolute difference between
     * any two elements in the array.
     * Return the minimum difference.
     * 📥 Input
     * arr[]: integer array (size ≥ 2)
     * 📤 Output
     * An integer representing the minimum absolute difference
     * 
     * @param a
     * @return
     */
    public static int minimumDifferencePair(int[] a) {
        if (a.length < 2)
            return -1;
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < a.length; i++) {
            min = Math.min(min, a[i] - a[i - 1]);
        }
        return min;
    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #10
     * Find the Median of an Array
     * (Source: GeeksForGeeks / HackerRank – basic version)
     * 🧩 Problem Statement
     * Given an integer array arr[], find the median of the array.
     * Definition reminder
     * If n is odd → median is the middle element after sorting
     * If n is even → median is the average of the two middle elements
     * 📥 Input
     * arr[]: integer array (size ≥ 1)
     * 📤 Output
     * If n is odd → return an integer
     * If n is even → return a double (or floor, depending on platform — assume
     * double here)
     * 
     * @param a
     * @return
     */
    public static double medianOfArray(int[] a) {
        if (a.length < 1)
            return 0.0;
        Arrays.sort(a);
        int mid = a.length / 2;
        if (a.length % 2 != 0) {
            return a[mid];
        } else {
            return (double) (a[mid - 1] + a[mid]) / 2;
        }
    }

    /**
     * 📌 Problem #12 (next new one)
     * Largest and Second Largest Element in an Array
     * (Source: GeeksForGeeks)
     * 🧩 Problem Statement
     * Given an array arr[] of size n, find:
     * the largest
     * the second largest distinct element
     * If the second largest element does not exist, return -1 for it.
     * 📥 Input
     * arr[]: integer array
     * 📤 Output
     * Two integers: (largest, secondLargest)
     * or (largest, -1) if second largest doesn’t exist
     * 
     * @param a
     * @return
     */
    public static List<Integer> largestAndSecondLargest(int[] a) {
        if (a.length == 0)
            return Collections.emptyList();

        List<Integer> list = new ArrayList<>();
        Arrays.sort(a);
        int largest = a[a.length - 1];
        list.add(largest);

        int secondLargest = -1;

        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] < largest) {
                secondLargest = a[i];
                break;
            }
        }
        list.add(secondLargest);
        return list;

    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #14
     * Minimum Product Pair
     * (Source: GeeksForGeeks)
     * 🧩 Problem Statement
     * Given an integer array arr[], find the minimum product of any pair of
     * elements in the array.
     * Return the minimum product.
     * 📥 Input
     * arr[]: integer array (size ≥ 2)
     * Elements may be positive, negative, or zero
     * 📤 Output
     * An integer (minimum product)
     * 🧪 Examples
     * Input: arr = [-1, -2, -3, 4]
     * Output: -12
     * Explanation:
     * (-3 * 4) = -12 is the minimum
     * 
     * @param a
     * @return
     */
    public static int minimumProduct(int[] a) {
        if (a.length < 2)
            return -1;

        int min = Integer.MAX_VALUE;
        Arrays.sort(a);
        min = Math.min(min, (a[0] * a[1]));
        min = Math.min(min, (a[0]) * a[a.length - 1]);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #15
     * Kth Smallest Element
     * (Source: GeeksForGeeks / LeetCode basic variant)
     * 🧩 Problem Statement
     * Given an integer array arr[] and an integer k, find the kth smallest element
     * in the array.
     * Elements may contain duplicates
     * k is 1-based (very important)
     * 📥 Input
     * arr[]: integer array
     * k: integer (1 ≤ k ≤ arr.length)
     * 📤 Output
     * An integer (the kth smallest element)
     * 
     * @param a
     * @param k
     * @return
     */
    public static int kthSmallestElement(int[] a, int k) {
        Arrays.sort(a);

        return a[k - 1];
    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #16
     * Second Smallest Element in an Array
     * (Source: GeeksForGeeks)
     * 🧩 Problem Statement
     * Given an integer array arr[], find the second smallest distinct element in
     * the array.
     * If the second smallest element does not exist, return -1.
     * 📥 Input
     * arr[]: integer array (size ≥ 1)
     * 📤 Output
     * Integer (second smallest distinct element or -1)
     * 
     * @param a
     * @return
     */
    public static int secondSmallest(int[] a) {
        if (a.length < 1)
            return -1;

        Arrays.sort(a);
        int smallest = a[0];

        for (int i = 1; i < a.length; i++) {
            if (smallest < a[i]) {
                return a[i];
            }
        }
        return -1;
    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #18
     * Third Maximum Number (Revisited — Simplified Variant)
     * (Source: Codeforces / practice variant)
     * This is a lighter variant than the earlier LeetCode one, meant to reinforce
     * distinct handling.
     * 🧩 Problem Statement
     * Given an integer array arr[], find the third largest distinct element.
     * If fewer than three distinct elements exist, return -1.
     * 📥 Input
     * arr[]: integer array
     * 📤 Output
     * Integer (third largest distinct element or -1)
     * 
     * @param a
     * @return
     */
    public static int thirdMaximumElement(int[] a) {
        if (a.length < 3)
            return -1;

        Arrays.sort(a);
        int distinctCount = 1;
        int prev = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] != prev) {
                distinctCount++;
                prev = a[i];
                if (distinctCount == 3) {
                    return prev;
                }
            }
        }
        return -1;

    }

    public static int secondLargest(int[] a) {
        if (a.length < 2)
            return -1;
        Arrays.sort(a);

        int max = a[a.length - 1];

        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] < max) {
                return a[i];
            }
        }
        return -1;
    }
}
