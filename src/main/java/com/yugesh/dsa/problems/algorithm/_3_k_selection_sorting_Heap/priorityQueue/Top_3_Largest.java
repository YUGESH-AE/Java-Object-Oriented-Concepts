package com.yugesh.dsa.problems.algorithm._3_k_selection_sorting_Heap.priorityQueue;

import java.util.PriorityQueue;

public class Top_3_Largest {
    static void main() {
        int[] a = {5, 1, 10, 3, 20, 8};
        top_3_largest(a, 3);
    }

    public static void top_3_largest(int[] a, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : a) {
            if (queue.size() < k) {
                queue.offer(num);                         // fill heap
            } else if (num > queue.peek()) {              // only if num is larger
                queue.poll();                             // remove smallest
                queue.offer(num);                         // add new number
            }
            // else: ignore num
        }

        System.out.println(queue); // contains top k largest elements
    }

}
