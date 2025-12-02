package com.yugesh.mapFramework.hashMap;

import java.util.*;

public class HashMap_1 {

    public static void main(String[] args) {
        // ===== ABOUT HASHMAP =====
        System.out.println("===== ABOUT HASHMAP =====");
        System.out.println("1. HashMap is an unordered collection of key-value pairs");
        System.out.println("2. Uses hash table internally for fast access");
        System.out.println("3. Allows one null key and multiple null values");
        System.out.println("4. Not synchronized (use ConcurrentHashMap or Collections.synchronizedMap() for thread safety)");
        System.out.println("5. Performance: O(1) average for get, put, remove operations");
        System.out.println("6. Does not maintain insertion order (use LinkedHashMap for that)");
        System.out.println("7. Does not keep keys sorted (use TreeMap for that)");
        System.out.println("8. Allows duplicate values but not duplicate keys");
        System.out.println("9. Fail-fast iterator (throws ConcurrentModificationException if modified during iteration)");
        System.out.println("10. Default initial capacity: 16, Load factor: 0.75\n");

        // ===== CREATING HASHMAP =====
        System.out.println("===== CREATING HASHMAP =====");
        HashMap<String, Integer> map1 = new HashMap<>();
        System.out.println("Empty HashMap created: " + map1);

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("Name", "John");
        map2.put("City", "New York");
        System.out.println("HashMap with initial elements: " + map2);

        HashMap<String, Integer> map3 = new HashMap<>(10);
        System.out.println("HashMap with initial capacity 10: " + map3);

        // Creating from another map
        HashMap<String, Integer> map4 = new HashMap<>(map3);
        System.out.println("HashMap created from another map: " + map4);

        // ===== PUTTING ELEMENTS =====
        System.out.println("\n===== PUTTING ELEMENTS =====");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 100);
        map.put("Banana", 200);
        map.put("Orange", 150);
        map.put("Mango", 120);
        System.out.println("After put: " + map);

        Integer oldValue = map.put("Apple", 110);
        System.out.println("put('Apple', 110) returns old value: " + oldValue + ", Map: " + map);

        // Adding null key
        Integer nullKeyValue = map.put(null, 999);
        System.out.println("put(null, 999): " + nullKeyValue + ", Map: " + map);

        // Adding null value
        map.put("Grape", null);
        System.out.println("put('Grape', null): Map: " + map);

        // ===== PUTTING MULTIPLE ELEMENTS =====
        System.out.println("\n===== PUTTING MULTIPLE ELEMENTS =====");
        HashMap<String, Integer> moreItems = new HashMap<>();
        moreItems.put("Kiwi", 80);
        moreItems.put("Pineapple", 200);
        map.putAll(moreItems);
        System.out.println("After putAll: " + map);

        // ===== PUT IF ABSENT =====
        System.out.println("\n===== PUT IF ABSENT =====");
        Integer result1 = map.putIfAbsent("Papaya", 90);
        System.out.println("putIfAbsent('Papaya', 90) - new key: " + result1 + ", Map: " + map);

        Integer result2 = map.putIfAbsent("Apple", 500);
        System.out.println("putIfAbsent('Apple', 500) - existing key: " + result2 + ", Map: " + map);

        // ===== SIZE AND EMPTY CHECK =====
        System.out.println("\n===== SIZE AND EMPTY CHECK =====");
        System.out.println("Size: " + map.size());
        System.out.println("Is empty: " + map.isEmpty());

        HashMap<String, Integer> emptyMap = new HashMap<>();
        System.out.println("Empty map size: " + emptyMap.size() + ", Is empty: " + emptyMap.isEmpty());

        // ===== GETTING ELEMENTS =====
        System.out.println("\n===== GETTING ELEMENTS =====");
        System.out.println("get('Apple'): " + map.get("Apple"));
        System.out.println("get('Papaya'): " + map.get("Papaya"));
        System.out.println("get('NonExistent'): " + map.get("NonExistent"));
        System.out.println("get(null): " + map.get(null));

        // ===== GET OR DEFAULT =====
        System.out.println("\n===== GET OR DEFAULT =====");
        System.out.println("getOrDefault('Apple', 0): " + map.getOrDefault("Apple", 0));
        System.out.println("getOrDefault('NonExistent', -1): " + map.getOrDefault("NonExistent", -1));
        System.out.println("getOrDefault('Grape', 0): " + map.getOrDefault("Grape", 0));

        // ===== CHECKING KEYS AND VALUES =====
        System.out.println("\n===== CHECKING KEYS AND VALUES =====");
        System.out.println("Contains key 'Apple': " + map.containsKey("Apple"));
        System.out.println("Contains key 'Watermelon': " + map.containsKey("Watermelon"));
        System.out.println("Contains key null: " + map.containsKey(null));

        System.out.println("Contains value 100: " + map.containsValue(100));
        System.out.println("Contains value 999: " + map.containsValue(999));
        System.out.println("Contains value null: " + map.containsValue(null));

        // ===== REMOVING ELEMENTS =====
        System.out.println("\n===== REMOVING ELEMENTS =====");
        HashMap<String, Integer> removeMap = new HashMap<>();
        removeMap.put("A", 1);
        removeMap.put("B", 2);
        removeMap.put("C", 3);
        System.out.println("Original map: " + removeMap);

        Integer removed = removeMap.remove("B");
        System.out.println("remove('B'): " + removed + ", Map: " + removeMap);

        Integer notRemoved = removeMap.remove("Z");
        System.out.println("remove('Z'): " + notRemoved + ", Map: " + removeMap);

        // ===== REMOVE WITH VALUE CHECK =====
        System.out.println("\n===== REMOVE WITH VALUE CHECK =====");
        HashMap<String, Integer> removeValueMap = new HashMap<>();
        removeValueMap.put("X", 10);
        removeValueMap.put("Y", 20);
        removeValueMap.put("Z", 30);
        System.out.println("Original map: " + removeValueMap);

        boolean removed1 = removeValueMap.remove("X", 10);
        System.out.println("remove('X', 10): " + removed1 + ", Map: " + removeValueMap);

        boolean removed2 = removeValueMap.remove("Y", 99);
        System.out.println("remove('Y', 99): " + removed2 + ", Map: " + removeValueMap);

        // ===== REPLACE =====
        System.out.println("\n===== REPLACE =====");
        HashMap<String, Integer> replaceMap = new HashMap<>();
        replaceMap.put("P", 1);
        replaceMap.put("Q", 2);
        replaceMap.put("R", 3);
        System.out.println("Original map: " + replaceMap);

        Integer oldVal = replaceMap.replace("Q", 20);
        System.out.println("replace('Q', 20): " + oldVal + ", Map: " + replaceMap);

        Integer notReplaced = replaceMap.replace("Z", 99);
        System.out.println("replace('Z', 99): " + notReplaced + ", Map: " + replaceMap);

        // ===== REPLACE WITH VALUE CHECK =====
        System.out.println("\n===== REPLACE WITH VALUE CHECK =====");
        HashMap<String, Integer> replaceValueMap = new HashMap<>();
        replaceValueMap.put("M", 100);
        replaceValueMap.put("N", 200);
        System.out.println("Original map: " + replaceValueMap);

        boolean replaced1 = replaceValueMap.replace("M", 100, 150);
        System.out.println("replace('M', 100, 150): " + replaced1 + ", Map: " + replaceValueMap);

        boolean replaced2 = replaceValueMap.replace("N", 99, 250);
        System.out.println("replace('N', 99, 250): " + replaced2 + ", Map: " + replaceValueMap);

        // ===== KEY SET =====
        System.out.println("\n===== KEY SET =====");
        HashMap<String, Integer> keySetMap = new HashMap<>();
        keySetMap.put("One", 1);
        keySetMap.put("Two", 2);
        keySetMap.put("Three", 3);
        System.out.println("Map: " + keySetMap);

        Set<String> keySet = keySetMap.keySet();
        System.out.println("keySet(): " + keySet);

        // ===== VALUES =====
        System.out.println("\n===== VALUES =====");
        Collection<Integer> values = keySetMap.values();
        System.out.println("values(): " + values);

        // ===== ENTRY SET =====
        System.out.println("\n===== ENTRY SET =====");
        Set<Map.Entry<String, Integer>> entrySet = keySetMap.entrySet();
        System.out.println("entrySet(): " + entrySet);

        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println("  Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // ===== FOR EACH =====
        System.out.println("\n===== FOR EACH =====");
        HashMap<String, String> forEachMap = new HashMap<>();
        forEachMap.put("Java", "Programming Language");
        forEachMap.put("Python", "Scripting Language");
        forEachMap.put("C++", "Systems Language");

        System.out.println("Using forEach with BiConsumer:");
        forEachMap.forEach((key, value) -> System.out.println("  " + key + " -> " + value));

        // ===== COMPUTE IF PRESENT =====
        System.out.println("\n===== COMPUTE IF PRESENT =====");
        HashMap<String, Integer> computeMap = new HashMap<>();
        computeMap.put("Score1", 80);
        computeMap.put("Score2", 90);
        System.out.println("Original map: " + computeMap);

        computeMap.computeIfPresent("Score1", (key, value) -> value + 10);
        System.out.println("After computeIfPresent('Score1', +10): " + computeMap);

        computeMap.computeIfPresent("Score3", (key, value) -> value + 10);
        System.out.println("After computeIfPresent('Score3', +10): " + computeMap);

        // ===== COMPUTE IF ABSENT =====
        System.out.println("\n===== COMPUTE IF ABSENT =====");
        HashMap<String, String> computeAbsentMap = new HashMap<>();
        computeAbsentMap.put("Name", "Alice");
        System.out.println("Original map: " + computeAbsentMap);

        computeAbsentMap.computeIfAbsent("City", key -> "New York");
        System.out.println("After computeIfAbsent('City', 'New York'): " + computeAbsentMap);

        computeAbsentMap.computeIfAbsent("Name", key -> "Bob");
        System.out.println("After computeIfAbsent('Name', 'Bob'): " + computeAbsentMap);

        // ===== COMPUTE =====
        System.out.println("\n===== COMPUTE =====");
        HashMap<String, Integer> computeAllMap = new HashMap<>();
        computeAllMap.put("Count1", 5);
        computeAllMap.put("Count2", 10);
        System.out.println("Original map: " + computeAllMap);

        computeAllMap.compute("Count1", (key, value) -> value == null ? 0 : value * 2);
        System.out.println("After compute('Count1', *2): " + computeAllMap);

        computeAllMap.compute("Count3", (key, value) -> value == null ? 1 : value + 1);
        System.out.println("After compute('Count3', new): " + computeAllMap);

        // ===== MERGE =====
        System.out.println("\n===== MERGE =====");
        HashMap<String, Integer> mergeMap = new HashMap<>();
        mergeMap.put("Java", 100);
        mergeMap.put("Python", 80);
        System.out.println("Original map: " + mergeMap);

        mergeMap.merge("Java", 50, Integer::sum);
        System.out.println("After merge('Java', 50, sum): " + mergeMap);

        mergeMap.merge("C++", 90, Integer::sum);
        System.out.println("After merge('C++', 90, sum): " + mergeMap);

        // ===== REPLACE ALL =====
        System.out.println("\n===== REPLACE ALL =====");
        HashMap<String, Integer> replaceAllMap = new HashMap<>();
        replaceAllMap.put("A", 10);
        replaceAllMap.put("B", 20);
        replaceAllMap.put("C", 30);
        System.out.println("Original map: " + replaceAllMap);

        replaceAllMap.replaceAll((key, value) -> value * 2);
        System.out.println("After replaceAll(*2): " + replaceAllMap);

        // ===== ITERATION =====
        System.out.println("\n===== ITERATION =====");
        HashMap<String, Integer> iterMap = new HashMap<>();
        iterMap.put("Item1", 1);
        iterMap.put("Item2", 2);
        iterMap.put("Item3", 3);

        System.out.println("Using entrySet Iterator:");
        Iterator<Map.Entry<String, Integer>> iter = iterMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Using keySet Iterator:");
        for (String key : iterMap.keySet()) {
            System.out.println("  " + key + " -> " + iterMap.get(key));
        }

        System.out.println("Using values Iterator:");
        for (Integer value : iterMap.values()) {
            System.out.print(value + " ");
        }
        System.out.println();

        // ===== CLONE =====
        System.out.println("\n===== CLONE =====");
        HashMap<String, Integer> original = new HashMap<>();
        original.put("X", 1);
        original.put("Y", 2);
        HashMap<String, Integer> cloned = (HashMap<String, Integer>) original.clone();
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);
        cloned.put("Z", 3);
        System.out.println("After adding 'Z' to clone:");
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);

        // ===== EQUALS AND HASH CODE =====
        System.out.println("\n===== EQUALS AND HASH CODE =====");
        HashMap<String, Integer> map5 = new HashMap<>();
        map5.put("A", 1);
        map5.put("B", 2);

        HashMap<String, Integer> map6 = new HashMap<>();
        map6.put("B", 2);
        map6.put("A", 1);

        System.out.println("map5: " + map5);
        System.out.println("map6: " + map6);
        System.out.println("map5 equals map6: " + map5.equals(map6));
        System.out.println("map5 hashCode: " + map5.hashCode());
        System.out.println("map6 hashCode: " + map6.hashCode());

        // ===== WITH CUSTOM OBJECTS =====
        System.out.println("\n===== WITH CUSTOM OBJECTS =====");
        HashMap<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(101, new Student("Alice", 85));
        studentMap.put(102, new Student("Bob", 92));
        studentMap.put(103, new Student("Charlie", 78));
        System.out.println("Student map:");
        studentMap.forEach((id, student) -> System.out.println("  " + id + " -> " + student));

        // ===== CLEAR =====
        System.out.println("\n===== CLEAR =====");
        HashMap<String, Integer> clearMap = new HashMap<>();
        clearMap.put("P", 1);
        clearMap.put("Q", 2);
        clearMap.put("R", 3);
        System.out.println("Before clear: " + clearMap + ", Size: " + clearMap.size());
        clearMap.clear();
        System.out.println("After clear: " + clearMap + ", Size: " + clearMap.size());
    }
}

// Custom Student class
class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", score=" + score + '}';
    }
}
