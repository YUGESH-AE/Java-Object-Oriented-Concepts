package com.yugesh.multithreading_cuncurrency.completableFuture.example_2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {

    static void main() {
        try (ExecutorService service = Executors.newCachedThreadPool()) {

            CompletableFuture<Double> futurePrice = CompletableFuture
                    .supplyAsync(() -> {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        return 2000.00;
                    }, service);

            CompletableFuture<Double> discounted = futurePrice
                    .thenApplyAsync(price -> {
                        return price * 0.90;
                    }, service);

            CompletableFuture<Double> converted =
                    discounted.thenCompose(price ->
                            CompletableFuture.supplyAsync(() -> {
                                return price * 80;
                            }, service)
                    );

            CompletableFuture<Double> taxFuture = CompletableFuture
                    .supplyAsync(() -> 0.18, service);

            CompletableFuture<Double> finalPrice =
                    converted.thenCombine(taxFuture, (price, gst) -> {
                        return price + (price * gst);
                    }).exceptionally(ex -> {
                        System.out.println(ex.getMessage());
                        return -1.0;
                    });

            finalPrice.thenAccept(p -> System.out.println("Final price:" + p));
            finalPrice.thenRun(() -> System.out.println("completed"));

            CompletableFuture.allOf(futurePrice, discounted, converted, taxFuture, finalPrice)
                    .join();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
