package com.yugesh.multithreading_cuncurrency.synchronization_basics;

public class WaitNotifyExample {

    private final static Object LOCK = new Object();

    static void main() {
        try {

            Thread t1 = new Thread(() -> {
                try {
                    one();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            Thread t2 = new Thread(() -> {
                try {
                    two();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void one() throws InterruptedException {

        synchronized (LOCK) {
            System.out.println("Inside the block 1");
            LOCK.wait();
            System.out.println("Back again in method 1");
        }
    }

    public static void two() throws InterruptedException {

        synchronized (LOCK) {
            System.out.println("Inside the block 2");
            LOCK.notify();
            System.out.println("Hello from method 2 even after notifying");
        }
    }
}
