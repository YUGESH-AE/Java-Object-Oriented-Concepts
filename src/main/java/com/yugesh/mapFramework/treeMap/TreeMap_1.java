package com.yugesh.mapFramework.treeMap;

import java.util.*;

public class TreeMap_1 {

    public static void main(String[] args) {
        // ===== ABOUT TREEMAP =====
        System.out.println("===== ABOUT TREEMAP =====");
        System.out.println("1. TreeMap maintains entries in sorted order of keys");
        System.out.println("2. Uses Red-Black Tree (self-balancing BST) internally");
        System.out.println("3. Implements NavigableMap and SortedMap interfaces");
        System.out.println("4. Does NOT allow null keys (throws NullPointerException)");
        System.out.println("5. Allows null values");
        System.out.println("6. Not synchronized (use Collections.synchronizedSortedMap() for thread safety)");
        System.out.println("7. Performance: O(log n) for get, put, remove operations");
        System.out.println("8. Slower than HashMap/LinkedHashMap but provides sorting and range queries");
        System.out.println("9. Natural ordering or custom Comparator can be used");
        System.out.println("10. Fail-fast iterator (throws ConcurrentModificationException if modified during iteration)\n");

        // ===== CREATING TREEMAP =====
        System.out.println("===== CREATING TREEMAP =====");
        TreeMap<String, Integer> map1 = new TreeMap<>();
        System.out.println("Empty TreeMap created: " + map1);

        // From another map
        Map<String, Integer> sourceMap = new HashMap<>();
        sourceMap.put("Z", 100);
        sourceMap.put("A", 200);
        sourceMap.put("M", 150);
        TreeMap<String, Integer> map2 = new TreeMap<>(sourceMap);
        System.out.println("TreeMap from HashMap (auto-sorted): " + map2);

        // With custom comparator (reverse order)
        TreeMap<Integer, String> reverseMap = new TreeMap<>(Collections.reverseOrder());
        System.out.println("TreeMap with reverse order created: " + reverseMap);

        // With initial capacity (not applicable to TreeMap, but can create from other TreeMap)
        TreeMap<String, Integer> map3 = new TreeMap<>(map2);
        System.out.println("TreeMap created from another TreeMap: " + map3);

        // ===== NATURAL ORDERING =====
        System.out.println("\n===== NATURAL ORDERING =====");
        TreeMap<String, Integer> fruits = new TreeMap<>();
        fruits.put("Zebra", 100);
        fruits.put("Apple", 200);
        fruits.put("Mango", 150);
        fruits.put("Banana", 120);
        fruits.put("Orange", 180);
        System.out.println("Added in order: Zebra, Apple, Mango, Banana, Orange");
        System.out.println("TreeMap (auto-sorted by key): " + fruits);

        // ===== PUTTING ELEMENTS =====
        System.out.println("\n===== PUTTING ELEMENTS =====");
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(50, "Fifty");
        map.put(10, "Ten");
        map.put(30, "Thirty");
        map.put(20, "Twenty");
        map.put(40, "Forty");
        System.out.println("After put (auto-sorted): " + map);

        String oldValue = map.put(10, "TEN");
        System.out.println("put(10, 'TEN') returns old value: " + oldValue + ", Map: " + map);

        // Adding null value (allowed)
        map.put(60, null);
        System.out.println("put(60, null): Map: " + map);

        // ===== PUTTING MULTIPLE ELEMENTS =====
        System.out.println("\n===== PUTTING MULTIPLE ELEMENTS =====");
        TreeMap<Integer, String> moreItems = new TreeMap<>();
        moreItems.put(5, "Five");
        moreItems.put(15, "Fifteen");
        moreItems.put(35, "ThirtyFive");
        map.putAll(moreItems);
        System.out.println("After putAll (maintains sorted order): " + map);

        // ===== PUT IF ABSENT =====
        System.out.println("\n===== PUT IF ABSENT =====");
        String result1 = map.putIfAbsent(25, "TwentyFive");
        System.out.println("putIfAbsent(25, 'TwentyFive') - new key: " + result1 + ", Map: " + map);

        String result2 = map.putIfAbsent(10, "TEN_NEW");
        System.out.println("putIfAbsent(10, 'TEN_NEW') - existing key: " + result2 + ", Map: " + map);

        // ===== SIZE AND EMPTY CHECK =====
        System.out.println("\n===== SIZE AND EMPTY CHECK =====");
        System.out.println("Size: " + map.size());
        System.out.println("Is empty: " + map.isEmpty());

        TreeMap<String, Integer> emptyMap = new TreeMap<>();
        System.out.println("Empty map size: " + emptyMap.size() + ", Is empty: " + emptyMap.isEmpty());

        // ===== GETTING ELEMENTS =====
        System.out.println("\n===== GETTING ELEMENTS =====");
        System.out.println("get(10): " + map.get(10));
        System.out.println("get(25): " + map.get(25));
        System.out.println("get(99): " + map.get(99));
        System.out.println("get(60): " + map.get(60));

        // ===== GET OR DEFAULT =====
        System.out.println("\n===== GET OR DEFAULT =====");
        System.out.println("getOrDefault(10, 'Zero'): " + map.getOrDefault(10, "Zero"));
        System.out.println("getOrDefault(99, 'MISSING'): " + map.getOrDefault(99, "MISSING"));
        System.out.println("getOrDefault(60, 'EMPTY'): " + map.getOrDefault(60, "EMPTY"));

        // ===== FIRST KEY AND LAST KEY =====
        System.out.println("\n===== FIRST KEY AND LAST KEY (SortedMap) =====");
        TreeMap<Integer, String> boundMap = new TreeMap<>();
        boundMap.put(10, "Ten");
        boundMap.put(20, "Twenty");
        boundMap.put(30, "Thirty");
        boundMap.put(40, "Forty");
        boundMap.put(50, "Fifty");
        System.out.println("TreeMap: " + boundMap);
        System.out.println("firstKey(): " + boundMap.firstKey());
        System.out.println("lastKey(): " + boundMap.lastKey());

        // ===== FIRST ENTRY AND LAST ENTRY =====
        System.out.println("\n===== FIRST ENTRY AND LAST ENTRY (NavigableMap) =====");
        Map.Entry<Integer, String> firstEntry = boundMap.firstEntry();
        System.out.println("firstEntry(): " + firstEntry.getKey() + " -> " + firstEntry.getValue());

        Map.Entry<Integer, String> lastEntry = boundMap.lastEntry();
        System.out.println("lastEntry(): " + lastEntry.getKey() + " -> " + lastEntry.getValue());

        // ===== CHECKING KEYS AND VALUES =====
        System.out.println("\n===== CHECKING KEYS AND VALUES =====");
        System.out.println("Contains key 10: " + boundMap.containsKey(10));
        System.out.println("Contains key 99: " + boundMap.containsKey(99));

        System.out.println("Contains value 'Thirty': " + boundMap.containsValue("Thirty"));
        System.out.println("Contains value 'Hundred': " + boundMap.containsValue("Hundred"));
        System.out.println("Contains value null: " + boundMap.containsValue(null));

        // ===== LOWER, FLOOR, CEILING, HIGHER (NavigableMap) =====
        System.out.println("\n===== LOWER, FLOOR, CEILING, HIGHER (NavigableMap) =====");
        TreeMap<Integer, String> navMap = new TreeMap<>();
        navMap.put(10, "Ten");
        navMap.put(20, "Twenty");
        navMap.put(30, "Thirty");
        navMap.put(40, "Forty");
        navMap.put(50, "Fifty");
        System.out.println("TreeMap: " + navMap);

        System.out.println("lowerKey(35): " + navMap.lowerKey(35));
        System.out.println("floorKey(35): " + navMap.floorKey(35));
        System.out.println("ceilingKey(35): " + navMap.ceilingKey(35));
        System.out.println("higherKey(35): " + navMap.higherKey(35));

        System.out.println("lowerEntry(35): " + navMap.lowerEntry(35));
        System.out.println("floorEntry(35): " + navMap.floorEntry(35));
        System.out.println("ceilingEntry(35): " + navMap.ceilingEntry(35));
        System.out.println("higherEntry(35): " + navMap.higherEntry(35));

        System.out.println("lowerKey(10): " + navMap.lowerKey(10));
        System.out.println("higherKey(50): " + navMap.higherKey(50));

        // ===== POLL FIRST AND POLL LAST =====
        System.out.println("\n===== POLL FIRST AND POLL LAST (NavigableMap) =====");
        TreeMap<Integer, String> pollMap = new TreeMap<>();
        pollMap.put(10, "Ten");
        pollMap.put(20, "Twenty");
        pollMap.put(30, "Thirty");
        pollMap.put(40, "Forty");
        pollMap.put(50, "Fifty");
        System.out.println("Original map: " + pollMap);

        Map.Entry<Integer, String> pollFirst = pollMap.pollFirstEntry();
        System.out.println("pollFirstEntry(): " + pollFirst.getKey() + " -> " + pollFirst.getValue() + ", Map: " + pollMap);

        Map.Entry<Integer, String> pollLast = pollMap.pollLastEntry();
        System.out.println("pollLastEntry(): " + pollLast.getKey() + " -> " + pollLast.getValue() + ", Map: " + pollMap);

        // ===== SUBMAP (RANGE VIEWS) =====
        System.out.println("\n===== SUBMAP (RANGE VIEWS) =====");
        TreeMap<Integer, String> rangeMap = new TreeMap<>();
        for (int i = 10; i <= 70; i += 10) {
            rangeMap.put(i, "Value" + i);
        }
        System.out.println("Original map: " + rangeMap);

        // subMap(fromKey, toKey) - fromInclusive, toExclusive
        SortedMap<Integer, String> sub1 = rangeMap.subMap(20, 60);
        System.out.println("subMap(20, 60): " + sub1);

        // subMap with boolean parameters (NavigableMap)
        NavigableMap<Integer, String> sub2 = rangeMap.subMap(20, true, 60, true);
        System.out.println("subMap(20, true, 60, true) [both inclusive]: " + sub2);

        NavigableMap<Integer, String> sub3 = rangeMap.subMap(20, false, 60, false);
        System.out.println("subMap(20, false, 60, false) [both exclusive]: " + sub3);

        // ===== HEADMAP (ELEMENTS LESS THAN) =====
        System.out.println("\n===== HEADMAP (ELEMENTS LESS THAN) =====");
        SortedMap<Integer, String> head1 = rangeMap.headMap(50);
        System.out.println("headMap(50) - keys < 50: " + head1);

        // With boolean parameter
        NavigableMap<Integer, String> head2 = rangeMap.headMap(50, true);
        System.out.println("headMap(50, true) - keys <= 50: " + head2);

        // ===== TAILMAP (ELEMENTS GREATER THAN OR EQUAL) =====
        System.out.println("\n===== TAILMAP (ELEMENTS GREATER THAN OR EQUAL) =====");
        SortedMap<Integer, String> tail1 = rangeMap.tailMap(40);
        System.out.println("tailMap(40) - keys >= 40: " + tail1);

        // With boolean parameter
        NavigableMap<Integer, String> tail2 = rangeMap.tailMap(40, false);
        System.out.println("tailMap(40, false) - keys > 40: " + tail2);

        // ===== COMPARATOR =====
        System.out.println("\n===== COMPARATOR (SortedMap) =====");
        TreeMap<Integer, String> naturalMap = new TreeMap<>();
        System.out.println("Natural order comparator: " + naturalMap.comparator());

        TreeMap<Integer, String> reverseOrderMap = new TreeMap<>(Collections.reverseOrder());
        System.out.println("Reverse order comparator: " + reverseOrderMap.comparator());

        // ===== DESCENDING MAP =====
        System.out.println("\n===== DESCENDING MAP (NavigableMap) =====");
        TreeMap<Integer, String> descMap = new TreeMap<>();
        descMap.put(10, "Ten");
        descMap.put(20, "Twenty");
        descMap.put(30, "Thirty");
        descMap.put(40, "Forty");
        System.out.println("Original map: " + descMap);

        NavigableMap<Integer, String> reversed = descMap.descendingMap();
        System.out.println("Descending map: " + reversed);

        // ===== DESCENDING KEY SET =====
        System.out.println("\n===== DESCENDING KEY SET (NavigableMap) =====");
        NavigableSet<Integer> descKeySet = descMap.descendingKeySet();
        System.out.println("Descending key set: " + descKeySet);

        // ===== REMOVING ELEMENTS =====
        System.out.println("\n===== REMOVING ELEMENTS =====");
        TreeMap<Integer, String> removeMap = new TreeMap<>();
        removeMap.put(1, "One");
        removeMap.put(2, "Two");
        removeMap.put(3, "Three");
        removeMap.put(4, "Four");
        System.out.println("Original map: " + removeMap);

        String removed = removeMap.remove(2);
        System.out.println("remove(2): " + removed + ", Map: " + removeMap);

        String notRemoved = removeMap.remove(99);
        System.out.println("remove(99): " + notRemoved + ", Map: " + removeMap);

        // ===== REMOVE WITH VALUE CHECK =====
        System.out.println("\n===== REMOVE WITH VALUE CHECK =====");
        TreeMap<Integer, String> removeValueMap = new TreeMap<>();
        removeValueMap.put(1, "One");
        removeValueMap.put(2, "Two");
        removeValueMap.put(3, "Three");
        System.out.println("Original map: " + removeValueMap);

        boolean removed1 = removeValueMap.remove(1, "One");
        System.out.println("remove(1, 'One'): " + removed1 + ", Map: " + removeValueMap);

        boolean removed2 = removeValueMap.remove(3, "WRONG");
        System.out.println("remove(3, 'WRONG'): " + removed2 + ", Map: " + removeValueMap);

        // ===== REPLACE =====
        System.out.println("\n===== REPLACE =====");
        TreeMap<Integer, String> replaceMap = new TreeMap<>();
        replaceMap.put(1, "One");
        replaceMap.put(2, "Two");
        replaceMap.put(3, "Three");
        System.out.println("Original map: " + replaceMap);

        String oldVal = replaceMap.replace(2, "TWO");
        System.out.println("replace(2, 'TWO'): " + oldVal + ", Map: " + replaceMap);

        String notReplaced = replaceMap.replace(99, "NinetyNine");
        System.out.println("replace(99, 'NinetyNine'): " + notReplaced + ", Map: " + replaceMap);

        // ===== REPLACE WITH VALUE CHECK =====
        System.out.println("\n===== REPLACE WITH VALUE CHECK =====");
        TreeMap<Integer, String> replaceValueMap = new TreeMap<>();
        replaceValueMap.put(1, "One");
        replaceValueMap.put(2, "Two");
        System.out.println("Original map: " + replaceValueMap);

        boolean replaced1 = replaceValueMap.replace(1, "One", "ONE");
        System.out.println("replace(1, 'One', 'ONE'): " + replaced1 + ", Map: " + replaceValueMap);

        boolean replaced2 = replaceValueMap.replace(2, "WRONG", "TWO");
        System.out.println("replace(2, 'WRONG', 'TWO'): " + replaced2 + ", Map: " + replaceValueMap);

        // ===== KEY SET =====
        System.out.println("\n===== KEY SET (SORTED ORDER) =====");
        TreeMap<String, Integer> keySetMap = new TreeMap<>();
        keySetMap.put("Zebra", 1);
        keySetMap.put("Apple", 2);
        keySetMap.put("Mango", 3);
        System.out.println("Map: " + keySetMap);

        Set<String> keySet = keySetMap.keySet();
        System.out.println("keySet() (sorted): " + keySet);

        NavigableSet<String> navKeySet = keySetMap.navigableKeySet();
        System.out.println("navigableKeySet(): " + navKeySet);

        // ===== VALUES =====
        System.out.println("\n===== VALUES (SORTED ORDER) =====");
        Collection<Integer> values = keySetMap.values();
        System.out.println("values() (sorted by key): " + values);

        // ===== ENTRY SET =====
        System.out.println("\n===== ENTRY SET (SORTED ORDER) =====");
        Set<Map.Entry<String, Integer>> entrySet = keySetMap.entrySet();
        System.out.println("entrySet() (sorted): " + entrySet);

        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println("  Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // ===== FOR EACH =====
        System.out.println("\n===== FOR EACH (SORTED ORDER) =====");
        TreeMap<String, String> forEachMap = new TreeMap<>();
        forEachMap.put("Zebra", "Animal");
        forEachMap.put("Apple", "Fruit");
        forEachMap.put("Car", "Vehicle");

        System.out.println("Using forEach with BiConsumer (maintains sorted order):");
        forEachMap.forEach((key, value) -> System.out.println("  " + key + " -> " + value));

        // ===== COMPUTE IF PRESENT =====
        System.out.println("\n===== COMPUTE IF PRESENT =====");
        TreeMap<String, Integer> computeMap = new TreeMap<>();
        computeMap.put("Score1", 80);
        computeMap.put("Score2", 90);
        System.out.println("Original map: " + computeMap);

        computeMap.computeIfPresent("Score1", (key, value) -> value + 10);
        System.out.println("After computeIfPresent('Score1', +10): " + computeMap);

        computeMap.computeIfPresent("Score3", (key, value) -> value + 10);
        System.out.println("After computeIfPresent('Score3', +10): " + computeMap);

        // ===== COMPUTE IF ABSENT =====
        System.out.println("\n===== COMPUTE IF ABSENT =====");
        TreeMap<String, String> computeAbsentMap = new TreeMap<>();
        computeAbsentMap.put("Name", "Alice");
        System.out.println("Original map: " + computeAbsentMap);

        computeAbsentMap.computeIfAbsent("City", key -> "New York");
        System.out.println("After computeIfAbsent('City', 'New York'): " + computeAbsentMap);

        computeAbsentMap.computeIfAbsent("Name", key -> "Bob");
        System.out.println("After computeIfAbsent('Name', 'Bob'): " + computeAbsentMap);

        // ===== COMPUTE =====
        System.out.println("\n===== COMPUTE =====");
        TreeMap<String, Integer> computeAllMap = new TreeMap<>();
        computeAllMap.put("Count1", 5);
        computeAllMap.put("Count2", 10);
        System.out.println("Original map: " + computeAllMap);

        computeAllMap.compute("Count1", (key, value) -> value == null ? 0 : value * 2);
        System.out.println("After compute('Count1', *2): " + computeAllMap);

        computeAllMap.compute("Count3", (key, value) -> value == null ? 1 : value + 1);
        System.out.println("After compute('Count3', new): " + computeAllMap);

        // ===== MERGE =====
        System.out.println("\n===== MERGE =====");
        TreeMap<String, Integer> mergeMap = new TreeMap<>();
        mergeMap.put("Java", 100);
        mergeMap.put("Python", 80);
        System.out.println("Original map: " + mergeMap);

        mergeMap.merge("Java", 50, Integer::sum);
        System.out.println("After merge('Java', 50, sum): " + mergeMap);

        mergeMap.merge("C++", 90, Integer::sum);
        System.out.println("After merge('C++', 90, sum): " + mergeMap);

        // ===== REPLACE ALL =====
        System.out.println("\n===== REPLACE ALL =====");
        TreeMap<String, Integer> replaceAllMap = new TreeMap<>();
        replaceAllMap.put("A", 10);
        replaceAllMap.put("B", 20);
        replaceAllMap.put("C", 30);
        System.out.println("Original map: " + replaceAllMap);

        replaceAllMap.replaceAll((key, value) -> value * 2);
        System.out.println("After replaceAll(*2): " + replaceAllMap);

        // ===== ITERATION (SORTED ORDER) =====
        System.out.println("\n===== ITERATION (SORTED ORDER) =====");
        TreeMap<String, Integer> iterMap = new TreeMap<>();
        iterMap.put("Item3", 3);
        iterMap.put("Item1", 1);
        iterMap.put("Item2", 2);

        System.out.println("Original insertion: Item3, Item1, Item2");
        System.out.println("Using entrySet Iterator (maintains sorted order):");
        Iterator<Map.Entry<String, Integer>> iter = iterMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("Using keySet Iterator (maintains sorted order):");
        for (String key : iterMap.keySet()) {
            System.out.println("  " + key + " -> " + iterMap.get(key));
        }

        // ===== CLONE =====
        System.out.println("\n===== CLONE =====");
        TreeMap<String, Integer> original = new TreeMap<>();
        original.put("Z", 1);
        original.put("A", 2);
        original.put("M", 3);
        TreeMap<String, Integer> cloned = (TreeMap<String, Integer>) original.clone();
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);
        cloned.put("B", 4);
        System.out.println("After adding 'B' to clone:");
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);

        // ===== EQUALS AND HASH CODE =====
        System.out.println("\n===== EQUALS AND HASH CODE =====");
        TreeMap<String, Integer> tm1 = new TreeMap<>();
        tm1.put("A", 1);
        tm1.put("B", 2);

        TreeMap<String, Integer> tm2 = new TreeMap<>();
        tm2.put("B", 2);
        tm2.put("A", 1);

        System.out.println("tm1 (insertion: A, B): " + tm1);
        System.out.println("tm2 (insertion: B, A): " + tm2);
        System.out.println("tm1 equals tm2: " + tm1.equals(tm2));
        System.out.println("(Note: Map equality ignores insertion order, only checks key-value pairs)");
        System.out.println("tm1 hashCode: " + tm1.hashCode());
        System.out.println("tm2 hashCode: " + tm2.hashCode());

        // ===== WITH CUSTOM OBJECTS =====
        System.out.println("\n===== WITH CUSTOM OBJECTS =====");
        TreeMap<Integer, Student> studentMap = new TreeMap<>();
        studentMap.put(103, new Student("Charlie", 78));
        studentMap.put(101, new Student("Alice", 85));
        studentMap.put(102, new Student("Bob", 92));
        System.out.println("Student map (sorted by ID):");
        studentMap.forEach((id, student) -> System.out.println("  " + id + " -> " + student));

        // ===== CUSTOM COMPARATOR =====
        System.out.println("\n===== CUSTOM COMPARATOR (REVERSE ORDER) =====");
        TreeMap<Integer, String> customComparatorMap = new TreeMap<>(Collections.reverseOrder());
        customComparatorMap.put(50, "Fifty");
        customComparatorMap.put(10, "Ten");
        customComparatorMap.put(30, "Thirty");
        customComparatorMap.put(20, "Twenty");
        customComparatorMap.put(40, "Forty");
        System.out.println("TreeMap with reverse order comparator: " + customComparatorMap);
        System.out.println("firstKey(): " + customComparatorMap.firstKey());
        System.out.println("lastKey(): " + customComparatorMap.lastKey());

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
        System.out.println("\nPerformance: HashMap > LinkedHashMap > TreeMap");
        System.out.println("Features: TreeMap > LinkedHashMap > HashMap");

        // ===== CLEAR =====
        System.out.println("\n===== CLEAR =====");
        TreeMap<String, Integer> clearMap = new TreeMap<>();
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
