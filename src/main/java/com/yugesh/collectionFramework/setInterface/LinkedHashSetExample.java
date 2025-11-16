package com.yugesh.collectionFramework.setInterface;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {

        // 1. Create LinkedHashSet
        LinkedHashSet<String> set = new LinkedHashSet<>();

        // 2. Add elements
        set.add("A");
        set.add("B");
        set.add("C");
        set.add(null);    // allowed
        set.add("A");     // duplicate, ignored

        System.out.println("Initial LinkedHashSet: " + set);
        // Output will maintain insertion order: [A, B, C, null]

        // 3. contains()
        System.out.println("Contains 'B'? " + set.contains("B"));

        // 4. remove()
        set.remove("C");
        System.out.println("After removing C: " + set);

        // 5. size() and isEmpty()
        System.out.println("Size: " + set.size());
        System.out.println("Is empty? " + set.isEmpty());

        // 6. addAll()
        set.addAll(Arrays.asList("X", "Y", "Z"));
        System.out.println("After addAll: " + set);

        // 7. removeAll()
        set.removeAll(Arrays.asList("X", "Z"));
        System.out.println("After removeAll: " + set);

        // 8. retainAll()
        set.retainAll(Arrays.asList("A", "B"));
        System.out.println("After retainAll: " + set);

        // 9. Convert to array
        Object[] arr = set.toArray();
        System.out.println("Array: " + Arrays.toString(arr));

        // 10. Iterate using for-each
        System.out.print("For-each: ");
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();

        // 11. Iterator
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
