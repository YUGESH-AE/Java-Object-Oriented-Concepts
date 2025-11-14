package com.yugesh.multithreading_cuncurrency.executorService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample {

    static void main() {

        try (ExecutorService executorService = Executors.newCachedThreadPool()) {

            Callable<Integer> sum = () -> {
                int add = 0;
                System.out.println("ThreadName " + Thread.currentThread().getName());
                for (int i = 0; i < 1_00_000; i++) {
                    add += i;
                }
                return add;
            };
            Future<Integer> future = executorService.submit(sum);
            System.out.println(future.isDone());
            System.out.println("Sum of Numbers is:" + future.get());
            System.out.println("shutting down");
            executorService.shutdown();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
