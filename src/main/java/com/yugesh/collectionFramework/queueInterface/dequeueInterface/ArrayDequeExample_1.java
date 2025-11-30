package com.yugesh.collectionFramework.queueInterface.dequeueInterface;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;

public class ArrayDequeExample_1 {
    public static void main(String[] args) {
        // ===== CREATING ARRAYDEQUE =====
        System.out.println("===== CREATING ARRAYDEQUE =====");
        Deque<String> deque = new ArrayDeque<>();
        System.out.println("Empty deque created: " + deque);

        // ===== ADDING ELEMENTS =====
        System.out.println("\n===== ADDING ELEMENTS =====");
        deque.addFirst("Apple");
        deque.addLast("Banana");
        deque.addFirst("Mango");
        deque.addLast("Orange");
        System.out.println("After addFirst/addLast: " + deque);

        boolean offerFirst = deque.offerFirst("Grape");
        boolean offerLast = deque.offerLast("Kiwi");
        System.out.println("After offerFirst('Grape')/offerLast('Kiwi'): " + deque);
        System.out.println("offerFirst result: " + offerFirst + ", offerLast result: " + offerLast);

        // ===== REMOVING ELEMENTS =====
        System.out.println("\n===== REMOVING ELEMENTS =====");
        String removeFirst = deque.removeFirst();
        System.out.println("removeFirst(): " + removeFirst + ", Deque: " + deque);

        String removeLast = deque.removeLast();
        System.out.println("removeLast(): " + removeLast + ", Deque: " + deque);

        String pollFirst = deque.pollFirst();
        System.out.println("pollFirst(): " + pollFirst + ", Deque: " + deque);

        String pollLast = deque.pollLast();
        System.out.println("pollLast(): " + pollLast + ", Deque: " + deque);

        // ===== EXAMINING ELEMENTS (WITHOUT REMOVING) =====
        System.out.println("\n===== EXAMINING ELEMENTS =====");
        System.out.println("getFirst(): " + deque.getFirst());
        System.out.println("getLast(): " + deque.getLast());
        System.out.println("peekFirst(): " + deque.peekFirst());
        System.out.println("peekLast(): " + deque.peekLast());

        // ===== COLLECTION INTERFACE METHODS =====
        System.out.println("\n===== COLLECTION METHODS =====");
        System.out.println("Size: " + deque.size());
        System.out.println("Is empty: " + deque.isEmpty());
        System.out.println("Contains 'Apple': " + deque.contains("Apple"));
        System.out.println("Contains 'Pineapple': " + deque.contains("Pineapple"));

        Deque<String> checkDeque = new ArrayDeque<>();
        checkDeque.add("Apple");
        checkDeque.add("Banana");
        System.out.println("Contains all: " + deque.containsAll(checkDeque));

        // ===== ADDING MULTIPLE ELEMENTS =====
        System.out.println("\n===== ADDING MULTIPLE ELEMENTS =====");
        Deque<String> moreItems = new ArrayDeque<>();
        moreItems.add("Papaya");
        moreItems.add("Watermelon");
        deque.addAll(moreItems);
        System.out.println("After addAll: " + deque);

        // ===== REMOVING SPECIFIC ELEMENTS =====
        System.out.println("\n===== REMOVING SPECIFIC ELEMENTS =====");
        deque.remove("Banana");
        System.out.println("After remove('Banana'): " + deque);

        Deque<String> toRemove = new ArrayDeque<>();
        toRemove.add("Apple");
        toRemove.add("Papaya");
        deque.removeAll(toRemove);
        System.out.println("After removeAll: " + deque);

        // ===== REMOVE IF =====
        System.out.println("\n===== REMOVE IF =====");
        Deque<Integer> numbers = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After removeIf (remove evens): " + numbers);

        // ===== RETAIN ALL =====
        System.out.println("\n===== RETAIN ALL =====");
        Deque<String> items = new ArrayDeque<>(Arrays.asList("A", "B", "C", "D", "E"));
        Deque<String> retain = new ArrayDeque<>(Arrays.asList("A", "C", "E"));
        items.retainAll(retain);
        System.out.println("After retainAll: " + items);

        // ===== QUEUE INTERFACE METHODS =====
        System.out.println("\n===== QUEUE METHODS =====");
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("After add: " + queue);

        boolean offered = queue.offer(40);
        System.out.println("offer(40): " + offered + ", Queue: " + queue);

        System.out.println("element(): " + queue.element());
        System.out.println("peek(): " + queue.peek());

        Integer polled = queue.poll();
        System.out.println("poll(): " + polled + ", Queue: " + queue);

        Integer removed = queue.remove();
        System.out.println("remove(): " + removed + ", Queue: " + queue);

        // ===== STACK OPERATIONS =====
        System.out.println("\n===== STACK OPERATIONS =====");
        Deque<String> stack = new ArrayDeque<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("After push: " + stack);

        System.out.println("peek(): " + stack.peek());

        String popped = stack.pop();
        System.out.println("pop(): " + popped + ", Stack: " + stack);

        // ===== ITERATION =====
        System.out.println("\n===== ITERATION =====");
        ArrayDeque<String> iterItems = new ArrayDeque<>(Arrays.asList("A", "B", "C", "D"));

        System.out.println("Forward iteration using Iterator:");
        Iterator<String> iter = iterItems.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        System.out.println("Reverse iteration using descendingIterator:");
        Iterator<String> descIter = iterItems.descendingIterator();
        while (descIter.hasNext()) {
            System.out.print(descIter.next() + " ");
        }
        System.out.println();

        System.out.println("Enhanced for loop:");
        for (String item : iterItems) {
            System.out.print(item + " ");
        }
        System.out.println();

        // ===== STREAM OPERATIONS =====
        System.out.println("\n===== STREAM OPERATIONS =====");
        ArrayDeque<Integer> nums = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Stream output:");
        nums.stream().forEach(System.out::print);
        System.out.println();

        System.out.println("Parallel stream output:");
        nums.parallelStream().forEach(System.out::print);
        System.out.println();

        // ===== TO ARRAY =====
        System.out.println("\n===== TO ARRAY =====");
        String[] array = iterItems.toArray(new String[0]);
        System.out.println("Converted to array: " + Arrays.toString(array));

        // ===== EQUALS AND HASH CODE =====
        System.out.println("\n===== EQUALS AND HASH CODE =====");
        ArrayDeque<String> deque1 = new ArrayDeque<>(Arrays.asList("X", "Y", "Z"));
        ArrayDeque<String> deque2 = new ArrayDeque<>(Arrays.asList("X", "Y", "Z"));
        System.out.println("deque1 equals deque2: " + deque1.equals(deque2));
        System.out.println("deque1 hashCode: " + deque1.hashCode());
        System.out.println("deque2 hashCode: " + deque2.hashCode());

        // ===== CLEAR =====
        System.out.println("\n===== CLEAR =====");
        ArrayDeque<String> clearDeque = new ArrayDeque<>(Arrays.asList("P", "Q", "R"));
        System.out.println("Before clear: " + clearDeque + ", Size: " + clearDeque.size());
        clearDeque.clear();
        System.out.println("After clear: " + clearDeque + ", Size: " + clearDeque.size());
    }
}