package com.yugesh.collectionFramework.setInterface.linkedHashSet;

import java.util.*;

public class LinkedHashSet_1 {

    public static void main(String[] args) {
        // ===== ABOUT LINKEDHASHSET =====
        System.out.println("===== ABOUT LINKEDHASHSET =====");
        System.out.println("1. LinkedHashSet maintains insertion order (doubly-linked list)");
        System.out.println("2. Combines HashSet speed with LinkedList ordering");
        System.out.println("3. No duplicates allowed (like HashSet)");
        System.out.println("4. Allows one null element");
        System.out.println("5. Not synchronized (use Collections.synchronizedSet() for thread safety)");
        System.out.println("6. Performance: O(1) for add, remove, contains operations");
        System.out.println("7. Better performance than TreeSet but slower than HashSet");
        System.out.println("8. Uses HashMap with linked doubly-linked list internally\n");

        // ===== CREATING LINKEDHASHSET =====
        System.out.println("===== CREATING LINKEDHASHSET =====");
        LinkedHashSet<String> set = new LinkedHashSet<>();
        System.out.println("Empty LinkedHashSet created: " + set);

        LinkedHashSet<Integer> set2 = new LinkedHashSet<>(Arrays.asList(5, 2, 8, 1, 9));
        System.out.println("LinkedHashSet with initial elements (insertion order): " + set2);

        // ===== INSERTION ORDER PRESERVATION =====
        System.out.println("\n===== INSERTION ORDER PRESERVATION =====");
        LinkedHashSet<String> fruits = new LinkedHashSet<>();
        fruits.add("Zebra");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Orange");
        System.out.println("Added in order: Zebra, Apple, Mango, Banana, Orange");
        System.out.println("LinkedHashSet (maintains insertion order): " + fruits);

        // Compare with HashSet
        HashSet<String> hashSet = new HashSet<>(fruits);
        System.out.println("HashSet (no order guarantee): " + hashSet);

        // ===== ADDING ELEMENTS =====
        System.out.println("\n===== ADDING ELEMENTS =====");
        LinkedHashSet<String> set3 = new LinkedHashSet<>();
        set3.add("Apple");
        set3.add("Banana");
        set3.add("Orange");
        set3.add("Mango");
        System.out.println("After add: " + set3);

        boolean added = set3.add("Grape");
        System.out.println("add('Grape'): " + added + ", Set: " + set3);

        // Try adding duplicate
        boolean duplicate = set3.add("Apple");
        System.out.println("add('Apple') again: " + duplicate + ", Set: " + set3);

        // Adding null
        boolean nullAdded = set3.add(null);
        System.out.println("add(null): " + nullAdded + ", Set: " + set3);

        // ===== ADDING MULTIPLE ELEMENTS =====
        System.out.println("\n===== ADDING MULTIPLE ELEMENTS =====");
        LinkedHashSet<String> moreItems = new LinkedHashSet<>(Arrays.asList("Kiwi", "Pineapple"));
        set3.addAll(moreItems);
        System.out.println("After addAll: " + set3);

        // ===== SIZE AND EMPTY CHECK =====
        System.out.println("\n===== SIZE AND EMPTY CHECK =====");
        System.out.println("Size: " + set3.size());
        System.out.println("Is empty: " + set3.isEmpty());

        // ===== CHECKING ELEMENTS =====
        System.out.println("\n===== CHECKING ELEMENTS =====");
        System.out.println("Contains 'Apple': " + set3.contains("Apple"));
        System.out.println("Contains 'Papaya': " + set3.contains("Papaya"));
        System.out.println("Contains null: " + set3.contains(null));

        LinkedHashSet<String> checkSet = new LinkedHashSet<>(Arrays.asList("Apple", "Banana"));
        System.out.println("Contains all [Apple, Banana]: " + set3.containsAll(checkSet));

        // ===== REMOVING ELEMENTS =====
        System.out.println("\n===== REMOVING ELEMENTS =====");
        LinkedHashSet<String> removeSet = new LinkedHashSet<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println("Original set: " + removeSet);

        boolean removed = removeSet.remove("C");
        System.out.println("remove('C'): " + removed + ", Set: " + removeSet);

        boolean notRemoved = removeSet.remove("Z");
        System.out.println("remove('Z'): " + notRemoved + ", Set: " + removeSet);

        // ===== REMOVING MULTIPLE ELEMENTS =====
        System.out.println("\n===== REMOVING MULTIPLE ELEMENTS =====");
        LinkedHashSet<String> toRemove = new LinkedHashSet<>(Arrays.asList("A", "B"));
        removeSet.removeAll(toRemove);
        System.out.println("After removeAll [A, B]: " + removeSet);

        // ===== REMOVE IF =====
        System.out.println("\n===== REMOVE IF =====");
        LinkedHashSet<Integer> numbers = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Original set: " + numbers);
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After removeIf (remove evens): " + numbers);

        // ===== RETAIN ALL =====
        System.out.println("\n===== RETAIN ALL =====");
        LinkedHashSet<Integer> retainSet = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        LinkedHashSet<Integer> retain = new LinkedHashSet<>(Arrays.asList(2, 4, 6, 8));
        System.out.println("Before retainAll: " + retainSet);
        retainSet.retainAll(retain);
        System.out.println("After retainAll [2, 4, 6, 8]: " + retainSet);

        // ===== ITERATION (ORDER PRESERVED) =====
        System.out.println("\n===== ITERATION (INSERTION ORDER PRESERVED) =====");
        LinkedHashSet<String> iterSet = new LinkedHashSet<>(Arrays.asList("Z", "A", "M", "B", "O"));
        System.out.println("Original insertion: Z, A, M, B, O");

        System.out.println("Using Iterator:");
        Iterator<String> iter = iterSet.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        System.out.println("Using Enhanced for loop:");
        for (String item : iterSet) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.println("Using forEach method:");
        iterSet.forEach(System.out::print);
        System.out.println();

        // ===== STREAM OPERATIONS =====
        System.out.println("\n===== STREAM OPERATIONS =====");
        LinkedHashSet<Integer> nums = new LinkedHashSet<>(Arrays.asList(5, 2, 8, 1, 9, 3));
        System.out.println("Original (insertion order): " + nums);

        System.out.println("Stream output (maintains order):");
        nums.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("Filtered stream (> 3):");
        nums.stream().filter(n -> n > 3).forEach(System.out::print);
        System.out.println();

        System.out.println("Mapped stream (multiply by 10):");
        nums.stream().map(n -> n * 10).forEach(System.out::print);
        System.out.println();

        System.out.println("Sorted stream (disrupts insertion order):");
        nums.stream().sorted().forEach(System.out::print);
        System.out.println();

        // ===== TO ARRAY =====
        System.out.println("\n===== TO ARRAY =====");
        String[] array = iterSet.toArray(new String[0]);
        System.out.println("Converted to array (maintains order): " + Arrays.toString(array));

        // ===== EQUALS AND HASH CODE =====
        System.out.println("\n===== EQUALS AND HASH CODE =====");
        LinkedHashSet<String> lhs1 = new LinkedHashSet<>(Arrays.asList("X", "Y", "Z"));
        LinkedHashSet<String> lhs2 = new LinkedHashSet<>(Arrays.asList("Z", "Y", "X"));
        System.out.println("lhs1 (order: X, Y, Z): " + lhs1);
        System.out.println("lhs2 (order: Z, Y, X): " + lhs2);
        System.out.println("lhs1 equals lhs2: " + lhs1.equals(lhs2));
        System.out.println("(Note: Set equality ignores order, only checks elements)");
        System.out.println("lhs1 hashCode: " + lhs1.hashCode());
        System.out.println("lhs2 hashCode: " + lhs2.hashCode());

        // ===== SET OPERATIONS =====
        System.out.println("\n===== SET OPERATIONS =====");

        // Union
        LinkedHashSet<Integer> setA = new LinkedHashSet<>(Arrays.asList(1, 2, 3, 4));
        LinkedHashSet<Integer> setB = new LinkedHashSet<>(Arrays.asList(3, 4, 5, 6));
        LinkedHashSet<Integer> union = new LinkedHashSet<>(setA);
        union.addAll(setB);
        System.out.println("Set A: " + setA);
        System.out.println("Set B: " + setB);
        System.out.println("Union (A ∪ B): " + union);

        // Intersection
        LinkedHashSet<Integer> intersection = new LinkedHashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("Intersection (A ∩ B): " + intersection);

        // Difference
        LinkedHashSet<Integer> difference = new LinkedHashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("Difference (A - B): " + difference);

        // ===== CLONING =====
        System.out.println("\n===== CLONING =====");
        LinkedHashSet<String> original = new LinkedHashSet<>(Arrays.asList("First", "Second", "Third"));
        LinkedHashSet<String> cloned = (LinkedHashSet<String>) original.clone();
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);
        cloned.add("Fourth");
        System.out.println("After adding 'Fourth' to clone:");
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);

        // ===== WITH CUSTOM OBJECTS =====
        System.out.println("\n===== WITH CUSTOM OBJECTS =====");
        LinkedHashSet<Person> personSet = new LinkedHashSet<>();
        personSet.add(new Person("Alice", 25));
        personSet.add(new Person("Bob", 30));
        personSet.add(new Person("Charlie", 28));
        personSet.add(new Person("Diana", 26));
        System.out.println("Person set (maintains insertion order):");
        personSet.forEach(System.out::println);

        // ===== CLEAR =====
        System.out.println("\n===== CLEAR =====");
        LinkedHashSet<String> clearSet = new LinkedHashSet<>(Arrays.asList("P", "Q", "R"));
        System.out.println("Before clear: " + clearSet + ", Size: " + clearSet.size());
        clearSet.clear();
        System.out.println("After clear: " + clearSet + ", Size: " + clearSet.size());

        // ===== COMPARISON: LINKEDHASHSET VS HASHSET VS TREESET =====
        System.out.println("\n===== COMPARISON: LinkedHashSet vs HashSet vs TreeSet =====");
        Integer[] data = {5, 2, 8, 1, 9, 3, 7};

        HashSet<Integer> hs = new HashSet<>(Arrays.asList(data));
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>(Arrays.asList(data));
        TreeSet<Integer> ts = new TreeSet<>(Arrays.asList(data));

        System.out.println("Original insertion order: 5, 2, 8, 1, 9, 3, 7");
        System.out.println("HashSet (no order): " + hs);
        System.out.println("LinkedHashSet (insertion order): " + lhs);
        System.out.println("TreeSet (sorted order): " + ts);
    }
}

// Custom Person class
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
