package com.yugesh.dsa.problems.algorithm._3_k_selection_sorting_Heap.Easy.heap.geeksForGeeks;

import java.util.*;

public class Heap_1 {

    static void main() {

        int[] largestArr = {4, 5, 8, 2, 10, 9};
        System.out.println(kthLargestStream(largestArr, 3));
    }

    /**
     * Problem name: K Largest Elements
     * Platform: GeeksforGeeks
     * List position: GeeksforGeeks (Heap EASY) — #3
     * 🧩 Problem Statement (precise)
     * Given an array of integers and a number k,
     * find the k largest elements in the array.
     * Order of output does not matter (unless specified)
     * Focus is on heap usage, not full sorting
     *
     * @param a
     * @param k
     * @return
     */
    public static List<Integer> kLargest(int[] a, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();

        for (int i : a) {
            p.offer(i);
            if (p.size() > k) {
                p.poll();
            }
        }

        while (!p.isEmpty()) {
            list.add(p.poll());
        }
        return list;
    }

    /**
     * ✅ Completed
     * K Largest Elements
     * Platform: GeeksforGeeks
     * Pattern: Heap (min-heap, size-k)
     * ▶️ Next Problem (Heap — EASY)
     * Problem name: Kth Largest Element in a Stream
     * Platform: GeeksforGeeks
     * List position: GeeksforGeeks (Heap EASY) — #4
     * You already solved the LeetCode version earlier — this one is the same invariant, just streamed input.
     *
     * @param a
     * @param k
     * @return
     */
    public static List<Integer> kthLargestStream(int[] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for (int num : a) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }

            if (pq.size() < k) {
                result.add(-1);
            } else {
                result.add(pq.peek());
            }
        }

        return result;
    }

    /**
     * ▶️ Next Problem (Heap — EASY)
     * Problem name: Merge Two Binary Max Heaps
     * Platform: GeeksforGeeks
     * List position: GeeksforGeeks (Heap EASY) — #6
     * 🧩 Problem Statement
     * You are given two binary max heaps represented as arrays.
     * Your task is to:
     * Merge them into one valid max heap
     * Return the resulting heap array
     * You do not need to maintain order between the two arrays —
     * only the max-heap property must hold in the final result.
     *
     * @param a
     * @param b
     * @return
     */
    public static List<Integer> mergeTwoBinary(int[] a, int[] b) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> list = new ArrayList<>();
        for (int i : a) {
            p.offer(i);
        }
        for (int i : b) {
            p.offer(i);
        }
        while (!p.isEmpty()) {
            list.add(p.poll());
        }
        return list;
    }

    /**
     * 🧩 Problem Statement (simple + exact)
     * <p>
     * You are given 4 integers, each representing a horseshoe color.
     * You want all 4 colors to be different.
     * <p>
     * In one move, you can replace any one horseshoe with a new color.
     * <p>
     * 👉 Return the minimum number of moves required.
     *
     * @param a
     * @return
     */
    public static int horseshoeMoves(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int x : a) {
            set.add(x);
        }
        return a.length - set.size();
    }


}
