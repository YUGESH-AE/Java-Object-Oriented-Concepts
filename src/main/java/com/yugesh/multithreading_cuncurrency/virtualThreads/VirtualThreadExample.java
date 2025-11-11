package com.yugesh.multithreading_cuncurrency.virtualThreads;

public class VirtualThreadExample {

    static void main() {

        try {

            Thread virtual = Thread.ofVirtual()
                    .start(
                            () -> {
                                for (int i = 0; i < 3; i++) {
                                    System.out.println(Thread.currentThread() + ":" + i);
                                }
                            }
                    );

            virtual.join();

            System.out.println("Main thread");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
