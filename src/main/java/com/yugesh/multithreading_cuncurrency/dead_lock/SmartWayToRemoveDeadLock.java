package com.yugesh.multithreading_cuncurrency.dead_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SmartWayToRemoveDeadLock {

    static void main() {

        try {

            Lock lock1 = new ReentrantLock();
            Lock lock2 = new ReentrantLock();

            Thread t1 = new Thread(() -> {

                try {

                    if (lock1.tryLock()) {
                        System.out.println("Thread-1 is Holding Lock-1");
                        Thread.sleep(200);

                        if (lock2.tryLock()) {
                            System.out.println("Thread-1 Acquired Lock-2");
                            // critical section
                            lock1.unlock();
                        } else {
                            System.out.println("Thread-1: Could not acquire Lock-2 , releasing Lock-1");

                        }
                        lock1.unlock();
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }, "Thread-1");

            Thread t2 = new Thread(() -> {
                try {

                    if (lock2.tryLock()) {
                        System.out.println("Thread-2 is Holding Lock-2");
                        Thread.sleep(200);
                        if (lock1.tryLock()) {
                            System.out.println("Thread-2 Acquired Lock-1");
                            lock1.unlock();
                        } else {
                            System.out.println("Thread-2: Could not acquire Lock-1 , releasing Lock-2");
                        }
                        lock2.unlock();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }, "Thread-2");

            t1.start();
            t2.start();

            t1.join();
            t2.join();
            System.out.println("Successful both the threads acquired locks.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
