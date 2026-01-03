package com.yugesh.dsa.problems.algorithm._2_frequencyMap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class K_MostFrequent {
    static void main() {

        int[] a = {1, 1, 1, 2, 2, 3};

        System.out.println(frequent(a, 2));
    }

    public static List<Integer> frequent(int[] a, int k) {

        Map<Integer, Long> map = Arrays.stream(a)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        List<Integer> list = new ArrayList<>();

        PriorityQueue<Map.Entry<Integer, Long>> q = new PriorityQueue<>(Comparator.comparingLong(Map.Entry::getValue));

        for (Map.Entry<Integer, Long> m : map.entrySet()) {
            q.offer(m);
            if (q.size() > k) {
                q.poll();
            }
        }

        while (q.size() != 0) {
            list.add(q.poll().getKey());
        }


        return list;
    }
}
