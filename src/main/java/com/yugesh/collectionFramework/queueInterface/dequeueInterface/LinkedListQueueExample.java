package com.yugesh.collectionFramework.queueInterface.dequeueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueExample {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        // Add elements (FIFO)
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        System.out.println("Initial Queue: " + queue);

        // Peek head element (does NOT remove)
        System.out.println("Peek: " + queue.peek());   // A

        // Poll elements (FIFO remove)
        System.out.println("Polled: " + queue.poll()); // A
        System.out.println("After first poll: " + queue); // [B, C]

        System.out.println("Polled: " + queue.poll()); // B
        System.out.println("Polled: " + queue.poll()); // C

        // Now queue is empty
        System.out.println("After emptying: " + queue);

        // poll() returns null when empty
        System.out.println("Poll on empty: " + queue.poll()); // null
    }
}
