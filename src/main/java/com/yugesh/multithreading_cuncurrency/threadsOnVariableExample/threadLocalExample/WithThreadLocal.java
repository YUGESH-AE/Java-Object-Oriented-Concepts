package com.yugesh.multithreading_cuncurrency.threadsOnVariableExample.threadLocalExample;

public class WithThreadLocal {

    static ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0);

    static void main() {
        try {

            Runnable task = () -> {
                counter.set(counter.get() + 1);
                System.out.println(
                        "Thread Name: " + Thread.currentThread().getName() + " Counter Value: " + counter.get());
            };

            Thread thread1 = new Thread(task, "Thread-1");
            Thread thread2 = new Thread(task, "Thread-2");
            Thread thread3 = new Thread(task, "Thread-3");

            thread1.start();
            thread2.start();
            thread3.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
