package com.yugesh.collectionFramework.setInterface.hashSet;

import java.util.*;

public class HashSetExample_1 {

    static void main() {
        // ===== CREATING HASHSET =====
        System.out.println("===== CREATING HASHSET =====");
        HashSet<String> set = new HashSet<>();
        System.out.println("Empty HashSet created: " + set);

        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("HashSet with initial elements: " + set2);

        // ===== ADDING ELEMENTS =====
        System.out.println("\n===== ADDING ELEMENTS =====");
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Mango");
        System.out.println("After add: " + set);

        boolean added = set.add("Grape");
        System.out.println("add('Grape'): " + added + ", Set: " + set);

        // Try adding duplicate
        boolean duplicate = set.add("Apple");
        System.out.println("add('Apple') again: " + duplicate + ", Set: " + set);

        // ===== ADDING MULTIPLE ELEMENTS =====
        System.out.println("\n===== ADDING MULTIPLE ELEMENTS =====");
        HashSet<String> moreItems = new HashSet<>(Arrays.asList("Kiwi", "Pineapple"));
        set.addAll(moreItems);
        System.out.println("After addAll: " + set);

        // ===== SIZE AND EMPTY CHECK =====
        System.out.println("\n===== SIZE AND EMPTY CHECK =====");
        System.out.println("Size: " + set.size());
        System.out.println("Is empty: " + set.isEmpty());

        // ===== CHECKING ELEMENTS =====
        System.out.println("\n===== CHECKING ELEMENTS =====");
        System.out.println("Contains 'Apple': " + set.contains("Apple"));
        System.out.println("Contains 'Papaya': " + set.contains("Papaya"));

        HashSet<String> checkSet = new HashSet<>(Arrays.asList("Apple", "Banana"));
        System.out.println("Contains all [Apple, Banana]: " + set.containsAll(checkSet));

        HashSet<String> checkSet2 = new HashSet<>(Arrays.asList("Apple", "Papaya"));
        System.out.println("Contains all [Apple, Papaya]: " + set.containsAll(checkSet2));

        // ===== REMOVING ELEMENTS =====
        System.out.println("\n===== REMOVING ELEMENTS =====");
        boolean removed = set.remove("Mango");
        System.out.println("remove('Mango'): " + removed + ", Set: " + set);

        boolean notRemoved = set.remove("Papaya");
        System.out.println("remove('Papaya'): " + notRemoved + ", Set: " + set);

        // ===== REMOVING MULTIPLE ELEMENTS =====
        System.out.println("\n===== REMOVING MULTIPLE ELEMENTS =====");
        HashSet<String> toRemove = new HashSet<>(Arrays.asList("Apple", "Banana"));
        set.removeAll(toRemove);
        System.out.println("After removeAll [Apple, Banana]: " + set);

        // ===== REMOVE IF =====
        System.out.println("\n===== REMOVE IF =====");
        HashSet<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Original set: " + numbers);
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After removeIf (remove evens): " + numbers);

        // ===== RETAIN ALL =====
        System.out.println("\n===== RETAIN ALL =====");
        HashSet<Integer> retainSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        HashSet<Integer> retain = new HashSet<>(Arrays.asList(2, 4, 6, 8));
        retainSet.retainAll(retain);
        System.out.println("After retainAll [2, 4, 6, 8]: " + retainSet);

        // ===== ITERATION =====
        System.out.println("\n===== ITERATION =====");
        HashSet<String> fruits = new HashSet<>(Arrays.asList("Apple", "Banana", "Orange", "Mango"));

        System.out.println("Using Iterator:");
        Iterator<String> iter = fruits.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        System.out.println("Using Enhanced for loop:");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        System.out.println("Using forEach method:");
        fruits.forEach(System.out::print);
        System.out.println();

        // ===== STREAM OPERATIONS =====
        System.out.println("\n===== STREAM OPERATIONS =====");
        HashSet<Integer> nums = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Stream output:");
        nums.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("Filtered stream (> 2):");
        nums.stream().filter(n -> n > 2).forEach(System.out::print);
        System.out.println();

        System.out.println("Mapped stream (multiply by 2):");
        nums.stream().map(n -> n * 2).forEach(System.out::print);
        System.out.println();

        System.out.println("Parallel stream:");
        nums.parallelStream().forEach(System.out::print);
        System.out.println();

        // ===== TO ARRAY =====
        System.out.println("\n===== TO ARRAY =====");
        String[] array = fruits.toArray(new String[0]);
        System.out.println("Converted to array: " + Arrays.toString(array));

        Object[] objArray = fruits.toArray();
        System.out.println("Converted to Object array: " + Arrays.toString(objArray));

        // ===== EQUALS AND HASH CODE =====
        System.out.println("\n===== EQUALS AND HASH CODE =====");
        HashSet<String> set_1 = new HashSet<>(Arrays.asList("X", "Y", "Z"));
        HashSet<String> set_2 = new HashSet<>(Arrays.asList("Z", "X", "Y"));
        System.out.println("set_1: " + set_1);
        System.out.println("set_2: " + set_2);
        System.out.println("set_1 equals set_2: " + set_1.equals(set_2));
        System.out.println("set_1 hashCode: " + set_1.hashCode());
        System.out.println("set_2 hashCode: " + set_2.hashCode());

        // ===== SET OPERATIONS =====
        System.out.println("\n===== SET OPERATIONS =====");

        // Union
        HashSet<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        HashSet<Integer> setB = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        HashSet<Integer> union = new HashSet<>(setA);
        union.addAll(setB);
        System.out.println("Set A: " + setA);
        System.out.println("Set B: " + setB);
        System.out.println("Union (A ∪ B): " + union);

        // Intersection
        HashSet<Integer> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        System.out.println("Intersection (A ∩ B): " + intersection);

        // Difference
        HashSet<Integer> difference = new HashSet<>(setA);
        difference.removeAll(setB);
        System.out.println("Difference (A - B): " + difference);

        // ===== CLONING =====
        System.out.println("\n===== CLONING =====");
        HashSet<String> original = new HashSet<>(Arrays.asList("A", "B", "C"));
        HashSet<String> cloned = (HashSet<String>) original.clone();
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);
        cloned.add("D");
        System.out.println("After adding 'D' to clone:");
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);

        // ===== WITH CUSTOM OBJECTS =====
        System.out.println("\n===== WITH CUSTOM OBJECTS =====");
        HashSet<Student> studentSet = new HashSet<>();
        studentSet.add(new Student("Alice", 101));
        studentSet.add(new Student("Bob", 102));
        studentSet.add(new Student("Charlie", 103));
        studentSet.add(new Student("Alice", 101)); // Duplicate
        System.out.println("Student set size (with duplicate): " + studentSet.size());
        studentSet.forEach(System.out::println);

        // ===== CLEAR =====
        System.out.println("\n===== CLEAR =====");
        HashSet<String> clearSet = new HashSet<>(Arrays.asList("P", "Q", "R"));
        System.out.println("Before clear: " + clearSet + ", Size: " + clearSet.size());
        clearSet.clear();
        System.out.println("After clear: " + clearSet + ", Size: " + clearSet.size());

        // ===== SPLITTING ITERATOR =====
        System.out.println("\n===== SPLITTING ITERATOR =====");
        HashSet<Integer> spliterSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        Spliterator<Integer> spliter = spliterSet.spliterator();
        System.out.println("Using Spliterator:");
        spliter.forEachRemaining(System.out::print);
        System.out.println();
    }
}

// Custom Student class
class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", id=" + id + '}';
    }
}