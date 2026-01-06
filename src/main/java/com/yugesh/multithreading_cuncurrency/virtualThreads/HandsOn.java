package com.yugesh.multithreading_cuncurrency.virtualThreads;

import jdk.management.VirtualThreadSchedulerMXBean;
import lombok.SneakyThrows;

import java.lang.management.ManagementFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandsOn {
    @SneakyThrows
    static void main() {

        VirtualThreadSchedulerMXBean bean=ManagementFactory.getPlatformMXBean(VirtualThreadSchedulerMXBean.class);

        System.out.println(bean);

       Thread virtual= Thread.ofVirtual()
                .unstarted(HandsOn::task);
       virtual.start();

        System.out.println(bean);
       virtual.join();
        System.out.println(bean);




    }

    public static void task(){
        System.out.println("start task:"+Thread.currentThread());
    }
}
