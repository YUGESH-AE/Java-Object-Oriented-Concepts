package com.yugesh.multithreading_cuncurrency.completableFuture.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {

    static void main() {
        try (
                ExecutorService cpuBound= Executors.newCachedThreadPool();
                ExecutorService inBound=Executors.newFixedThreadPool(3);
                ){

            List<CompletableFuture<Void>>list=new ArrayList<>();

            for(int i=0;i<10;i++){

                CompletableFuture<Void>future= CompletableFuture.supplyAsync(OrderService::getOrder,inBound)
                        .thenApplyAsync(OrderService::enrich,cpuBound)
                        .thenApplyAsync(OrderService::performPayment,cpuBound)
                        .thenApplyAsync(OrderService::dispatch,inBound)
                        .thenAcceptAsync(OrderService::sendEmail,cpuBound);
                list.add(future);
            }

           CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
