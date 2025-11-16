package com.yugesh.collectionFramework.setInterface;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {

        TreeSet<Integer> set = new TreeSet<>();

        // 1. Add elements
        set.add(50);
        set.add(10);
        set.add(30);
        set.add(20);
        set.add(40);

        System.out.println("TreeSet: " + set);
        // Output sorted: [10, 20, 30, 40, 50]

        // 2. Basic operations
        System.out.println("Contains 20? " + set.contains(20));
        System.out.println("Size: " + set.size());

        // 3. SortedSet methods
        System.out.println("First: " + set.first());   // 10
        System.out.println("Last: " + set.last());     // 50
        System.out.println("headSet(30): " + set.headSet(30));   // < 30
        System.out.println("tailSet(30): " + set.tailSet(30));   // >= 30
        System.out.println("subSet(20, 50): " + set.subSet(20, 50)); // [20,30,40]

        // 4. NavigableSet methods
        System.out.println("Lower(30): " + set.lower(30));     // 20
        System.out.println("Floor(30): " + set.floor(30));     // 30
        System.out.println("Higher(30): " + set.higher(30));   // 40
        System.out.println("Ceiling(25): " + set.ceiling(25)); // 30

        // 5. Reverse order
        System.out.println("Descending: " + set.descendingSet());

        // 6. Polling (removes elements)
        System.out.println("pollFirst(): " + set.pollFirst()); // removes 10
        System.out.println("pollLast(): " + set.pollLast());   // removes 50
        System.out.println("After polls: " + set);

        // 7. Remove and clear
        set.remove(30);
        System.out.println("After removing 30: " + set);

        set.clear();
        System.out.println("After clear(): " + set);
    }
}
