package com.yugesh.collectionFramework.setInterface.treeSet;

import java.util.*;

public class TreeSetExample_1 {

    public static void main(String[] args) {
        // ===== ABOUT TREESET =====
        System.out.println("===== ABOUT TREESET =====");
        System.out.println("1. TreeSet maintains elements in sorted (ascending) order");
        System.out.println("2. Implements NavigableSet and SortedSet interfaces");
        System.out.println("3. Uses Red-Black Tree (self-balancing BST) internally");
        System.out.println("4. No duplicates allowed (like HashSet)");
        System.out.println("5. Does NOT allow null elements (throws NullPointerException)");
        System.out.println("6. Not synchronized (use Collections.synchronizedSortedSet() for thread safety)");
        System.out.println("7. Performance: O(log n) for add, remove, contains operations");
        System.out.println("8. Slower than HashSet/LinkedHashSet but provides sorting and range queries");
        System.out.println("9. Natural ordering or custom Comparator can be used\n");

        // ===== CREATING TREESET =====
        System.out.println("===== CREATING TREESET =====");
        TreeSet<Integer> set1 = new TreeSet<>();
        System.out.println("Empty TreeSet created: " + set1);

        TreeSet<Integer> set2 = new TreeSet<>(Arrays.asList(5, 2, 8, 1, 9, 3, 7));
        System.out.println("TreeSet with elements (auto-sorted): " + set2);

        // With custom comparator (reverse order)
        TreeSet<Integer> reverseSet = new TreeSet<>(Collections.reverseOrder());
        reverseSet.addAll(Arrays.asList(5, 2, 8, 1, 9, 3, 7));
        System.out.println("TreeSet with reverse order: " + reverseSet);

        // ===== NATURAL ORDERING =====
        System.out.println("\n===== NATURAL ORDERING =====");
        TreeSet<String> fruits = new TreeSet<>();
        fruits.add("Zebra");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Orange");
        System.out.println("Added in order: Zebra, Apple, Mango, Banana, Orange");
        System.out.println("TreeSet (auto-sorted): " + fruits);

        // ===== ADDING ELEMENTS =====
        System.out.println("\n===== ADDING ELEMENTS =====");
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(10);
        treeSet.add(30);
        treeSet.add(20);
        treeSet.add(40);
        System.out.println("After add: " + treeSet);

        boolean added = treeSet.add(25);
        System.out.println("add(25): " + added + ", Set: " + treeSet);

        // Try adding duplicate
        boolean duplicate = treeSet.add(30);
        System.out.println("add(30) again: " + duplicate + ", Set: " + treeSet);

        // ===== ADDING MULTIPLE ELEMENTS =====
        System.out.println("\n===== ADDING MULTIPLE ELEMENTS =====");
        TreeSet<Integer> moreItems = new TreeSet<>(Arrays.asList(5, 15, 35));
        treeSet.addAll(moreItems);
        System.out.println("After addAll: " + treeSet);

        // ===== SIZE AND EMPTY CHECK =====
        System.out.println("\n===== SIZE AND EMPTY CHECK =====");
        System.out.println("Size: " + treeSet.size());
        System.out.println("Is empty: " + treeSet.isEmpty());

        // ===== CHECKING ELEMENTS =====
        System.out.println("\n===== CHECKING ELEMENTS =====");
        System.out.println("Contains 25: " + treeSet.contains(25));
        System.out.println("Contains 100: " + treeSet.contains(100));

        TreeSet<Integer> checkSet = new TreeSet<>(Arrays.asList(10, 20, 30));
        System.out.println("Contains all [10, 20, 30]: " + treeSet.containsAll(checkSet));

        // ===== REMOVING ELEMENTS =====
        System.out.println("\n===== REMOVING ELEMENTS =====");
        TreeSet<Integer> removeSet = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original set: " + removeSet);

        boolean removed = removeSet.remove(30);
        System.out.println("remove(30): " + removed + ", Set: " + removeSet);

        boolean notRemoved = removeSet.remove(100);
        System.out.println("remove(100): " + notRemoved + ", Set: " + removeSet);

        // ===== REMOVING MULTIPLE ELEMENTS =====
        System.out.println("\n===== REMOVING MULTIPLE ELEMENTS =====");
        TreeSet<Integer> toRemove = new TreeSet<>(Arrays.asList(10, 50));
        removeSet.removeAll(toRemove);
        System.out.println("After removeAll [10, 50]: " + removeSet);

        // ===== REMOVE IF =====
        System.out.println("\n===== REMOVE IF =====");
        TreeSet<Integer> numbers = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Original set: " + numbers);
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After removeIf (remove evens): " + numbers);

        // ===== RETAIN ALL =====
        System.out.println("\n===== RETAIN ALL =====");
        TreeSet<Integer> retainSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        TreeSet<Integer> retain = new TreeSet<>(Arrays.asList(2, 4, 6, 8));
        System.out.println("Before retainAll: " + retainSet);
        retainSet.retainAll(retain);
        System.out.println("After retainAll [2, 4, 6, 8]: " + retainSet);

        // ===== FIRST AND LAST =====
        System.out.println("\n===== FIRST AND LAST (SortedSet Methods) =====");
        TreeSet<Integer> boundSet = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("TreeSet: " + boundSet);
        System.out.println("first(): " + boundSet.first());
        System.out.println("last(): " + boundSet.last());

        // ===== SUBSETS (RANGE VIEWS) =====
        System.out.println("\n===== SUBSET (RANGE VIEWS) =====");
        TreeSet<Integer> rangeSet = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
        System.out.println("Original set: " + rangeSet);

        // subSet(fromElement, toElement) - fromInclusive, toExclusive
        SortedSet<Integer> sub1 = rangeSet.subSet(20, 60);
        System.out.println("subSet(20, 60): " + sub1);

        // subSet with boolean parameters (NavigableSet)
        NavigableSet<Integer> sub2 = rangeSet.subSet(20, true, 60, true);
        System.out.println("subSet(20, true, 60, true) [both inclusive]: " + sub2);

        // ===== HEADSET (ELEMENTS LESS THAN) =====
        System.out.println("\n===== HEADSET (ELEMENTS LESS THAN) =====");
        SortedSet<Integer> head1 = rangeSet.headSet(50);
        System.out.println("headSet(50) - elements < 50: " + head1);

        // With boolean parameter
        NavigableSet<Integer> head2 = rangeSet.headSet(50, true);
        System.out.println("headSet(50, true) - elements <= 50: " + head2);

        // ===== TAILSET (ELEMENTS GREATER THAN OR EQUAL) =====
        System.out.println("\n===== TAILSET (ELEMENTS GREATER THAN OR EQUAL) =====");
        SortedSet<Integer> tail1 = rangeSet.tailSet(40);
        System.out.println("tailSet(40) - elements >= 40: " + tail1);

        // With boolean parameter
        NavigableSet<Integer> tail2 = rangeSet.tailSet(40, false);
        System.out.println("tailSet(40, false) - elements > 40: " + tail2);

        // ===== LOWER, FLOOR, CEILING, HIGHER (NavigableSet) =====
        System.out.println("\n===== LOWER, FLOOR, CEILING, HIGHER (NavigableSet Methods) =====");
        TreeSet<Integer> navSet = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("TreeSet: " + navSet);

        System.out.println("lower(35) - greatest < 35: " + navSet.lower(35));
        System.out.println("floor(35) - greatest <= 35: " + navSet.floor(35));
        System.out.println("ceiling(35) - least >= 35: " + navSet.ceiling(35));
        System.out.println("higher(35) - least > 35: " + navSet.higher(35));

        System.out.println("lower(10) - greatest < 10: " + navSet.lower(10));
        System.out.println("higher(50) - least > 50: " + navSet.higher(50));

        // ===== POLL FIRST AND POLL LAST =====
        System.out.println("\n===== POLL FIRST AND POLL LAST =====");
        TreeSet<Integer> pollSet = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original set: " + pollSet);

        Integer first = pollSet.pollFirst();
        System.out.println("pollFirst(): " + first + ", Set: " + pollSet);

        Integer last = pollSet.pollLast();
        System.out.println("pollLast(): " + last + ", Set: " + pollSet);

        // ===== COMPARATOR =====
        System.out.println("\n===== COMPARATOR (SortedSet Method) =====");
        TreeSet<Integer> naturalSet = new TreeSet<>();
        System.out.println("Natural order comparator: " + naturalSet.comparator());

        TreeSet<Integer> reverseOrderSet = new TreeSet<>(Collections.reverseOrder());
        System.out.println("Reverse order comparator: " + reverseOrderSet.comparator());

        // ===== ITERATION (SORTED ORDER) =====
        System.out.println("\n===== ITERATION (SORTED ORDER) =====");
        TreeSet<String> iterSet = new TreeSet<>(Arrays.asList("Zebra", "Apple", "Mango", "Banana"));
        System.out.println("Original insertion: Zebra, Apple, Mango, Banana");

        System.out.println("Using Iterator (ascending):");
        Iterator<String> iter = iterSet.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        System.out.println("Using descendingIterator (descending):");
        Iterator<String> descIter = iterSet.descendingIterator();
        while (descIter.hasNext()) {
            System.out.print(descIter.next() + " ");
        }
        System.out.println();

        System.out.println("Using Enhanced for loop:");
        for (String item : iterSet) {
            System.out.print(item + " ");
        }
        System.out.println();

        // ===== DESCENDINGSET =====
        System.out.println("\n===== DESCENDINGSET (REVERSE VIEW) =====");
        TreeSet<Integer> descSet = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
        NavigableSet<Integer> reversed = descSet.descendingSet();
        System.out.println("Original set: " + descSet);
        System.out.println("Descending set: " + reversed);

        // ===== STREAM OPERATIONS =====
        System.out.println("\n===== STREAM OPERATIONS =====");
        TreeSet<Integer> streamSet = new TreeSet<>(Arrays.asList(5, 2, 8, 1, 9, 3));
        System.out.println("Original (sorted): " + streamSet);

        System.out.println("Stream output (maintains sorted order):");
        streamSet.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("Filtered stream (> 3):");
        streamSet.stream().filter(n -> n > 3).forEach(System.out::print);
        System.out.println();

        System.out.println("Mapped stream (multiply by 10):");
        streamSet.stream().map(n -> n * 10).forEach(System.out::print);
        System.out.println();

        // ===== TO ARRAY =====
        System.out.println("\n===== TO ARRAY =====");
        String[] array = iterSet.toArray(new String[0]);
        System.out.println("Converted to array (maintains order): " + Arrays.toString(array));

        // ===== EQUALS AND HASH CODE =====
        System.out.println("\n===== EQUALS AND HASH CODE =====");
        TreeSet<String> ts1 = new TreeSet<>(Arrays.asList("X", "Y", "Z"));
        TreeSet<String> ts2 = new TreeSet<>(Arrays.asList("Z", "Y", "X"));
        System.out.println("ts1 (order: X, Y, Z): " + ts1);
        System.out.println("ts2 (order: Z, Y, X): " + ts2);
        System.out.println("ts1 equals ts2: " + ts1.equals(ts2));
        System.out.println("(Note: Set equality ignores insertion/storage order, only checks elements)");
        System.out.println("ts1 hashCode: " + ts1.hashCode());
        System.out.println("ts2 hashCode: " + ts2.hashCode());

        // ===== WITH CUSTOM OBJECTS =====
        System.out.println("\n===== WITH CUSTOM OBJECTS =====");
        TreeSet<Student> studentSet = new TreeSet<>(
                Comparator.comparingInt(Student::getScore).reversed()
        );
        studentSet.add(new Student("Alice", 85));
        studentSet.add(new Student("Bob", 92));
        studentSet.add(new Student("Charlie", 78));
        studentSet.add(new Student("Diana", 88));
        System.out.println("Students sorted by score (descending):");
        studentSet.forEach(System.out::println);

        // ===== CLEAR =====
        System.out.println("\n===== CLEAR =====");
        TreeSet<Integer> clearSet = new TreeSet<>(Arrays.asList(10, 20, 30));
        System.out.println("Before clear: " + clearSet + ", Size: " + clearSet.size());
        clearSet.clear();
        System.out.println("After clear: " + clearSet + ", Size: " + clearSet.size());

        // ===== COMPARISON: HASHSET VS LINKEDHASHSET VS TREESET =====
        System.out.println("\n===== COMPARISON: HashSet vs LinkedHashSet vs TreeSet =====");
        Integer[] data = {5, 2, 8, 1, 9, 3, 7};

        HashSet<Integer> hs = new HashSet<>(Arrays.asList(data));
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>(Arrays.asList(data));
        TreeSet<Integer> ts = new TreeSet<>(Arrays.asList(data));

        System.out.println("Original insertion: 5, 2, 8, 1, 9, 3, 7");
        System.out.println("HashSet (no order): " + hs);
        System.out.println("LinkedHashSet (insertion order): " + lhs);
        System.out.println("TreeSet (sorted order): " + ts);
        System.out.println("\nPerformance: HashSet > LinkedHashSet > TreeSet");
        System.out.println("Features: TreeSet > LinkedHashSet > HashSet");
    }
}

// Custom Student class
class Student implements Comparable<Student> {
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
    public int compareTo(Student other) {
        return Integer.compare(this.score, other.score);
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
