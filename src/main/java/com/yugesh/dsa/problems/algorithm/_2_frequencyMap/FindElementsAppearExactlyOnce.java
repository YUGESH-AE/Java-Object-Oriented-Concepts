package com.yugesh.dsa.problems.algorithm._2_frequencyMap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindElementsAppearExactlyOnce {
    static void main() {

        int[] a = {1, 2, 2, 3, 4, 4, 5};
        findExactlyOne(a);

        int[] e = {6, 2, 5, 2, 2, 6, 6};
        System.out.println(exactlyOnce(e, 3));


    }

    public static void findExactlyOne(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                int value = map.get(a[i]);
                map.replace(a[i], value + 1);
            } else {
                map.put(a[i], 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() == 1) {
                list.add(i.getKey());
            }
        }
        System.out.println(list);
    }

    public static int exactlyOnce(int[] e, int k) {
        if (e == null || e.length == 0) return -1;
        if (e.length == 1) return e[0];
        Map<Integer, Long> map = Arrays.stream(e)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );
        for (Map.Entry<Integer, Long> m : map.entrySet()) {
            if (m.getValue() % k != 0) {
                return m.getKey();
            }
        }
        return -1;
    }

}
