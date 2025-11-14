package com.yugesh.multithreading_cuncurrency.completableFuture;

import java.util.concurrent.*;

public class CompletableFutureExample {

    static void main(){

        try(ExecutorService executor=Executors.newCachedThreadPool()){

            // 1️⃣ supplyAsync() → returns a value
            CompletableFuture<Integer>task1= CompletableFuture.supplyAsync(()->{
                 System.out.println("Task 1 Started");
                 try {
                     Thread.sleep(1000);
                 } catch (Exception e) {
                   System.out.println(e.getMessage());
                 }
               
                return 10;
            }
            ,executor);


             // 2️⃣ runAsync() → returns void
            CompletableFuture<Void> task2= CompletableFuture.runAsync(()->{
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
                System.out.println("Task 2 Completed");
            },executor);


        }

        
    }
}
