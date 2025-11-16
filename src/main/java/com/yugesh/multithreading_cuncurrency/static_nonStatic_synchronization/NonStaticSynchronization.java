package com.yugesh.multithreading_cuncurrency.static_nonStatic_synchronization;

public class NonStaticSynchronization {

    int counter = 0;

    static void main() {

        try {

            NonStaticSynchronization obj1 = new NonStaticSynchronization();

            NonStaticSynchronization obj2 = new NonStaticSynchronization();

            Thread t1 = new Thread(() -> {
                for (int i = 0; i < 1_000_000; i++) {
                    obj1.incrementCounter();
                }
            });

            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 1_000_000; i++) {
                    obj1.incrementCounter();
                }
            });

            Thread t3 = new Thread(() -> {
                for (int i = 0; i < 1_000_000; i++) {
                    obj2.incrementCounter();
                }
            });

            t1.start();
            t2.start();
            t3.start();
            t1.join();
            t2.join();
            t3.join();

            System.out.println("Obj1 Counter Value: " + obj1);
            System.out.println("Obj2 Counter Value: " + obj2);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    synchronized void incrementCounter() {
        counter++;
    }

    public String toString() {
        return " " + counter;
    }

}
