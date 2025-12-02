package com.yugesh.mapFramework.treeMap;

import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {

        // Sorting keys in natural order
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(50, "Fifty");
        map.put(10, "Ten");
        map.put(30, "Thirty");
        map.put(20, "Twenty");
        map.put(40, "Forty");

        System.out.println("TreeMap: " + map);

        // Basic operations
        System.out.println("Get 30: " + map.get(30));
        map.remove(10);

        // Navigation methods
        System.out.println("firstKey(): " + map.firstKey());
        System.out.println("lastKey(): " + map.lastKey());
        System.out.println("higherKey(30): " + map.higherKey(30));
        System.out.println("lowerKey(30): " + map.lowerKey(30));
        System.out.println("ceilingKey(25): " + map.ceilingKey(25));
        System.out.println("floorKey(25): " + map.floorKey(25));

        // Range queries
        System.out.println("headMap(30): " + map.headMap(30)); // < 30
        System.out.println("tailMap(30): " + map.tailMap(30)); // >= 30
        System.out.println("subMap(20, 50): " + map.subMap(20, 50)); // 20 ≤ key < 50

        // computeIfAbsent
        map.computeIfAbsent(60, k -> "Sixty");

        // computeIfPresent
        map.computeIfPresent(20, (k, v) -> v + " Updated");

        // merge
        map.merge(40, "Extra",
                (oldVal, newVal) -> oldVal + " + " + newVal);

        // entrySet
        for (var e : map.entrySet()) {
            System.out.println(e.getKey() + " → " + e.getValue());
        }

        map.clear();
        System.out.println("After clear(): " + map);
    }
}
