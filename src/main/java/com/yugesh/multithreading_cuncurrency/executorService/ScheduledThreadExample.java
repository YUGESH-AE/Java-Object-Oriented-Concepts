package com.yugesh.multithreading_cuncurrency.executorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadExample {

    public static void main(String[] args) {

        try {

            ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

            service.schedule(() -> System.out.println("This runs after 2 seconds"),
                    2,
                    TimeUnit.SECONDS);

            service.scheduleAtFixedRate(() -> System.out.println("Repeats every 3 seconds"),
                    1, 3, TimeUnit.SECONDS);

                    // service.shutdown();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
