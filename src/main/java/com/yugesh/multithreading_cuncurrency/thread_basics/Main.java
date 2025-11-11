package com.yugesh.multithreading_cuncurrency.thread_basics;

public class Main {
    
    static void main() {

        DaemonThread daemonThread=new DaemonThread("Daemon thread");
        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("Main thread is starting");
        UserThread userThread =new UserThread("user thread");
        userThread.start();

        System.out.println("Main thread is exiting");

        Thread thread=new Thread(new UserThread2_Runnable());
        thread.start();

       Thread lambda=new Thread(()->{
               System.out.println("Inside "+Thread.currentThread().getName());
               for(int i=0;i<5;i++){
                   System.out.println(Thread.currentThread().getName()+":"+i);
               }
       },"Lambda expression");
       lambda.start();
    }
}
