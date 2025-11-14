package com.yugesh.multithreading_cuncurrency.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkStealingPoolExample {

    static void main() {

        try {

            ExecutorService executor = Executors.newWorkStealingPool();

            for (int i = 1; i <= 8; i++) {
                int id = i;
                executor.submit(() -> {
                    System.out.println("Task " + id + " -> " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                });
            }

            executor.shutdown(); // stop accepting new tasks
            executor.awaitTermination(5, TimeUnit.SECONDS); // wait for tasks to finish

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
