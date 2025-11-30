package com.yugesh.collectionFramework.queueInterface;

import java.util.*;

public class PriorityQueueExample_1 {
    public static void main(String[] args) {
        // ===== CREATING PRIORITYQUEUE =====
        System.out.println("===== CREATING PRIORITYQUEUE =====");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        System.out.println("Empty PriorityQueue created: " + pq);

        // With custom comparator (max heap)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        System.out.println("Max heap created: " + maxHeap);

        // ===== ADDING ELEMENTS =====
        System.out.println("\n===== ADDING ELEMENTS =====");
        pq.add(50);
        pq.add(10);
        pq.add(30);
        pq.add(20);
        pq.add(40);
        System.out.println("After add (min heap): " + pq);

        boolean offered = pq.offer(15);
        System.out.println("After offer(15): " + pq);
        System.out.println("offer() returned: " + offered);

        // ===== ADDING MULTIPLE ELEMENTS =====
        System.out.println("\n===== ADDING MULTIPLE ELEMENTS =====");
        PriorityQueue<Integer> morePq = new PriorityQueue<>(Arrays.asList(5, 25, 35));
        pq.addAll(morePq);
        System.out.println("After addAll: " + pq);

        // ===== EXAMINING HEAD (WITHOUT REMOVING) =====
        System.out.println("\n===== EXAMINING HEAD (WITHOUT REMOVING) =====");
        System.out.println("peek(): " + pq.peek());
        System.out.println("element(): " + pq.element());
        System.out.println("PriorityQueue unchanged: " + pq);

        // ===== REMOVING HEAD ELEMENT =====
        System.out.println("\n===== REMOVING HEAD ELEMENT =====");
        Integer polled = pq.poll();
        System.out.println("poll(): " + polled + ", Queue: " + pq);

        Integer removed = pq.remove();
        System.out.println("remove(): " + removed + ", Queue: " + pq);

        // ===== COLLECTION INTERFACE METHODS =====
        System.out.println("\n===== COLLECTION METHODS =====");
        System.out.println("Size: " + pq.size());
        System.out.println("Is empty: " + pq.isEmpty());
        System.out.println("Contains 30: " + pq.contains(30));
        System.out.println("Contains 100: " + pq.contains(100));

        PriorityQueue<Integer> checkPq = new PriorityQueue<>(Arrays.asList(10, 20));
        System.out.println("Contains all [10, 20]: " + pq.containsAll(checkPq));

        // ===== REMOVING SPECIFIC ELEMENTS =====
        System.out.println("\n===== REMOVING SPECIFIC ELEMENTS =====");
        pq.remove(25);
        System.out.println("After remove(25): " + pq);

        PriorityQueue<Integer> toRemove = new PriorityQueue<>(Arrays.asList(10, 40));
        pq.removeAll(toRemove);
        System.out.println("After removeAll [10, 40]: " + pq);

        // ===== REMOVE IF =====
        System.out.println("\n===== REMOVE IF =====");
        PriorityQueue<Integer> filterPq = new PriorityQueue<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        filterPq.removeIf(n -> n % 2 == 0);
        System.out.println("After removeIf (remove evens): " + filterPq);

        // ===== RETAIN ALL =====
        System.out.println("\n===== RETAIN ALL =====");
        PriorityQueue<Integer> retainPq = new PriorityQueue<>(Arrays.asList(1, 2, 3, 4, 5));
        PriorityQueue<Integer> retain = new PriorityQueue<>(Arrays.asList(1, 3, 5));
        retainPq.retainAll(retain);
        System.out.println("After retainAll [1, 3, 5]: " + retainPq);

        // ===== WITH STRING ELEMENTS =====
        System.out.println("\n===== WITH STRING ELEMENTS (NATURAL ORDER) =====");
        PriorityQueue<String> stringPq = new PriorityQueue<>();
        stringPq.add("Zebra");
        stringPq.add("Apple");
        stringPq.add("Mango");
        stringPq.add("Banana");
        System.out.println("After adding strings: " + stringPq);

        System.out.println("poll(): " + stringPq.poll());
        System.out.println("poll(): " + stringPq.poll());
        System.out.println("Remaining: " + stringPq);

        // ===== WITH CUSTOM COMPARATOR (REVERSE ORDER) =====
        System.out.println("\n===== MAX HEAP (REVERSE ORDER) =====");
        PriorityQueue<Integer> maxHeapPq = new PriorityQueue<>(Collections.reverseOrder());
        maxHeapPq.add(50);
        maxHeapPq.add(10);
        maxHeapPq.add(30);
        maxHeapPq.add(20);
        maxHeapPq.add(40);
        System.out.println("Max heap: " + maxHeapPq);

        System.out.println("poll(): " + maxHeapPq.poll());
        System.out.println("poll(): " + maxHeapPq.poll());
        System.out.println("Remaining: " + maxHeapPq);

        // ===== WITH CUSTOM OBJECT (USING CUSTOM COMPARATOR) =====
        System.out.println("\n===== CUSTOM OBJECT - PRIORITY BY LENGTH =====");
        PriorityQueue<String> stringByLength = new PriorityQueue<>(
                Comparator.comparingInt(String::length)
        );
        stringByLength.add("Elephant");
        stringByLength.add("Cat");
        stringByLength.add("Dog");
        stringByLength.add("Antelope");
        System.out.println("Sorted by length: " + stringByLength);

        while (!stringByLength.isEmpty()) {
            System.out.println("poll(): " + stringByLength.poll());
        }

        // ===== CUSTOM CLASS =====
        System.out.println("\n===== CUSTOM CLASS EXAMPLE =====");
        PriorityQueue<Student> studentPq = new PriorityQueue<>(
                Comparator.comparingInt(Student::getGrade)
        );
        studentPq.add(new Student("Alice", 85));
        studentPq.add(new Student("Bob", 92));
        studentPq.add(new Student("Charlie", 78));
        studentPq.add(new Student("Diana", 88));
        System.out.println("Students by grade (ascending):");

        while (!studentPq.isEmpty()) {
            Student student = studentPq.poll();
            System.out.println("  " + student);
        }

        // ===== ITERATION =====
        System.out.println("\n===== ITERATION =====");
        PriorityQueue<Integer> iterPq = new PriorityQueue<>(Arrays.asList(5, 2, 8, 1, 9));

        System.out.println("Using Iterator:");
        Iterator<Integer> iter = iterPq.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        System.out.println("Enhanced for loop:");
        for (Integer num : iterPq) {
            System.out.print(num + " ");
        }
        System.out.println();

        // ===== STREAM OPERATIONS =====
        System.out.println("\n===== STREAM OPERATIONS =====");
        PriorityQueue<Integer> streamPq = new PriorityQueue<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Stream output:");
        streamPq.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("Filtered stream (> 2):");
        streamPq.stream().filter(n -> n > 2).forEach(System.out::print);
        System.out.println();

        // ===== TO ARRAY =====
        System.out.println("\n===== TO ARRAY =====");
        PriorityQueue<Integer> arrayPq = new PriorityQueue<>(Arrays.asList(10, 20, 30, 40));
        Integer[] array = arrayPq.toArray(new Integer[0]);
        System.out.println("Converted to array: " + Arrays.toString(array));

        // ===== EQUALS AND HASH CODE =====
        System.out.println("\n===== EQUALS AND HASH CODE =====");
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Arrays.asList(1, 2, 3));
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Arrays.asList(1, 2, 3));
        System.out.println("pq1 equals pq2: " + pq1.equals(pq2));
        System.out.println("pq1 hashCode: " + pq1.hashCode());
        System.out.println("pq2 hashCode: " + pq2.hashCode());

        // ===== CLEAR =====
        System.out.println("\n===== CLEAR =====");
        PriorityQueue<Integer> clearPq = new PriorityQueue<>(Arrays.asList(10, 20, 30));
        System.out.println("Before clear: " + clearPq + ", Size: " + clearPq.size());
        clearPq.clear();
        System.out.println("After clear: " + clearPq + ", Size: " + clearPq.size());
    }
}

// Custom Student class for example
class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name + " - Grade: " + grade;
    }
}