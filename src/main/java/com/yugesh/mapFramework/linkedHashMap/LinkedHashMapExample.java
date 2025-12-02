package com.yugesh.mapFramework.linkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {

        Map<Integer, String> map = new LinkedHashMap<>();

        // maintains insertion order
        map.put(3, "Three");
        map.put(1, "One");
        map.put(2, "Two");

        System.out.println("Initial: " + map); // {3=Three, 1=One, 2=Two}

        // get
        System.out.println("Get 1: " + map.get(1));

        // remove
        map.remove(2);

        // putIfAbsent
        map.putIfAbsent(2, "New Two");

        // computeIfAbsent
        map.computeIfAbsent(4, k -> "Four");

        // computeIfPresent
        map.computeIfPresent(1, (k, v) -> v + " Updated");

        // compute
        map.compute(5, (k, v) -> "Value Five");

        // merge
        map.merge(3, "MergedValue",
                (oldVal, newVal) -> oldVal + " + " + newVal);

        // entrySet
        for (var e : map.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }

        System.out.println("Keys: " + map.keySet());
        System.out.println("Values: " + map.values());
        System.out.println("Size: " + map.size());

        map.clear();
        System.out.println("After clear: " + map);
    }
}
