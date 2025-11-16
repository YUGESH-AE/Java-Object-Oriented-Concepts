package com.yugesh.collectionFramework.queueInterface;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Comparator;
import java.util.PriorityQueue;

public class priorityQueueUsingComparator {

    static void main() {

        Comparator<Person> age = (p1, p2) -> {
            if (p1.getAge() < p2.getAge()) {
                return -1;
            } else if (p1.getAge() > p2.getAge()) {
                return 1;
            } else {
                return 0;
            }
        };

        PriorityQueue<Person> pq = new PriorityQueue<>(age);
        pq.offer(new Person("yugesh", 26));
        pq.offer(new Person("Alice", 20));
        pq.offer(new Person("Bob", 35));
        pq.offer(new Person("Tomy", 19));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }

    @AllArgsConstructor
    @ToString
    @Getter
    @Setter
    static class Person {
        private String name;
        private int age;

    }
}
