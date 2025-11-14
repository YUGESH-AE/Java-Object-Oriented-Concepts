package com.yugesh.multithreading_cuncurrency.threadsOnVariableExample.threadLocalExample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalDateExample {

    static ThreadLocal<SimpleDateFormat> dateFormatter = ThreadLocal.withInitial(
            () -> new SimpleDateFormat("yyyy-MM-dd"));

    static void main() {
        try {
            Runnable task = () -> {

                String formattedDate = dateFormatter.get().format(new Date());
                System.out.println(
                        "Thread Name:" + Thread.currentThread().getName() + " Formatted Date: " + formattedDate);
                // Clean up ThreadLocal to prevent memory leaks
                dateFormatter.remove();
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
