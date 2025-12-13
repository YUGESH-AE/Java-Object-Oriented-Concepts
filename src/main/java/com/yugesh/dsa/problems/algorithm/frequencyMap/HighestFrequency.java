package com.yugesh.dsa.problems.algorithm.frequencyMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class HighestFrequency {
    static void main() {

        int[] a = {4, 5, 4, 5, 4, 6, 5};

        System.out.println(higher(a));

    }

    public static int higher(int[] a) {
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

        int maxFrequency = 0, result = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
