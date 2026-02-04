package com.yugesh.dsa.problems.algorithm._2_frequencyMap.easy.geeksForGeeks;

import java.util.*;

public class FrequencyMap_1 {
    static void main() {

        int[] arrRepeating = {1, 5, 3, 4, 3, 5, 6};
        System.out.println(firstRepeating(arrRepeating));

        int[] arrNonRepeating = {9, 4, 9, 6, 7, 4};
        System.out.println(firstNonRepeating(arrNonRepeating));

        int[] arrMajority = {3, 1, 3, 3, 2};
        System.out.println(majorityElement(arrMajority));

        int[] arr1 = {1, 2, 5, 4, 0};
        int[] arr2 = {2, 4, 5, 0, 1};
        System.out.println(arraysEqual(arr1, arr2));

        int[] duplicateArr = {1, 2, 3, 6, 3, 6, 1};
        System.out.println(findDuplicate(duplicateArr));
    }

    /**
     * 🧩 GFG — Problem 2
     * First Repeating Element
     * Source: GeeksforGeeks
     * 📌 Problem Statement (clean)
     * Given an array of integers, find the first element that repeats.
     * “First” means the element whose first occurrence index is smallest
     * If no element repeats, return -1
     *
     * @param arr
     * @return
     */
    public static int firstRepeating(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : arr) {
            map.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > 1) {
                return m.getKey();
            }
        }
        return -1;
    }

    /**
     * 🧩 GFG — Problem 3
     * First Non-Repeating Element
     * Source: GeeksforGeeks
     * 📌 Problem Statement (clean)
     * Given an array of integers, find the first element that does NOT repeat.
     * “First” means the element whose index of occurrence is smallest
     * If no such element exists, return -1
     *
     * @param arr
     * @return
     */
    public static int firstNonRepeating(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : arr) {
            map.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == 1) {
                return m.getKey();
            }
        }
        return -1;
    }

    /**
     * 🧩 GFG — Problem 4
     * Majority Element
     * Source: GeeksforGeeks
     * 📌 Problem Statement (clean)
     * Given an array of integers of size n, find the majority element.
     * A majority element is an element that appears more than ⌊n / 2⌋ times
     * If no such element exists, return -1
     * ⚠️ This is the key difference from the LeetCode version:
     * a majority element may NOT exist here.
     * Input:  [3, 1, 3, 3, 2]
     * Output: 3
     * Explanation:
     * 3 appears 3 times, n = 5, ⌊n/2⌋ = 2 → 3 > 2
     *
     * @param a
     * @return
     */
    public static int majorityElement(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : a) {
            map.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }
        int v = a.length / 2;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > v) {
                return m.getKey();
            }
        }
        return -1;
    }

    /**
     * 🧩 GFG — Problem 5
     * Check if Two Arrays are Equal or Not
     * Source: GeeksforGeeks
     * 📌 Problem Statement (clean)
     * Given two integer arrays arr1 and arr2 of the same size, determine whether they are equal.
     * Two arrays are considered equal if:
     * They contain the same elements
     * With the same frequencies
     * Order does NOT matter
     * Return true if they are equal, otherwise false.
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean arraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr1) {
            map.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }

        for (int i : arr2) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    /**
     * 🧩 GFG — Problem 6
     * Find Duplicate Elements in an Array
     * Source: GeeksforGeeks
     * 📌 Problem Statement (clean)
     * Given an array of integers, find all elements that appear more than once.
     * Return the duplicate elements
     * If no duplicates exist, return an empty result (or -1 depending on variant)
     * Order of output usually doesn’t matter unless stated
     *
     * @param a
     * @return
     */
    public static List<Integer> findDuplicate(int[] a) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.compute(i, (k, v) -> v == null ? 1 : v + 1);
        }
        for (Map.Entry<Integer, Integer> ma : map.entrySet()) {
            if (ma.getValue() > 1) {
                list.add(ma.getKey());
            }
        }
        return list;
    }

    /**
     * 🧩 Counting Elements in Two Arrays
     * (appears on multiple platforms in slightly different wording)
     * 📌 Problem Statement (canonical form)
     * You are given two integer arrays A and B.
     * For each element in A, determine how many times it appears in B, and compute the total count.
     * In other words:
     * For every x in A, add frequency of x in B to the answer.
     * @param a
     * @param b
     * @return
     */
    public static  int countingElementInArray(int[]a,int[]b){

            Map<Integer,Integer> map =new HashMap<>();

            for(int i:b){
                map.put(i,map.getOrDefault(i,0)+1);
            }
            int count=0;
            for(int i:a){
                if(map.containsKey(i)){
                    count+=map.get(i);
                }
            }
            return count;

    }
}
