package com.yugesh.dsa.problems.algorithm.k_selection_sorting.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class K_Smallest {
    static void main() {

        int[]a={7, 2, 10, 4, 6, 1};
        k_smallest(a,3);
    }
    public static void k_smallest(int []a, int k){
        PriorityQueue<Integer>queue=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i:a){
            if(queue.size()<k){
                queue.offer(i);
            } else if (i<queue.peek()) {
                queue.poll();
                queue.offer(i);
            }
        }
        System.out.println(queue);
    }
}
