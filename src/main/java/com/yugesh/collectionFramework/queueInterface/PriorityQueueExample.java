package com.yugesh.collectionFramework.queueInterface;

import java.util.PriorityQueue;

public class PriorityQueueExample {

    static void main() {
        /**
         * Elements are ordered by priority, not by insertion time
         * Does not allow null
         * Allows duplicates
         * Not thread-safe
         * Very fast for insert and remove operations
         * Default priority → natural ordering
         * Integer → smallest first
         * String → lexicographically smallest first
         */


        PriorityQueue<Integer> pqi = new PriorityQueue<>();

        pqi.offer(30);
        pqi.offer(10);
        pqi.offer(50);
        pqi.offer(20);

        System.out.println("PriorityQueue: " + pqi);

        System.out.println("Peek (head): " + pqi.peek()); // 10

        System.out.println("Poll: " + pqi.poll()); // 10 removed
        System.out.println("After poll: " + pqi);

        System.out.println("Poll: " + pqi.poll()); // 20 removed
        System.out.println("Poll: " + pqi.poll()); // 30 removed
        System.out.println("Poll: " + pqi.poll()); // 50 removed


        PriorityQueue<String> pqs = new PriorityQueue<>();

        pqs.offer("dog");
        pqs.offer("cat");
        pqs.offer("apple");
        pqs.offer("ball");

        while (!pqs.isEmpty()) {
            System.out.println(pqs.poll());
        }


    }
}
