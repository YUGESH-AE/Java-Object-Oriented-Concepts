package com.yugesh.multithreading_cuncurrency.executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {

    static void main() {

        try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {
            int noOfThread = Runtime.getRuntime().availableProcessors();
            System.out.println("No of Threads in the Machine is " + noOfThread);

            for (int i = 0; i < 100; i++) {
                int id = i;
                executorService
                        .submit(() -> System.out.println("Task " + id + " -> " + Thread.currentThread().getName()));
            }
            executorService.shutdown();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
