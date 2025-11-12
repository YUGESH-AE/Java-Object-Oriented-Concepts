package com.yugesh.multithreading_cuncurrency.thread_transition_states;

public class ThreadTransitionDemo {

    static void main() {

        try {

            Object lock = new Object();

            Thread t1 = new Thread(() -> {
                synchronized (lock) {
                    try {
                        System.out.println("Thread t1 is in RUNNABLE state.");
                        System.out.println("Thread t1 is going to WAITING state by calling wait() method.");
                        lock.wait();
                        System.out.println("Thread t1 is back to RUNNABLE state after being notified.");
                        System.out.println("Thread: Got the signal!");
                        Thread.sleep(1000); // TIMED_WAITING
                        System.out.println("Thread: Done!");
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            });

            t1.start();

            Thread.sleep(2000);

            synchronized (lock) {
                System.out.println("ThreadLambda: Sending signal...");
                lock.notify(); // wakes up worker
            }

            t1.join(); // main waits for worker to finish
            System.out.println("ThreadLambda: All done!"); // TERMINATED
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
