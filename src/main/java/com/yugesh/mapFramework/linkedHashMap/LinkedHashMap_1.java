package com.yugesh.mapFramework.linkedHashMap;

import java.util.*;

public class LinkedHashMap_1 {
    public static void main(String[] args) {
        // ===== ABOUT LINKEDHASHMAP =====
        System.out.println("===== ABOUT LINKEDHASHMAP =====");
        System.out.println("1. LinkedHashMap maintains insertion order of key-value pairs");
        System.out.println("2. Uses hash table with doubly-linked list internally");
        System.out.println("3. Combines HashMap speed with insertion order preservation");
        System.out.println("4. Allows one null key and multiple null values");
        System.out.println("5. Not synchronized (use Collections.synchronizedMap() for thread safety)");
        System.out.println("6. Performance: O(1) average for get, put, remove operations");
        System.out.println("7. Can be configured for access-order (LRU cache) using constructor");
        System.out.println("8. Slightly slower than HashMap due to doubly-linked list maintenance");
        System.out.println("9. Iteration order is predictable (insertion order by default)");
        System.out.println("10. Fail-fast iterator (throws ConcurrentModificationException if modified during iteration)\n");

        // ===== CREATING LINKEDHASHMAP =====
        System.out.println("===== CREATING LINKEDHASHMAP =====");
        LinkedHashMap<String, Integer> map1 = new LinkedHashMap<>();
        System.out.println("Empty LinkedHashMap created: " + map1);

        LinkedHashMap<String, String> map2 = new LinkedHashMap<>();
        map2.put("Name", "John");
        map2.put("City", "New York");
        System.out.println("LinkedHashMap with initial elements: " + map2);

        // With initial capacity
        LinkedHashMap<String, Integer> map3 = new LinkedHashMap<>(10);
        System.out.println("LinkedHashMap with initial capacity 10: " + map3);

        // Creating from another map (maintains insertion order)
        LinkedHashMap<String, Integer> map4 = new LinkedHashMap<>(map3);
        System.out.println("LinkedHashMap created from another map: " + map4);

        // Access-order LinkedHashMap (LRU Cache)
        LinkedHashMap<String, Integer> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
        System.out.println("Access-order LinkedHashMap created: " + accessOrderMap);

        // ===== INSERTION ORDER PRESERVATION =====
        System.out.println("\n===== INSERTION ORDER PRESERVATION =====");
        LinkedHashMap<String, Integer> fruits = new LinkedHashMap<>();
        fruits.put("Zebra", 100);
        fruits.put("Apple", 200);
        fruits.put("Mango", 150);
        fruits.put("Banana", 120);
        fruits.put("Orange", 180);
        System.out.println("Added in order: Zebra, Apple, Mango, Banana, Orange");
        System.out.println("LinkedHashMap (maintains insertion order): " + fruits);

        // Compare with HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Zebra", 100);
        hashMap.put("Apple", 200);
        hashMap.put("Mango", 150);
        hashMap.put("Banana", 120);
        hashMap.put("Orange", 180);
        System.out.println("HashMap (no order guarantee): " + hashMap);

        // ===== PUTTING ELEMENTS =====
        System.out.println("\n===== PUTTING ELEMENTS =====");
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
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
        LinkedHashMap<String, Integer> moreItems = new LinkedHashMap<>();
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

        LinkedHashMap<String, Integer> emptyMap = new LinkedHashMap<>();
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
        LinkedHashMap<String, Integer> removeMap = new LinkedHashMap<>();
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
        LinkedHashMap<String, Integer> removeValueMap = new LinkedHashMap<>();
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
        LinkedHashMap<String, Integer> replaceMap = new LinkedHashMap<>();
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
        LinkedHashMap<String, Integer> replaceValueMap = new LinkedHashMap<>();
        replaceValueMap.put("M", 100);
        replaceValueMap.put("N", 200);
        System.out.println("Original map: " + replaceValueMap);

        boolean replaced1 = replaceValueMap.replace("M", 100, 150);
        System.out.println("replace('M', 100, 150): " + replaced1 + ", Map: " + replaceValueMap);

        boolean replaced2 = replaceValueMap.replace("N", 99, 250);
        System.out.println("replace('N', 99, 250): " + replaced2 + ", Map: " + replaceValueMap);

        // ===== KEY SET =====
        System.out.println("\n===== KEY SET (INSERTION ORDER) =====");
        LinkedHashMap<String, Integer> keySetMap = new LinkedHashMap<>();
        keySetMap.put("One", 1);
        keySetMap.put("Two", 2);
        keySetMap.put("Three", 3);
        System.out.println("Map: " + keySetMap);

        Set<String> keySet = keySetMap.keySet();
        System.out.println("keySet() (maintains insertion order): " + keySet);

        // ===== VALUES =====
        System.out.println("\n===== VALUES (INSERTION ORDER) =====");
        Collection<Integer> values = keySetMap.values();
        System.out.println("values() (maintains insertion order): " + values);

        // ===== ENTRY SET =====
        System.out.println("\n===== ENTRY SET (INSERTION ORDER) =====");
        Set<Map.Entry<String, Integer>> entrySet = keySetMap.entrySet();
        System.out.println("entrySet() (maintains insertion order): " + entrySet);

        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println("  Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // ===== FOR EACH =====
        System.out.println("\n===== FOR EACH (INSERTION ORDER) =====");
        LinkedHashMap<String, String> forEachMap = new LinkedHashMap<>();
        forEachMap.put("Java", "Programming Language");
        forEachMap.put("Python", "Scripting Language");
        forEachMap.put("C++", "Systems Language");

        System.out.println("Using forEach with BiConsumer (maintains insertion order):");
        forEachMap.forEach((key, value) -> System.out.println("  " + key + " -> " + value));

        // ===== COMPUTE IF PRESENT =====
        System.out.println("\n===== COMPUTE IF PRESENT =====");
        LinkedHashMap<String, Integer> computeMap = new LinkedHashMap<>();
        computeMap.put("Score1", 80);
        computeMap.put("Score2", 90);
        System.out.println("Original map: " + computeMap);

        computeMap.computeIfPresent("Score1", (key, value) -> value + 10);
        System.out.println("After computeIfPresent('Score1', +10): " + computeMap);

        computeMap.computeIfPresent("Score3", (key, value) -> value + 10);
        System.out.println("After computeIfPresent('Score3', +10): " + computeMap);

        // ===== COMPUTE IF ABSENT =====
        System.out.println("\n===== COMPUTE IF ABSENT =====");
        LinkedHashMap<String, String> computeAbsentMap = new LinkedHashMap<>();
        computeAbsentMap.put("Name", "Alice");
        System.out.println("Original map: " + computeAbsentMap);

        computeAbsentMap.computeIfAbsent("City", key -> "New York");
        System.out.println("After computeIfAbsent('City', 'New York'): " + computeAbsentMap);

        computeAbsentMap.computeIfAbsent("Name", key -> "Bob");
        System.out.println("After computeIfAbsent('Name', 'Bob'): " + computeAbsentMap);

        // ===== COMPUTE =====
        System.out.println("\n===== COMPUTE =====");
        LinkedHashMap<String, Integer> computeAllMap = new LinkedHashMap<>();
        computeAllMap.put("Count1", 5);
        computeAllMap.put("Count2", 10);
        System.out.println("Original map: " + computeAllMap);

        computeAllMap.compute("Count1", (key, value) -> value == null ? 0 : value * 2);
        System.out.println("After compute('Count1', *2): " + computeAllMap);

        computeAllMap.compute("Count3", (key, value) -> value == null ? 1 : value + 1);
        System.out.println("After compute('Count3', new): " + computeAllMap);

        // ===== MERGE =====
        System.out.println("\n===== MERGE =====");
        LinkedHashMap<String, Integer> mergeMap = new LinkedHashMap<>();
        mergeMap.put("Java", 100);
        mergeMap.put("Python", 80);
        System.out.println("Original map: " + mergeMap);

        mergeMap.merge("Java", 50, Integer::sum);
        System.out.println("After merge('Java', 50, sum): " + mergeMap);

        mergeMap.merge("C++", 90, Integer::sum);
        System.out.println("After merge('C++', 90, sum): " + mergeMap);

        // ===== REPLACE ALL =====
        System.out.println("\n===== REPLACE ALL =====");
        LinkedHashMap<String, Integer> replaceAllMap = new LinkedHashMap<>();
        replaceAllMap.put("A", 10);
        replaceAllMap.put("B", 20);
        replaceAllMap.put("C", 30);
        System.out.println("Original map: " + replaceAllMap);

        replaceAllMap.replaceAll((key, value) -> value * 2);
        System.out.println("After replaceAll(*2): " + replaceAllMap);

        // ===== ITERATION (ORDER PRESERVED) =====
        System.out.println("\n===== ITERATION (INSERTION ORDER PRESERVED) =====");
        LinkedHashMap<String, Integer> iterMap = new LinkedHashMap<>();
        iterMap.put("Item3", 3);
        iterMap.put("Item1", 1);
        iterMap.put("Item2", 2);

        System.out.println("Original insertion: Item3, Item1, Item2");
        System.out.println("Using entrySet Iterator (maintains insertion order):");
        Iterator<Map.Entry<String, Integer>> iter = iterMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Using keySet Iterator (maintains insertion order):");
        for (String key : iterMap.keySet()) {
            System.out.println("  " + key + " -> " + iterMap.get(key));
        }

        // ===== ACCESS-ORDER LINKEDHASHMAP (LRU Cache) =====
        System.out.println("\n===== ACCESS-ORDER LINKEDHASHMAP (LRU Cache) =====");
        LinkedHashMap<String, Integer> lruCache = new LinkedHashMap<>(16, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 3; // Keep only 3 entries
            }
        };

        lruCache.put("A", 1);
        lruCache.put("B", 2);
        lruCache.put("C", 3);
        System.out.println("Added A, B, C: " + lruCache);

        lruCache.get("A"); // Access A
        System.out.println("After accessing 'A': " + lruCache);

        lruCache.put("D", 4); // This will remove B (least recently used)
        System.out.println("After adding D: " + lruCache);

        lruCache.get("C"); // Access C
        System.out.println("After accessing 'C': " + lruCache);

        lruCache.put("E", 5); // This will remove A (least recently used)
        System.out.println("After adding E: " + lruCache);

        // ===== CLONE =====
        System.out.println("\n===== CLONE =====");
        LinkedHashMap<String, Integer> original = new LinkedHashMap<>();
        original.put("X", 1);
        original.put("Y", 2);
        original.put("Z", 3);
        LinkedHashMap<String, Integer> cloned = (LinkedHashMap<String, Integer>) original.clone();
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);
        cloned.put("W", 4);
        System.out.println("After adding 'W' to clone:");
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);

        // ===== EQUALS AND HASH CODE =====
        System.out.println("\n===== EQUALS AND HASH CODE =====");
        LinkedHashMap<String, Integer> lhm1 = new LinkedHashMap<>();
        lhm1.put("A", 1);
        lhm1.put("B", 2);

        LinkedHashMap<String, Integer> lhm2 = new LinkedHashMap<>();
        lhm2.put("B", 2);
        lhm2.put("A", 1);

        System.out.println("lhm1 (order: A, B): " + lhm1);
        System.out.println("lhm2 (order: B, A): " + lhm2);
        System.out.println("lhm1 equals lhm2: " + lhm1.equals(lhm2));
        System.out.println("(Note: Map equality ignores insertion order, only checks key-value pairs)");
        System.out.println("lhm1 hashCode: " + lhm1.hashCode());
        System.out.println("lhm2 hashCode: " + lhm2.hashCode());

        // ===== WITH CUSTOM OBJECTS =====
        System.out.println("\n===== WITH CUSTOM OBJECTS =====");
        LinkedHashMap<Integer, Student> studentMap = new LinkedHashMap<>();
        studentMap.put(103, new Student("Charlie", 78));
        studentMap.put(101, new Student("Alice", 85));
        studentMap.put(102, new Student("Bob", 92));
        System.out.println("Student map (maintains insertion order):");
        studentMap.forEach((id, student) -> System.out.println("  " + id + " -> " + student));

        // ===== COMPARISON: HASHMAP VS LINKEDHASHMAP VS TREEMAP =====
        System.out.println("\n===== COMPARISON: HashMap vs LinkedHashMap vs TreeMap =====");
        String[] keys = {"Z", "A", "M", "B", "O"};

        HashMap<String, Integer> hm = new HashMap<>();
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        TreeMap<String, Integer> tm = new TreeMap<>();

        for (int i = 0; i < keys.length; i++) {
            hm.put(keys[i], i);
            lhm.put(keys[i], i);
            tm.put(keys[i], i);
        }

        System.out.println("Original insertion: Z, A, M, B, O");
        System.out.println("HashMap (no order): " + hm);
        System.out.println("LinkedHashMap (insertion order): " + lhm);
        System.out.println("TreeMap (sorted order): " + tm);

        // ===== CLEAR =====
        System.out.println("\n===== CLEAR =====");
        LinkedHashMap<String, Integer> clearMap = new LinkedHashMap<>();
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