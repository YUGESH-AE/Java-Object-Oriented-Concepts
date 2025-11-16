package com.yugesh.multithreading_cuncurrency.synchronization_basics;

public class WithSynchronizationSameLockObject {

    //same lock object for both threads
    final Object lock = new Object();
    int counrter = 0;

    static void main() {

        try {

            WithSynchronizationSameLockObject c = new WithSynchronizationSameLockObject();

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
        synchronized (lock) {
            counrter++;
        }
    }

    public String toString() {
        return "Final counter value :" + counrter;
    }


}
