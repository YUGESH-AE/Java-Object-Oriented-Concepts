package com.yugesh.multithreading_cuncurrency.thread_basics;

public class ThreadJoinExample {

    static void main() {
        try {
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 1: " + i);
                }
            });

            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 25; i++) {
                    System.out.println("Thread 2: " + i);

                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("Inside the Main method Main thread");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
}
