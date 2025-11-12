package com.yugesh.multithreading_cuncurrency.virtualThreads;

public class ManyVirtualThreadExample {

    static void main() {

        try {

            for (int i = 0; i < 5; i++) {

                Thread.ofVirtual().start(() -> {
                    System.out.println("Running on: " + Thread.currentThread());
                });
            }
            Thread.sleep(2000);
            System.out.println("Main Thread");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
