package com.yugesh.multithreading_cuncurrency.executorService;

import com.yugesh.CPUCores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {

    static void main() {
        int noOfThread = CPUCores.getCpuCores();
        System.out.println("No of Threads in the Machine is " + noOfThread);

        try (ExecutorService executorService = Executors.newFixedThreadPool(noOfThread)) {


            for (int i = 0; i < 100; i++) {
                int id = i;
                executorService
                        .submit(() -> System.out.println("Task " + id + " -> " + Thread.currentThread().getName()));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
