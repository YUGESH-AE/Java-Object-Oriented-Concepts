package com.yugesh.collectionFramework.setInterface.hashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {

        // 1. Create HashSet
        HashSet<String> set = new HashSet<>();

        // 2. Add elements
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("A");   // duplicate, ignored
        set.add(null);  // allowed (only one null)

        System.out.println("Initial HashSet: " + set);

        // 3. Check if element exists
        System.out.println("Contains 'B'? " + set.contains("B"));
        System.out.println("Contains 'Z'? " + set.contains("Z"));

        // 4. Remove elements
        set.remove("B");     // remove element
        System.out.println("After removing B: " + set);

        // 5. Size and emptiness
        System.out.println("Size: " + set.size());
        System.out.println("Is empty? " + set.isEmpty());

        // 6. Add multiple elements (addAll)
        set.addAll(Arrays.asList("X", "Y", "Z"));
        System.out.println("After addAll: " + set);

        // 7. Remove multiple elements (removeAll)
        set.removeAll(Arrays.asList("X", "Z"));
        System.out.println("After removeAll: " + set);

        // 8. Retain only specific elements (retainAll)
        set.retainAll(Arrays.asList("A", "C"));
        System.out.println("After retainAll: " + set);

        // 9. Convert to array
        Object[] arr = set.toArray();
        System.out.println("To array: " + Arrays.toString(arr));

        // 10. Iterate using for-each
        System.out.print("For-each: ");
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();

        // 11. Iterate using iterator
        System.out.print("Iterator: ");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 12. Clear
        set.clear();
        System.out.println("After clear(): " + set);
    }
}
