package com.yugesh.dsa.problems.algorithm._3_k_selection_sorting_Heap.Easy.heap.leetcode;

import java.util.*;

public class HeapBased {
    static void main() {

        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones));

        int[] kTHArr = {4, 5, 8, 2};
        System.out.println(kthLargestElement(kTHArr, 3));

        int[] ranks = {10, 3, 8, 9, 4};
        System.out.println(relativeRanks(ranks));

        int[] costOfRopesArr = {4, 3, 2, 6};
        System.out.println(minimumCostOfRopes(costOfRopesArr));

        int[] candies = {6, 5, 7, 9, 2, 2};
        System.out.println(minimumCostOfCandies(candies));
    }

    /**
     * 🟩 Heap — EASY
     * 📌 Problem #1
     * Last Stone Weight
     * (Source: LeetCode)
     * 🧩 Problem Statement
     * You are given an array stones[], where each element represents the weight of a stone.
     * You repeatedly perform the following operation:
     * Take the two heaviest stones
     * Smash them together:
     * If weights are equal → both destroyed
     * If weights differ → the heavier stone is reduced by the lighter one
     * Put the remaining stone (if any) back
     * Repeat until at most one stone remains.
     * Return the weight of the last remaining stone, or 0 if none remain.
     * 📥 Input
     * stones[]: integer array
     * 📤 Output
     * Integer (weight of last stone or 0)
     *
     * @param stones
     * @return
     */
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int max = maxHeap.poll();
            int secondMax = maxHeap.poll();

            int diff = max - secondMax;
            if (diff > 0) {
                maxHeap.offer(diff);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    /**
     * 🟩 Heap Pattern — EASY
     * 📌 Problem #2
     * Kth Largest Element in a Stream
     * (Source: LeetCode)
     * 🧩 Problem Statement
     * You are given:
     * An integer k
     * An initial array nums[]
     * You will receive a stream of integers one by one.
     * After each insertion, return the kth largest element seen so far.
     *
     * @param a
     * @param k
     * @return
     */
    public static int kthLargestElement(int[] a, int k) {

        PriorityQueue<Integer> p = new PriorityQueue<>();

        for (int i : a) {
            p.offer(i);
            if (p.size() > k) {
                p.poll();
            }
        }
        return p.peek();
    }

    /**
     * Heap EASY — Problem #3
     * Relative Ranks
     * You are given an integer array score where score[i] represents the score of the i-th athlete.
     * All scores are unique.
     * Your task is to return an array answer of the same length such that:
     * The athlete with the highest score gets "Gold Medal"
     * The second highest gets "Silver Medal"
     * The third highest gets "Bronze Medal"
     * All others get their rank number as a string ("4", "5", …)
     * The ranking is based only on score, but the result must be placed back in the original order of athletes.
     *
     * @param ranks
     * @return
     */
    public static List<String> relativeRanks(int[] ranks) {
        int n = ranks.length;

        // Result list with fixed size
        List<String> result = new ArrayList<>(Collections.nCopies(n, ""));

        // Map score -> original index
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(ranks[i], i);
        }

        // Max heap of scores
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Comparator.reverseOrder());
        for (int score : ranks) {
            maxHeap.offer(score);
        }

        int rank = 1;

        while (!maxHeap.isEmpty()) {
            int score = maxHeap.poll();
            int idx = indexMap.get(score);

            if (rank == 1) {
                result.set(idx, "Gold Medal");
            } else if (rank == 2) {
                result.set(idx, "Silver Medal");
            } else if (rank == 3) {
                result.set(idx, "Bronze Medal");
            } else {
                result.set(idx, String.valueOf(rank));
            }

            rank++;
        }

        return result;
    }

    /**
     * 🧩 Problem Statement (verbatim logic, simplified)
     * You are given N ropes, each with a certain length.
     * You need to connect all the ropes into one rope.
     * Cost of connecting two ropes = sum of their lengths.
     * After connecting, the new rope can again be connected with others.
     * 👉 Find the minimum total cost required to connect all ropes.
     *
     * @param a
     * @return
     */
    public static int minimumCostOfRopes(int[] a) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int i : a) {
            p.offer(i);
        }

        int sum = 0;
        while (p.size() > 1) {
            int min1 = p.poll();
            int min2 = p.poll();
            int v = min2 + min1;
            sum += v;
            p.offer(v);
        }
        return sum;
    }

    /**
     * 🧩 Problem Statement (clean, exact intent)
     * You are given an integer array cost where cost[i] is the price of the i-th candy.
     * There is a discount rule:
     * For every 3 candies you buy, you get the cheapest one free.
     * You may buy the candies in any order.
     * 👉 Return the minimum total cost to buy all candies.
     *
     * @param a
     * @return
     */
    public static int minimumCostOfCandies(int[] a) {

        PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : a) {
            p.offer(i);
        }

        int sum = 0;

        while (p.size() >= 3) {
            int first = p.poll();
            int second = p.poll();
            p.poll();
            sum += first + second;
        }
        while (!p.isEmpty()) {
            sum += p.poll();
        }

        return sum;
    }


}


