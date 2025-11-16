package com.yugesh.multithreading_cuncurrency.synchronization_basics;

public class WithoutSynchronization {

    int counrter = 0;

    static void main() {

        try {

            WithoutSynchronization c = new WithoutSynchronization();

            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 1_000_000; i++) {
                    c.incrementCounter();
                }
            });
            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 1_000_000; i++) {
                    c.incrementCounter();
                }
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();

            System.out.println(c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    void incrementCounter() {
        counrter++;
    }

    public String toString() {
        return "Final counter value :" + counrter;
    }

}
