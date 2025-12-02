package com.yugesh.mapFramework.hashMap;

import lombok.*;

import java.util.*;

public class HashMapExample {

    static void main() {

        Map<String, Student> map = new HashMap<>();

        // 1. put values
        map.put("A", new Student(121, "yugesh"));
        map.put("B", new Student(132, "sanjay"));
        map.put("C", new Student(129, "ajay"));
        map.put("D", new Student(138, "sarath"));
        map.put("E", new Student(167, "vicky"));
        map.put("F", new Student(160, "santhosh"));
        map.put("G", new Student(181, "raj"));

        System.out.println(map);

        // // 2. get()
        System.out.println("To fetch the value of Key G:" + map.get("G"));

        // 3. containsKey / containsValue
        System.out.println("Contanins key C? :" + map.containsKey("C"));
        /*
         * if we dont override equals and hash code it will consider it as a new object
         * even if we provide same value hence override and pass the value
         */
        System.out.println("Contains value raj? :" + map.containsValue(new Student(181, "raj")));

        // 4. remove()
        map.remove("C");
        System.out.println("After removing C: " + map);


        // 5. putIfAbsent()
        map.putIfAbsent("A", new Student(100, "AAA"));// Not inserted (A exists)
        map.putIfAbsent("Z", new Student(89, "ravi"));// Inserted

        // System.out.println(map);
        map.computeIfAbsent("G", v -> new Student(67, "sundar"));
        map.computeIfAbsent("H", v -> new Student(007, "harish"));

        System.out.println(map);

        // 7. computeIfPresent()
        map.computeIfPresent("G", (k, v) -> new Student(v.getId(), v.getName().toUpperCase()));
        System.out.println(map);

        //8.compute (always runs)
        map.compute("KEY", (k, v) -> v == null ? new Student(101, "Master") : v);
        System.out.println(map);

        //9 key set fetching the keys
        Set<String> keys = map.keySet();
        System.out.println(keys);

        //10 fetching the values which is of type collection
        Collection<Student> values = map.values();
        //or
        Set<Student> v = new HashSet<>(map.values());
        System.out.println(values);

        //11.fetching both keys and values
        for (Map.Entry<String, Student> m : map.entrySet()) {
            System.out.println(m);

        }

        // 12. size / isEmpty
        System.out.println("Size: " + map.size());
        System.out.println("IsEmpty: " + map.isEmpty());

        //13.clear
        map.clear();
        System.out.println("After clear(): " + map);


    }

    @AllArgsConstructor
    @ToString
    @Getter
    @Setter
    @EqualsAndHashCode
    static class Student {
        private int id;
        private String name;
    }

}
