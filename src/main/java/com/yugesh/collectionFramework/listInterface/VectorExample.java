package com.yugesh.collectionFramework.listInterface;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {

        // 1. Create vector
        Vector<String> vector = new Vector<>();

        // 2. Add elements
        vector.add("A");
        vector.add("B");
        vector.add("C");

        // Legacy method
        vector.addElement("D");

        System.out.println("Initial Vector: " + vector);

        // 3. Insert at index
        vector.add(1, "X");  // A, X, B, C, D
        System.out.println("After insert at index 1: " + vector);

        // 4. Access elements
        System.out.println("Element at index 2: " + vector.get(2));

        // 5. Update element
        vector.set(2, "Updated");
        System.out.println("After set(): " + vector);

        // 6. Remove elements
        vector.remove("A");           // remove by value
        vector.removeElement("C");    // legacy method
        vector.remove(2);             // remove by index

        System.out.println("After removals: " + vector);

        // 7. Search methods
        System.out.println("Contains 'X'? " + vector.contains("X"));
        System.out.println("First element: " + vector.firstElement());
        System.out.println("Last element: " + vector.lastElement());

        // 8. Capacity methods
        System.out.println("Size: " + vector.size());
        System.out.println("Capacity: " + vector.capacity());

        vector.ensureCapacity(20);
        System.out.println("After ensureCapacity(20) → capacity: " + vector.capacity());

        vector.trimToSize();
        System.out.println("After trimToSize() → capacity: " + vector.capacity());

        // 9. Iteration using Iterator
        System.out.print("Iterator: ");
        Iterator<String> it = vector.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 10. Old Enumeration iteration
        System.out.print("Enumeration: ");
        Enumeration<String> e = vector.elements();
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement() + " ");
        }
        System.out.println();

        // 11. Clear
        vector.clear();
        System.out.println("After clear(): " + vector);
    }
}
