package com.yugesh.dsa.problems.algorithm._3_k_selection_sorting_Heap.Easy.geeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K_th_Selection_Sorting_1 {
    static void main() {

        int[] kLargestArr = {1, 23, 12, 9, 30, 2, 50};
        System.out.println(kLargest(kLargestArr, 3));

        int[] secondMaxArr = {10, 10, 10};
        System.out.println(secondLargest(secondMaxArr));
    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #3
     * K Largest Elements
     * (Source: GeeksForGeeks)
     * 🧩 Problem Statement
     * You are given an array arr[] of size n and an integer k.
     * Print the k largest elements from the array.
     * Order of output does not matter
     * Elements may contain duplicates
     * Easy-level intent: sorting-based solution is acceptable
     * 📥 Input
     * arr[]: integer array
     * k: integer (1 ≤ k ≤ n)
     * 📤 Output
     * k integers representing the largest elements
     *
     * @param a
     * @param k
     * @return
     */
    public static List<Integer> kLargest(int[] a, int k) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(a);
        for (int i = a.length - k; i < a.length; i++) {
            list.add(a[i]);
        }
        return list;
    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #4
     * Second Largest Element in an Array
     * (Source: GeeksForGeeks)
     * 🧩 Problem Statement
     * Given an array arr[] of size n, find the second largest distinct element in the array.
     * If the second largest element does not exist, return -1.
     * 📥 Input
     * arr[]: integer array
     * n: size of array
     * 📤 Output
     * An integer (second largest distinct element or -1)
     * 🧪 Examples
     * Input:
     * arr = [12, 35, 1, 10, 34, 1]
     * Output:
     * 34
     * Input:
     * arr = [10, 10, 10]
     * Output:
     * -1
     * Input:
     * arr = [10]
     * Output:
     * -1
     *
     * @param a
     * @return
     */
    public static int secondLargest(int[] a) {
        if (a.length < 2) return -1;
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
