package com.yugesh.multithreading_cuncurrency.dead_lock;

public class DeadLockExample {

    static void main() {
        
        try {
            
        String lock1 = "LOCK-1";
        String lock2 = "LOCK-2";

        Thread t1=new Thread(()->{
            synchronized (lock1){
                System.out.println("Thread-1: Holding lock 1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("Acquired Lock 2.");
                }
            }
        },"Thread-1");

        Thread t2=new Thread(()->{
             synchronized (lock2){
                System.out.println("Thread-2: Holding lock 1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("Acquired Lock 1.");
                }
            }
        },"Thread-2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Sucessfull both the threads acquired locks.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


       


    }

}
