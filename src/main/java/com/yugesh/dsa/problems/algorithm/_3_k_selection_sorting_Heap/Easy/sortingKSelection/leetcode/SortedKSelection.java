package com.yugesh.dsa.problems.algorithm._3_k_selection_sorting_Heap.Easy.sortingKSelection.leetcode;

import java.util.Arrays;

public class SortedKSelection {

    public static void main(String[] args) {

        int[] a = { 1, 1, 4, 2, 1, 3 };
        System.out.println(heightChecker(a));

        int[] maxiA = { 3, 4, 5, 2 };
        System.out.println(maximumProductTowNumbers(maxiA));

        int[] avgSalary = { 1000, 2000, 3000 };
        System.out.println(averageSalary(avgSalary));

        int[] largestTwice = { 3, 6, 1, 0 };
        System.out.println(largestAtLeastTwice(largestTwice));
    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #6
     * Height Checker
     * (Source: LeetCode)
     * 🧩 Problem Statement
     * You are given an array heights representing the heights of students standing
     * in a line.
     * A student is considered out of place if their height does not match the
     * expected height after sorting the array in non-decreasing order.
     * Return the number of students who are out of place.
     * 📥 Input
     * heights: integer array
     * 📤 Output
     * Integer count
     * 🧪 Example
     * Input: heights = [1,1,4,2,1,3]
     * Sorted: [1,1,1,2,3,4]
     * Out of place at indices: 2, 4, 5
     * Output: 3
     * 
     * @param a
     * @return
     */
    public static int heightChecker(int[] a) {
        int[] sort = Arrays.copyOf(a, a.length);
        Arrays.sort(sort);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != sort[i]) {
                count++;
            }
        }
        return count;

    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #7
     * Maximum Product of Two Elements in an Array
     * (Source: LeetCode)
     * 🧩 Problem Statement
     * You are given an integer array nums.
     * Choose two different elements i and j such that:
     * 📥 Input
     * nums: integer array (length ≥ 2)
     * 📤 Output
     * An integer (maximum product)
     * (nums[i] - 1) * (nums[j] - 1)
     * 
     * @param a
     * @return
     */
    public static int maximumProductTowNumbers(int[] a) {
        if (!(a.length >= 2))
            return -1;
        Arrays.sort(a);
        int num1 = a[a.length - 1];
        int num2 = a[a.length - 2];

        return ((num1 - 1) * (num2 - 1));
    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #8
     * Average Salary Excluding the Minimum and Maximum Salary
     * (Source: LeetCode)
     * 🧩 Problem Statement
     * You are given an array salary where salary[i] is the salary of the i-th
     * employee.
     * Return the average salary of employees excluding:
     * the minimum salary
     * the maximum salary
     * 📥 Input
     * salary: integer array
     * Length of array ≥ 3
     * 📤 Output
     * A double representing the average value
     * 🧪 Example
     * Input: salary = [4000,3000,1000,2000]
     * Sorted: [1000,2000,3000,4000]
     * Exclude min & max → [2000,3000]
     * Average = (2000 + 3000) / 2 = 2500.0
     * Input: salary = [1000,2000,3000]
     * Output: 2000.0
     * 🧠 Invariant-first thinking
     * After sorting:
     * salary[0] → minimum
     * salary[n-1] → maximum
     * salary[1..n-2] → valid salaries
     * 
     * @param a
     * @return
     */
    public static double averageSalary(int[] a) {
        if (!(a.length >= 3))
            return 0.0;

        Arrays.sort(a);
        int count = 0;
        double sum = 0;
        for (int i = 1; i < a.length - 1; i++) {
            sum += a[i];
            count++;
        }
        return sum / count;
    }

    /**
     * 🟦 Pattern: Sorting + K-selection
     * 📌 Problem #11
     * Largest Number At Least Twice of Others
     * (Source: LeetCode)
     * 🧩 Problem Statement
     * You are given an integer array nums.
     * Return the index of the largest element if it is at least twice as large as
     * every other number in the array.
     * If it is not, return -1.
     * 📥 Input
     * nums: integer array (size ≥ 1)
     * 📤 Output
     * Integer index (from the original array), or -1
     * 🧪 Examples
     * Input: nums = [3, 6, 1, 0]
     * Output: 1
     * Explanation:
     * Largest = 6
     * All others ≤ 3 → 6 ≥ 2×3 ✔
     * Index of 6 in original array = 1
     * Input: nums = [1, 2, 3, 4]
     * Output: -1
     * Explanation:
     * Largest = 4
     * Second largest = 3 → 4 < 2×3
     * 
     * @param a
     * @return
     */
    public static int largestAtLeastTwice(int[] a) {
        if (a.length == 0)
            return -1;

        int[] sorted = Arrays.copyOf(a, a.length);
        Arrays.sort(sorted);

        int max = sorted[sorted.length - 1];
        int secondMax = sorted.length > 1 ? sorted[sorted.length - 2] : 0;

        if (max < 2 * secondMax)
            return -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) {
                return i;
            }
        }
        return -1;
    }
}
