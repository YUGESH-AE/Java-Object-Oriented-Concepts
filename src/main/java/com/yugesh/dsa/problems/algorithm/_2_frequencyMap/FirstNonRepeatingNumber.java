package com.yugesh.dsa.problems.algorithm._2_frequencyMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingNumber {

    static void main() {
        int[] a = {4, 5, 1, 2, 0, 4};

        firstNonRepeating(a);

        int[] b = {4, 5, 4, 5, 7, 8, 8};
        System.out.println(firstNonRepeatingNum(b));

    }

    public static void firstNonRepeating(int[] a) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                int value = map.get(a[i]);
                map.replace(a[i], value + 1);
            } else {
                map.put(a[i], 1);
            }
        }
        System.out.println(map);
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() == 1) {
                System.out.println("First non repeating: " + i.getKey());
                return;
            }
        }
    }

    public static int firstNonRepeatingNum(int[] b) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : b) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) {
                return m.getKey();
            }
        }
        return 0;
    }
}
