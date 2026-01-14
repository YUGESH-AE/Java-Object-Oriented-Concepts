package com.yugesh.dsa.problems.algorithm._3_k_selection_sorting_Heap.Easy.sortingKSelection.leetcode;

import java.util.Arrays;

public class K_th_Selection_Sorting_1 {
    static void main() {

        int[] k_thLargestArr = {3, 2, 1, 5, 6, 4};
        System.out.println(kthLargestElement(k_thLargestArr, 2));

        int[] thirdMax = {1, 2};
        System.out.println(thirdMaximum(thirdMax));
    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #1
     * Kth Largest Element in an Array
     * (Source: LeetCode – Easy mindset)
     * 🧩 Problem Statement
     * You are given an integer array nums and an integer k.
     * Return the kth largest element in the array.
     * Important detail (this always trips people):
     * “kth largest” means not the kth distinct element
     * It is the element that would appear at index n - k after sorting in ascending order
     * 📥 Input
     * nums: an array of integers
     * k: an integer (1 ≤ k ≤ length of array)
     * 📤 Output
     * An integer: the kth largest element
     *
     * @param a
     * @param k
     * @return
     */
    public static int kthLargestElement(int[] a, int k) {
        Arrays.sort(a);
        return a[a.length - k];
    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #2
     * Third Maximum Number
     * (Source: LeetCode)
     * 🧩 Problem Statement
     * You are given an integer array nums.
     * Return the third distinct maximum number in this array.
     * If the third distinct maximum does not exist, return the maximum number.
     * 📥 Input
     * nums: integer array (may contain duplicates)
     * 📤 Output
     * An integer
     *
     * @param a
     * @return
     */
    public static int thirdMaximum(int[] a) {
        Integer max = null, secMax = null, thirdMax = null;

        for (int n : a) {
            if (n == (max == null ? null : max) ||
                    n == (secMax == null ? null : secMax) ||
                    n == (thirdMax == null ? null : thirdMax)) {
                continue; // skip duplicates
            }

            if (max == null || n > max) {
                thirdMax = secMax;
                secMax = max;
                max = n;
            } else if (secMax == null || n > secMax) {
                thirdMax = secMax;
                secMax = n;
            } else if (thirdMax == null || n > thirdMax) {
                thirdMax = n;
            }
        }

        return thirdMax == null ? max : thirdMax;
    }

}
