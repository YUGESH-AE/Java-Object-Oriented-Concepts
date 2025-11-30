package com.yugesh.collectionFramework.queueInterface.dequeueInterface;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedList_Queue_Deque_Stack {

    static void main() {

        // ===== QUEUE INTERFACE METHODS =====
        System.out.println("\n===== QUEUE METHODS =====");
        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("After add: " + queue);

        boolean offered = queue.offer(40);
        System.out.println("offer(40): " + offered + ", Queue: " + queue);

        System.out.println("element() (peek front, throw exception if empty): " + queue.element());
        System.out.println("peek() (peek front, return null if empty): " + queue.peek());

        Integer polled = queue.poll();
        System.out.println("poll() (remove front): " + polled + ", Queue: " + queue);

        Integer removed = queue.remove();
        System.out.println("remove() (remove front, throw exception if empty): " + removed + ", Queue: " + queue);

        // ===== DEQUE INTERFACE METHODS =====
        System.out.println("\n===== DEQUE METHODS =====");
        LinkedList<Integer> deque = new LinkedList<>();

        // Add to front and rear
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        deque.addLast(3);
        System.out.println("After addFirst/addLast: " + deque);

        deque.offerFirst(99);
        deque.offerLast(88);
        System.out.println("After offerFirst(99)/offerLast(88): " + deque);

        // Get without removing
        System.out.println("getFirst(): " + deque.getFirst());
        System.out.println("getLast(): " + deque.getLast());
        System.out.println("peekFirst(): " + deque.peekFirst());
        System.out.println("peekLast(): " + deque.peekLast());

        // Remove from front and rear
        Integer first = deque.removeFirst();
        System.out.println("removeFirst(): " + first + ", Deque: " + deque);

        Integer last = deque.removeLast();
        System.out.println("removeLast(): " + last + ", Deque: " + deque);

        Integer pollFirst = deque.pollFirst();
        System.out.println("pollFirst(): " + pollFirst + ", Deque: " + deque);

        Integer pollLast = deque.pollLast();
        System.out.println("pollLast(): " + pollLast + ", Deque: " + deque);

        // Stack operations
        System.out.println("\n===== DEQUE AS STACK =====");
        LinkedList<String> stack = new LinkedList<>();

        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("After push: " + stack);

        System.out.println("peek(): " + stack.peek());

        String popped = stack.pop();
        System.out.println("pop(): " + popped + ", Stack: " + stack);

        // ===== DEQUE ITERATION =====
        System.out.println("\n===== DEQUE ITERATION =====");
        LinkedList<String> dequeItems = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));

        System.out.println("Forward iteration:");
        for (String item : dequeItems) {
            System.out.print(item + " ");
        }
        System.out.println("\nReverse iteration:");
        Iterator<String> descIter = dequeItems.descendingIterator();
        while (descIter.hasNext()) {
            System.out.print(descIter.next() + " ");
        }
        System.out.println();

        // ===== STREAM OPERATIONS =====
        System.out.println("\n===== STREAM OPERATIONS =====");
        LinkedList<Integer> nums = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        nums.stream().forEach(System.out::print);
        System.out.println();

        nums.parallelStream().forEach(System.out::print);
        System.out.println();

        // ===== CLEAR =====
        System.out.println("\n===== CLEAR =====");
        LinkedList<String> clearList = new LinkedList<>(Arrays.asList("X", "Y", "Z"));
        clearList.clear();
        System.out.println("After clear: " + clearList + ", Size: " + clearList.size());
    }
}
