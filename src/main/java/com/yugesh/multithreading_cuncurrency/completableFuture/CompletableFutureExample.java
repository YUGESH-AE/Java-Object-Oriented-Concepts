package com.yugesh.multithreading_cuncurrency.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    static void main() {


        try (ExecutorService executor = Executors.newCachedThreadPool()) {

            // 1️⃣ supplyAsync() → returns a value
            CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
                System.out.println("Task 1 Started");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                return 10;
            }, executor);

            // 2️⃣ runAsync() → returns void
            CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("Task 2 Completed");
            }, executor);

            // 3️⃣ thenApply() → transform the result
            CompletableFuture<Integer> task3 = task1.thenApply(n -> (n * n + 1));

            // 4️⃣ thenAccept() → consumes the result
            task3.thenAccept(result -> {
                System.out.println("The Task 3 result:" + result);
            });


            // 5️⃣ thenRun() → run something after previous task (no input/output)
            task3.thenRun(() -> System.out.println("Task 3 Completed"));


            // 6️⃣ Combine two futures
            CompletableFuture<Integer> task4 = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1200);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                return 30;
            }, executor);

            CompletableFuture<Integer> combined = task3.thenCombine(task4, Integer::sum);

            System.out.println("Combined Result: " + combined.get());

            // 7️⃣ anyOf() → returns result of the first completed task
            CompletableFuture<Object> any = CompletableFuture.anyOf(
                    task1,
                    task4
            );

            System.out.println("AnyOf result: " + any.get());

            // 8️⃣ allOf() → wait for all to finish
            CompletableFuture<Void> all = CompletableFuture.allOf(task1, task2, task3, task4);
            all.get();

            System.out.println("All tasks completed!");

            executor.shutdown();

        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }
}
