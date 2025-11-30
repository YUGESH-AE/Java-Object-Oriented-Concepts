package com.yugesh.collectionFramework.listInterface.arrauList;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {

        // -----------------------------
        // 1. Create an ArrayList
        // -----------------------------
        ArrayList<String> list = new ArrayList<>();

        // -----------------------------
        // 2. Adding elements
        // -----------------------------
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println("Initial List: " + list);

        // add at specific index
        list.add(1, "X");     // A, X, B, C, D
        System.out.println("After adding 'X' at index 1: " + list);

        // -----------------------------
        // 3. Accessing elements
        // -----------------------------
        System.out.println("Element at index 2: " + list.get(2));

        // -----------------------------
        // 4. Updating an element
        // -----------------------------
        list.set(2, "Updated");   // replaces element at index 2
        System.out.println("After set(): " + list);

        // -----------------------------
        // 5. Removing elements
        // -----------------------------
        list.remove(3);   // remove by index
        System.out.println("After removing index 3: " + list);

        list.remove("A"); // remove by value
        System.out.println("After removing 'A': " + list);

        // -----------------------------
        // 6. Searching
        // -----------------------------
        System.out.println("Contains 'C'? " + list.contains("C"));
        System.out.println("Index of 'X': " + list.indexOf("X"));

        // -----------------------------
        // 7. Adding multiple elements
        // -----------------------------
        list.addAll(Arrays.asList("P", "Q", "R"));
        System.out.println("After addAll(): " + list);

        // -----------------------------
        // 8. Removing multiple elements
        // -----------------------------
        list.removeAll(Arrays.asList("P", "Q"));
        System.out.println("After removeAll(): " + list);

        // -----------------------------
        // 9. retainAll (keep only given elements)
        // -----------------------------
        list.retainAll(Arrays.asList("X", "R"));
        System.out.println("After retainAll(): " + list);

        // Restore original list
        list.clear();
        list.addAll(Arrays.asList("A", "B", "C", "D", "E"));

        // -----------------------------
        // 10. subList
        // -----------------------------
        List<String> sub = list.subList(1, 4); // B, C, D
        System.out.println("Sublist (1,4): " + sub);

        // -----------------------------
        // 11. Convert to array
        // -----------------------------
        String[] arr = list.toArray(new String[0]);
        System.out.println("Array: " + Arrays.toString(arr));

        // -----------------------------
        // 12. Iteration methods
        // -----------------------------

        // for-each
        System.out.print("For-each: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        // iterator
        System.out.print("Iterator: ");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // ListIterator (forward + backward)
        System.out.print("ListIterator forward: ");
        ListIterator<String> lit = list.listIterator();
        while (lit.hasNext()) {
            System.out.print(lit.next() + " ");
        }
        System.out.println();

        System.out.print("ListIterator backward: ");
        while (lit.hasPrevious()) {
            System.out.print(lit.previous() + " ");
        }
        System.out.println();

        // -----------------------------
        // 13. Size, isEmpty
        // -----------------------------
        System.out.println("Size: " + list.size());
        System.out.println("IsEmpty?: " + list.isEmpty());

        // -----------------------------
        // 14. Clear
        // -----------------------------
        list.clear();
        System.out.println("After clear(): " + list);
    }
}
