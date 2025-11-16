package com.yugesh.collectionFramework.queueInterface.dequeueInterface;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
    public static void main(String[] args) {

        Deque<String> dq = new ArrayDeque<>();

        // ----- Queue (FIFO) operations -----
        dq.offer("A");
        dq.offer("B");
        dq.offer("C");
        System.out.println("Queue mode: " + dq); // [A, B, C]

        System.out.println("Peek: " + dq.peek()); // A
        System.out.println("Poll: " + dq.poll()); // A
        System.out.println("After poll: " + dq); // [B, C]

        // ----- Deque operations (both ends) -----
        dq.offerFirst("Start");
        dq.offerLast("End");
        System.out.println("After offerFirst/offerLast: " + dq); // [Start, B, C, End]

        dq.pollFirst();   // removes Start
        dq.pollLast();    // removes End
        System.out.println("After pollFirst/pollLast: " + dq); // [B, C]

        // ----- Stack (LIFO) operations -----
        dq.push("X");
        dq.push("Y");
        dq.push("Z");
        System.out.println("Stack mode: " + dq); // Z, Y, X, B, C

        System.out.println("Pop: " + dq.pop()); // Z
        System.out.println("After pop: " + dq);

        // Peek stack top
        System.out.println("Stack top peek: " + dq.peek());
    }
}
