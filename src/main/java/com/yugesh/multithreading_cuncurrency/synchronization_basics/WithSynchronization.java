package com.yugesh.multithreading_cuncurrency.synchronization_basics;

public class WithSynchronization {
    int counrter = 0;

    /*
     * We can either create a lock object and pass it to the synchronized block
     * or we can pass this keyword to the synchronized block its like passing the same object as lock
     * or we can simply make the method synchronized which internally uses this as lock object
     * or we can use Reflection to get the class level lock using ClassName.class as lock object
     */

    // void incrementCounter() {
    //     synchronized (this) {
    //         counrter++;
    //     }
    // }

     synchronized void incrementCounter() {
        
            counrter++;
    }

    

    public String toString() {
        return "Final counter value :" + counrter;
    }

    static void main() {

        try {

            WithSynchronization c = new WithSynchronization();

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
}
