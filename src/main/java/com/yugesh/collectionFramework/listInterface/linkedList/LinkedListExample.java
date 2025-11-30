package com.yugesh.collectionFramework.listInterface.linkedList;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {

        // Create LinkedList
        LinkedList<String> list = new LinkedList<>();

        // 1. Basic add (List methods)
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("Initial: " + list);

        // 2. Add at a specific index
        list.add(1, "X"); // Insert at index 1
        System.out.println("After adding at index 1: " + list);

        // 3. Access elements by index
        System.out.println("Element at index 0: " + list.get(0));
        System.out.println("Element at index 2: " + list.get(2));

        // 4. Update (set) element
        list.set(2, "Updated");
        System.out.println("After set(): " + list);

        // 5. Remove elements
        list.remove("B");       // remove by value
        list.remove(0);         // remove by index
        System.out.println("After removals: " + list);

        // 6. Search
        System.out.println("Contains 'X'? " + list.contains("X"));
        System.out.println("Index of 'Updated': " + list.indexOf("Updated"));

        // 7. Size and check empty
        System.out.println("Size: " + list.size());
        System.out.println("Is empty? " + list.isEmpty());

        // 8. Iterate using for-each
        System.out.print("For-each: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        // 9. Clear
        list.clear();
        System.out.println("After clear(): " + list);
    }
}
