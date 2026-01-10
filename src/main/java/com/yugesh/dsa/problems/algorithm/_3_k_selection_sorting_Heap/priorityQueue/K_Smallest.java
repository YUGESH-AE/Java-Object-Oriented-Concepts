package com.yugesh.dsa.problems.algorithm._3_k_selection_sorting_Heap.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class K_Smallest {
    static void main() {

        int[] a = {7, 2, 10, 4, 6, 1};
        k_smallest(a, 3);
        int[] d = {7, 2, 10, 4, 6, 1};
        System.out.println(getKthSmallest(d, 3));

        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(kth_smallest(arr, 3));
    }

    public static void k_smallest(int[] a, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : a) {
            if (queue.size() < k) {
                queue.offer(i);
            } else if (i < queue.peek()) {
                queue.poll();
                queue.offer(i);
            }
        }
        System.out.println(queue);
    }

    public static PriorityQueue<Integer> getKthSmallest(int[] d, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : d) {
            if (q.size() < k) {
                q.offer(i);
            } else if (i < q.peek()) {
                q.poll();
                q.offer(i);
            }
        }
        return q;
    }

    public static int kth_smallest(int[] a, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : a) {
            q.offer(i);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }
}
