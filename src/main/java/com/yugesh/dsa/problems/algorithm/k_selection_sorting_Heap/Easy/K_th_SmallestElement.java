package com.yugesh.dsa.problems.algorithm.k_selection_sorting_Heap.Easy;

import java.util.*;

public class K_th_SmallestElement {

    static void main() {

        int[] a = {7, 10, 4, 3, 20, 15};

        System.out.println(smallest(a, 3));

        int[] b = {3, 2, 1, 5, 6, 4};

        System.out.println(k_largest(b, 3));

        int[] c = {1, 1, 1, 2, 2, 3};
        System.out.println(topKFrequentElement(c, 2));

        int[] d = {5, 6, 7, 8, 9};
        System.out.println(kClosestToX(d, 3, 7));
    }

    public static int smallest(int[] a, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : a) {
            priorityQueue.offer(i);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.peek();
    }

    public static List<Integer> k_largest(int[] a, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : a) {
            priorityQueue.offer(i);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            list.add(priorityQueue.poll());
        }
        return list;
    }

    public static List<Integer> topKFrequentElement(int[] a, int k) {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.compute(i, (key, value) -> value != null ? value + 1 : 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
                new PriorityQueue<>(
//                        Map.Entry.comparingByValue()
                        (v1, v2) ->
                                v1.getValue() - v2.getValue()
                );

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            priorityQueue.offer(m);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        while (!priorityQueue.isEmpty()) {
            list.add(priorityQueue.poll().getKey());
        }
        return list;
    }

    //important
    //K closest numbers to X
    public static List<Integer> kClosestToX(int[] a, int k, int x) {

        List<Integer> list = new ArrayList<>();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (v1, v2) -> Math.abs(v2 - x) - Math.abs(v1 - x)
        );
        for (int i : a) {
            priorityQueue.offer(i);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        while (!priorityQueue.isEmpty()) {
            list.add(priorityQueue.poll());
        }
        return list;
    }

//    public int[][] kClosestToOrigin(int[][]a,int k){
//
//        PriorityQueue<int[][]>priorityQueue=
//                new PriorityQueue<>((x1,y1),(x2,y2)->);
//    }
}
