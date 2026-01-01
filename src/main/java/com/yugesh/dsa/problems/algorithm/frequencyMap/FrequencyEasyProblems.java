package com.yugesh.dsa.problems.algorithm.frequencyMap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FrequencyEasyProblems {

    static void main() {

        int[] a = {4, 6, 2, 6, 4, 6, 2};

        System.out.println(elementAppearingKTimes(a, 2));
        System.out.println(appearMoreThanOnce(a));
        System.out.println(highestFrequency(a));

    }

    public static Map<Integer, Integer> frequency(int[] a) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : a) {
            map.compute(i, (k, v) -> v != null ? v + 1 : 1);
        }
        return map;
    }

    public static int elementAppearingKTimes(int[] a, int k) {
        Map<Integer, Integer> map = frequency(a);

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == k) {
                return m.getKey();
            }
        }
        return -1;
    }

    public static List<Integer> appearMoreThanOnce(int[] a) {
        Map<Integer, Integer> map = frequency(a);

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > 1) {
                list.add(m.getKey());
            }
        }
        return list;
    }

    public static boolean allFrequencyEven(int[] a) {
        Map<Integer, Integer> map = frequency(a);

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static int highestFrequency(int[] a) {
        Map<Integer, Integer> map = frequency(a);

        int maxValue = Integer.MIN_VALUE, maxKey = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > maxValue) {
                maxValue = m.getValue();
                maxKey = m.getKey();
            }
        }
        return maxKey;
    }
}
