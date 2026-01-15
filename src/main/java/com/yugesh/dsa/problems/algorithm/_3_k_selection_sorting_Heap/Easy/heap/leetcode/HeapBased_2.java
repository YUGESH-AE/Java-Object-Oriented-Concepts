package com.yugesh.dsa.problems.algorithm._3_k_selection_sorting_Heap.Easy.heap.leetcode;

import java.util.*;

public class HeapBased_2 {
    static void main() {

        int[] a = {5, -2, 4, 1, 3};
        System.out.println(subsequenceOfLengthK(a, 2));

        int[] mul = {1, 2, 5};
        System.out.println(maximumProductOfKElement(mul, 4));
    }

    /**
     * Problem name: Find Subsequence of Length K With the Largest Sum
     * Platform: LeetCode
     * List position: LeetCode (Heap EASY) — #5
     * 🧩 Problem Statement (precise intent)
     * You are given an integer array nums and an integer k.
     * You must return a subsequence of length k such that:
     * The sum is maximum
     * The original order is preserved (this is important)
     * A subsequence is formed by deleting elements without changing order.
     *
     * @param a
     * @param k
     * @return
     */
    public static List<Integer> subsequenceOfLengthK(int[] a, int k) {
        // Phase 1: select k largest values
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : a) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Count selected values
        Map<Integer, Integer> freq = new HashMap<>();
        while (!pq.isEmpty()) {
            int val = pq.poll();
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }

        // Phase 2: reconstruct subsequence in original order
        List<Integer> result = new ArrayList<>();
        for (int num : a) {
            if (freq.getOrDefault(num, 0) > 0) {
                result.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        return result;
    }

    /**
     * ▶️ Next Problem (Heap — EASY)
     * Problem name: Maximum Product After K Increments
     * Platform: LeetCode
     * List position: LeetCode (Heap EASY) — #6
     * 🧩 Problem Statement (clear + minimal)
     * You are given:
     * An integer array nums
     * An integer k
     * You can perform the following operation exactly k times:
     * Choose any index i
     * Increment nums[i] by 1
     * After all operations, return the maximum possible product of all elements in the array.
     * (Answer is usually asked modulo 1_000_000_007, but focus on logic first.)
     *
     * @param a
     * @param k
     * @return
     */
    public static int maximumProductOfKElement(int[] a, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for (int i : a) {
            p.offer(i);
        }
        while (k != 0) {
            int value = p.poll();
            p.offer(value + 1);
            k--;
        }
        int mul = 1;
        while (!p.isEmpty()) {
            mul *= p.poll();
        }
        return mul;
    }

}
