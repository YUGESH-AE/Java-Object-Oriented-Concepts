package com.yugesh.multithreading_cuncurrency.volatile_example;


/*
 * use ctrl+c to stop the program execution
 */

public class WithVolatileExample {
    
    private static volatile boolean running = true;

    static void main() {

        try {

            System.out.println("Main thread started");
            Thread workerThread = new Thread(() -> {
                System.out.println("Worker Thread Started");
                while (running) {
                    // System.out.println("Worker Thread is running");
                }
                System.out.println("Worker Thread Stopped");

            }, "WorkerThread");

            workerThread.start();
            Thread.sleep(2000);
            System.out.println("Main Thread is changing the running state to false");
            running = false;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
